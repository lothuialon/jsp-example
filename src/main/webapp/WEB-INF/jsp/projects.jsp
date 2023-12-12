<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Project Listesi</h1>
<table>
<thead>
<th><b>Project Code</b></th>
<th><b>Project Name</b></th>
</thead>
<c:forEach items="${projeListesi}" var="project">
<tr>
<td>${project.projectCode}</td>
<td>${project.projectName}</td>
<td><a href="editproject/${project.id}">Detay</a>
<td><a href="deleteproject/${project.id}">Sil</a>
</tr>
</c:forEach>

</table>

<a href="/newproject">Yeni Proje Ekle</a>
</body>
</html>