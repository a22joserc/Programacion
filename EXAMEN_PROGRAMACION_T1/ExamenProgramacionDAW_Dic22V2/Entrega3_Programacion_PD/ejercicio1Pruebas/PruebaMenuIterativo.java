package ejercicio1Pruebas;
import java.util.Scanner;

public class PruebaMenuIterativo {
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
					String cif;
					do {
						System.out.println("Introduzca el CIF de la empresa");
						cif = sc.nextLine();
						if (cif.isEmpty() || cif.isBlank()) {
							System.out.println("ERROR: Campo alfanumérico obligatrio!");
						}
					} while(cif.isEmpty() == true || cif.isBlank() == true);
					empresa.setCif(cif);
					// ---------------------------- NOMBRE EMPRESA -------------------------------------
					String nomEmpresa;
					do {
						System.out.println("Introduzca el nombre de la empresa");
						nomEmpresa = sc.nextLine();
						if (nomEmpresa.isEmpty() || nomEmpresa.isBlank()) {
							System.out.println("ERROR: Campo alfanumérico obligatrio!");
						}
					} while(nomEmpresa.isEmpty() == true || nomEmpresa.isBlank() == true);
					empresa.setNombre(nomEmpresa);
					// ---------------------------- DIRECCIÓN EMPRESA ----------------------------------
					String dirEmpresa;
					do {
						System.out.println("Introduzca la dirección de la empresa");
						dirEmpresa = sc.nextLine();
						if (dirEmpresa.isEmpty() || dirEmpresa.isBlank()) {
							System.out.println("ERROR: Campo alfanumérico obligatrio!");
						}
					} while(dirEmpresa.isEmpty() == true || dirEmpresa.isBlank() == true);
					empresa.setDireccion(dirEmpresa);
					// ---------------------------- NÚMERO TRABAJADORES EMPRESA ------------------------
					String strEmpEmpresa;
					do {
						System.out.println("Introduzca el número de trabajadores de la empresa");
						strEmpEmpresa = sc.nextLine();
						if (strEmpEmpresa.isEmpty() || strEmpEmpresa.isBlank()) {
							System.out.println("ERROR: Campo alfanumérico obligatrio!");
						}
					} while(strEmpEmpresa.isEmpty() == true || strEmpEmpresa.isBlank() == true);
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
					trabajador.setDni(dniTrabajador);
					// ---------------------------- NOMBRE TRABAJADOR -----------------------------------
					String nomTrabajador;
					do {
						System.out.println("Introduzca el nombre del trabajador");
						nomTrabajador = sc.nextLine();
						if (nomTrabajador.isEmpty() || nomTrabajador.isBlank()) {
							System.out.println("ERROR: Campo alfanumérico obligatrio!");
						}
					} while(nomTrabajador.isEmpty() == true || nomTrabajador.isBlank() == true);
					trabajador.setNombre(nomTrabajador);
					// ---------------------------- APELLIDOS TRABAJADOR -----------------------------------
					String apeTrabajador;
					do {
						System.out.println("Introduzca los apellidos del trabajador");
						apeTrabajador = sc.nextLine();
						if (apeTrabajador.isEmpty() || apeTrabajador.isBlank()) {
							System.out.println("ERROR: Campo alfanumérico obligatrio!");
						}
					} while(apeTrabajador.isEmpty() == true || apeTrabajador.isBlank() == true);
					trabajador.setApellidos(apeTrabajador);
					// ------------------------------- LUGAR NACIMIENTO ------------------------------------
					String lugNacTrabajador;
					do {
						System.out.println("Introduzca el lugar de nacimiento del trabajador: ");
						lugNacTrabajador = sc.nextLine();
						if (lugNacTrabajador.isEmpty() || lugNacTrabajador.isBlank()) {
							System.out.println("ERROR: Campo alfanumérico obligatrio!");
						}
					}while(lugNacTrabajador.isEmpty() == true || lugNacTrabajador.isBlank() == true);
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
