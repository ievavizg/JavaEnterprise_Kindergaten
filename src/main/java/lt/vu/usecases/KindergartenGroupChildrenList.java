package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Children;
import lt.vu.entities.KindergartenGroup;
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
public class KindergartenGroupChildrenList {

    @Inject
    private ChildrenDAO childrenDAO;

    @Inject
    private KindergartenGroupDAO kindergartenGroupDAO;

    @Getter
    @Setter
    private Children children = new Children();

    @Getter
    @Setter
    private KindergartenGroup kindergartenGroup = new KindergartenGroup();

    @Getter
    private List<Children> childrenList;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer kindGroupId = Integer.parseInt(requestParameters.get("kindGroupId"));
        this.kindergartenGroup = kindergartenGroupDAO.findOne(kindGroupId);
        loadKindergartenGroupChildren(kindGroupId);
    }

    private void loadKindergartenGroupChildren(Integer kindGroupId) {
        this.childrenList = childrenDAO.loadAll(kindGroupId);
    }

    @Transactional
    public String createChildren() {
        children.setKindergarten_group(this.kindergartenGroup);
        childrenDAO.persist(children);
        return "groupKids?faces-redirect=true&kindGroupId=" + this.kindergartenGroup.getId();
    }
}
