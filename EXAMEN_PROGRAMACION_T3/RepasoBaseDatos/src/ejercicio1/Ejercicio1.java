package ejercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		try (Connection connection = ConexionBaseDatos.openConnection();
			 JdbcRowSet rowSet = ConexionBaseDatos.openConnectionRowSet()) {
			
			mostrarSalarioPosPorId(scanner, connection);
			// System.out.println("Salario Acumulado (€): " + getSalarioAcumulado(connection));
			// System.out.println("Número empleados: " + getNumEmpSalPos(scanner, connection));
			//
			// updatePosicion(connection);
			//
			// deletePosicion(connection, scanner);
			//
			// insertEmployee(connection, scanner);
			//
			/*
			System.out.println("Lista Empleados:");
			ArrayList<Employee> listaEmployees = getAllEmployees(connection);
			listaEmployees.forEach(e -> System.out.println(e.toString()));*/
			
			// mostrarEmployeesRowSet(rowSet);
			
			// System.out.println("Número empleados: " + getNumEmployeesRowSet(rowSet));
			
			// mostrarEmployeePorPosicion(rowSet, scanner);
			
			// mostrarEmployeePorPosicionV2(rowSet, scanner);
			
			// actualizarSalarioPosicion(rowSet, scanner);
			
			// eliminarUltimoRegistro(rowSet);
			// insertarRegistro(rowSet, scanner);
			// mostrarEmployeesRowSet(rowSet);
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static void mostrarSalarioPosPorId(Scanner scanner, Connection connection) throws SQLException {
		
		System.out.println("Introduzca el ID del empleado:");
		int idEmpleado = Integer.parseInt(scanner.nextLine());
		PreparedStatement preparedStatement = connection.prepareStatement(ConexionBaseDatos.SELECT_SALAR_POS_POR_ID);
		preparedStatement.setInt(1, idEmpleado);
		ResultSet resultSet = preparedStatement.executeQuery();
		/*
		while (resultSet.next()) {
			String posicion = resultSet.getString(1);
			double salario = resultSet.getDouble(2);
			System.out.println("Salario: " + salario + " €, Posición: " + posicion);
		}
		*/
		if (resultSet.first()) {
			String posicion = resultSet.getString(1);
			double salario = resultSet.getDouble(2);
			System.out.println("Salario: " + salario + " €, Posición: " + posicion);
		}
		else {
			System.out.println("No existe ningún empleado con ID " + idEmpleado);
		}
	}
	
	
	public static double getSalarioAcumulado(Connection connection) throws SQLException {
		
		double salarioTotal = 0;
		// Creamos statement
		Statement statement = connection.createStatement();
		// Obtenems resultSet
		ResultSet resultSet = statement.executeQuery(ConexionBaseDatos.SELECT_TOTAL_SALAR);
		// Recorremos resultset
		while (resultSet.next()) {
			salarioTotal = resultSet.getDouble(1);
		}
		return salarioTotal;
	}
	
	
	public static int getNumEmpSalPos(Scanner scanner, Connection connection) throws SQLException {
		int numEmp = 0;
		//
		System.out.println("Introduzca el salario del empleado");
		double salario = Double.parseDouble(scanner.nextLine());
		System.out.println("Introduzca la posicion del empleado empleado");
		String posicion = scanner.nextLine().toLowerCase();
		// 
		PreparedStatement preparedStatement = connection.prepareStatement(ConexionBaseDatos.SELECT_NUM_EMP_SAL_POS);
		preparedStatement.setDouble(1, salario);
		preparedStatement.setString(2, posicion);
		//
		ResultSet resultSet = preparedStatement.executeQuery();
		//
		while (resultSet.next()) {
			numEmp = resultSet.getInt(1);
		}
		
		return numEmp;
	}
	
	
	public static ArrayList<Employee> getAllEmployees(Connection connection) throws SQLException{
		
		ArrayList<Employee> employees = new ArrayList<>();
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(ConexionBaseDatos.SELECT_ALL_EMP);
		while (resultSet.next()) {
			Employee employee = new Employee();
			employee.setId(resultSet.getInt(1));
			employee.setName(resultSet.getString(2));
			employee.setPosition(resultSet.getString(3));
			employee.setSalary(resultSet.getDouble(4));
			employees.add(employee);			
		}
		
		return employees;
		
	}
	
	
	public static void updatePosicion(Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(ConexionBaseDatos.UDPATE_CTO);
	}
	
	
	public static void deletePosicion(Connection connection, Scanner scanner) throws SQLException {
		
		System.out.println("Introduzca la posicion de los empleados que quiere eliminar:");
		String posicion = scanner.nextLine().toLowerCase();
		//
		PreparedStatement preparedStatement = connection.prepareStatement(ConexionBaseDatos.DELETE_EMP_POSIC);
		preparedStatement.setString(1, posicion);
		//
		preparedStatement.executeUpdate();
		
	}
	
	public static void insertEmployee(Connection connection, Scanner scanner) {
		
		System.out.println("Introduzca el ID empleado");
		Integer id = Integer.parseInt(scanner.nextLine());
		System.out.println("Introduzca el nombre del empleado");
		String nombre = scanner.nextLine();
		System.out.println("Introduzca la posicion del empleado");
		String posicion = scanner.nextLine();
		System.out.println("Introduzca el salario del empleado");
		double salario = Double.parseDouble(scanner.nextLine());
		// Generamos objeto
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(nombre);
		employee.setPosition(posicion);
		employee.setSalary(salario);
		//
		employee.insertBD(connection);
		
	}
	
	
	public static void mostrarEmployeesRowSet(JdbcRowSet rowSet) throws SQLException {
		
		rowSet.setCommand(ConexionBaseDatos.SELECT_ALL_EMP);
		rowSet.execute();
		
		while(rowSet.next()) {
			Employee employee = new Employee();
			employee.setId(rowSet.getInt(1));
			employee.setName(rowSet.getString(2));
			employee.setPosition(rowSet.getString(3));
			employee.setSalary(rowSet.getDouble(4));
			System.out.println(employee.toString());
		}
		
	}
	
	
	public static int getNumEmployeesRowSet(JdbcRowSet rowSet) throws SQLException {
		rowSet.setCommand(ConexionBaseDatos.SELECT_NUM_EMP);
		rowSet.execute();
		// Nos Colocamos en la primera fila del rowSet ya que sólo tiene un único registro
		rowSet.absolute(1);
		int numEmp = rowSet.getInt(1);
		return numEmp;
	
	}
	
	
	public static void mostrarEmployeePorPosicion(JdbcRowSet rowSet, Scanner scanner) throws SQLException {
		
		// Hacemos la consulta
		rowSet.setCommand(ConexionBaseDatos.SELECT_ALL_EMP);
		rowSet.execute();
		// Solicitamos la posicion al usuario
		System.out.println("Introduzca la posición del registo que quiere visualizar");
		int pos = Integer.parseInt(scanner.nextLine());
		// Mostramos Registro Posición Indicada Usuario
		System.out.println("Registro posición : " + pos);
		try {
			if (rowSet.absolute(pos)) {
				Employee employee = new Employee(rowSet.getInt(1), rowSet.getString(2), rowSet.getString(3), rowSet.getDouble(4));
				System.out.println(employee.toString());
			}
			else {
				System.out.println("La posción indicada no existe!");
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Mostramos posición anterior
		System.out.println("Registro posición anterior: " + (pos-1));
		try {
			if (rowSet.absolute(pos-1)) {
				Employee employee = new Employee(rowSet.getInt(1), rowSet.getString(2), rowSet.getString(3), rowSet.getDouble(4));
				System.out.println(employee.toString());
			}
			else {
				System.out.println("La posción indicada no existe!");
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Mostramos posición Siguinete
		System.out.println("Registro posición siguiente: " + (pos+1));
		try {
			if (rowSet.absolute(pos+1)) {
				Employee employee = new Employee(rowSet.getInt(1), rowSet.getString(2), rowSet.getString(3), rowSet.getDouble(4));
				System.out.println(employee.toString());
			}
			else {
				System.out.println("La posción indicada no existe!");
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
	public static void mostrarEmployeePorPosicionV2(JdbcRowSet rowSet, Scanner scanner) throws SQLException {
		
		// Hacemos la consulta
		rowSet.setCommand(ConexionBaseDatos.SELECT_ALL_EMP);
		rowSet.execute();
		// Solicitamos la posicion al usuario
		int pos;
		do {
			System.out.println("Introduzca la posición del registo que quiere visualizar");
			pos = Integer.parseInt(scanner.nextLine());
			if (pos < 1) {
				System.out.println("ERROR: Debe introducir una posición mayor que 0");
			}
		} while(pos < 1);
		// Generamos una Lista con las posiciones a buscar
		List<Integer> posiciones =  Arrays.asList(pos-1,pos, pos+1);
		// Mostramos registros para cada de las posiciones
		for (Integer posicion:posiciones) {
			System.out.println("Registro posición : " + posicion);
			try {
				if (rowSet.absolute(posicion)) {
					Employee employee = new Employee(rowSet.getInt(1), rowSet.getString(2), rowSet.getString(3), rowSet.getDouble(4));
					System.out.println(employee.toString());
				}
				else {
					System.out.println("La posción indicada no existe!");
				}
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}
	
	
	public static void actualizarSalarioPosicion(JdbcRowSet rowSet, Scanner scanner) throws SQLException {
		
		// Seleccionamos todos los registros
		rowSet.setCommand(ConexionBaseDatos.SELECT_ALL_EMP);
		rowSet.execute();
		// Solicitamos Posicion
		System.out.println("Introduzca la posición del registo que quiere actualizar");
		int pos = Integer.parseInt(scanner.nextLine());
		System.out.println("Introduzca el nuevo valor del salario");
		double nuevoSalario = Double.parseDouble(scanner.nextLine());
		try {
			// Nos colocamos en la posicion
			rowSet.absolute(pos);
			// Seleccionamos el nuevo salario
			rowSet.updateDouble(4, nuevoSalario);
			// Actualizamos Fila
			rowSet.updateRow();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public static void eliminarUltimoRegistro(JdbcRowSet rowSet) throws SQLException {
		// Seleccionamos todos los registros
		rowSet.setCommand(ConexionBaseDatos.SELECT_ALL_EMP);
		rowSet.execute();
		// Nos posicionamos en el último registro
		rowSet.last();
		// Eliminamos el registro
		rowSet.deleteRow();
		
	}
	
	public static void insertarRegistro(JdbcRowSet rowSet, Scanner scanner) throws SQLException {
		// Seleccionamos los regitros
		rowSet.setCommand(ConexionBaseDatos.SELECT_ALL_EMP);
		rowSet.execute();
		// Nos movemos a la fila de insercion
		rowSet.moveToInsertRow();
		try {
			System.out.println("Introduzca el id del empleado");
			int id = Integer.parseInt(scanner.nextLine());
			rowSet.updateInt(1, id);
			System.out.println("Introduzca el nombre del empleado");
			String nombre = scanner.nextLine();
			rowSet.updateString(2, nombre);
			System.out.println("Introduzca la posicion del empleado");
			String posicion = scanner.nextLine();
			rowSet.updateString(3, posicion);
			System.out.println("Introduzca el valor del salario");
			double salario = Double.parseDouble(scanner.nextLine());
			rowSet.updateDouble(4, salario);
			rowSet.insertRow();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
		
	
}
