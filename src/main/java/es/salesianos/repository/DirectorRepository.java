package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Actor;
import es.salesianos.model.Director;

public class DirectorRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	public List<Director> searchAllDirectors() {
		List<Director> listDirectores = new ArrayList<Director>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM DIRECTOR");
			resultSet = prepareStatement.executeQuery();
			System.out.println("Entrando en el while de searchAllDirectors");
			Director directorInDatabase;
			while (resultSet.next()) {
				directorInDatabase = new Director();
				directorInDatabase.setCod(resultSet.getInt(1));
				directorInDatabase.setName(resultSet.getString(2));
				System.out.println("Entrando en el while de searchAllDirectors in Database " + directorInDatabase.toString());
				listDirectores.add(directorInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}
		System.out.println("listDirectores.size(): " + listDirectores.size());
		return listDirectores;
	}

	public void insertDirector(Director director) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO DIRECTOR (name)" + "VALUES (?)");
			System.out.println("actor.getName() in insertDirector: " + director.getName());
			preparedStatement.setString(1, director.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLException in insertDirector: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
	}
	

	private void close(PreparedStatement prepareStatement) {
		try {
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public Actor search(Actor actorFormulario) {
		Actor actorInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM A WHERE codOwner = ?");
			prepareStatement.setInt(1, actorFormulario.getCod());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				actorInDatabase = new Actor();
				actorInDatabase.setCod(resultSet.getInt(1));
				actorInDatabase.setName(resultSet.getString(2));
//				actorInDatabase.setSurname(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);

		}
		manager.close(conn);
		return actorInDatabase;
	}
	
	public void updateDirector(Director ownerFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE ACTOR SET name = ? WHERE cod = ?");
			preparedStatement.setString(1, ownerFormulario.getName());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}
	
	public void delete(Integer cod) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {


			preparedStatement = deleteDirector(cod, conn);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}
	
	private PreparedStatement deleteDirector(Integer cod, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement("DELETE FROM DIRECTOR WHERE cod = ?");
		preparedStatement.setInt(1, cod);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}
	
	public Director search(Director directorFormulario) {
		Director directorInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM A WHERE cod = ?");
			prepareStatement.setInt(1, directorFormulario.getCod());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				directorInDatabase = new Director();
				directorInDatabase.setCod(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);

		}
		manager.close(conn);
		return directorInDatabase;
	}

}
