package it.objectmethod.srlgroupjob.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import it.objectmethod.srlgroupjob.controller.bean.UtenteBean;
import it.objectmethod.srlgroupjob.service.UtenteService;

@Controller
public class MenuController {

	@Autowired
	UtenteService serviceCliente;
	
	@GetMapping("/menu")
	public String menu(ModelMap model,HttpSession ses) {
		
		UtenteBean utenteBean = (UtenteBean) ses.getAttribute("agenteBean");
		
		model.addAttribute(utenteBean);
		
		return "MenuPage";
	}
	
	@GetMapping("/logout")
	public String logOut(HttpSession ses) {
		
		ses.setAttribute("agenteBean",null);
		
		return "forward:/login";
	}
	
	
}
