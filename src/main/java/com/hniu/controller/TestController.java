package com.hniu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hniu.service.UserService;

@RestController
public class TestController {

	    @Autowired
	    private UserService userService;
	
	    @RequestMapping("test")
	    public String test(){
	        System.out.println("hello");
	        return "hello";
	    }
       
	/*    @RequestMapping("getUserId")
	    public List<User> getUser(Integer id){

	        return  userService.getUser(id);
	    }*/
	

}
