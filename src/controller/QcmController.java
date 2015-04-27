package controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.org.apache.xpath.internal.axes.ReverseAxesWalker;

import BeansVues.*;
import dao.Entites.*;
import services.QcmMetier;

@Controller
public class QcmController {

	@Autowired         
	QcmMetier services;    // services est un interface: spring, grace à @Autowired, lui associe une instanciation des l'objet qcmService définit dans spring-beans.xml
	Qcm qcm = new Qcm();
	Utilisateur user = new Utilisateur();
	String espace = "Espace Employe" ;
	String bonjour = "Bonjour "+this.user.getNom() +" "+ this.user.getPrenom();;
	int compteurQuestionnaires=0;
	
	/* ***************************************************************************************
	 * ************************************* Partie Index ************************************
	 *****************************************************************************************
	 */
	@RequestMapping(value="/vueSeConnecter")
	public String vueSeConnecter(Model model){
		return "Index/seConnecter";
	}
	
	@RequestMapping(value="/vueNouveauUtilisateur")
	public String vueNouveauUtilisateur(Model model){
		return "Index/sInscrire";
	}
	
	@RequestMapping(value="/index")
	public String index(Model model){
		return "Index/index";
	}
	
	@RequestMapping(value="/seDeconnecter")
	public String seDeconnecter(Model model){	
		return "Index/index";
	}
	
	@RequestMapping(value="/authentification")
	public String sidentifier(Model model ,
							  @RequestParam(value="identifiant") String identifiant,
							  @RequestParam(value="password") String password){
		String message = "";
		List<Employe> listeEmp = (List<Employe>) services.empDejaEnregistre(identifiant, password);
		List<Responsable> listeResp = (List<Responsable>) services.respDejaEnregistre(identifiant, password);
		List<Internaute> listeInternaute = (List<Internaute>) services.internauteDejaEnregistre(identifiant, password);
		
		if(!listeEmp.isEmpty()){
			this.user = listeEmp.get(0);
			this.espace = "Espace Employe";
			this.bonjour = "Bonjour "+this.user.getNom() +" "+ this.user.getPrenom();

			model.addAttribute("espace", this.espace);
			model.addAttribute("bonjour", this.bonjour);
			model.addAttribute("user", this.user);
			model.addAttribute("qcm", new Qcm());
			
			return "Employe/accueil";
			
		}else if(!listeResp.isEmpty()) {
			this.user = listeResp.get(0);
			this.espace = "Espace Responsable technique";
			this.bonjour = "Bonjour "+this.user.getNom() +" "+ this.user.getPrenom();
			model.addAttribute("espace", this.espace);
			model.addAttribute("bonjour", this.bonjour);
			model.addAttribute("user", this.user);
			return "Responsable/accueil";
			
		}else if(!listeInternaute.isEmpty()){
			this.user = listeInternaute.get(0);
			this.espace = "Espace Internaute";
			this.bonjour = "Bonjour "+this.user.getNom() +" "+ this.user.getPrenom() ;
			//bonjour += ", votre date de naissance est:  " + this.user.getDateNaissance() ;
			model.addAttribute("espace", this.espace);
			model.addAttribute("bonjour", this.bonjour);
			model.addAttribute("user", this.user);
			return "Internaute/accueil";
			
		}else {
			message = "Identifiant ou mot de pass incorrect, reessayer!";
			
			model.addAttribute("message", message);
			return "Index/seConnecter";
		}
	}
	
	// sidentifier.aspx
	@RequestMapping(value="/nouveauUser")
	public String nouveauUser(Model model,
							  @RequestParam(value="nom") String nom,
							  @RequestParam(value="prenom") String prenom,
							  @RequestParam(value="identifiant") String identifiant,
							  @RequestParam(value="dateNaissance") String dateNaissance,
							  @RequestParam(value="password") String password,
							  @RequestParam(value="role") String role){
		if(role.equals("Employe")) {
			Employe emp = new Employe(nom, prenom, identifiant, password);
			services.ajouterUtilisateur(emp);
			model.addAttribute("user", emp);			
		}else if(role.equals("Internaute")){
			Internaute inte = new Internaute(nom, prenom, identifiant, password);
			inte.setDateNaissance(dateNaissance);
			services.ajouterUtilisateur(inte);			
			model.addAttribute("user", inte);		
		}else{
			Responsable resp = new Responsable(nom, prenom, identifiant, password);
			services.ajouterUtilisateur(resp);
			model.addAttribute("user", resp);
		}

		return "Index/seConnecter";
	}
	
