package ejemplo1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Ejemplo1 {

	public static void main(String[] args) {
		ArrayList<Employee> listaEmployees = new ArrayList<>();
		String sURL = "jdbc:mariadb://dbalumnos.sanclemente.local:3319/JVR_empresa";
		String selectSql = "SELECT * FROM employees";
		try (Connection connection = DriverManager.getConnection(sURL,"alumno","abc123..")) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectSql);
			while(resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("emp_id"));
				employee.setName(resultSet.getString("name"));
				employee.setPosicion(resultSet.getString("posicion"));
				employee.setSalary(resultSet.getDouble("salary"));
				listaEmployees.add(employee);
			}
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
		
		listaEmployees.forEach(employee -> System.out.println(employee));
		

	}

}
