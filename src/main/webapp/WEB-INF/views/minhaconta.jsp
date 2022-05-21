<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Minha Conta</title>

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

		<h5>Minha Conta</h5>
		<p>Dados do usuário autenticado na aplicação.</p>
		<hr />

		<form id="formEdicao" action="atualizar-senha" method="post">

			<div class="mb-3">
				<div>
					Usuário Autenticado: <strong>${usuario_auth.nome}</strong>
				</div>
				<div>
					Email: <strong>${usuario_auth.email}</strong>
				</div>
			</div>

			<div class="row mb-3">
				<div class="col-md-3">
					<label>Nova Senha:</label>
					<form:input path="model.senha" type="password" id="senha"
						name="senha" class="form-control" placeholder="Digite aqui" />
				</div>
				<div class="col-md-3">
					<label>Confirme a Senha:</label>
					<form:input path="model.senhaConfirmacao" type="password"
						id="senhaConfirmacao" name="senhaConfirmacao" class="form-control"
						placeholder="Digite aqui" />
				</div>
			</div>

			<div class="row mb-3">
				<div class="col-md-12">
					<input type="submit" value="Salvar Nova Senha"
						class="btn btn-primary" /> <input type="reset" value="Cancelar"
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

			$("#formEdicao").validate({
				rules : {
					'senha' : {
						required : true,
						minlength : 8,
						maxlength : 20
					},
					'senhaConfirmacao' : {
						required : true,
						equalTo : '#senha'
					}
				}
			});
		});
	</script>

</body>
</html>


