package com.hjk532.spring.module.mapper;

import java.util.List;

import com.hjk532.spring.module.UsersVo;

public interface UsersMapper {

	/**
	 * .添加新账户
	 * @param users 账户bean
	 * @return 操作是否成功
	 */
	public boolean addUsers(UsersVo users);
	
	/**
	 * .删除账户
	 * @param account 账户编号
	 * @return 操作是否成功
	 */
	public boolean deleteUsers(Integer account);
	
	/**
	 * .修改账户
	 * @param users 账户信息
	 * @return 操作是否成功
	 */
	public boolean updateUsers(UsersVo users);
	
	/**
	 * .按账号查询账户
	 * @param account 账号
	 * @return 操作是否成功
	 */
	public UsersVo findByAccount(String account);
	
	/**
	 * .按账户名模糊查询账户
	 * @param tName 账户名信息
	 * @return 操作是否成功
	 */
	public UsersVo findByName(String tName);
	
	/**
	 * .分页显示所有账户
	 * @param start 起始行
	 * @param end 结束行（不包含）
	 * @return
	 */
	public List<UsersVo> findUsers(Integer start,Integer end);
}
