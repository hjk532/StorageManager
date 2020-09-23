package com.hjk532.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjk532.spring.module.TypeVo;
import com.hjk532.spring.module.UsersVo;
import com.hjk532.spring.module.TypeJson;
import com.hjk532.spring.service.TypeService;

@Controller
@RequestMapping("/Type")
public class TypeController {

	@Autowired
	TypeService typeService;

	@RequestMapping("/newType")
	public String newType(Model model,UsersVo user) throws Exception {
		model.addAttribute(user);
		return "/WEB-INF/inner/type/newtype.jsp";
	}
	@RequestMapping("/new")
	public String addType(Model model, TypeVo type,UsersVo user) throws Exception {
		boolean result = typeService.addType(type);
		if (result) {
			return "";
		} else {
			return "";
		}
		
	}

	@RequestMapping("/deleteType")
	public String deleteType(Model model,UsersVo user) throws Exception {
		model.addAttribute(user);
		return "/WEB-INF/inner/type/deletetype.jsp";
	}
	@RequestMapping("/delete")
	public String delete(Integer id, Model model,UsersVo user) throws Exception {
		boolean result = typeService.deleteType(id);
		if (result) {
			return "";
		} else {
			return "";
		}
	}

	@RequestMapping("/changeType")
	public String updateType(Model model,UsersVo user) throws Exception {
		model.addAttribute(user);
		return "/WEB-INF/inner/type/changetype.jsp";
	}
	@RequestMapping("/change")
	public String update(TypeVo type, Model model,UsersVo user) throws Exception {
		boolean result = typeService.updateType(type);
		if (result) {
			return "";
		} else {
			return "";
		}
	}

	@RequestMapping("/querybynum")
	public String queryType(Integer num, Model model,UsersVo user) throws Exception {
		TypeVo type = (TypeVo) typeService.findByNum(num);
		model.addAttribute(type);
		return "";
	}

	@RequestMapping("/querybyname")
	public String queryType(String name, Model model,UsersVo user) throws Exception {
		TypeVo type = (TypeVo) typeService.findByName(name);
		model.addAttribute(type);
		return "";
	}

	@RequestMapping("/showType")
	public String showCargo(Model model, UsersVo user) throws Exception {
		model.addAttribute("user", user);
		return "/WEB-INF/inner/type/typelist.jsp";
	}

	@RequestMapping("/getList")
	@ResponseBody
	public String getList(Integer page) throws Exception {
		List<TypeVo> types = typeService.findType(page);
		String json = new TypeJson("\"\"", types, 0, types.size()).toString();
		return json;
	}
}
