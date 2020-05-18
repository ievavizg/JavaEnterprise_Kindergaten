package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Children;
import lt.vu.mybatis.dao.ActivitiesGroupMapper;
import lt.vu.mybatis.dao.ChildrenActivitiesMapper;
import lt.vu.mybatis.model.ActivitiesGroup;
import lt.vu.mybatis.model.ChildrenActivities;
import lt.vu.persistence.ChildrenDAO;

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
public class ChildrenInformation {

    @Inject
    private ChildrenDAO childrenDAO;

    @Inject
    private ActivitiesGroupMapper activitiesGroupMapper;

    @Inject
    private ChildrenActivitiesMapper childrenActivitiesMapper;

    @Getter
    @Setter
    private Children children = new Children();

    @Getter
    @Setter
    private ChildrenActivities childrenActivities = new ChildrenActivities();

    @Getter
    @Setter
    private ActivitiesGroup activitiesGroup = new ActivitiesGroup();

    @Getter
    private List<ActivitiesGroup> activitiesGroupList;

    @Getter
    private List<ActivitiesGroup> activitiesGroupListFree;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer childrenId = Integer.parseInt(requestParameters.get("childrenId"));
        this.children = childrenDAO.findOne(childrenId);
        loadChildren(childrenId);
        loadChildrenActivities(childrenId);
        loadChildrenFreeActivities(childrenId);
    }

    private void loadChildrenActivities(Integer childrenId) {
        this.activitiesGroupList = activitiesGroupMapper.selectActivitiesByChildren(childrenId);
    }

    private void loadChildrenFreeActivities(Integer childrenId) {
        this.activitiesGroupListFree = activitiesGroupMapper.selectActivitiesByChildrenFree(childrenId);
    }

    private void loadChildren(Integer childrenId) {
        this.children = childrenDAO.findOne(childrenId);
    }


    @Transactional
    public String addActivity() {
        childrenActivities.setChildrenlistId(this.children.getId());
        childrenActivities.setActivitiesGroupsId(this.activitiesGroup.getId());
        childrenActivitiesMapper.insert(childrenActivities);
        return "children?faces-redirect=true&childrenId=" + this.children.getId();
    }

}
