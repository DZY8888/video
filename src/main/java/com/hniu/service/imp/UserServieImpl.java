package com.hniu.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hniu.entity.User;
import com.hniu.entity.UserExample;
import com.hniu.entity.UserExample.Criteria;
import com.hniu.mapper.UserMapper;
import com.hniu.service.UserService;
/*
 * 用户管理Service
 */
@Service
public class UserServieImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> getUser(Integer id) {
		UserExample example=new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(id);
		return userMapper.selectByExample(example);
	}

	@Override
	public Object insertUser(User user) {
		
		return userMapper.insert(user);
	}

	@Override
	public Object updateUser(User user) {
		
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public Object deleteUser(Integer id) {
		
		return userMapper.deleteByPrimaryKey(id);
	}
	
	

}
