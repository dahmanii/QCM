<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=" %>
<%@ taglib prefix="sss" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Espace Responsable Technique</title>
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
					<!---------------- Qcms non validés----------------------->
					<form action="vueResponsableQcmsNonValides.aspx" method="post">
			        	<button type="submit" style="width: 100%;height: 100%;background-color: #000 ;">Qcms non validés</button>
			        </form>	
				</div>
				<div class="sous-menu" >	
					<!---------------- Tous les Qcms ----------------------->
					<form action="vueResponsableListeQcms.aspx" method="post">
			        	<button type="submit" style="width: 100%;height: 100%;background-color: #515151 ;">Tous les Qcms</button>
			        </form>	
				</div>
				<div class="sous-menu" >	
					<!---------------- Consulter Qcms Internautes ----------------------->
					<form action="vueResponsableQcmsInternautes.aspx" method="post">
			        	<button type="submit" style="width: 100%;height: 100%;background-color: #8b8b8b;">Qcms Internautes</button>
			        </form>		
				</div>
				<div class="sous-menu" >	
					<!---------------- Statistiques ----------------------->
					<form action="vueResponsableStatistques.aspx" method="post">
			        	<button type="submit" style="width: 100%;height: 100%;background-color: #5B5B5B;">Statistiques</button>
			        </form>		
				</div>
				
			</div> <!-- fin entete -->
					<!----------------  -------------------->
		<div class="box" style = "display:bloc;">
			<div class="titre">	
				<div class="titre-trapeze">	
					<h1>Tous les QCM</h1>	
				</div>			    		
			</div>
			<div class="sous-box">	
				<!-- Liste produits -->	
				<sss:forEach items="${listeQcms}" var = "o">	
					<fieldset>
				    <legend Style="margin:auto;">
				    	<label for="idQcm" Style="float:none;">IdQcm ${ o.id }</label>
				    </legend>	
	                <br />
	                <div class="infos-qcm" style="float:none;">
		                <label for="idQcm">Catégorie </label>
						<label for="idQcm">${ o.categorie } </label>
		                <br />
		                <label for="idQcm">Libellé </label>
						<label for="idQcm">${ o.libelle } </label>
		                <br />
		                <label for="idQcm">Crée le:  </label>
						<label for="idQcm" style=" width: 52%;">${ o.dateCreation } </label>		                
		                <br />
		                <label for="etat">Etat:  </label>
						<label for="idQcm">${o.etat } </label>
						<br>	
						<label for="etat">Lus:  </label>
						<label for="idQcm">${o.internautes } fois </label>
						<br>					
					</div>                
					<br>
	                <div class="line-separatrice"></div>
	                <div class="line-separatrice"></div>
	                
	                <sss:forEach items="${o.questionnaires}" var = "oo">
	                	<div class="line-separatrice"></div>
						<br />
						<div class="infos-questionnaire" style="float:none;">
			                <label for="idQcm">Question : </label>
							<label for="idQcm">${oo.question} </label>
			                <br />
			                <sss:forEach items="${oo.choices}" var = "ooo">
				                <label for="idQcm">${ooo.label}(${ooo.br})   </label>
				                <label for="idQcm">${ooo.choix} </label>
								<br />
							</sss:forEach>  
						</div>		                  	
		                <br/>	             	
                  	</sss:forEach>					
					</fieldset>
				</sss:forEach>
			</div><!--fin sous-box -->
		</div><!-- fin box -->
		</div>    <!-- fin container -->
	</body>
</html>