<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="sss" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html><html>
<head>
	<meta charset="utf-8" />
	<title>Accueil</title>
	<link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
	<div id="container">
		<div id="entete">
			<div id="logo">				
			</div>
		</div>
		<div class="box">
			<div class="titre">	
				<div class="titre-trapeze">	
					<h1>Se connecter </h1>	
				</div>			    		
			</div>
			<div class="sous-box">	
				<span style="color:red">${ message }</span>
				<p>Saisissez votre identifiant et votre mot de passe SONDIX pour vous connecter à votre espace.</p>
				<form action="authentification.aspx" method="post">
					<label for="identifiant">Login </label>
					<input type="text" id="identifiant" class="champs-saisi" name="identifiant" value=""  />
					 <br />
					<label for="mdp">Mot de pass </label>
					<input type="password" id="mdp" class="champs-saisi" name="password" value="" />
					<br/>
					<button type="submit" class="btn-valider" name="se connecter">se connecter</button>		
				</form>	
			</div>
		</div>
		<div class="box">
			<div class="titre">	
				<div class="titre-trapeze">	
					<h1>Créer nouveau compte</h1>	
				</div>			    		
			</div>
			<div class="sous-box">		
					
				<form action="nouveauUser.aspx" method="post">
							<label for="nom">Choisir fonction </label>
							<select name="role" >
							    <option value="Employe">Employé</option>							
								<option value="Responsable">Responsable technique</option>
			                    <option value="Internaute">Internaute</option>
			 				</select>
			 			<br />	
			 			<br />	
							<label for="nom">Nom </label>
							<input type="text" name="nom" class="champs-saisi">
						<br />
							<label for="prenom">Prénom </label>
							<input type="text" name="prenom" class="champs-saisi">
						<br />
							<label for="dateNaissance">Date de naissance </label>
							<input type="text" name="dateNaissance" class="champs-saisi">
						<br />
							<label for="identifiant">Identifiant</label>
							<input type="text" name="identifiant" class="champs-saisi">
						<br />
							<label for="password">Mot de pass</label>
							<input type="password" name="password" class="champs-saisi">
						<br />
								
			 				<!--  		
							<input id="rad1" name="role" type="radio" value="Employe" /> 
							<label for="rad1">Employé d'entreprise</label> 
							
							<input id="rad2" name="role" type="radio" value="Internaute" /> 
							<label for="rad2">Internaute</label> 
												
							<input id="rad3" name="role" type="radio" value="Responsable" /> 
							<label for="rad3">Responsable technique</label>
							-->	
							<button type="submit" class="btn-valider"  name="valider">valider</button>		
				</form>		
			</div>
		</div>
		
		
		
		
	
		<td>${ user.nom }</td><br/>
		<td>${ user.prenom }</td><br/>
		<td>${ user.identifiant }</td><br/>
		<td>${ user.role }</td><br/>
	</div>
</body>
</html>