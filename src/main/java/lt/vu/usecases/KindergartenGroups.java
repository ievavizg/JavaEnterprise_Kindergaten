package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.KindergartenGroup;
import lt.vu.persistence.KindergartenGroupDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
@RequestScoped
public class KindergartenGroups {
    @Inject
    private KindergartenGroupDAO kindergartenGroupDAO;

    @Getter @Setter
    private KindergartenGroup kindergartenGroup = new KindergartenGroup();
    
    @Getter
    private List<KindergartenGroup> allKindergartenGroups;

    @PostConstruct
    public void init(){
        loadAllKindergartenGroups();
    }


    private void loadAllKindergartenGroups(){
        this.allKindergartenGroups = kindergartenGroupDAO.loadAll();
    }

    @Transactional
    public String createKindergartenGroup(){
        this.kindergartenGroupDAO.persist(kindergartenGroup);
        return "index?faces-redirect=true";
    }

}
