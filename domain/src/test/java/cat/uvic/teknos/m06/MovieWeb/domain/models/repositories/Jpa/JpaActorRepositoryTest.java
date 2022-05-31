package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.Jpa;

import cat.uvic.teknos.m06.MovieWeb.domain.models.Actor;
import cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.MovieWebRep;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.junit.jupiter.api.Assertions.*;

class JpaActorRepositoryTest {
    private final int  MODEL_TO_DELETE = 2;
    private static EntityManagerFactory entityManagerFactory;
    private static MovieWebRep movieWebRep;

    public JpaActorRepositoryTest(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @BeforeAll
    static void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("movieweb_mysql");
        movieWebRep = new JpaGenreRepository(entityManagerFactory);
    }

    @Test
    void seveInsert() {
        Actor actor = new Actor();

        actor.setName("Brad Pit");
        actor.setId(0);

        assertDoesNotThrow(() -> {
            movieWebRep.Save(actor);
        });

        assertTrue(actor.getId() > 0);
    }

    @Test
    void saveUpdate() {
        Actor actor = new Actor();

        actor.setId(1);
        actor.setName("Adam");

        assertDoesNotThrow(() -> { movieWebRep.Save(actor); });

        assertTrue(actor.getId() > 0);
    }

    @Test
    void delete() {
        assertDoesNotThrow(() -> { movieWebRep.Delete(MODEL_TO_DELETE); });
    }

    @Test
    void getAll() {
        var actor = movieWebRep.GetAll();

        assertNull(actor);
        assertTrue(actor.size() > 0);
    }

    @Test
    void getById() {
        var actor = movieWebRep.GetById(2);

        assertNotNull(actor);
    }
}