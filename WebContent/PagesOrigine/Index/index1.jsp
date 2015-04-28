<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="sss" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html><html>
<head>
	<meta charset="utf-8" />
	<title>Page d'accueil</title>
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
		<div class="box-index margin-right30">
			<div class="titre">	
				<div class="titre-trapeze">	
					<h1>Qcm aux choix</h1>	
				</div>			    		
			</div>
			<div class="sous-box-index1">
						
			</div>
		</div>
		<div class="box-index">
			<div class="titre">	
				<div class="titre-trapeze">	
					<h1>Interfaces optimisés</h1>	
				</div>			    		
			</div>
			<div class="sous-box-index2">
						
			</div>
		</div>
		<div class="box-index margin-right30">
			<div class="titre">	
				<div class="titre-trapeze">	
					<h1>Blabla Blabla</h1>	
				</div>			    		
			</div>
			<div class="sous-box-index3">
						
			</div>
		</div>
		<div class="box-index">
			<div class="titre">	
				<div class="titre-trapeze">	
					<h1>Blabla Blabla</h1>	
				</div>			    		
			</div>
			<div class="sous-box-index4">
						
			</div>
		</div>

	</div>
</body>
</html>