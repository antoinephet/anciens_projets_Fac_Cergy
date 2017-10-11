package jdbc2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;



public class JdbcAddressAccess {

	public Address find(String id) {
		try {
			String query = "SELECT * FROM address";
			//String query = "SELECT * FROM address WHERE id='" + id + "';";
			System.out.println(query);
			ResultSet resultSet = getStatement().executeQuery(query);
			while (!resultSet.last()) {
				resultSet.next();
			}

			Address address = new Address(resultSet.getString("id"),
					resultSet.getString("number"), resultSet.getString("street"),
					resultSet.getString("city"), resultSet.getInt("postalCode"));

			return address;
		} catch (Exception e) {
			throw new NoSuchElementException();
		}
	}

	public void create(Address object) {
		try {
			String query = "INSERT INTO address VALUES ('" + object.getId()
					+ "', '" + object.getCity() + "','" + object.getNumber() + "',"
					+ object.getPostalCode() + ",'" + object.getStreet() + "');";
			System.out.println(query);
			Statement statement = getStatement();
			statement.executeUpdate(query);
			//statement.close();
		} catch (SQLException se) {
		}
		System.out.println("Address added! ");
	}

	public void update(Address object) {
		try {
			String query = "Update address set city = '" + object.getCity()
					+ ", number = '" + object.getNumber() + "', postalcode = "
					+ object.getPostalCode() + ", street = '" + object.getStreet()
					+ "' where id = '" + object.getId() + "';";
			System.out.println(query);
			Statement statement = getStatement();
			statement.executeUpdate(query);
			statement.close();
		} catch (SQLException se) {
		}
		System.out.println("Address updated! ");
	}

	public void delete(Address object) {
		try {
			String query = "Delete from address where id = '" + object.getId()
					+ "';";
			System.out.println(query);
			Statement statement = getStatement();
			statement.executeUpdate(query);
			statement.close();
		} catch (SQLException se) {
		}
		System.out.println("Address removed! ");
	}

	private Statement getStatement() {
		try {
			return JdbcConnection.getConnection().createStatement(
					);
			/*ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY,
			ResultSet.HOLD_CURSORS_OVER_COMMIT*/
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.exit(-1);
		}
		return null;
	}
}
