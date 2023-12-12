<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="jakarta.tags.core" %>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>Project Kayıt Sayfası</h1>
 
 <form:form method="POST" action="/addNewProject">
 <table>
 <tr>
 <td>Project Code </td>
 <td><form:input path="projectCode" /></td>
 </tr>
  <tr>
 <td>Project Name </td>
 <td><form:input path="projectName" /></td>
 </tr>
  <tr>
 <td>&nbsp; </td>
 <td><input type="submit" value="Kaydet" /></td>
 </tr>
 </table>
 </form:form>
</body>
</html>