package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.UsuarioDAO;
import modelo.UsuarioDTO;

/**
 * Servlet implementation class ServletGestionUsuario
 */
@WebServlet("/ServletGestionUsuario")
public class ServletGestionUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionUsuario() {
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
		
		String u,c,r,e;
		int d;
		boolean res;
		
		if(request.getParameter("btnins")!=null) {
		d=Integer.parseInt(request.getParameter("doc"));
		u=request.getParameter("usu");
		c=request.getParameter("cla");
		r=request.getParameter("rol");
		e=request.getParameter("est");
		
		UsuarioDTO usdto=new UsuarioDTO(d, u, c, r, e);
		UsuarioDAO usdao=new UsuarioDAO();
		res=usdao.insertarusuario(usdto);
		if(res) {
			JOptionPane.showMessageDialog(null, "Usuario registrdo");
			response.sendRedirect("usuario.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "Usuario no registrado");
			response.sendRedirect("usuario.jsp");
		}
		
			
		}
		
		
		
	}

}
