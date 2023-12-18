package ej2Ordenacion;

import java.util.ArrayList;
import java.util.Collections;


public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> telefonos = new ArrayList<>();
		
		telefonos.add("556555555");
		telefonos.add("981555555");
		telefonos.add("666666666");
		telefonos.add("982555555");
		telefonos.add("986555555");
		telefonos.add("+44776666666");
		telefonos.add("+34666666666");
		telefonos.add("+34981565656");
			
		Collections.sort(telefonos, new ComparadorTelefonos());
		
		for (String tlf: telefonos) {
			System.out.println(tlf);
		}
	
	}

}
