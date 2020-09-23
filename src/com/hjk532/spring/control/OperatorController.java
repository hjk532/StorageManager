package com.hjk532.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hjk532.spring.module.OperatorJson;
import com.hjk532.spring.module.OperatorVo;
import com.hjk532.spring.module.UsersVo;
import com.hjk532.spring.service.OperatorService;

@Controller
@RequestMapping("/operator")
public class OperatorController {

	@Autowired
	OperatorService operatorService;

	@RequestMapping("/newoperator")
	public String newOperator(Model model, OperatorVo operator,UsersVo user) throws Exception{
		model.addAttribute(user);
		model.addAttribute(operator);
		return "/WEB-INF/inner/operator/newoperator.jsp";
	}
	@RequestMapping("/newo")
	public String newo(Model model, OperatorVo operator,UsersVo user) throws Exception{
		boolean result = operatorService.addOperator(operator);
		if (result) {
			return "";
		} else {
			return "";
		}
		
	}

	@RequestMapping("/deleteoperator")
	public String deleteOperator(Integer id, Model model,UsersVo user) throws Exception{
		model.addAttribute(user);
		return "/WEB-INF/inner/operator/deleteoperator.jsp";
	}
	@RequestMapping("/delete")
	public String delete(Integer id, Model model,UsersVo user) throws Exception{
		boolean result = operatorService.deleteOperator(id);
		if (result) {
			return "";
		} else {
			return "";
		}
	}

	@RequestMapping("/updateoperator")
	public String update(OperatorVo operator, Model model,UsersVo user) throws Exception{
		model.addAttribute(user);
		model.addAttribute(operator);
		return "/WEB-INF/inner/operator/changeoperator.jsp";
	}
	@RequestMapping("/update")
	public String updateOperator(OperatorVo operator, Model model,UsersVo user) throws Exception{
		boolean result = operatorService.updateOperator(operator);
		if (result) {
			return "";
		} else {
			return "";
		}
	}

	@RequestMapping("/querybynum")
	public String queryOperator(Integer num, Model model,UsersVo user) throws Exception{
		OperatorVo operator =(OperatorVo)operatorService.findByNum(num);
		model.addAttribute(operator);
		return "";
	}

	@RequestMapping("/querybyname")
	public String queryOperator(String name, Model model,UsersVo user) throws Exception{
		OperatorVo operator =(OperatorVo)operatorService.findByName(name);
		model.addAttribute(operator);
		return "";
	}

	@RequestMapping("/showOperator")
	public ModelAndView showOperator(Integer page,UsersVo user) throws Exception{

		ModelAndView model = new ModelAndView();
		List<OperatorVo> operators = operatorService.findOperator(page);
		model.addObject(operators);
		model.setViewName("");
		return model;

	}
	@RequestMapping("/getList")
	@ResponseBody
	public String getList(Integer page) throws Exception {
		List<OperatorVo> operators = operatorService.findOperator(page);
		String json = new OperatorJson("\"\"", operators, 0, operators.size()).toString();
		return json;
	}

}
