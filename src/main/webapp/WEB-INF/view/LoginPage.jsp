<%@page import="it.objectmethod.srlgroupjob.controller.bean.UtenteBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Srl Group</title>

<style>
body {
	background: linear-gradient(to bottom, rgb(39, 40, 58), rgb(10, 10, 10));
	background-attachment: fixed;
	background-size: cover;
	background-repeat: no-repeat;
}

.color-radial {
	height: 100%;
	width: 100%;
	position: fixed;
	bottom: 0;
	right: 0;
	left: 0;
	top: 0;
	background: radial-gradient(rgba(59, 60, 78, 0.2), rgba(0, 0, 0, 0));
}

h1 {
	text-align: center;
	color: rgb(245, 242, 161);
	margin-top: 14%;
	text-shadow: 1px 1px rgba(240, 240, 240, 0.5);
	font-family: Arial, sans-serif;
	font-weight: 500;
	font-style: futura;
}

.container-border {
	max-width: 173px;
	max-height: 290px;
	padding: 4px 6px 4px 6px;
	background: linear-gradient(to right, rgb(212, 0, 0), rgb(212, 64, 0));
	border-radius: 5px 5px 5px 5px;
	margin: 0 auto auto auto;
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

.username p {
	margin: 4% 0 0 0;
	text-align: center;
	font-family: Arial, sans-serif;
	font-weight: 300;
	font-style: futura;
}

.password p {
	margin: 3% 0 0 0;
	text-align: center;
	font-family: Arial, sans-serif;
	font-weight: 300;
	font-style: futura;
}

.username input {
	margin: 2% 10% 4% 10%;
	width: 80%;
}

.password input {
	margin: 2% 10% 6% 10%;
	width: 80%;
}

.btn-login {
	width: 28%;
	height: 13%;
	position: relative;
	background: linear-gradient(to right, rgb(212, 0, 0), rgb(212, 64, 0));
	border-radius: 2px;
	padding: 1px 1px 1px 1px;
	bottom: 3px;
	margin: auto auto auto auto;
}

.btn-login input {
	background: rgb(255, 255, 255);
	width: 100%;
	height: 100%;
	border-radius: 2px;
	text-align: center;
	font-family: Arial, sans-serif;
	font-style: futura;
	font-weight: 300;
	font-size: 4.5mm;
	border: none;
}

#err {
	position: relative;
	top: 10px;
	width: 30%;
	margin: 0 35% 0 35%;
}

#err p {
	text-align: center;
	color: rgb(250, 30, 10);
	text-shadow: 1px 1px rgba(0, 0, 0, 0.8);
	font-family: Arial, sans-serif;
	font-style: futura;
	font-weight: 300;
	font-size: 3mm;
}
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
	function sleep(milliseconds) {
		return new Promise(function(resolve) {
			setTimeout(resolve, milliseconds);
		});
	}

	
	async function usercheck(username, password) {

		var url = window.location.origin;
		url += "/usercheck?username=" + username + "&password=" + password;

		try {
			let response = await
			fetch(url);

			let data = await
			response.json();
			console.log(data);
			return data;

		} catch (err) {
			console.log(err);
			return null;
		}

	}

	async function checking() {
		console.log("ciao a tutti");

		if (document.getElementById("user").value == ""
				&& document.getElementById("pass").value == "") {
			document.getElementById("err").innerHTML = "<p>Inserire username e password.</p>";
		} else if (document.getElementById("user").value == "") {
			document.getElementById("err").innerHTML = "<p>Inserire username.</p>";
		} else if (document.getElementById("pass").value == "") {
			document.getElementById("err").innerHTML = "<p>Inserire password.</p>";
		} else {
			var isThereErr = null;
			var running = true;
			while(running){
				
				if(isThereErr != null){
					running = false;
				} else {
					isThereErr = await usercheck(document.getElementById("user").value,
							document.getElementById("pass").value);
				}
				
			}

			var form = document.getElementById("form");
			
			if (isThereErr.isThereErr == "true") {
				form.setAttribute('onsubmit', "return false;");
				document.getElementById("err").innerHTML = "<p>Inserire Username o Password validi.</p>";
			} else {
				form.action = "/login";
				form.submit();
			}
		}
	}
</script>

</head>

<body>
	<div class="color-radial"></div>
	<h1>Login</h1>


	<div class="container-border">

		<div class="container">

			<form id="form">

				<div class="username">
					<p>Username</p>
					<input type="text" name="username" id="user">
				</div>
				<div class="password">
					<p>Password</p>
					<input type="password" name="password" id="pass">
				</div>

				<div class="btn-login">
					<button type="button" onclick="checking()">Login</button>
				</div>

			</form>

		</div>
	</div>

	<div id="err"></div>


</body>
</html>