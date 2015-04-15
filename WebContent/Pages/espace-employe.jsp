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
			

			<!---------------- Ajout QCM ----------------------->
			<div class="box" style = "display:${displayAjouterQCM};">
				<div class="titre">	
					<div class="titre-trapeze">	
						<h1>Ajouter QCM</h1>	
					</div>			    		
				</div>
				<div class="sous-box" >	
					
					<form action="nouveauQcm.aspx" method="post" >				
					
						<input type="hidden" name="idEmp"    value = " ${user.id} " />		
						<input type="hidden" name="espace"   value = " ${espace} " />
						<input type="hidden" name="bonjour"  value = " ${bonjour} " />
						<input type="hidden" name="idQcm"    value = " ${qcm.id} " />
						<div style = "display:${displayAjouterlibelleQcm};">
							<p style="font-weight: bold;">Ajouter un nouveau QCM :</p>
							<label for="categorie">Categorie</label>
							<select name="categorie" >
								<option value="Science">Science</option>
					            <option value="Informatique">Informatique</option>
					            <option value="Musique">Musique</option>
					            <option value="Culture générale">Culture générale</option>
							</select>	
							<br />
							<label for="etat">Libellé</label>
							<input type="text" name="libelle" />
							<br />
							<br />
						</div>
						<div style = "display:${displaylibellelabelQcm};">
							<p><span style="font-weight: bold;">Informations du QCM :</span> </p>
							<p>Categorie :<span style="font-weight: italic;">${ qcm.categorie }</span></p>
							<p>Libellé :<span style="font-weight: italic;">${ qcm.libelle }</span></p>
							<br />
							<br />
						</div>
						<div class="line-separatrice"></div>
						
						<p style="width: 60%;">
	            			<span style="font-style: italic;">Tapez la question ${compteurQuestionnaires} du QCM:</span>
							<!-- <label for="question">Tapez la question du QCM:</label> -->
					      	<textarea class="textareaq" name="question" id="question" >${questionnaire.question}</textarea>
				      	</p>
						<div class="line-separatrice"></div>
						<div class="choix">
							<div class="col-gauche">
								<p style="font-weight: bold;">Saisir les choix :</p>
								<p >
									<span style="font-style: italic;">Choix A:</span>
					       			<textarea class="textareac" name="choix1" id="choix1">${questionnaire.choix1}</textarea>
				       			</p>
								<p >
									<span style="font-style: italic;">Choix B:</span>
					       			<textarea class="textareac" name="choix2" id="choix2" >${questionnaire.choix2}</textarea>
				       			</p>
								
								<p >
									<span style="font-style: italic;">Choix C:</span>
					       			<textarea class="textareac" name="choix3" id="choix3" >${questionnaire.choix3}</textarea>
				       			</p>
								
								<p >
									<span style="font-style: italic;">Choix D:</span>
					       			<textarea class="textareac" name="choix4" id="choix4" >${questionnaire.choix4}</textarea>
				       			</p>
			       			</div>	
			       			<div class="col-droite">
								<p style="font-weight: bold;">Cochez les bonnes réponses</p>
								<input type="checkbox" name="bnrs" id="cbG05" value = "A" class="css-checkbox" >
								<input type="checkbox" name="bnrs" id="cbG05" value = "B" class="css-checkbox" >
								<input type="checkbox" name="bnrs" id="cbG05" value = "C" class="css-checkbox" >
								<input type="checkbox" name="bnrs" id="cbG05" value = "D" class="css-checkbox" >
			       			</div>	
		       			</div>
		       						   
						<br />
						<br />
						<input type="reset" class="btn-valider" name="raz" value="Remettre à zéro" style="border:0px; color:white;"/>					
						<button type="submit" class="btn-valider" name="newQcm" value="questionnaire_suivant">Questionnaire suivant</button>	
						<button type="submit" class="btn-valider" name="newQcm" value="valider_qcm">Valider Qcm</button>	
						<!-- <input action="modifierQcm.aspx" type="submit" value="Modifier" ${disabled} > -->

					</form>
				</div>
			</div>
			<!----------------Modifier QCM ----------------------->
			<div class="box" style = "display:${displayModifierQCM};">
				<div class="titre">	
					<div class="titre-trapeze">	
						<h1>Modifier QCM</h1>	
					</div>			    		
				</div>
				<div class="sous-box">	
					
					<form action="modifierQcm.aspx" method="post" >				
					
						<input type="hidden" name="id" value = " ${qcm.id} " />	
						<input type="hidden" name="dateCreation" value = " ${qcm.dateCreation} " />	
						<input type="hidden" name="idEmp" value = " ${user.id} " />		
						<input type="hidden" name="espace" value = " ${espace} " />
						<input type="hidden" name="bonjour" value = " ${bonjour} " />
						
						<p style="font-weight: bold;">Modifier QCM :</p>
						<p style="width: 60%;">
	            			<span style="font-style: italic;">Modifier la question 1 du QCM:</span>
							<!-- <label for="question">Tapez la question du QCM:</label> -->
					      	<textarea class="textareaq" name="question" id="question" >${questionnaire.question}</textarea>
				      	</p>
						<div class="line-separatrice"></div>
						<div class="choix">
							<div class="col-gauche">
								<p style="font-weight: bold;">Modifier les choix :</p>
								<p >
									<span style="font-style: italic;">Choix A:</span>
					       			<textarea class="textareac" name="choix1" id="choix1">${questionnaire.choix1}</textarea>
				       			</p>
								<p >
									<span style="font-style: italic;">Choix B:</span>
					       			<textarea class="textareac" name="choix2" id="choix2" >${questionnaire.choix2}</textarea>
				       			</p>
								
								<p >
									<span style="font-style: italic;">Choix C:</span>
					       			<textarea class="textareac" name="choix3" id="choix3" >${questionnaire.choix3}</textarea>
				       			</p>
								
								<p >
									<span style="font-style: italic;">Choix D:</span>
					       			<textarea class="textareac" name="choix4" id="choix4" >${questionnaire.choix4}</textarea>
				       			</p>
			       			</div>	
			       			<div class="col-droite">
								<p style="font-weight: bold;">Cochez les bonnes réponses</p>
								<input type="checkbox" name="bnrs" id="cbG05" class="css-checkbox" >
								<input type="checkbox" name="bnrs" id="cbG05" class="css-checkbox" >
								<input type="checkbox" name="bnrs" id="cbG05" class="css-checkbox" >
								<input type="checkbox" name="bnrs" id="cbG05" class="css-checkbox" >
			       			</div>	
		       			</div>
		       						   
						<br />
						<br />
						<label for="etat">Etat</label>
						<select name="etat" >
							<option value="en ligne">En ligne</option>
				            <option value="en cours">En cours</option>
						</select>	
						<br />
						<br />					
						<button type="submit" class="btn-valider" name="modifier">Modifier > suivant</button>	
						<!-- <input action="modifierQcm.aspx" type="submit" value="Modifier" ${disabled} > -->

					</form>
				</div>
			</div>

			<!---------------- Liste QCM ----------------------->
			<div class="box" style = "display:${displayListeQCM};">
				<div class="titre">	
					<div class="titre-trapeze">	
						<h1>Liste QCM</h1>	
					</div>			    		
				</div>
				<div class="sous-box">	
					<!-- Liste qcm -->		
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
		                <label for="idQcm">Crée le:  </label>
						<label for="idQcm">${ o.dateCreation } </label>		                
		                <br />
		                <label for="etat">Etat:  </label>
						<label for="idQcm">${o.etat } </label>
						<br>
						<label for="etat">Message Responsable:  </label>
						<label for="idQcm">${o.messageResponsable } </label>
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
		                  	<ul class="forms-liste-qcm">
		                  	<li>
		                  	<form action="supprimerQCM.aspx" method="post">
		                  		<input type="hidden" name="idEmp" value = "${user.id}" />
		                  		<input type="hidden" name="id" value = "${o.id}" />
		                  		<button type="submit" class="btn-valider" name="supprimer" >Supprimer</button> 
		                  	</form>
		                  	</li>
		                  	<li>
		                  	<!-- <form action="modification.aspx" method="post"> -->
		                  	<form action="supprimerQCM.aspx" method="post">
		                  		<input type="hidden" name="espace" value = " ${espace} " />
								<input type="hidden" name="bonjour" value = " ${bonjour} " />
								
		                  		<input type="hidden" name="id" value = "${o.id}" />
		                  		<input type="hidden" name="dateCreation" value = "${o.dateCreation}" />
		                  		<input type="hidden" name="question" value = "${questionnaires.question}" />
		                  		<input type="hidden" name="choix1" value = "${questionnaires.choix1}" />
		                  		<input type="hidden" name="choix2" value = "${questionnaires.choix2}" />
		                  		<input type="hidden" name="choix3" value = "${questionnaires.choix3}" />
		                  		<input type="hidden" name="choix4" value = "${questionnaires.choix4}" />
		                  		<input type="hidden" name="idEmp" value = "${user.id}" />
		                  		<input type="hidden" name="bonneRep" value = "X" />
		                  		<input type="hidden" name="etat" value = "${o.etat}" />
		                  		<button type="submit" class="btn-valider" name="modifier" value="modifier">Modifier</button> 
		                  	</form>
		                  	</li>
		                  	</ul>
		                  	</br>
	                  	</sss:forEach>
						<br />
						<div class="line-separatrice"></div>
						<br />
					</sss:forEach>
			</div>
			<hr/>
		</div>
		</div>
	</body>
</html>