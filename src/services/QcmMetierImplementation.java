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
	public void modifierQcm(Qcm q) {
		employeDao.modifierQcm(q);
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

	@Override
	public Integer ajouterQuestionnaire(Questionnaire questionnaire){
		return employeDao.ajouterQuestionnaire(questionnaire);
	}
	@Override
	public Integer ajouterBonneReponse(BonneRep bonneRep) {
		return employeDao.ajouterBonneReponse(bonneRep);
	}

	@Override
	public void ajouterBonneReponseAQuestionnaire(Integer idBnr, Integer idQuestionnaire) {
		employeDao.ajouterBonneReponseAQuestionnaire(idBnr, idQuestionnaire);
	}

	@Override
	public void ajouterQuestionnaireAQcm(Integer idQuestionnaire, Integer idQcm) {
		employeDao.ajouterQuestionnaireAQcm(idQuestionnaire, idQcm);
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

	
	
}
