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

public class JdbcActorRepository implements FilmsRepository {
    private final ConnectionControl connectionControl;

    public JdbcActorRepository(ConnectionControl connectionControl) { this.connectionControl = connectionControl; }



    @Override
    public void Delete(Key id) {
        try (Connection connection = connectionControl.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM MovieWeb.ACTOR WHERE ID_ACTOR = ?");
            preparedStatement.setInt(1, Integer.valueOf(String.valueOf(id)));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
    }

    @Override
    public void Save(Films films) {
        try (Connection connection = connectionControl.getConnection()){
            PreparedStatement preparedStatementOne = connection.prepareStatement("INSERT INTO MovieWeb.ACTOR VALUES (?);");
            PreparedStatement preparedStatementTwo = connection.prepareStatement("UPDATE MovieWeb.ACTOR SET (?);");

            if(Actor.GetId() == 0) {
                preparedStatementOne.setString(1, Actor.GetName());
                preparedStatementOne.executeUpdate();
            } else {
                preparedStatementTwo.setString(1, Actor.GetName());
                preparedStatementTwo.executeUpdate();
            }
        } catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
    }

    public List<Actor> GetAll() {
        try (Connection connection = connectionControl.getConnection()){
            List<Actor> listActor = new ArrayList<>();
            Statement statement = connection.createStatement();
            String select = "SELECT * FROM MovieWeb.ACTOR;";
            ResultSet resultSet = statement.executeQuery(select);
            Actor actor;

            while (resultSet.next()){
                actor = new Actor();
                actor.SetId(resultSet.getInt("ID_ACTOR"));
                actor.SetName(resultSet.getString("NAME"));
                listActor.add(actor);
            }
            return listActor;
        } catch (Exception e) {
            throw new RepositoryExceptions("ERROR FOUND: ",e);
        }
    }

    public Actor GetById(Key id) {
        try (Connection connection = connectionControl.getConnection()){
            Actor actor = new Actor();
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM MovieWeb.ACTOR WHERE ID_ACTOR = ?");
            preparedStatement.setInt(1, Integer.valueOf(String.valueOf(id)));
            ResultSet resultSet = preparedStatement.executeQuery();

            int id_actor = resultSet.getInt("ID_ACTOR");
            String name = resultSet.getString("NAME");

            actor.SetId(id_actor);
            actor.SetName(name);
            return actor;

        }catch (Exception e) {
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