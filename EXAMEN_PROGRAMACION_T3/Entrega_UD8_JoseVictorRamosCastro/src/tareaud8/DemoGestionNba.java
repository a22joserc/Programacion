package tareaud8;

import java.util.Random;
import java.util.Scanner;

public class DemoGestionNba {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		GestionNba gestionNba = new GestionNba();
		
		// 1.- Generamos equipos 
		gestionNba.anadirEquipo(new Equipo("Los Angeles Lakers", "Los Angeles", tipoConferencia.OESTE));
		gestionNba.anadirEquipo(new Equipo("New York Knicks", "New York", tipoConferencia.ESTE));
		gestionNba.anadirEquipo(new Equipo("Chicago Bulls", "Chigaco", tipoConferencia.ESTE));
		gestionNba.anadirEquipo(new Equipo("Dallas Mavericks", "Dallas", tipoConferencia.OESTE));
		gestionNba.anadirEquipo(new Equipo("Golden State Warriors", "San Francisco", tipoConferencia.OESTE));
		gestionNba.anadirEquipo(new Equipo("Atlanta Hawks", "Atlanta", tipoConferencia.ESTE));
		gestionNba.anadirEquipo(new Equipo("Brooklyn Nets", "New York", tipoConferencia.ESTE));
		gestionNba.anadirEquipo(new Equipo("Minesota Timberwolves", "Mineaoplis", tipoConferencia.OESTE));
		
		// 2.- Mostramos Equipos por Pantalla
		System.out.println("*************************** MOSTRAMOS EQUIPOS POR PANTALLA *****************************");
		gestionNba.mostrarEquipos();	
		
		// 4.- Mostramos excepción número máximo de rookies
		System.out.println("*************************** MOSTRAMOS EXCEPCIÓN ROOKIES ********************************");
		try {
			for (int i=0; i<4; i++) {
				gestionNba.anadirJugadorEquipo("Dallas Mavericks", new Rookie(("Rookie " + (i+1)), new Random().nextInt(0, 101), new Random().nextInt(1, 61)));
			}
			gestionNba.mostrarInfoEquipo("Dallas Mavericks");
		} catch (NbaException e) {
			System.out.println(e.getMessage());
		}
		// 4.- Mostramos excepción número máximo de Jugadores
		System.out.println("*************************** MOSTRAMOS EXCEPCIÓN NúM JUGADORES **************************");
		try {
			for (int i=0; i<13; i++) {
				gestionNba.anadirJugadorEquipo("Dallas Mavericks", new Veterano(("Veterano " + (i+1)), new Random().nextInt(0, 101), 500000, new Random().nextInt(5, 21), gestionNba.getEquipo("New York Knicks")));
			}
			gestionNba.mostrarInfoEquipo("Dallas Mavericks");
		} catch (NbaException e) {
			System.out.println(e.getMessage());
		}
		
		// 5.- Mostramos la info del equipo jugadores y masa salarial a partir de su nombre
		System.out.println("*************************** MOSTRAMOS NúM JUGADORES Y MASA SALARIAL EQUIPO **************************");
		try {
			gestionNba.mostrarInfoEquipo("Dallas Mavericks");
		} catch (NbaException e) {
			System.out.println(e.getMessage());
		}
		
		// 6.- Generamos Fichero
		gestionNba.mostrarInfoEquiposFichero("./equipos.txt");
		
		// 7.- Comparar jugadores del mismo equipo por su salario
		System.out.println("*************************** COMPARAMOS JUGADORES DEL MISMO EQUIPO POR SALARIO **************************");
		try {
			gestionNba.anadirJugadorEquipo("Golden State Warriors", new Veterano("Stephen Curry", 30, 50000000, 12, gestionNba.getEquipo("Golden State Warriors")));
			gestionNba.anadirJugadorEquipo("Golden State Warriors", new Veterano("Klay Thompson", 11, 35000000, 10, gestionNba.getEquipo("Golden State Warriors")));
			gestionNba.anadirJugadorEquipo("Golden State Warriors", new Veterano("Draymon Green", 23, 35000000, 10, gestionNba.getEquipo("Golden State Warriors")));
			gestionNba.anadirJugadorEquipo("Golden State Warriors", new Veterano("Jordan Poole", 3, 2100000, 10, gestionNba.getEquipo("Golden State Warriors")));
		} catch (NbaException e) {
			System.out.println(e.getMessage());
		}
		gestionNba.getEquipo("Golden State Warriors").comparaJugadoresSalario("Stephen Curry","Klay Thompson");
		gestionNba.getEquipo("Golden State Warriors").comparaJugadoresSalario("Klay Thompson","Draymon Green");
		gestionNba.getEquipo("Golden State Warriors").comparaJugadoresSalario("Jordan Poole","Draymon Green");
		
		// 8.- Obtenemos Equipos por conferencias
		System.out.println("*************************** MOSTRAMOS EQUIPOS POR CONFERENCIA ORDENADOS POR NOMBRE **************************");
		gestionNba.anadirEquiposConferencias();
		System.out.println("Equipos conferencia ESTE: ");
		gestionNba.getListaEquiposConferenciaEste().forEach(equipo -> System.out.println(equipo));
		System.out.println("Equipos conferencia OESTE: ");
		gestionNba.getListaEquiposConferenciaOeste().forEach(equipo -> System.out.println(equipo));
		
		// 9.- Serializamos equipo
		System.out.println("*************************** SERIALIZAMOS EQUIPO ***********************************");
		gestionNba.guardarEquipoDisco("Golden State Warriors", "./GoldenStateWarriors_equipo.ser");
		System.out.println("*************************** LEEMOS EL EQUIPO SERIALIZADO **************************");
		gestionNba.leerEquipoDisco("./GoldenStateWarriors_equipo.ser");

		// 3.- Entrada de Jugadores por teclado
		// Añadimos 3 rookies a un equipo para comprobar el número máximo de rookies
		try {
			for (int i=0; i<3; i++) {
				gestionNba.anadirJugadorEquipo("Atlanta Hawks", new Rookie(("Rookie " + (i+1)), new Random().nextInt(0, 101), new Random().nextInt(1, 61)));
			}
		} catch (NbaException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("***************** INTRODUCIMOS DOS JUGADORES POR TECLADO **************************");
		// Comprobar con Atlanta Hawks para Excepción Núm Rookies
		// Comprobar con Dallas Mavericks para Excepción Plantilla completa
		// Comprobar con cualquier otro equipo para el resto de excepciones
		int numJugadoresTeclado = 2;
		for (int i=0; i<numJugadoresTeclado; i++) {
			System.out.println("Jugador_" + (i+1) + ": ");
			Menu.anadirJugadorTeclado(gestionNba, scanner);
		}
	
	}
	

}
