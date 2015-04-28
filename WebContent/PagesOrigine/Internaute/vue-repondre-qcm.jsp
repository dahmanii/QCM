<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=" %>
<%@ taglib prefix="sss" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Espace Internaute</title>
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
					<!----------------  -------------------->
		<div class="box" style = "display:bloc;">
			<div class="titre">	
				<div class="titre-trapeze">	
					<h1>Répondre à ce Qcm</h1>	
				</div>			    		
			</div>
			<div class="sous-box">	
				<fieldset>
			    <legend Style="margin:auto;">
			    	<label for="idQcm" Style="float:none;">Libellé : ${ qcm.libelle }</label>
			    </legend>	
                <br />     
                <form action="repondreQcm.aspx" method="post">            
	                <sss:forEach items="${qcm.questionnaires}" var = "questionnaire">
	                	<div class="line-separatrice"></div>
						<br />
						<div class="infos-questionnaire" style="float:none;">
							<span>${questionnaire.question} </span>
			                <br />
			                <br />
			                <sss:forEach items="${questionnaire.choices}" var = "choice">
			                	<div class="choix">
				                	<input type="radio" name="${questionnaire.id}" value="${choice.label}" style="float: left;margin-right: 11px;">
					                <span>${choice.label}) ${choice.choix} </span>
				                </div>
								<br />
							</sss:forEach>  	           
						</div>		                  	
		                <br/>	             	
	                </sss:forEach>
	                <input type="hidden" name="idQcm"    value = "${qcm.id}" />       		
					<button type="submit" class="btn-valider" name="choisir" style="margin-left: 40px;">Répondre</button>
                </form>		              			
				</fieldset>
			</div><!--fin sous-box -->
		</div><!-- fin box -->
		</div>    <!-- fin container -->
	</body>
</html>