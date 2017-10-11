package jdbc2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JdbcPersonAccess {

	private JdbcAddressAccess jdbcAddressAccess = new JdbcAddressAccess();

	public Person find(String id) {
		try {
			String query = "SELECT * FROM person";
			//String query = "SELECT * FROM person WHERE id='" + id + "';";
			System.out.println(query);
			ResultSet resultSet = getStatement().executeQuery(query);
			while (!resultSet.last()) {
				resultSet.next();
			}

			String addressId = resultSet.getString("address_id");

			Address address = jdbcAddressAccess.find(addressId);

			Person person = new Person(resultSet.getString("id"),
					resultSet.getString("firstname"), resultSet.getString("lastname"),
					resultSet.getInt("age"), address);

			return person;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	public void create(Person object) {
		try {
			String query = "INSERT INTO person VALUES ('" + object.getId()
					+ "', " + object.getAge() + ",'" + object.getFirstname() + "','"
					+ object.getLastname() + "','" + object.getAddress().getId() + "');";
			System.out.println(query);
			Statement statement = getStatement();
			statement.executeUpdate(query);
			//statement.close();
		} catch (SQLException se) {
		}
		System.out.println("Person added! ");
	}

	public void update(Person object) {
		try {
			String query = "Update person set age = " + object.getAge()
					+ ", firstname = '" + object.getFirstname() + "', lastname = '"
					+ object.getLastname() + "' where id = '" + object.getId() + "';";
			System.out.println(query);
			Statement statement = getStatement();
			statement.executeUpdate(query);
			statement.close();
		} catch (SQLException se) {
		}
		System.out.println("Person updated! ");
	}

	public void delete(Person object) {
		try {
			String query = "Delete from person where id = '" + object.getId()
					+ "';";
			System.out.println(query);
			Statement statement = getStatement();
			statement.executeUpdate(query);
			statement.close();
		} catch (SQLException se) {
		}
		System.out.println("Person removed! ");
	}

	private Statement getStatement() {
		try {
			return JdbcConnection.getConnection().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY,
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		return null;
	}

}
