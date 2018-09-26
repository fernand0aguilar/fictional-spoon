package aeb.gov.br.files;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public abstract class AebRhAbstractPdfView extends AbstracITextPdfView {

	protected final String ADDRESS_IMAGE_URL = this.getClass().getClassLoader().getResource("static/Logo_AEB.png")
			.toString();

	private final float MINISTER_IMAGE_HEIGHT = 21.5f;
	private final float MINISTER_IMAGE_WIDTH = 62.5f;

	protected final FontFamily FONT_USED = FontFamily.TIMES_ROMAN;

	@Override
	protected void insertLogo(Document document) throws Exception {
		PdfPTable pdfTable = new PdfPTable(3);

		PdfPCell imageCell = new PdfPCell();
		PdfPCell nameCell = new PdfPCell();
		PdfPCell remainingCell = new PdfPCell();
		imageCell.setBorderWidth(0);
		nameCell.setBorderWidth(0);
		remainingCell.setBorderWidth(0);
		pdfTable.setWidthPercentage(100);
		pdfTable.setWidths(new int[] { 1, 3, 1 });

		Image image = Image.getInstance(ADDRESS_IMAGE_URL);
		image.setAlignment(Element.ALIGN_LEFT);

		image.scaleAbsolute(this.MINISTER_IMAGE_WIDTH, this.MINISTER_IMAGE_HEIGHT);
		imageCell.addElement(image);
		Paragraph title = new Paragraph("AGÊNCIA ESPACIAL BRASILEIRA", this.getFONT(Font.BOLD, 15));
		title.setAlignment(Element.TITLE);

		nameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		nameCell.addElement(title);

		pdfTable.addCell(imageCell);
		pdfTable.addCell(nameCell);
		pdfTable.addCell(remainingCell);

		document.add(pdfTable);
	}

	public Font getFONT(int fontWeight) {
		switch (fontWeight) {
		case Font.BOLD:
			return new Font(FONT_USED, 12, Font.BOLD);
		default:
			return new Font(FONT_USED, 12);
		}
	}

	public Font getFONT(int fontWeight, float fontSize) {
		switch (fontWeight) {
		case Font.BOLD:
			return new Font(FONT_USED, fontSize, Font.BOLD);
		default:
			return new Font(FONT_USED, fontSize);
		}
	}

}
