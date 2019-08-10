package cn.itcast.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login.action")
	public String login(String username,String password,HttpSession session) throws Exception{
		
		session.setAttribute("username", username);
		
		return "redirect:/queryItems.action";
		//return "redirect:items/queryItems.action";
	}

	@RequestMapping("/logout.action")
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/queryItems.action";
	}
	
}
