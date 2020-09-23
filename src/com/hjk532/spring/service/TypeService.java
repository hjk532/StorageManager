package com.hjk532.spring.service;

import java.util.List;

import com.hjk532.spring.module.Type;
import com.hjk532.spring.module.TypeVo;

public interface TypeService {

	/**
	 * .添加新类型
	 * @param type 类型bean
	 * @return 操作是否成功
	 */
	public boolean addType(Type type) throws Exception;
	
	/**
	 * .删除类型
	 * @param tNum 类型编号
	 * @return 操作是否成功
	 */
	public boolean deleteType(Integer tNum) throws Exception;
	
	/**
	 * .修改类型
	 * @param type 类型信息
	 * @return 操作是否成功
	 */
	public boolean updateType(Type type) throws Exception;
	
	/**
	 * .按编号模糊查询类型
	 * @param tNum 类型编号信息
	 * @return 操作是否成功
	 */
	public Type findByNum(Integer tNum) throws Exception;
	
	/**
	 * .按类型名模糊查询类型
	 * @param tName 类型名信息
	 * @return 操作是否成功
	 */
	public Type findByName(String tName) throws Exception;
	
	/**
	 * .分页显示所有类型
	 * @param start 起始行
	 * @param end 结束行（不包含）
	 * @return 结果集
	 */
	public List<TypeVo> findType(Integer page) throws Exception;
	
	/**
	 * .查找所有类型
	 * @return 结果集
	 */
	public List<TypeVo> findAllType() throws Exception;

}
