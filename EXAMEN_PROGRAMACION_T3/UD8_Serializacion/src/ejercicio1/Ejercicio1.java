package ejercicio1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ejercicio1 {
	
	private static ArrayList<Employee> listaRecuperadaEmployees;

	public static void main(String[] args) {
		
		ArrayList<Employee> listaEmployees = new ArrayList<>();
		listaEmployees.add(new Employee("1", "Jose", "Ramos"));
		listaEmployees.add(new Employee("2", "Juan", "Lorenzo"));
		listaEmployees.add(new Employee("3", "Jorge", "Ruíz"));
		listaEmployees.add(new Employee("4", "Ramon", "López"));
		listaEmployees.add(new Employee("5", "Luis", "Martínez"));
		
		escribirEmployees(listaEmployees);
		leerEmployees();
		for (Employee employee:listaRecuperadaEmployees) {
			System.out.println(employee);
		}
	}
	
	
	public static void escribirEmployees(ArrayList<Employee> listaEmployees) {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("./Employees.dat"));
			objectOutputStream.writeObject(listaEmployees);
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void leerEmployees() {
		
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("./Employees.dat"));
			listaRecuperadaEmployees = (ArrayList<Employee>) objectInputStream.readObject();
			objectInputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
