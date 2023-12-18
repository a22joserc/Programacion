package utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gestionhospital.GestionHospital;

public class Menu {
	
	public static void tecladoAsignarMedicoPaciente(GestionHospital gestionHospital, Scanner scanner) {
		
		System.out.println("*************************************************************");
		System.out.println("Listado Médicos Hospital:");
		gestionHospital.mostrarMedicosHospital();
		System.out.println("*************************************************************");
		System.out.println("Listado Pacientes Hospital:");
		gestionHospital.mostrarPacientesHospital();
		System.out.println("*************************************************************");
		
		String dniMedico = Menu.validarDni(scanner, "médico");
		String dnipaciente = Menu.validarDni(scanner, "paciente");
		
		try {
			gestionHospital.anadirPacienteMedico(dnipaciente, dniMedico);
		} catch (HospitalException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static String validarDni(Scanner scanner, String opcion) {
		Pattern patron = Pattern.compile("[0-9]{8}[A-Z a-z]");
		Matcher matcher;
		String dni;
		do {
			System.out.println("Introduzca el DNI " + opcion + ":");
			dni = scanner.nextLine();
			matcher = patron.matcher(dni);
			if (!matcher.matches()) {
				System.out.println("ERROR: Formato de DNI erroneo!");
			}
		} while (!matcher.matches());
		
		return dni;
	}

}
