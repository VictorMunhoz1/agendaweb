<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>COTI Informática</title>

<!-- folhas de estilo CSS -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />

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

					<form>

						<div class="mb-3">
							<label>Email de acesso:</label> <input type="text"
								class="form-control" placeholder="Digite seu email aqui" />
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

				</div>
			</div>

		</div>
	</div>

	<!-- arquivos de extensão javascript -->
	<script src="resources/js/bootstrap.min.js"></script>

</body>
</html>


