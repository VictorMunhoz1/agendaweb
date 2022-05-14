package br.com.cotiinformatica.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TarefasEdicaoModel {

	private Integer idTarefa;
	private String nome;
	private String descricao;
	private String data;
	private String hora;
	private String prioridade;
}