	/* *****************************************************************************************
	 * ************************************* Action Employe ************************************
	 *******************************************************************************************
	 */
	////////////////
	// Les Vues
	//
	//
	//////////////// vueEmployeAjouterQcm ///////////
	@RequestMapping(value="/vueEmployeAjouterQcm")
	public String nouveauUser(Model model){
		
		model.addAttribute("user", this.user);		
		model.addAttribute("bonjour", this.bonjour);
		model.addAttribute("espace", this.espace);
		return "Employe/vue-initialiser-qcm-formulaire";
	}
	
	////////////////vueEmployeModifierQcms ///////////
	@RequestMapping(value="/vueEmployeModifierQcms")
	public String vueEmployeModifierQcms(Model model){
		
		model.addAttribute("user", this.user);		
		model.addAttribute("bonjour", this.bonjour);
		model.addAttribute("espace", this.espace);
		
		List<Qcm> liste_Qcm = services.consulterQcm(this.user.getId());
		model.addAttribute("listeQcms", liste_Qcm);
		model.addAttribute("listeQcms", liste_Qcm);
		return "Employe/vue-modifier-qcm";
	}
	
	//////////////// vueEmployeListeQcm ///////////
	@RequestMapping(value="/vueEmployeListeQcm")
	public String vueEmployeListeQcm(Model model){
		
		model.addAttribute("user", this.user);		
		model.addAttribute("bonjour", this.bonjour);
		model.addAttribute("espace", this.espace);
		
		List<Qcm> liste_Qcm = services.consulterQcm(this.user.getId());
		
		for(Qcm qcm: liste_Qcm) {
			switch (qcm.getEtat()) {
			case "en ligne":
				qcm.setColor("#AFE6B1");  // etat = en ligne
				break;
			case "en cours":
				qcm.setColor("#e6aa0e");  // etat = en cours
				break;
			case "refuse":
				qcm.setColor("#f05a49");  // etat = refus�
				break;
			default:
				break;
			}
		}
		
		model.addAttribute("listeQcms", liste_Qcm);

		return "Employe/vue-liste-mes-qcm";
	}
	
	
	////////////////vueEmployeQcmInternaute ///////////
	@RequestMapping(value="/vueEmployeQcmInternaute")
	public String vueEmployeQcmInternaute(Model model){
	
		model.addAttribute("user", this.user);		
		model.addAttribute("bonjour", this.bonjour);
		model.addAttribute("espace", this.espace);
		
		List<Qcm> liste_Qcm = services.mesQcmLus(this.user.getId());
		model.addAttribute("listeQcms", liste_Qcm);
	
	return "Employe/vue-liste-mes-qcm-lus";
	}
	
	//////////////// vueModifierQuestionnaire ///////////
	@RequestMapping(value="/vueModifierQuestionnaire")
	public String vueModifierQuestionnaire(Model model, @RequestParam(value="idQcm") Integer idQcm,
												   		@RequestParam(value="idQuestionnaire") Integer idQuestionnaire){
		
		//qcm.show();
		Qcm qcm = services.getQcm(idQcm);	
		Questionnaire quest = services.getQuestionnaire(idQuestionnaire);
		QuestionnaireVue questionnaire = new QuestionnaireVue(quest);
		
		model.addAttribute("qcm", qcm);
		model.addAttribute("questionnaire", questionnaire);
		model.addAttribute("espace", this.espace);	
		model.addAttribute("bonjour", this.bonjour);	
		model.addAttribute("user", this.user);	
		
		return "Employe/vue-modifier-questionnaire-formulaire";
	}

