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
import aeb.gov.br.model.organizational.EmployeeCategory;
import aeb.gov.br.model.personal.Employee;
import aeb.gov.br.service.organizational.EmployeeCategoryService;
import aeb.gov.br.service.personal.EmployeeService;

@Component
public class PerCategoryPDFView extends AebRhAbstractPdfView {

	private EmployeeCategoryService employeeCategoryService;
	private EmployeeService employeeService;

	Iterable<EmployeeCategory> employeeCategories;

	@Override
	public void content(Document document) throws DocumentException {
		insertCategories(document);
		listCategories(document);
	}

	@Override
	public String title() {
		return "Funcionários por categoria";
	}

	private void insertCategories(Document document) throws DocumentException {
		document.add(Chunk.NEWLINE);
		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100);
		table.setWidths(new float[] { 2, 2 });

		PdfPCell categoryNameCell = new PdfPCell(new Paragraph("Categoria", super.getFONT(Font.BOLD)));
		PdfPCell numberOfEmployeesCell = new PdfPCell(new Paragraph("Número de pessoas", super.getFONT(Font.BOLD)));

		categoryNameCell.setFixedHeight(25f);
		table.addCell(categoryNameCell);
		table.addCell(numberOfEmployeesCell);

		addCategoryContent(table);

		document.add(table);
	}

	private void addCategoryContent(PdfPTable table) {
		this.employeeCategories = employeeCategoryService.list();
		for (EmployeeCategory employeeCategory : this.employeeCategories) {
			PdfPCell categoryCell = new PdfPCell(new Paragraph(employeeCategory.getCategory()));
			employeeCategory.setNumberOfEmployees(employeeService.getNumberFromCategory(employeeCategory));
			PdfPCell numberOfEmployee = new PdfPCell(new Paragraph(employeeCategory.getNumberOfEmployees() + ""));
			table.addCell(categoryCell);
			table.addCell(numberOfEmployee);
		}
	}

	private void listCategories(Document document) throws DocumentException {
		for (EmployeeCategory employeeCategory : this.employeeCategories) {
			if (employeeCategory.getNumberOfEmployees() > 0) {
				document.newPage();
				Paragraph employeeCategoryName = new Paragraph(employeeCategory.getCategory(),
						super.getFONT(Font.BOLD));
				document.add(employeeCategoryName);

				Iterable<Employee> employees = employeeService.getEmployeeByCategory(employeeCategory);
				for(Employee employee : employees) {
					Paragraph employeeName = new Paragraph(employee.getName());
					employeeName.setAlignment(Element.ALIGN_CENTER);
					document.add(employeeName);
				}
			}
		}
	}

	@Autowired
	public void setEmployeeCategoryService(EmployeeCategoryService employeeCategoryService) {
		this.employeeCategoryService = employeeCategoryService;
	}

	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

}
