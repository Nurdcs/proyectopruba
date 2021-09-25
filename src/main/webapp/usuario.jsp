<%@page import="controlador.Conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/consultar.js"></script>
</head>
<body>

<form action="ServletGestionUsuario" method="post">
<h1>Formulario de  ingreso</h1>
<select>
<option></option>
</select>
<input type="text" name="doc"  >
<input type="text" name="usu"  >
<input type="text" name="cla"  >
<input type="text" name="rol"  >
<input type="text" name="est"  >
<input type="submit" name="btnins" value="Registrar">

</form>


<form action="ServletGestionUsuario" method="post">
<input type="text" name="doc"  >
<input type="submit" name="btncon" value="Consultar">
</form>

</body>
</html>