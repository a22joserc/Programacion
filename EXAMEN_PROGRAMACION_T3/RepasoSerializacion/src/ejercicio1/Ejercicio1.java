package ejercicio1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		ArrayList<Employee> lista = new ArrayList<>();
		lista.add(new Employee("E1", "Jose", "Ramos"));
		lista.add(new Employee("E2", "Juan", "Ramos"));
		lista.add(new Employee("E3", "Luis", "Ramos"));
		lista.add(new Employee("E4", "Fernando", "Ramos"));
		// Guardamos 
		guardarListaEmployees(lista,"empleados.dat");
		// Leemos
		ArrayList<Employee> listaRecuperada = leerListaEmployees("empleados.dat");
		// Recorremos lista
		listaRecuperada.forEach(e -> System.out.println(e.toString()));
		

	}
	
	public static void guardarListaEmployees(ArrayList<Employee> listaEmployees, String fichero) {
		
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fichero))) {
			objectOutputStream.writeObject(listaEmployees);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static ArrayList<Employee> leerListaEmployees(String fichero){
		
		// ArrayList<Employee> listaEmployees = null;
		
		ArrayList<Employee> listaEmployees = new ArrayList<>();
		
		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fichero))) {
			
			listaEmployees.addAll((ArrayList<Employee>) objectInputStream.readObject());	
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		
		return listaEmployees;
	}

}
