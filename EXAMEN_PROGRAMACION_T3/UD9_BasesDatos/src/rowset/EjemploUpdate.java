package rowset;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class EjemploUpdate {

	public static void main(String[] args) {
		JdbcRowSet rowSet;
		try {
			//obtenemos el rowset de forma estatica
		    rowSet = RowSetProvider.newFactory().createJdbcRowSet();
		    rowSet.setUrl("jdbc:mysql://dbalumnos.sanclemente.local:3319/JVR_empresa");
		    rowSet.setUsername("alumno");
		    rowSet.setPassword("abc123..");
		    // Asignamos consulta y ejecutamos 
		    rowSet.setCommand("select * from person");
		    rowSet.execute();
		    // Movemos el puntero al último elemento y Actualizamos
		    // Permite hacer la consulta y actualizar a la vez
		    rowSet.last();
		    rowSet.updateInt("age", 120);
		    rowSet.updateRow();
		    rowSet.close();
		    System.out.println("**************************************");
		    System.out.println("Id: "  + rowSet.getInt(1) + " - Name: " + rowSet.getString(2) + " - Posición: " + rowSet.getString(3));
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
