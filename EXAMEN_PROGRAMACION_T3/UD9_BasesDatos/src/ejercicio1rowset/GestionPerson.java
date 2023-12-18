package ejercicio1rowset;

import java.sql.SQLException;
import java.util.LinkedList;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class GestionPerson {
	
	public JdbcRowSet getJdbcRowSet() throws SQLException {
		JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
		rowSet.setUrl("jdbc:mysql://dbalumnos.sanclemente.local:3319/JVR_empresa");
	    rowSet.setUsername("alumno");
	    rowSet.setPassword("abc123..");
	    return rowSet;
	}
	
	public LinkedList<Person> getAllPerson(JdbcRowSet rowSet) throws SQLException{
		LinkedList<Person> listaPerson = new LinkedList<>();
		rowSet.setCommand("select * from person");
	    rowSet.execute();
	    while(rowSet.next()) {
	    	Person person = new Person();
	    	person.setId(rowSet.getInt(1));
	    	person.setName(rowSet.getString(2));
	    	person.setLastName(rowSet.getString(3));
	    	person.setAge(rowSet.getInt(4));
	    	listaPerson.add(person);
	    }
	    return listaPerson;
	}
	
	
	public int getNumPerson(JdbcRowSet rowSet) throws SQLException{
		rowSet.setCommand("select count(*) from person");
		rowSet.execute();
		rowSet.next();
		return rowSet.getInt(1);
	}
	
	
	public void getRegistroPosicion(JdbcRowSet rowSet, int posicion) throws SQLException{
		rowSet.setCommand("select * from person");
	    rowSet.execute();    
	    
	    boolean existePos = rowSet.absolute(posicion);
	    if (existePos) {
	    	Person personPos = new Person(rowSet.getInt(1), rowSet.getString(2), rowSet.getString(3), rowSet.getInt(4));
	    	System.out.println(personPos.toString());
	    }
	    else {
	    	System.out.println("La posición indicada no existe la tabal de registros");
	    }
	    
	    boolean existeNext = rowSet.next();
	    if (existeNext) {
	    	Person personNext = new Person(rowSet.getInt(1), rowSet.getString(2), rowSet.getString(3), rowSet.getInt(4));
	    	System.out.println(personNext.toString());
	    }
	    else {
	    	System.out.println("La posición indicada no existe la tabal de registros");
	    }
	    
	    // Volvemos a la posición 
	    existePos = rowSet.absolute(posicion);
	    boolean existePrevious = rowSet.previous();
	    if (existePrevious) {
	    	Person personPrevious = new Person(rowSet.getInt(1), rowSet.getString(2), rowSet.getString(3), rowSet.getInt(4));
	    	System.out.println(personPrevious.toString());
	    }
	    else {
	    	System.out.println("La posición indicada no existe la tabal de registros");
	    }
		
	}
	
	public void updateEdad(JdbcRowSet rowSet, int posicion, int edad) throws SQLException{
		rowSet.setCommand("select * from person");
		rowSet.execute();
		rowSet.absolute(posicion);
		Person personPos = new Person(rowSet.getInt(1), rowSet.getString(2), rowSet.getString(3), rowSet.getInt(4));
		rowSet.updateInt("age", edad);
		rowSet.updateRow();
		System.out.println("Actualizando la edad de " + personPos.getName() + " " + personPos.getLastName() + " de " + personPos.getAge() + " a " + edad);
	}
	
	public void eliminarUltimoRegistro(JdbcRowSet rowSet) throws SQLException{
		rowSet.setCommand("select * from person");
		rowSet.execute();
		rowSet.last();
		Person personPos = new Person(rowSet.getInt(1), rowSet.getString(2), rowSet.getString(3), rowSet.getInt(4));
		rowSet.deleteRow();
		System.out.println("El registro " + personPos.toString() + " ha sido eliminado!");
	}
	
	public void insertPerson(JdbcRowSet rowSet) throws SQLException{
		 rowSet.setCommand("select * from person");
		 rowSet.execute();
		 rowSet.moveToInsertRow();
		 rowSet.updateInt(1, 6);
		 rowSet.updateString(2, "Bonifacio");
		 rowSet.updateString(3, "Martínez");
		 rowSet.updateInt(4, 35);
		 rowSet.insertRow();
		 System.out.println("Registro insertado!");
	}
	
	public static void main(String[] args) {
		
		GestionPerson gestionPerson = new GestionPerson();
		try(JdbcRowSet rowSet= gestionPerson.getJdbcRowSet()){
			// 1.- Obtenemos todos los registros de la tabla person
			LinkedList<Person> listaPerson = gestionPerson.getAllPerson(rowSet);
			listaPerson.forEach(persona -> System.out.println(persona));
			// 2.- Número de empleados de empleados
			System.out.println("Número total de personas: " + gestionPerson.getNumPerson(rowSet));
		    // 3.- Obtenemos registro por una posicion, su previo y su anterior.
			gestionPerson.getRegistroPosicion(rowSet, 6);
			// 4.- Update edad por posición 
			gestionPerson.updateEdad(rowSet,5, 38);
			// 5.- Eliminar el último registro
			gestionPerson.eliminarUltimoRegistro(rowSet);
			// 6.- Insertar una nueva persona
			gestionPerson.insertPerson(rowSet);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
