package turismoTierraSantaWH;

public class Atraccion {

	private String nombre;
	private Double costo;
	private Double tiempo;
	private int cupo;
	
	
	public Double getCosto() {
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	public Double getTiempo() {
		return tiempo;
	}
	public void setTiempo(Double tiempo) {
		this.tiempo = tiempo;
	}
	public int getCupo() {
		return cupo;
	}
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
