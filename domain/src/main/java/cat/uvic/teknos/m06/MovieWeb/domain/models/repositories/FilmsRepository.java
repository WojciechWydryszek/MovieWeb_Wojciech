package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories;

import cat.uvic.teknos.m06.MovieWeb.domain.models.*;
import java.sql.*;

public class FilmsRepository extends MovieWebRepository{
    private static final String INSERT = "insert into FILMS values (?)";
    private static final String UPDATE = "update FILMS set ?";
    private static final String SELECT = "select ? from FILMS ?";

    @Override
    public void Save(Connection conn) {

    }

    @Override
    public void Update(Connection conn) {
        try (var prepareStatement = conn.prepareStatement(UPDATE)) {
            prepareStatement.setString(1, Films.GetName());
            prepareStatement.executeQuery(UPDATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(Connection conn) {
        try (var prepareStatment = conn.prepareStatement(null)) {
            prepareStatment.executeUpdate("drop table if exists FILMS;");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void GetById(Connection conn) {
        String where ="where ID_GEN = 1";
        try (var prepareStatment  = conn.prepareStatement(SELECT)) {
            prepareStatment.setString(1, Films.GetName());
            prepareStatment.setString(2, where);
            prepareStatment.executeUpdate(SELECT);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void GetAll(Connection conn) {
        try (var prepareStatement = conn.prepareStatement(SELECT)) {
            prepareStatement.setString(1, Films.GetName());
            prepareStatement.executeUpdate(SELECT);  //String.valueOf(prepareStatement)

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(Connection conn) {
        try (var prepareStatement = conn.prepareStatement(INSERT)) {
            prepareStatement.setString(1, Films.GetName());
            prepareStatement.executeUpdate(INSERT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
