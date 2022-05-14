<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${not empty mensagem_sucesso}">

	<div class="alert alert-success alert-dismissible fade show"
		role="alert">
		<strong>${mensagem_sucesso}</strong>
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close"></button>
	</div>

</c:if>

<c:if test="${not empty mensagem_alerta}">

	<div class="alert alert-warning alert-dismissible fade show"
		role="alert">
		<strong>${mensagem_alerta}</strong>
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close"></button>
	</div>

</c:if>

<c:if test="${not empty mensagem_erro}">

	<div class="alert alert-danger alert-dismissible fade show"
		role="alert">
		<strong>${mensagem_erro}</strong>
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close"></button>
	</div>

</c:if>



