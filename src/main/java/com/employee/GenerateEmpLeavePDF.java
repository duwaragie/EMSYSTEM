package com.employee;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
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

@WebServlet("/GenerateEmpLeavePDF")
public class GenerateEmpLeavePDF extends HttpServlet {
	private static final long serialVersionUID = 1L;


		 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        // Fetch leave records using a utility class
		        List<EmpLeave> leaveList = EmpLeaveDBUtil.getLeaveDetails();  // Ensure EmpLeaveDBUtil is implemented

		        // Check if leave list is empty or null
		        if (leaveList == null || leaveList.isEmpty()) {
		            response.setContentType("text/html");
		            response.getWriter().write("<script type='text/javascript'>alert('No leave records found.');window.location.href='ManageLeaveServlet';</script>");
		            return;
		        }

		        // Specify the server-side location where the PDF will be saved
		        String filePath = "C:\\Users\\Zayan Mohamed\\eclipse-workspace\\EmployeeManagment\\src\\main\\webapp\\WEB-INF\\reports\\leave_records_report.pdf";
		        System.out.println("Saving PDF to: " + filePath);  // Log the file path

		        // Save the PDF on the server
		        try (FileOutputStream fos = new FileOutputStream(filePath)) {
		            // Initialize the PDF document
		            Document document = new Document();
		            PdfWriter.getInstance(document, fos);
		            document.open();

		            // Add a title to the document
		            document.add(new Paragraph("Employee Leave Records Report"));
		            document.add(new Paragraph(" "));

		            // Create a table with 11 columns (based on leave details)
		            PdfPTable table = new PdfPTable(11);
		            table.setWidthPercentage(100);  // Make the table width 100% of the page

		            // Define table headers
		            String[] headers = {"Leave ID", "Leave Type", "Start Date", "End Date", "Leave Status", "Reason", "Date Approved", "Date Rejected", "Employee ID", "Approved/Rejected By", "Date Submitted"};
		            for (String header : headers) {
		                PdfPCell headerCell = new PdfPCell(new Paragraph(header));
		                table.addCell(headerCell);
		            }

		            // Populate table rows with leave data
		            for (EmpLeave leave : leaveList) {
		                table.addCell(String.valueOf(leave.getLeaveId()));
		                table.addCell(leave.getLeaveType());
		                table.addCell(leave.getStartDate());
		                table.addCell(leave.getEndDate());
		                table.addCell(leave.getLeaveStatus());
		                table.addCell(leave.getReason());
		                table.addCell(leave.getDateApproved());
		                table.addCell(leave.getDateRejected());
		                table.addCell(String.valueOf(leave.getEmployeeId()));
		                table.addCell(String.valueOf(leave.getApprovedRejectedBy()));
		                table.addCell(leave.getDateSubmitted());
		            }

		            // Add the table to the document
		            document.add(table);

		            // Close the document
		            document.close();

		            // Send JavaScript alert for success
		            response.setContentType("text/html");
		            response.getWriter().write("<script type='text/javascript'>alert('Leave records report generated successfully!'); window.location.href='ManageLeaveServlet';</script>");
		        } catch (DocumentException e) {
		            // Catch DocumentException and notify failure
		            response.setContentType("text/html");
		            response.getWriter().write("<script type='text/javascript'>alert('Failed to generate the leave records report. Please try again.'); window.location.href='ManageLeaveServlet';</script>");
		        } catch (IOException e) {
		            // Catch IOException and notify failure
		            response.setContentType("text/html");
		            response.getWriter().write("<script type='text/javascript'>alert('Error saving the report. Please check the file path.'); window.location.href='ManageLeaveServlet';</script>");
		        }
		    }
		}