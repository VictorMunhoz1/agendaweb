package br.com.cotiinformatica.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.models.TarefasConsultaModel;
import br.com.cotiinformatica.repositories.TarefaRepository;

@Controller
public class TarefasConsultaController {

	@RequestMapping(value = "/tarefas-consulta")
	public ModelAndView consulta() {

		// nome da página /WEB-INF/views/tarefas-consulta.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas-consulta");

		modelAndView.addObject("model", new TarefasConsultaModel());
		return modelAndView;
	}

	@RequestMapping(value = "/consultar-tarefas", method = RequestMethod.POST)
	public ModelAndView consultarTarefas(TarefasConsultaModel model, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("tarefas-consulta");

		try {

			// capturar o usuário autenticado no sistema
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_auth");

			// executar a consulta de tarefas
			TarefaRepository tarefaRepository = new TarefaRepository();
			List<Tarefa> tarefas = tarefaRepository.findAll(model.getNome(), usuario.getIdUsuario());

			// enviando a lista de tarefas para a página
			modelAndView.addObject("tarefas", tarefas);

			// enviando mensagens
			if (tarefas.size() > 0)
				modelAndView.addObject("mensagem_sucesso",
						tarefas.size() + " tarefa(s) obtida(s) para a consulta realizada.");
			else
				modelAndView.addObject("mensagem_alerta", "Nenhum resultado foi encontrado para a pesquisa realizada.");
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		modelAndView.addObject("model", new TarefasConsultaModel());
		return modelAndView;
	}

	@RequestMapping(value = "/excluirtarefa")
	public ModelAndView excluirTarefa(Integer idTarefa, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("tarefas-consulta");

		try {

			// capturar o usuário autenticado
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_auth");

			Tarefa tarefa = new Tarefa();
			tarefa.setIdTarefa(idTarefa);
			tarefa.setIdUsuario(usuario.getIdUsuario());

			// excluindo a tarefa do usuário
			TarefaRepository tarefaRepository = new TarefaRepository();
			tarefaRepository.delete(tarefa);

			modelAndView.addObject("mensagem_sucesso", "Tarefa excluída com sucesso.");
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		modelAndView.addObject("model", new TarefasConsultaModel());
		return modelAndView;
	}
}
