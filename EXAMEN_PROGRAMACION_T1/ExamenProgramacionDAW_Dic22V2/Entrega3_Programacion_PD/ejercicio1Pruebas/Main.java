package ejercicio1Pruebas;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;

import ejercicio1.FuncionesValidacionDni;

import java.util.Map;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		
		// Creamos instancias de Empresa y trabajador con el constructor por defecto
		/*Empresa empresa = new Empresa();
		Trabajador trabajador = new Trabajador();
		trabajador.setEmpresa(empresa);
		// Creamos Menú
		System.out.println("************************************************************************");
		System.out.println("                                 MENÚ                                   ");
		System.out.println("************************************************************************");
		System.out.println("ALTA: Alta de empleado\nINFO: Mostrar información del empleado\nCADENA: Entrada de datos por cadena especial y mostrar el nuevo empleado");
		System.out.println("************************************************************************");
		System.out.println("Introduzca por teclado la opción deseada:");
		Scanner sc = new Scanner(System.in);
		String menu = sc.nextLine();
		System.out.println("************************************************************************");
		switch(menu) {
			case "ALTA":
				System.out.println("Ha elegido: ALTA DE EMPLEADO POR TECLADO");
				System.out.println("************ DATOS DE LA EMPRESA DEL TRABAJADOR ****************");
				System.out.println("Introduzca el CIF de la empresa");
				empresa.setCif(sc.nextLine());
				System.out.println("Introduzca el nombre de la empresa");
				empresa.setNombre(sc.nextLine());
				System.out.println("Introduzca la dirección de la empresa");
				empresa.setDireccion(sc.nextLine());
				System.out.println("Introduzca el número de trabajadores de la empresa");
				empresa.setNumEmpleados(sc.nextInt());
				sc.nextLine();
				System.out.println("******************** DATOS DEL TRABAJADOR **********************");
				String dni;
				boolean validarDni;
				do {
					System.out.println("Introduzca el DNI del trabajador: ");
					dni = sc.nextLine();
					// validar = validarDNI(dni);
					validarDni = validarDNIV2(dni);
				}while(!validarDni);
				System.out.println("Validación realizada! DNI correcto!");
				trabajador.setDni(dni);
				System.out.println("Introduzca el nombre del trabajador");
				trabajador.setNombre(sc.nextLine());
				System.out.println("Introduzca los apellidos del trabajador");
				trabajador.setApellidos(sc.nextLine());
				System.out.println("Introduzca el lugar de nacimiento del trabajador");
				trabajador.setLugarNac(sc.nextLine());
				int edad;
				do {
					System.out.println("Introduzca la edad del trabajador: ");
					edad = sc.nextInt();
				}while(!(edad > 16 && edad <= 70));
				System.out.println("Validación realizada! Edad correcta!");
				trabajador.setEdad(edad);
				break;
			case "INFO":
				System.out.println("Ha elegido: MOSTRAR INFORMACIÓN DE EMPLEADO");
				System.out.println(trabajador.toString());
				break;
			case "CADENA":
				System.out.println("Ha elegido: ALTA EMPLEADO POR CADENA Y MOSTRAR INFO EMPLEADO");
				break;
			default:
				System.out.println("ERROR: La opción elegida no se encuentra disponible en las funcionalidades del programa!");
		}*/
		
		/*Scanner sc = new Scanner(System.in);
		System.out.println("**************** EMPRESA *****************");
		System.out.println("Introduzca el CIF de la empresa");
		String cif = sc.nextLine();
		System.out.println("Introduzca el nombre de la empresa");
		String nomEmpresa = sc.nextLine();
		System.out.println("Introduzca la dirección de la empresa");
		String dirEmpresa = sc.nextLine();
		System.out.println("Introduzca el número de trabajadores de la empresa");
		int trabEmpresa = sc.nextInt();
		sc.nextLine();
		System.out.println("**************** TRABAJADOR *****************");
		System.out.println("Introduzca el DNI del trabajor");
		String dni = sc.nextLine();
		System.out.println("Introduzca el nombre del trabajador");
		String nomTrabajador = sc.nextLine();
		System.out.println("Introduzca los apellidos del trabajador");
		String apellTrabajador = sc.nextLine();
		System.out.println("Introduzca el lugar de nacimiento del trabajador");
		String lugTrabajador = sc.nextLine();
		System.out.println("Introduzca la edad del trabajador");
		int edadTrabajador = sc.nextInt();
		sc.close();
		// Instanciamos Empresa
		Empresa e1 = new Empresa(cif,nomEmpresa,dirEmpresa,trabEmpresa);
		System.out.println(e1.toString());
		// Instanciamos Trabajador
		Trabajador t1 = new Trabajador(e1,dni,nomTrabajador,apellTrabajador,edadTrabajador,lugTrabajador);
		System.out.println(t1.toString());*/
		
		
		/*String cadena = "45666783L:Juan:Lopez:45:Ourense|A80192727:Los hermanos S.L.:Calle Principal 5, Lugo|22";
		Scanner scC = new Scanner(cadena);
		scC.useDelimiter("\\|");
		String cadena1 = scC.next();
		// System.out.println(cadena1);
		Scanner sc1 = new Scanner(cadena1);
		sc1.useDelimiter(":");
		String dni = sc1.next();
		String nombre = sc1.next();
		String apellidos = sc1.next();
		int edad = sc1.nextInt();
		String lugar = sc1.next();
		String cadena2 = scC.next();
		// System.out.println(cadena2);
		Scanner sc2 = new Scanner(cadena2);
		sc2.useDelimiter(":");
		String cif = sc2.next();
		String nomEmpresa = sc2.next();
		String direccion = sc2.next();
		int empleados = scC.nextInt();
		Empresa empresaCadena = new Empresa(cif,nomEmpresa,direccion,empleados);
		System.out.println(empresaCadena.toString());
		Trabajador trabajadorCadena = new Trabajador(empresaCadena,dni,nombre,apellidos,edad,lugar);
		System.out.println(trabajadorCadena.toString());
		scC.close();
		sc1.close();
		sc2.close();*/
		
		/*scC.useDelimiter("\\|");
		while (scC.hasNext()) {
			String cadenaSplit = scC.next();
			Scanner sc1 = new Scanner(cadenaSplit);
			sc1.useDelimiter(":");
			while (sc1.hasNext()) {
				System.out.println(sc1.next());
			}
		}*/
		
		/*String cadena = "45666783L:Juan:Lopez:45:Ourense|A80192727:Los hermanos S.L.:Calle Principal 5, Lugo|22";
		Trabajador trabajadorCadena = new Trabajador(cadena);
		System.out.println(trabajadorCadena.toString());
		System.out.println(trabajadorCadena.getEmpresa().toString());*/
		
		//String dni = "45666783L";
		/*String dni;
		int contLetra, contDigito, posLetra;
		Scanner sc = new Scanner(System.in);
		do {
			contLetra=0;
			contDigito=0;
			posLetra=0;
			System.out.println("Introduzca su DNI: ");
			dni = sc.nextLine();
			for (int i=0; i<dni.length(); i++) {
				if ((dni.charAt(i)>='a' && dni.charAt(i)<='z') || (dni.charAt(i) >='A' && dni.charAt(i) <='Z')) {
					contLetra++;
					posLetra=i+1;
				}
				if (dni.charAt(i) >='0' && dni.charAt(i) <='9') {
					contDigito++;
				}
			}
			System.out.println("Digitos = " + contDigito);
			System.out.println("Letras = " + contLetra);
			System.out.println("PosLetra = " + posLetra);
		}while(!(contDigito == 8 && contLetra == 1 && posLetra == 9));
		sc.close();
		System.out.println("Validación realizada! DNI correcto!");*/
		
		/*boolean flag = true;
		contLetra=0;
		contDigito=0;
		while(flag) {
			System.out.println("Introduzca su DNI: ");
			dni = sc.nextLine();
			for (int i=0; i<dni.length(); i++) {
				ch = dni.charAt(i);
				if ((ch>='a' && ch<='z') || (ch>='A' && ch <='Z')) {
					contLetra++;
				}
				if (ch>='0' && ch<='9') {
					contDigito++;
				}
			}
			if (contDigito == 8 && contLetra == 1) {
				flag = false;
			}
			else {
				contLetra=0;
				contDigito=0;
			}
		}
		System.out.println("Digitos = " + contDigito);
		System.out.println("Letras = " + contLetra);*/
		
		
		/*String dni;
		int contLetra, contDigito;
		Scanner sc = new Scanner(System.in);
		do {
			contLetra=0;
			contDigito=0;
			System.out.println("Introduzca su DNI: ");
			dni = sc.nextLine();
			contLetra = obtenerLetrasDNI(dni);
			contDigito = obtenerDigitosDNI(dni);
			System.out.println("Digitos = " + contDigito);
			System.out.println("Letras = " + contLetra);
		}while(!(contDigito == 8 && contLetra == 1));
		sc.close();
		System.out.println("Validación realizada! DNI correcto!");*/
		
		
		/*String dni;
		boolean validar;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Introduzca su DNI: ");
			dni = sc.nextLine();
			// validar = validarDNI(dni);
			validar = validarDNIV2(dni);
			//System.out.println(validar);
		}while(!validar);
		sc.close();
		System.out.println("Validación realizada! DNI correcto!");*/
		
		
		
		// StringTokenizer
		/*String cadena = "45666783L:Juan:Lopez:45:Ourense|A80192727:Los hermanos S.L.:Calle Principal 5, Lugo|22";
		StringTokenizer st = new StringTokenizer(cadena,"|"); 
		String cadena1 = st.nextToken();
		StringTokenizer st1 = new StringTokenizer(cadena1,":"); 
		String dni = st1.nextToken();
		String nombre = st1.nextToken();
		String apellidos = st1.nextToken();
		int edad = Integer.parseInt(st1.nextToken());
		String lugar = st1.nextToken();
		String cadena2 = st.nextToken();
		StringTokenizer st2 = new StringTokenizer(cadena2,":"); 
		String cif = st2.nextToken();
		String nomEmpresa = st2.nextToken();
		String direccion = st2.nextToken();	
		String cadena3 = st.nextToken();
		int empleados = Integer.parseInt(cadena3);
		Empresa empresaCadena = new Empresa(cif,nomEmpresa,direccion,empleados);
		System.out.println(empresaCadena.toString());
		Trabajador trabajadorCadena = new Trabajador(empresaCadena,dni,nombre,apellidos,edad,lugar);
		System.out.println(trabajadorCadena.toString());*/
		
		// StringTokenizer con ArrayList
		/*String cadena = "45666783L:Juan:Lopez:45:Ourense|A80192727:Los hermanos S.L.:Calle Principal 5, Lugo|22";
		StringTokenizer st = new StringTokenizer(cadena,"|");  
		ArrayList<String> listaTokens = new ArrayList<String>();
		while (st.hasMoreTokens()) {
			StringTokenizer st1 = new StringTokenizer(st.nextToken(),":"); 
			while (st1.hasMoreTokens()) {
				listaTokens.add(st1.nextToken());
			}
		}
		
		for (String token: listaTokens) {
			System.out.println(token);
		}*/
		
		
		// StringTokenizer con HashMap
		/*String cadena = "45666783L:Juan:Lopez:45:Ourense|A80192727:Los hermanos S.L.:Calle Principal 5, Lugo|22";
		StringTokenizer st = new StringTokenizer(cadena,"|");  
		String[] claves = {"dni","nombre","apellidos","edad","lugNac","cif","nomEmp","dirEmp","numEmp"};
		Map<String,String> dictTokens = new HashMap<>();
		int i=0;
		while (st.hasMoreTokens()) {
			StringTokenizer st1 = new StringTokenizer(st.nextToken(),":"); 
			while (st1.hasMoreTokens()) {
				dictTokens.put(claves[i],st1.nextToken());
				i++;
			}
		}
		Empresa empresaCadena = new Empresa(dictTokens.get("cif"),dictTokens.get("nomEmp"),dictTokens.get("dirEmp"),Integer.parseInt(dictTokens.get("numEmp")));
		System.out.println(empresaCadena.toString());
		Trabajador trabajadorCadena = new Trabajador(empresaCadena,dictTokens.get("dni"),dictTokens.get("nombre"),dictTokens.get("apellidos"),Integer.parseInt(dictTokens.get("edad")),dictTokens.get("lugar"));
		System.out.println(trabajadorCadena.toString());*/
		
		
		// StringTokenizer con HashMap y Función static romperCadenaTipo1
		/*String cadena = "45666783L:Juan:Lopez:45:Ourense|A80192727:Los hermanos S.L.:Calle Principal 5, Lugo|22";
		Map<String, String> dictTokens = Funciones.romperCadenaTipo1(cadena);
		Empresa empresaCadena = new Empresa(dictTokens.get("cif"),dictTokens.get("nomEmp"),dictTokens.get("dirEmp"),Integer.parseInt(dictTokens.get("numEmp")));
		System.out.println(empresaCadena.toString());
		Trabajador trabajadorCadena = new Trabajador(empresaCadena,dictTokens.get("dni"),dictTokens.get("nombre"),dictTokens.get("apellidos"),Integer.parseInt(dictTokens.get("edad")),dictTokens.get("lugar"));
		System.out.println(trabajadorCadena.toString());*/
		
		// Constructor Map
		/*String cadena = "45666783L:Juan:Lopez:45:Ourense|A80192727:Los hermanos S.L.:Calle Principal 5, Lugo|22";
		Map<String, String> dictTokens = Funciones.romperCadenaTipo1(cadena);
		Trabajador trabajadorCadena = new Trabajador(dictTokens);
		System.out.println(trabajadorCadena.toString());
		System.out.println(trabajadorCadena.getEmpresa().toString());*/
		
		// Método setFromString
		/*
		String cadena = "45666783L:Juan:Lopez:45:Ourense|A80192727:Los hermanos S.L.:Calle Principal 5, Lugo|22";
		Trabajador trabajador = new Trabajador();
		Empresa empresa = new Empresa();
		trabajador.setEmpresa(empresa);
		trabajador.setFromString(cadena);
		System.out.println(trabajador.toString());
		System.out.println(trabajador.getEmpresa().toString());*/
		
		// Método obtener LetraDNi
		//String strDigitosDni = "76499677";
		//System.out.println(Funciones.obtenerLetraDNI(strDigitosDni));
		
		// Validar DNI con Letra
		/*String dni;
		boolean validar;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Introduzca su DNI: ");
			dni = sc.nextLine();
			validar = Funciones.validarDNIV3(dni);
			if(!validar) {
				System.out.println("ERROR: DNI no valido!");
			}
		}while(!validar);
		sc.close();
		System.out.println("Validación realizada! DNI correcto!");*/
		// Leer y validar DNI con Letra
		// Scanner sc = new Scanner(System.in);
		// String dni = Funciones.leerValidarDNI(sc);
		// System.out.println(dni);
		// String entrada = sc.nextLine();
		// System.out.println(entrada.length());
		
		/*String cif = "     ";
		if (cif.isEmpty() || cif.isBlank()) {
			System.out.println("ERROR: Campo obligatrio!");
		}*/
		
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el CIF de la empresa");
		String cif = Funciones.leerValidarEntrada(sc);		
		System.out.println("Introduzca el nombre de la empresa");
		String nombre = Funciones.leerValidarEntrada(sc);
		System.out.println("Introduzca el Direccion de la empresa");
		String direccion = Funciones.leerValidarEntrada(sc);
		System.out.println("CIF: " + cif + "\nNombre: " + nombre + "\nDirección: " + direccion);*/
		
		
	}
	
	private static int obtenerLetrasDNI(String dni) {
		int contLetra = 0;
		for (int i=0; i<dni.length(); i++) {
			if ((dni.charAt(i)>='a' && dni.charAt(i)<='z') || (dni.charAt(i) >='A' && dni.charAt(i) <='Z')) {
				contLetra++;
			}
		}
		return contLetra;
	}
	
	private static int obtenerDigitosDNI(String dni) {
		int contDigito = 0;
		for (int i=0; i<dni.length(); i++) {
			if (dni.charAt(i) >='0' && dni.charAt(i) <='9') {
				contDigito++;
			}
		}
		return contDigito;
	}
	
	private static boolean validarDNI(String dni) {
		boolean validar;
		int contLetra = 0;
		int contDigito = 0;
		for (int i=0; i<dni.length(); i++) {
			if ((dni.charAt(i)>='a' && dni.charAt(i)<='z') || (dni.charAt(i) >='A' && dni.charAt(i) <='Z')) {
				contLetra++;
			}
			if (dni.charAt(i) >='0' && dni.charAt(i) <='9') {
				contDigito++;
			}
		}
		if (contDigito == 8 && contLetra == 1) {
			validar = true;
		}
		else {
			validar = false;
		}
		return validar;
	}

		
	/*private static boolean validarDNIV2(String dni) {
		boolean validar;
		int contLetra = obtenerLetrasDNI(dni);
		int contDigito = obtenerDigitosDNI(dni);
		if (contDigito == 8 && contLetra == 1) {
			validar = true;
		}
		else {
			validar = false;
		}
		return validar;*/
}
	
	

