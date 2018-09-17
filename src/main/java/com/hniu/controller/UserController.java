package com.hniu.controller;
/*
 * 用户管理
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hniu.entity.User;
import com.hniu.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/insertUser")
	public Object insertUser(@RequestBody User user) {
		if(user == null) {
	    	return "参数不能为空";
	    }
		return userService.insertUser(user);
	}
	
	@GetMapping("getUserId")
    public Object getUser(Integer id){
		if(id == null){
			return "参数不能为空";
		}
        return  userService.getUser(id);
    }
	
    @PutMapping("updateUser")	
	public Object updateUser(@RequestBody User user) {
    	if(user == null){
			return "参数不能为空";
		}
		return userService.updateUser(user);
	}
    
    @DeleteMapping("deleteUser")
    public Object deleteUser(Integer id) {
    	if(id == null){
			return "参数不能为空";
		}
    	return userService.deleteUser(id);
    }
	
	
}
