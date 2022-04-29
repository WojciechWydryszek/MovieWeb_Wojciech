package cat.uvic.teknos.m06.MovieWeb.app;

import cat.uvic.teknos.m06.MovieWeb.app.exception.AppCheckExceptions;
import cat.uvic.teknos.m06.MovieWeb.app.exception.AppUnchekedException;
import cat.uvic.teknos.m06.MovieWeb.list.LinkedList;
import static cat.uvic.teknos.m06.MovieWeb.utilities.StringUtils.join;
import static cat.uvic.teknos.m06.MovieWeb.utilities.StringUtils.split;
import org.apache.commons.text.WordUtils;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {


//        try(var connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieweb_test", "root", null)){
//            connection.setAutoCommit(false); //false is for manual commit
//            var statement = connection.createStatement();
////          var result = statement.executeUpdate("insert into FILMS values (1, 'test', 42, 'Wojciech')");
//            var resultSet = statement.executeQuery("select ID, NAME, ID_GEN, DIRECTOR from FILMS");
//
//            while(resultSet.next()){
//                System.out.println("ID: "+resultSet.getInt("ID")+" Name: "+resultSet.getString("NAME")+" ID_Gen: "+resultSet.getInt("ID_GEN")+" Director: "+resultSet.getString("DIRECTOR"));
//            }
//
//            connection.commit(); // the manual commit
//        }

//        if(connection !=null)
//            System.out.println("Connection!");


//        var cliInfo = connection.getClientInfo();
//        var properties =  cliInfo.keys();
//        while(properties.hasMoreElements()){
//            var key = properties.nextElement();
//            System.out.println(key + ": " + cliInfo.get(key));
//        }

//        LinkedList tokens;
//        tokens = split(getMessage());
//        String result = join(tokens);
//        System.out.println(WordUtils.capitalize(result));
    }
}
