package cat.uvic.teknos.m06.MovieWeb.utilities;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class SingleLineCommandSchemaLoaderTest {

    @Test
    void load() {
        var connectionProperties = new ConnectionProperties();
        connectionProperties.setUrl("jdbc:mysql://localhost:3306/test");
        connectionProperties.setUsername("root");

        var schemaLoader = new SingleLineCommandSchemaLoader("C:/Users/10030110/Desktop/m06/sql.txt",connectionProperties); //  src/test/resources/SingleLineSchema.txt

        assertDoesNotThrow(() -> {schemaLoader.load();});
    }
}