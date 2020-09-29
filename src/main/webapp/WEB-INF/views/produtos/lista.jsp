<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Casa do Código</title>
<c:url value="/resources/css" var="cssPath" />
<link rel="stylesheet" href="${cssPath}/bootstrap.min.css" />
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css" />
<!--<style type="text/css">
        body{
            padding-top: 60px;
        }
    </style>-->
</head>
<body>

	<div>${sucesso }</div>
	<div>${falha }</div>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${s:mvcUrl('HC#index').build() }">Casa
					do Código</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="${s:mvcUrl('PC#listar').build()}">Lista de
							Produtos</a></li>
					<li><a href="${s:mvcUrl('PC#form').build()}">Cadastro de
							Produtos</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><security:authentication
								property="principal.username" /></a></li>
					<li><a href="logout">SaiR</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
	</nav>
	<div class="container">
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Título</th>
				<th>Descrição</th>
				<th>Páginas</th>
				<th>Preço EBOOK</th>
				<th>Preço Impresso</th>
				<th>Preço COMBO</th>
				<th>Foto Capa</th>
			</tr>

			<c:forEach items="${produtos}" var="produto">
				<tr>
					<td><a
						href="${s:mvcUrl('PC#detalhe').arg(0,produto.id).build() }">${produto.titulo}</a></td>
					<td>${produto.descricao}</td>
					<td>${produto.paginas}</td>
					<c:forEach items="${produto.precos}" var="preco">

						<td>${preco.valor }</td>

					</c:forEach>
					<td><img
						src="<c:url value="${contextPath}/${produto.sumarioPath }" />"
						width="50px" height="50px"></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	files
	<img src="<c:url value="files/01.jpg" />" width="50px" height="50px">
	<br> files2
	<img src="<c:url value="files/03.jpg" />" width="50px" height="50px">
	<br> files2
	<img src="<c:url value="files/01/01.jpg" />" width="50px" height="50px">
</body>
</html>