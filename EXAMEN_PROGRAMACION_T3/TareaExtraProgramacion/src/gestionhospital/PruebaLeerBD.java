package gestionhospital;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.ConexionBaseDatos;

public class PruebaLeerBD {

	public static void main(String[] args) {
		
		GestionHospital gestionHospital = new GestionHospital();
		
		try (Connection connection = ConexionBaseDatos.openConnection()) {
			
			ArrayList<Medico> listaMedicos =  gestionHospital.obtenerMedicosBaseDatos(connection);
			
			for (Medico medico: listaMedicos) {
				System.out.println(medico.toString());
				for (Paciente paciente: medico.getListaPacientes()) {
					System.out.println(paciente.toString());
				}
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		/*
		int numero = 87654321;
		
		for (int i=0; i<3; i++) {
			numero--;
			String dniM = String.valueOf(numero).concat("H"); 
			System.out.println("Medico " + (i+1) + " - DNI: " + dniM);
			for (int j=0; j<3; j++) {
				numero--;
				String dniP = String.valueOf(numero).concat("K"); 
				System.out.println("Paciente " + (j+1) + " - DNI: " + dniP);
			}
			
		}
		*/

	}

}
