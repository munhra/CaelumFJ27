<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title> Lista de produtos </title>
	</head>
	<body>
		<c:forEach items="${produtoList}" var="produto">
			${produto.descricao} - ${produto.quantidade} - 
			<a href="/estoque/produtos/mostrar/${produto.id}">detalhes</a><br/>
			- <a href="/estoque/produtos/editar?id=${produto.id}">editar</a><br/>
		</c:forEach>
	</body>
</html>