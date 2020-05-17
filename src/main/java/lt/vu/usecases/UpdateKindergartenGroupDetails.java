package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.KindergartenGroup;
import lt.vu.persistence.KindergartenGroupDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;

@ViewScoped
@Named
@Getter @Setter
public class UpdateKindergartenGroupDetails implements Serializable {

    private KindergartenGroup kindergartenGroup;

    @Inject
    KindergartenGroupDAO kindergartenGroupDAO;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer kindGroupId = Integer.parseInt(requestParameters.get("kindGroupId"));
        this.kindergartenGroup = kindergartenGroupDAO.findOne(kindGroupId);
    }

    @Transactional
    public String updateKindergartenGroup() {
        try{
            kindergartenGroupDAO.update(this.kindergartenGroup);
        } catch (OptimisticLockException e) {
            return "/kindergartenGroupDetails.xhtml?faces-redirect=true&kindGroupId=" + this.kindergartenGroup.getId() + "&error=optimistic-lock-exception";
        }
        return "index.xhtml?&faces-redirect=true";
    }
}
