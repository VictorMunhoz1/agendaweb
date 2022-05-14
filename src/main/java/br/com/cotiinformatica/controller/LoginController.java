package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.models.LoginModel;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class LoginController {

	// método para mapear a navegação da página de login
	@RequestMapping(value = "/") // página raiz do projeto
	public ModelAndView login() {

		ModelAndView modelAndView = new ModelAndView("login"); // WEB-INF/views/login.jsp

		modelAndView.addObject("model", new LoginModel());
		return modelAndView;
	}

	// método para receber o SUBMIT POST do formulário
	@RequestMapping(value = "/login-user", method = RequestMethod.POST) // ação do formulário
	public ModelAndView loginUser(LoginModel model, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("login"); // WEB-INF/views/login.jsp

		try {

			// consultar o usuário no banco de dados através do email e senha
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			Usuario usuario = usuarioRepository.find(model.getEmail(), model.getSenha());

			if (usuario != null) { // usuário foi encontrado!

				// salvar os dados do usuário em uma sessão
				request.getSession().setAttribute("usuario_auth", usuario);

				// redirecionamento..
				modelAndView.setViewName("redirect:tarefas-consulta");
			} else { // usuário não foi encontrado!
				modelAndView.addObject("mensagem_erro", "Acesso negado, email ou senha inválidos.");
			}
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", "Ocorreu um erro: " + e.getMessage());
		}

		modelAndView.addObject("model", new LoginModel());
		return modelAndView;
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {

		// destruir a sessão
		request.getSession().removeAttribute("usuario_auth");

		// redirecionar para o raiz do projeto (página de login)
		ModelAndView modelAndView = new ModelAndView("redirect:/");

		return modelAndView;
	}

}
