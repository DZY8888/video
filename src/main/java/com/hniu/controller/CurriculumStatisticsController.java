package com.hniu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hniu.entity.Comment;
import com.hniu.service.CurriculumStatisticsService;
/*
 * (author)邓志勇
 * 课程统计
 */

@RestController
public class CurriculumStatisticsController {

	@Autowired
	private CurriculumStatisticsService curriculumStatisticsService;
	
	/*
	 * 统计该课程被多少人学习
	 */
	@GetMapping("/getCurriculumStudyNum")
	public Object getCurriculumStudyNum(Integer id) {
		if (id == null) {
			return "参数不能为空";
		}
		return curriculumStatisticsService.getCurriculumStudyNum(id);
	}

	
	
	/*2.课程名称，学校名称，教师名，课程介绍、课程寄语、预备知识、。。。
	    评分标准，已参与人数（开课表中该课程ID对应的参与人数之和）等。*/
	@GetMapping("/getCouresDetails")
	public Object getCouresDetails(Integer id){
		if (id == null ) {
			return "参数不能为空";
		}
		return curriculumStatisticsService.getCouresDetails(id);
	}
	
	/*显示列出课程名称，评价内容，评价时间，及评价标星*/
	@GetMapping("/getCommentInformation")
	public Object getCommentInformation(Integer id) {
		if (id == null ) {
			return "参数不能为空";
		}
		return curriculumStatisticsService.getCommentInformation(id);
	}
	
	
	/*2.显示课程总的评价数和课程得分*/
	@GetMapping("/getEvaluateNum")
	public Object getEvaluateNum(Integer id){
		if (id == null) {
			return "参数不能为空";
		}
		return curriculumStatisticsService.getEvaluateNum(id);
	}
	
	
	
	/*
	 * 当前学习人数统计
	 */
	@GetMapping("/getCurrentStudyNum")
	public Object getCurrentStudyNum(Integer id) {
		 if (id == null) {
			return "参数不能为空";
		}
		return curriculumStatisticsService.getCurrentStudyNum(id);
	}
	
	/*
	 * 课程评价记录条数
	 */
	@GetMapping("/getCurriculumEvaluation")
	public Object getCurriculumEvaluation(Integer id) {
		if (id == null) {
			return "参数不能为空";
		}
		return curriculumStatisticsService.getCurriculumEvaluation(id);
	}
	
	
	/*1.课程封面视频*/
	@GetMapping("/getVideo")
	public Object getVideo(Integer id) {
		if (id == null) {
			return "参数不能为空";
		}
		return curriculumStatisticsService.getVideo(id);
	}
	
	/*1.针对课程发表评价，点赞，标星（5颗星）*/
	@PostMapping("/insertComment")
	public Object insertComment(Comment comment) {
		if (comment == null) {
			return "参数不能为空";
		}
		return curriculumStatisticsService.insertComment(comment);
	}
	

	/*单击立即加入，用户可以学习课程*/
	@GetMapping("/JoinTheCourseByid")
	public Object JoinTheCourseByid(Integer id) {
		if (id == null) {
			return "参数不能为空";
		}
		return curriculumStatisticsService.JoinTheCourseByid(id);
	}

}
