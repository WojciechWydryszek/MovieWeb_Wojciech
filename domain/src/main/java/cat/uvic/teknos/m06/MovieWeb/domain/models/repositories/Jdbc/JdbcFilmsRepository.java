package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.Jdbc;

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
    public void Delete(Key id) {
        try (Connection connection = connectionControl.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM MovieWeb.FILMS WHERE ID = ?");
            preparedStatement.setInt(1, Integer.valueOf(String.valueOf(id)));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
    }

    @Override
    public void Save(Films films) {
        try (Connection connection = connectionControl.getConnection()){
            PreparedStatement preparedStatementOne = connection.prepareStatement("INSERT INTO MovieWeb.FILMS VALUES (?);");
            PreparedStatement preparedStatementTwo = connection.prepareStatement("UPDATE MovieWeb.FILMS SET (?);");

            if(Films.GetId() == 0) {
                preparedStatementOne.setString(1, Films.GetName());
                preparedStatementOne.executeUpdate();
            } else {
                preparedStatementTwo.setString(1, Films.GetName());
                preparedStatementTwo.executeUpdate();
            }
        } catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
    }

    public Films GetById(Key id) {
        try (Connection connection = connectionControl.getConnection()){
            Films films = new Films();
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM MovieWeb.FILMS WHERE ID = ?");
            preparedStatement.setInt(1, Integer.valueOf(String.valueOf(id)));
            ResultSet resultSet = preparedStatement.executeQuery();

            int idFilm = resultSet.getInt("ID");
            String name = resultSet.getString("NAME");


            films.SetId(idFilm);
            films.SetName(name);
            return films;

        }catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
    }

    public List<Films> GetAll() {
        try (Connection connection = connectionControl.getConnection()){
            List<Films> listFilms = new ArrayList<>();
            Statement statement = connection.createStatement();
            String select = "SELECT * FROM MovieWeb.FILMS;";
            ResultSet resultSet = statement.executeQuery(select);
            Films films;

            while (resultSet.next()){
                films = new Films();
                films.SetId(resultSet.getInt("ID"));
                films.SetName(resultSet.getString("NAME"));
                listFilms.add(films);
            }
            return listFilms;
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