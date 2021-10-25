package turismoTierraSantaWH;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
	private ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>(0);
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>(0);
	private ArrayList<Promocion> promociones = new ArrayList<Promocion>(0);

	public ArrayList<Atraccion> getAtracciones() {
		return atracciones;
	}

	public void setAtracciones(ArrayList<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(ArrayList<Promocion> promociones) {
		this.promociones = promociones;
	}

	public boolean contieneAtraccion(ArrayList<Atraccion> array1, ArrayList<Atraccion> array2) {
	      
	    // Loop for array1
	    for(int i = 0; i < array1.size(); i++) {
	          
	        // Loop for array2
	        for(int j = 0; j < array2.size(); j++) {
	              
	            // Compare the element of each and
	            // every element from both of the
	            // arrays
	            if(array1.get(i) == array2.get(j)) {
	              
	                // Return if common element found
	                return true;
	            }
	        }
	    }
	      
	    // Return if no common element exist
	    return false; 
	}
	
	public void cargarAtracciones() {
		
		FileReader fr = null;
	    BufferedReader br = null;
    
	    try {
	       
	        fr = new FileReader ("atracciones.txt");
	        br = new BufferedReader(fr); 
	        
	        String linea = br.readLine();
	        while((linea != null)){
	        	String[] parts = linea.split("-");
	        	Atraccion atr= new Atraccion();
	        	atr.setNombre(parts[0]);
	        	atr.setCosto(Double.valueOf(parts[1]));
	        	atr.setTiempo(Double.valueOf(parts[2]));
	        	atr.setCupo(Integer.valueOf(parts[3]));
	        	this.atracciones.add(atr);
	            linea = br.readLine();
	        					  }
	        }
	    catch(IOException e){
	        e.printStackTrace();
	    }finally{
	        try{                    
	            if(fr != null){   
	                fr.close();     
	            			  }                  
	           }catch (Exception e2){ 
	            e2.printStackTrace();
	        					    }
	     	    }
	}
	
	public void cargarUsuarios() {
		FileReader fr = null;
	    BufferedReader br = null;
    
	    try {
	       
	        fr = new FileReader ("usuarios.txt");
	        br = new BufferedReader(fr); 
	        String linea = br.readLine();
	        while((linea != null)){
	        	String[] parts = linea.split("-");
	        	 Usuario usr= new Usuario();
	        	usr.setNombre(parts[0]);
	        	usr.setPresupuesto((Double.valueOf(parts[1]))) ;
	        	usr.setTiempoDisponible((Double.valueOf(parts[2])));
	        	this.usuarios.add(usr);
	            linea = br.readLine();
	        					  }
	        }
	    catch(IOException e){
	        e.printStackTrace();
	    }finally{
	        try{                    
	            if(fr != null){   
	                fr.close();     
	            			  }                  
	           }catch (Exception e2){ 
	            e2.printStackTrace();
	        					    }
	     	    }
	}

	public void cargarPromociones() {		
		FileReader fr = null;
	    BufferedReader br = null;
	    try {
	        fr = new FileReader ("promociones.txt");
	        br = new BufferedReader(fr); 
	        Atraccion atr;
	        String linea = br.readLine();
	        while((linea != null)){
	        	 Promocion prom= new Promocion();
	        	String[] parts = linea.split("-");
	        	prom.setNombre(parts[0]);
	        	prom.setTipo(TipoPromocion.valueOf(parts[1]));
	        	
	        	switch(parts[1]) {
	        	case "PORCENTUAL": {
	        		double tota=0;
	        		double tiempoTota =0;
	        		for (int i= 1; i<=Integer.valueOf(parts[2]);i++) {
	        			atr= this.buscarAtraccion(parts[2+i]);
	        			prom.agregarAtraccion(atr);
	        			tota+= atr.getCosto();
	        			tiempoTota+= atr.getTiempo();
	        		}
	        		double mult= (Double.valueOf(parts[3+Integer.valueOf(parts[2])]))/100 ;
	        		prom.setTot(tota*(1-mult));
	        		prom.setTiempoTot(tiempoTota);
	        		break;
	        	}
	        	
	        	case "ABSOLUTA": {
	        		double tiempoTota =0;
	        		for (int i= 1; i<=Integer.valueOf(parts[2]);i++) {
	        			atr= this.buscarAtraccion(parts[2+i]);
	        			tiempoTota+= atr.getTiempo();
	        			prom.agregarAtraccion(atr);
	        		}
	        		prom.setTot(Double.valueOf(parts[3+Integer.valueOf(parts[2])]));
	        		prom.setTiempoTot(tiempoTota);
	        		break;
	        	}
	        	case "AXB":{
	        		double tota=0;
	        		double tiempoTota =0;
	        		int cant = Integer.valueOf(parts[2]) - Integer.valueOf(parts[3]);
	        		for (int i= 1; i<=Integer.valueOf(parts[2]);i++) {
	        			atr= this.buscarAtraccion(parts[3+i]);
	        			if(cant!=0) {
	        			prom.agregarAtraccion(atr);
	        			tota+= atr.getCosto();
	        			tiempoTota+= atr.getTiempo();
	        			cant -= 1;
	        		}
	        			else {
	        				tiempoTota+= atr.getTiempo();
	        				prom.agregarAtraccion(atr);
	        			}
	        		}
	        		prom.setTot(tota);
	        		prom.setTiempoTot(tiempoTota);
	        	}
	        	break;
	        	}
	        	
	        	this.promociones.add(prom);
	            linea = br.readLine();
	        					  }        
	        }
	    catch(IOException e){
	        e.printStackTrace();
	    }finally{
	        try{                    
	            if(fr != null){   
	                fr.close();     
	            			  }                  
	           }catch (Exception e2){ 
	            e2.printStackTrace();
	        					    }
	     	    }
	}

	public void cargar() {
		this.cargarAtracciones();
		this.cargarPromociones();
		this.cargarUsuarios();
	}
	
	public Atraccion buscarAtraccion(String atraccion ) {
	for(Atraccion atrac : atracciones) {
		if(atrac.getNombre().equals(atraccion)) {
			return atrac;
		}
	}
	return null;

}

	public ArrayList<Promocion> ordenarPromociones(double oro, double tiempo){
		ArrayList<Promocion> listaProm = this.promociones.stream().sorted((o1, o2)->o2.getTiempoTot().
                compareTo(o1.getTiempoTot())).
                collect(Collectors.toCollection(ArrayList::new));
		 listaProm = listaProm.stream().sorted((o1, o2)->o2.getTot().
                compareTo(o1.getTot())).
                collect(Collectors.toCollection(ArrayList::new));
		for(Promocion prom: listaProm) {
			if(prom.getTot()>oro || prom.getTiempoTot()>tiempo ) {
				listaProm.remove(prom);
			}
		}
		
		return listaProm;
	}

	public ArrayList<Atraccion> ordenarAtracciones(double oro, double tiempo){
		ArrayList<Atraccion> listaAtr = this.atracciones.stream().sorted((o1, o2)->o2.getTiempo().
                compareTo(o1.getTiempo())).
                collect(Collectors.toCollection(ArrayList::new));
		 listaAtr = listaAtr.stream().sorted((o1, o2)->o2.getCosto().
                compareTo(o1.getCosto())).
                collect(Collectors.toCollection(ArrayList::new));
		for(Atraccion atr: listaAtr) {
			if(atr.getCosto()>oro || atr.getTiempo()>tiempo ) {
				listaAtr.remove(atr);
			}
		}
		
		return listaAtr;
	}


	public ArrayList<Atraccion> quitarAtraccionesAdquiridas(ArrayList<Atraccion> atraccionesAOfrecer, ArrayList<Atraccion> atraccionesAdquiridas){
		atraccionesAOfrecer.removeAll(atraccionesAdquiridas);
		return atraccionesAOfrecer;
	}
	
	

	
	
}
