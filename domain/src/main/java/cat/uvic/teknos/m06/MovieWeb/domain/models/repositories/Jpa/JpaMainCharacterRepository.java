package cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.Jpa;

import cat.uvic.teknos.m06.MovieWeb.domain.models.MainCharacter;
import cat.uvic.teknos.m06.MovieWeb.domain.models.repositories.MovieWebRep;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JpaMainCharacterRepository implements MovieWebRep {

    private final EntityManagerFactory entityManagerFactory;

    public JpaMainCharacterRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    @Override
    public void Delete(int id) {
        var entityManager = entityManagerFactory.createEntityManager();
        var mainCharacter = entityManager.find(MainCharacter.class, id);
        entityManager.getTransaction().begin();
        if (mainCharacter != null) {
            entityManager.merge(mainCharacter); // the merge create new ob
            entityManager.remove(mainCharacter);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void Save(Object mainCharacter) {
        if (((MainCharacter) mainCharacter).getId() <=0)
            Insert ((MainCharacter) mainCharacter);
        else
            Update((MainCharacter) mainCharacter);
    }

    public void Insert(MainCharacter mainCharacter){
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(mainCharacter);
        entityManager.getTransaction().commit();
    }

    public void Update(MainCharacter mainCharacter){
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(mainCharacter);
        entityManager.getTransaction().commit();
    }

    public List<MainCharacter> GetAll() {
        var entityManager = entityManagerFactory.createEntityManager();
        var query = entityManager.createQuery("SELECT MainCharacter FROM MainCharacter mainCharacter");
        return query.getResultList();
    }

    public MainCharacter GetById(Integer id) {
        var entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(MainCharacter.class, id);
    }
}
