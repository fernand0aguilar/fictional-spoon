package aeb.gov.br.views;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import aeb.gov.br.files.AebRhAbstractPdfView;
import aeb.gov.br.model.leave.Leave;
import aeb.gov.br.model.personal.Employee;
import aeb.gov.br.service.leave.LeaveService;
import aeb.gov.br.service.personal.EmployeeService;

@Component
public class PerVacationsPDFView extends AebRhAbstractPdfView {

	private Long bossId;
	private Employee boss;
	private EmployeeService eSrvc;
	private LeaveService lSrvc;
	private ArrayList<EmployeesVacation> vacations;
	private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	private class EmployeesVacation implements Comparable<EmployeesVacation>{
		public Employee employee;
		public Leave vacation;

		public EmployeesVacation(Employee employee, Leave vacation) {
			this.employee = employee;
			this.vacation = vacation;
		}
		
		@Override
		public int compareTo(EmployeesVacation e){
			if (vacation.getDate() == null || e.vacation.getDate() == null) return 0;
			return vacation.getDate().getTime().compareTo(e.vacation.getDate().getTime());
		}
	}

	@Override
	public void content(Document document) throws DocumentException {
		getEmployeesVacation();
		if (!vacations.isEmpty()) {
			insertEmployeesOnVacation(document);
			insertEmployeesUpcomingVacation(document);
		} else {
			insertNoVacationsFound(document);
		}
	}

	private void insertNoVacationsFound(Document document) throws DocumentException {
		document.add(Chunk.NEWLINE);
		Paragraph title = new Paragraph("Nenhum funcionário de férias ou com férias marcadas",
				super.getFONT(Font.BOLD));
		document.add(title);
	}

	private void getEmployeesVacation() {
		GregorianCalendar today = (GregorianCalendar) GregorianCalendar.getInstance();
		boss = eSrvc.searchEmployee(bossId);
		ArrayList<Employee> emps = eSrvc.getEmployeeByBoss(boss);
		ArrayList<Leave> vacs = lSrvc.getAllVacation();
		vacations = new ArrayList<PerVacationsPDFView.EmployeesVacation>();
		if (emps != null && vacs != null) {
			for (Employee e : emps) {
				for (Leave v : vacs) {
					if (v.getEmployee().getId() == e.getId()) {
						if (v.getEndDate() != null ? v.getEndDate().after(today) : false) {
							EmployeesVacation ev = new EmployeesVacation(e, v);
							vacations.add(ev);
						}
					}
				}
			}
		}
		
		Collections.sort(vacations);

	}

	private void insertEmployeesOnVacation(Document document) throws DocumentException {
		GregorianCalendar today = (GregorianCalendar) GregorianCalendar.getInstance();

		Paragraph title = new Paragraph("Funcionários de Férias", super.getFONT(Font.BOLD));
		document.add(title);

		document.add(Chunk.NEWLINE);
		PdfPTable pdfPTable = createEmployeesVacationTableHeader();

		for (EmployeesVacation ev : vacations) {
			if (ev.vacation.getDate().before(today) || ev.vacation.getDate().equals(today)) {
				insertEmployeeVacationCell(pdfPTable, ev);
			}
		}

		document.add(pdfPTable);
	}

	private void insertEmployeesUpcomingVacation(Document document) throws DocumentException {
		GregorianCalendar today = (GregorianCalendar) GregorianCalendar.getInstance();

		document.newPage();
		Paragraph title = new Paragraph("Funcionários com férias por vir", super.getFONT(Font.BOLD));
		document.add(title);

		document.add(Chunk.NEWLINE);
		PdfPTable pdfPTable = createEmployeesVacationTableHeader();

		for (EmployeesVacation ev : vacations) {
			if (ev.vacation.getDate().after(today)) {
				insertEmployeeVacationCell(pdfPTable, ev);
			}
		}
		document.add(pdfPTable);
	}

	private PdfPTable createEmployeesVacationTableHeader() throws DocumentException {
		PdfPTable pdfPTable = new PdfPTable(3);
		pdfPTable.setWidthPercentage(100);
		pdfPTable.setWidths(new float[] { 3, 3, 3 });

		PdfPCell tableHeaderName = new PdfPCell(new Paragraph("Funcionário", super.getFONT(Font.BOLD)));
		tableHeaderName.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell tableHeaderDateStart = new PdfPCell(new Paragraph("Início", super.getFONT(Font.BOLD)));
		tableHeaderDateStart.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell tableHeaderDateEnd = new PdfPCell(new Paragraph("Término", super.getFONT(Font.BOLD)));
		tableHeaderDateEnd.setHorizontalAlignment(Element.ALIGN_CENTER);

		tableHeaderName.setFixedHeight(25f);
		pdfPTable.addCell(tableHeaderName);
		pdfPTable.addCell(tableHeaderDateStart);
		pdfPTable.addCell(tableHeaderDateEnd);

		return pdfPTable;
	}

	private void insertEmployeeVacationCell(PdfPTable pdfPTable, EmployeesVacation ev) {
		String startDate = " ";
		String endDate = " ";
		if (ev.vacation.getDate() != null) {
			startDate = formatter.format(ev.vacation.getDate().getTime());
		}
		if (ev.vacation.getEndDate() != null) {
			endDate = formatter.format(ev.vacation.getEndDate().getTime());
		}

		PdfPCell empCell = new PdfPCell(new Paragraph(ev.employee.getName()));
		empCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell startCell = new PdfPCell(new Paragraph(startDate));
		startCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell endCell = new PdfPCell(new Paragraph(endDate));
		endCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		pdfPTable.addCell(empCell);
		pdfPTable.addCell(startCell);
		pdfPTable.addCell(endCell);
	}

	@Override
	public String title() {
		return "Relatorio de Férias";
	}

	public void setBossId(Long bossId) {
		this.bossId = bossId;
	}

	@Autowired
	public void seteSrvc(EmployeeService eSrvc) {
		this.eSrvc = eSrvc;
	}

	@Autowired
	public void setlSrvc(LeaveService lSrvc) {
		this.lSrvc = lSrvc;
	}

}
