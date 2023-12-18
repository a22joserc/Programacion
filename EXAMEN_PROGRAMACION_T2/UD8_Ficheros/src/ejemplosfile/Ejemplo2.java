package ejemplosfile;

import java.io.File;

public class Ejemplo2 {

	public static void main(String[] args) {
		String directorio = "E:/micarpeta";
        String varios = "carpeta1/carpeta2/carpeta3";
        // Crear un directorio
        boolean exito = (new File(directorio)).mkdir();
        if (exito) {
            System.out.println("Directorio: " + directorio + " creado");
        }
        // Crear varios directorios
        exito = (new File(directorio+"//"+varios)).mkdirs();
        if (exito) {
            System.out.println("Directorios: " + varios + " creados");
        }
		
	}

}
