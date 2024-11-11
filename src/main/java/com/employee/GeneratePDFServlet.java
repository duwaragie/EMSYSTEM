package com.employee;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.List;

@WebServlet("/GeneratePDFServlet")
public class GeneratePDFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Fetch the list of attendance records using AttendanceDBUtil
	        List<Attendance> attendanceList = AttendanceDBUtil.getAttendanceDetails();

	        // Check if attendance list is empty or null
	        if (attendanceList == null || attendanceList.isEmpty()) {
	            response.setContentType("text/html");
	            response.getWriter().write("<script type='text/javascript'>alert('No attendance records found.');window.location.href='ReadAttendanceServlet';</script>");
	            return;
	        }

	        // Specify the server-side location where the PDF will be saved
	        String filePath = "C:\\Users\\Zayan Mohamed\\eclipse-workspace\\EmployeeManagment\\src\\main\\webapp\\WEB-INF\\reports\\attendance_report.pdf";
	        System.out.println("Saving PDF to: " + filePath);  // Log the file path

	        // Save the PDF on the server
	        try (FileOutputStream fos = new FileOutputStream(filePath)) {
	            // Initialize the PDF document
	            Document document = new Document();
	            PdfWriter.getInstance(document, fos);
	            document.open();

	            // Add a title to the document
	            document.add(new Paragraph("Employee Attendance Report"));
	            document.add(new Paragraph(" "));
	            
	            // Create a table with 6 columns
	            PdfPTable table = new PdfPTable(6);
	            table.setWidthPercentage(100); // Make the table width 100% of the page

	            // Define table headers
	            String[] headers = {"Attendance ID", "Employee ID", "Date", "Status", "CheckInTime", "CheckOutTime"};
	            for (String header : headers) {
	                PdfPCell headerCell = new PdfPCell(new Paragraph(header));
	                table.addCell(headerCell);
	            }

	            // Populate table rows with attendance data
	            for (Attendance a : attendanceList) {
	                table.addCell(String.valueOf(a.getAttendanceId()));
	                table.addCell(String.valueOf(a.getEmpId()));
	                table.addCell(a.getDate());  // Using the formatted date string from DBUtil
	                table.addCell(a.getStatus());
	                table.addCell(a.getCheckInTime());
	                table.addCell(a.getCheckOutTime());
	            }

	            // Add the table to the document
	            document.add(table);

	            // Close the document
	            document.close();

	            // Send JavaScript alert for success
	            response.setContentType("text/html");
	            response.getWriter().write("<script type='text/javascript'>alert('Report successfully generated!'); window.location.href='ReadAttendanceServlet';</script>");
	        } catch (DocumentException e) {
	            // Catch DocumentException and notify failure
	            response.setContentType("text/html");
	            response.getWriter().write("<script type='text/javascript'>alert('Failed to generate the report. Please try again.'); window.location.href='ReadAttendanceServlet';</script>");
	        } catch (IOException e) {
	            // Catch IOException and notify failure
	            response.setContentType("text/html");
	            response.getWriter().write("<script type='text/javascript'>alert('Error saving the report. Please check the file path.'); window.location.href='ReadAttendanceServlet';</script>");
	        }
	    }
	}