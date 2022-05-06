//package cat.uvic.teknos.m06.MovieWeb.utilities;
//
//import org.junit.jupiter.api.Test;
//import java.io.FileNotFoundException;
//import static org.junit.jupiter.api.Assertions.*;
//
//class SingleLineCommandSchemaLoaderTest {
//
//    @Test
//    void load() {
//        var connectionProperties = new ConnectionProperties();
//        connectionProperties.setUrl("jdbc:mysql://localhost:3306/test");
//        connectionProperties.setUsername("root");
//
//        var schemaLoader = new SingleLineCommandSchemaLoaderTest("src/test/resources/SingleLineSchema.txt",connectionProperties); // PATH IS INTO app DIRECTORY
//
//        assertDoesNotThrow(() -> {schemaLoader.load();});
//    }
//}