	//////////////// vueModifierQcm ///////////
	@RequestMapping(value="/vueModifierQcm")
	public String vueModifierQcm(Model model, @RequestParam(value="idQcm") Integer idQcm){
		
		model.addAttribute("user", this.user);		
		model.addAttribute("bonjour", this.bonjour);
		model.addAttribute("espace", this.espace);
		
		//List<Qcm> liste_Qcm = services.consulterQcm(this.user.getId());
		Qcm q = services.getQcm(idQcm);
		QcmVue qcm = new QcmVue(q);
		model.addAttribute("qcm", qcm);
		return "Employe/vue-modifier-qcm-formulaire";
	}
	///////////// Fin des vues
	/////////////
	//////////////// initialiserQcm ///////////
	@RequestMapping(value="/initialiserQcm")
	public String initialiserQcm(Model model, Qcm qcm, Questionnaire questionnaire, String[] choix, Integer[] bnrs,
												   String newQcm){
	
		Integer idQcm;

		String dateCreation;
	    DateTime dt = new DateTime();
		 /* Conversion de la date en String selon le format défini */
        DateTimeFormatter formatter = DateTimeFormat.forPattern( "dd/MM/yyyy HH:mm:ss" );
        dateCreation = dt.toString( formatter );
        qcm.setDateCreation(dateCreation);

        idQcm = services.ajouterQcm(qcm);
        qcm.setId(idQcm);
        this.qcm = qcm;
        questionnaire.addChoices(choix, bnrs);
       
        services.ajouterQuestionnaireAQcm(questionnaire, this.qcm.getId());
        		
		model.addAttribute("user", this.user);		
		model.addAttribute("bonjour", this.bonjour);
		model.addAttribute("espace", this.espace);

			
		if(newQcm.equals("questionnaire_suivant")){
			compteurQuestionnaires++;
			model.addAttribute("questionnaire", questionnaire);
			model.addAttribute("qcm", this.qcm);
			model.addAttribute("compteurQuestionnaires", compteurQuestionnaires);
			return "Employe/vue-remplir-qcm-formulaire";
		}else{
			compteurQuestionnaires=0;
			this.qcm = null;
			model.addAttribute("compteurQuestionnaires", compteurQuestionnaires);
			return "Employe/vue-initialiser-qcm-formulaire"; 
		}
		
	}
	
	//////////////// remplirQcm ///////////
	@RequestMapping(value="/remplirQcm")
	public String remplirQcm(Model model, Qcm qcm, Questionnaire questionnaire, String[] choix, Integer[] bnrs,
												   String newQcm){
        questionnaire.addChoices(choix, bnrs);
       
        services.ajouterQuestionnaireAQcm(questionnaire, this.qcm.getId());
        		
		model.addAttribute("user", this.user);		
		model.addAttribute("bonjour", this.bonjour);
		model.addAttribute("espace", this.espace);
		
			
		if(newQcm.equals("questionnaire_suivant")){
			compteurQuestionnaires++;
			model.addAttribute("questionnaire", questionnaire);
			model.addAttribute("qcm", this.qcm);
			model.addAttribute("compteurQuestionnaires", compteurQuestionnaires);
			return "Employe/vue-remplir-qcm-formulaire";
		}else{
			compteurQuestionnaires=0;
			this.qcm = null;
			model.addAttribute("compteurQuestionnaires", compteurQuestionnaires);
			return "Employe/vue-initialiser-qcm-formulaire";
		}
	}	
	
	//////////////// supprimerQCM ///////////	
	@RequestMapping(value="/supprimerQCM")
	public String supprimerQCM(Model model, @RequestParam(value="idQcm") Integer id){

		services.supprimerQcm(id); 	
	
		List<Qcm> liste_Qcm = services.consulterQcm(user.getId());
		model.addAttribute("listeQcms", liste_Qcm);	
		
		model.addAttribute("user", this.user);
		model.addAttribute("espace", this.espace);
		model.addAttribute("bonjour", this.bonjour);
		
		return "Employe/vue-modifier-qcm";
	}    
	
	//////////////// supprimerQUESTIONNAIRE ///////////	
	@RequestMapping(value="/supprimerQUESTIONNAIRE")                    
	public String supprimerQUESTIONNAIRE(Model model, @RequestParam(value="idQuestionnaire") Integer idQuestionnaire,
													  @RequestParam(value="idQcm") Integer idQcm){
		services.supprimerQuestionnaire(idQcm, idQuestionnaire);
		
		List<Qcm> liste_Qcm = services.consulterQcm(user.getId());
		model.addAttribute("listeQcms", liste_Qcm);
	
		
		model.addAttribute("user", this.user);
		model.addAttribute("espace", this.espace);
		model.addAttribute("bonjour", this.bonjour);
		
		return "Employe/vue-modifier-qcm";
	}

	//////////////// modifierQcm ///////////	
	@RequestMapping(value="/modifierQcm")
	public String modifierQCM(Model model, Qcm qcm, 
										   @RequestParam(value="idQuestionnaires") Integer[] idQuestionnaires,
										   @RequestParam(value="question") String[] question,
										   @RequestParam(value="choix") String[] choix,
										   @RequestParam(value="bnrs") String[] bnrs
										   ){
		
		services.modifierQcm(qcm, idQuestionnaires, question, choix, bnrs);

		List<Qcm> liste_Qcm = services.consulterQcm(user.getId());
		model.addAttribute("listeQcms", liste_Qcm);
		model.addAttribute("espace", this.espace);	
		model.addAttribute("bonjour", this.bonjour);	
		model.addAttribute("user", this.user);	
		
		return "Employe/vue-modifier-qcm";
	}

