package com.hjk532.spring.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hjk532.spring.module.Log;
import com.hjk532.spring.module.mapper.LogMapper;
import com.hjk532.spring.service.LogService;

public class LogServiceImpl implements LogService {

	@Autowired
	LogMapper logMapper;

	@Override
	public boolean addLog(Log log) {
		return logMapper.addLog(log);
	}

	@Override
	public boolean addLogs(List<Log> logs) {
		return logMapper.addLogs(logs);
	}

	@Override
	public boolean deleteLog(Integer logId) {
		return logMapper.deleteLog(logId);
	}
	
	@Override
	public boolean deleteLogs(List<Integer> logId) {
		return logMapper.deleteLogs(logId);
	}

	@Override
	public boolean updateLog(Log log) {
		return logMapper.updateLog(log);
	}

	@Override
	public Log findByLogId(Integer logId) {
		return logMapper.findByLogId(logId);
	}

	@Override
	public List<Log> findByDate(Date date) {
		return logMapper.findByDate(date);
	}

	@Override
	public List<Log> findByOpid(Integer OpId) {
		return logMapper.findByOpid(OpId);
	}

	@Override
	public List<Log> findInLog(Integer page) {
		Integer start = 0;
		Integer end = 10;
		page--;
		return logMapper.findInLog(start, end);
	}

	@Override
	public List<Log> findOutLog(Integer page) {
		Integer start = 0;
		Integer end = 10;
		page--;
		return logMapper.findOutLog(start, end);
	}

	@Override
	public List<Log> findChangeLog(Integer page) {
		Integer start = 0;
		Integer end = 10;
		page--;
		return logMapper.findChangeLog(start, end);
	}

	@Override
	public List<Log> findInLogWeek(Integer page) {
		Integer start = 0;
		Integer end = 10;
		page--;
		return logMapper.findInLogWeek(start, end);
	}

	@Override
	public List<Log> findOutLogWeek(Integer page) {
		Integer start = 0;
		Integer end = 10;
		page--;
		return logMapper.findOutLogWeek(start, end);
	}

	@Override
	public List<Log> findChangeLogWeek(Integer page) {
		Integer start = 0;
		Integer end = 10;
		page--;
		return logMapper.findChangeLogWeek(start, end);
	}

	@Override
	public List<Log> findInLogOpt(Integer page, Integer opId) {
		Integer start = 0;
		Integer end = 10;
		page--;
		return logMapper.findInLogOpt(start, end, opId);
	}

	@Override
	public List<Log> findOutLogOpt(Integer page, Integer opId) {
		Integer start = 0;
		Integer end = 10;
		page--;
		return logMapper.findOutLogOpt(start, end, opId);
	}

	@Override
	public List<Log> findChangeLogOpt(Integer page, Integer opId) {
		Integer start = 0;
		Integer end = 10;
		page--;
		return logMapper.findChangeLogOpt(start, end, opId);
	}

	@Override
	public List<Log> findInLogWeekOpt(Integer page, Integer opId) {
		Integer start = 0;
		Integer end = 10;
		page--;
		return logMapper.findInLogOpt(start, end, opId);
	}

	@Override
	public List<Log> findOutLogWeekOpt(Integer page, Integer opId) {
		Integer start = 0;
		Integer end = 10;
		page--;
		return logMapper.findOutLogOpt(start, end, opId);
	}

	@Override
	public List<Log> findChangeLogWeekOpt(Integer page, Integer opId) {
		Integer start = 0;
		Integer end = 10;
		page--;
		return logMapper.findChangeLogOpt(start, end, opId);
	}

	@Override
	public List<Log> findLogWeekOpt(Integer page, Integer opId) {
		List<Log> list=new ArrayList<>();
		Integer start = 0;
		Integer end = 10;
		page--;
		list.addAll(logMapper.findInLogWeekOpt(start,end,opId));
		list.addAll(logMapper.findOutLogWeekOpt(start,end,opId));
		list.addAll(logMapper.findChangeLogWeekOpt(start,end,opId));
		return list;
	}

	@Override
	public List<Log> findLogWeek(Integer page) {
		List<Log> list=new ArrayList<>();
		Integer start = 0;
		Integer end = 10;
		page--;
		list.addAll(logMapper.findInLogWeek(start,end));
		list.addAll(logMapper.findOutLogWeek(start,end));
		list.addAll(logMapper.findChangeLogWeek(start,end));
		return list;
	}

	@Override
	public List<Log> findLog(Integer page) {
		List<Log> list=new ArrayList<>();
		Integer start = 0;
		Integer end = 10;
		page--;
		list.addAll(logMapper.findInLog(start,end));
		list.addAll(logMapper.findOutLog(start,end));
		list.addAll(logMapper.findChangeLog(start,end));
		return list;
	}
	
	

}
