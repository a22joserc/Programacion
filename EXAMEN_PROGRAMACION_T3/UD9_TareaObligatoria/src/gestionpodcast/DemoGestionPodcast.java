package gestionpodcast;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;

import org.apache.commons.dbcp2.BasicDataSource;


public class DemoGestionPodcast {

	public static void main(String[] args) {
		
		
		GestionPodcast gestionPodcast = new GestionPodcast();
		Scanner scanner = new Scanner(System.in);
		
		try(BasicDataSource dataSource = new BasicDataSource();
			Connection connection = gestionPodcast.openConnection(dataSource);
			JdbcRowSet rowSet = gestionPodcast.openConnectionJdbcRowSet()){
			boolean flag = true;
			do {
				System.out.println("***********************************************************************");
				System.out.println("*****************************  MENÚ  **********************************");
				System.out.println("***********************************************************************");
				System.out.println("OPCIONES:");
				System.out.println("1: Agregar nuevo podcast base de datos");
				System.out.println("2: Agregar nuevo género base de datos");
				System.out.println("3: Actualizar géneros podcast base de datos");
				System.out.println("4: Eliminar podcast base de datos");
				System.out.println("5: Visualizar podcasts base de datos");
				System.out.println("6: Visualiazar podcast base de datos");
				System.out.println("***********************************************************************");
				System.out.println("Introduzca la opción deseada:");
				String opcion = scanner.nextLine();
				switch (opcion){
					case "1":
						// Agrega podcast a tabla podcast
						// Agrega los generos del podcast que no estaba registrados en la base de datos
						// Agrega los registros correspondientes a gen_pod
						System.out.println("******************* AGREGAR PODCAST BASE DATOS ******************");
						gestionPodcast.mostrarIdTituloPodcasts(connection);
						Podcast podcast = Menu.altaPodcastTeclado(connection, scanner); 
						gestionPodcast.altaPodcastV3(connection, podcast);
						break;
					case "2":
						System.out.println("******************* AGREGAR GENERO BASE DATOS ********************");
						gestionPodcast.mostrarGeneros(connection);
						Genero genero = Menu.altaGeneroTeclado(scanner);
						gestionPodcast.crearGenero(connection, genero);
						break;
					case "3":
						System.out.println("******************* ACTUALIZAR PODCAST BASE DATOS ******************");
						Menu.actualizarGeneroPodcast(connection, gestionPodcast, scanner);
						break;
					case "4":
						System.out.println("******************* ELIMINAR PODCAST BASE DATOS ********************");
						gestionPodcast.mostrarIdTituloPodcasts(connection);
						Menu.eliminarPodcast(connection, gestionPodcast, scanner);
						break;
					case "5":
						System.out.println("*********** MOSTRAR TODOS LOS PODCASTS BASE DATOS ******************");
						gestionPodcast.mostrarPodcasts(connection);
						break;
					case "6":
						System.out.println("*********** MOSTRAR PODCAST ESPECÍFICO ******************");
						gestionPodcast.verPodcast(rowSet, connection, scanner);
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
			
			System.out.println("***********************************************************************");
			System.out.println("*********************** FIN DEL MENÚ  *********************************");
			System.out.println("***********************************************************************");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
