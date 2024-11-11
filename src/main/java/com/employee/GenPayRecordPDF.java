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


@WebServlet("/GenPayRecordPDF")
public class GenPayRecordPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch payroll records using a utility class
        List<PayrollRecord> payrollList = PayrollRecordDBUtil.getPayRecordDetails();  // Ensure PayrollRecordDBUtil is implemented

        // Check if payroll list is empty or null
        if (payrollList == null || payrollList.isEmpty()) {
            response.setContentType("text/html");
            response.getWriter().write("<script type='text/javascript'>alert('No payroll records found.');window.location.href='ManagePayrollServlet';</script>");
            return;
        }

        // Specify the server-side location where the PDF will be saved
        String filePath = "C:\\Users\\Zayan Mohamed\\eclipse-workspace\\EmployeeManagment\\src\\main\\webapp\\WEB-INF\\reports\\payroll_records.pdf";
        System.out.println("Saving PDF to: " + filePath);  // Log the file path

        // Save the PDF on the server
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            // Initialize the PDF document
            Document document = new Document();
            PdfWriter.getInstance(document, fos);
            document.open();

            // Add a title to the document
            document.add(new Paragraph("Payroll Records Report"));
            document.add(new Paragraph(" "));

            // Create a table with 8 columns (based on payroll details)
            PdfPTable table = new PdfPTable(8);
            table.setWidthPercentage(100);  // Make the table width 100% of the page

            // Define table headers
            String[] headers = {"Payroll ID", "Employee ID", "Basic Salary", "Allowances", "Deductions", "Net Salary", "Status", "Payment Date"};
            for (String header : headers) {
                PdfPCell headerCell = new PdfPCell(new Paragraph(header));
                table.addCell(headerCell);
            }

            // Populate table rows with payroll data
            for (PayrollRecord record : payrollList) {
                table.addCell(String.valueOf(record.getPayrollID()));
                table.addCell(String.valueOf(record.getEmpId()));
                table.addCell(record.getBasicSalary());
                table.addCell(record.getAllowances());
                table.addCell(record.getDeductions());
                table.addCell(record.getNetSalary());
                table.addCell(record.getStatus());
                table.addCell(record.getPaymentDate());
            }

            // Add the table to the document
            document.add(table);

            // Close the document
            document.close();

            // Send JavaScript alert for success
            response.setContentType("text/html");
            response.getWriter().write("<script type='text/javascript'>alert('Payroll records report generated successfully!'); window.location.href='ManagePayrollServlet';</script>");
        } catch (DocumentException e) {
            // Catch DocumentException and notify failure
            response.setContentType("text/html");
            response.getWriter().write("<script type='text/javascript'>alert('Failed to generate the payroll records report. Please try again.'); window.location.href='ManagePayrollServlet';</script>");
        } catch (IOException e) {
            // Catch IOException and notify failure
            response.setContentType("text/html");
            response.getWriter().write("<script type='text/javascript'>alert('Error saving the report. Please check the file path.'); window.location.href='ManagePayrollServlet';</script>");
        }
    }
}
	
	