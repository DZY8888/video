package com.hniu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hniu.service.CommentService;

/*
 * 发表评论Controller
 */
@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@GetMapping("getComment")
	public Object getComment(Integer id) {
		if (id == null) {
			return "参数不能为空";
		}
		return commentService.getComment(id);
	}
	
	
	
	
	
}
