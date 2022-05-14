<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de tarefas</title>

<!-- folhas de estilo CSS -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />

<!-- estilos para o jquery validation -->
<style>
label.error {
	color: red;
}

input.error, select.error, textarea.error {
	border: 2px solid red;
}
</style>

</head>
<body>

	<!-- menu do sistema -->
	<jsp:include page="/WEB-INF/components/menu.jsp"></jsp:include>

	<!-- mensagens do sistema -->
	<jsp:include page="/WEB-INF/components/mensagens.jsp"></jsp:include>

	<div class="container mt-3">

		<h5>Cadastro de tarefas</h5>
		<p>Preencha o formulário abaixo para cadastrar uma tarefa.</p>
		<hr />

		<form id="formCadastro" action="cadastrar-tarefa" method="post">

			<div class="row mb-3">
				<div class="col-md-6">
					<label>Nome da tarefa:</label>
					<form:input path="model.nome" type="text" id="nome" name="nome"
						class="form-control" placeholder="Digite aqui" />
				</div>
				<div class="col-md-2">
					<label>Data da tarefa:</label>
					<form:input path="model.data" type="date" id="data" name="data"
						class="form-control" />
				</div>
				<div class="col-md-2">
					<label>Hora da tarefa:</label>
					<form:input path="model.hora" type="time" id="hora" name="hora"
						class="form-control" />
				</div>
				<div class="col-md-2">
					<label>Prioridade:</label>
					<form:select path="model.prioridade" id="prioridade"
						name="prioridade" class="form-select">
						<option value="">Selecione</option>
						<option value="1">ALTA</option>
						<option value="2">MÉDIA</option>
						<option value="3">BAIXA</option>
					</form:select>
				</div>
			</div>

			<div class="row mb-3">
				<div class="col-md-12">
					<label>Descrição da tarefa:</label>
					<form:textarea path="model.descricao" class="form-control"
						id="descricao" name="descricao" rows="4" placeholder="Digite aqui"></form:textarea>
				</div>
			</div>

			<div class="row mb-3">
				<div class="col-md-12">
					<input type="submit" value="Realizar Cadastro"
						class="btn btn-success" /> <input type="reset" value="Cancelar"
						class="btn btn-secondary" />
				</div>
			</div>

		</form>

	</div>

	<!-- arquivos de extensão javascript -->
	<script src="resources/js/bootstrap.min.js"></script>

	<!-- biblioteca do jquery -->
	<script src="resources/js/jquery-3.6.0.min.js"></script>

	<!-- biblioteca do jquery validation -->
	<script src="resources/js/jquery.validate.min.js"></script>
	<script src="resources/js/additional-methods.min.js"></script>
	<script src="resources/js/messages_pt_BR.min.js"></script>

	<script>
		//função para inicializar o código JavaScript (JQuery)
		$(document).ready(function() {

			$("#formCadastro").validate({
				rules : {
					'nome' : {
						required : true
					},
					'data' : {
						required : true
					},
					'hora' : {
						required : true
					},
					'prioridade' : {
						required : true
					},
					'descricao' : {
						required : true
					}
				}
			});
		});
	</script>

</body>
</html>


