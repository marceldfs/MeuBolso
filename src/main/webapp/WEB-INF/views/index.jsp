<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:.Meu Bolso.:</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<br />

	<h3>Lista de ganhos e gastos realizados.:</h3>
	<hr />

	<table class="w3-table-all w3-hoverable">
		<thead>
			<tr class="w3-light-grey">
				<th>Data</th>
				<th>Descricao</th>
				<th>Tipo</th>
				<th>Valor</th>
			</tr>
		</thead>
		<c:forEach items="${gastos}" var="gasto">

			<tr id="ganho_${gasto.id}">
				<td>${gasto.data}</td>
				<td>${gasto.descricao}</td>
				<td>${gasto.tipo}</td>
				<td>${gasto.valor}</td>
			</tr>
		</c:forEach>

	</table>

	<c:import url="rodape.jsp" />
</body>
</html>