package ejercicio1Pruebas;

import java.util.Map;
import java.util.Scanner;

public class PruebaMenu {

	public static void main(String[] args) {
		// Instanciamos objetos de la clase Empresa y Trabajador: Constructor por paso de parámetros
		Empresa empresaInfo = new Empresa("H-12345678","Pollos Hermanos Ltd.","Albuquerque - New Mexico",234); 
		Trabajador trabajadorInfo = new Trabajador(empresaInfo,"12345678H","Gustavo","Fring",54, "Snatiago - Chile");
		// Constuimos Menu utilizando la estructura switch
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
				System.out.println("Ha elegido DAR DE ALTA UN EMPLEADO POR TECLADO");
				System.out.println("************ DATOS DE LA EMPRESA DEL TRABAJADOR ****************");
				System.out.println("Introduzca el CIF de la empresa");
				String cif = sc.nextLine();
				System.out.println("Introduzca el nombre de la empresa");
				String nomEmpresa = sc.nextLine();
				System.out.println("Introduzca la dirección de la empresa");
				String dirEmpresa = sc.nextLine();
				System.out.println("Introduzca el número de trabajadores de la empresa");
				int empEmpresa = sc.nextInt();
				sc.nextLine();
				// Instanciamos objeto Empresa
				Empresa empresaAlta = new Empresa(cif,nomEmpresa,dirEmpresa,empEmpresa);
				System.out.println("******************** DATOS DEL TRABAJADOR **********************");
				String dniTrabajador;
				boolean validarDni;
				do {
					System.out.println("Introduzca el DNI del trabajador: ");
					dniTrabajador = sc.nextLine();
					validarDni = Funciones.validarDNI(dniTrabajador);
				} while(!validarDni); // } while(validarDni == false);
				System.out.println("Validación realizada! DNI correcto!");
				System.out.println("Introduzca el nombre del trabajador");
				String nomTrabajador = sc.nextLine();
				System.out.println("Introduzca los apellidos del trabajador");
				String apeTrabajador = sc.nextLine();
				System.out.println("Introduzca el lugar de nacimiento del trabajador");
				String lugNacTrabajador = sc.nextLine();
				int edadTrabajador;
				do {
					System.out.println("Introduzca la edad del trabajador: ");
					edadTrabajador = sc.nextInt();
				} while(!(edadTrabajador > 16 && edadTrabajador <= 70));
				System.out.println("Validación realizada! Edad correcta!");
				// Instancimos un objeto de la clase Trabajador
				Trabajador trabajadorAlta = new Trabajador(empresaAlta,dniTrabajador,nomTrabajador,apeTrabajador,edadTrabajador,lugNacTrabajador);
				System.out.println(empresaAlta.toString());
				System.out.println(trabajadorAlta.toString());
				break;
			case "INFO":
				System.out.println("Ha elegido MOSTRAR LA INFORMACIÓN DEL EMPLEADO");
				System.out.println(trabajadorInfo.toString());
				break;
			case "CADENA":
				System.out.println("Ha elegido: DAR DE ALTA UN EMPLEADO POR CADENA Y MOSTRAR INFO EMPLEADO");
				String cadena = "45666783L:Juan:Lopez:45:Ourense|A80192727:Los hermanos S.L.:Calle Principal 5, Lugo|22";
				Map<String, String> dictTokens = Funciones.romperCadenaTipo1(cadena);
				Trabajador trabajadorCadena = new Trabajador(dictTokens);
				System.out.println(trabajadorCadena.toString());
				System.out.println(trabajadorCadena.getEmpresa().toString());
				break;
			default:
				System.out.println("ERROR: La opción elegida no se encuentra disponible en las funcionalidades del programa!");
		}
		System.out.println("************************************************************************");
		sc.close();
	
	}

}
