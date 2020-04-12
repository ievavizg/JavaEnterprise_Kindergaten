package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.ActivitiesGroup;
import lt.vu.entities.Children;
import lt.vu.mybatis.dao.ActivitiesGroupMapper;
import lt.vu.mybatis.dao.ChildrenActivitiesMapper;
import lt.vu.mybatis.model.ChildrenActivities;
import lt.vu.persistence.ActivitiesDAO;
import lt.vu.persistence.ChildrenDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Model
@RequestScoped
public class ChildrenInformation {
    @Inject
    private ChildrenDAO childrenDAO;

    @Inject
    private ActivitiesDAO activitiesDAO;

    @Inject
    private ActivitiesGroupMapper activitiesGroupMapper;

    @Inject
    private ChildrenActivitiesMapper childrenActivitiesMapper;

    @Getter
    @Setter
    private Children children = new Children();

    @Getter
    @Setter
    private ActivitiesGroup activitiesGroup = new ActivitiesGroup();

    @Getter
    private List<lt.vu.mybatis.model.ActivitiesGroup> activitiesGroupList;

    @Getter
    private List<lt.vu.mybatis.model.ChildrenActivities> childrenActivities;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer childrenId = Integer.parseInt(requestParameters.get("childrenId"));
        this.children = childrenDAO.findOne(childrenId);
        loadChildren(childrenId);
        loadChildrenActivities(childrenId);
    }

    private void loadChildrenActivities(Integer studentId) {
        this.activitiesGroupList = activitiesGroupMapper.selectActivitiesByChildren(studentId);
    }

    private void loadChildren(Integer childrenId) {
        this.children = childrenDAO.findOne(childrenId);
    }

}
