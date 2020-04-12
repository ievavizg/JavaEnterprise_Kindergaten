package lt.vu.persistence;

import lt.vu.entities.Children;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ChildrenDAO {

    @Inject
    private EntityManager entityManager;

    public List<Children> loadAll(Integer kindGroupId) {
        return entityManager.createNamedQuery("Children.findAll", Children.class).setParameter("kindGroupId", kindGroupId).getResultList();
    }

    public void persist(Children children) {
        this.entityManager.persist(children);
    }

    public Children findOne(Integer id) {
        return entityManager.find(Children.class, id);
    }

}
