package ddl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DemoGestionPerson {

	public static void main(String[] args) {
		
		Person person = new Person(6,"Valentino", "Rossi", 44);
		
		GestionPerson gestionPerson = new GestionPerson();
		
		try {
			// 1.- Método openConnection
			Connection connection = gestionPerson.openConnection();
			// 1.- Método insertPerson
			// int registrosAfectados = gestionPerson.insertPerson(connection, person);
			// System.out.println(registrosAfectados);
			// 3.- Método Update
			gestionPerson.updatePersonAgeById(connection, 1, 36);
			// 4.- Método select all
			List<Person> listaPersons = gestionPerson.selectAllPeople(connection);
			listaPersons.forEach(persona -> System.out.println(persona));
			// 5.- Método closeConnection
			gestionPerson.closeConnection(connection);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}
