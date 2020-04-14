package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.ActivitiesGroup;
import lt.vu.entities.KindergartenGroup;
import lt.vu.mybatis.dao.ActivitiesGroupMapper;
import lt.vu.mybatis.dao.ChildrenActivitiesMapper;
import lt.vu.mybatis.dao.ChildrenMapper;
import lt.vu.mybatis.model.Children;
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
    private ActivitiesDAO activitiesDAO;

    @Inject
    private ActivitiesGroupMapper activitiesGroupMapper;


    @Inject
    private ChildrenMapper childrenMapper;

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
  private List<Children> childrenList;


    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer activitiesGroupId = Integer.parseInt(requestParameters.get("activitiesGroupId"));
        this.activitiesGroup = activitiesDAO.findOne(activitiesGroupId);
        loadActivitiesGroupChildren(activitiesGroupId);
    }

    private void loadActivitiesGroupChildren(Integer activitiesGroupId) {
        this.childrenList = childrenMapper.selectChildrenByActivity(activitiesGroupId);
    }

}
