package com.hniu.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hniu.constant.StateCode;
import com.hniu.controller.Base;
import com.hniu.entity.Comment;
import com.hniu.entity.CommentExample;
import com.hniu.entity.CommentExample.Criteria;
import com.hniu.mapper.CommentMapper;
import com.hniu.service.CommentService;
import com.hniu.util.ChangliangUtil;
import com.hniu.util.State;

/*
 * 查询评论controller
 */

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
    private CommentMapper commentmapper;
	
	public Base base;
	
	public StateCode StateCode;
	
	@Override
	public State<Object> getComment(Integer id) {
		Comment selectByPrimaryKey = commentmapper.selectByPrimaryKey(id);
		if (selectByPrimaryKey != null) {
			return base.packaging(StateCode.selectByExample, ChangliangUtil.QUERYSUCCESS, id);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL, id);
		}
	}
	
	

}
