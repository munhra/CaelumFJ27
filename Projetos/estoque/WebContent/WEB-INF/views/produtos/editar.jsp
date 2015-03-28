<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<title> Alterar Produto </title>
	</head>
	<body>
		<form action="/estoque/produtos/alterar" method="post">
			<input type="hidden" name="id" value="${produto.id}"/><br/>
			Descricao: <input type="text" name="descricao" value="${produto.descricao}">
			<form:errors path="produto.descricao"/>
			<br/>
			Quantidade: <input type="text" name="quantidade" value="${produto.quantidade}">
			<form:errors path="produto.quantidade"/>
			<br/>
			<input type="submit" value="Alterar"/>
		</form>
	</body>
</html>