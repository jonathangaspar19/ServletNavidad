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
import es.salesianos.model.Pelicula;

public class FilmRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";

	ConnectionManager manager = new ConnectionH2();
	
	/*
	public List<Actor> searchAllActores() {
		List<Actor> listActores = new ArrayList<Actor>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ACTOR");
			resultSet = prepareStatement.executeQuery();
			System.out.println("Entrando en el while de searchAllActores");
			Actor actorInDatabase;
			while (resultSet.next()) {
				actorInDatabase = new Actor();
				actorInDatabase.setCod(resultSet.getInt(1));
				actorInDatabase.setName(resultSet.getString(2));
				actorInDatabase.setYearOfTheBirthDate(resultSet.getInt(3));
				System.out.println("Actor in Database " + actorInDatabase.toString() );
				listActores.add(actorInDatabase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}
		System.out.println("listActores.size(): " + listActores.size());
		return listActores;
	}	
	
	public void insertActor(Actor actor) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO ACTOR (name,yearofbirthdate)" + "VALUES (?, ?)");
			System.out.println("actor.getName() in insertActor: " + actor.getName());
			System.out.println("actor.getYearOfTheBirthDate() in insertActor: " + actor.getYearOfTheBirthDate());
			preparedStatement.setString(1, actor.getName());
			preparedStatement.setInt(2, actor.getYearOfTheBirthDate());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLException in insertActor: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}
	}	*/

	public List<Pelicula> searchAllPeliculas() {
		List<Pelicula> listFilm = new ArrayList<Pelicula>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT cod, codOwner, tittle FROM FILM");
			resultSet = prepareStatement.executeQuery();
			Pelicula filmInDataBase;
			while (resultSet.next()) {
				filmInDataBase = new Pelicula();
				filmInDataBase.setCod(resultSet.getInt(1));
				filmInDataBase.setCodDirector(resultSet.getInt(2));
				filmInDataBase.setTitulo(resultSet.getString(3));				
				listFilm.add(filmInDataBase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}
		System.out.println("listFilm.size(): " + listFilm.size());
		return listFilm;
	}	
	
	public void insertPelicula(Pelicula pelicula) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		System.out.println("Pelicula object in insertPelicula: " + pelicula.toString());
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO FILM (TITTLE ,codOwner)" + "VALUES (?, ?)");
			preparedStatement.setString(1, pelicula.getTitulo());
			preparedStatement.setInt(2, pelicula.getCodDirector());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
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

	public Pelicula searchPelicula(Pelicula peliculaFormulario) {
		Pelicula actorInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM PELICULA WHERE codOwner = ?");
			prepareStatement.setInt(1, peliculaFormulario.getCod());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				actorInDatabase = new Pelicula();
				actorInDatabase.setCod(resultSet.getInt(1));
//				actorInDatabase.setNombrePelicula(resultSet.getString(2));
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

	public void insertDirector(Director directorFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO DIRECTOR (name,surname)" + "VALUES (?, ?)");
			preparedStatement.setString(1, directorFormulario.getName());
//			preparedStatement.setString(2, directorFormulario.getSurname());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}

	public void updateActor(Actor ownerFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE ACTOR SET name = ?,surname = ? WHERE codActor = ?");
			preparedStatement.setString(1, ownerFormulario.getName());
//			preparedStatement.setString(2, ownerFormulario.getSurname());
			preparedStatement.setInt(3, ownerFormulario.getCod());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}

	public void updateDirector(Director ownerFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE OWNER SET name = ?,surname = ? WHERE codDirector = ?");
			preparedStatement.setString(1, ownerFormulario.getName());
//			preparedStatement.setString(2, ownerFormulario.getSurname());
//			preparedStatement.setInt(3, ownerFormulario.getCodDirector());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}

	public void updatePelicula(Pelicula peliculaFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE PELICULA SET name = ? WHERE codPelicula = ?");
//			preparedStatement.setString(1, peliculaFormulario.getNombrePelicula());
//			preparedStatement.setInt(2, peliculaFormulario.getCodPelicula());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}

	public void delete(Integer codActor) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {

			preparedStatement = deletePetsFor(codActor, conn);

			preparedStatement = deleteActor(codActor, conn);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}

	public void enlazar(Integer codActor, Integer codPelicula) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {

			preparedStatement = enlazarActor(codActor, codPelicula, conn);


		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}

	private PreparedStatement deleteActor(Integer codActor, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement("DELETE FROM ACTOR WHERE codActor = ?");
		preparedStatement.setInt(1, codActor);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}

	private PreparedStatement deletePetsFor(Integer codOwner, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement("DELETE FROM PET WHERE codOwner = ?");
		preparedStatement.setInt(1, codOwner);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}

	private PreparedStatement enlazarActor(Integer codActor, Integer codPelicula, Connection conn) throws SQLException {
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(
				"INSERT INTO actores.codPeliculas FROM ACTORES WHERE codActor = ? AND codPelicula = ?");

		preparedStatement.setInt(1, codActor);
		preparedStatement.setInt(2, codPelicula);
		preparedStatement.executeUpdate();
		return preparedStatement;
	}

	/*
	 * public List<Actor> searchAll() { List<Actor> listOwners = new
	 * ArrayList<Actor>(); Connection conn = manager.open(jdbcUrl); ResultSet
	 * resultSet = null; PreparedStatement prepareStatement = null;
	 * 
	 * 
	 * prepareStatement = conn.prepareStatement("SELECT * FROM OWNER"); resultSet =
	 * prepareStatement.executeQuery(); while (resultSet.next()) { Actor
	 * ownerInDatabase = new Actor();
	 * 
	 * ownerInDatabase.setCodActor(resultSet.getInt(1));
	 * ownerInDatabase.setName(resultSet.getString(2));
	 * ownerInDatabase.setSurname(resultSet.getString(3));
	 * 
	 * listOwners.add(ownerInDatabase); }
	 * 
	 * 
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); throw new
	 * RuntimeException(e); } finally { close(resultSet); close(prepareStatement);
	 * manager.close(conn); }
	 * 
	 * return listOwners; }
	 */
	public Actor searchByCodOwner(Integer codActor) {
		Actor ownerInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM ACTOR WHERE codOwner = ?");
			prepareStatement.setInt(1, codActor);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				ownerInDatabase = new Actor();
				ownerInDatabase.setCod(resultSet.getInt(1));
				ownerInDatabase.setName(resultSet.getString(2));
//				ownerInDatabase.setSurname(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
		}
		manager.close(conn);
		return ownerInDatabase;
	}

	public List<Director> searchAllDirectores() {
		List<Director> listDirectores = new ArrayList<Director>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {

			prepareStatement = conn.prepareStatement("SELECT * FROM DIRECTOR");
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Director directorInDatabase = new Director();

//				directorInDatabase.setCodDirector(resultSet.getInt(1));
				directorInDatabase.setName(resultSet.getString(2));
//				directorInDatabase.setSurname(resultSet.getString(3));

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

		return listDirectores;
	}

}
