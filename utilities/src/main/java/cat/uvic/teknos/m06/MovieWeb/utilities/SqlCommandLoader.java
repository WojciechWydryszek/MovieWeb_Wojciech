//package cat.uvic.teknos.m06.MovieWeb.utilities;
//
//import cat.uvic.teknos.m06.MovieWeb.utilities.exceptions.SchemaLoaderException;
//import java.io.File;
//import java.io.*;
//import java.nio.charset.Charset;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class SqlCommandLoader implements SchemaLoader {
//    private final String PATH;
//    private final ConnectionProperties connectionProperties;
//
//    public SqlCommandLoader(String PATH, ConnectionProperties connectionProperties){
//        this.PATH = PATH;
//        this.connectionProperties = connectionProperties;
//    }
//
//    @Override
//    public void load() throws FileNotFoundException {
//        try (var connection = DriverManager.getConnection(
//                connectionProperties.getUrl(), connectionProperties.getUsername(), connectionProperties.getPassword());
//             var statement = connection.createStatement();
//             var inputStream = new BufferedReader(new FileReader(PATH, Charset.forName("utf-8")));
//        ){
//            String sqlOrder = null;
//            while((sqlOrder=inputStream.readLine())!=null){
//                if(!sqlOrder.isEmpty()) {
//                    statement.executeUpdate(sqlOrder);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}