package gestionpodcast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Autor {
	
	// Atributos de clase
	private int idAutor;
	private String dni;
	private String apellidos;
	private String nombre;
	
	public void setFromSql (int idAutor, Connection connection) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Consultas.SELECT_DNI_APELLIDOS_NOMBRE_AUTOR);
			preparedStatement.setInt(1, idAutor);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			this.setDni(resultSet.getString(1));
			this.setApellidos(resultSet.getString(2));
			this.setNombre(resultSet.getString(3));
			this.setIdAutor(idAutor);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// GETTERS
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public String getDni() {
		return dni;
	}
	
	// SETTERS
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	@Override
	public String toString() {
		return "iDAutor: " + this.getIdAutor() + " - DNI: " + this.getDni() + " - Apellidos: " + this.getApellidos() +  " - Nombre: " + this.getNombre();
	}
	

}
