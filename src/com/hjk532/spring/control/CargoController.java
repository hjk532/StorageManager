package com.hjk532.spring.control;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hjk532.spring.exception.CustomException;
import com.hjk532.spring.module.CargoVo;
import com.hjk532.spring.module.TypeVo;
import com.hjk532.spring.module.UsersVo;
import com.hjk532.spring.service.CargoService;
import com.hjk532.spring.service.TypeService;
import com.hjk532.spring.service.UsersService;

@Controller
@RequestMapping("/Cargo")
public class CargoController {

	@Autowired
	CargoService cargoService;
	@Autowired
	UsersService usersService;
	@Autowired
	TypeService typeService;

	@RequestMapping("/newCargo")
	public String newCargo(Model model, UsersVo user) throws Exception {
		String account = user.getUserAccount();
		UsersVo users = usersService.findByAccount(account);
		List<TypeVo> types = typeService.findAllType();
		model.addAttribute("user", users);
		model.addAttribute("types", types);
		return "/WEB-INF/inner/cargo/newCargo.jsp";
	}

	@RequestMapping("/addCargo")
	public String addCargo(Model model, CargoVo cargo, @RequestParam(value = "oNum") Integer oNum,
			@RequestParam(value = "tNum") Integer tNum,UsersVo user) throws Exception {
		cargo.setoNum(oNum);
		cargo.settNum(tNum);
		boolean result = cargoService.addCargo(cargo, cargo.getoNum());
		if (result) {
			model.addAttribute("user",user);
			return "/WEB-INF/inner/cargo/cargolist.jsp";
		} else {
			throw new CustomException("添加失败，数据异常");
		}
	}
	
	@RequestMapping("/dooutCargo")
	public String dooutCargo(Model model, Integer opId,UsersVo user) throws Exception {
		List<CargoVo> cargos= cargoService.findCargo(1);
		model.addAttribute("opId",opId);
		model.addAttribute("cargos",cargos);
		model.addAttribute("user",user);
		return "/WEB-INF/inner/cargo/outCargo.jsp";
	}
	
	@RequestMapping("/outCargo")
	public String outCargo(CargoVo cargo, Model model, Integer opId,Integer account,Integer page,Date lastOptime,UsersVo user) throws Exception {
		cargo.setLastOpttime(lastOptime);
		boolean result = cargoService.outCargo(cargo,account);
		if (result) {
			model.addAttribute("user",user);
			List<CargoVo> cargos=cargoService.findCargo(page);
			model.addAttribute("cargos",cargos);
			model.addAttribute("opId",opId);
			return "/WEB-INF/inner/cargo/outCargo.jsp";
		} else {
			throw new CustomException("出库失败，未查到该条信息，请检查您提交的数据");
		}
	}
	
	
	@RequestMapping("/changeCargo")
	public String changeCargo(Integer opId, Model model, Integer page, UsersVo users) throws Exception {
		List<CargoVo> cargos = cargoService.findCargo(page);
		model.addAttribute("cargos", cargos);
		model.addAttribute("opId", opId);
		model.addAttribute("user", users);
		return "/WEB-INF/inner/cargo/changeCargo.jsp";
	}

	@RequestMapping("/updateCargo")
	public String updateCargo(CargoVo cargos, Integer opId, Model model,UsersVo userAccount,Integer page) throws Exception {
		boolean result = cargoService.updateCargo(cargos, opId);
		if (result) {
			List<CargoVo> list = cargoService.findCargo(page);
			model.addAttribute("cargos", list);
			model.addAttribute("opId", opId);
			model.addAttribute("Account", userAccount);
			model.addAttribute("user", userAccount);
			return "/WEB-INF/inner/cargo/changeCargo.jsp";
		} else {
			throw new CustomException("更新失败，未查到该条信息，请检查您提交的数据");
		}

	}

	@RequestMapping("/showCargo")
	public String queryCargo(CargoVo cargo,Integer page, Model model,UsersVo user) throws Exception {
		List<CargoVo> cargos = cargoService.findCargos(cargo,page);
		model.addAttribute("cargos",cargos);
		model.addAttribute("user",user);
		model.addAttribute("page",page);
		return "/WEB-INF/inner/cargo/cargolist.jsp";
	}
	
}
