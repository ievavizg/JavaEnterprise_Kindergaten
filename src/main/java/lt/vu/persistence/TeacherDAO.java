package lt.vu.persistence;

import lt.vu.entities.KindergartenGroup;
import lt.vu.entities.Teacher;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TeacherDAO {

    @Inject
    private EntityManager entityManager;

    public List<Teacher> loadAll(){
        return entityManager.createNamedQuery("teacher.loadAll", Teacher.class).getResultList();
    }
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void persist(Teacher teacher){
        this.entityManager.persist(teacher);
    }

    public Teacher findOne(Integer id) {
        return entityManager.find(Teacher.class, id);
    }


}
