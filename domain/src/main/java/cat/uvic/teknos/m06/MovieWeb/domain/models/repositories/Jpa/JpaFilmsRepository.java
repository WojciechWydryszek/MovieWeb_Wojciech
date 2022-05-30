package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.Jpa;

import cat.uvic.teknos.m06.MovieWeb.domain.models.Film;
import cat.uvic.teknos.m06.MovieWeb.domain.models.Genre;
import cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.MovieWebRep;
import javax.persistence.EntityManagerFactory;
import java.security.Key;
import java.util.List;

public class JpaFilmsRepository implements MovieWebRep {

    private final EntityManagerFactory entityManagerFactory;

    public JpaFilmsRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void Delete(Object id) {

    }

    @Override
    public void Delete(Key id) {
        var entityManager = entityManagerFactory.createEntityManager();
        var film = entityManager.find(Film.class, id);
        entityManager.getTransaction().begin();
        if (film != null) {
            entityManager.merge(film);
            entityManager.remove(film);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void Save(Genre film) {
        if (((Film) film).getId() <= 0)
            Insert(film);
        else
            Update(film);
    }

    private void Insert(Film film){
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(film);
        entityManager.getTransaction().commit();
    }

    private void Update(Film film){
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(film);
        entityManager.getTransaction().commit();
    }

    public Film GetById(Integer id) {
        var entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Film.class, id);
    }

    @Override
    public List<Film> GetAll() {
        var entityManager = entityManagerFactory.createEntityManager();
        var query = entityManager.createQuery("SELECT FILM FROM Film film ");
        return query.getResultList();
    }


}



