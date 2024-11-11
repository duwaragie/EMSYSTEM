package com.employee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/ReportGeneratorServlet")
public class ReportGeneratorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String REPORT_FOLDER = "reports"; // Relative path

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the real path for the reports folder
        String realPath = getServletContext().getRealPath(REPORT_FOLDER); 
        File reportDir = new File(realPath);
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

        // Get the PDF file from the request
        Part filePart = request.getPart("file");
        String fileName = "report.pdf"; // You can customize this as needed
        File file = new File(reportDir, fileName);

        // Save the file
        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] fileContent = filePart.getInputStream().readAllBytes();
            fos.write(fileContent);
            response.getWriter().write("{\"success\": true}");
        } catch (IOException e) {
            response.getWriter().write("{\"success\": false, \"message\": \"" + e.getMessage() + "\"}");
        }
    }
}

