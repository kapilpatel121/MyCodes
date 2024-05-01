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

public class StudentResult {

    public static final String DEST = "E:/KAPIL 22/StudentResult.pdf";
    public static final String Query = "Select * from student_Result order by Enrollmen_id asc";

    public static void main(String[] args) throws IOException, DocumentException, SQLException {
        new StudentResult().generateStudentResultPDF();
    }

    public void generateStudentResultPDF() throws IOException, DocumentException, SQLException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();

        try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
        	       PreparedStatement ps = con.prepareStatement(Query);
             ResultSet rs = ps.executeQuery()) {

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(DEST));
            document.open();
            PdfPTable table = new PdfPTable(7);
            LocalDateTime dt = LocalDateTime.now(); // Initialize LocalDateTime object with current date and time

            // Add heading
            Paragraph heading = new Paragraph("Student Result Details");
            heading.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(heading);

            // Add paragraph
            Paragraph paragraph = new Paragraph("This document contains details of davv indore student result.");
            paragraph.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(paragraph);

            // Add Timestamp
            document.add(new Paragraph("Time and Date:-" + dt));

            // Add space
            document.add(new Paragraph(" "));

            int i = 0;
            table.addCell("Sno");
            table.addCell("Enrollment id"); // Adjusted column name
            table.addCell("Name");
            table.addCell("Class");
            table.addCell("Session");
            table.addCell("Subject");
            table.addCell("Result");
            

            // Set fixed width for Enrollment ID column
            table.setWidthPercentage(100);
            // Remove extra column widths
            float[] columnWidths = {2f, 5f, 5f, 3f, 4f, 4f, 5f};
            table.setWidths(columnWidths);

            if (rs != null) {
                while (rs.next()) {
                    table.addCell("" + ++i);
                    table.addCell(rs.getString(1));
                    table.addCell(rs.getString(2));
                    table.addCell(rs.getString(3));
                    table.addCell(rs.getString(4));
                    table.addCell(rs.getString(5));
                    table.addCell(rs.getString(6));
                }
                System.out.println("Placement Data Generated successfully");
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
}