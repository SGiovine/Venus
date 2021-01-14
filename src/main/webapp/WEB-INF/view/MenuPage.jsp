<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Srl Group</title>

<style type="text/css">
body {
	background: linear-gradient(to bottom, rgb(39, 40, 58), rgb(10, 10, 10));
	background-attachment: fixed;
	background-size: cover;
	background-repeat: no-repeat;
}

.log {
	margin: 0 5% 0 0;
	width: 170px;
	height: 20px;
}

.log form input {
	border: none;
	background: rgba(255, 255, 255, 0.4);
	float: right;
	border-radius: 2px;
	font-size: 4mm;
	font-family: Arial, sans-serif;
	font-style: futura;
	font-weight: 300;
}

.log p {
	font-size: 3mm;
	font-weight: 150;
	color: white;
}

.container-border {
	max-width: 300px;
	padding: 4px 6px 4px 6px;
	background: linear-gradient(to right, rgb(212, 0, 0), rgb(212, 64, 0));
	border-radius: 5px 5px 5px 5px;
	margin: 15% auto 0 auto;
}

.container {
	width: 100%;
	height: 100%;
	position: relative;
	background: rgb(245, 242, 200);
	right: 2px;
	border-radius: 5px 5px 5px 5px;
	border: solid rgba(230, 230, 230, 0.5) 2px;
	padding: 2px 0px 2px 0px;
}

.btn {
	width: 100%;
	height: 100%;
	float: right;
	font-family: Arial, sans-serif;
	font-style: futura;
	font-weight: 300;
	font-size: 4.5mm;
}

.btn-inner {
	margin: 2% auto 2% 5%;
	text-align: center;
	display: inline-block;
	background: linear-gradient(to right, rgb(212, 0, 0), rgb(212, 64, 0));
	border-radius: 2px;
	padding: 1px 1px 1px 1px;
}

#firstbtn {
	
}
</style>

</head>

<body>

	<div class="log">

		<form action="logout">
			<input type="submit" value="logout">
		</form>

		<p>${agenteBean.email}</p>

	</div>


	<div class="container-border">

		<div class="container">
			<div class="btn-inner">
				<form action="creaBorderaux">
					<input type="submit" class="btn" value="Aggiungi Borderaux">
				</form>
			</div>
			<div class="btn-inner">
				<form action="/visualizzaBorderaux">
					<input type="submit" class="btn" value="Visualizza Borderaux non inviate">
				</form>
			</div>
		</div>
	</div>

</body>
</html>