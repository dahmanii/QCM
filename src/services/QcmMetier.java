package services;

import java.util.Iterator;

import java.util.List;

import dao.Entites.*;

public interface QcmMetier {
	
	public void ajouterUtilisateur(Utilisateur user);
	public Employe getEmploye(Integer id);
	public Internaute getInternaute(Integer id);
	public Responsable getResponsable(Integer id);
	public List<Employe> empDejaEnregistre(String identifiant, String password);
	public List<Responsable> respDejaEnregistre(String identifiant, String password);
	public List<Internaute> internauteDejaEnregistre(String identifiant, String password);
	
	public Integer ajouterChoice(Choice choice);	
	public void ajouterChoiceAQuestionnaire(Integer idChoice, Integer idQuestionnaire);	

	//public Integer ajouterQuestionnaire(Questionnaire questionnaire);
	public void ajouterQuestionnaireAQcm(Questionnaire questionnaire, Integer idQcm);
	public void modifierQuestionnaire(Questionnaire questionnaire);
	
	public Questionnaire getQuestionnaire(Integer id);
	
	public void supprimerChoicesByIdQcm(Integer IdQcm);
	public void supprimerQuestionnairesByIdQcm(Integer IdQcm);
	
	public Integer ajouterQcm(Qcm q);
	public void supprimerQcm(Integer id);
	public void supprimerQuestionnaire(Integer idQcm, Integer idQuestionnaire);
	
	public void modifierQcm( Qcm qcm, Integer[] idQuestionnaires, String[] question, String[] choix, String[] bnrs);
	public void mettreQcmEnLigne( Integer id);
	public Qcm consulterQcmById(Integer id);
	public List<Qcm> consulterQcm(Integer idEmp);
	public List<Qcm> consulterQcm();
	
	public List<Qcm> consulterQcmByCategorie(String categorie);
	public Qcm getQcm(Integer idQcm);
	public List<Qcm> consulterQcmEnCours();
	
	public void validerQcm(Integer idQcm, String nouveauEtatQcm, String responsableMessageValidationQcm);
	
	public void repondreQcm(Qcm qcm, Integer id, List<String> reponsesInternaute);
	public List<Internaute> consulterInternautes();
	public List<Qcm> mesQcmLus(Integer id);
	public List<Qcm> qcmLus();
	
	
}
