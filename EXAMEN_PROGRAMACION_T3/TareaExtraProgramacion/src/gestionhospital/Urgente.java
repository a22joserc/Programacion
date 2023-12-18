package gestionhospital;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import utils.ConexionBaseDatos;

public class Urgente extends Paciente{
	
	// Atributos de Clase
	private LocalDate fechaIngreso;
	
	public Urgente() {
		super();
	}
	
	public Urgente(String dni, String nombre, tipoSexo sexo, gradoEnfermedad impEnfermedad, LocalDate fechaIngreso) {
		super(dni, nombre, sexo, impEnfermedad);
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public void guardarBaseDatos(Connection connection, String dniMedico) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(ConexionBaseDatos.INSERT_PACIENTE_URGENTE)){
			preparedStatement.setString(1, this.getDni());
			preparedStatement.setString(2, this.getNombre());
			preparedStatement.setString(3, this.getSexo().toString());
			preparedStatement.setString(4, "Urgente");
			if (this.getImpEnfermedad() == gradoEnfermedad.Grado1) {
				preparedStatement.setInt(5, 1);
			}
			else if (this.getImpEnfermedad() == gradoEnfermedad.Grado2) {
				preparedStatement.setInt(5, 2);
			}
			else {
				preparedStatement.setInt(5, 3);
			}
			preparedStatement.setDate(6, Date.valueOf(this.getFechaIngreso()));
			preparedStatement.setString(7, dniMedico);
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	@Override
	public String toString() {
		return "Urgente [fechaIngreso=" + fechaIngreso + ", dni=" + dni + ", nombre=" + nombre + ", sexo=" + sexo
				+ ", impEnfermedad=" + impEnfermedad + "]";
	}
	
	
	
	// GETTERS AND SETTERS
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
}
