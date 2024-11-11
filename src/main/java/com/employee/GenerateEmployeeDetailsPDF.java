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

@WebServlet("/GenerateEmployeeDetailsPDF")
public class GenerateEmployeeDetailsPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch employee details using a utility class (similar to AttendanceDBUtil)
        List<Employee> employeeList = EmployeeDBUtil.getEmployees(); // Ensure EmployeeDBUtil is implemented

        // Check if employee list is empty or null
        if (employeeList == null || employeeList.isEmpty()) {
            response.setContentType("text/html");
            response.getWriter().write("<script type='text/javascript'>alert('No employee records found.');window.location.href='EmployeeDetails';</script>");
            return;
        }

        // Specify the server-side location where the PDF will be saved
        String filePath = "C:\\Users\\Zayan Mohamed\\eclipse-workspace\\EmployeeManagment\\src\\main\\webapp\\WEB-INF\\reports\\employee_details_report.pdf";
        System.out.println("Saving PDF to: " + filePath);  // Log the file path

        // Save the PDF on the server
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            // Initialize the PDF document
            Document document = new Document();
            PdfWriter.getInstance(document, fos);
            document.open();

            // Add a title to the document
            document.add(new Paragraph("Employee Details Report"));
            document.add(new Paragraph(" "));

            // Create a table with 6 columns (based on employee details)
            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100); // Make the table width 100% of the page

            // Define table headers
            String[] headers = {"Employee ID", "Name", "Email", "Phone", "Hire Date", "Job Title"};
            for (String header : headers) {
                PdfPCell headerCell = new PdfPCell(new Paragraph(header));
                table.addCell(headerCell);
            }

            // Populate table rows with employee data
            for (Employee emp : employeeList) {
                table.addCell(String.valueOf(emp.getEmpID()));
                table.addCell(emp.getName());
                table.addCell(emp.getEmail());
                table.addCell(String.valueOf(emp.getPhone()));
                table.addCell(emp.getHireDate());
                table.addCell(emp.getJobTitle());
            }

            // Add the table to the document
            document.add(table);

            // Close the document
            document.close();

            // Send JavaScript alert for success
            response.setContentType("text/html");
            response.getWriter().write("<script type='text/javascript'>alert('Employee details report generated successfully!'); window.location.href='EmployeeDetails';</script>");
        } catch (DocumentException e) {
            // Catch DocumentException and notify failure
            response.setContentType("text/html");
            response.getWriter().write("<script type='text/javascript'>alert('Failed to generate the employee details report. Please try again.'); window.location.href='EmployeeDetails';</script>");
        } catch (IOException e) {
            // Catch IOException and notify failure
            response.setContentType("text/html");
            response.getWriter().write("<script type='text/javascript'>alert('Error saving the report. Please check the file path.'); window.location.href='EmployeeDetails';</script>");
        }
    }
}