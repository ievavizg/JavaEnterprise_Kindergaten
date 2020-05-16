package lt.vu.persistence;

import lt.vu.entities.KindergartenGroup;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class KindergartenGroupDAO {

    @Inject
    private EntityManager entityManager;

    public List<lt.vu.entities.KindergartenGroup> loadAll(){
        return entityManager.createNamedQuery("kindergartenGroup.loadAll", KindergartenGroup.class).getResultList();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void persist(KindergartenGroup kindergartenGroup){
        this.entityManager.persist(kindergartenGroup);
    }

    public KindergartenGroup findOne(Integer id) {
        return entityManager.find(KindergartenGroup.class, id);
    }

    public KindergartenGroup update(KindergartenGroup kindergartenGroup){
        return entityManager.merge(kindergartenGroup);
    }
}
