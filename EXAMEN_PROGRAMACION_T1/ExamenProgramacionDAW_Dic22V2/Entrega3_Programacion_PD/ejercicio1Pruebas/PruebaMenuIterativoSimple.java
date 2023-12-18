package ejercicio1Pruebas;

import java.util.Scanner;

public class PruebaMenuIterativoSimple {
	
	public static void main(String[] args) {
		
		String salirMenu;
		// Instanciamos objetos de la clase Empresa y Trabajador: Constructor por defecto
		Empresa empresa = new Empresa(); 
		Trabajador trabajador = new Trabajador();
		trabajador.setEmpresa(empresa);
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("************************************************************************");
			System.out.println("                                 MENÚ                                   ");
			System.out.println("************************************************************************");
			System.out.println("ALTA: Alta de empleado\nINFO: Mostrar información del empleado\nCADENA: Entrada de datos por cadena especial y mostrar el nuevo empleado");
			System.out.println("************************************************************************");
			System.out.println("Introduzca por teclado la opción deseada:");
			String menu = sc.nextLine();
			System.out.println("************************************************************************");
			switch(menu) {
				case "ALTA":
					System.out.println("Ha elegido DAR DE ALTA UN EMPLEADO POR TECLADO");
					System.out.println("************ DATOS DE LA EMPRESA DEL TRABAJADOR ****************");
					// ----------------------------- CIF -----------------------------------------------
					System.out.println("Introduzca el CIF de la empresa");
					String cif = Funciones.leerValidarEntrada(sc);		
					empresa.setCif(cif);
					// ---------------------------- NOMBRE EMPRESA -------------------------------------
					System.out.println("Introduzca el nombre de la empresa");
					String nomEmpresa = Funciones.leerValidarEntrada(sc);
					empresa.setNombre(nomEmpresa);
					// ---------------------------- DIRECCIÓN EMPRESA ----------------------------------
					System.out.println("Introduzca la dirección de la empresa");
					String dirEmpresa = Funciones.leerValidarEntrada(sc);
					empresa.setDireccion(dirEmpresa);
					// ---------------------------- NÚMERO TRABAJADORES EMPRESA ------------------------
					System.out.println("Introduzca el número de trabajadores de la empresa");
					String strEmpEmpresa = Funciones.leerValidarEntrada(sc);
					int empEmpresa = Integer.parseInt(strEmpEmpresa);
					empresa.setNumEmpleados(empEmpresa);
					System.out.println("******************** DATOS DEL TRABAJADOR **********************");
					// ----------------------------------------- DNI ------------------------------------
					String dniTrabajador;
					boolean validarDni;
					do {
						System.out.println("Introduzca el DNI del trabajador: ");
						dniTrabajador = sc.nextLine();
						validarDni = Funciones.validarDNIV3(dniTrabajador);
						if(!validarDni) {
							System.out.println("ERROR: DNI no valido!");
						}
					} while(!validarDni); // } while(validarDni == false);
					System.out.println("Validación realizada! DNI correcto!");
					// ---------------------------- NOMBRE TRABAJADOR -----------------------------------
					System.out.println("Introduzca el nombre del trabajador");
					String nomTrabajador = Funciones.leerValidarEntrada(sc);
					trabajador.setNombre(nomTrabajador);
					// ---------------------------- APELLIDOS TRABAJADOR -----------------------------------
					System.out.println("Introduzca los apellidos del trabajador");
					String apeTrabajador = Funciones.leerValidarEntrada(sc);
					trabajador.setApellidos(apeTrabajador);
					// ------------------------------- LUGAR NACIMIENTO ------------------------------------
					System.out.println("Introduzca el lugar de nacimiento del trabajador: ");
					String lugNacTrabajador = Funciones.leerValidarEntrada(sc);
					trabajador.setLugarNac(lugNacTrabajador);
					// ------------------------------- EDAD TRABAJADOR -------------------------------------
					int edadTrabajador;
					do {
						System.out.println("Introduzca la edad del trabajador: ");
						edadTrabajador = sc.nextInt();
					} while(!(edadTrabajador > 16 && edadTrabajador <= 70));
					System.out.println("Validación realizada! Edad correcta!");
					trabajador.setEdad(edadTrabajador);
					sc.nextLine();
					// ------------------------------- DATOS DEL TRABAJADOR ---------------------------------
					System.out.println("RESUMEN DE DATOS DE ALTA DE EMPLEADO: ");
					System.out.println("DATOS EMPRESA: ");
					System.out.println(empresa.toString());
					System.out.println("DATOS PERSONALES: ");
					System.out.println(trabajador.toString());
					break;
				case "INFO":
					System.out.println("Ha elegido MOSTRAR LA INFORMACIÓN DEL EMPLEADO");
					System.out.println(trabajador.toString());
					break;
				case "CADENA":
					System.out.println("Ha elegido: DAR DE ALTA UN EMPLEADO POR CADENA Y MOSTRAR INFO EMPLEADO");
					String cadena = "45666783L:Juan:Lopez:45:Ourense|A80192727:Los hermanos S.L.:Calle Principal 5, Lugo|22";
					trabajador.setFromStringST(cadena);
					System.out.println(trabajador.toString());
					System.out.println(trabajador.getEmpresa().toString());
					break;
				default:
					System.out.println("ERROR: La opción elegida no se encuentra disponible en las funcionalidades del programa!");
			}			
			System.out.println("************************************************************************");
			System.out.println("DESEA SALIR DEL MENU:\nEscriba SI/si en caso afrimativo\nEscriba NO/no en caso negativo");
			System.out.println("************************************************************************");
			salirMenu = sc.nextLine();
		}while(salirMenu.equalsIgnoreCase("NO"));
		sc.close();
		System.out.println("************************** FIN DEL MENÚ ********************************");
		System.out.println("************************************************************************");
		
	}

}
