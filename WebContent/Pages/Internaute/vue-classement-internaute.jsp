<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=" %>
<%@ taglib prefix="sss" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Espace employé</title>
		<link type="text/css" rel="stylesheet" href="inc/style.css" />
	</head>
	<body>
		<!---------------- Entête: espace .... ----------------------->
		<!---------------- Message bonjour nom prenom .... ----------------------->
		<div id="container">
			<div id="infos-connexion" >
				<div id="infos-user" >
					<span >${espace}, ${bonjour}</span>
				</div>
				<div class="quitter">	
					<!---------------- Se déconnecter ----------------------->
					<form action="seDeconnecter.aspx" method="post">
			        	<button type="submit" style="width: 100%;height: 100%;background-color: #3E3E3E;">Quitter</button>
			        </form>		
				</div>
			</div>
			<div id="entete">
				<div id="logo">				
				</div>
				<div class="sous-menu" >	
					<!---------------- Catégories Qcms ----------------------->
					<form action="vueInternauteCategoriesQcms.aspx" method="post">
			        	<button type="submit" style="width: 100%;height: 100%;background-color: #000 ;">Toutes les catégories</button>
			        </form>	
				</div>
				<div class="sous-menu" >	
					<!---------------- Consulter Qcms ----------------------->
					<form action="vueInternauteMesPoints.aspx" method="post">
			        	<button type="submit" style="width: 100%;height: 100%;background-color: #515151 ;">Mes Points</button>
			        </form>	
				</div>
				<div class="sous-menu" >	
					<!---------------- Consulter Qcms Internautes ----------------------->
					<form action="vueInternauteRecompenses.aspx" method="post">
			        	<button type="submit" style="width: 100%;height: 100%;background-color: #8b8b8b;">Mes récompenses</button>
			        </form>		
				</div>
				<div class="sous-menu" >	
					<!---------------- Consulter Qcms Internautes ----------------------->
					<form action="vueInternauteClassement.aspx" method="post">
			        	<button type="submit" style="width: 100%;height: 100%;background-color: #5B5B5B;">Classement</button>
			        </form>		
				</div>				
			</div> <!-- fin entete -->
				<div class="box" style = "display:bloc;">
			<div class="titre">	
				<div class="titre-trapeze">	
					<h1>Liste classement internautes</h1>	
				</div>			    		
			</div>
			<div class="sous-box">	
				<!-- Liste produits -->	
	  			<table border="1">
	  				<caption> Classemant et Détails des points des jours</caption>
					<tbody>
						<tr>
							<th> Nom </th>
							<th> Identifiant </th>
							<th> Science </th>
							<th> Informatique </th>
							<th> Musique </th>
							<th> Culture générale </th>
							<th> Total </th>
						</tr>
						<sss:forEach items="${liste_internautes}" var = "o">
							<tr style="background-color:${o.prenom};">
								<th> ${o.nom} </th>
								<td> ${o.identifiant }</td>
								<td> ${o.pointS} </td>
								<td> ${o.pointI} </td>
								<td> ${o.pointM} </td>
								<td> ${o.pointC} </td>
								<td> ${o.total} </td>
							</tr>
						</sss:forEach>
					</tbody>
				</table>
			</div><!--fin sous-box -->
		</div><!-- fin box -->
		</div>    <!-- fin container -->
	</body>
</html>