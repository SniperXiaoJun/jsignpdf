/*
 * $Id: CellAlignment.java,v 1.1 2010/04/14 17:50:43 kwart Exp $
 *
 * This code is part of the 'iText Tutorial'.
 * You can find the complete tutorial at the following address:
 * http://itextdocs.lowagie.com/tutorial/
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * itext-questions@lists.sourceforge.net
 */
package com.lowagie.examples.objects.tables;

import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Change the alignment of the contents of a PdfPCell.
 */
public class CellAlignment {

	/**
	 * Changing the alignment
	 * 
	 * @param args
	 *            no arguments needed
	 */
	public static void main(String[] args) {

		System.out.println("indentation - alignment");
		// step1
		Document document = new Document(PageSize.A4.rotate(), 10, 10, 10, 10);
		try {
			// step2
			PdfWriter.getInstance(document,
					new FileOutputStream("Alignment.pdf"));
			// step3
			document.open();
			// step4
			PdfPTable table = new PdfPTable(2);
			PdfPCell cell;
			Paragraph p = new Paragraph("Quick brown fox jumps over the lazy dog. Quick brown fox jumps over the lazy dog.");
			table.addCell("default alignment");
			cell = new PdfPCell(p);
			table.addCell(cell);
			table.addCell("centered alignment");
			cell = new PdfPCell(p);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			table.addCell("right alignment");
			cell = new PdfPCell(p);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(cell);
			table.addCell("justified alignment");
			cell = new PdfPCell(p);
			cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			table.addCell(cell);
			table.addCell("blah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\n");
			table.getDefaultCell().setVerticalAlignment(Element.ALIGN_BASELINE);
			table.addCell("baseline");
			table.addCell("blah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\n");
			table.getDefaultCell().setVerticalAlignment(Element.ALIGN_BOTTOM);
			table.addCell("bottom");
			table.addCell("blah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\n");
			table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell("middle");
			table.addCell("blah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\n");
			table.getDefaultCell().setVerticalAlignment(Element.ALIGN_TOP);
			table.addCell("top");
			document.add(table);
		} catch (Exception de) {
			de.printStackTrace();
		}
		// step5
		document.close();
	}
}