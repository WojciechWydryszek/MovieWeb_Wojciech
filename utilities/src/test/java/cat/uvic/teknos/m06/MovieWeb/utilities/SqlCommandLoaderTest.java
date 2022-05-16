package cat.uvic.teknos.m06.MovieWeb.utilities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SqlCommandLoaderTest {

    @Test
    void load() {
        var connectionProperties=new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/mysql");
        connectionProperties.setUsername("root");
        var schemaLoader= new SqlCommandLoader("src/main/resources/schema.sql",connectionProperties); // src/main/resources/schema.sql
        assertDoesNotThrow(() ->{
            schemaLoader.load();
        });
    }
}