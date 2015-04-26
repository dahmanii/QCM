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
					<h1>Liste QCM ${ o.categorie }</h1>	
				</div>			    		
			</div>
			<div class="sous-box">	
				<!-- Liste produits -->	
				<p>${messageListeQcmInternaute}</p>
				<form action="afficherQcmInternauteByCategorie.aspx" method="post">
					<label for="categorie">Choisir une autre categorie</label>
					<select name="categorie" >
						<option value="Science">Science</option>
			            <option value="Informatique">Informatique</option>
			            <option value="Musique">Musique</option>
			            <option value="Culture générale">Culture générale</option>
					</select>           		
					<button type="submit" class="btn-valider" name="afficher" >Afficher</button> 
	           	</form>
				<sss:forEach items="${listeQcms}" var = "o">	
					<br />
					<fieldset>
				    <legend Style="margin:auto;">
				    	<label for="idQcm" Style="float:none;">Libellé : ${ o.libelle }</label>
				    </legend>	
	                <br />               
	                <sss:forEach items="${o.questionnaires}" var = "oo">
	                	<div class="line-separatrice"></div>
						<br />
						<div class="infos-questionnaire" style="float:none;">
							<span>${oo.question} </span>
			                <br />
			                <sss:forEach items="${oo.choices}" var = "ooo">
			                	<div class="choix">
				                	<span>${ooo.label}) ${ooo.choix}</span>
				                </div>
								<br />
							</sss:forEach>  
						</div>		                  	
		                <br/>	             	
                  	</sss:forEach>	 
                	<form action="vueRepondreQcm.aspx" method="post">   
                  		<input type="hidden" name="idQcm"    value = "${o.id}" />       		
						<button type="submit" class="btn-valider" name="choisir" Style="margin-left:40px;">Choisir</button> 
           			</form>	                				
					</fieldset>
				</sss:forEach>
			</div><!--fin sous-box -->
		</div><!-- fin box -->
		</div>    <!-- fin container -->
	</body>
</html>