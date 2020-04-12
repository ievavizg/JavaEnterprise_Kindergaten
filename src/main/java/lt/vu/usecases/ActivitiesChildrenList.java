package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.ActivitiesGroup;
import lt.vu.entities.Children;
import lt.vu.entities.KindergartenGroup;
import lt.vu.mybatis.dao.ActivitiesGroupMapper;
import lt.vu.mybatis.dao.ChildrenActivitiesMapper;
import lt.vu.mybatis.model.ChildrenActivities;
import lt.vu.persistence.ActivitiesDAO;
import lt.vu.persistence.ChildrenDAO;
import lt.vu.persistence.KindergartenGroupDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
@RequestScoped
public class ActivitiesChildrenList {

    @Inject
    private ChildrenDAO childrenDAO;

    @Inject
    private ActivitiesDAO activitiesDAO;

    @Inject
    private ActivitiesGroupMapper activitiesGroupMapper;

    @Getter
    @Setter
    private Children children = new Children();

    @Getter
    @Setter
    private ActivitiesGroup activitiesGroup = new ActivitiesGroup();

    @Getter
    private List<Children> childrenList;

    @Getter
    private List<lt.vu.mybatis.model.ActivitiesGroup> activitiesGroupList;


    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer activitiesGroupId = Integer.parseInt(requestParameters.get("activitiesGroupId"));
        this.activitiesGroup = activitiesDAO.findOne(activitiesGroupId);
        loadActivitiesGroupChildren(activitiesGroupId);
    }

    private void loadActivitiesGroupChildren(Integer activitiesGroupId) {
        this.childrenList = childrenDAO.loadAll(activitiesGroupId);
    }

/*
    @Transactional
    public String createChildren() {
        children.setKindergarten_group(this.kindergartenGroup);
        childrenDAO.persist(children);
        return "groupKids?faces-redirect=true&kindGroupId=" + this.kindergartenGroup.getId();
    }*/
}