<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form action="/ssh4/login" method="get">
		<input type="text" name="username" />
		<input type="text" name="password" />
		<input type="submit" value="submit"/>
	</form>
	<form action="/ssh4/loginpost" method="post">
		<input type="text" name="username" />
		<input type="text" name="password" />
		<input type="submit" value="submit"/>
	</form>
	<form action="/ssh4/logindelete" method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="text" name="username" />
		<input type="text" name="password" />
		<input type="submit" value="delete"/>
	</form>
	<form action="/ssh4/loginput" method="post">
		<input type="hidden" name="_method" value="put" />
		<input type="text" name="username" />
		<input type="text" name="password" />
		<input type="submit" value="put"/>
	</form>
</body>
</html>