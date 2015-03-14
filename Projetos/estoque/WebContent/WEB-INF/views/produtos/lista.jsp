<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title> Lista de produtos </title>
	</head>
	<body>
		<c:forEach items="${produtoList}" var="produto">
			${produto.descricao} - ${produto.quantidade} <br/>
		</c:forEach>
	</body>
</html>