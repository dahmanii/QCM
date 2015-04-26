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
			<div id="logo" class="logo-margin-index">				
			</div>
			<div class="sous-menu" >	
				<!---------------- Accueil ----------------------->
				<form action="index.aspx" method="post">
		        	<button type="submit" style="width: 100%;height: 100%;background-color: #000 ;">Accueil</button>
		        </form>	
			</div>
			<div class="sous-menu" >	
				<!---------------- Se connecter ----------------------->
				<form action="vueSeConnecter.aspx" method="post">
		        	<button type="submit" style="width: 100%;height: 100%;background-color: #515151 ;">Se connecter</button>
		        </form>	
			</div>
			<div class="sous-menu" >	
				<!---------------- Nouveau utilisateur ----------------------->
				<form action="vueNouveauUtilisateur.aspx" method="post">
		        	<button type="submit" style="width: 100%;height: 100%;background-color: #8b8b8b ;">S'enregistrer</button>
		        </form>	
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
	</div>
</body>
</html>