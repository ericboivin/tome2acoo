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
<link href="bootstrap/css/docs.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="styles.css" rel="stylesheet">
</head>

<body>

	<div class="navbar navbar-inverse" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="">Netrunner identity draft</a>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<img
					src="http://netrunnerdb.com/web/bundles/netrunnerdbcards/images/cards/en/${identity.code}.png"
					alt="${identity.name}" />
			</div>
			<div class="col-md-8">
				<h3>You have chosen ${identity.name}</h3>
				<div class="bs-glyphicons">
						<a
							href="selectIdentity?confirm=ok&code=<c:out value = "${identity.code}"/>"
							class="btn btn-info" role="button"><span
							class="glyphicon glyphicon-ok" aria-hidden="true"></span> <span
							class="glyphicon-class">Confirm</span></a>
							<a
							href="javascript:goBack()"
							class="btn btn-info" role="button"><span
							class="glyphicon glyphicon-remove" aria-hidden="true"></span> <span
							class="glyphicon-class">Cancel</span></a>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
function goBack() {
    window.history.back();
}
</script>
</html>
