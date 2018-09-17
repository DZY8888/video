package com.hniu.service;

import org.springframework.stereotype.Repository;

import com.hniu.entity.Comment;

@Repository
public interface CommentService {

	Comment getComment(Integer id);
	
	
}
