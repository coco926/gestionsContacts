<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un contact</title>
</head>
<body>
	<h1>Ajouter un contact</h1>
	<br>
	<form action="/GestionContacts/AddContactServlet" method="post">
		<label for="nom">Nom : </label> 
		<input type="text" name="nom">
		<br> 
		<label for="prenom">Prenom : </label> 
		<input type="text" name="prenom"> 
		<br> 
		<label for="email"> email : </label> 
		<input type="text" name="email"> 
		<br> 
		<input type="submit" value="Envoyer"> 
		<input type="reset">
	</form>
</body>
</html>