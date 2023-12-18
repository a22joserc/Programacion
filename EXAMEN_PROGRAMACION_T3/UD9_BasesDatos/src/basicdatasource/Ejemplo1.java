package basicdatasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import org.apache.commons.dbcp2.BasicDataSource;


public class Ejemplo1 {

	public static void main(String[] args) throws SQLException {
		
		BasicDataSource dataSource = new BasicDataSource();
        //dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		// "jdbc:mariadb://dbalumnos.sanclemente.local:3319/JVR_empresa";
        // dataSource.setUrl("jdbc:mysql://localhost:3306/hola");
		dataSource.setUrl("jdbc:mysql://dbalumnos.sanclemente.local:3319/JVR_empresa");
        // "alumno" 
        dataSource.setUsername("alumno");
        //"abc123.."
        dataSource.setPassword("abc123..");
        dataSource.setInitialSize(5);
        dataSource.setMaxTotal(10);
        
        // Obtener una conexión del pool
        Connection connection = dataSource.getConnection();
        
        // Usar la conexión para enviar consultas
        // ...
        
        Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM person");
		LinkedList<Person> listaPerson = new LinkedList<>();
		while(resultSet.next()) {
			Person person = new Person();
			person.setId(resultSet.getInt(1));
			person.setName(resultSet.getString(2));
			person.setLastName(resultSet.getString(3));
			person.setAge(resultSet.getInt(4));
			listaPerson.add(person);
		}
		listaPerson.forEach(persona -> System.out.println(persona));
        // Devolver la conexión al pool
        connection.close();
        dataSource.close();

	}

}
