package com.hjk532.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjk532.spring.module.Type;
import com.hjk532.spring.module.TypeVo;
import com.hjk532.spring.module.mapper.TypeMapper;
import com.hjk532.spring.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	TypeMapper typeMapper;

	@Override
	public boolean addType(Type type) throws Exception {
		boolean result = typeMapper.addType(type);
		return result;
	}

	@Override
	public boolean deleteType(Integer tNum) throws Exception {
		boolean result = typeMapper.deleteType(tNum);
		return result;
	}

	@Override
	public boolean updateType(Type type) throws Exception {
		boolean result = typeMapper.updateType(type);
		return result;
	}

	@Override
	public Type findByNum(Integer tNum) throws Exception {
		return typeMapper.findByNum(tNum);
	}

	@Override
	public Type findByName(String tName) throws Exception {
		return typeMapper.findByName(tName);
	}

	@Override
	public List<TypeVo> findType(Integer page) throws Exception {
		Integer start = -1;
		Integer end = 9;
		return typeMapper.findType(start + page, end + page);
	}
	@Override
	public List<TypeVo> findAllType() throws Exception {
		return typeMapper.findAllType();
	}

}