	//////////////// modifierQuestionnaire ///////////	
	@RequestMapping(value="/modifierQuestionnaire")
	public String modifierQuestionnaire(Model model, Questionnaire questionnaire, String[] choix, Integer[] bnrs){
		
		//qcm.setId(idQcm);	
		questionnaire.addChoices(choix, bnrs);
		questionnaire.show();
		services.modifierQuestionnaire(questionnaire); 
		
		List<Qcm> liste_Qcm = services.consulterQcm(user.getId());
		model.addAttribute("listeQcms", liste_Qcm);
			
		model.addAttribute("espace", this.espace);	
		model.addAttribute("bonjour", this.bonjour);	
		model.addAttribute("user", this.user);	
		
		return "Employe/vue-modifier-qcm";
	}

	/* *****************************************************************************************
	 * ********************************** Action Responsable ***********************************
	 *******************************************************************************************
	 */
	////////////////
	// Les Vues
	//
	//
	//////////////// vueResponsableQcmsNonValides ///////////
	@RequestMapping(value="/vueResponsableQcmsNonValides")
	public String vueResponsableQcmsNonValides(Model model){
		
		String messageListeQcmResponsable;
		
		List<Qcm> liste_Qcm = services.consulterQcmEnCours();	
		if (liste_Qcm.isEmpty()) messageListeQcmResponsable = "Tous les qcm ont �t� valid�s";
		else messageListeQcmResponsable = "Liste des Qcm � valider";
		model.addAttribute("messageListeQcmResponsable", messageListeQcmResponsable);	
		model.addAttribute("listeQcms", liste_Qcm);	
		
		model.addAttribute("user", this.user);		
		model.addAttribute("bonjour", this.bonjour);
		model.addAttribute("espace", this.espace);
		return "Responsable/vue-qcm-non-valides-formulaire";
	}
	
	////////////////vueResponsableListeQcms ///////////
	@RequestMapping(value="/vueResponsableListeQcms")
	public String vueResponsableListeQcms(Model model){
				
		List<Qcm> liste_Qcm = services.consulterQcm();		
		model.addAttribute("listeQcms", liste_Qcm);	
		
		model.addAttribute("user", this.user);		
		model.addAttribute("bonjour", this.bonjour);
		model.addAttribute("espace", this.espace);
		return "Responsable/vue-liste-qcm";
	}
	
	////////////////vueResponsableQcmsInternautes ///////////
	@RequestMapping(value="/vueResponsableQcmsInternautes")
	public String vueResponsableQcmsInternautes(Model model){

		List<Qcm> liste_Qcm = services.qcmLus();	
		model.addAttribute("listeQcms", liste_Qcm);	
		
		model.addAttribute("user", this.user);		
		model.addAttribute("bonjour", this.bonjour);
		model.addAttribute("espace", this.espace);
		return "Responsable/vue-qcm-internaute";
	}
	
	////////////////vueResponsableStatistques ///////////
	@RequestMapping(value="/vueResponsableStatistques")
	public String vueResponsableStatistques(Model model){
		//// a faire
		model.addAttribute("user", this.user);		
		model.addAttribute("bonjour", this.bonjour);
		model.addAttribute("espace", this.espace);
		return "Responsable/vue-statistiques";
	}
	///////////// Fin des vues

	////////////////validationQCM ///////////
	@RequestMapping(value="/validationQCM")
	public String validationQCM(Model model , @RequestParam(value="idQcm") Integer idQcm ,
											  @RequestParam(value="responsableMessageValidationQcm") String responsableMessageValidationQcm ,
											  @RequestParam(value="nouveauEtatQcm") String nouveauEtatQcm){
				
		services.validerQcm(idQcm, nouveauEtatQcm, responsableMessageValidationQcm);			
		List<Qcm> liste_Qcm = services.consulterQcmEnCours();		
		
		String messageListeQcmResponsable;
		if (liste_Qcm.isEmpty()) messageListeQcmResponsable = "Tous les qcm ont été validés";
		else messageListeQcmResponsable = "Liste des Qcm à valider";
		model.addAttribute("messageListeQcmResponsable", messageListeQcmResponsable);	
		model.addAttribute("listeQcms", liste_Qcm);	
		model.addAttribute("user", this.user);		
		model.addAttribute("bonjour", this.bonjour);
		model.addAttribute("espace", this.espace);
		return "Responsable/vue-qcm-non-valides-formulaire";
	}
	/* *****************************************************************************************
	 * *********************************** Action Internaute************************************
	 *******************************************************************************************
	 */
	////////////////
	// Les Vues
	//
	//
	//////////////// vueInternauteCategoriesQcms ///////////
	@RequestMapping(value="/vueInternauteCategoriesQcms")
	public String vueInternauteCategoriesQcms(Model model){

		model.addAttribute("user", this.user);		
		model.addAttribute("bonjour", this.bonjour);
		model.addAttribute("espace", this.espace);
		return "Internaute/vue-categories";
	}
	
