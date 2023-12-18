package rowset;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class EjemploDeleteRow {

	public static void main(String[] args) {
		
		// También se puede usar con try-with-resources
		try(JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet()) {
		    rowSet.setUrl("jdbc:mysql://dbalumnos.sanclemente.local:3319/JVR_empresa");
		    rowSet.setUsername("alumno");
		    rowSet.setPassword("abc123..");
		    // Asignamos consulta y ejecutamos 
		    rowSet.setCommand("select * from employees");
		    rowSet.execute();
		    // Movemos el cursor al último registros y lo eliminamos
		    rowSet.last();
		    rowSet.deleteRow();
		    rowSet.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}

