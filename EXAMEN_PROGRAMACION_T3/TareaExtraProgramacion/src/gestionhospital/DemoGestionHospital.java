package gestionhospital;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import utils.ConexionBaseDatos;
import utils.HospitalException;
import utils.Menu;

public class DemoGestionHospital {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		GestionHospital gestionHospital = new GestionHospital();
			
		// 1.- Pacientes
		Urgente pacienteU1= new Urgente("87654321H", "Paciente Urgente 1", tipoSexo.HOMBRE, gradoEnfermedad.Grado1, LocalDate.now());
		Urgente pacienteU2= new Urgente("77744422H", "Paciente Uegente 2", tipoSexo.HOMBRE, gradoEnfermedad.Grado2, LocalDate.now());
		Urgente pacienteU3= new Urgente("66644422H", "Paciente Uegente 3", tipoSexo.HOMBRE, gradoEnfermedad.Grado3, LocalDate.now());
		Urgente pacienteU4= new Urgente("87654321H", "Paciente Urgente 1", tipoSexo.HOMBRE, gradoEnfermedad.Grado1, LocalDate.now());
		NoUrgente pacienteNU1 = new NoUrgente("12345678H", "Paciente No Urgente 1", tipoSexo.HOMBRE, gradoEnfermedad.Grado1, 401);
		NoUrgente pacienteNU2 = new NoUrgente("42345678H", "Paciente No Urgente 1", tipoSexo.HOMBRE, gradoEnfermedad.Grado1, 401);
		NoUrgente pacienteNU3 = new NoUrgente("52345678H", "Paciente No Urgente 1", tipoSexo.HOMBRE, gradoEnfermedad.Grado1, 401);
		

		try {
			// 2.- Añadimos pacientes al hospital
			gestionHospital.anadirPacienteHospital(pacienteNU3);
			gestionHospital.anadirPacienteHospital(pacienteNU2);
			gestionHospital.anadirPacienteHospital(pacienteNU1);
			gestionHospital.anadirPacienteHospital(pacienteU3);
			gestionHospital.anadirPacienteHospital(pacienteU2);
			gestionHospital.anadirPacienteHospital(pacienteU1);
			
			// 3.- Comprobamos que no podemos meter un paciente con el mismo Dni
			gestionHospital.anadirPacienteHospital(pacienteU4);

		} catch (HospitalException e) {
			System.out.println(e.getMessage());
		}
		
		// 4.- Mostramos Pacientes Hospital
		System.out.println("*************************************************************");
		gestionHospital.mostrarPacientesHospital();
		
		// 5.- Médicos
		
		Medico medico1 = new Medico("Nombre Medico 1", "Apellidos Medico 1", "12345678H");
		Medico medico2 = new Medico("Nombre Medico 2", "Apellidos Medico 2", "87654218H");
		// Médico 3 tiene mismo DNI que medico 1 -> Comprobamos que no se inserta 
		Medico medico3 = new Medico("Nombre Medico 3", "Apellidos Medico 3", "12345678H"); 
		
		try {
			gestionHospital.anadirMedicoHospital(medico1);
			gestionHospital.anadirMedicoHospital(medico2);
			gestionHospital.anadirMedicoHospital(medico3);	
			
		} catch (HospitalException e) {
			System.out.println(e.getMessage());
		}
		
		// Mostramos médicos Hospital 
		System.out.println("*************************************************************");
		gestionHospital.mostrarMedicosHospital();
		
		// 6.- Asignamos pacientes a medicos
		
		try {
			gestionHospital.anadirPacienteMedico(pacienteU1.getDni(), medico1.getDni());
			gestionHospital.anadirPacienteMedico(pacienteU2.getDni(), medico1.getDni());
			gestionHospital.anadirPacienteMedico(pacienteU3.getDni(), medico1.getDni());
			gestionHospital.anadirPacienteMedico(pacienteNU1.getDni(), medico1.getDni());
			// Probamos a añadir al medico un paciente con el mismo Dni
			gestionHospital.anadirPacienteMedico(pacienteU4.getDni(), medico1.getDni());
			
		} catch (HospitalException e) {
			System.out.println(e.getMessage());
		}
		
		// 7.- Mostramos Pacientes medico 1
		System.out.println("*************************************************************");
		gestionHospital.getMedico(medico1.getDni()).mostrarPacientes();
		
		
		// 8.- Imprimimos fichero
		/*
		System.out.println("*************************************************************");
		gestionHospital.getMedico(medico1.getDni()).informeFichero("./InformeMedico.txt");*/
		
		// 9.- Asignar paciente medico pidiendo datos por teclado
		/*
		System.out.println("*************************************************************");
		Menu.tecladoAsignarMedicoPaciente(gestionHospital, scanner);
		scanner.close();*/
		
		// 10.- Guardamos en Base Datos
		
		
		try (Connection connection = ConexionBaseDatos.openConnection()) {
			
			// medico1.guardarBaseDatos(connection);
			medico2.guardarBaseDatos(connection);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
