package testTurismoTierraSantaWH;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import turismoTierraSantaWH.Atraccion;
import turismoTierraSantaWH.Promocion;
import turismoTierraSantaWH.Service;
import turismoTierraSantaWH.Usuario;

public class TestTurismoTierraSantaWH {

	@Test
	public void testService() {
		Service datos = new Service();
		assertNotNull(datos);
	}
	
	
	/*@Test
	public void testGetNombreUsuario() {
		Service datos = new Service();
		ArrayList<Usuario>  usuarios=datos.getUsuarios();
		Usuario usuario1=usuarios[3];
		assertEquals("Galadriel",usuario1.getNombre());
		
		
		
	}*/
	
	
	@Test
	public void testSiObtienePromociones() {
		ArrayList<Promocion> promociones;
		Service datos = new Service();
		promociones= datos.getPromociones();
		assertNotNull(promociones);
	}

	
	@Test
	public void testCargaPromociones() {
		ArrayList<Promocion> promociones;
		Service datos = new Service();
		promociones= datos.getPromociones();
		assertNotNull(promociones);
	}

	@Test
	public void testCargaAtracciones() {
		
		Service datos = new Service();
		ArrayList<Atraccion> atracciones= datos.getAtracciones();
		assertNotNull(atracciones);
	}
	@Test
	public void testCargaUsuarios() {
		
		Service datos = new Service();
		ArrayList<Usuario> usuarios= datos.getUsuarios();
		assertNotNull(usuarios);
	}
	
	@Test
	public void validaSiCargaTodosLosUsuarios() {
		
		Service datos = new Service();
		datos.cargar();
		ArrayList<Usuario> usuarios=datos.getUsuarios();
		assertEquals(4,usuarios.size());

	}
	
	@Test
	public void validaSiCargaTodosLasAtracciones() {
		
		Service datos = new Service();
		datos.cargar();
		ArrayList<Atraccion> atracciones=datos.getAtracciones();
		assertEquals(9,atracciones.size());

	}
	
	@Test
	public void validaSiCargaTodosLasPromociones() {
		
		Service datos = new Service();
		datos.cargar();
		ArrayList<Promocion> promociones=datos.getPromociones();
		assertEquals(6,promociones.size());

	}
	@Test
	public void validaSiContieneAtraccion() {
		Service datos = new Service();
		datos.cargar();
		ArrayList<Atraccion> array1= datos.getAtracciones();
		ArrayList<Atraccion> array2= datos.getAtracciones();
		
		assertEquals(true,datos.contieneAtraccion(array1,array2));
	
	}
	
	
	
	
}
