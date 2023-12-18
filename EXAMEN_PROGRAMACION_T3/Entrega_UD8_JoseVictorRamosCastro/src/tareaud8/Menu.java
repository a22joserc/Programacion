package tareaud8;

import java.util.Scanner;

public class Menu {
	
	
	public static void anadirJugadorTeclado(GestionNba gestionNba, Scanner scanner) {
		Equipo equipo;
		boolean flagEquipo = true;
		do {
			// Pedimos nombre del equipo
			do { 
				System.out.println("Introduzca el Nombre del equipo ");
				String nombreEquipo = scanner.nextLine(); 
				equipo = gestionNba.getEquipo(nombreEquipo);
				if (equipo == null) {
					System.out.println("Error: El equipo no está registrado en el sistema!");
				}
			} while(equipo == null);
			
			// Pedimos el tipo de jugador
			String tipoJugador; 
			do {
				System.out.println("Introduzca el tipo de Jugador: ROOKIE - VETERANO ");
				tipoJugador = scanner.nextLine(); 
				if (!(tipoJugador.equalsIgnoreCase("ROOKIE") || tipoJugador.equalsIgnoreCase("VETERANO"))) {
					System.out.println("ERROR: Sólo puede crear un rookie o un veterano");
				}
			} while(!(tipoJugador.equalsIgnoreCase("ROOKIE") || tipoJugador.equalsIgnoreCase("VETERANO")));
			
			// Pedimos datos Jugador
			Jugador jugador = null;
			String nombreJugador;
			boolean flagRookie = true;
			boolean flagVeterano = true;
			
			if (tipoJugador.equalsIgnoreCase("ROOKIE")) {
				System.out.println("Va a generar un rookie");
				do {
					try {
						System.out.println("Introduzca el nombre del jugador (rookie)");
						nombreJugador = scanner.nextLine();
						System.out.println("Introduzca el dorsal");
						String dorsal = scanner.nextLine();
						System.out.println("Introduzca el número del draft");
						String draft = scanner.nextLine();
						jugador = new Rookie(nombreJugador, Integer.parseInt(dorsal), Integer.parseInt(draft));
						flagRookie = false;
					}
					catch (NbaException e) {
						System.out.println(e.getMessage());
					}
				} while(flagRookie);
			}
			else {
				System.out.println("Va a generar un veterano");
				do {
					try {
						// Veterano(String nombre, int dorsal, double salario, int anosExperiencia, Equipo ultimoEquipo)
						System.out.println("Introduzca el nombre del jugador");
						nombreJugador = scanner.nextLine();
						System.out.println("Introduzca el dorsal");
						String dorsal = scanner.nextLine();
						System.out.println("Introduzca el salario");
						String salario = scanner.nextLine();
						System.out.println("Introduzca años de experiencia");
						String anosExp = scanner.nextLine();
						// Pedimos último equipo se asume que el último equipo tiene que estar registrado en el sistema
						Equipo ultimoEquipo;
						do { 
							System.out.println("Introduzca el Nombre de su último equipo ");
							String nombreUltimoEquipo = scanner.nextLine(); 
							ultimoEquipo = gestionNba.getEquipo(nombreUltimoEquipo);
							if (ultimoEquipo == null) {
								System.out.println("Error: El equipo no está registrado en el sistema!");
							}
						} while(ultimoEquipo == null);
						jugador = new Veterano(nombreJugador, Integer.parseInt(dorsal), Double.parseDouble(salario), Integer.parseInt(anosExp), ultimoEquipo);
						flagVeterano = false;
					}
					catch (NbaException e) {
						System.out.println(e.getMessage());
					}
				} while(flagVeterano);	
			}
			
			// Añadimos Jugador al Equipo
			try {
				boolean flagJugador = equipo.anadirJugador(jugador);
				if (flagJugador) {
					System.out.println("El jugador " + jugador.toString() + " ha sido añadido correctamente al equipo " + equipo.getNombre());
					flagEquipo = false;
				}
				else {
					System.out.println("ERROR: El jugador " + jugador.getNombre() + " ya estaba previamente registrado en el equipo " + equipo.getNombre());
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while(flagEquipo);
	}


}
