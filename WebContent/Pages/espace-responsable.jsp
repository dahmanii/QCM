<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=" %>
<%@ taglib prefix="sss" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Espace Responsable technique</title>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
	<div id="container">
		<div id="entete">
			<div id="logo">				
			</div>
			<div id="espace">	
				<h2 > ${ espace } </h2>			
			</div>
			<div id="bonjour">	
				<h2>  ${ bonjour} </h2>			
			</div>
			<div class="quitter">	
				<!---------------- Se déconnecter ----------------------->
				<form action="seDeconnecter.aspx" method="post">
		        	<button type="submit" style="width: 100%;height: 100%;background-color: #8b8b8b;">Quitter</button>
		        </form>		
			</div>
		</div>
		<!----------------  -------------------->
		<div class="box" style = "display:bloc;">
			<div class="titre">	
				<div class="titre-trapeze">	
					<h1>Afficher QCM</h1>	
				</div>			    		
			</div>
			<form action="afficherQcmResponsable.aspx" method="post">
           		<input type="hidden" name="id" value = "${user.id}" />
           		<input type="hidden" name="espace"   value = " ${espace} " />
				<input type="hidden" name="bonjour"  value = " ${bonjour} " />         		
				<button type="submit" class="btn-valider" name="afficher" >Afficher</button> 
           	</form>
			<div class="sous-box">	
				<!-- Liste produits -->	
				<div class="line-separatrice"></div>
				<p>${messageListeQcmResponsable}</p>	
				<sss:forEach items="${listeQcms}" var = "o">	
					<label for="idQcm">IdQcm </label>
					<label for="idQcm">${ o.id } </label>
	                <br />
	                <label for="idQcm">Catégorie </label>
					<label for="idQcm">${ o.categorie } </label>
	                <br />
	                <label for="idQcm">Libellé </label>
					<label for="idQcm">${ o.libelle } </label>
	                <br />
	                <label for="etat">Etat:  </label>
					<label for="idQcm">${o.etat } </label>
	                <br />
	                <label for="idQcm">Crée le:  </label>
					<label for="idQcm">${ o.dateCreation } </label>
					<br>
	                <p>                    -------------------------                    </p>
	                <sss:forEach items="${o.questionnaires}" var = "oo">
		                <label for="idQcm">Question : </label>
						<label for="idQcm">${oo.question} </label>
		                <br />
		                <label for="idQcm">A)   </label>
		                <label for="idQcm">${ oo.choix2 } </label>
						<br />
		                <label for="idQcm">B)  </label>
						<label for="idQcm">${ oo.choix2 } </label>
	                  	<br />
	                  	<label for="idQcm">C)  </label>
						<label for="idQcm">${ oo.choix3 } </label>
	                  	<br />
	                  	<label for="idQcm">D) </label>
						<label for="idQcm">${ oo.choix4 } </label>
	                  	<br />
	                  	<label for="idQcm">Bonnes réponses:   </label>
						<label for="idQcm">
							<sss:forEach items="${oo.bonneReps}" var = "ooo">
								${ooo.bnr}
							</sss:forEach>
						</label>
	                  	<br />	                  	
                  	</sss:forEach>
					<br />
					<ul class="forms-liste-qcm">
						<li>
	                  	<form action="validationQCM.aspx" method="post">
	                  		<input type="hidden" name="espace" value = " ${espace} " />
							<input type="hidden" name="bonjour" value = " ${bonjour} " />	
							<input type="hidden" name="id" value = "${user.id}" />						
	                  		<input type="hidden" name="idQcm" value = "${o.id}" />
							<p style="width: 60%;">
		            			<span style="font-style: italic;">Tapez un message ici:</span>
						      	<textarea class="textareaq" name="responsableMessageValidationQcm" ></textarea>
					      	</p>
	                  		<button type="submit" class="btn-valider" name="nouveauEtatQcm" value="en ligne">Accépter</button> 
	                  		<button type="submit" class="btn-valider" name="nouveauEtatQcm"  value="refuse" >Refuser</button> 
	                  	</form>
	                  	</li>
	                </ul>
					<div class="line-separatrice"></div>
					<br />
				</sss:forEach>
			</div>
		</div>
	</div>
</body>
</html>