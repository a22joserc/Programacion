package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class ConexionBaseDatos {
	
	private final static String USER_NAME = "root";
	private final static String PASSWORD = "B22s5.cz";
	private final static String URL = "jdbc:mysql://localhost:3306/testProgramacion";
	
	public final static String SELECT_SALAR_POS_POR_ID = "select posicion, salario from employees where id=?";
	public final static String SELECT_TOTAL_SALAR = "select sum(salario) from employees";
	public final static String SELECT_NUM_EMP_SAL_POS = "select count(*) from employees where salario > ? and lower(posicion) = ?";
	public final static String SELECT_ALL_EMP = "select * from employees";
	public final static String UDPATE_CTO = "update employees set posicion='CTO' where posicion='Jefe tecnico'";
	public final static String DELETE_EMP_POSIC = "delete from employees where lower(posicion)=?";
	public final static String INSERT_EMP = "insert into employees values(?,?,?,?)";
	public final static String SELECT_NUM_EMP = "select count(*) from employees";
	
	
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
