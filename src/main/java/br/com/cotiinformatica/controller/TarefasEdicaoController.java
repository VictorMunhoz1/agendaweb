package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.helpers.DateHelper;
import br.com.cotiinformatica.models.TarefasEdicaoModel;
import br.com.cotiinformatica.repositories.TarefaRepository;

@Controller
public class TarefasEdicaoController {

	@RequestMapping(value = "/tarefas-edicao")
	public ModelAndView edicao(Integer id, HttpServletRequest request) {

		TarefasEdicaoModel model = new TarefasEdicaoModel();

		// nome da página /WEB-INF/views/tarefas-edicao.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas-edicao");

		try {

			// capturando o usuário autenticado na aplicação
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_auth");

			// consultando os dados da tarefa no banco através do id
			TarefaRepository tarefaRepository = new TarefaRepository();
			Tarefa tarefa = tarefaRepository.findById(id);

			// verificando se a tarefa obtida pertence ao usuário
			if (tarefa.getIdUsuario() == usuario.getIdUsuario()) {

				model.setIdTarefa(tarefa.getIdTarefa());
				model.setNome(tarefa.getNome());
				model.setData(DateHelper.formatToString(tarefa.getData()));
				model.setHora(tarefa.getHora());
				model.setDescricao(tarefa.getDescricao());
				model.setPrioridade(tarefa.getPrioridade().toString());
			} else {
				modelAndView = new ModelAndView("redirect:/tarefas-consulta");
			}
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		modelAndView.addObject("model", model);
		return modelAndView;
	}

	@RequestMapping(value = "/atualizar-tarefa", method = RequestMethod.POST)
	public ModelAndView atualizarTarefa(TarefasEdicaoModel model, HttpServletRequest request) {

		// nome da página /WEB-INF/views/tarefas-edicao.jsp
		ModelAndView modelAndView = new ModelAndView("tarefas-edicao");

		// capturando o usuário autenticado na aplicação
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario_auth");

		try {

			// capturar os dados da tarefa
			Tarefa tarefa = new Tarefa();

			tarefa.setIdTarefa(model.getIdTarefa());
			tarefa.setNome(model.getNome());
			tarefa.setData(DateHelper.formatToDate(model.getData()));
			tarefa.setHora(model.getHora());
			tarefa.setDescricao(model.getDescricao());
			tarefa.setPrioridade(Integer.parseInt(model.getPrioridade()));
			tarefa.setIdUsuario(usuario.getIdUsuario());

			// atualizando no banco de dados
			TarefaRepository tarefaRepository = new TarefaRepository();
			tarefaRepository.update(tarefa);

			modelAndView.addObject("mensagem_sucesso", "Tarefa atualizada com sucesso.");
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		modelAndView.addObject("model", model);
		return modelAndView;
	}

}
