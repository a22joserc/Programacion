package ddl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IPerson {
	
	public Connection openConnection() throws SQLException;
    public int insertPerson(Connection connection, Person person) throws SQLException;
    public void updatePersonAgeById(Connection connection, int id, int newAge) throws SQLException;
    public List<Person> selectAllPeople(Connection connection) throws SQLException;

}
