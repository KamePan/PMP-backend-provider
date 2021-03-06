package cn.edu.ecnu.dao;

import cn.edu.ecnu.domain.Judge;
import cn.edu.ecnu.domain.JudgeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JudgeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table judge
     *
     * @mbggenerated
     */
    int countByExample(JudgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table judge
     *
     * @mbggenerated
     */
    int deleteByExample(JudgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table judge
     *
     * @mbggenerated
     */
    int insert(Judge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table judge
     *
     * @mbggenerated
     */
    int insertSelective(Judge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table judge
     *
     * @mbggenerated
     */
    List<Judge> selectByExample(JudgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table judge
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Judge record, @Param("example") JudgeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table judge
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Judge record, @Param("example") JudgeExample example);
}