package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.Jpa;

import cat.uvic.teknos.m06.MovieWeb.domain.models.MainCharacter;
import cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.MovieWebRep;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.junit.jupiter.api.Assertions.*;

class JpaMainCharacterRepositoryTest {
    private final int  MODEL_TO_DELETE = 2;
    private static EntityManagerFactory entityManagerFactory;
    private static MovieWebRep movieWebRep;

    public JpaMainCharacterRepositoryTest(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @BeforeAll
    static void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("movieweb_mysql");
        movieWebRep = new JpaMainCharacterRepository(entityManagerFactory);
    }

    @Test
    void saveInsert() {
        MainCharacter mainCharacter = new MainCharacter();

        mainCharacter.setId(0);
        mainCharacter.setName("Lebiosqui");

        assertDoesNotThrow(() -> { movieWebRep.Save(mainCharacter); });

        assertTrue(mainCharacter.getId() > 0);
    }

    @Test
    void saveUpdate() {
        MainCharacter mainCharacter = new MainCharacter();

        mainCharacter.setId(1);
        mainCharacter.setName("Chikibriky");

        assertDoesNotThrow(() -> { movieWebRep.Delete(MODEL_TO_DELETE); });
    }

    @Test
    void delete() {
        assertDoesNotThrow(() -> { movieWebRep.Delete(MODEL_TO_DELETE); });
    }

    @Test
    void getAll() {
        var mainCharacter = movieWebRep.GetAll();

        assertNotNull(mainCharacter);
        assertTrue(mainCharacter.size() > 0);
    }

    @Test
    void getById() {
        var mainCharacter = movieWebRep.GetById(2);

        assertNotNull(mainCharacter);
    }
}