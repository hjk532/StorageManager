package com.hjk532.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjk532.spring.module.Operator;
import com.hjk532.spring.module.OperatorVo;
import com.hjk532.spring.module.mapper.OperatorMapper;
import com.hjk532.spring.service.OperatorService;

@Service
public class OperatorServiceImpl implements OperatorService {

	@Autowired
	OperatorMapper operatorMapper;

	@Override
	public boolean addOperator(Operator operator) throws Exception {
		boolean result = operatorMapper.addOperator(operator);
		return result;
	}

	@Override
	public boolean deleteOperator(Integer opid) throws Exception {
		boolean result = operatorMapper.deleteOperator(opid);
		return result;
	}

	@Override
	public boolean updateOperator(OperatorVo operator) throws Exception {
		if(operator.getOptGender().equals("男"))operator.setOptGender("0");
		else operator.setOptGender("1");
		boolean result = operatorMapper.updateOperator(operator);
		if(operator.getOptGender().equals("1"))operator.setOptGender("女");
		else operator.setOptGender("男");
		return result;
	}

	@Override
	public OperatorVo findByNum(Integer oid) throws Exception {
		OperatorVo operator=operatorMapper.findByNum(oid);
		if(operator.getOptGender().equals("1"))operator.setOptGender("女");
		else operator.setOptGender("男");
		return operator;
	}

	@Override
	public Operator findByName(String oinfo) throws Exception {
		return operatorMapper.findByName(oinfo);
	}

	@Override
	public List<OperatorVo> findOperator(Integer page) throws Exception {
		Integer start = -1;
		Integer end = 9;
		List<OperatorVo> operators=operatorMapper.findOperator(start + page, end + page);
		for(Operator op:operators) {
			if(op.getOptGender().equals("1"))op.setOptGender("女");
			else op.setOptGender("男");
		}
		return operators;
	}

}
