package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.Jpa;

import cat.uvic.teknos.m06.MovieWeb.domain.models.Actor;
import cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.MovieWebRep;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JpaActorRepository implements MovieWebRep {

    private final EntityManagerFactory entityManagerFactory;

    public JpaActorRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    @Override
    public void Delete(int id) {
        var entityManager = entityManagerFactory.createEntityManager();
        var actor = entityManager.find(Actor.class, id);
        entityManager.getTransaction().begin();
        if (actor != null) {
            entityManager.merge(actor); // the merge create new ob
            entityManager.remove(actor);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void Save(Object actor) {
        if (((Actor) actor).getId() <= 0) // if film ID is 0 or less execute insert function, else execute the Update
            Insert((Actor) actor);
        else
            Update((Actor) actor);
    }

    public void Insert(Actor actor) {
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin(); // start transaction
        entityManager.persist(actor); //insert film ob
        entityManager.getTransaction().commit(); // commit
    }

    public void Update(Actor actor){
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(actor);
        entityManager.getTransaction().commit();
    }

    public List<Actor> GetAll() {
        var entityManager = entityManagerFactory.createEntityManager();
        var query = entityManager.createQuery("SELECT Actor FROM Actor actor");
        return query.getResultList();
    }

    public Actor GetById(Integer id) {
        var entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Actor.class, id);
    }
}
