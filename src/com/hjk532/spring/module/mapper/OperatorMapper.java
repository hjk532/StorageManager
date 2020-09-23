package com.hjk532.spring.module.mapper;

import java.util.List;

import com.hjk532.spring.module.Operator;
import com.hjk532.spring.module.OperatorVo;

public interface OperatorMapper {

	/**
	 * .添加新操作员
	 * @param operator 操作员信息
	 * @return 操作是否成功
	 */
	public boolean addOperator(Operator operator);
	
	/**
	 * .删除操作员
	 * @param opid 操作员编号
	 * @return 操作是否成功
	 */
	public boolean deleteOperator(Integer opid);
	
	/**
	 * .修改操作员
	 * @param Operator 操作员信息
	 * @return 操作是否成功
	 */
	public boolean updateOperator(OperatorVo Operator);
	
	/**
	 * .按编号模糊查询操作员
	 * @param oid 操作员编号信息
	 * @return 操作是否成功
	 */
	public OperatorVo findByNum(Integer oid);
	
	/**
	 * .按操作员名模糊查询操作员
	 * @param oinfo 操作员名信息
	 * @return 操作是否成功
	 */
	public Operator findByName(String oinfo);
	
	/**
	 * .分页显示所有操作员
	 * @param start 起始行
	 * @param end 结束行(不包含)
	 * @return 操作是否成功
	 */
	public List<OperatorVo> findOperator(Integer start,Integer end);
}
