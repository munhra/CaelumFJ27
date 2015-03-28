<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<title>Cadastro de produtos</title>
	</head>
	<body>
		<form action="/estoque/produtos/salvar" method="post">
			Descricao : <input type="text" name="descricao"/>
			<form:errors path="produto.descricao"/>
			<br/>
			Quantidade : <input type="text" name="quantidade"/><br/>
			<input type="submit" value="Cadastrar"/>
			<form:errors path="produto.quantidade"/>
			<br/>
		</form>
	</body>
</html>