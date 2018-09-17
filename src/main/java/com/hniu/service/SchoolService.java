package com.hniu.service;

import org.springframework.stereotype.Repository;

import com.hniu.entity.CourseType;
import com.hniu.entity.University;

@Repository
public interface SchoolService {

	Object insertSchool(University university);

	Object getSchool(Integer id);

	Object updateSchool(University university);

	Object deleteSchool(Integer id);
	
}
