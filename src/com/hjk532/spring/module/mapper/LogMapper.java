package com.hjk532.spring.module.mapper;

import java.util.Date;
import java.util.List;

import com.hjk532.spring.module.Log;

public interface LogMapper {
	/**
	 * .添加日志
	 * 
	 * @param log 日志bean
	 * @return 操作是否成功
	 */
	public boolean addLog(Log log);

	/**
	 * .批量添加日志
	 * 
	 * @param logs 日志bean
	 * @return 操作是否成功
	 */
	public boolean addLogs(List<Log> logs);

	/**
	 * .删除日志
	 * 
	 * @param logId 日志编号
	 * @return 操作是否成功
	 */
	public boolean deleteLog(Integer logId);
	
	/**
	 * .批量删除日志
	 * 
	 * @param logId 日志编号
	 * @return 操作是否成功
	 */
	public boolean deleteLogs(List<Integer> logId);

	/**
	 * .修改日志
	 * 
	 * @param log 日志信息
	 * @return 操作是否成功
	 */
	public boolean updateLog(Log log);

	/**
	 * .按id查询日志
	 * 
	 * @param logId 日志编号信息
	 * @return 操作是否成功
	 */

	public Log findByLogId(Integer logId);

	/**
	 * .按日期查询日志
	 * 
	 * @param date 日志编号信息
	 * @return 操作是否成功
	 */
	public List<Log> findByDate(Date date);

	/**
	 * .按日志操作员编号查询日志
	 * 
	 * @param opId 日志名信息
	 * @return 操作是否成功
	 */
	public List<Log> findByOpid(Integer opId);

	/**
	 * .分页显示所有入库日志
	 * 
	 * @param start 起始行
	 * @param end   结束行(不包含)
	 * @return 操作是否成功
	 */
	public List<Log> findInLog(Integer start, Integer end);

	/**
	 * .分页显示所有出库日志
	 * 
	 * @param start 起始行
	 * @param end   结束行(不包含)
	 * @return 操作是否成功
	 */
	public List<Log> findOutLog(Integer start, Integer end);

	/**
	 * .分页显示所有变更日志
	 * 
	 * @param start 起始行
	 * @param end   结束行(不包含)
	 * @return 操作是否成功
	 */
	public List<Log> findChangeLog(Integer start, Integer end);

	/**
	 * .分页显示所有本周入库日志
	 * 
	 * @param start 起始行
	 * @param end   结束行(不包含)
	 * @return 操作是否成功
	 */
	public List<Log> findInLogWeek(Integer start, Integer end);

	/**
	 * .分页显示所有本周出库日志
	 * 
	 * @param start 起始行
	 * @param end   结束行(不包含)
	 * @return 操作是否成功
	 */
	public List<Log> findOutLogWeek(Integer start, Integer end);

	/**
	 * .分页显示所有本周变更日志
	 * 
	 * @param start 起始行
	 * @param end   结束行(不包含)
	 * @return 操作是否成功
	 */
	public List<Log> findChangeLogWeek(Integer start, Integer end);

	/**
	 * .分页显示所有入库日志
	 * 
	 * @param start 起始行
	 * @param end   结束行(不包含)
	 * @return 操作是否成功
	 */
	public List<Log> findInLogOpt(Integer start, Integer end, Integer opId);

	/**
	 * .分页显示所有出库日志
	 * 
	 * @param start 起始行
	 * @param end   结束行(不包含)
	 * @return 操作是否成功
	 */
	public List<Log> findOutLogOpt(Integer start, Integer end, Integer opId);

	/**
	 * .分页显示所有变更日志
	 * 
	 * @param start 起始行
	 * @param end   结束行(不包含)
	 * @return 操作是否成功
	 */
	public List<Log> findChangeLogOpt(Integer start, Integer end, Integer opId);

	/**
	 * .分页显示所有本周入库日志
	 * 
	 * @param start 起始行
	 * @param end   结束行(不包含)
	 * @return 操作是否成功
	 */
	public List<Log> findInLogWeekOpt(Integer start, Integer end, Integer opId);

	/**
	 * .分页显示所有本周出库日志
	 * 
	 * @param start 起始行
	 * @param end   结束行(不包含)
	 * @return 操作是否成功
	 */
	public List<Log> findOutLogWeekOpt(Integer start, Integer end, Integer opId);

	/**
	 * .分页显示所有本周变更日志
	 * 
	 * @param start 起始行
	 * @param end   结束行(不包含)
	 * @return 操作是否成功
	 */
	public List<Log> findChangeLogWeekOpt(Integer start, Integer end, Integer opId);

}
