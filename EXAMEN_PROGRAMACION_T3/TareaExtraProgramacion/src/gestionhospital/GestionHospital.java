package gestionhospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import utils.ConexionBaseDatos;
import utils.HospitalException;

public class GestionHospital {
	
	private ArrayList<Paciente> listaPacientes;
	private ArrayList<Medico> listaMedicos;
	
	public GestionHospital() {
		this.listaPacientes = new ArrayList<>();
		this.listaMedicos = new ArrayList<>();
	}
	
	
	
	
	public ArrayList<Medico> obtenerMedicosBaseDatos(Connection connection){
		
		ArrayList<Medico> medicosLista = new ArrayList<>();
		
		try(Statement statement = connection.createStatement()) {
			
			ResultSet resultSet = statement.executeQuery(ConexionBaseDatos.SELECT_MEDICOS);
			
			while (resultSet.next()) {
				Medico medico = new Medico();
				String dniMedico = resultSet.getString(1);
				medico.setDni(dniMedico);
				medico.setNombre(resultSet.getString(2));
				medico.setApellidos(resultSet.getString(3));
				medico.obtenerPacientesBaseDatos(connection);
				/*
				// Obtenemos Pacientes vinculados a ese médico
				ArrayList<Paciente> pacientesLista = new ArrayList<>();
				try(PreparedStatement preparedStatement = connection.prepareStatement(ConexionBaseDatos.SELECT_PACIENTES_MEDICO)) {
					preparedStatement.setString(1, dniMedico);
					ResultSet resultSetPacientes = preparedStatement.executeQuery();
					while (resultSetPacientes.next()) {
						// Tipo paciente
						String tipoPaciente = resultSetPacientes.getString(4);
						//System.out.println(tipoPaciente);
						if (tipoPaciente.equalsIgnoreCase("urgente")) {
							Urgente pacienteU = new Urgente();
							pacienteU.setDni(resultSetPacientes.getString(1));
							pacienteU.setNombre(resultSetPacientes.getString(2));
							// Sexo Paciente
							if (resultSetPacientes.getString(3).equalsIgnoreCase("hombre")) {
								pacienteU.setSexo(tipoSexo.HOMBRE); 
							}
							else {
								pacienteU.setSexo(tipoSexo.MUJER); 
							}
							// Grado enfermedad
							if (resultSetPacientes.getInt(5) == 1) {
								pacienteU.setImpEnfermedad(gradoEnfermedad.Grado1);
							}
							else if (resultSetPacientes.getInt(5) == 2) {
								pacienteU.setImpEnfermedad(gradoEnfermedad.Grado2);
							}
							else {
								pacienteU.setImpEnfermedad(gradoEnfermedad.Grado3);
							}
							pacienteU.setFechaIngreso(resultSetPacientes.getDate(6).toLocalDate());
							pacientesLista.add(pacienteU);	
						}
						else {
							NoUrgente pacienteNU = new NoUrgente();
							pacienteNU.setDni(resultSetPacientes.getString(1));
							pacienteNU.setNombre(resultSetPacientes.getString(2));
							// Sexo Paciente
							if (resultSetPacientes.getString(3).equalsIgnoreCase("hombre")) {
								pacienteNU.setSexo(tipoSexo.HOMBRE); 
							}
							else {
								pacienteNU.setSexo(tipoSexo.MUJER); 
							}
							// Grado enfermedad
							if (resultSetPacientes.getInt(5) == 1) {
								pacienteNU.setImpEnfermedad(gradoEnfermedad.Grado1);
							}
							else if (resultSetPacientes.getInt(5) == 2) {
								pacienteNU.setImpEnfermedad(gradoEnfermedad.Grado2);
							}
							else {
								pacienteNU.setImpEnfermedad(gradoEnfermedad.Grado3);
							}
							pacienteNU.setNumHabitaction(resultSetPacientes.getInt(7));
							pacientesLista.add(pacienteNU);	
						}

					}
				
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				medico.setListaPacientes(pacientesLista);
				*/
				medicosLista.add(medico);	
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return medicosLista;
	}
	
	
	
	
	
	
	
	// Asignar paciente a médico
	
	public void anadirPacienteMedico(String dniPaciente, String dniMedico) throws HospitalException{
		if (this.getPaciente(dniPaciente) == null) {
			throw new HospitalException("ERROR: El paciente NO se encuentra registrado en sistema!");
		}
		if (this.getMedico(dniMedico) == null) {
			throw new HospitalException("ERROR: El médico NO se encuentra registrado en sistema!");
		}
		// Agregamos paciente a médico
		this.getMedico(dniMedico).anadirPaciente(this.getPaciente(dniPaciente));
	}
	
	// Añadir paciente al hospital
	
	public void anadirPacienteHospital(Paciente paciente)  throws HospitalException{
		if (this.getPaciente(paciente.getDni()) != null) {
			throw new HospitalException("ERROR: El paciente ya se encuentra registrado en sistema");
		}
		else {
			this.getListaPacientes().add(paciente);
		}
	}
	
	// Añadir medico al hospital
	public void anadirMedicoHospital(Medico medico) throws HospitalException{
		if (this.getMedico(medico.getDni()) != null) {
			throw new HospitalException("ERROR: El médico ya se encuentra registrado en sistema");
		}
		else {
			this.getListaMedicos().add(medico);
		}		
	}
	
	// Mostrar pacientes Hospital
	
	public void mostrarPacientesHospital() {
		this.getListaPacientes().forEach(p -> System.out.println(p.toString()));
	}
	
	// Mostrar médicos Hospital
	
	public void mostrarMedicosHospital() {
		this.getListaMedicos().forEach(m -> System.out.println(m.toString()));
	}
	
	// Get paciente
	public Paciente getPaciente(String dniPaciente) {
		Iterator<Paciente> iterator = this.getListaPacientes().iterator();
		while (iterator.hasNext()) {
			Paciente paciente = iterator.next();
			if (paciente.getDni().equals(dniPaciente)) {
				return paciente;
			}
		}
		return null;
	}
	
	// Get Medico
	public Medico getMedico(String dniMedico) {
		Iterator<Medico> iterator = this.getListaMedicos().iterator();
		while (iterator.hasNext()) {
			Medico medico = iterator.next();
			if (medico.getDni().equals(dniMedico)) {
				return medico;
			}
		}
		return null;
	}
	
	// GETTERS
	
	public ArrayList<Medico> getListaMedicos() {
		return listaMedicos;
	}
	
	public ArrayList<Paciente> getListaPacientes() {
		return listaPacientes;
	}

}
