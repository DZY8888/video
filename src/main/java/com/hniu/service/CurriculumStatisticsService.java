package com.hniu.service;

import org.springframework.stereotype.Repository;
import com.hniu.entity.Comment;
import com.hniu.entity.CourseType;

@Repository
public interface CurriculumStatisticsService {
         
	Object getCurriculumStudyNum(Integer id);

	//拿到当前学习人数有统计
	Integer getCurrentStudyNum(Integer id);

	//拿到课程评价记录条数
	Object getCurriculumEvaluation(Integer id);

	
	/*
	 * 课程统计接口
	 */
	Object insertcurriculum(CourseType courseType);

	Object getcurriculum(Integer id);

	Object updatecurriculum(CourseType courseType);

	Object deletecurriculum(Integer id);
	
	
	
	/*
	 * 2.课程名称，学校名称，教师名，课程介绍、课程寄语、预备知识、。。。
	 * 评分标准，已参与人数（开课表中该课程ID对应的参与人数之和）等。
	 */
    Object getCouresDetails(Integer id);

  	/*显示列出课程名称，评价内容，评价时间，及评价标星*/
	Object getCommentInformation(Integer id);

	/*2.显示课程总的评价数和课程得分*/
	Object getEvaluateNum(Integer id);

	//拿到视频地址
	Object getVideo(Integer id);

	/*1.针对课程发表评价，点赞，标星（5颗星）*/
	Object insertComment(Comment comment);

	/*单击立即加入，用户可以学习课程*/
	Object JoinTheCourseByid(Integer id);
	
} 