	//////////////// vueInternauteMesPoints ///////////
	@RequestMapping(value="/vueInternauteMesPoints")
	public String vueInternauteMesPoints(Model model){
		Internaute internaute = services.getInternaute(this.user.getId());
		this.user = internaute;
		internaute.show();
		Integer total = internaute.total();
		System.out.println("total: "+total);
		
		model.addAttribute("total", total);		
		model.addAttribute("user", this.user);		
		model.addAttribute("bonjour", this.bonjour);
		model.addAttribute("espace", this.espace);
		return "Internaute/vue-points-internaute";
	}

	//////////////// vueInternauteRecompenses ///////////
	@RequestMapping(value="/vueInternauteRecompenses")
	public String vueInternauteRecompenses(Model model){
	
		model.addAttribute("user", this.user);		
		model.addAttribute("bonjour", this.bonjour);
		model.addAttribute("espace", this.espace);
		return "Internaute/vue-recompenses-internaute";
	}

	//////////////// vueInternauteClassement ///////////
	@RequestMapping(value="/vueInternauteClassement")
	public String vueInternauteClassement(Model model){
		
		List<Internaute> liste = services.consulterInternautes();
		Collections.reverse(liste);	
		
		for(Internaute inter: liste) {
			if(inter.getId() == this.user.getId()) inter.setPrenom("#AFE6B1"); // on stock la couleur vers ou rien dans la propriété nom inutilisé dans la vue
			else inter.setNom("");
			inter.setTotal(inter.total());
		}
		
		
		model.addAttribute("liste_internautes", liste);		
		model.addAttribute("user", this.user);		
		model.addAttribute("bonjour", this.bonjour);
		model.addAttribute("espace", this.espace);
		return "Internaute/vue-classement-internaute";
	}
	
	////////////////vueRepondreQcm ///////////
	@RequestMapping(value="/vueRepondreQcm")
	public String vueRepondreQcm(Model model, @RequestParam(value="idQcm") Integer idQcm){
		
		Qcm q = services.getQcm(idQcm);
		QcmInternaute qcm = new QcmInternaute(q);
		
		model.addAttribute("qcm", qcm);
		model.addAttribute("user", this.user);		
		model.addAttribute("bonjour", this.bonjour);
		model.addAttribute("espace", this.espace);
		return "Internaute/vue-repondre-qcm";
	}
	
	////////////////listeQcmByCategorie ///////////
	@RequestMapping(value="/listeQcmByCategorie")
	public String listeQcmByCategorie(Model model , @RequestParam(value="categorie") String categorie){
		
		String messageListeQcmInternaute;

		List<Qcm> liste_Qcm = services.consulterQcmByCategorie(categorie);
		if (liste_Qcm.isEmpty()) messageListeQcmInternaute = "Les Qcm de la cat�gorie "+categorie+" sont en cours de cr�ation";
		else messageListeQcmInternaute = "Liste Qcm de la cat�gorie "+categorie;
		model.addAttribute("messageListeQcmInternaute", messageListeQcmInternaute);	
		model.addAttribute("listeQcms", liste_Qcm);	
		
		model.addAttribute("user", this.user);		
		model.addAttribute("bonjour", this.bonjour);
		model.addAttribute("espace", this.espace);
		return "Internaute/vue-liste-qcm";
	}
	
	//////////////// repondreQcm ///////////
	@RequestMapping(value="/repondreQcm")
	public String repondreQcm(Model model , @RequestParam(value="idQcm") Integer idQcm,
											@RequestParam(value="bnrs") Map<String, String> bnrs){
		
		Qcm qcm = services.getQcm(idQcm);  /// il faut inscr�menter qcm.internaute

		List<String> reponsesInternaute = new ArrayList<String>();
		
		for(Questionnaire quest: qcm.getQuestionnaires()) {
			reponsesInternaute.add(bnrs.get(""+quest.getId()));
		}

		services.repondreQcm(qcm, this.user.getId(), reponsesInternaute);
		this.user = services.getInternaute(this.user.getId());
		model.addAttribute("user", this.user);		
		model.addAttribute("bonjour", this.bonjour);
		model.addAttribute("espace", this.espace);
		//return "Internaute/vue-reponses";
		return listeQcmByCategorie(model, "Science");
	}
}
