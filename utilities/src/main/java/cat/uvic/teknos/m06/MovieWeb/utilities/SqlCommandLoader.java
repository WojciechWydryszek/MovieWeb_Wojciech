package cat.uvic.teknos.m06.MovieWeb.utilities;

import cat.uvic.teknos.m06.MovieWeb.utilities.exceptions.SchemaLoaderException;
import java.io.*;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Scanner;

public class SqlCommandLoader implements SchemaLoader{
    private final String schemaPath;
    private final ConnectionProperties connectionProperties;

    public SqlCommandLoader(String schemaPath, ConnectionProperties connectionProperties) {
        this.schemaPath = schemaPath;
        this.connectionProperties = connectionProperties;
    }

    @Override
    public void load(){
        try(var connection = DriverManager.getConnection(
                connectionProperties.getUrl(), connectionProperties.getUsername(), connectionProperties.getPassword());
            var inputStream=new Scanner(new FileReader(schemaPath, Charset.forName("utf-8")));
            var statement=connection.createStatement();
        ){
            boolean skip=false;
            String[] sqlArray;
            String command;
            String oneLine;
            while(inputStream.hasNextLine()){
                command="";
                while(command.indexOf(';')==-1) {
                    oneLine=inputStream.nextLine();
                    sqlArray = oneLine.split("");
                    for(int i=0;i<sqlArray.length;i++){
                        if(!skip) {
                            if (sqlArray[i] == "-" && sqlArray[i + 1] == "-")
                                skip = true;
                            else
                                command+=sqlArray[i];
                        }
                    }
                }
                statement.executeUpdate(command);
            }
        }catch (SQLException e) {
            throw new SchemaLoaderException("Sql Exception!", e);
        } catch (FileNotFoundException e) {
            throw new SchemaLoaderException("File Exception!" + schemaPath + " doesn't exist" + e);
        } catch (IOException e) {
            throw new SchemaLoaderException("IO Exception!", e);
        }
    }
}