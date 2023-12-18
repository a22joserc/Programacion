package gestionpodcast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import org.apache.commons.dbcp2.BasicDataSource;

public class GestionPodcast {
	
	public Connection openConnection() throws SQLException{
		String sURL = "jdbc:mariadb://dbalumnos.sanclemente.local:3319/JVR_podcast_bd";
		Connection connection = DriverManager.getConnection(sURL,"alumno","abc123..");
		System.out.println("Conexion con la base de datos!");
		return connection;
	}
	
	public Connection openConnection(BasicDataSource dataSource) throws SQLException{
		dataSource.setUrl("jdbc:mariadb://dbalumnos.sanclemente.local:3319/JVR_podcast_bd");
        dataSource.setUsername("alumno");
        dataSource.setPassword("abc123..");
        dataSource.setInitialSize(5);
        dataSource.setMaxTotal(10);
        Connection connection = dataSource.getConnection();
        System.out.println("Conexion con la base de datos!");
		return connection;
	}
	
	public JdbcRowSet openConnectionJdbcRowSet() throws SQLException {
		String sURL = "jdbc:mariadb://dbalumnos.sanclemente.local:3319/JVR_podcast_bd";
		JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
		rowSet.setUrl(sURL);
		rowSet.setUsername("alumno");
		rowSet.setPassword("abc123..");
		System.out.println("Conexion con la base de datos RowSet!");
		return rowSet;
	}
		
	
	// ---------------------------------------------------------------------------------------------------------------------------------// 
	// Alta Podcast
	
	public void altaPodcastV3(Connection connection, Podcast podcast) { 
		
		// Insercción Tabla Podcast
		insertIntoTablePodcast(connection, podcast);
		// Insercción Tabla Generos
		insertIntoTableGenerosV2(connection, podcast);
		// Insercción Tabla gen_pod
		insertIntoTableGenPod(connection, podcast);
	}
	
