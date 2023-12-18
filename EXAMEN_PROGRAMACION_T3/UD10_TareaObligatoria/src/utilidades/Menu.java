package utilidades;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import excepciones.GestionCarreraException;
import gestioncarrera.Carrera;
import gestioncarrera.Equipo;
import gestioncarrera.GestionCarrera;
import gestioncarrera.Participante;

public class Menu {
	
	
	public static void altaCorredorEquipo(GestionCarrera gestionCarrera, Scanner scanner) {
		String salir;
		do {
			String codigo = Menu.validarCodigoCorredor(scanner);
			String nombre = Menu.validarNombreCorredor(scanner);
			String apellidos = Menu.validarApellidosCorredor(scanner);
			String sexo = Menu.validarSexo(scanner);
			int edad = Menu.validarEdad(scanner);
			Participante participante = new Participante(codigo, nombre, apellidos, sexo, edad);
			gestionCarrera.mostrarEquipos();
			System.out.println("Introduzca el código de equipo al que quiere añadir el corredor:");
			String codigoEquipo = scanner.nextLine();
			try {
				gestionCarrera.addCorredorEquipo(codigoEquipo, participante);
				gestionCarrera.mostrarCorredoresEquipo(codigoEquipo);
			} catch (GestionCarreraException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Desea continuar dando de alta corredores en equipos? SI - NO");
			salir = scanner.nextLine();
		}while(salir.equalsIgnoreCase("si"));
	}
	
	public static void altaEquipoCarrera(GestionCarrera gestionCarrera, Scanner scanner) {
		String salir;
		do {
			gestionCarrera.mostrarEquipos();
			gestionCarrera.mostrarEquiposCarreras();
			String codigoEquipo = Menu.validarCodigoEquipo(scanner);
			String nombreCarrera = Menu.validarNombreCarrera(scanner);
			try {
				gestionCarrera.addEquipoCarrera(nombreCarrera, codigoEquipo);
				gestionCarrera.mostrarEquiposCarrera(nombreCarrera);
			} catch (GestionCarreraException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Desea continuar dando de alta equipos en carreras? SI - NO");
			salir = scanner.nextLine();
		}while(salir.equalsIgnoreCase("si"));
	}
	
	public static void eliminarEquipoCarrera(GestionCarrera gestionCarrera, Scanner scanner) {
		String salir;
		do {
			gestionCarrera.mostrarEquiposCarreras();
			String codigoEquipo = Menu.validarCodigoEquipo(scanner);
			String nombreCarrera = Menu.validarNombreCarrera(scanner);
			try {
				gestionCarrera.removeEquipoCarrera(nombreCarrera, codigoEquipo);
				gestionCarrera.mostrarEquiposCarrera(nombreCarrera);
			} catch (GestionCarreraException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Desea continuar eliminando equipos de carreras? SI - NO");
			salir = scanner.nextLine();
		}while(salir.equalsIgnoreCase("si"));
	}
	
	public static void asignarPremioEquipo(GestionCarrera gestionCarrera, Scanner scanner) {
		String salir;
		do {
			gestionCarrera.mostrarEquiposCarreras();
			String nombreCarrera = Menu.validarNombreCarrera(scanner);
			String codigoEquipo = Menu.validarCodigoEquipo(scanner);
			int pos = Menu.validarPoscionCarrera(scanner);
			try {
				gestionCarrera.addPremioEquipoCarrera(nombreCarrera, codigoEquipo, pos);
			} catch (GestionCarreraException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Desea continuar asignando premios? SI - NO");
			salir = scanner.nextLine();
		}while(salir.equalsIgnoreCase("si"));
	}
	
	public static void mostrarFuncionalidadStream(GestionCarrera gestionCarrera) {
		Equipo equipo = gestionCarrera.getEquipo("EQ_ST_1");
		equipo.mostrarParticipantes();
		System.out.println("Mostramos String apellidos " + equipo.getNombre() + ":");
		System.out.println(equipo.getStringApellidosEquipo());
		System.out.println("************************************************************************");
		System.out.println("Mostramos partipante menor edad " + equipo.getNombre() + ":");
		try {
			Participante participante = equipo.getCorredorMenorEdadStreamV2();
			System.out.println(participante.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("************************************************************************");
		System.out.println("Mostramos los Equipos 2 y 3: ");
		Equipo equipo2 = gestionCarrera.getEquipo("EQ_ST_1");
		equipo2.mostrarParticipantes();
		Equipo equipo3 = gestionCarrera.getEquipo("EQ_ST_2");
		equipo3.mostrarParticipantes();
		List<Participante> listaCombinada = gestionCarrera.combinarEquipoPorSexoCategoria(equipo2, equipo3);
		System.out.println("Lista combinada Sexo:HOMBRE - Categoria:SENIOR ");
		listaCombinada.forEach(p -> System.out.println(p.toString()));
		System.out.println("************************************************************************");
	}
	
	public static void volcarCarreraBaseDatos(GestionCarrera gestionCarrera, Scanner scanner, Connection connection) {
		try {
			if (!ConexionBaseDatos.tablaExiste(connection, "carrera")) {
				System.out.println("************************* IMPORTANTE **********************************");
				System.out.println("Tabla carrera no existe en la base datos, por lo que se procede a su creación!");
				ConexionBaseDatos.crearTablaCarrera(connection);
				System.out.println("************************************************************************");
			}
			String salir;
			do {
				gestionCarrera.mostrarEquiposCarreras();
				String nombreCarrera = Menu.validarNombreCarrera(scanner);
				Carrera carrera = gestionCarrera.getCarrera(nombreCarrera);
				if (carrera != null) {
					carrera.guardarBaseDatos(connection);
				}
				else {
					System.out.println("ERROR: La carrera seleccionada no esta registrada en el sistema!");
				}
				System.out.println("Desea guardando datos de carreras? SI - NO");
				salir = scanner.nextLine();
			}while(salir.equalsIgnoreCase("si"));
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static String validarCodigoEquipo(Scanner scanner) {
		String codigoEquipo;
		do {
			System.out.println("Introduzca el código del equipo: ");
			codigoEquipo = scanner.nextLine();
			if (codigoEquipo.isBlank() || codigoEquipo.isEmpty()) {
				System.out.println("ERROR: El código del equipo no puede estar vacio");
			}
		}while(codigoEquipo.isBlank() || codigoEquipo.isEmpty());
		return codigoEquipo;
	}
	
	public static String validarNombreCarrera(Scanner scanner) {
		String nombreCarrera;
		do {
			System.out.println("Introduzca el nombre de la carrera: ");
			nombreCarrera= scanner.nextLine();
			if (nombreCarrera.isBlank() || nombreCarrera.isEmpty()) {
				System.out.println("ERROR: El nombre de la carrera no puede estar vacio");
			}
		}while(nombreCarrera.isBlank() || nombreCarrera.isEmpty());
		return nombreCarrera;
	}
	
	public static int validarPoscionCarrera(Scanner scanner) {
		boolean flag = true;
		int pos = 0;
		do {
			try {
				System.out.println("Introduzca la posición del podium que quiere asingar al equipo (1,2,3): ");
				pos = Integer.parseInt(scanner.nextLine());
				if (pos < 1 || pos > 3) {
					System.out.println("ERROR: La posición del podium sólo puede ser (1,2,3)");
				}
				else {
					flag = false;
				}
			}
			catch (NumberFormatException e) {
				System.out.println("ERROR: La posición del podium debe ser un número entero!");
			}
		} while(flag);
		return pos;	
	}
	
	
	public static void mostrarCorredoresEquipo(GestionCarrera gestionCarrera, Scanner scanner) {
		String salir;
		do {
			gestionCarrera.mostrarEquipos();
			System.out.println("Introduzca el código de equipo:");
			String codigoEquipo = scanner.nextLine();
			try {
				gestionCarrera.mostrarCorredoresEquipo(codigoEquipo);
			} catch (GestionCarreraException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Desea seguir viendo los corredores de los equipos? SI - NO");
			salir = scanner.nextLine();
		}while(salir.equalsIgnoreCase("si"));
	}
	
	public static String validarSexo(Scanner scanner) {
		String sexo;
		do {
			System.out.println("Introduzca el sexo del corredor HOMBRE/MUJER:");
			sexo = scanner.nextLine();
			if (!(sexo.equalsIgnoreCase("hombre") || sexo.equalsIgnoreCase("mujer"))) {
				System.out.println("ERROR: El sexo del particpante debe ser fijado a HOMBRE o MUJER");
			}
		}while(!(sexo.equalsIgnoreCase("hombre") || sexo.equalsIgnoreCase("mujer")));
		return sexo;
		
	}
	
	public static int validarEdad(Scanner scanner) {
		boolean flag = true;
		int edad = 0;
		do {
			try {
				System.out.println("Introduzca la edad del corredor");
				edad = Integer.parseInt(scanner.nextLine());
				if (edad <= 0 || edad > 30) {
					System.out.println("ERROR: La Edad del participante debe estar comprendida entre 1 y 30 años");
				}
				else {
					flag = false;
				}
			}
			catch (NumberFormatException e) {
				System.out.println("ERROR: La edad del corredor debe ser un número entero!");
			}
		} while(flag);
		return edad;
	}
	
	public static String validarCodigoCorredor(Scanner scanner) {
		String codigoCorredor;
		do {
			System.out.println("Introduzca el código del corredor: ");
			codigoCorredor = scanner.nextLine();
			if (codigoCorredor.isBlank() || codigoCorredor.isEmpty()) {
				System.out.println("ERROR: El código del corredor no puede estar vacio");
			}
		}while(codigoCorredor.isBlank() || codigoCorredor.isEmpty());
		return codigoCorredor;
	}
	
	
	public static String validarNombreCorredor(Scanner scanner) {
		String nombreCorredor;
		do {
			System.out.println("Introduzca el nombre del corredor: ");
			nombreCorredor = scanner.nextLine();
			if (nombreCorredor.isBlank() || nombreCorredor.isEmpty()) {
				System.out.println("ERROR: El nombre del corredor no puede estar vacio");
			}
		}while(nombreCorredor.isBlank() || nombreCorredor.isEmpty());
		return nombreCorredor;
	}
	
	public static String validarApellidosCorredor(Scanner scanner) {
		String apellidosCorredor;
		do {
			System.out.println("Introduzca los apellidos del corredor: ");
			apellidosCorredor = scanner.nextLine();
			if (apellidosCorredor.isBlank() || apellidosCorredor.isEmpty()) {
				System.out.println("ERROR: Los apellidos del corredor no puede estar vacio");
			}
		}while(apellidosCorredor.isBlank() || apellidosCorredor.isEmpty());
		return apellidosCorredor;
	}
	
}
