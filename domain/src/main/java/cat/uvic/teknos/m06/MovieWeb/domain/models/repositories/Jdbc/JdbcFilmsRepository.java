/*package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.Jdbc;

import cat.uvic.teknos.m06.MovieWeb.domain.models.exceptions.RepositoryExceptions;
import cat.uvic.teknos.m06.MovieWeb.domain.models.*;
import cat.uvic.teknos.m06.MovieWeb.domain.models.helper.ConnectionControl;
import cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.FilmsRepository;
import java.security.Key;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcFilmsRepository implements FilmsRepository {

    private final ConnectionControl connectionControl;

    public JdbcFilmsRepository(ConnectionControl connectionControl) { this.connectionControl = connectionControl; }


    @Override
    public void Delete(Object id) {

    }

    @Override
    public void Delete(int id) {
        try (Connection connection = connectionControl.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM MovieWeb.FILMS WHERE ID = ?");
            preparedStatement.setInt(1, Integer.valueOf(String.valueOf(id)));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
    }

    @Override
    public void Save(Genre films) {

    }

    @Override
    public void Save(Film films) {
        try (Connection connection = connectionControl.getConnection()){
            PreparedStatement preparedStatementOne = connection.prepareStatement("INSERT INTO MovieWeb.FILMS VALUES (?);");
            PreparedStatement preparedStatementTwo = connection.prepareStatement("UPDATE MovieWeb.FILMS SET (?);");

            if(Film.getId() == 0) {
                preparedStatementOne.setString(1, Film.getName());
                preparedStatementOne.executeUpdate();
            } else {
                preparedStatementTwo.setString(1, Film.getName());
                preparedStatementTwo.executeUpdate();
            }
        } catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
    }

    public Film GetById(Key id) {
        try (Connection connection = connectionControl.getConnection()){
            Film films = new Film();
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM MovieWeb.FILMS WHERE ID = ?");
            preparedStatement.setInt(1, Integer.valueOf(String.valueOf(id)));
            ResultSet resultSet = preparedStatement.executeQuery();

            int idFilm = resultSet.getInt("ID");
            String name = resultSet.getString("NAME");


            films.setId(idFilm);
            films.setName(name);
            return films;

        }catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
    }

    public List<Film> GetAll() {
        try (Connection connection = connectionControl.getConnection()){
            List<Film> listFilms = new ArrayList<>();
            Statement statement = connection.createStatement();
            String select = "SELECT * FROM MovieWeb.FILMS;";
            ResultSet resultSet = statement.executeQuery(select);
            Film film;

            while (resultSet.next()){
                film = new Film();
                film.setId(resultSet.getInt("ID"));
                film.setName(resultSet.getString("NAME"));
                listFilms.add(film);
            }
            return listFilms;
        } catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
    }

    @Override
    public Object GetById(Integer id) {
        return null;
    }

    @Override
    public List<Genre> GetFilmsByIdGen(Genre genre) { return null; }

    @Override
    public List<Actor> GetFilmsByIdGen(Actor actor) { return null; }

    @Override
    public List<Film> GetFilmsByIdGen(Film film) { return null; }

    @Override
    public List<MainCharacter> GetFilmsByIdGen(MainCharacter mainCharacter) { return null; }
}*/