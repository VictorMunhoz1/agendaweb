package br.com.cotiinformatica.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Usuario {

	private Integer idUsuario;
	private String nome;
	private String email;
	private String senha;

	// Associação (TER-MUITOS)
	private List<Tarefa> tarefas;
}
