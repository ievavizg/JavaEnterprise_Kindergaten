package lt.vu.mybatis.dao;

import lt.vu.mybatis.model.KindergartenGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KindergartenGroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.KINDERGARTEN_GROUP
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.KINDERGARTEN_GROUP
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    int insert(KindergartenGroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.KINDERGARTEN_GROUP
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    KindergartenGroup selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.KINDERGARTEN_GROUP
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    List<KindergartenGroup> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.KINDERGARTEN_GROUP
     *
     * @mbg.generated Thu Apr 02 20:14:32 EEST 2020
     */
    int updateByPrimaryKey(KindergartenGroup record);
}