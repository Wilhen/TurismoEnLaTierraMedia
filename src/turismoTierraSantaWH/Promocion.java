package turismoTierraSantaWH;
import java.util.ArrayList;

	public class Promocion {
	private String nombre;
	private ArrayList<Atraccion> atracciones
    = new ArrayList<Atraccion>(0);
	private TipoPromocion tipo;
	private Double tot;
	private Double tiempoTot;
	

	public Double getTiempoTot() {
		return tiempoTot;
	}
	public void setTiempoTot(Double tiempoTot) {
		this.tiempoTot = tiempoTot;
	}
	public Double getTot() {
		return tot;
	}
	public void setTot(Double tot) {
		this.tot = tot;
	}
	public ArrayList<Atraccion> getAtracciones() {
		return atracciones;
	}
	public void setAtracciones(ArrayList<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoPromocion getTipo() {
		return tipo;
	}
	public void setTipo(TipoPromocion tipo) {
		this.tipo = tipo;
	}
	
	public void agregarAtraccion(Atraccion atr) {
		this.atracciones.add(atr);
	}
}