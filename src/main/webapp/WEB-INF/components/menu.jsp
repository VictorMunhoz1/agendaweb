<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">AgendaWeb</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="/agendaweb/tarefas-consulta"> Consultar Tarefas </a></li>
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="/agendaweb/tarefas-cadastro"> Cadastrar Tarefa </a></li>
			</ul>
		</div>
	</div>
</nav>

<div style="border-bottom: 1px solid #eee; background-color: #fafafa;">
	<div class="container">
		<div class="row mb-2">
			<div class="col-md-12 text-end">
				<div class="mt-2">
					Usuário: <span style="font-weight: 500;">${usuario_auth.nome}</span>,
					email: ${usuario_auth.email} &nbsp;&nbsp; <a
						href="/agendaweb/logout" class="btn btn-outline-secondary btn-sm"
						onclick="return confirm('Deseja realmente sair do sistema?');">
						Sair da Agenda </a>
				</div>
			</div>
		</div>
	</div>
</div>







