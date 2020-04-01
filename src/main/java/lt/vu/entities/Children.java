package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity

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
    private Integer lastName;

    @Column(name = "BIRTHDATE")
    private Date birthDate;

    @Size(max = 11)
    @Column(name = "PERSONAL_CODE")
    private Long personalCode;

    @ManyToOne
    @JoinColumn(name="KIND_GROUP_ID")
    private Kindergarten_Group kindergarten_group;

    @ManyToMany
    @JoinTable(name="CHILDREN_ACTIVITIES")
    private List<Activities_Group> activities_groups = new ArrayList<>();

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
