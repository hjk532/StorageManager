package com.hjk532.spring.service;

import java.util.List;

import com.hjk532.spring.module.UsersVo;

public interface UsersService {
	
	/**
	 * .添加新账户
	 * @param Users 账户bean
	 * @return 操作是否成功
	 */
	public boolean addUsers(UsersVo users) throws Exception;
	
	/**
	 * .删除账户
	 * @param oid 账户编号
	 * @return 操作是否成功
	 */
	public boolean deleteUsers(Integer oid) throws Exception;
	
	/**
	 * .修改账户
	 * @param Users 账户信息
	 * @return 操作是否成功
	 */
	public boolean updateUsers(UsersVo users) throws Exception;
	
	/**
	 * .查询账户
	 * @param oid 账号信息
	 * @return 操作是否成功
	 */
	public UsersVo findByAccount(String account) throws Exception ;
	
	/**
	 * .按账户名模糊查询账户
	 * @param oinfo 账户名信息
	 * @return 操作是否成功
	 */
	public UsersVo findByName(String oinfo) throws Exception;
	
	/**
	 * .分页显示所有账户
	 * @param start 起始行
	 * @param end 结束行(不包含)
	 * @return 操作是否成功
	 */
	public List<UsersVo> findUsers(Integer page) throws Exception;
}
