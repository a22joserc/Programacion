package gestionpodcast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	
	public static Podcast altaPodcastTeclado(Connection connection, Scanner scanner) {
		
		// Tipo Podcast
		String tipo = Menu.validarTipoPodcast(scanner);
		
		// IdPodcast
		int idPodcast = Menu.validarIdPodcast(scanner);
		
		// Título
		String tituloPodcast = Menu.validarTituloPodcast(scanner);
		
		// Duración
		int duracionPodcast = Menu.validarDuracionPodcast(scanner);
		
		// Periodicidad
		String periodicidadPodcast = Menu.validarPeriodicidadPodcast(scanner);
		
		// Calidad Audio - Formato Video
		String calidadPodcast = null;
		String formatoVideo = null;
		if (tipo.equalsIgnoreCase("audio")) {
			calidadPodcast = Menu.validarCalidadAudioPodcast(scanner);
		}
		else {
			formatoVideo = Menu.validarFormatoVideoPodcast(scanner);			
		}
		
		// IdAutor
		int idAutor = Menu.validarIdAutor(connection, scanner);
		
		// Una vez que tenemos el ID del Autor Válido obtenemos sus datos a través de una consulta SQL
		Autor autor = new Autor();
		autor.setFromSql(idAutor, connection);

		// Obtenemos Lista Generos
		ArrayList<Genero> listaGeneros = Menu.obtenerListaGeneros(connection, scanner);
		
		// Instanciamos Podcast
		Podcast podcast = new Podcast();
		podcast.setIdPodcast(idPodcast);
		podcast.setTitulo(tituloPodcast);
		if (tipo.equalsIgnoreCase("audio")) {
			podcast.setTipo(tipoPodcast.Audio);
		}
		else {
			podcast.setTipo(tipoPodcast.Video);
		}
		podcast.setCalidad(calidadPodcast);
		podcast.setDuracion(duracionPodcast);
		podcast.setPericidad(periodicidadPodcast);
		podcast.setFormatoVideo(formatoVideo);
		podcast.setAutor(autor);
		podcast.setGeneros(listaGeneros);
		return podcast;
	}
	
	
	public static String validarTipoPodcast(Scanner scanner) {
		String tipo;
		do {
			System.out.println("Introduzca el tipo de Podcast para introducir en la Base de datos: Audio - Video");
			tipo = scanner.nextLine();
			if (!(tipo.equalsIgnoreCase("audio") || tipo.equalsIgnoreCase("video"))) {
				System.out.println("ERROR: El Podcast sólo puede ser de tipo Audio o Video");
			}
		} while(!(tipo.equalsIgnoreCase("audio") || tipo.equalsIgnoreCase("video")));
		return tipo;
	}
	
	
	public static String validarTipoActualizacion(Scanner scanner) {
		String tipo;
		do {
			System.out.println("Introduzca el tipo de actulización a realizar en los generos del podcast: ");
			System.out.println("Anadir: Añadir un nuevo genero al podcast");
			System.out.println("Eliminar: Eliminar un genero al podcast");
			System.out.println("Modificar: Cambiar un genero del podcast por otro");
			tipo = scanner.nextLine();
			if (!(tipo.equalsIgnoreCase("anadir") || tipo.equalsIgnoreCase("eliminar") || tipo.equalsIgnoreCase("modificar"))) {
				System.out.println("ERROR: Sólo se puede anadir, eliminar o modificar");
			}
		} while(!(tipo.equalsIgnoreCase("anadir") || tipo.equalsIgnoreCase("eliminar") || tipo.equalsIgnoreCase("modificar")));
		return tipo;
	}
	
	
	public static int validarDuracionPodcast(Scanner scanner) {
		boolean flagDuracion = true;
		int duracionPodcast = 0;
		do {
			try {
				System.out.println("Introduzca la Duración del Podcast en minutos (int)");
				duracionPodcast = Integer.parseInt(scanner.nextLine());
				if (duracionPodcast <= 0) {
					System.out.println("ERROR: La Duración del Podcast no puede ser cero o un número negativo");
				}
				else {
					flagDuracion = false;
				}
			}
			catch (NumberFormatException e) {
				System.out.println("ERROR: La duración del podcast debe ser un número entero!");
			}
		} while(flagDuracion);
		return duracionPodcast;
	}
	
	public static int validarIdPodcast(Scanner scanner) {
		boolean flagIdPodcast = true;
		int idPodcast = 0;
		do {
			try {
				System.out.println("Introduzca el idPodcast (int)");
				idPodcast = Integer.parseInt(scanner.nextLine());
				
				if (idPodcast <= 0) {
					System.out.println("ERROR: El idPodcast debe ser mayor que cero");
				}
				else {
					flagIdPodcast = false;
				}
			}
			catch (NumberFormatException e) {
				System.out.println("ERROR: El IdPodcast debe ser un número entero!");
			}
		} while(flagIdPodcast);
		return idPodcast;
	}
	
	public static int validarIdAutor(Connection connection, Scanner scanner) {
		int idAutor = 0;
		boolean flagAutorBD = true;
		do {
			boolean flagIdAutor = true;
			// int idAutor;
			do {
				try {
					System.out.println("Introduzca el idAutor (int)");
					idAutor = Integer.parseInt(scanner.nextLine());
					flagIdAutor = false;
				}
				catch (NumberFormatException e) {
					System.out.println("ERROR: El IdAutor debe ser un número entero!");
				}
			} while(flagIdAutor);		
			try {
				PreparedStatement preparedStatementIdAutor = connection.prepareStatement(Consultas.SELECT_NUM_IDAUTOR);
				preparedStatementIdAutor.setInt(1, idAutor);
				ResultSet resultSetIdAutor = preparedStatementIdAutor.executeQuery();
				resultSetIdAutor.next();
				int numIdAutor = resultSetIdAutor.getInt(1);
				if (numIdAutor !=1) {
					System.out.println("ERROR: El autor no se encuentra registrado en la base de datos");
				}
				else {
					flagAutorBD = false;
				}
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}while(flagAutorBD);
		return idAutor;
	}
	
	public static String validarTituloPodcast(Scanner scanner) {
		String tituloPodcast;
		do {
			System.out.println("Introduzca el Título del Podcast (varchar)");
			tituloPodcast = scanner.nextLine();
			if (tituloPodcast.isBlank() || tituloPodcast.isEmpty()) {
				System.out.println("ERROR: El título del Podcast no puede estar vacio");
			}
		}while(tituloPodcast.isBlank() || tituloPodcast.isEmpty());
		return tituloPodcast;
	}
	
	public static String validarPeriodicidadPodcast(Scanner scanner) {
		String periodicidadPodcast;
		do {
			System.out.println("Introduzca la Periodicidad del Podcast (varchar)");
			periodicidadPodcast = scanner.nextLine();
			if (periodicidadPodcast.isBlank() || periodicidadPodcast.isEmpty()) {
				System.out.println("ERROR: La periodicidad del Podcast no puede estar vacia");
			}
		}while(periodicidadPodcast.isBlank() || periodicidadPodcast.isEmpty());
		return periodicidadPodcast;
	}
	
	public static String validarFormatoVideoPodcast(Scanner scanner) {
		String formatoVideoPodocast;
		do {
			System.out.println("Introduzca el Formato de Video del Podcast (varchar)");
			formatoVideoPodocast = scanner.nextLine();
			if (formatoVideoPodocast.isBlank() || formatoVideoPodocast.isEmpty()) {
				System.out.println("ERROR: El formato de video del Podcast no puede estar vacia");
			}
		}while(formatoVideoPodocast.isBlank() || formatoVideoPodocast.isEmpty());
		return formatoVideoPodocast;
	}
	
	
	public static String validarCalidadAudioPodcast(Scanner scanner) {
		String calidadAudioPodocast;
		do {
			System.out.println("Introduzca la Calidad de Audio del Podcast en Kbps (varchar)");
			calidadAudioPodocast = scanner.nextLine();
			if (calidadAudioPodocast.isBlank() || calidadAudioPodocast.isEmpty()) {
				System.out.println("ERROR: La calidad de audio del Podcast no puede estar vacia");
			}
		}while(calidadAudioPodocast.isBlank() || calidadAudioPodocast.isEmpty());
		return calidadAudioPodocast;
	}
	
	
	public static int validarIdGenero(Scanner scanner) {
		boolean flagIdGenero = true;
		int idGenero = 0;
		do {
			try {
				System.out.println("Introduzca el IdGenero del Podcast: ");
				idGenero = Integer.parseInt(scanner.nextLine());
				if (idGenero <=0) {
					System.out.println("ERROR: El IdGenero debe ser mayor o igual que cero!");
				} 
				else {
					flagIdGenero = false;
				}
			}
			catch (NumberFormatException e) {
				System.out.println("ERROR: El IdGenero debe ser un número entero!");
			}
		} while(flagIdGenero);
		return idGenero;
	}
	
	public static ArrayList<Genero> obtenerListaGeneros(Connection connection, Scanner scanner){
		String salir;
		ArrayList<Genero> listaGeneros = new ArrayList<>();
		do {
			int idGenero = Menu.validarIdGenero(scanner);
			// Comprobamos si el genero introducido se encuentra en la base de datos
			String sqlS = "SELECT count(idGeneros) FROM Generos WHERE idGeneros=?";
			try {
				PreparedStatement preparedStatementIdGenero = connection.prepareStatement(sqlS);
				preparedStatementIdGenero.setInt(1, idGenero);
				ResultSet resultSetIdGenero = preparedStatementIdGenero.executeQuery();
				resultSetIdGenero.next();
				int numIdGenero= resultSetIdGenero.getInt(1);
				Genero genero = new Genero();
				if (numIdGenero == 1) {
					System.out.println("El género introducido ya se encuentra registrado en la base de datos por lo que se obtienen sus datos de la misma!");
					genero.setIdGenero(idGenero);
					String sqlG = "SELECT nombre FROM Generos WHERE idGeneros=?";
					PreparedStatement preparedStatementNombreGenero = connection.prepareStatement(sqlG);
					preparedStatementNombreGenero.setInt(1, idGenero);
					ResultSet resultSetNombreGenero = preparedStatementNombreGenero.executeQuery();
					resultSetNombreGenero.next();
					String nombreGenero = resultSetNombreGenero.getString(1);
					System.out.println(nombreGenero);
					genero.setNombre(nombreGenero);
				} 
				else {
					System.out.println("El género introducido no se encuentra registrado en la base de datos por lo que debe registrarlo manualmente!");
					System.out.println("Introduzca un NombreGenero del Podcast: ");
					String nombreGenero = scanner.nextLine();
					genero.setIdGenero(idGenero);
					genero.setNombre(nombreGenero);
				}
				listaGeneros.add(genero);
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Desea introducir más generos? SI - NO");
			salir = scanner.nextLine();
		} while(!salir.equalsIgnoreCase("no"));
		return listaGeneros;
	}
	
	
	public static Genero altaGeneroTeclado(Scanner scanner) {
		int idGenero = Menu.validarIdGenero(scanner);
		System.out.println("Introduzca un NombreGenero del Podcast: ");
		String nombreGenero = scanner.nextLine();
		Genero genero = new Genero();
		genero.setIdGenero(idGenero);
		genero.setNombre(nombreGenero);
		return genero;
	}
	
	
	public static void actualizarGeneroPodcast(Connection connection, GestionPodcast gestionPodcast, Scanner scanner) {
		
		String salir;
		do {
			System.out.println("**************************************************************************************");
			gestionPodcast.mostrarPodcasts(connection);
			System.out.println("**************************************************************************************");
			int idPodcast = Menu.validarIdPodcast(scanner);
			if(gestionPodcast.existePodcast(connection, idPodcast)) {
				ArrayList<Genero> listaGeneros = gestionPodcast.obternerListaGenerosPodcast(connection, idPodcast);
				System.out.println("Actualmente el Podcast con idPodcast " + idPodcast + " cuenta con los siguientes generos: ");
				listaGeneros.forEach(genero -> System.out.println(genero));
				String tipoActualizacion = Menu.validarTipoActualizacion(scanner);
				gestionPodcast.mostrarGeneros(connection);
				int idGenero;
				switch (tipoActualizacion.toLowerCase()){
					case "anadir":
						idGenero = Menu.validarIdGenero(scanner);
						if (gestionPodcast.existeGenero(connection, idGenero)) {
							gestionPodcast.insertarGeneroPodcast(connection, idPodcast, idGenero);
						}
						else {
							System.out.println("El género con idGenero " + idGenero + " no se encuentra registrado en la base de datos!");
						}
						break;
					
					case "eliminar":
						idGenero = Menu.validarIdGenero(scanner);
						if (gestionPodcast.existeGenero(connection, idGenero)) {
							gestionPodcast.eliminarGeneroPodcast(connection, idPodcast, idGenero);
						}
						else {
							System.out.println("El género con idGenero " + idGenero + " no se encuentra registrado en la base de datos!");
						}
						break;
					
					case "modificar":
						System.out.print("IdGenero antiguo. ");
						int idGeneroViejo = Menu.validarIdGenero(scanner);
						System.out.print("IdGenero nuevo. ");
						int idGeneroNuevo = Menu.validarIdGenero(scanner);
						if (gestionPodcast.existeGenero(connection, idGeneroViejo) && gestionPodcast.existeGenero(connection, idGeneroNuevo)) {
							gestionPodcast.actualizarGeneroPodcast(connection, idPodcast, idGeneroViejo, idGeneroNuevo);
						}
						else {
							System.out.println("Alguno de los géneros introducidos no se encuentra registrado en la base de datos!");
						}
						break;
						
					default:
						System.out.println("ERROR: Opción no contemplada!");
						break;
				}
			}
			else {
				System.out.println("ERROR: El podcast con id " + idPodcast + " no se encuentra registrado en la base de datos!");
			}
			System.out.println("Desea realizar más operaciones de actualización? SI - NO");
			salir = scanner.nextLine();
		} while(!salir.equalsIgnoreCase("no"));
		
	}
	
	public static void eliminarPodcast(Connection connection, GestionPodcast gestionPodcast, Scanner scanner) {
		int idPodcast = Menu.validarIdPodcast(scanner);
		gestionPodcast.eliminarPodcast(connection, idPodcast);
	}
	
	

}
