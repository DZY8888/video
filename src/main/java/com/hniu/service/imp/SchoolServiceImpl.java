package com.hniu.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hniu.entity.CourseType;
import com.hniu.entity.University;
import com.hniu.mapper.CourseTypeMapper;
import com.hniu.mapper.UniversityMapper;
import com.hniu.service.SchoolService;
/*
 * 学校管理Service
 */


@Service
public class SchoolServiceImpl implements SchoolService{

	
	@Autowired
	private UniversityMapper universityMapper;
	
	@Override
	public Object insertSchool(University university) {
	
		return universityMapper.insert(university);
	}
	
	@Override
	public Object getSchool(Integer id) {
	
		return universityMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public Object updateSchool(University university) {
	
		return universityMapper.updateByPrimaryKey(university);
	}

	@Override 
	public Object deleteSchool(Integer id) {
		
		return universityMapper.deleteByPrimaryKey(id);
	}
		

}
