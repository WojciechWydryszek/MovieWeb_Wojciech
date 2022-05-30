package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.Jpa;

import cat.uvic.teknos.m06.MovieWeb.domain.models.Film;
import cat.uvic.teknos.m06.MovieWeb.domain.models.Genre;
import cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.MovieWebRep;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class JpaFilmsRepositoryTest {
    private static final int MODEL_TO_DELETE = 2;
    private static EntityManagerFactory entityManagerFactory;
    private static MovieWebRep movieWebRep;

    public JpaFilmsRepositoryTest(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @BeforeAll
    static void SetUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("movieweb_mysql");
        movieWebRep = new JpaFilmsRepository(entityManagerFactory);
    }

    @Test
    void saveInsert() {
        Film film = new Film();
        film.setName("Avatar (2002)");
        film.setId(0);

        assertDoesNotThrow(() -> { movieWebRep.Save((Genre) film); });

        assertTrue(film.getId() > 0);
    }

    @Test
    void saveUpdate() {
        Film film = new Film();

        film.setId(1);
        film.setName("Avatar (2002)");

        assertDoesNotThrow(() -> {
            movieWebRep.Save((Genre) film);
        });

        assertTrue(film.getId() > 0);
    }

    @Test
    void delete() {
        assertDoesNotThrow(() -> { movieWebRep.Delete(MODEL_TO_DELETE); });
    }

    @Test
    void getAll() {
        var film = movieWebRep.GetAll();

        assertNotNull(film);
        assertTrue(film.size() > 0);
    }

    @Test
    void getById() {
        var film = movieWebRep.GetById(2);

        assertNotNull(film);
    }
}