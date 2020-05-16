package lt.vu.rest.contracts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KindergartenGroupDTO {
    private String name;
    private String description;
    private String teacherName;
    private String teacherLastName;
    private int teacherId;
}
