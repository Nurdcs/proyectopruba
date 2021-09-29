package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import modelo.CreditoDAO;

/**
 * Servlet implementation class Creditos
 */
@WebServlet("/Creditos")
@MultipartConfig
public class Creditos extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Creditos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//if(request.getParameter("cargar")!=null) {
			
		 Part archivo= request.getPart("archivo");
		   String Url="C:\\\\Users\\\\nyral\\\\eclipse-workspace\\\\Aplicacionweb10\\\\src\\\\main\\\\webapp\\\\documentos\\\\";
			
			//String Url="C:\\Users\\nyral\\OneDrive\\Escritorio\\arcivoseclipse\\";
			
			//En Mysql: show variables like 'secure_file_priv'
			//String tipo= archivo.getContentType();
			//JOptionPane.showMessageDialog(null, tipo);
			//String Url="C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/";
			
			if(request.getParameter("cargar")!=null) {
			
					
				try {
				InputStream file= archivo.getInputStream();
				JOptionPane.showMessageDialog(null, Url);
				File copia= new File(Url+"archivo11.csv");
				FileOutputStream escribir= new FileOutputStream(copia);
				int num=file.read();
				while(num !=-1) {
					
					escribir.write(num);
					num=file.read();
				}
				
				
				file.close();
				escribir.close();
				
				boolean x;
				JOptionPane.showMessageDialog(null, "Se cargo el archivo correctamente");
				
				CreditoDAO credao=new CreditoDAO();
				
				x=credao.cargarcredito(Url+"archivo11.csv");
				if(x) {
					JOptionPane.showMessageDialog(null, "Datos cargados en la bd");
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "No se cargaron los datos");
				}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Error al cargar el archivoooooo: "+e);
									}
					
				
			
			}
			
			
		
		
		
		
		
		
		
		
	}

}
