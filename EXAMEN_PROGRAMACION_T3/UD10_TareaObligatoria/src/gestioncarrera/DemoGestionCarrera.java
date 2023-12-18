package gestioncarrera;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import excepciones.GestionCarreraException;
import utilidades.ConexionBaseDatos;
import utilidades.Menu;


public class DemoGestionCarrera {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		GestionCarrera gestionCarrera = new GestionCarrera();
		try (Connection connection = ConexionBaseDatos.openConnection()) {
			gestionCarrera.generarCarrerasEquipos();
			boolean flag = true;
			boolean flagPremio = false;
			do {
				System.out.println("***********************************************************************");
				System.out.println("*****************************  MENÚ  **********************************");
				System.out.println("***********************************************************************");
				System.out.println("OPCIONES:");
				System.out.println("1: Alta Equipo Carrera");
				System.out.println("2: Alta Participante Equipo");
				System.out.println("3: Eliminar Equipo Carrera");
				System.out.println("4: Asignar Premio Equipo Carrera");
				System.out.println("5: Mostrar corredores Equipo");
				System.out.println("6: Funcionalidad Stream");
				System.out.println("7: Volcar datos base datos");
				System.out.println("***********************************************************************");
				System.out.println("Introduzca la opción deseada:");
				String opcion = scanner.nextLine();
				switch (opcion){
					case "1":
						System.out.println("******************* ALTA EQUIPO CARRERA ******************");
						Menu.altaEquipoCarrera(gestionCarrera, scanner);
						break;
					case "2":
						System.out.println("******************* ALTA PARTICPANTE EQUIPO ********************");
						Menu.altaCorredorEquipo(gestionCarrera, scanner);
						break;
					case "3":
						System.out.println("******************* ELIMINAR EQUIPO CARRERA ******************");
						Menu.eliminarEquipoCarrera(gestionCarrera, scanner);
						break;
					case "4":
						System.out.println("******************* ASIGNAR PREMIO EQUIPO CARRERA ********************");
						Menu.asignarPremioEquipo(gestionCarrera, scanner);
						flagPremio = true;
						break;
					case "5":
						System.out.println("******************* MOSTRAR CORREDORES EQUIPO ********************");
						Menu.mostrarCorredoresEquipo(gestionCarrera, scanner);
						break;
					case "6":
						System.out.println("******************* MOSTRAR FUNCIONALIDADES STREAM ********************");
						Menu.mostrarFuncionalidadStream(gestionCarrera);
						break;
					case "7":
						System.out.println("******************* VOLCAR DATOS BASE DATOS ********************");
						if (flagPremio) {
							Menu.volcarCarreraBaseDatos(gestionCarrera, scanner, connection);
						}
						else {
							System.out.println("WARNING: Para volcar datos de las carreras a la Base de Datos debe asignar primero los premios a los equipos en las carreras!");
						}
						break;
					default:
						System.out.println("ERROR: La opción elegida no está contemplada en menú!");
						break;
				}
				System.out.println("***********************************************************************");
				System.out.println("Desea salir del Menú? SI - NO");
				String salir = scanner.nextLine();
				if (salir.equalsIgnoreCase("si")) {
					flag = false;
				}
			} while (flag);
			scanner.close();
			System.out.println("***********************************************************************");
			System.out.println("*********************** FIN DEL MENÚ  *********************************");
			System.out.println("***********************************************************************");
			
		} catch (GestionCarreraException e) {
			System.out.println(e.getMessage());
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
