<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="data" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link href="resources/css/jquery.css" rel="stylesheet">
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:.Meu Bolso.:</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<br />

	<div class="w3-container">
		<h2>Novo Ganho.:</h2>
		<hr />
	</div>

	<form class="w3-container" action="" method="post">

		<p>
			<label>Data: </label> <data:campoData id="dataGanho"/>
		</p>
		
		<p>
			<label>Descricao: </label> <input class="w3-input w3-border w3-round" type="text" name="">
		</p>
		
		<p>
			<label>Tipo: </label> 
			<select class="w3-select w3-border w3-round" name="">
				<option value="" disabled selected>Escolhe a opcao</option>
				<option value="">Fixo</option>
				<option value="">Variavel</option>
				<option value="">Outro</option>
			</select>

		</p>
		
		<p>
			<label>Valor: </label> <input class="w3-input w3-border w3-round" type="text" name="">
		</p>
		
		<p>
			<input class="w3-input w3-light-grey w3-hover-grey" type="submit" value="Cadastrar">
		</p>

	</form>

	<c:import url="rodape.jsp" />
</body>
</html>