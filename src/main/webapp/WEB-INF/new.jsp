<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevo Lenguaje</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<main class="container">
		<a class="float-end" href="/dashboard">Dashboard</a>
		<form:form class="mt-5" action="/dashboard" method="POST" modelAttribute="Lenguaje">
		    <div class="mb-3">
		        <form:label class="form-label" path="nombre">Nombre</form:label>
		        <form:input class="form-control" path="nombre"/>
		        <form:errors class="text-danger" path="nombre"/>
		    </div>
		    <div class="mb-3">
		        <form:label class="form-label" path="creador">Creador</form:label>
		        <form:input class="form-control" path="creador"/>
		        <form:errors class="text-danger" path="creador"/>
		    </div>
		    <div class="mb-3">
		        <form:label class="form-label" path="version">Version</form:label>
		        <form:input class="form-control" path="version"/>
		        <form:errors class="text-danger" path="version"/>
		    </div>
		    <input class="btn btn-primary float-end" type="submit" value="Submit"/>
		</form:form>
	</main>
</body>
</html>