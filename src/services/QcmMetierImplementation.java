package services;

import java.util.Iterator;
import java.util.List;

import dao.Entites.*;
import dao.Interfaces.*;

public class QcmMetierImplementation implements QcmMetier {
	
	EmployeDAO employeDao;
	QcmDAO qcmDao;
	InternauteDAO internauteDao;
	ResponsableDAO responsableDao;
	
	public QcmMetierImplementation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterUtilisateur(Utilisateur user) {
		qcmDao.ajouterUtilisateur(user);
	}

	@Override
	public Employe getEmploye(Integer id) {
		return qcmDao.getEmploye(id);
	}

	@Override
	public Internaute getInternaute(Integer id) {
		return qcmDao.getInternaute(id);
	}

	@Override
	public Responsable getResponsable(Integer id) {
		return qcmDao.getResponsable(id);
	}

	@Override
	public Integer ajouterQcm(Qcm q) {
		return employeDao.ajouterQcm(q);
	}

	@Override
	public void supprimerQcm(Integer id) {
		employeDao.supprimerQcm(id);
	}
	
	@Override
	public void supprimerQuestionnaire(Integer idQcm, Integer idQuestionnaire) {
		employeDao.supprimerQuestionnaire(idQcm, idQuestionnaire);
	}

	@Override
	public void modifierQcm(Qcm qcm, Integer[] idQuestionnaires, String[] question, String[] choix, String[] bnrs) {
		
		qcm.set2Questionnaires(idQuestionnaires, question, choix, bnrs);
		for(Questionnaire quest: qcm.getQuestionnaires()) modifierQuestionnaire(quest);
		
		employeDao.modifierQcm(qcm);
	}

	@Override
	public Qcm consulterQcmById(Integer id) {
		return employeDao.consulterQcmById(id);
	}

	@Override
	public List<Qcm> consulterQcm(Integer idEmp) {
		return employeDao.consulterQcm(idEmp);
	}
	
	@Override
	public List<Employe> empDejaEnregistre(String identifiant, String password) {
		return qcmDao.empDejaEnregistre(identifiant, password);
	}

	@Override
	public List<Responsable> respDejaEnregistre(String identifiant,
			String password) {
		return qcmDao.respDejaEnregistre(identifiant, password);
	}

	@Override
	public List<Internaute> internauteDejaEnregistre(String identifiant,
			String password) {
		return qcmDao.internauteDejaEnregistre(identifiant, password);
	}

	@Override
	public void mettreQcmEnLigne(Integer id) {
		employeDao.mettreQcmEnLigne(id);
	}

	@Override
	public List<Qcm> consulterQcmByCategorie(String categorie) {
		return internauteDao.consulterQcmByCategorie(categorie);
	}
	/*
	@Override
	public Integer ajouterQuestionnaire(Questionnaire questionnaire){
		return employeDao.ajouterQuestionnaire(questionnaire);
	}*/

	@Override
	public void ajouterQuestionnaireAQcm(Questionnaire questionnaire, Integer idQcm) {
		employeDao.ajouterQuestionnaireAQcm(questionnaire, idQcm);
	}
	
	
	public void setEmployeDao(EmployeDAO employeDao) {
		this.employeDao = employeDao;
	}
	
	public void setQcmDao(QcmDAO qcmDao) {
		this.qcmDao = qcmDao;
	}
	
	public void setInternauteDao(InternauteDAO internauteDao) {
		this.internauteDao = internauteDao;
	}
	public void setResponsableDao(ResponsableDAO responsableDAO) {
		this.responsableDao = responsableDAO;
	}

	@Override
	public Qcm getQcm(Integer idQcm) {
		return qcmDao.getQcm(idQcm);
	}

	@Override
	public List<Qcm> consulterQcmEnCours() {
		return responsableDao.consulterQcmEnCours();
	}

	@Override
	public void validerQcm(Integer idQcm, String nouveauEtatQcm, String responsableMessageValidationQcm) {
		responsableDao.validerQcm(idQcm, nouveauEtatQcm, responsableMessageValidationQcm);
	}

	@Override
	public Integer ajouterChoice(Choice choice) {
		
		return employeDao.ajouterChoice(choice);
	}

	@Override
	public void ajouterChoiceAQuestionnaire(Integer idChoice, Integer idQuestionnaire) {
		employeDao.ajouterChoiceAQuestionnaire(idChoice, idQuestionnaire);
		
	}

	@Override
	public void supprimerChoicesByIdQcm(Integer IdQcm) {
		employeDao.supprimerChoicesByIdQcm(IdQcm);
		
	}

	@Override
	public void supprimerQuestionnairesByIdQcm(Integer IdQcm) {
		employeDao.supprimerQuestionnairesByIdQcm(IdQcm);
		
	}

	@Override
	public Questionnaire getQuestionnaire(Integer id) {
		return qcmDao.getQuestionnaire(id);
	}

	@Override
	public void modifierQuestionnaire(Questionnaire questionnaire) {
		employeDao.modifierQuestionnaire(questionnaire);
	}

	@Override
	public List<Qcm> consulterQcm() {	
		return responsableDao.consulterQcm();
	}

	@Override
	public void repondreQcm(Qcm qcm, Integer id, List<String> reponsesInternaute) {
		Integer internaute = qcm.getInternautes() + 1;
		qcm.setInternautes(internaute);
		
		Integer noteQcm = 0;
		
		for(Questionnaire quest: qcm.getQuestionnaires()){
			for(Choice c: quest.getChoices()) {
				if(reponsesInternaute.get(0).equals(c.getLabel())){
					noteQcm+=c.getBr();
					break;
				}
			}
			reponsesInternaute.remove(0);
		}		
		internauteDao.repondreQcm(qcm, id ,noteQcm);		
	}

	@Override
	public List<Internaute> consulterInternautes() {
		return internauteDao.consulterInternautes();
	}

	@Override
	public List<Qcm> mesQcmLus(Integer idEmp) {
		return employeDao. mesQcmLus(idEmp);
	}

	@Override
	public List<Qcm> qcmLus() {
		return responsableDao. qcmLus();
	}

	
	
}
