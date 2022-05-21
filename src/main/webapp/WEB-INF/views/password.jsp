<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>COTI Informática</title>

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
<body class="bg-secondary">

	<div class="row mt-5">
		<div class="col-md-4 offset-md-4">

			<div class="card">
				<div class="card-body">

					<div class="text-center">
						<h3>Esqueci minha senha</h3>
						<p>Informe seu email para recuperação da senha.</p>
					</div>

					<hr />

					<form id="formRecuperarSenha" action="recuperar-senha"
						method="post">

						<div class="mb-3">
							<label>Email de acesso:</label>
							<form:input path="model.email" id="email" name="email"
								type="text" class="form-control"
								placeholder="Digite seu email aqui" />
						</div>

						<div class="mb-3">
							<div class="d-grid">
								<input type="submit" value="Recuperar Senha"
									class="btn btn-success" />
							</div>
						</div>

						<div class="mb-3">
							<div class="d-grid">
								<a href="/agendaweb/" class="btn btn-light"> Voltar para a
									página inicial. </a>
							</div>
						</div>

					</form>

					<div class="mt-3 text-success text-center">
						<strong>${mensagem_sucesso}</strong>
					</div>

					<div class="mt-3 text-danger text-center">
						<strong>${mensagem_erro}</strong>
					</div>

				</div>
			</div>

		</div>
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

			$("#formRecuperarSenha").validate({
				rules : {
					'email' : {
						required : true,
						email : true
					}
				}
			});
		});
	</script>

</body>
</html>


