package com.hniu.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hniu.constant.StateCode;
import com.hniu.controller.Base;
import com.hniu.entity.User;
import com.hniu.entity.UserExample;
import com.hniu.entity.UserExample.Criteria;
import com.hniu.mapper.UserMapper;
import com.hniu.service.UserService;
import com.hniu.util.ChangliangUtil;
import com.hniu.util.State;
/*
 * 用户管理Service
 */
@Service
public class UserServieImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	public Base base;
	
	public StateCode StateCode;
	
	@Override
	public State<Object> getUser(Integer id) {
		UserExample example=new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(id);
		List<User> selectByExample = userMapper.selectByExample(example);
		if (selectByExample != null && selectByExample.size() > 0) {
			return base.packaging(StateCode.selectByExample, ChangliangUtil.QUERYSUCCESS, selectByExample);
		}
		return base.packaging(StateCode.FAIL, ChangliangUtil.QUERYFAIL, selectByExample);
	}

	@Override
	public  State<Object> insertUser(User user) {
		int i=userMapper.insert(user);
		if (i == 1) {
			return base.packaging(StateCode.selectByExample,ChangliangUtil.INSERTSUCCESS, i);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.INSERTFAIL, i);
		}
	}

	@Override
	public State<Object> updateUser(User user) {
		int i = userMapper.updateByPrimaryKey(user);
		if (i == 1) {
			return base.packaging(StateCode.selectByExample, ChangliangUtil.UPDATESUCCESS,i);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.UPDATEFAIL,i);
		}
	}

	@Override
	public State<Object> deleteUser(Integer id) {
		int i = userMapper.deleteByPrimaryKey(id);
		if (i == 1) {
			return base.packaging(StateCode.selectByExample, ChangliangUtil.DELETESUCCESS,i);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.DELETEFAIL,i);
		}
	}

	@Override
	public State<Object> getUserAll(Integer page,Integer rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		List<Object> list=new ArrayList<>();
		UserExample userExample=new UserExample();
		Criteria createCriteria = userExample.createCriteria();
		List<User> selectByExample = userMapper.selectByExample(userExample);
		if (selectByExample != null && selectByExample.size() > 0) {
			PageInfo info=new PageInfo(selectByExample);
			list.add(info.getTotal());
			return base.packaging(StateCode.selectByExample, ChangliangUtil.DELETESUCCESS,list);
		}else {
			return base.packaging(StateCode.FAIL, ChangliangUtil.DELETEFAIL,selectByExample);
		}
	}

}
