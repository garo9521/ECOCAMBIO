package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.ConexionBD;


public class QuerysBD {

	public static String validarUsuario(String boleta, String pass) {
		try {
			ConexionBD basedatos = new ConexionBD();
			basedatos.conectar(DatosBD.url,DatosBD.usuario,DatosBD.password);
			String sentencia = "SELECT idusuario FROM usuario where idusuario = '" + boleta + "' and contrasena = '" + pass + "'";
			//System.out.println(sentencia);
			ResultSet tuplas = basedatos.consulta(sentencia);
			String aux = "";
			
			while (tuplas.next())
				return tuplas.getString(1);
			if(aux.equals(""))
				return "null";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean registrarUsuario(String[] campo){
		ConexionBD basedatos = new ConexionBD();
		basedatos.conectar(DatosBD.url,DatosBD.usuario,DatosBD.password);
		
		String sentencia = "INSERT INTO usuario(puntos, correo, idusuario, nombre, contrasena) VALUES(0, '" 
		+ campo[0] + "', '" + campo[1] + "', '" + campo[2] + "', '" + campo[3] + "')";
		System.out.println(sentencia);
		return basedatos.insertar(sentencia);
	}
	

	public static boolean actualizaUsuario(String boleta, String[] campo) {
		ConexionBD basedatos = new ConexionBD();
		basedatos.conectar(DatosBD.url,DatosBD.usuario,DatosBD.password);
		String sentencia = "UPDATE usuario SET correo = '" + campo[0] + "', nombre = '" + campo[1] + "', contrasena = '" + campo[2] + "' WHERE idusuario = " + boleta;
		System.out.println(sentencia);
		return basedatos.insertar(sentencia);
	}
	
	public static boolean agregarPuntos(String boleta, int puntos) {
		ConexionBD basedatos = new ConexionBD();
		basedatos.conectar(DatosBD.url,DatosBD.usuario,DatosBD.password);
		String sentencia = "UPDATE usuario SET puntos = puntos + " + puntos + " WHERE idusuario = " + boleta;
		System.out.println(sentencia);
		return basedatos.insertar(sentencia);
	}
	
	
	
	public static String[] getDatos(String boleta){
		try {
			ConexionBD basedatos = new ConexionBD();
			basedatos.conectar(DatosBD.url,DatosBD.usuario,DatosBD.password);
			String sentencia = "SELECT * FROM usuario where idusuario = '" + boleta + "'";
			System.out.println(sentencia);
			ResultSet tuplas = basedatos.consulta(sentencia);
			String[] aux = new String[4];
			while (tuplas.next()){
				aux[0] = tuplas.getString(2);
				aux[1] = tuplas.getString(3);
				aux[2] = tuplas.getString(5);
				aux[3] = tuplas.getString(4);
			}

			return aux;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String[][] Productos(){
		try {
			ConexionBD basedatos = new ConexionBD();
			basedatos.conectar(DatosBD.url,DatosBD.usuario,DatosBD.password);
			String sentencia = "SELECT nombre, costo FROM producto";
			System.out.println(sentencia);
			ResultSet tuplas = basedatos.consulta(sentencia);
			ArrayList<String[]> vector = new ArrayList<String[]>();
			while (tuplas.next()){
				String[] aux = new String[2];
				aux[0] = tuplas.getString(1);
				aux[1] = tuplas.getString(2);
				vector.add(aux);
			}

			String[][] ans = new String[vector.size()][2];
			int cont = 0;
			for(String[] i : vector)
				ans[cont++] = i;
			return ans;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
