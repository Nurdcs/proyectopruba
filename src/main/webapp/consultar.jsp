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
//Conexion con=new Conexion();
//con.conexiondb();

String d="",u="",c="",r="",e="";
if(request.getParameter("do")!=null){
d=request.getParameter("do");
u=request.getParameter("us");
c=request.getParameter("cl");
r=request.getParameter("ro");
e=request.getParameter("es");
}
%>




<form action="ServletGestionUsuario" method="post">
<table>
<tr>
<th>Documento</th>
<th>Usuario</th>
<th>Clave</th>
<th>Rol</th>
<th>Estado</th>
</tr>

<tr>
<td><input type="text" name="doc"  value="<%=d%>"></td>
<td><input type="text" name="usu"  value="<%=u%>"></td>
<td><input type="text" name="cla"  value="<%=c%>"></td>
<td><input type="text" name="rol"  value="<%=r%>"></td>
<td><input type="text" name="est"  value="<%=e%>"></td>
<td><input type="submit" name="btnact" value="Actualizar"></td>
<td><input type="submit" name="btneli" value="Eliminar"></td>

</tr>



</table>
</form>

</body>
</html>