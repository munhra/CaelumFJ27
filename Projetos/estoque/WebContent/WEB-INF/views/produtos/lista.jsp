<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title> Lista de produtos </title>
	</head>
	<body>
		<c:forEach items="${produtoList}" var="produto">
			${produto.descricao} - ${produto.quantidade} - 
			<a href="/estoque/produtos/mostrar/${produto.id}">detalhes</a><br/>
		</c:forEach>
	</body>
</html>