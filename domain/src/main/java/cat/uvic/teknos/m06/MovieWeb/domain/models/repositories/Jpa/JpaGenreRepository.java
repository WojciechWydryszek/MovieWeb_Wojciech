package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.Jpa;

import cat.uvic.teknos.m06.MovieWeb.domain.models.Genre;
import cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.MovieWebRep;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JpaGenreRepository implements MovieWebRep {

    private final EntityManagerFactory entityManagerFactory;

    public JpaGenreRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void Delete(int id) {
        var entityManager = entityManagerFactory.createEntityManager();
        var genre = entityManager.find(Genre.class, id);
        entityManager.getTransaction().begin();
        if (genre != null) {
            entityManager.merge(genre); // the merge create new ob
            entityManager.remove(genre);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void Save(Object genre) {
        if (((Genre) genre).getId() <= 0) // if film ID is 0 or less execute insert function, else execute the Update
            Insert((Genre) genre);
        else
            Update((Genre) genre);
    }

    public void Insert(Genre genre) {
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin(); // start transaction
        entityManager.persist(genre); //insert film ob
        entityManager.getTransaction().commit(); // commit
    }

    public void Update(Genre genre){
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(genre);
        entityManager.getTransaction().commit();
    }

    public Genre GetById(Integer id) {
        var entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Genre.class, id);
    }

    public List<Genre> GetAll() {
        var entityManager = entityManagerFactory.createEntityManager();
        var query = entityManager.createQuery("SELECT GENRE FROM Genre genre");
        return query.getResultList();
    }
}
