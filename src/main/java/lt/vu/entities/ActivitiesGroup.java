package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "activitiesGroup.loadAll", query = "select ag from ActivitiesGroup as ag")
})

@Table(name = "ACTIVITIES_GROUP")
@Getter
@Setter
public class ActivitiesGroup {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Size(max = 30)
    @Column(name = "NAME")
    private String name;

    @Size(max = 50)
    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name="TEACHER_ID")
    private Teacher teacher;

    @ManyToMany(mappedBy="activities_groups")
    private List<Children> childrenList = new ArrayList<>();

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivitiesGroup activities_group = (ActivitiesGroup) o;
        return Objects.equals(name, activities_group.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
