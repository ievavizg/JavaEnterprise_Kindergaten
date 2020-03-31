package lt.vu.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Teacher {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Size(max = 20)
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Size(max = 50)
    @Column(name = "LAST_NAME")
    private Integer lastName;

    @Size(max = 11)
    @Column(name = "PERSONAL_CODE")
    private Long personalCode;

    @OneToMany(mappedBy = "TEACHER")
    private List<Kindergarten_Group> kindergarten_groups = new ArrayList<>();

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