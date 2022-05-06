//package cat.uvic.teknos.m06.MovieWeb.utilities;
//
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//class SqlCommandLoaderTest {
//
//    @Test
//    void load() {
//        var connectionProperties = new ConnectionProperties(); // connectionProperties is in utilities/src/main/java/cat.../connectionProperties
//        connectionProperties.setUrl("jdbc:mysql://localhost:3306/test"); // connection using localhost witch XAMPP for server
//        connectionProperties.setUsername("root"); // default username
//
//        var schemaLoader = new SqlCommandLoader("C:/Users/10030110/Desktop/sql.txt",connectionProperties); // src/test/resources/SingleLineSchema.txt
//
//        assertDoesNotThrow(() -> {schemaLoader.load();});
//    }
//}