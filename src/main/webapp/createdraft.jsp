<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
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
			<label class="control-label" for="field1">Please input the
				name and emails of all players</label> <br />
			<form method="POST" action="createdraft">
				<button type="button" id="add" class="btn btn-default addButton">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
				</button> 
				<label class="control-label text-danger">${error}</label>
				<br /> <br />
				<div id="items">
					<div>
						1. <input type="text" name="name[]" required placeholder="Name">&nbsp;
						<input type="email" name="email[]" placeholder="Email">
					</div>
				</div>
				<div class="clearb"></div>
				<br /><input type="submit" value="Submit"/>
			</form>
		</div>
	</div>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							//when the Add Filed button is clicked
							$("#add").click(function(e) {
								//Append a new row of code to the "#items" div
								$("#items").append(
									"<div>"+ ($('#items').find(':visible[name="name[]"]').length + 1)
									+ '. <input type="text" name="name[]" required placeholder="Name">&nbsp;<input type="email" name="email[]" placeholder="Email"><button type="button" id="delete" class="btn btn-default delete"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button></div>');
							});

							$("body").on("click", ".delete", function(e) {
								$(this).parent("div").remove();
							});
						});
	</script>
</body>
</html>
