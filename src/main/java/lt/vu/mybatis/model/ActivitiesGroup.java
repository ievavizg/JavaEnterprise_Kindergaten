package lt.vu.mybatis.model;

public class ActivitiesGroup {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ACTIVITIES_GROUP.ID
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ACTIVITIES_GROUP.DESCRIPTION
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ACTIVITIES_GROUP.NAME
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ACTIVITIES_GROUP.TEACHER_ID
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    private Integer teacherId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ACTIVITIES_GROUP.ID
     *
     * @return the value of PUBLIC.ACTIVITIES_GROUP.ID
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ACTIVITIES_GROUP.ID
     *
     * @param id the value for PUBLIC.ACTIVITIES_GROUP.ID
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ACTIVITIES_GROUP.DESCRIPTION
     *
     * @return the value of PUBLIC.ACTIVITIES_GROUP.DESCRIPTION
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ACTIVITIES_GROUP.DESCRIPTION
     *
     * @param description the value for PUBLIC.ACTIVITIES_GROUP.DESCRIPTION
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ACTIVITIES_GROUP.NAME
     *
     * @return the value of PUBLIC.ACTIVITIES_GROUP.NAME
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ACTIVITIES_GROUP.NAME
     *
     * @param name the value for PUBLIC.ACTIVITIES_GROUP.NAME
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ACTIVITIES_GROUP.TEACHER_ID
     *
     * @return the value of PUBLIC.ACTIVITIES_GROUP.TEACHER_ID
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    public Integer getTeacherId() {
        return teacherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ACTIVITIES_GROUP.TEACHER_ID
     *
     * @param teacherId the value for PUBLIC.ACTIVITIES_GROUP.TEACHER_ID
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}