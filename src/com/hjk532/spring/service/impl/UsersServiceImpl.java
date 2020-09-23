package com.hjk532.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hjk532.spring.module.Operator;
import com.hjk532.spring.module.OperatorVo;
import com.hjk532.spring.module.UsersVo;
import com.hjk532.spring.module.mapper.OperatorMapper;
import com.hjk532.spring.module.mapper.UsersMapper;
import com.hjk532.spring.service.UsersService;

public class UsersServiceImpl implements UsersService {

	@Autowired UsersMapper UsersMapper;
	@Autowired OperatorMapper operatorMapper;

	@Override
	public boolean addUsers(UsersVo users) throws Exception{
		boolean result = UsersMapper.addUsers(users);
		return result;
	}

	@Override
	public boolean deleteUsers(Integer oid) throws Exception{
		boolean result = UsersMapper.deleteUsers(oid);
		return result;
	}

	@Override
	public boolean updateUsers(UsersVo Users) throws Exception{
		boolean result = UsersMapper.updateUsers(Users);
		return result;
	}

	@Override
	public UsersVo findByAccount(String account) throws Exception{
		UsersVo user=UsersMapper.findByAccount(account);
		Operator op=operatorMapper.findByNum(user.getOpId()).getOperator();
		user.setOperator(op);
		return user;
	}

	@Override
	public UsersVo findByName(String oinfo) throws Exception{
		return UsersMapper.findByName(oinfo);
	}

	@Override
	public List<UsersVo> findUsers(Integer page) throws Exception{
		Integer start = -1;
		Integer end = 9;
		return UsersMapper.findUsers(start + page, end + page);
	}
}
