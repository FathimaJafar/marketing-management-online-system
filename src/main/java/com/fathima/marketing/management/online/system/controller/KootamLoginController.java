package com.fathima.marketing.management.online.system.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fathima.marketing.management.online.system.model.LoginUser;
import com.fathima.marketing.management.online.system.service.LoginUserService;

@Controller
public class KootamLoginController {
	
	@Autowired
	private LoginUserService loginUserService;
	
	@GetMapping("/kootam")
	public String login(Model model) {
		LoginUser loginUser = new LoginUser();
		model.addAttribute("loginUser", loginUser);
		
		return "kootamFathima";
	}
	
	@GetMapping("/logOut")
	public String logOut(Model model) {
		LoginUser loginUser = new LoginUser();
		model.addAttribute("loginUser", loginUser);
		
		return "kootamFathima";
	}
	 @GetMapping("/kootam/{luId}")
		public String kootamById(HttpSession session,@PathVariable ( value = "luId") int luId, Model model) {
			// create model attribute to bind form data
			
		 LoginUser loginUserIn=loginUserService.getLoginUserById(luId);
			
			session.setAttribute("luUserType", loginUserIn.getLuUserType());
			session.setAttribute("luId", loginUserIn.getLuId());
			model.addAttribute("loginUser", loginUserIn);
				return "home";
		}
	
	@PostMapping("/login/home")
	public String home(HttpSession session,@ModelAttribute("loginUser") LoginUser loginUser,Model model) {
		// save LoginUser to database

		//LoginUser loginUserIn=loginUserService.getLoginUserByPhone(loginUser.getLuPhone(), loginUser.getLuPassword());
		LoginUser loginUserIn=loginUserService.getLoginUserById(loginUser.getLuId(), loginUser.getLuPassword());
		
		session.setAttribute("luUserType", loginUserIn.getLuUserType());
		session.setAttribute("luId", loginUserIn.getLuId());
		model.addAttribute("loginUser", loginUserIn);
			return "home";
		
	}
	
	
	
	
	

}
