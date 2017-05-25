package modelo;
import java.util.*;

public class Cuenta {

	private String nombre,ID,Tipo,subTipo;
	private ArrayList operaciones;
	public Cuenta(String nombre,String ID, String Tipo, String subTipo) {
		
		this.nombre = nombre;
		this.setID(ID);
		this.setTipo(Tipo);
		this.setSubTipo(subTipo);
	}
	public void agregarOperacion(Operacion oper)
	{
		operaciones.add(oper);
	}	
	public void eliminarOperacion(Operacion oper)
	{
		
	}
	
	public ArrayList getOperaciones()
	{
		return operaciones;
	}
	public String getNombre()
	{
		return nombre;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getSubTipo() {
		return subTipo;
	}
	public void setSubTipo(String subTipo) {
		this.subTipo = subTipo;
	}

}