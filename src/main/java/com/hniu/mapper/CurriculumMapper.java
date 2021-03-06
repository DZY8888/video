package com.hniu.mapper;

import com.hniu.entity.CouresDetails;
import com.hniu.entity.Curriculum;
import com.hniu.entity.CurriculumExample;
import com.hniu.entity.CurriculumWithBLOBs;
import com.hniu.entity.NavigationDetails;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CurriculumMapper {
    int countByExample(CurriculumExample example);

    int deleteByExample(CurriculumExample example);

    int deleteByPrimaryKey(Integer curriculumId);

    int insert(CurriculumWithBLOBs record);

    int insertSelective(CurriculumWithBLOBs record);

    List<CurriculumWithBLOBs> selectByExampleWithBLOBs(CurriculumExample example);

    List<Curriculum> selectByExample(CurriculumExample example);

    CurriculumWithBLOBs selectByPrimaryKey(Integer curriculumId);

    int updateByExampleSelective(@Param("record") CurriculumWithBLOBs record, @Param("example") CurriculumExample example);

    int updateByExampleWithBLOBs(@Param("record") CurriculumWithBLOBs record, @Param("example") CurriculumExample example);

    int updateByExample(@Param("record") Curriculum record, @Param("example") CurriculumExample example);

    int updateByPrimaryKeySelective(CurriculumWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CurriculumWithBLOBs record);

    int updateByPrimaryKey(Curriculum record);
    //统计总数
    int count();
    
    //DZY
    Integer getcurriculumMapperStudyNum();

    /*拿到当期学习人数统计 DZY*/
	Integer getCurrentStudyNum(@Param("id") Integer id);

	/*拿到课程评价记录条数 DZY*/
	Integer getCurriculumEvaluation(@Param("id") Integer id);
	
	/*2.课程名称，学校名称，教师名，课程介绍、课程寄语、预备知识、。。。
          评分标准，已参与人数（开课表中该课程ID对应的参与人数之和）等。 DZY*/
	CouresDetails getCouresDetails(@Param("id") Integer id);
	
	/*单击立即加入，用户可以学习课程 DZY*/
	CouresDetails JoinTheCourseByid(@Param("id") Integer id);

	NavigationDetails getNavigationDetails(@Param("id") Integer id);
}