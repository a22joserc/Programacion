package ejemplo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EjemploConexion {

	public static void main(String[] args) {
		
		String sURL = "jdbc:mariadb://dbalumnos.sanclemente.local:3319/test";
		/*
			Connection con = null;
		  try {
	
		      con = (Connection) DriverManager.getConnection(sURL,"alumno","abc123..");
		      System.out.println ("¡Conexión exitosa!");
		      System.out.println(con.prepareStatement("SELECT 1"));
		      
	
		  } 
		  catch (Exception e) { 
		     System.out.println("Error en la conexión:" + e.toString() );
		  } 
		  finally {
			  try {
			      // Cerramos posibles conexiones abiertas
			      if (con!=null) con.close();    
			  } 
			  catch (Exception e) {
				  System.out.println("Error cerrando conexiones: " + e.toString());
			  } 
		}
		*/
		try (Connection connection = DriverManager.getConnection(sURL,"alumno","abc123..")) {
			 System.out.println ("¡Conexión exitosa!");
		     System.out.println(connection.prepareStatement("SELECT 1"));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public static boolean isConnectionValid(Connection connection){
	    try {
	        if (connection != null && !connection.isClosed()) {
	            // Running a simple validation query
	            connection.prepareStatement("SELECT 1");
	            return true;
	        }
	    }
	    catch (SQLException e) {
	        // log some useful data here
	    }
	    return false;
	}

}
