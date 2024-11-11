<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



  <table>
  <c:forEach var="emp" items ="${emDetails}">
  
  <c:set var=employeeId value ="${ em.employeeId}"/>
  <c:set var=employeeName value ="${ em.employeeName}"/>
  <c:set var= employeeStatus value ="${ em.employeeStatus}"/>
 
 
 
 
 <tr>
     
        <td> Employee ID </td>
         <td> ${ emp.employeeId} </td>
         
 </tr>
 
 <tr>
     
        <td> Employee Name </td>
         <td> ${ emp.employeeName} </td>
         
 </tr>
     <tr>
     
        <td> Employee Status </td>
         <td> ${emp.EmployeeStatus} </td>
         
 </tr>
   </c:forEach>
   </table>
   <c:url value="UpdateHR.jsp"  var= "empUpate">
   <c:param name="employeeId " value="$(employeeId)"/>
   <c:param name="employeeName " value="$(employeeName)"/>
   <c:param name="employeeStatus " value="$(employeeStatus)"/>
   
   </c:url>
   <a href="${emUpdate}">
  <button type="submit">Update</button>
  </a>
  </body>
  
  </html>