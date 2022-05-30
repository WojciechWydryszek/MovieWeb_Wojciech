package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.Jpa;

import cat.uvic.teknos.m06.MovieWeb.domain.models.Genre;
import cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.MovieWebRep;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class JpaGenreRepositoryTest {
    private static final int  MODEL_TO_DELETE = 2;
    private static EntityManagerFactory entityManagerFactory;
    private static MovieWebRep movieWebRep;

    public JpaGenreRepositoryTest(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @BeforeAll
    static void SetUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("movieweb_mysql");
        movieWebRep = new JpaGenreRepository(entityManagerFactory);
    }

        @Test
        void saveInsert() {
            Genre genre = new Genre();

            genre.setName("Action");
            genre.setId(0);

            assertDoesNotThrow(() -> {
                movieWebRep.Save(genre);
            });

            assertTrue(genre.getId() > 0);
        }

        @Test
        void saveUpdate(){
            Genre genre = new Genre();

            genre.setId(1);
            genre.setName("Action");

            assertDoesNotThrow(() -> { movieWebRep.Save(genre); });

             assertTrue(genre.getId() > 0);
        }

        @Test
        void delete() {
            assertDoesNotThrow(() -> { movieWebRep.Delete(MODEL_TO_DELETE); });
        }

        @Test
        void getAll() {
            var filmGenre = movieWebRep.GetAll();

            assertNotNull(filmGenre);
            assertTrue(filmGenre.size() > 0);
        }

        @Test
        void getById() {
            var filmGenre = movieWebRep.GetById(2);

            assertNotNull(filmGenre);
        }
}