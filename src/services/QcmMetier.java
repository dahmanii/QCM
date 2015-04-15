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
	
	public Integer ajouterBonneReponse(BonneRep bonneRep);		
	public Integer ajouterQuestionnaire(Questionnaire questionnaire);		
	public void ajouterBonneReponseAQuestionnaire(Integer idBnr, Integer idQuestionnaire);	
	public void ajouterQuestionnaireAQcm(Integer idQuestionnaire, Integer idQcm);
	
	public Integer ajouterQcm(Qcm q);
	public void supprimerQcm(Integer id);
	public void modifierQcm( Qcm q);
	public void mettreQcmEnLigne( Integer id);
	public Qcm consulterQcmById(Integer id);
	public List<Qcm> consulterQcm(Integer idEmp);
	
	public List<Qcm> consulterQcmByCategorie(String categorie);
	public Qcm getQcm(Integer idQcm);
	public List<Qcm> consulterQcmEnCours();
	
	public void validerQcm(Integer idQcm, String nouveauEtatQcm, String responsableMessageValidationQcm);
	
}
