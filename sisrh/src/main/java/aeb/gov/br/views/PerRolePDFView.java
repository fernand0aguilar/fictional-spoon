package aeb.gov.br.views;

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
import aeb.gov.br.model.organizational.EmployeeRole;
import aeb.gov.br.model.personal.Employee;
import aeb.gov.br.service.organizational.EmployeeRoleService;
import aeb.gov.br.service.personal.EmployeeService;;

@Component
public class PerRolePDFView extends AebRhAbstractPdfView {

	private EmployeeRoleService employeeRoleService;
	private EmployeeService employeeService;
	private Iterable<EmployeeRole> employeeRoles;

	@Override
	public void content(Document document) throws DocumentException {
		insertRoles(document);
		listRoles(document);
	}

	private void insertRoles(Document document) throws DocumentException {
		document.add(Chunk.NEWLINE);
		PdfPTable pdfPTable = new PdfPTable(2);
		pdfPTable.setWidthPercentage(100);
		pdfPTable.setWidths(new float[] { 2, 2 });

		PdfPCell tableHeaderName = new PdfPCell(new Paragraph("Cargo", super.getFONT(Font.BOLD)));
		PdfPCell tableHeaderNumber = new PdfPCell(new Paragraph("Número de pessoas", super.getFONT(Font.BOLD)));

		tableHeaderName.setFixedHeight(25f);
		pdfPTable.addCell(tableHeaderName);
		pdfPTable.addCell(tableHeaderNumber);

		this.employeeRoles = employeeRoleService.list();

		for (EmployeeRole role : this.employeeRoles) {
			insertRoleOnTable(document, pdfPTable, role);
		}
		
		document.add(pdfPTable);
	}

	@Override
	public String title() {
		return "Relatório de cargos";
	}

	@Autowired
	public void setEmployeeRoleService(EmployeeRoleService employeeRoleService) {
		this.employeeRoleService = employeeRoleService;
	}

	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	private void insertRoleOnTable(Document document, PdfPTable pdfPTable, EmployeeRole role) {
		PdfPCell roleCell = new PdfPCell(new Paragraph(role.getDescription()));
		role.setNumberOfEmployee(employeeService.getNumberFromRole(role));
		PdfPCell numberCell = new PdfPCell(new Paragraph(role.getNumberOfEmployee() + ""));
		pdfPTable.addCell(roleCell);
		pdfPTable.addCell(numberCell);
	}
	
	private void listRoles(Document document) throws DocumentException {
		for(EmployeeRole role : this.employeeRoles) {
			if(role.getNumberOfEmployee() > 0) {
				document.newPage();
				Paragraph roleName = new Paragraph(role.getDescription(), super.getFONT(Font.BOLD));
				document.add(roleName);
				
				Iterable<Employee> employees = employeeService.getEmployeeByRole(role);
				
				for (Employee employee : employees) {
					Paragraph employeeName = new Paragraph(employee.getName());
					employeeName.setAlignment(Element.ALIGN_CENTER);
					document.add(employeeName);
				}
			}
		}
	}

}
