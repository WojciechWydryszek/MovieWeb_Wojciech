package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.Jdbc;

import cat.uvic.teknos.m06.MovieWeb.domain.models.Actor;
import cat.uvic.teknos.m06.MovieWeb.domain.models.Films;
import cat.uvic.teknos.m06.MovieWeb.domain.models.Genre;
import cat.uvic.teknos.m06.MovieWeb.domain.models.MainCharacter;
import cat.uvic.teknos.m06.MovieWeb.domain.models.exceptions.RepositoryExceptions;
import cat.uvic.teknos.m06.MovieWeb.domain.models.helper.ConnectionControl;
import cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.FilmsRepository;
import java.security.Key;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcGenreRepository implements FilmsRepository {

    private final ConnectionControl connectionControl;

    public JdbcGenreRepository(ConnectionControl connectionControl) { this.connectionControl = connectionControl; }

    @Override
    public void Delete(Key id) {
        try (Connection connection = connectionControl.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM MovieWeb.GENRE WHERE ID_GEN = ?");
            preparedStatement.setInt(1, Integer.valueOf(String.valueOf(id)));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
    }

    @Override
    public void Save(Films films) {
        try (Connection connection = connectionControl.getConnection()){
            PreparedStatement preparedStatementOne = connection.prepareStatement("INSERT INTO MovieWeb.Genre VALUES (?);");
            PreparedStatement preparedStatementTwo = connection.prepareStatement("UPDATE MovieWeb.GEN SET (?);");

            if(Genre.GetId_gen() == 0) {
                preparedStatementOne.setString(1, Genre.GetNameInsert());
                preparedStatementOne.executeUpdate();
            } else {
                preparedStatementTwo.setString(1, Genre.GetNameUpdate());
                preparedStatementTwo.executeUpdate();
            }
        } catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
    }

    public Genre GetById(Key id) {
        try (Connection connection = connectionControl.getConnection()){
            Genre genre = new Genre();
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM MovieWeb.GENRE WHERE ID_GEN = ?");
            preparedStatement.setInt(1, Integer.valueOf(String.valueOf(id)));
            ResultSet resultSet = preparedStatement.executeQuery();

            int id_gen = resultSet.getInt("ID_GEN");
            String description = resultSet.getString("DESCRIPTION");

            genre.SetId_gen(id_gen);
            genre.SetDescioption(description);
            return genre;

        }catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
    }

    public List<Genre> GetAll() {
        try (Connection connection = connectionControl.getConnection()){
            List<Genre> listGenre = new ArrayList<>();
            Statement statement = connection.createStatement();
            String select = "SELECT * FROM MovieWeb.GENRE;";
            ResultSet resultSet = statement.executeQuery(select);
            Genre genre;

            while (resultSet.next()){
                genre = new Genre();
                genre.SetId_gen(resultSet.getInt("ID_GENRE"));
                genre.SetDescioption(resultSet.getString("DESCRIPTION"));
                listGenre.add(genre);
            }
            return listGenre;
        } catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
    }

    @Override
    public List<Genre> GetFilmsByIdGen(Genre genre) { return null; }

    @Override
    public List<Actor> GetFilmsByIdGen(Actor actor) { return null; }

    @Override
    public List<Films> GetFilmsByIdGen(Films films) { return null; }

    @Override
    public List<MainCharacter> GetFilmsByIdGen(MainCharacter mainCharacter) { return null; }
}

