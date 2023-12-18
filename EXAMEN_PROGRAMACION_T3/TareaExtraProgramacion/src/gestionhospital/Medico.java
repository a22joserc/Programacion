package gestionhospital;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;

import utils.ConexionBaseDatos;
import utils.HospitalException;

public class Medico {
	
	// Atributos de clase
	private String nombre;
	private String apellidos;
	private String dni;
	private ArrayList<Paciente> listaPacientes;
	
	public Medico() {
		this.listaPacientes = new ArrayList<>();
	}
	
	public Medico(String nombre, String apellidos, String dni) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.listaPacientes = new ArrayList<>();
	}
	
	
	
	public void guardarBaseDatos(Connection connection) {
		
		try(PreparedStatement preparedStatement = connection.prepareStatement(ConexionBaseDatos.INSERT_MEDICO)) {
			preparedStatement.setString(1, this.getDni());
			preparedStatement.setString(2, this.getNombre());
			preparedStatement.setString(3, this.getApellidos());
			preparedStatement.executeUpdate();
			// Guardamos los pacientes asociados a cada medico en la tabla Pacientes
			for (Paciente paciente: this.getListaPacientes()) {
				paciente.guardarBaseDatos(connection, this.getDni());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void obtenerPacientesBaseDatos(Connection connection) {
	
		// ArrayList<Paciente> pacientesLista = new ArrayList<>();
		try(PreparedStatement preparedStatement = connection.prepareStatement(ConexionBaseDatos.SELECT_PACIENTES_MEDICO)) {
			preparedStatement.setString(1, this.getDni());
			ResultSet resultSetPacientes = preparedStatement.executeQuery();
			while (resultSetPacientes.next()) {
				// Tipo paciente
				String tipoPaciente = resultSetPacientes.getString(4);
				// Sexo Paciente
				tipoSexo sexoPaciente;
				if (resultSetPacientes.getString(3).equalsIgnoreCase("hombre")) {
					sexoPaciente = tipoSexo.HOMBRE; 
				}
				else {
					sexoPaciente = tipoSexo.MUJER; 
				}
				// Grado Enfermedad
				gradoEnfermedad enfGrado;
				if (resultSetPacientes.getInt(5) == 1) {
					enfGrado = gradoEnfermedad.Grado1;
				}
				else if (resultSetPacientes.getInt(5) == 2) {
					enfGrado = gradoEnfermedad.Grado2;
				}
				else {
					enfGrado = gradoEnfermedad.Grado3;
				}
				if (tipoPaciente.equalsIgnoreCase("urgente")) {
					Urgente pacienteU = new Urgente();
					pacienteU.setDni(resultSetPacientes.getString(1));
					pacienteU.setNombre(resultSetPacientes.getString(2));
					// Sexo Paciente
					pacienteU.setSexo(sexoPaciente); 
					pacienteU.setImpEnfermedad(enfGrado);
					pacienteU.setFechaIngreso(resultSetPacientes.getDate(6).toLocalDate());
					// pacientesLista.add(pacienteU);	
					this.getListaPacientes().add(pacienteU);
				}
				else {
					NoUrgente pacienteNU = new NoUrgente();
					pacienteNU.setDni(resultSetPacientes.getString(1));
					pacienteNU.setNombre(resultSetPacientes.getString(2));
					// Sexo Paciente
					pacienteNU.setSexo(sexoPaciente); 
					// Grado enfermedad
					pacienteNU.setImpEnfermedad(enfGrado);
					pacienteNU.setNumHabitaction(resultSetPacientes.getInt(7));
					// pacientesLista.add(pacienteNU);
					this.getListaPacientes().add(pacienteNU);
				}
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// this.setListaPacientes(pacientesLista);		
	
	}
	
	
	
	
	
	public void anadirPaciente(Paciente paciente) throws HospitalException {
		if (this.getListaPacientes().contains(paciente)) {
			throw new HospitalException("ERROR: El paciente ya se encuentra asignado a dicho médico!");
		}
		else {
			this.getListaPacientes().add(paciente);
		}
	}
	
	
	public void informeFichero(String nombreFichero) {
		
		try {
            PrintWriter printWriter = new PrintWriter(nombreFichero);
            printWriter.println("Médico: " + this.getDni() + ", Núm pacientes: " + this.getNumPacientes());
            Collections.sort(this.getListaPacientes(), new PacienteComparator());
            Iterator<Paciente> iterator = this.getListaPacientes().iterator();
            while (iterator.hasNext()) {
            	Paciente paciente = iterator.next();
            	if (paciente.getImpEnfermedad() == gradoEnfermedad.Grado1) {
            		printWriter.println("Grado 1: " + paciente.getDni());
            	}
            	else if (paciente.getImpEnfermedad() == gradoEnfermedad.Grado2) {
            		printWriter.println("Grado 2: " + paciente.getDni());
            	}
            	else {
            		printWriter.println("Grado 3: " + paciente.getDni());
            	}
            }

            printWriter.close();
        } 
		catch (Exception e) {
            System.out.println(e.getMessage());
		}
		
	}
	
	
	// Num pacientes médico
	public int getNumPacientes() {
		return this.getListaPacientes().size();
	}
	
	@Override
	public String toString() {
		return "Medico - Nombre: " + this.getNombre() + " - Apellidos: " + this.getApellidos() + " - DNI: " + this.getDni();
	}
	
	// Mostrar pacientes
	public void mostrarPacientes() {
		System.out.println(this.toString());
		System.out.println("Pacientes asignados: ");
		this.getListaPacientes().forEach(p -> System.out.println(p.toString()));
	}
	
	// Se comparan Objetos Medico por dni

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Medico))
			return false;
		Medico other = (Medico) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	// Getters and Setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public ArrayList<Paciente> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}
	
	
	
	

}
