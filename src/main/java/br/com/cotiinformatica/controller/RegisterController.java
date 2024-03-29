package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.models.RegisterModel;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class RegisterController {

	// m�todo para abrir a p�gina
	@RequestMapping(value = "/register")
	public ModelAndView register() {

		ModelAndView modelAndView = new ModelAndView("register");

		// criando uma instancia da classe model e envia-la para a p�gina
		modelAndView.addObject("model", new RegisterModel());

		return modelAndView;
	}

	// m�todo para receber o SUBMIT do formul�rio
	@RequestMapping(value = "/register-user", method = RequestMethod.POST)
	public ModelAndView registerUser(RegisterModel model) {

		ModelAndView modelAndView = new ModelAndView("register");

		try {

			UsuarioRepository usuarioRepository = new UsuarioRepository();

			// verificar se j� existe um usu�rio cadastrado com o email informado
			if (usuarioRepository.find(model.getEmail()) != null) {
				modelAndView.addObject("mensagem_erro", "O email informado j� est� cadastrado para outro usu�rio.");
			} else {

				Usuario usuario = new Usuario();

				usuario.setNome(model.getNome());
				usuario.setEmail(model.getEmail());
				usuario.setSenha(model.getSenha());

				usuarioRepository.create(usuario);

				modelAndView.addObject("mensagem_sucesso", "Usu�rio cadastrado com sucesso.");
			}
		} catch (Exception e) {
			// mensagem de erro..
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		modelAndView.addObject("model", new RegisterModel());
		return modelAndView;
	}
}
