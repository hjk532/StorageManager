package com.hjk532.spring.module.mapper;

import java.util.List;

import com.hjk532.spring.module.Type;
import com.hjk532.spring.module.TypeVo;

public interface TypeMapper {
	
	/**
	 * .添加新类型
	 * @param type 类型bean
	 * @return 操作是否成功
	 */
	public boolean addType(Type type);
	
	/**
	 * .删除类型
	 * @param tNum 类型编号
	 * @return 操作是否成功
	 */
	public boolean deleteType(Integer tNum);
	
	/**
	 * .修改类型
	 * @param type 类型信息
	 * @return 操作是否成功
	 */
	public boolean updateType(Type type);
	
	/**
	 * .按编号模糊查询类型
	 * @param tNum 类型编号信息
	 * @return 操作是否成功
	 */
	public Type findByNum(Integer tNum);
	
	/**
	 * .按类型名模糊查询类型
	 * @param tName 类型名信息
	 * @return 操作是否成功
	 */
	public Type findByName(String tName);
	
	/**
	 * .分页显示所有类型
	 * @param start 起始行
	 * @param end 结束行（不包含）
	 * @return
	 */
	public List<TypeVo> findType(Integer start,Integer end);
	/**
	 * .查找所有类型
	 * @return
	 */
	public List<TypeVo> findAllType();
}
