package com.davv.jdbc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.Desktop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.time.LocalDateTime;

public class Teacherdetails {

	public static final String DEST = "E:/PDFS/teacherDetails.pdf";
	public static final String Query = "SELECT * FROM teacher_details ";

	public static void main(String[] args) throws IOException, DocumentException, SQLException {
		new Teacherdetails().createPdf();
	}

	public void createPdf() throws IOException, DocumentException, SQLException {
		File file = new File(DEST);
		file.getParentFile().mkdirs();
		//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/producto", "c", "codefor");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "root");
		PreparedStatement ps = con.prepareStatement(Query);
		ResultSet rs = ps.executeQuery();

		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(DEST));
		document.open();
		PdfPTable table = new PdfPTable(4);
		LocalDateTime dt = LocalDateTime.now(); // Initialize LocalDateTime object with current date and time

		// Add heading
		Paragraph heading = new Paragraph("Teacher details");
		heading.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(heading);

		// Add paragraph
		Paragraph paragraph = new Paragraph("This document contains details of Teacher details");
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);

		// Add Timestamp
		document.add(new Paragraph("Time and Date:-" + dt));

		// Add space
		document.add(new Paragraph(" "));

		table.addCell("Teacher id");
		table.addCell(" Teacher Name");
		table.addCell("Qualification");
		table.addCell("Subject");

		// Set fixed width for Enrollment ID column
		table.setWidthPercentage(100);
		// Remove extra column widths
		float[] columnWidths = { 2f, 5f, 5f, 4f };
		table.setWidths(columnWidths);

		if (rs != null) {
			while (rs.next()) {
				table.addCell(rs.getString(1));
				table.addCell(rs.getString(2));
				table.addCell(rs.getString(3));
				table.addCell(rs.getString(4));
			}
			System.out.println("Teacher Details Generated successfully");
			System.out.println("The link is: " + DEST);
		} else {
			System.out.println("no record found");
		}
		document.add(table);
		document.close();

		try {
			// Replace "path/to/your/file.pdf" with the actual path to your PDF file
			File pdfFile = new File(DEST);

			if (pdfFile.exists()) {
				Desktop.getDesktop().open(pdfFile);
			} else {
				System.out.println("PDF file not found.");
			}
		} catch (IOException e) {
			System.out.println("Error opening PDF file: " + e.getMessage());
		}
	}
}
