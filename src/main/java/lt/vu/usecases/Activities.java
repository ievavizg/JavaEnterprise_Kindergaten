package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.ActivitiesGroup;
import lt.vu.entities.KindergartenGroup;
import lt.vu.persistence.ActivitiesDAO;
import lt.vu.persistence.KindergartenGroupDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
@RequestScoped
public class Activities {
    @Inject
    private ActivitiesDAO activitiesDAO;

    @Getter
    @Setter
    private ActivitiesGroup activitiesGroup = new ActivitiesGroup();


    @Getter
    private List<ActivitiesGroup> allActivities;

    @PostConstruct
    public void init(){
        loadAllActivitiesGroups();
    }


    private void loadAllActivitiesGroups(){
        this.allActivities = activitiesDAO.loadAll();
    }

    @Transactional
    public String createActivitiesGroup(){
        this.activitiesDAO.persist(activitiesGroup);
        return "index?faces-redirect=true";
    }

}
