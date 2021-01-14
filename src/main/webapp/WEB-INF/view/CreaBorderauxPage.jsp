<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
</style>

</head>
<body>


	<div class="btn-menu">
		<form action="/menu">
			<input type="submit" class="btn" value="menu">
		</form>

	</div>


	<div class="border-container">

		<div class="container">

			<form action="/creaBorderaux">

				<input type="text" name="localita"> <input type="text"
					name="nazione"> <input type="text" name="provincia">
				<input type="text" name="indirizzo"> <input type="text"
					name="cap"> <input type="text" name="codice"> <input
					type="text" name="ragSoc1"> <input type="text" name="ragSoc2"> <input
					type="text" name="aspetto"> <input type="text" name="peso"> <select
					class="select" name="tipoRegistro">
					<option value="IV">IVA Vendita</option>
					<option value="DV">DDT Vendita</option>
					<option value="LI">Lettere Incarico</option>

				</select> <input type="submit" value="crea borderaux">

			</form>

		</div>

	</div>

</body>
</html>