package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
Connection cnn;

public Connection conexiondb() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
			try {
				cnn=DriverManager.getConnection("jdbc:mysql://localhost/bancog10","root","");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Conexion okkkk");
		
		
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	
return cnn;	
}
	
	

}
