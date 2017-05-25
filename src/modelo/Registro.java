package modelo;
import java.util.*;

public class Registro {

	private String nombre;
	private ArrayList cuentas;
	public Registro(String nombre) {
		
		this.nombre = nombre;
	}	
	public void agregarCuenta(Cuenta cuent)
	{
		cuentas.add(cuent);
	}
	public void eliminarCuenta(Cuenta cuent)
	{
		
	}
	
	public ArrayList getCuentas()
	{
		return cuentas;
	}
	public String getNombre()
	{
		return nombre;
	}

}