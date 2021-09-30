<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
HttpSession  objsesion=request.getSession();
String uss=(String)objsesion.getAttribute("llevausuario");

%>
<div><%=uss%></div>
<form action="Creditos" method="post" enctype="multipart/form-data">
<input type="file" name="archivo" value="" >
<input type="submit" name="cargar" value="add Archivo">
</form>


</body>
</html>