package com.hjk532.spring.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Plant")
public class PlantController {
	//区别移动端访问和电脑端访问
	@RequestMapping("/sendWeb")
	public String sendWeb(Model model,Integer status) throws Exception{
		if(status==0) {
			return "/WEB-INF/signIn.jsp";
		}else {
			return "/WEB-INF/notice.jsp";
		}
	}
}
