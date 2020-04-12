package lt.vu.persistence;

import lt.vu.entities.ActivitiesGroup;
import lt.vu.entities.Children;
import lt.vu.entities.KindergartenGroup;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ActivitiesDAO {

    @Inject
    private EntityManager entityManager;

    public List<ActivitiesGroup> loadAll() {
        return entityManager.createNamedQuery("activitiesGroup.loadAll", ActivitiesGroup.class).getResultList();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void persist(ActivitiesGroup activitiesGroup) {
        this.entityManager.persist(activitiesGroup);
    }

    public void remove(ActivitiesGroup activitiesGroup) {
        this.entityManager.remove(activitiesGroup);
    }

    public ActivitiesGroup findOne(Integer id) {
        return entityManager.find(ActivitiesGroup.class, id);
    }

}
