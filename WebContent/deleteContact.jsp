<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Supprimer un contact</title>
</head>
<body>
	<h1>Quel contact voudriez-vous supprimer ? </h1>
	<form action="/GestionContacts/DeleteContactServlet" method="post">
		<label for="nom">Nom : </label>
		<input type="text" name="nom">
		<br>
		<label for="prenom">Prenom : </label>
		<input type="text" name="prenom">
		<br>	              
		<input type="submit" value="Envoyer"> 
		<input type="reset">
	</form>
</body>
</html>