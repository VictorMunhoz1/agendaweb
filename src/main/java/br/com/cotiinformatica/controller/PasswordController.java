package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.models.PasswordModel;

@Controller
public class PasswordController {

	@RequestMapping(value = "/password")
	public ModelAndView password() {

		ModelAndView modelAndView = new ModelAndView("password");
		modelAndView.addObject("model", new PasswordModel());

		return modelAndView;
	}

	@RequestMapping(value = "/recuperar-senha", method = RequestMethod.POST)
	public ModelAndView recuperarSenha(PasswordModel model) {

		ModelAndView modelAndView = new ModelAndView("password");
		modelAndView.addObject("model", model);

		return modelAndView;
	}

}
