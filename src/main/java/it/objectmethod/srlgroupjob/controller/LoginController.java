package it.objectmethod.srlgroupjob.controller;

import org.springframework.http.MediaType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import it.objectmethod.srlgroupjob.controller.bean.UtenteBean;
import it.objectmethod.srlgroupjob.model.ErrorLogin;
import it.objectmethod.srlgroupjob.controller.bean.LoginError;
import it.objectmethod.srlgroupjob.service.UtenteService;

@Controller
public class LoginController {

	@Autowired
	UtenteService serviceCliente;

	@GetMapping("/login")
	public String login(HttpSession ses, @RequestParam(name = "username", required = false) String username,
			@RequestParam(name = "password", required = false) String password, ModelMap model) {

		UtenteBean utenteBean = (UtenteBean) ses.getAttribute("agenteBean");

		if (utenteBean == null) {
			if (username != null || password != null) {
				System.out.println(password.equals("") == false);

				if (username.equals("") == false || password.equals("") == false) {

					utenteBean = serviceCliente.CheckUsernameAndPasswordThenGetAgenteBean(username, password);

					if (utenteBean.equals(null) && username.equals("") == true || password.equals("") == true) {

						System.out.println("errore agentebean non trovati nel data e param vuoti");

						return "LoginPage";
					}

					else if (utenteBean.equals(null)) {

						System.out.println("errore agentebean non trovati nel data");

						return "LoginPage";
					}

					else {

						ses.setAttribute("agenteBean", utenteBean);

						return "forward:/menu";

					}

				} else {

					System.out.println("errore dei parametri vuoti");
					return "LoginPage";
				}
			} else {
				System.out.println("errore dei parametri nulli");

				return "LoginPage";
			}

		} else {

			return "forward:/menu";
		}
	}

}
