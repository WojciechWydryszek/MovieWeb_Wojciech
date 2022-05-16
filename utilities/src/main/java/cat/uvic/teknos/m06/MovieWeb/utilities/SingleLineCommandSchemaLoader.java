//package cat.uvic.teknos.m06.MovieWeb.utilities;
//
//import cat.uvic.teknos.m06.MovieWeb.utilities.exceptions.SchemaLoaderException;
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class SingleLineCommandSchemaLoader implements SchemaLoader{
//    private final String schemaPath;
//    private final ConnectionProperties connectionProperties;
//
//    public SingleLineCommandSchemaLoader(String schemaPath, ConnectionProperties connectionProperties){
//        this.schemaPath = schemaPath;
//        this.connectionProperties = connectionProperties;
//    }
//
//    @Override
//    public void load() throws FileNotFoundException {
//        try (var connection = DriverManager.getConnection(
//                connectionProperties.getUrl(), connectionProperties.getUsername(), connectionProperties.getPassword());
//             var statement = connection.createStatement();
//             var inputStream = new BufferedReader(new FileReader(schemaPath, Charset.forName("utf-8")));
//        )
//        {
//            String sql = null;
//            while((sql=inputStream.readLine())!=null){
//                if(!sql.isEmpty()){
//                    statement.executeUpdate(sql);
//                }
//            }
//        } catch (SQLException e) {
//            throw new SchemaLoaderException("Sql Exception!", e);
//        } catch (FileNotFoundException e) {
//            throw new SchemaLoaderException("File Exception!"+schemaPath+" doesn't exist"+ e);
//        } catch (IOException e) {
//            throw new SchemaLoaderException("IO Exception!", e);
//        }
//
//    }
//}