package com.hniu.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hniu.entity.User;
/*
 * 用户管理接口
 */
import com.hniu.util.State;

@Repository
public interface UserService {

	State<Object> getUser(Integer id);

	State<Object> insertUser(User user);

	State<Object> updateUser(User user);

	State<Object> deleteUser(Integer id);

	State<Object> getUserAll(Integer page, Integer rows);

	
	
}
