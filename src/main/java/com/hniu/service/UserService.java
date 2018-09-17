package com.hniu.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hniu.entity.User;
/*
 * 用户管理接口
 */

@Repository
public interface UserService {

	List<User> getUser(Integer id);

	Object insertUser(User user);

	Object updateUser(User user);

	Object deleteUser(Integer id);
	
	
}
