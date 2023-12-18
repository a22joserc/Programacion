package ejemplosmapas;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EjemploMapas {

	public static void main(String[] args) {
		Map<String, String> mapCountryCodes = new HashMap<>();
		 
		mapCountryCodes.put("1", "USA");
		mapCountryCodes.put("44", "United Kingdom");
		mapCountryCodes.put("33", "France");
		mapCountryCodes.put("81", "Japan");
		
		// Generamos un set de las keys
		Set<String> setCodes = mapCountryCodes.keySet();
		Iterator<String> iterator = setCodes.iterator();
		 
		while (iterator.hasNext()) {
		    String code = iterator.next();
		    String country = mapCountryCodes.get(code);
		    System.out.println(code + " = > " + country);
		}
		
		System.out.println("**************************");
		
		for (String code:setCodes) {
			System.out.println(code + " = > " + mapCountryCodes.get(code));
			
		}
		
		System.out.println("**************************");
		
		mapCountryCodes.remove("1");
		
		// Devuelve los objetos almacenados en el map
		Collection<String> countries = mapCountryCodes.values();
		 
		for (String country : countries) {
		    System.out.println(country);
		}
		
		System.out.println("**************************");
		
		// Método entrySet()
		Set<Map.Entry<String, String>> entries = mapCountryCodes.entrySet();
		 
		for (Map.Entry<String, String> entry : entries) {
		    String code = entry.getKey();
		    String country = entry.getValue();
		 
		    System.out.println(code + " => " + country);
		}
		
		System.out.println("**************************");
		// Método for-each lambda
		
		// mapCountryCodes.forEach((code, country) -> System.out.println(code + " => " + country));
		// mapCountryCodes.forEach((code, country) -> mapCountryCodes.replace(code, "BoniLandia"));
		mapCountryCodes.replace("81", "BoniLandia");
		mapCountryCodes.forEach((code, country) -> System.out.println(code + " => " + country));
		

	}

}
