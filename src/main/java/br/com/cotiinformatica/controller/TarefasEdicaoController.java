package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TarefasEdicaoController {

	@RequestMapping(value = "/tarefas-edicao")
	public ModelAndView edicao() {

		// nome da página /WEB-INF/views/tarefas-edicao.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas-edicao");
		return modelAndView;
	}
}
