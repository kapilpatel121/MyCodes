package com.itext;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class placementRecord {
    public static final String DEST = "E:/KAPIL 22/PlacementRecord.pdf";
    public static final String Query = "Select * from STUDENT_PLACEMENT_DETAILS order by year desc ";
    LocalDateTime dt = null;
       public static void main(String[] args) throws IOException, DocumentException, SQLException {
		new placementRecord().createPdf();
	}
   

    public void createPdf() throws IOException, DocumentException, SQLException {
    	File file = new File(DEST);
        file.getParentFile().mkdirs();
        
    	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
        PreparedStatement ps = con.prepareStatement(Query);
        ResultSet rs = ps.executeQuery();

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(DEST));
        document.open();
        PdfPTable table = new PdfPTable(6);

        // Set total width of the table
        table.setTotalWidth(500); // Adjust as needed

        // Set column widths
        float[] columnWidths = { 1f, 2f, 1.5f, 2.5f, 2f, 1.5f }; // Adjust as needed
        table.setWidths(columnWidths);

        // Add heading
        Paragraph heading = new Paragraph("Student Placement Details");
        heading.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(heading);

        // Add paragraph
        Paragraph paragraph = new Paragraph("This document contains details of student placements.");
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph);

        // Add Timestamp
        document.add(new Paragraph("Time and Date:-" + dt.now()));

        // Add space
        document.add(new Paragraph(" "));

        int i = 0;
        table.addCell("Sno");
        table.addCell("Name");
        table.addCell("Graduation Year");
        table.addCell("Company");
        table.addCell("Placement status");
        table.addCell("GPA");
        if (rs != null) {
            while (rs.next()) {
                table.addCell("" + ++i);
                table.addCell(rs.getString(1));
                table.addCell(rs.getString(2));
                table.addCell(rs.getString(3));
                table.addCell(rs.getString(4));
                table.addCell(rs.getString(5));
            }
            System.out.println("Placement Data Generated successfully");
            String link = "E:/KAPIL 22/PlacementRecord.pdf";
            System.out.println("The link is: " + link);
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
