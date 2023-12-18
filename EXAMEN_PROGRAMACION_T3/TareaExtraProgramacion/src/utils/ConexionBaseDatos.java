package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class ConexionBaseDatos {
	
	private final static String USER_NAME = "root";
	private final static String PASSWORD = "B22s5.cz";
	private final static String URL = "jdbc:mysql://localhost:3306/hospitalBD";
	
	// Sentencias SQL
	
	public final static String INSERT_PACIENTE_URGENTE = "insert into pacientes(dni,nombre,sexo,tipoPaciente,gradoEnf,fechaIngreso,dniMedico) values (?,?,?,?,?,?,?)";
	public final static String INSERT_PACIENTE_NOURGENTE = "insert into pacientes(dni,nombre,sexo,tipoPaciente,gradoEnf,numHabitacion,dniMedico) values (?,?,?,?,?,?,?)";
	public final static String INSERT_MEDICO = "insert into medicos values(?,?,?)";
	
	public final static String SELECT_PACIENTES_MEDICO = "select p.dni, p.nombre, p.sexo, p.tipopaciente, p.gradoenf, p.fechaingreso, p.numhabitacion from pacientes p inner join medicos m on p.dniMedico = m.dni where m.dni=?";
	public final static String SELECT_MEDICOS = "select * from medicos";
	
	
	
	public static Connection openConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		System.out.println("Conexion con la base de datos!");
		return connection;
		
	}
	
	public static JdbcRowSet openConnectionRowSet() throws SQLException {
		JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
		rowSet.setUrl(URL);
		rowSet.setUsername(USER_NAME);
		rowSet.setPassword(PASSWORD);
		System.out.println("Conexión Base datos RowSet");
		return rowSet;		
	}
	

}
