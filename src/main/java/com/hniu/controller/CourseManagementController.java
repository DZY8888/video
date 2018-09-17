package com.hniu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hniu.entity.CourseType;
import com.hniu.service.CurriculumStatisticsService;

/*
 * 课程类别管理管理
 */

@RestController
public class CourseManagementController {

	@Autowired
	private CurriculumStatisticsService curriculumStatisticsService;
	
	
	@PostMapping("/insertcurriculum")
	public Object insertcurriculum(@RequestBody CourseType courseType) {
		if (courseType == null) {
			return "参数不能为空";
		}
		return curriculumStatisticsService.insertcurriculum(courseType);
	}
	
	@GetMapping("/getcurriculum")
	public Object getcurriculum(Integer id) {
		if (id == null) {
			return "参数不能为空";
		}
		return curriculumStatisticsService.getcurriculum(id);
	}
	
	@PutMapping("/updatecurriculum")
    public Object updatecurriculum(@RequestBody CourseType courseType) {
		if (courseType == null) {
			return "参数不能为空";
		}
		return curriculumStatisticsService.updatecurriculum(courseType);
	}
	
	@PutMapping("/deletecurriculum")
    public Object deletecurriculum(Integer id) {
		if (id == null) {
			return "参数不能为空";
		}
		return curriculumStatisticsService.deletecurriculum(id);
	}
	
	
	
}
