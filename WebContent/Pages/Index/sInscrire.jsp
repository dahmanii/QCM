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
							<button type="submit" class="btn-valider"  name="valider">valider</button>		
				</form>		
			</div>
		</div>

	</div>
</body>
</html>