package ddl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class GestionPerson  implements IPerson {
	
	public GestionPerson() {
		
	}
	
	@Override
	public Connection openConnection() throws SQLException{
		String sURL = "jdbc:mariadb://dbalumnos.sanclemente.local:3319/JVR_podcast_bd";
		Connection connection = DriverManager.getConnection(sURL,"alumno","abc123..");
		System.out.println("Conexion con la base de datos!");
		return connection;
	}
	
	@Override
	public int insertPerson(Connection connection, Person person) throws SQLException {
		String queryInsert = "INSERT INTO person VALUES (?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(queryInsert);
		preparedStatement.setInt(1, person.getId());
		preparedStatement.setString(2, person.getName());
		preparedStatement.setString(3, person.getLastName());
		preparedStatement.setInt(4, person.getAge());
		int registrosAfectados = preparedStatement.executeUpdate();
		preparedStatement.close();
		return registrosAfectados;
	}
	
	@Override
	public void updatePersonAgeById(Connection connection, int id, int newAge) throws SQLException{
		String queryUpdate = "UPDATE person SET age=? WHERE id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate);
		preparedStatement.setInt(1, newAge);
		preparedStatement.setInt(2, id);
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
	@Override
	public List<Person> selectAllPeople(Connection connection) throws SQLException{
		LinkedList<Person> listaPerson = new LinkedList<>();
		String querySelect = "SELECT * FROM person";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(querySelect);
		while(resultSet.next()) {
			Person person = new Person();
			person.setId(resultSet.getInt(1));
			person.setName(resultSet.getString(2));
			person.setLastName(resultSet.getString(3));
			person.setAge(resultSet.getInt(4));
			listaPerson.add(person);
		}
		resultSet.close();
		statement.close();
		return listaPerson;
	}

	public void closeConnection(Connection connection) throws SQLException {
		connection.close();
		System.out.println("Cerrando conexion con la base de datos!");
	}
	
	// Cerrando con try with resources los resultSet y Statements
	
	// IMPORTANTE CERRAR RECURSOS
	
	/* 
	@Override
	public int insertPerson(Connection connection, Person person) throws SQLException {
		String queryInsert = "INSERT INTO person VALUES (?,?,?,?)";
		try(PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)){
			preparedStatement.setInt(1, person.getId());
			preparedStatement.setString(2, person.getName());
			preparedStatement.setString(3, person.getLastName());
			preparedStatement.setInt(4, person.getAge());
			int registrosAfectados = preparedStatement.executeUpdate();
			return registrosAfectados;
		}
	}
	
	@Override
	public void updatePersonAgeById(Connection connection, int id, int newAge) throws SQLException{
		String queryUpdate = "UPDATE person SET age=? WHERE id=?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate)){
			preparedStatement.setInt(1, newAge);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		}
	}
	
	@Override
	public List<Person> selectAllPeople(Connection connection) throws SQLException{
		LinkedList<Person> listaPerson = new LinkedList<>();
		String querySelect = "SELECT * FROM person";
		try(Statement statement = connection.createStatement(); 
			ResultSet resultSet = statement.executeQuery(querySelect)){
			while(resultSet.next()) {
				Person person = new Person();
				person.setId(resultSet.getInt(1));
				person.setName(resultSet.getString(2));
				person.setLastName(resultSet.getString(3));
				person.setAge(resultSet.getInt(4));
				listaPerson.add(person);
			}
			return listaPerson;
		}
	}
	 
	*/

}
