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
        @NamedQuery(name = "teacher.loadAll", query = "select t from Teacher t")
})

@Table(name = "TEACHER")
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Size(max = 20)
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Size(max = 50)
    @Column(name = "LAST_NAME")
    private String lastName;

    @Size(max = 11)
    @Column(name = "PERSONAL_CODE")
    private Long personalCode;

    @OneToMany(mappedBy = "teacher")
    private List<KindergartenGroup> kindergarten_groups = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(personalCode, teacher.personalCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(personalCode);
    }
}
