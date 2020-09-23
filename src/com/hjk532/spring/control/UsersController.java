package com.hjk532.spring.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hjk532.spring.module.UsersVo;
import com.hjk532.spring.module.Log;
import com.hjk532.spring.module.OperatorVo;
import com.hjk532.spring.module.UsersJson;
import com.hjk532.spring.service.LogService;
import com.hjk532.spring.service.OperatorService;
import com.hjk532.spring.service.UsersService;

@Controller
@RequestMapping("/Users")
public class UsersController {

	@Autowired UsersService usersService;
	@Autowired OperatorService operatorService;
	@Autowired LogService logService;
	
	@RequestMapping("/newUsers")
	public String newUsers(Model model,UsersVo users ) throws Exception{
		model.addAttribute(users);
		return "/WEB-INF/inner/users/newuser.jsp";
	}
	@RequestMapping("/newu")
	public String newu(Model model,UsersVo users ) throws Exception{
		boolean result=usersService.addUsers(users);
		if(result) {
			return "";
		}else {
			return "";
		}
	}
	
	@RequestMapping("/deleteUsers")
	public String deleteUsers(Integer id,Model model,UsersVo user) throws Exception{
		model.addAttribute(user);
		model.addAttribute(id);
		return "/WEB-INF/inner/users/deleteuser.jsp";
	}
	@RequestMapping("/delete")
	public String delete(Integer id,Model model,UsersVo user) throws Exception{
		boolean result=usersService.deleteUsers(id);
		if(result) {
			return "";
		}else {
			return "";
		}
	}
	
	@RequestMapping("/updateUsers")
	public String updateUsers(UsersVo users,OperatorVo operator,Model model) {
		model.addAttribute(operator);
		model.addAttribute(users);
		return "/WEB-INF/inner/users/changeuser.jsp";
	}
	@RequestMapping("/update")
	public String update(UsersVo users,OperatorVo operator,Model model) throws Exception{
		if(usersService.updateUsers(users) & operatorService.updateOperator(operator)) {
			model.addAttribute("operator",operator);
			model.addAttribute("user",users);
			return "/WEB-INF/inner/users/personalspace.jsp";
		}else {
			return "";
		}
	}
	
	@RequestMapping("/login")
	public String login(UsersVo user,Model model,HttpServletRequest request) throws Exception{
		String account=user.getUserAccount();
		String password = user.getUserPassword();
		if(user.getUserAccount()==null || user.getUserPassword()==null) {
			model.addAttribute("wrong","wrong");
			return "/WEB-INF/login.jsp"; 
		}
		UsersVo users= usersService.findByAccount(account);
		if(users.getUserPassword().equals(password)) {
			Integer oid=users.getOpId();
			Integer authority=users.getUserAuthority();
			model.addAttribute("user",users);
			Integer page=1;
			List<Log> weeklogs=logService.findLogWeekOpt(page,oid);
			List<Log> inlogs=logService.findInLogWeekOpt(page,oid);
			List<Log> outlogs=logService.findOutLogWeekOpt(page,oid);
			model.addAttribute("weeklogs",weeklogs);
			model.addAttribute("inlogs",inlogs);
			model.addAttribute("outlogs",outlogs);
			request.getSession().setAttribute("userAccount", account);
			if(authority!=0) {
				return "/WEB-INF/primindex.jsp";
			}else {
				return "/WEB-INF/adminindex.jsp";
			}
		}else {
			model.addAttribute("wrong","wrong");
			return "/WEB-INF/login.jsp"; 
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session,Model model,UsersVo user) {
		session.invalidate();
		return "/WEB-INF/login.jsp";
	}
	
	@RequestMapping("/findUsers")
	public String findUsers(String account,Model model,UsersVo user) throws Exception{
		UsersVo users=usersService.findByAccount(account);
		OperatorVo operator=(OperatorVo)operatorService.findByNum(users.getOpId());
		model.addAttribute("user",users);
		model.addAttribute("operator",operator);
		return "/WEB-INF/inner/users/personalspace.jsp";
	}
	
	@RequestMapping("/showUsers")
	public ModelAndView showUsers(Integer page,UsersVo user) throws Exception{
		
		ModelAndView model=new ModelAndView();
		List<UsersVo> users=usersService.findUsers(page);
		model.addObject(users);
		model.setViewName("");
		return model;

	}
	@RequestMapping("/getList")
	@ResponseBody
	public String getList(Integer page) throws Exception {
		List<UsersVo> users = usersService.findUsers(page);
		String json = new UsersJson("\"\"", users, 0, users.size()).toString();
		return json;
	}
	
}
