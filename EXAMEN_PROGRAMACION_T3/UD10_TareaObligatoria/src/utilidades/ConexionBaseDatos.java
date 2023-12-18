package utilidades;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBaseDatos {
	
	private final static String URL_BASE_DATOS = "jdbc:mariadb://dbalumnos.sanclemente.local:3319/JVR_tarea10_bd";
	private final static String USUARIO = "alumno";
	private final static String CONTRASENA = "abc123..";
	private final static String CREAR_TABLA = "CREATE TABLE carrera("
											  + "nombreCarrera varchar(50) primary key,"
											  + "nombreEquipo varchar(50),"
											  + "numeroParticipantes int unsigned,"
											  + "fechaInserccion date"
											  + ")"; 
	
	public final static String INSERT_CARRERA = "INSERT INTO carrera VALUES (?,?,?,?)";
	
	public static Connection openConnection() throws SQLException{
		Connection connection = DriverManager.getConnection(URL_BASE_DATOS,USUARIO,CONTRASENA);
		System.out.println("Conexion con la base de datos!");
		return connection;
	}
	
	
	public static void crearTablaCarrera(Connection connection) throws SQLException {
		Statement statement = connection.createStatement(); 
		statement.executeUpdate(CREAR_TABLA);
	}
	
	
	public static boolean tablaExiste(Connection connection, String nombreTabla) throws SQLException {	
		DatabaseMetaData databaseMetaData = connection.getMetaData();
		ResultSet resultSet = databaseMetaData.getTables(null, null, "carrera", new String[] {"TABLE"});
		while(resultSet.next()) {
			if(resultSet.getString(3).equals(nombreTabla)) {
				return true;
			}
		}
		return false;
	}

}
