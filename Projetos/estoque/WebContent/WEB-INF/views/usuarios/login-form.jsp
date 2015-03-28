<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
	<head>
		<title>Login</title>
	</head>
	<body>
		<sec:authorize access="hasRole('ROLE_USER')">
			Voce ja logou
		</sec:authorize>
		<sec:authorize access="isAnonymous()">
			<form action="/estoque/login" method="post">
				Login: <input type="text" name="j_username"/><br/>
				Senha: <input type="password" name="j_password" /><br/>
				<input type="submit" value="Login">
			</form>
		</sec:authorize>
	</body>
</html>