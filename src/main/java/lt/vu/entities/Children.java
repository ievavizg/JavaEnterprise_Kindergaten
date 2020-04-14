package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Children.findAll", query = "select ch from Children as ch where ch.kindergarten_group.id=:kindGroupId")

})
@Table(name = "CHILDREN")
@Getter @Setter
public class Children implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Size(max = 20)
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Size(max = 50)
    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "BIRTHDATE")
    private Date birthDate;

    @NotNull(message = "Please enter personal code")
    @Column(name = "PERSONAL_CODE")
    private Long personalCode;

    @ManyToOne
    @JoinColumn(name="KIND_GROUP_ID")
    private KindergartenGroup kindergarten_group;

    @ManyToMany
    @JoinTable(name="CHILDREN_ACTIVITIES")
    private List<ActivitiesGroup> activities_groups = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Children children = (Children) o;
        return Objects.equals(personalCode, children.personalCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(personalCode);
    }

}
