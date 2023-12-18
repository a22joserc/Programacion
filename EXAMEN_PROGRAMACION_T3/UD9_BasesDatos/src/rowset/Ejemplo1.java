package rowset;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class Ejemplo1 {

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
		    while (rowSet.next()) {
                System.out.println("Id: "  + rowSet.getInt(1));
                System.out.println("Name: " + rowSet.getString(2));
                System.out.println("Posicion: " + rowSet.getString(3));
            }
		    // Movemos el puntero al último elemento
		    rowSet.last();
		    System.out.println("**************************************");
		    System.out.println("Id: "  + rowSet.getInt(1) + " - Name: " + rowSet.getString(2) + " - Posición: " + rowSet.getString(3));
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
