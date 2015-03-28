<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<title>Detalhes do produto</title>
	</head>
	<body>
		id: <input value="${produto.id}" disabled="disabled" /><br>
		descricao: <input value="${produto.descricao}" disabled="disabled" /><br>
		quantidade: <input value="${produto.quantidade}" disabled="disabled" /><br>
	
		<h2> Lista de movimentações</h2>
		<ul>
			<c:forEach items="${produto.movimentacoes}" var="m">
				<li>
					${m.tipo} - ${m.quantidade} -
					<fmt:formatDate value="${m.data.time}" pattern="dd/MM/yyyy - hh:mm" />
				</li>
			</c:forEach>
		
		</ul>
	
	
	</body>

</html>