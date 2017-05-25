package modelo;

public class Operacion {

	private String tipo;
	private Double monto;
	public Operacion(String tipo, Double monto) 
	{
		this.tipo = tipo;
		this.monto = monto;
	}
	public String getTipo()
	{
		return tipo;
	}
	public Double getMonto()
	{
		return monto;
	}

}
