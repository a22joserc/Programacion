package gestionhospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.ConexionBaseDatos;

public class NoUrgente extends Paciente{
	
	// Atributos de clase
	private int numHabitaction;
	
	public NoUrgente() {
		super();
	}
	
	public NoUrgente(String dni, String nombre, tipoSexo sexo, gradoEnfermedad impEnfermedad, int numHabitacion) {
		super(dni, nombre, sexo, impEnfermedad);
		this.numHabitaction = numHabitacion;
	}
	
	@Override
	public void guardarBaseDatos(Connection connection, String dniMedico) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(ConexionBaseDatos.INSERT_PACIENTE_NOURGENTE)){
			preparedStatement.setString(1, this.getDni());
			preparedStatement.setString(2, this.getNombre());
			preparedStatement.setString(3, this.getSexo().toString());
			preparedStatement.setString(4, "No Urgente");
			if (this.getImpEnfermedad() == gradoEnfermedad.Grado1) {
				preparedStatement.setInt(5, 1);
			}
			else if (this.getImpEnfermedad() == gradoEnfermedad.Grado2) {
				preparedStatement.setInt(5, 2);
			}
			else {
				preparedStatement.setInt(5, 3);
			}
			preparedStatement.setInt(6, this.getNumHabitaction());;
			preparedStatement.setString(7, dniMedico);
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public String toString() {
		return "NoUrgente [numHabitaction=" + numHabitaction + ", dni=" + dni + ", nombre=" + nombre + ", sexo=" + sexo
				+ ", impEnfermedad=" + impEnfermedad + "]";
	}

	
	/*
	@Override
	public String toString() {
		return "DNI: " + this.getDni() + " - Nombre: " + this.getNombre() + " - Sexo: " + this.getSexo() + " - Importancia Enfermedad: " + this.getImpEnfermedad() + " - Núm Habitación: " + this.getNumHabitaction();
	}
	*/
	
	// Getters and setters
	
	public int getNumHabitaction() {
		return numHabitaction;
	}
	
	public void setNumHabitaction(int numHabitaction) {
		this.numHabitaction = numHabitaction;
	}

}
