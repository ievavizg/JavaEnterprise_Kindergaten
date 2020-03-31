package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity

@Table(name = "ACTIVITIES_GROUP")
@Getter
@Setter
public class Activities_Group {
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

    @OneToMany(mappedBy = "KINDERGARTEN_GROUP")
    private List<Children> childrenList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activities_Group activities_group = (Activities_Group) o;
        return Objects.equals(name, activities_group.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
