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
			String sentencia = "SELECT idusuario FROM usuario where nocuenta = '" + boleta + "' and contra = '" + pass + "'";
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
	
	public static String getIdNameUser(String boleta){
		try {
			ConexionBD basedatos = new ConexionBD();
			basedatos.conectar(DatosBD.url,DatosBD.usuario,DatosBD.password);
			String sentencia = "SELECT nombre FROM usuario where nocuenta = '" + boleta + "'";
			System.out.println(sentencia);
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
	
	public static String getIdUsuario(String boleta){
		try {
			ConexionBD basedatos = new ConexionBD();
			basedatos.conectar(DatosBD.url,DatosBD.usuario,DatosBD.password);
			String sentencia = "SELECT idusuario FROM usuario where nocuenta = '" + boleta + "'";
			System.out.println(sentencia);
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
	
	public static String[][] getRegistros(String boleta){
		try {
			ConexionBD basedatos = new ConexionBD();
			basedatos.conectar(DatosBD.url,DatosBD.usuario,DatosBD.password);
			String idUsuario = getIdUsuario(boleta);
			String sentencia = "SELECT nombre, idregistro FROM registro where idusuario = '" + idUsuario + "'";
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
	
	public static boolean registrarUsuario(String[] campo){
		ConexionBD basedatos = new ConexionBD();
		basedatos.conectar(DatosBD.url,DatosBD.usuario,DatosBD.password);
		
		String sentencia = "INSERT INTO usuario(correo, nocuenta, nombre, contra) VALUES('" 
		+ campo[0] + "', '" + campo[1] + "', '" + campo[2] + "', '" + campo[3] + "')";
		System.out.println(sentencia);
		return basedatos.insertar(sentencia);
	}
	
	public static boolean agregarCuenta(Cuenta cuenta){
		ConexionBD basedatos = new ConexionBD();
		basedatos.conectar(DatosBD.url,DatosBD.usuario,DatosBD.password);
		
		String sentencia = "INSERT INTO cuentasDisponibles(nombre, identificador, tipo, subtipo) VALUES('" 
		+ cuenta.getNombre() + "', '" + cuenta.getID() + "', '" + cuenta.getTipo() + "', '" + cuenta.getSubTipo() + "')";
		System.out.println(sentencia);
		return basedatos.insertar(sentencia);	
	}
	
	public static String[] getNombresCuentas(){
		try {
			ConexionBD basedatos = new ConexionBD();
			basedatos.conectar(DatosBD.url,DatosBD.usuario,DatosBD.password);
			String sentencia = "SELECT nombre FROM cuentasDisponibles";
			System.out.println(sentencia);
			ResultSet tuplas = basedatos.consulta(sentencia);
			ArrayList<String> vector = new ArrayList<String>();
			while (tuplas.next()){
				String aux = "";
				aux = tuplas.getString(1);
				vector.add(aux);
			}

			String[] ans = new String[vector.size()];
			int cont = 0;
			for(String i : vector)
				ans[cont++] = i;
			return ans;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args){
		QuerysBD db = new QuerysBD();
		System.out.println(db.validarUsuario("2014330415", "edgar21"));
		String r[][] = db.getRegistros("2014330415");
		for(String[] v: r) {
			for(String n: v) {
				System.out.print(n);
			}
			System.out.println("");
		}
	}
}
