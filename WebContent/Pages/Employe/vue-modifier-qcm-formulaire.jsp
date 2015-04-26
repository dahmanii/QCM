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
						<h1>Modifier QCM</h1>	
					</div>			    		
				</div>
				<div class="sous-box" >						
					<form action="modifierQcm.aspx" method="post" >		
						<!-- infos qcm -->
						<input type="hidden" name="id"    value = "${ qcm.id }" />                	
	                	<input type="hidden" name="dateCreation"    value = "${ qcm.dateCreation }" />
	                	<input type="hidden" name="etat"    value = "en cours" />
						<input type="hidden" name="idEmp"    value = "${user.id}" />
						<input type="hidden" name="messageResponsable"    value = "${ qcm.messageResponsable }" />
						<input type="hidden" name="internautes"    value = "${ qcm.internautes }" />
						<div >
							<p style="font-weight: bold;">Id QCM: ${qcm.id}</p>
							<label for="categorie">Categorie: </label>
							<select name="categorie" >
								<option value="Science" ${qcm.categorieScience}>Science</option>
					            <option value="Informatique" ${qcm.categorieInformatique}>Informatique</option>
					            <option value="Musique" ${qcm.categorieMusique}>Musique</option>
					            <option value="Culture générale" ${qcm.categorieCulture}>Culture générale</option>
							</select>	
							<br />
							<label for="libelle">Libellé</label>
							<input type="text" name="libelle" value="${qcm.libelle}"/>
							<br />
							<br />
						</div>
						<div class="line-separatrice"></div>
						<sss:forEach items="${qcm.questionnaires}" var = "quest">
							<!-- infos questionnaire -->
							<input type="hidden" name="idQuestionnaires"    value = "${ quest.id }" />    
							<p style="font-weight: bold;">Id QUESTIONNAIRE: ${quest.id}</p>
							<p style="width: 60%;">
		            			<span style="font-style: italic;">Modifier la question 1 du QCM:</span>
						      	<textarea class="textareaq" name="question" id="question" >${quest.question}</textarea>
					      	</p>
							<div class="line-separatrice"></div>
							<div class="choix">
								<div class="col-gauche">
									<p style="font-weight: bold;">Modifier les choix maximum:</p>
									<sss:forEach items="${quest.choices}" var = "c">	
										<p >
											<span style="font-style: italic;">Choix ${c.label}:</span>
							       			<textarea class="textareac" name="choix" >${c.choix}</textarea>
						       			</p>
					       			</sss:forEach>
				       			</div>	
				       			<div class="col-droite">
									<p style="font-weight: bold;">Cochez les bonnes réponses</p>
									<sss:forEach items="${quest.choices}" var = "c">	
										<input type="checkbox" name="bnrs" id="cbG05" value = "${quest.id}-${c.label}" class="css-checkbox" ${c.checked}>
					       			</sss:forEach>
					       			<!-- 
									<input type="checkbox" name="bnrs" id="cbG05" value = "0" class="css-checkbox" checked>
									<input type="checkbox" name="bnrs" id="cbG05" value = "1" class="css-checkbox" >
									<input type="checkbox" name="bnrs" id="cbG05" value = "2" class="css-checkbox" >
									<input type="checkbox" name="bnrs" id="cbG05" value = "3" class="css-checkbox" >
									 -->
				       			</div>	
			       			</div>
		       			</sss:forEach>			   
						<br />
						<br />	
						<button type="submit" class="btn-valider" value="modifier qcm">Modifier Qcm</button>	
					</form> <!-- fin formulaire -->
				</div> <!-- fin sous box -->
			</div> <!-- fin box -->
			
			
		</div> <!-- fin container -->
	</body>
</html>