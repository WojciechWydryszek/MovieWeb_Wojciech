package cat.uvic.teknos.m06.MovieWeb.utilities;

import cat.uvic.teknos.m06.MovieWeb.utilities.exceptions.SchemaLoaderException;
import java.io.File;
import java.io.*;
import java.nio.charset.Charset;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlCommandLoader implements SchemaLoader {
    private final String PATH;
    private final ConnectionProperties connectionProperties;

    public SqlCommandLoader(String path, ConnectionProperties connectionProperties) {
        this.PATH = path;
        this.connectionProperties = connectionProperties;
    }

    @Override
    public void load() throws FileNotFoundException {
        try (var connection = DriverManager.getConnection(
                connectionProperties.getUrl(), connectionProperties.getUsername(), connectionProperties.getPassword());
             var statement = connection.createStatement();
             var inputStream = new BufferedReader(new FileReader(PATH, Charset.forName("utf-8")));
        ) {
            String sqlOrder;
            var command = "";
            boolean skip;
            String[] sqlArray;
            while ((sqlOrder = inputStream.readLine()) != null) { // generate String using first line
                if (!sqlOrder.isEmpty()) {
                    skip = false;
                    sqlArray = sqlOrder.split("");
                    for(int i=0;i<sqlArray.length;i++) { // commends of -- is for rest of line
                        if (!skip)
                            if(sqlArray[i] != "-" && sqlArray[i+1] != "-") {
                                command += sqlArray[i]; // command is how execute if do not have commend --
                                skip = true;
                            }
                    }
                    statement.executeUpdate(command);
                }
            }

        } catch (SQLException e) {
            throw new SchemaLoaderException("Sql Exception!", e);
        } catch (FileNotFoundException e) {
            throw new SchemaLoaderException("File Exception!" + PATH + " doesn't exist" + e);
        } catch (IOException e) {
            throw new SchemaLoaderException("IO Exception!", e);
        }
    }
}