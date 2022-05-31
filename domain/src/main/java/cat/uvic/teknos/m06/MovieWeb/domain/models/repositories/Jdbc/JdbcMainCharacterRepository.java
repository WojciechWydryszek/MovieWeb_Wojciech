/*package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.Jdbc;

import cat.uvic.teknos.m06.MovieWeb.domain.models.*;
import cat.uvic.teknos.m06.MovieWeb.domain.models.exceptions.RepositoryExceptions;
import cat.uvic.teknos.m06.MovieWeb.domain.models.helper.ConnectionControl;
import cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.FilmsRepository;
import java.security.Key;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcMainCharacterRepository implements FilmsRepository {
    private final ConnectionControl connectionControl;

    public JdbcMainCharacterRepository(ConnectionControl connectionControl) { this.connectionControl = connectionControl; }


    @Override
    public void Delete(Object id) {}

    @Override
    public void Delete(int id) {
        try (Connection connection = connectionControl.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM MovieWeb.MAIN_CHAPTER WHERE ID_ACTOR = ?");
            preparedStatement.setInt(1, Integer.valueOf(String.valueOf(id)));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
    }

    @Override
    public void Save(Genre film) {
        try (Connection connection = connectionControl.getConnection()){
            PreparedStatement preparedStatementOne = connection.prepareStatement("INSERT INTO MovieWeb.MAIN_CHAPTER VALUES (?);");
            PreparedStatement preparedStatementTwo = connection.prepareStatement("UPDATE MovieWeb.MAIN_CHAPTER SET (?);");

            if(MainCharacter.getId() == 0) {
                preparedStatementOne.setString(1, MainCharacter.getName());
                preparedStatementOne.executeUpdate();
            } else {
                preparedStatementTwo.setString(1, MainCharacter.getName());
                preparedStatementTwo.executeUpdate();
            }
        } catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
    }

    public List<MainCharacter> GetAll() {
        try (Connection connection = connectionControl.getConnection()){
            List<MainCharacter> listMainCharacter = new ArrayList<>();
            Statement statement = connection.createStatement();
            String select = "SELECT * FROM MovieWeb.MainCharacter;";
            ResultSet resultSet = statement.executeQuery(select);
            MainCharacter mainCharacter;

            while (resultSet.next()){
                mainCharacter = new MainCharacter();
                mainCharacter.setId(resultSet.getInt("ID_ACTOR"));
                mainCharacter.setName(resultSet.getString("NAME"));
                mainCharacter.setId(resultSet.getInt("ID_FILM"));
            }
            return listMainCharacter;
        } catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
    }

    @Override
    public Object GetById(Integer id) {
        return null;
    }

    public MainCharacter GetById(Key id) {
        try (Connection connection = connectionControl.getConnection()){
            MainCharacter mainCharacter = new MainCharacter();
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM MovieWeb.MAIN_CHAPTER WHERE ID_ACTOR = ?");
            preparedStatement.setInt(1, Integer.valueOf(String.valueOf(id)));
            ResultSet resultSet = preparedStatement.executeQuery();

            int idActor = resultSet.getInt("ID_ACTOR");
            String name = resultSet.getString("NAME");

            mainCharacter.setId(idActor);
            mainCharacter.setName(name);
            return mainCharacter;

        }catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
    }

    @Override
    public void Save(Film film) {

    }

    @Override
    public List<Genre> GetFilmsByIdGen(Genre genre) {
        return null;
    }

    @Override
    public List<Actor> GetFilmsByIdGen(Actor actor) {
        return null;
    }

    @Override
    public List<Film> GetFilmsByIdGen(Film film) {
        return null;
    }

    @Override
    public List<MainCharacter> GetFilmsByIdGen(MainCharacter mainCharacter) {
        return null;
    }
}
*/