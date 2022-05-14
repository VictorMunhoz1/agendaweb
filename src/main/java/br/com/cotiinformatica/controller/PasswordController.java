package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PasswordController {

	@RequestMapping(value = "/password")
	public ModelAndView password() {

		ModelAndView modelAndView = new ModelAndView("password"); // WEB-INF/views/password.jsp
		return modelAndView;
	}

}
