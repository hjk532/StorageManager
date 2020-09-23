package com.hjk532.spring.service;

import java.util.List;

import com.hjk532.spring.module.Operator;
import com.hjk532.spring.module.OperatorVo;

public interface OperatorService {
	
	/**
	 * .添加新操作员
	 * @param Operator 操作员信息
	 * @return 操作是否成功
	 */
	public boolean addOperator(Operator operator) throws Exception;
	
	/**
	 * .删除操作员
	 * @param opid 操作员编号
	 * @return 操作是否成功
	 */
	public boolean deleteOperator(Integer opid) throws Exception;
	
	/**
	 * .修改操作员
	 * @param Operator 操作员信息
	 * @return 操作是否成功
	 */
	public boolean updateOperator(OperatorVo Operator) throws Exception;
	
	/**
	 * .按编号模糊查询操作员
	 * @param oid 操作员编号信息
	 * @return 操作是否成功
	 */
	public Operator findByNum(Integer oid) throws Exception;
	
	/**
	 * .按操作员名模糊查询操作员
	 * @param oinfo 操作员名信息
	 * @return 操作是否成功
	 */
	public Operator findByName(String oinfo) throws Exception;
	
	/**
	 * .分页显示所有操作员
	 * @param start 起始行
	 * @param end 结束行(不包含)
	 * @return 操作是否成功
	 */
	public List<OperatorVo> findOperator(Integer page) throws Exception;

}
