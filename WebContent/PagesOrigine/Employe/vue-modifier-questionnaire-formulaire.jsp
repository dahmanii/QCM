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
						<h1>Modifier Questionnaire</h1>	
					</div>			    		
				</div>
				<div class="sous-box" >						
					<form action="modifierQuestionnaire.aspx" method="post" >		
		                <div class="infos-qcm" style="float:none;margin-bottom:10px;">
							<!-- infos questionnaire -->
							<input type="hidden" name="id"    value = "${ questionnaire.id }" />							
		                	<label for="idQcm" Style="float:none;">IdQcm ${ qcm.id }</label>
		                	<br />
			                <label for="idQcm">Catégorie </label>
							<label for="idQcm">${ qcm.categorie } </label>
			                <br />
			                <label for="idQcm">Libellé </label>
							<label for="idQcm" >${ qcm.libelle } </label>
			                <br />
			                <label for="idQcm">Crée le:  </label>
							<label for="idQcm" style=" width: 52%;">${ qcm.dateCreation } </label>		                
			                <br />
			                <label for="etat">Etat:  </label>
							<label for="idQcm">${qcm.etat } </label>
							<br>
							<label for="etat" style="float: none;">Message Responsable:  </label>
							<label for="idQcm" style="float: none;">${qcm.messageResponsable } </label>
						</div>
						<div class="line-separatrice"></div>
						<p style="font-weight: bold;">Id QUESTIONNAIRE: ${questionnaire.id}</p>
						<p style="width: 60%;">
	            			<span style="font-style: italic;">Modifier la question:</span>
					      	<textarea class="textareaq" name="question" id="question" >${questionnaire.question}</textarea>
				      	</p>
						<div class="line-separatrice"></div>
						<div class="choix">
							<div class="col-gauche">
								<p style="font-weight: bold;">Modifier les choix maximum:</p>
								<sss:forEach items="${questionnaire.choices}" var = "c">	
									<p >
										<span style="font-style: italic;">Choix ${c.label}:</span>
						       			<textarea class="textareac" name="choix" id="choix1">${c.choix}</textarea>
					       			</p>
				       			</sss:forEach>
			       			</div>	
			       			<div class="col-droite">
								<p style="font-weight: bold;">Modifier les bonnes réponses</p>
								<sss:forEach items="${questionnaire.choices}" var = "c">	
									<input type="checkbox" name="bnrs" id="cbG05" value = "${c.label}" class="css-checkbox" ${c.checked}>
				       			</sss:forEach>
				       			<!-- 
								<input type="checkbox" name="bnrs" id="cbG05" value = "0" class="css-checkbox" checked>
								<input type="checkbox" name="bnrs" id="cbG05" value = "1" class="css-checkbox" >
								<input type="checkbox" name="bnrs" id="cbG05" value = "2" class="css-checkbox" >
								<input type="checkbox" name="bnrs" id="cbG05" value = "3" class="css-checkbox" >
								 -->
			       			</div>	
		       			</div>
						<br />
						<br />
						<button type="submit" class="btn-valider" value="modifier">Modifier Questionnaire</button>	
					</form> <!-- fin formulaire -->
				</div> <!-- fin sous box -->
			</div> <!-- fin box -->
			
			
		</div> <!-- fin container -->
	</body>
</html>