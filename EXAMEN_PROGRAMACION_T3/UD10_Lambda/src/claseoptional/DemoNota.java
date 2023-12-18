package claseoptional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DemoNota {
	
	public static void main(String[] args) {

	    List<Nota> notas= new ArrayList<Nota>();
	    notas.add(new Nota("matematicas",3));
	    notas.add(new Nota("lengua",8));
	    notas.add(new Nota("ingles",5));
	    notas.add(new Nota("fisica",7));
	    
	    Nota nota = buscarNotaSobresaliente(notas);

	    // Estas sentencias nos pueden generar el típico java.lang.NullPointerExcepcion
	    if (nota !=null) {
	    	System.out.println(nota.getValor());
	    	System.out.println(nota.getAsignatura());
	    }
	    
	    
	    notas.add(new Nota("Informática",10));
	    
	    Optional<Nota> oNota = buscarNotaSobresalienteOptional(notas);
	    
	    if(oNota.isPresent()) {
	    	Nota notaOptional = oNota.get();
	    	System.out.println(notaOptional.getValor());
	    	System.out.println(notaOptional.getAsignatura());
	    } 
	    
	  }
	
	public static Nota buscarNotaSobresaliente(List<Nota> notas) {
		
		for(Nota nota:notas) {
			if(nota.getValor()>=9) {
				return nota;
			}
		}
		return null;
	}
	
	
	public static Optional<Nota> buscarNotaSobresalienteOptional(List<Nota> notas) {
		
		for(Nota nota:notas) {
			if(nota.getValor()>=9) {
				return Optional.of(nota);
			}
		}
		return Optional.empty();
	}
	
	
}
