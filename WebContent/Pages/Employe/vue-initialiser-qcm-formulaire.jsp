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
					<!---------------- Ajouter Qcms ----------------------->
					<form action="vueEmployeAjouterQcm.aspx" method="post">
			        	<button type="submit" style="width: 100%;height: 100%;background-color: #000 ;">Ajouter Qcm</button>
			        </form>	
				</div>
				<div class="sous-menu" >	
					<!---------------- Consulter Qcms ----------------------->
					<form action="vueEmployeListeQcm.aspx" method="post">
			        	<button type="submit" style="width: 100%;height: 100%;background-color: #515151 ;">Liste Qcm</button>
			        </form>	
				</div>
				<div class="sous-menu" >	
					<!---------------- Consulter Qcms Internautes ----------------------->
					<form action="vueEmployeModifierQcms.aspx" method="post">
			        	<button type="submit" style="width: 100%;height: 100%;background-color: #8b8b8b;">Modifier Qcms</button>
			        </form>		
				</div>
				<div class="sous-menu" >	
					<!---------------- Consulter Qcms Internautes ----------------------->
					<form action="vueEmployeQcmInternaute.aspx" method="post">
			        	<button type="submit" style="width: 100%;height: 100%;background-color: #5B5B5B;">Qcms Internautes</button>
			        </form>		
				</div>
				
			</div> <!-- fin entete -->
			<!---------------- Ajout QCM ----------------------->
			
			<div class="box">
				<div class="titre">	
					<div class="titre-trapeze">	
						<h1>Ajouter QCM</h1>	
					</div>			    		
				</div>
				<div class="sous-box" >	
					
					<form action="initialiserQcm.aspx" method="post" >				
						<input type="hidden" name="etat"    value = "en cours" />
						<input type="hidden" name="idEmp"    value = "${user.id}" />						
						<input type="hidden" name="messageResponsable"    value = "" />
						<input type="hidden" name="internautes"    value = "0" />
						<div >
							<p style="font-weight: bold;">Ajouter un nouveau QCM :</p>
							<label for="categorie">Categorie</label>
							<select name="categorie" >
								<option value="Science">Science</option>
					            <option value="Informatique">Informatique</option>
					            <option value="Musique">Musique</option>
					            <option value="Culture générale">Culture générale</option>
							</select>	
							<br />
							<label for="libelle">Libellé</label>
							<input type="text" name="libelle" />
							<br />
							<br />
						</div>
						<div class="line-separatrice"></div>
						
						<p style="width: 60%;">
	            			<span style="font-style: italic;">Tapez la question ${compteurQuestionnaires} du QCM:</span>
					      	<textarea class="textareaq" name="question" id="question" >${questionnaire.question}</textarea>
				      	</p>
						<div class="line-separatrice"></div>
						<div class="choix">
							<div class="col-gauche">
								<p style="font-weight: bold;">Saisir 4 choix maximum:</p>
								<p >
									<span style="font-style: italic;">Choix A:</span>
					       			<textarea class="textareac" name="choix" id="choix1"></textarea>
				       			</p>
								<p >
									<span style="font-style: italic;">Choix B:</span>
					       			<textarea class="textareac" name="choix" id="choix2" ></textarea>
				       			</p>
								
								<p >
									<span style="font-style: italic;">Choix C:</span>
					       			<textarea class="textareac" name="choix" id="choix3" ></textarea>
				       			</p>
								
								<p >
									<span style="font-style: italic;">Choix D:</span>
					       			<textarea class="textareac" name="choix" id="choix4" ></textarea>
				       			</p>
			       			</div>	
			       			<div class="col-droite">
								<p style="font-weight: bold;">Cochez les bonnes réponses</p>
								<input type="checkbox" name="bnrs" id="cbG05" value = "0" class="css-checkbox" >
								<input type="checkbox" name="bnrs" id="cbG05" value = "1" class="css-checkbox" >
								<input type="checkbox" name="bnrs" id="cbG05" value = "2" class="css-checkbox" >
								<input type="checkbox" name="bnrs" id="cbG05" value = "3" class="css-checkbox" >
			       			</div>	
		       			</div>
		       						   
						<br />
						<br />
						<input type="reset" class="btn-valider" name="raz" value="Remettre à zéro" style="border:0px; color:white;"/>					
						<button type="submit" class="btn-valider" name="newQcm" value="questionnaire_suivant">Questionnaire suivant</button>	
						<button type="submit" class="btn-valider" name="newQcm" value="valider_qcm">Valider Qcm</button>	

					</form>
				</div>
			</div>
			
			
		</div> <!-- fin container -->
	</body>
</html>