	public void insertIntoTablePodcast(Connection connection, Podcast podcast) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Consultas.INSERT_INTO_PODCAST);
			preparedStatement.setInt(1, podcast.getIdPodcast());
			preparedStatement.setString(2, podcast.getTitulo());
			if (podcast.getTipo().toString().equalsIgnoreCase("audio")) {
				preparedStatement.setByte(3, (byte) 0);
			}
			else {
				preparedStatement.setByte(3, (byte) 1);
			}
			preparedStatement.setString(4, podcast.getCalidad());
			preparedStatement.setInt(5, podcast.getDuracion());
			preparedStatement.setString(6, podcast.getPericidad());
			preparedStatement.setString(7, podcast.getFormatoVideo());
			preparedStatement.setInt(8, podcast.getAutor().getIdAutor());
			preparedStatement.executeUpdate();
			System.out.println("Registro insertado en la tabla Podcast");
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}	
	
	public void insertIntoTableGenPod(Connection connection, Podcast podcast) {
		Iterator<Genero> iterator = podcast.getGeneros().iterator();
		while(iterator.hasNext()) {
			Genero genero = iterator.next();
			try {
				PreparedStatement preparedStatementGen_Pod = connection.prepareStatement(Consultas.INSERT_INTO_GEN_POD);
				preparedStatementGen_Pod.setInt(1, podcast.getIdPodcast());
				preparedStatementGen_Pod.setInt(2, genero.getIdGenero());
				preparedStatementGen_Pod.executeUpdate();
				System.out.println("Registro insertado en la tabla gen_pod");	
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void insertIntoTableGeneros(Connection connection, Podcast podcast) {
		Iterator<Genero> iterator = podcast.getGeneros().iterator();
		while(iterator.hasNext()) {
			 Genero genero = iterator.next();
			 try {
				 PreparedStatement preparedStatementGenero = connection.prepareStatement(Consultas.INSERT_INTO_GENEROS);
				 preparedStatementGenero.setInt(1, genero.getIdGenero());
				 preparedStatementGenero.setString(2, genero.getNombre());
				 preparedStatementGenero.executeUpdate();
				 System.out.println("Registro insertado en la tabla Generos");	
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void insertIntoTableGenerosV2(Connection connection, Podcast podcast) {
		Iterator<Genero> iterator = podcast.getGeneros().iterator();
		while(iterator.hasNext()) {
			 Genero genero = iterator.next();
			 this.crearGenero(connection, genero);
		}	
	}
	
	public boolean existeGenero(Connection connection, Genero genero) {
		try {
			PreparedStatement preparedStatementIdGenero= connection.prepareStatement(Consultas.SELECT_NUM_IDGENEROS);
			preparedStatementIdGenero.setInt(1, genero.getIdGenero());
			ResultSet resultSetIdAutor = preparedStatementIdGenero.executeQuery();
			resultSetIdAutor.next();
			int numIdGenero = resultSetIdAutor.getInt(1);
			if (numIdGenero == 1) {
				return true;
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	// Sobrecarga metodo
	
	public boolean existeGenero(Connection connection, int idGenero) {
		try {
			PreparedStatement preparedStatementIdGenero= connection.prepareStatement(Consultas.SELECT_NUM_IDGENEROS);
			preparedStatementIdGenero.setInt(1, idGenero);
			ResultSet resultSetIdAutor = preparedStatementIdGenero.executeQuery();
			resultSetIdAutor.next();
			int numIdGenero = resultSetIdAutor.getInt(1);
			if (numIdGenero == 1) {
				return true;
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
		
	// ---------------------------------------------------------------------------------------------------------------------------------// 
	
	// ---------------------------------------------------------------------------------------------------------------------------------//
	// Dar de alta un nuevo género
	
	public void crearGenero(Connection connection, Genero genero) {
		boolean flagGenero = this.existeGenero(connection, genero);
		if (!flagGenero) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(Consultas.INSERT_INTO_GENEROS);
				preparedStatement.setInt(1, genero.getIdGenero());
				preparedStatement.setString(2, genero.getNombre());
				preparedStatement.executeUpdate();
				System.out.println("Registro insertado en la tabla Generos");	
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			System.out.println("El genero con id " + genero.getIdGenero() + " ya se encuentra en la tabla generos");
		}
	}
	
	// Sobrecarga de métodos
	public void crearGenero(JdbcRowSet rowSet, Genero genero)  {
		try {
			rowSet.setCommand(Consultas.SELECT_ALL_GENEROS);
			rowSet.execute();
			rowSet.moveToInsertRow();
			rowSet.updateInt(1, genero.getIdGenero());
			rowSet.updateString(2, genero.getNombre());
			rowSet.insertRow();
			System.out.println("Registro insertado!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Visualizar todos los géneros
	public void mostrarGeneros(Connection connection) {
		System.out.println("Listado de Géneros almacenados en la base de datos: ");
		ArrayList<Genero> listaGeneros = this.obtenerListaGeneros(connection);
		listaGeneros.forEach(genero -> System.out.println(genero));
	}
	
	public ArrayList<Genero> obtenerListaGeneros(Connection connection) {
		ArrayList<Genero> listaGeneros = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(Consultas.SELECT_ALL_GENEROS);
			while(resultSet.next()) {
				Genero genero = new Genero();
				genero.setIdGenero(resultSet.getInt(1));
				genero.setNombre(resultSet.getString(2));
				listaGeneros.add(genero);
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listaGeneros;
	}
	
	// ---------------------------------------------------------------------------------------------------------------------------------//
	// Actualizar géneros podcast
	
	
	public void eliminarGeneroPodcast(Connection connection, int idPodcast, int idGenero) {
		try {
			if (this.podcastTieneGenero(connection, idPodcast, idGenero)) {
				PreparedStatement preparedStatement = connection.prepareStatement(Consultas.DELETE_GEN_POD);
				preparedStatement.setInt(1, idPodcast);
				preparedStatement.setInt(2, idGenero);
				preparedStatement.executeUpdate();
				System.out.println("El género con id " + idGenero + " ha sido eliminado del podcast con id " + idPodcast);	
			}
			else {
				System.out.println("El podcast con id " + idPodcast + " no tiene el género " + idGenero);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	

	
	public void insertarGeneroPodcast(Connection connection, int idPodcast, int idGenero) {
		try {
			PreparedStatement preparedStatementGenPod = connection.prepareStatement(Consultas.INSERT_INTO_GEN_POD);
			preparedStatementGenPod.setInt(1, idPodcast);
			preparedStatementGenPod.setInt(2, idGenero);
			preparedStatementGenPod.executeUpdate();
			System.out.println("El género con id " + idGenero + " ha sido añadido del podcast con id " + idPodcast);	
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void actualizarGeneroPodcast(Connection connection, int idPodcast, int idGeneroViejo, int idGeneroNuevo) {
		try {
			if (this.podcastTieneGenero(connection, idPodcast, idGeneroViejo)) {
				PreparedStatement preparedStatementGenPod = connection.prepareStatement(Consultas.UPDATE_GEN_POD);
				preparedStatementGenPod.setInt(1, idGeneroNuevo);
				preparedStatementGenPod.setInt(2, idPodcast);
				preparedStatementGenPod.setInt(3, idGeneroViejo);
				preparedStatementGenPod.executeUpdate();
				System.out.println("El género con id " + idGeneroViejo + " ha sido actualizado a " + idGeneroNuevo + " en el podcast con id " + idPodcast);
			}
			else {
				System.out.println("El podcast con id " + idPodcast + " no tiene el género " + idGeneroViejo);
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public boolean podcastTieneGenero(Connection connection, int idPodcast, int idGenero) {
		String selectIdPodcastGen = "select idGenero from gen_pod where idPodcat=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectIdPodcastGen);
			preparedStatement.setInt(1, idPodcast);
			ResultSet resultSet =preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt(1) == idGenero) {
					return true;
				}				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
	// ---------------------------------------------------------------------------------------------------------------------------------//
	
	
	// ---------------------------------------------------------------------------------------------------------------------------------//
	// Eliminar un podcast por id. Primero eliminar gen_pod y después eliminar podcast
	
	public void eliminarPodcast(Connection connection, int idPodcast) {
		if (this.existePodcast(connection, idPodcast)) {
			// Eliminamos registros gen_pod
			this.eliminarRegistroTablaGenPod(connection, idPodcast);
			// Elimninamos registo podcast
			this.eliminarRegistroTablaPodcast(connection, idPodcast);
		}
		else {
			System.out.println("El podcast con id " + idPodcast + " no existe en la base de datos!");
		}
	}
		
	public void eliminarRegistroTablaGenPod(Connection connection, int idPodcast) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Consultas.DELETE_GEN_POD_IDPODCAST);
			preparedStatement.setInt(1, idPodcast);
			preparedStatement.executeUpdate();
			System.out.println("Registro eliminado de la tabla gen_pod");	
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void eliminarRegistroTablaPodcast(Connection connection, int idPodcast) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Consultas.DELETE_PODCAST_IDPODCAST);
			preparedStatement.setInt(1, idPodcast);
			preparedStatement.executeUpdate();
			System.out.println("Registro eliminado de la tabla Podcast");	
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// ---------------------------------------------------------------------------------------------------------------------------------//
	
	
	// ---------------------------------------------------------------------------------------------------------------------------------//
	// Visualizar todos los podcasts
	
	public void mostrarPodcasts(Connection connection) {
		LinkedList<Podcast> listaPodcasts = this.obtenterListaPodcasts(connection);
		System.out.println("Listado de Podcasts almacenados en la base de datos: ");
		listaPodcasts.forEach(podcast -> System.out.println(podcast));
	}
	
	public void mostrarIdTituloPodcasts(Connection connection) {
		LinkedList<Podcast> listaPodcasts = this.obtenterListaPodcasts(connection);
		System.out.println("Listado de Podcasts almacenados en la base de datos: ");
		listaPodcasts.forEach(podcast -> System.out.println("ID: " + podcast.getIdPodcast() + " - Título: " + podcast.getTitulo()));
	}
	
	public LinkedList<Podcast> obtenterListaPodcasts(Connection connection) {
		
		LinkedList<Podcast> listaPodcasts = new LinkedList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSetPodcast = statement.executeQuery(Consultas.SELECT_ALL_PODCASTS);
			while(resultSetPodcast.next()) {
				Podcast podcast = new Podcast();
				int idPodcast = resultSetPodcast.getInt(1);
				podcast.setIdPodcast(idPodcast);
				podcast.setTitulo(resultSetPodcast.getString(2));
				podcast.setTipo(resultSetPodcast.getByte(3));
				podcast.setCalidad(resultSetPodcast.getString(4));
				podcast.setDuracion(resultSetPodcast.getInt(5));
				podcast.setPericidad(resultSetPodcast.getString(6));
				podcast.setFormatoVideo(resultSetPodcast.getString(7));
				// Obtenemos Autor
				int idAutor = resultSetPodcast.getInt(8);		
				Autor autor = new Autor();
				autor.setFromSql(idAutor, connection);
				podcast.setAutor(autor);
				// Obtenemos Géneros Podcast
				ArrayList<Genero> listaGeneros = this.obternerListaGenerosPodcast(connection, idPodcast);
				podcast.setGeneros(listaGeneros);
				listaPodcasts.add(podcast);
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listaPodcasts;
	}
	
	public ArrayList<Genero> obternerListaGenerosPodcast(Connection connection, int idPodcast){
		
		ArrayList<Genero> listaGeneros = new ArrayList<>();
		try {
			PreparedStatement preparedStatementGenero = connection.prepareStatement(Consultas.SELECT_GENEROS_PODCAST);
			preparedStatementGenero.setInt(1, idPodcast);
			ResultSet resultSetGenero = preparedStatementGenero.executeQuery();
			while(resultSetGenero.next()) {
				Genero genero = new Genero();
				genero.setIdGenero(resultSetGenero.getInt(1));
				genero.setNombre(resultSetGenero.getString(2));
				listaGeneros.add(genero);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return listaGeneros;
	}
	
	// ---------------------------------------------------------------------------------------------------------------------------------//
	// Visualizar podcast

	
	public void verPodcast(JdbcRowSet rowSet, Connection connection, Scanner scanner) {
		
		try {
			rowSet.setCommand(Consultas.SELECT_ALL_PODCASTS);
			rowSet.execute();
			String salir;
			do {
				System.out.println("Introduzca la posición del podcast que quiere visualizar: ");
				int pos = Integer.parseInt(scanner.nextLine());
				try {
					if (rowSet.absolute(pos)) {
						System.out.println("Posición acutal");
						int idPodcast = rowSet.getInt(1);
						int idAutor = rowSet.getInt(8);
						Autor autor = new Autor();
						autor.setFromSql(idAutor, connection);
						ArrayList<Genero> listaGeneros = this.obternerListaGenerosPodcast(connection, idPodcast);
						Podcast podcast = new Podcast();
						podcast.setIdPodcast(idPodcast);
						podcast.setTitulo(rowSet.getString(2));
						podcast.setTipo(rowSet.getByte(3));
						podcast.setCalidad(rowSet.getString(4));
						podcast.setDuracion(rowSet.getInt(5));
						podcast.setPericidad(rowSet.getString(6));
						podcast.setFormatoVideo(rowSet.getString(7));
						podcast.setAutor(autor);
						podcast.setGeneros(listaGeneros);
						System.out.println(podcast.toString());
					}
					
					else {
						System.out.println("ERROR: La posición indicada no existe!");
					}
					
					if (rowSet.absolute(pos+1)) {
						System.out.println("Posición siguiente");
						int idPodcast = rowSet.getInt(1);
						int idAutor = rowSet.getInt(8);
						Autor autor = new Autor();
						autor.setFromSql(idAutor, connection);
						ArrayList<Genero> listaGeneros = this.obternerListaGenerosPodcast(connection, idPodcast);
						Podcast podcast = new Podcast();
						podcast.setIdPodcast(idPodcast);
						podcast.setTitulo(rowSet.getString(2));
						podcast.setTipo(rowSet.getByte(3));
						podcast.setCalidad(rowSet.getString(4));
						podcast.setDuracion(rowSet.getInt(5));
						podcast.setPericidad(rowSet.getString(6));
						podcast.setFormatoVideo(rowSet.getString(7));
						podcast.setAutor(autor);
						podcast.setGeneros(listaGeneros);
						System.out.println(podcast.toString());
					}
					else {
						System.out.println("ERROR: La posición siguiente no existe!");
					}
					
					if (rowSet.absolute(pos-1)) {
						System.out.println("Posición Anterior");
						int idPodcast = rowSet.getInt(1);
						int idAutor = rowSet.getInt(8);
						Autor autor = new Autor();
						autor.setFromSql(idAutor, connection);
						ArrayList<Genero> listaGeneros = this.obternerListaGenerosPodcast(connection, idPodcast);
						Podcast podcast = new Podcast();
						podcast.setIdPodcast(idPodcast);
						podcast.setTitulo(rowSet.getString(2));
						podcast.setTipo(rowSet.getByte(3));
						podcast.setCalidad(rowSet.getString(4));
						podcast.setDuracion(rowSet.getInt(5));
						podcast.setPericidad(rowSet.getString(6));
						podcast.setFormatoVideo(rowSet.getString(7));
						podcast.setAutor(autor);
						podcast.setGeneros(listaGeneros);
						System.out.println(podcast.toString());
					}
					else {
						System.out.println("ERROR: La posición anterior no existe!");
					}
				}
				catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Desea continuar visualizando más podcasts? SI - NO ");
				salir = scanner.nextLine();
			}while(salir.equalsIgnoreCase("si"));
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public boolean existePodcast(Connection connection, int idPodcast) {
		String sqlIdPodcast= "SELECT count(*) FROM Podcast WHERE idPodcast=?";
		try {
			PreparedStatement preparedStatement= connection.prepareStatement(sqlIdPodcast);
			// PreparedStatement preparedStatement= connection.prepareStatement(Consultas.SELECT_NUM_IDPODCAST);
			preparedStatement.setInt(1, idPodcast);
			ResultSet resultSetIdAutor = preparedStatement.executeQuery();
			resultSetIdAutor.next();
			int numIdGenero = resultSetIdAutor.getInt(1);
			if (numIdGenero == 1) {
				return true;
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	// ---------------------------------------------------------------------------------------------------------------------------------//
	

}


