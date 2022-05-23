package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories;

import cat.uvic.teknos.m06.MovieWeb.domain.models.exceptions.RepositoryExceptions;
import cat.uvic.teknos.m06.MovieWeb.domain.models.*;
import java.sql.*;
import java.util.List;

public class JdbcFilmsRepository implements FilmsRepository{
    private static final String TABLE = "FILMS";
    private static final String INSERT = "insert into" + TABLE + "values (?)";
    private static final String UPDATE = "update" + TABLE + "set ?";
    private static final String SELECT = "select ? from" + TABLE + "?";
    private static final String DELETE = "drop ?";

    @Override
    public void Save() {  }

    @Override
    public List<Films> Update(Connection conn, Integer id) { // update table FILMS from database MovieWeb
        try (var prepareStatement = conn.prepareStatement(UPDATE)) {
            String command="";
            String[] stringArray;
            boolean stop = false;
            if(Films.GetName() != "") {
                prepareStatement.setString(1, Films.GetName());
                stringArray = UPDATE.split("");
                for(int i=0;i< stringArray.length;i++) // this for is for protect for multiple commands befor first command
                    if(!stop && stringArray[i]!=";")
                        command+=stringArray[i];
                    else
                        stop = true;

                if(!stop)  // if user don't put ; , code put it for user
                    command+=";";
                prepareStatement.executeQuery(command); // just execute under find end of command ";"
            } else
                throw new Exception("INCORRECT VALUES FOR UPDATE");
        } catch (Exception e){
            throw new RepositoryExceptions("Error found: ", e);
        }
        return null;
    }

    @Override
    public void Delete(Connection conn, Integer id) { // delete table FILMS from database MovieWeb
        try (var prepareStatement = conn.prepareStatement(DELETE)) {
            String command = "";
            String[] stringArray;
            boolean stop = false;
            if(Films.GetName() != "") {
                prepareStatement.setString(1, Films.GetName());
                stringArray = DELETE.split("");
                for(int i=0;i<stringArray.length;i++)
                    if(!stop && stringArray[i]!=";")
                        command+=stringArray[i];
                    else
                        stop = true;

                if(!stop)
                    command+=";";
                prepareStatement.executeUpdate(command);
            } else
                throw new Exception("INCORRECT VALUES FOR DELETE");
        } catch (Exception e) {
            throw new RepositoryExceptions("Error found: ", e);
        }
    }

    @Override
    public String GetById(Connection conn, Integer id) {  // concrect select from database MovieWeb
        String command;
        String where ="where ID_GEN = " + id + ";";
        try (var prepareStatement = conn.prepareStatement(SELECT)) {
            if(Films.GetName() != "" && where != "") {
                prepareStatement.setString(1, Films.GetName());
                prepareStatement.setString(2, where);
                command = SELECT;
            } else
                throw new Exception("INCORRECT VALUES FOR SELECT");
        } catch (Exception e) {
            throw new RepositoryExceptions("Error found: ", e);
        }
        return command;
    }

    @Override
    public String GetAll(Connection conn) {  // select all from database MovieWeb
        String command="";
        String[] stringArray;
        boolean stop = false;
        try (var prepareStatement = conn.prepareStatement(SELECT)) {
            if(Films.GetName() != "") {
                prepareStatement.setString(1, Films.GetName());
                stringArray = SELECT.split("");
                for(int i=0;i< stringArray.length;i++)
                    if(!stop && stringArray[i]!=";")
                        command+=stringArray[i];
                    else
                        stop = true;

                if(!stop)
                    command+=";";
            } else
                throw new Exception("INCORRECT VALUES FOR SELECT");
        } catch (Exception e) {
            throw new RepositoryExceptions("Error found: ", e);
        }
        return command;
    }

    public void Insert(Connection conn) {  // insert into table FILMS in database MovieWeb
        try (var prepareStatement = conn.prepareStatement(INSERT)) {
            String command="";
            String[] stringArray;
            boolean stop = false;
            if(Films.GetName() != "") {
                prepareStatement.setString(1, Films.GetName());
                stringArray = INSERT.split("");
                for(int i=0;i< stringArray.length;i++)
                    if(!stop && stringArray[i]!=";")
                        command+=stringArray[i];
                    else
                        stop = true;

                if(!stop)
                    command+=";";
                prepareStatement.executeUpdate(command);
            } else
                throw new Exception("INCORRECT VALUES FOR INSERT");
        } catch (Exception e) {
            throw new RepositoryExceptions("Error found: ", e);
        }
    }

    @Override
    public List<Films> getByFilms(Integer id) { return null; }
}