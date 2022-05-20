package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories;

import cat.uvic.teknos.m06.MovieWeb.domain.models.exceptions.RepositoryExceptions;
import cat.uvic.teknos.m06.MovieWeb.domain.models.*;

import java.io.FileReader;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.Scanner;

public class FilmsRepository extends MovieWebRepository{
    private static final String INSERT = "insert into FILMS values (?)";
    private static final String UPDATE = "update FILMS set ?";
    private static final String SELECT = "select ? from FILMS";
    private final String table = "FILMS";
    private final String schemaPath;
    private final ConnectionProperties connectionProperties;

    public FilmsRepository(String schemaPath, ConnectionProperties connectionProperties) {
        this.schemaPath = schemaPath;
        this.connectionProperties = connectionProperties;
    }


    @Override
    public void Save(Connection conn) {

    }

    @Override
    public void Update(Connection conn) { // update table FILMS from database MovieWeb
        try (var prepareStatement = conn.prepareStatement(UPDATE)) {
            prepareStatement.setString(1, Films.GetName());
            prepareStatement.executeQuery(UPDATE);
        } catch (Exception e){
            throw new RepositoryExceptions("Error found: ", e);
        }
    }







// not complete Delete and GetById, need perfect codi
    @Override
    public void Delete(Connection conn) { // delete table FILMS from database MovieWeb
        try (var connection = DriverManager.getConnection(
                ConnectionProperties.getUrl(), ConnectionProperties.getUsername(), ConnectionProperties.getPassword());
             var statement=connection.createStatement()) {
            PreparedStatement prepareStatement = null;
            prepareStatement.executeUpdate("drop table if exists"+ table);
        } catch (Exception e) {
            throw new RepositoryExceptions("Error found: ", e);
        }
    }

    @Override
    public void GetById(Connection conn) {  // concrect select from database MovieWeb
        String where ="where ID_GEN = 1";  // var for filter select
        try (var connection = DriverManager.getConnection(
                ConnectionProperties.getUrl(), ConnectionProperties.getUsername(), ConnectionProperties.getPassword());
             var statement=connection.createStatement()) {
            PreparedStatement prepareStatement = null;
            prepareStatement.setString(1, Films.GetName());
            prepareStatement.executeUpdate(SELECT);
        } catch (Exception e) {
            throw new RepositoryExceptions("Error found: ", e);
        }
    }














    @Override
    public void GetAll(Connection conn) {  // select all from database MovieWeb
        try (var prepareStatement = conn.prepareStatement(SELECT)) {
            prepareStatement.setString(1, Films.GetName());
            prepareStatement.executeUpdate(SELECT);  //String.valueOf(prepareStatement)

        } catch (Exception e) {
            throw new RepositoryExceptions("Error found: ", e);
        }
    }

    public void Insert(Connection conn) {  // insert into table FILMS in database MovieWeb
        try (var prepareStatement = conn.prepareStatement(INSERT)) {
            prepareStatement.setString(1, Films.GetName());
            prepareStatement.executeUpdate(INSERT);
        } catch (Exception e) {
            throw new RepositoryExceptions("Error found: ", e);
        }
    }
}
