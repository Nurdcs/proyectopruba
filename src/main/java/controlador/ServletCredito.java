package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.Part;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.CreditoDAO;

/**
 * Servlet implementation class ServletCredito
 */
@WebServlet("/ServletCredito")
@MultipartConfig
public class ServletCredito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCredito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 
		CreditoDAO credao=new CreditoDAO();
	if(request.getParameter("cargar")!=null) {
		
		Part archivo= request.getPart("archivo");
		//String Url="C:\\Users\\nyral\\eclipse-workspace\\Aplicacionweb10\\src\\main\\webapp\\documento\\";
		
		
		//En Mysql: show variables like 'secure_file_priv'
		//String tipo= archivo.getContentType();
		//JOptionPane.showMessageDialog(null, tipo);
		String Url="C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/";
		
		if(archivo.getContentType().equals("application/vnd.ms-excel")) {
		try {
		InputStream file= archivo.getInputStream();
		File copia= new File(Url+"prueba43.csv");
		FileOutputStream escribir= new FileOutputStream(copia);
		int num=file.read();
		while(num !=-1) {
			escribir.write(num);
			num=file.read();
		}
		file.close();
		escribir.close();
		JOptionPane.showMessageDialog(null, "Se cargo el archivo correctamente");
		if(credao.cargarcredito(Url+"prueba43.csv")) {
			response.sendRedirect("creditos.jsp?men=Se registro los creditos correctamente");
		}else
		{
			response.sendRedirect("creditos.jsp?men=No se registraron creditos");
		}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar el archivo: "+e);
			response.sendRedirect("creditos.jsp?men=Error al cargar el archivo: ");
			
		}
		}else
		{
			response.sendRedirect("Libros.jsp?men=Formato de Archivo no permitido");
			}
	}
	
	}

}
