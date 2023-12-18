package rowset;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class EjemploInsertRow {

	public static void main(String[] args) {
		JdbcRowSet rowSet;
		try {
			//obtenemos el rowset de forma estatica
		    rowSet = RowSetProvider.newFactory().createJdbcRowSet();
		    rowSet.setUrl("jdbc:mysql://dbalumnos.sanclemente.local:3319/JVR_empresa");
		    rowSet.setUsername("alumno");
		    rowSet.setPassword("abc123..");
		    // Asignamos consulta y ejecutamos 
		    rowSet.setCommand("select * from employees");
		    rowSet.execute();
		    // Permite hacer la consulta e insertar a la vez
		    // moveToInsertRow() se mueve hasta la última línea 
		    rowSet.moveToInsertRow();
		    rowSet.updateInt("emp_id", 500);
		    rowSet.updateString("name", "Bonifacio Martínez");
		    rowSet.updateString("posicion", "Abogado das Silveiras");
		    rowSet.updateFloat("salary",10000);
		    rowSet.insertRow();
		    rowSet.close();
		    System.out.println("**************************************");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
