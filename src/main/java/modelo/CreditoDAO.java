package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class CreditoDAO {
	
	Conexion con=new Conexion();
	Connection cnn=con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;	
	
	
public boolean cargarcredito(String URL) {
		JOptionPane.showMessageDialog(null, "en dao"+URL);
		boolean resul=false;
		try {
			
		/*String sql="load data infile '"+URL+"' into table creditos fields terminated by ',' lines terminated by '\r\n'";*/
			String loadQuery = "LOAD DATA  INFILE '"+URL+"' INTO TABLE creditos FIELDS TERMINATED BY ';' LINES TERMINATED BY '\n' ";
		ps = cnn.prepareStatement(loadQuery);
		JOptionPane.showMessageDialog(null, "en ps");
		resul=ps.executeUpdate()>0;
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null,"Error al registrar creditosmm: "+ e);
			//e.printStackTrace();
		
		}
		return resul;
	}

/*String loadQuery = "LOAD DATA INFILE '" + path.toAbsolutePath()
+ "' INTO TABLE persons FIELDS TERMINATED BY ','"
+ " LINES TERMINATED BY '\\n' (PersonID, FirstName, City) ";*/
	
}
