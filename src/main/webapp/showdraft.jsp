<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="async.draft.webapp.Draft"%>
<%@ page import="async.draft.webapp.Player"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Netrunner Identity draft</title>

<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/fontawesome/4.2.0/css/font-awesome.min.css">
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- Custom styles for this template -->
<link href="styles.css" rel="stylesheet">
</head>

<body>

	<div class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="">Netrunner identity draft</a>
			</div>
		</div>
	</div>
	<div class="container">
		<div id="content">
			<label class="control-label text-success">${message}</label>
			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>Name</th>
						<th>Corp</th>
						<th>Runner</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${draft.players}" var="player" varStatus="number">
						<tr>
							<td>${number.index + 1}</td>
							<td>${player.name}</td>
							<td>${player.corp}</td>
							<td>${player.runner}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br />
			<a href="showdraft?draft=${draft.code}">Permalink</a>
		</div>
	</div>
</body>
</html>
