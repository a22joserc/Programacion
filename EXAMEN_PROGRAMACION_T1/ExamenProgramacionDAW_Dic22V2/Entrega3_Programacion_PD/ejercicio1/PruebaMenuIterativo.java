package ejercicio1;
import java.util.Scanner;

public class PruebaMenuIterativo {
	
	public static void main(String[] args) {
		// INiCIO PROGRAMA
		boolean flagAlta = false;
		boolean flagCadena = false;
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
					flagAlta = true;
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
						validarDni = FuncionesValidacionDni.validarDNIv2(dniTrabajador);
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
					String strEdadTrabajador;
					int edadTrabajador;
					do {
						do {
							System.out.println("Introduzca la edad del trabajador: ");
							strEdadTrabajador = sc.nextLine();
							if (strEdadTrabajador.isEmpty() || strEdadTrabajador.isBlank()) {
								System.out.println("ERROR: Campo alfanumérico obligatrio!");
							}
						} while(strEdadTrabajador.isEmpty() == true || strEdadTrabajador.isBlank() == true);
						edadTrabajador = Integer.parseInt(strEdadTrabajador);
						if (!(edadTrabajador > 16 && edadTrabajador <= 70)) {
							System.out.println("ERROR: La edad del trabajador debe ser mayor de 16 y menor de 70 años");
						}
					} while(!(edadTrabajador > 16 && edadTrabajador <= 70));
					System.out.println("Validación realizada! Edad correcta!");
					trabajador.setEdad(edadTrabajador);
					// ------------------------------- DATOS DEL TRABAJADOR ---------------------------------
					System.out.println("RESUMEN DE DATOS DE ALTA DE EMPLEADO: ");
					System.out.println("DATOS EMPRESA: ");
					System.out.println(empresa.toString());
					System.out.println("DATOS PERSONALES: ");
					System.out.println(trabajador.toString());
					break;
				case "INFO":
					System.out.println("Ha elegido MOSTRAR LA INFORMACIÓN DEL EMPLEADO");
					if (flagCadena==false && flagAlta==false) {
						System.out.println("WARNING: No ha dado de alta ningún empleado por teclado o cadena. Se mostrará la inforamción del constructor por defecto!");
					}
					System.out.println(trabajador.toString());
					break;
				case "CADENA":
					flagCadena = true;
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
			System.out.println("Desea salir de Menú? Escriba SI/si en caso afirmativo o teclee algo para permanecer en el menú!");
			System.out.println("************************************************************************");
			salirMenu = sc.nextLine();
		}while(!salirMenu.equalsIgnoreCase("SI"));
		sc.close();
		System.out.println("************************** FIN DEL MENÚ ********************************");
		System.out.println("************************************************************************");
	}
	

}

