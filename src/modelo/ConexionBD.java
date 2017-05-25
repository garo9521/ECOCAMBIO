package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class ConexionBD{
	
	private Connection con = null;
	
	public boolean conectar(String direc, String user, String pass ){		
		try{			
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection)DriverManager.getConnection(direc, user, pass);
			System.out.println("Se realizo la conexion.");
			
		}catch (SQLException e) {
			System.out.println("Error conectando con la base.");
		}catch (ClassNotFoundException e) {
			System.out.println("No se encontro la clase.");
		}
		if(con != null)
			return true;
		return false;
	}
	public boolean insertar(String consulta){		
		try{
			System.out.println(consulta);
			Statement sentenciaBuscar = (Statement)this.con.createStatement();
			sentenciaBuscar.executeUpdate(consulta);
			return true;
		}catch( Exception e ){
			e.printStackTrace();
			return false;
		}
		
	}
	
	public ResultSet consulta(String consulta){
		ResultSet ans = null;
		try{
			//System.out.println(consulta);
			Statement sentenciaBuscar = (Statement)this.con.createStatement();
			ans = sentenciaBuscar.executeQuery(consulta);
		}catch( Exception e ){
			e.printStackTrace();
		}
		return ans;
	}
	
	public void setCon(Connection con) {
		this.con = con;
	}
}

