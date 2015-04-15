package controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.Entites.*;
import services.QcmMetier;

@Controller
public class QcmController {

	@Autowired         
	QcmMetier services;    // services est un interface: spring, grace à @Autowired, lui associe une instanciation des l'objet qcmService définit dans spring-beans.xml
	int compteurQuestionnaires=0;
	@RequestMapping(value="/sidentifier")
	public String sidentifier(Model model){
		return "sidentifier";
	}
	
	@RequestMapping(value="/seDeconnecter")
	public String seDeconnecter(Model model){	
		return "sidentifier";
	}
	
	@RequestMapping(value="/authentification")
	public String sidentifier(Model model ,
							  @RequestParam(value="identifiant") String identifiant,
							  @RequestParam(value="password") String password){
		String message = "";
		System.out.println("Avant chargement des 3 types users");
		List<Employe> listeEmp = (List<Employe>) services.empDejaEnregistre(identifiant, password);
		List<Responsable> listeResp = (List<Responsable>) services.respDejaEnregistre(identifiant, password);
		List<Internaute> listeInternaute = (List<Internaute>) services.internauteDejaEnregistre(identifiant, password);
		System.out.println("Apres chargement des 3 types users");
		String espace;
		String bonjour;
		
		if(!listeEmp.isEmpty()){
			
			Employe userEmp = listeEmp.get(0);
			espace = "Espace Employé";
			bonjour = "Bonjour "+userEmp.getNom() +" "+ userEmp.getPrenom();
			
			
			model.addAttribute("espace", espace);
			model.addAttribute("bonjour", bonjour);
			model.addAttribute("compteurQuestionnaires", compteurQuestionnaires);
			model.addAttribute("user", userEmp);
			model.addAttribute("qcm", new Qcm());
			
			List<Qcm> liste_Qcm = services.consulterQcm(userEmp.getId());
			model.addAttribute("listeQcms", liste_Qcm);
			if(liste_Qcm.isEmpty()) model.addAttribute("displayListeQCM","none");
			else  model.addAttribute("displayListeQCM","bloc");			
			model.addAttribute("displayAjouterQCM","bloc");
			model.addAttribute("displayModifierQCM","none");			
			model.addAttribute("displayAjouterlibelleQcm","bloc");
			model.addAttribute("displaylibellelabelQcm","none");
			return "espace-employe";
			
		}else if(!listeResp.isEmpty()) {
			Responsable userResp = listeResp.get(0);
			espace = "Espace Responsable technique";
			bonjour = "Bonjour "+userResp.getNom() +" "+ userResp.getPrenom();
			model.addAttribute("espace", espace);
			model.addAttribute("bonjour", bonjour);
			model.addAttribute("user", userResp);
			return "espace-responsable";
			
		}else if(!listeInternaute.isEmpty()){
			Internaute userInternaute = listeInternaute.get(0);
			espace = "Espace Internaute";
			bonjour = "Bonjour "+userInternaute.getNom() +" "+ userInternaute.getPrenom() ;
			bonjour += ", votre date de naissance est:  " + userInternaute.getDateNaissance() ;
			model.addAttribute("espace", espace);
			model.addAttribute("bonjour", bonjour);
			model.addAttribute("user", userInternaute);
			//model.addAttribute("listeQcms", services.consulterQcm());
			return "espace-internaute";
			
		}else {
			message = "Identifiant ou mot de pass incorrect, réessayer!";
			
			//compteur++;
			//model.addAttribute("compteur", compteur);//test
			model.addAttribute("message", message);
			return "sidentifier";
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
		System.out.println("Debut nouveauUser");
		if(role.equals("Employe")) {
			System.out.println("Debut if employe");
			Employe emp = new Employe(nom, prenom, identifiant, password);
			System.out.println("Debut if employeobjet employe cree");
			System.out.println("ajout utilisateur");
			services.ajouterUtilisateur(emp);
			System.out.println("utilisateur ajouté ");
			model.addAttribute("user", emp);
			System.out.println("model ajouté ");
			
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

		return "sidentifier";
	}
	
	@RequestMapping(value="/nouveauQcm")
	public String nouveauQCM(Model model, @RequestParam(value="idQcm") Integer idQcm,
									      @RequestParam(value="idEmp") Integer idEmp,
										  @RequestParam(value="newQcm") String newQcm,
										  @RequestParam(value="espace") String espace,
										  @RequestParam(value="bonjour") String bonjour,
										  @RequestParam(value="question") String question,
										  @RequestParam(value="choix1") String choix1,
										  @RequestParam(value="choix2") String choix2,
										  @RequestParam(value="choix3") String choix3,
										  @RequestParam(value="choix4") String choix4,
										  @RequestParam(value="categorie") String categorie,
										  @RequestParam(value="libelle") String libelle,
										  @RequestParam(value="bnrs") String[] bnrs ){
		System.out.println("---------------- Debut Test /nouveauQcm dans le controller -------------");
		System.out.println("categorie: "+categorie);
		System.out.println("idEmp: "+idEmp);
		System.out.println("idQcm: "+idQcm);
		
		Employe user = services.getEmploye(idEmp);
		Qcm qcm;
		Questionnaire questionnaire;
		Integer idQuestionnaire;
		Integer idBnr;
		
		if(compteurQuestionnaires == 0){
			String dateCreation;
		    DateTime dt = new DateTime();
			 /* Conversion de la date en String selon le format défini */
	        DateTimeFormatter formatter = DateTimeFormat.forPattern( "dd/MM/yyyy HH:mm:ss" );
	        dateCreation = dt.toString( formatter );
	        qcm = new Qcm(categorie, libelle, dateCreation, idEmp);
	        idQcm = services.ajouterQcm(qcm);
	        System.out.println("conteur: "+compteurQuestionnaires+" idQcm: "+idQcm);
		}else{
			qcm = services.getQcm(idQcm);
			idQcm = qcm.getId();
		}
	    
        
        questionnaire = new Questionnaire(question, choix1, choix2, choix3, choix4);
        //questionnaire.show();  
        idQuestionnaire = services.ajouterQuestionnaire(questionnaire);
        
        for(String s:bnrs){
        	idBnr = services.ajouterBonneReponse(new BonneRep(s));
        	services.ajouterBonneReponseAQuestionnaire(idBnr, idQuestionnaire);
        }
       
        services.ajouterQuestionnaireAQcm(idQuestionnaire, idQcm);
        
		List<Qcm> liste_Qcm = services.consulterQcm(idEmp);
		model.addAttribute("listeQcms", liste_Qcm);
		if(liste_Qcm.isEmpty()) model.addAttribute("displayListeQCM","none");
		else  model.addAttribute("displayListeQCM","bloc");
		
		
		
		model.addAttribute("user", user);		
		model.addAttribute("bonjour", bonjour);
		model.addAttribute("espace", espace);
		
		model.addAttribute("displayAjouterQCM","bloc");
		model.addAttribute("displayModifierQCM","none");
			
		if(newQcm.equals("questionnaire_suivant")){
			compteurQuestionnaires++;
			model.addAttribute("questionnaire", questionnaire);
			model.addAttribute("qcm", qcm);
			model.addAttribute("compteurQuestionnaires", compteurQuestionnaires);
			model.addAttribute("displayAjouterlibelleQcm","none");
			model.addAttribute("displaylibellelabelQcm","bloc");
		}else{
			compteurQuestionnaires=0;
			model.addAttribute("compteurQuestionnaires", compteurQuestionnaires);
			model.addAttribute("displayAjouterlibelleQcm","bloc");
			model.addAttribute("displaylibellelabelQcm","none");
		}
		
		
		System.out.println("---------------- Fin Test /nouveauQcm dans le controller -------------\n\n");
		return "espace-employe";
	}
	
	/*
	 @RequestMapping(value="/nouveauQcm")
	public String nouveauQCM(Model model, @RequestParam(value="idEmp") Integer idEmp,
										  @RequestParam(value="espace") String espace,
										  @RequestParam(value="bonjour") String bonjour,
										  @RequestParam(value="question") String question,
										  @RequestParam(value="choix1") String choix1,
										  @RequestParam(value="choix2") String choix2,
										  @RequestParam(value="choix3") String choix3,
										  @RequestParam(value="choix4") String choix4,
										  @RequestParam(value="etat") String etat,
										  @RequestParam(value="bnrs") String[] bnrs ){

		System.out.println("---------------- Debut Test /nouveauQcm dans le controller -------------");
		
		Employe user = services.getEmploye(idEmp);
		
	    String dateCreation;
	    DateTime dt = new DateTime();
		 /* Conversion de la date en String selon le format défini 
        DateTimeFormatter formatter = DateTimeFormat.forPattern( "dd/MM/yyyy HH:mm:ss" );
        dateCreation = dt.toString( formatter );
        
        //Qcm qcm = new Qcm(dateCreation, question, idEmp, choix1, choix2, choix3, choix4, bnrs[0]);
        Qcm qcm = new Qcm(libelle, dateCreation, idEmp);
        qcm.setEtat(etat);
		services.ajouterQcm(qcm);
		
		List<Qcm> liste_Qcm = services.consulterQcm(idEmp);
		model.addAttribute("listeQcms", liste_Qcm);
		if(liste_Qcm.isEmpty()) model.addAttribute("displayListeQCM","none");
		else  model.addAttribute("displayListeQCM","bloc");
		
		model.addAttribute("qcm", qcm);
		model.addAttribute("user", user);		
		model.addAttribute("bonjour", bonjour);
		model.addAttribute("espace", espace);
		
		model.addAttribute("displayAjouterQCM","bloc");
		model.addAttribute("displayModifierQCM","none");
	
		System.out.println("---------------- Fin Test /nouveauQcm dans le controller -------------\n\n");
		return "espace-employe";
	}
	 
	 */
	
	
	@RequestMapping(value="/supprimerQCM")
	public String supprimerQCM(Model model, @RequestParam(value="id") Integer id,
											@RequestParam(value="idEmp") Integer idEmp){
		System.out.println("\n\n");
		System.out.println("---------------- Debut Test /supprimer dans le controller -------------");
		System.out.println("idEmp : "+idEmp);
		
		Employe user = services.getEmploye(idEmp);
		
		user.show();
		System.out.println("id QCMMMMMM: "+id);
		
		//services.supprimerQcm(id); 	
		String espace = "Espace Employé";
		String bonjour  = "Bonjour "+user.getNom() +" "+ user.getPrenom();
		
		List<Qcm> liste_Qcm = services.consulterQcm(idEmp);
		model.addAttribute("listeQcms", liste_Qcm);
		if(liste_Qcm.isEmpty()) model.addAttribute("displayListeQCM","none");
		else  model.addAttribute("displayListeQCM","bloc");		
		
		model.addAttribute("user", user);
		model.addAttribute("espace", espace);
		model.addAttribute("bonjour", bonjour);
		model.addAttribute("displayAjouterQCM","bloc");
		model.addAttribute("displayModifierQCM","none");
		model.addAttribute("displayAjouterlibelleQcm","bloc");
		model.addAttribute("displaylibellelabelQcm","none");
		System.out.println("---------------- Fin Test /supprimer dans le controller -------------");
		//System.out.println("\n\n");
		
		return "espace-employe";
	}
	
	@RequestMapping(value="/modifierQcm")
	public String modifierQCM(Model model, Qcm qcm , @RequestParam(value="espace") String espace ,
													 @RequestParam(value="bonjour") String bonjour){
		
		qcm.show();
		services.modifierQcm(qcm); 
		
		Employe user = services.getEmploye(qcm.getIdEmp());
				
		List<Qcm> liste_Qcm = services.consulterQcm(qcm.getIdEmp());
		model.addAttribute("listeQcms", liste_Qcm);
		if(liste_Qcm.isEmpty()) model.addAttribute("displayListeQCM","none");
		else  model.addAttribute("displayListeQCM","bloc");
		
		model.addAttribute("espace", espace);	
		model.addAttribute("bonjour", bonjour);	
		model.addAttribute("user", user);	
		model.addAttribute("displayAjouterQCM","bloc");
		model.addAttribute("displayModifierQCM","none");
		return "espace-employe";
	}
	
	@RequestMapping(value="/modification")
	public String modification(Model model, Qcm qcm, @RequestParam(value="espace") String espace ,
			  										 @RequestParam(value="bonjour") String bonjour,
			  										 @RequestParam(value="modifier") String modifier ){
		qcm.show();
		Employe user = services.getEmploye(qcm.getIdEmp());		
		List<Qcm> liste_Qcm = services.consulterQcm(qcm.getIdEmp());
		model.addAttribute("listeQcms", liste_Qcm);
		if(liste_Qcm.isEmpty()) model.addAttribute("displayListeQCM","none");
		else  model.addAttribute("displayListeQCM","bloc");		
		model.addAttribute("user", user);
		model.addAttribute("espace", espace);
		model.addAttribute("bonjour", bonjour);
		if(modifier.equals("modifier")){			
			model.addAttribute("qcm", qcm);			
			model.addAttribute("displayAjouterQCM","none");
			model.addAttribute("displayModifierQCM","bloc");
		}else if(modifier.equals("mettre en ligne")){
			services.mettreQcmEnLigne(qcm.getId()); 		
			model.addAttribute("displayAjouterQCM","bloc");
			model.addAttribute("displayModifierQCM","none");
		}
		return "espace-employe";
	}
	// --------------------------------  Partie Internaute  ----------------------------------
	@RequestMapping(value="/afficherQcmInternauteByCategorie")
	public String afficherQcmInternauteByCategorie(Model model , @RequestParam(value="id") Integer idInter ,
													  			 @RequestParam(value="categorie") String categorie ,
													  			 @RequestParam(value="espace") String espace ,
													  			 @RequestParam(value="bonjour") String bonjour){
		String messageListeQcmInternaute;
		Internaute user = services.getInternaute(idInter);
		List<Qcm> liste_Qcm = services.consulterQcmByCategorie(categorie);
		if (liste_Qcm.isEmpty()) messageListeQcmInternaute = "Les Qcm de la catégorie "+categorie+" sont en cours de création";
		else messageListeQcmInternaute = "Liste des Qcm de la catégorie "+categorie;
		model.addAttribute("messageListeQcmInternaute", messageListeQcmInternaute);	
		model.addAttribute("listeQcms", liste_Qcm);	
		model.addAttribute("user", user);
		model.addAttribute("espace", espace);
		model.addAttribute("bonjour", bonjour);
		return "espace-internaute";
	}
	
	// --------------------------------  Partie Responsable  ----------------------------------
	@RequestMapping(value="/afficherQcmResponsable")
	public String afficherQcmResponsable(Model model , @RequestParam(value="id") Integer idRespons ,
													   @RequestParam(value="espace") String espace ,
													   @RequestParam(value="bonjour") String bonjour){
		
		String messageListeQcmResponsable;
		Responsable user = services.getResponsable(idRespons);
		
		List<Qcm> liste_Qcm = services.consulterQcmEnCours();
		
		if (liste_Qcm.isEmpty()) messageListeQcmResponsable = "Tous les qcm ont été validés";
		else messageListeQcmResponsable = "Liste des Qcm à valider";
		model.addAttribute("messageListeQcmResponsable", messageListeQcmResponsable);	
		model.addAttribute("listeQcms", liste_Qcm);	
		model.addAttribute("user", user);
		model.addAttribute("espace", espace);
		model.addAttribute("bonjour", bonjour);
		return "espace-responsable";
	}
	@RequestMapping(value="/validationQCM")
	public String validationQCM(Model model , @RequestParam(value="idQcm") Integer idQcm ,
											  @RequestParam(value="id") Integer idResp ,
											  @RequestParam(value="responsableMessageValidationQcm") String responsableMessageValidationQcm ,
											  @RequestParam(value="nouveauEtatQcm") String nouveauEtatQcm ,
											  @RequestParam(value="espace") String espace ,
											  @RequestParam(value="bonjour") String bonjour){
		
		String messageListeQcmResponsable;
		
		Responsable user = services.getResponsable(idResp);
		services.validerQcm(idQcm, nouveauEtatQcm, responsableMessageValidationQcm);
		
		
		List<Qcm> liste_Qcm = services.consulterQcmEnCours();
		
		
		if (liste_Qcm.isEmpty()) messageListeQcmResponsable = "Tous les qcm ont été validés";
		else messageListeQcmResponsable = "Liste des Qcm à valider";
		model.addAttribute("messageListeQcmResponsable", messageListeQcmResponsable);	
		model.addAttribute("listeQcms", liste_Qcm);	
		model.addAttribute("user", user);
		model.addAttribute("espace", espace);
		model.addAttribute("bonjour", bonjour);
		return "espace-responsable";
	}
}
