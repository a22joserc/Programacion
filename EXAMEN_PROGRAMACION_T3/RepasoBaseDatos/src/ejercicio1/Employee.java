package ejercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Employee {
	private int id;
    private String name;
    private String position;
    private double salary;
    
    
    public Employee() {}
    
    
    
    public Employee(int id, String name, String position, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.salary = salary;
	}


	public void insertBD(Connection connection) {
    	
    	try(PreparedStatement preparedStatement = connection.prepareStatement(ConexionBaseDatos.INSERT_EMP)){
	    	preparedStatement.setInt(1, this.getId());
	    	preparedStatement.setString(2, this.getName());
	    	preparedStatement.setString(3, this.getPosition());
	    	preparedStatement.setDouble(4, this.getSalary());
	    	preparedStatement.executeUpdate();
    	} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    }
        
    
    @Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", position=" + position + ", salary=" + salary + "]";
	}
    
	// GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
    
    
    
    
    

}
