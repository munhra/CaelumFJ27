<html>
	<head>
		<title> Alterar Produto </title>
	</head>
	<body>
		<form action="/estoque/produtos/alterar" method="post">
			<input type="hidden" name="id" value="${produto.id}"/><br/>
			Descricao: <input type="text" name="descricao" value="${produto.descricao}"><br/>
			Quantidade: <input type="text" name="quantidade" value="${produto.quantidade}"><br/>
			<input type="submit" value="Alterar"/>
		</form>
	</body>
</html>