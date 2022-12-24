<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function myFunction() {
		
		var username = document.getElementById("uname").value;
		var pass = document.getElementById("pwd").value;

		if (username == "") {
			alert("Please enter the Username");
			return false;
		}
		if (pass == "") {
			alert("Please enter the Password");
			return false;
		}

	}
</script>
</head>
<body>
	<form action="MyFirstServlet" onsubmit="return myFunction()" method="post">
		<table>
			<tr>
				<td>username</td>
				<td><input type="text" id="uname" name="uname"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" id="pwd" name="pwd"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"></td>
			</tr>
		<a href="NewUser.jsp">Signup</a>

	</form>
</body>
</html>