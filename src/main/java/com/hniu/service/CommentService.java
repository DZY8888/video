package com.hniu.service;

import org.springframework.stereotype.Repository;

import com.hniu.entity.Comment;
import com.hniu.util.State;

@Repository
public interface CommentService {

	State<Object> getComment(Integer id);
	
	
}
