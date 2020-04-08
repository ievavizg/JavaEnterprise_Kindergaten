package lt.vu.mybatis.dao;

import lt.vu.mybatis.model.ActivitiesGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivitiesGroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ACTIVITIES_GROUP
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ACTIVITIES_GROUP
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    int insert(ActivitiesGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ACTIVITIES_GROUP
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    ActivitiesGroup selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ACTIVITIES_GROUP
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    List<ActivitiesGroup> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.ACTIVITIES_GROUP
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    int updateByPrimaryKey(ActivitiesGroup record);

    List<ActivitiesGroup> selectActivitiesByChildren(Integer childrenId);
}