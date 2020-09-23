package com.hjk532.spring.control;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hjk532.spring.module.Log;
import com.hjk532.spring.module.UsersVo;
import com.hjk532.spring.service.LogService;

@Controller
@RequestMapping("/Log")
public class LogControl {
	
	@Autowired LogService logService;
	
	@RequestMapping("/showLog")
	public String showLog(String logId,Date generateTime,Integer opId,String cargoList,UsersVo user,Integer logStatus,Model model){
		Log log =new Log();
		log.setLogId(logId);
		log.setCargoList(cargoList);
		log.setGenerateTime(generateTime);
		log.setLogStatus(logStatus);
		log.setOpId(opId);
		model.addAttribute("log",log);
		model.addAttribute("user",user);
		return "/WEB-INF/inner/log/showlog.jsp";
	}
	
	/**
	 * .按id查询日志
	 * @param logId 日志编号信息
	 * @return 操作是否成功
	 */
	@RequestMapping("/findByLogId")
	public String findByLogId(Model model,Integer logId,UsersVo user) throws Exception{
		Log log=logService.findByLogId(logId);
		model.addAttribute("log",log);
		model.addAttribute("user",user);
		return "/WEB-INF/inner/log/loglist.jsp";
	}
	/**
	 * .按日期查询日志
	 * @param oid 日志编号信息
	 * @return 操作是否成功
	 */
	@RequestMapping("/findByDate")
	public String findByDate(Model model,Date date,UsersVo user) throws Exception{
		List<Log> logs=logService.findByDate(date);
		model.addAttribute("logs",logs);
		model.addAttribute("user",user);
		return "/WEB-INF/inner/log/loglist.jsp";
	}
	
	/**
	 * .按日志操作员编号查询日志
	 * @param oinfo 日志名信息
	 * @return 操作是否成功
	 */
	@RequestMapping("/findByOpid")
	public String findByOpid(Model model,Integer OpId,UsersVo user) throws Exception{
		List<Log> logs=logService.findByOpid(OpId);
		model.addAttribute("logs",logs);
		model.addAttribute("user",user);
		return "/WEB-INF/inner/log/loglist.jsp";
	}
	
	/**
	 * .分页显示所有日志
	 * @param start 起始行
	 * @param end 结束行(不包含)
	 * @return 操作是否成功
	 */
	@RequestMapping("/findLog")
	public String findLog(Model model,Integer page,UsersVo user) throws Exception{
		List<Log> logs=logService.findLog(page);
		model.addAttribute("logs",logs);
		model.addAttribute("user",user);
		return "/WEB-INF/inner/log/loglist.jsp";
	}
}
