<%@page import="controlador.Conexion"%>
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
Conexion con=new Conexion();
con.conexiondb();

%>
<form action="ServletGestionUsuario" method="post">
<h1>Formulario de  ingreso</h1>
<input type="text" name="doc">
<input type="text" name="usu">
<input type="text" name="cla">
<input type="text" name="rol">
<input type="text" name="est">
<input type="submit" name="btnins">

</form>


</body>
</html>