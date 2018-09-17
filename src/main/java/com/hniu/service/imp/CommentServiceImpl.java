package com.hniu.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hniu.entity.Comment;
import com.hniu.entity.CommentExample;
import com.hniu.entity.CommentExample.Criteria;
import com.hniu.mapper.CommentMapper;
import com.hniu.service.CommentService;

/*
 * 查询评论controller
 */

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
    private CommentMapper commentmapper;
	
	
	@Override
	public Comment getComment(Integer id) {
		
		return commentmapper.selectByPrimaryKey(id);
	}
	
	

}
