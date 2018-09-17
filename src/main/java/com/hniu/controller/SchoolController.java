package com.hniu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hniu.entity.University;
import com.hniu.service.SchoolService;


@RestController
public class SchoolController {

	@Autowired
	private SchoolService schoolService;
	
	@PostMapping("/insertSchool")
	public Object insertSchool(@RequestBody University university) {
	    System.out.println("学校的名称是"+university.getSchoolName()+"id是+"+university.getUniversityId());
		return schoolService.insertSchool(university);
	}
	
	@GetMapping("/getSchool")
	public Object getSchool(Integer id) {
	    if(id == null) {
	    	return "参数不能为空";
	    }
		return schoolService.getSchool(id);
	}
	
	@PutMapping("/updateSchool")
	public Object updateSchool(@RequestBody University university) {
		if(university == null) {
		    	return "参数不能为空";
		}
		return schoolService.updateSchool(university);
	}
	
	@DeleteMapping("/deleteSchool")
	public Object deleteSchool(Integer id) {
		if(id == null) {
	    	return "参数不能为空";
	    }
		return schoolService.deleteSchool(id);
	}

}
