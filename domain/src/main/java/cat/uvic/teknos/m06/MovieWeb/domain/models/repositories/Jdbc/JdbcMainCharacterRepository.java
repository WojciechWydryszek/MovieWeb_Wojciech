package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.Jdbc;

import cat.uvic.teknos.m06.MovieWeb.domain.models.Actor;
import cat.uvic.teknos.m06.MovieWeb.domain.models.Films;
import cat.uvic.teknos.m06.MovieWeb.domain.models.Genre;
import cat.uvic.teknos.m06.MovieWeb.domain.models.MainCharacter;
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
    public void Delete(Key id) {
        try (Connection connection = connectionControl.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM MovieWeb.MAIN_CHAPTER WHERE ID_ACTOR = ?");
            preparedStatement.setInt(1, Integer.valueOf(String.valueOf(id)));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
    }

    @Override
    public void Save(Films films) {
        try (Connection connection = connectionControl.getConnection()){
            PreparedStatement preparedStatementOne = connection.prepareStatement("INSERT INTO MovieWeb.MAIN_CHAPTER VALUES (?);");
            PreparedStatement preparedStatementTwo = connection.prepareStatement("UPDATE MovieWeb.MAIN_CHAPTER SET (?);");

            if(MainCharacter.GetId_actor() == 0) {
                preparedStatementOne.setString(1, MainCharacter.GetName_ch());
                preparedStatementOne.executeUpdate();
            } else {
                preparedStatementTwo.setString(1, MainCharacter.GetName_ch());
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
                mainCharacter.SetId_actor(resultSet.getInt("ID_ACTOR"));
                mainCharacter.SetName_ch(resultSet.getString("NAME"));
                mainCharacter.SetId_film(resultSet.getInt("ID_FILM"));
            }
            return listMainCharacter;
        } catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
    }

    public MainCharacter GetById(Key id) {
        try (Connection connection = connectionControl.getConnection()){
            MainCharacter mainCharacter = new MainCharacter();
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM MovieWeb.MAIN_CHAPTER WHERE ID_ACTOR = ?");
            preparedStatement.setInt(1, Integer.valueOf(String.valueOf(id)));
            ResultSet resultSet = preparedStatement.executeQuery();

            int id_actor = resultSet.getInt("ID_ACTOR");
            String name = resultSet.getString("NAME");
            int id_film = resultSet.getInt("ID_FILMS");

            mainCharacter.SetId_actor(id_actor);
            mainCharacter.SetName_ch(name);
            mainCharacter.SetId_film(id_film);
            return mainCharacter;

        }catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
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
    public List<Films> GetFilmsByIdGen(Films films) {
        return null;
    }

    @Override
    public List<MainCharacter> GetFilmsByIdGen(MainCharacter mainCharacter) {
        return null;
    }
}
