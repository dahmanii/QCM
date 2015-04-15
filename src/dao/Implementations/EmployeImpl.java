package dao.Implementations;
import dao.Interfaces.EmployeDAO;
import dao.Entites.*;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;

public class EmployeImpl implements EmployeDAO {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("init EmployeImpl");
	}

	@Override
	public Integer ajouterQcm(Qcm q) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Integer idQcm = (Integer)session.save(q);
		session.getTransaction().commit();
		return idQcm;
	}

	@Override
	public void supprimerQcm(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		Qcm q = (Qcm) session.load(Qcm.class, id);
		System.out.println("QCM à supprimer dans EmployeImpl, (id = " + id + "):");
		q.show();
		session.delete(q);
		session.getTransaction().commit();

	}

	@Override
	public void modifierQcm(Qcm q) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		
		System.out.println("Dans modifierQcm / EmployeImpl");
		System.out.println("QCM: ");q.show();
		
		Qcm qcm = (Qcm) session.load(Qcm.class, q.getId());	qcm.show();
		qcm.setQcm(q);
		qcm.show();
		session.save(qcm);
		session.getTransaction().commit();
	}
	
	@Override
	public void mettreQcmEnLigne(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		
		System.out.println("Dans mettreQcmEnLigne / EmployeImpl");
		System.out.println("id QCM: "+id);
		
		Qcm qcm = (Qcm) session.load(Qcm.class, id);	System.out.println("QCM: ");qcm.show();
		qcm.setEtat("en ligne");
		System.out.println("QCM en ligne: ");qcm.show();
		qcm.show();
		session.save(qcm);
		session.getTransaction().commit();
	}

	@Override
	public Qcm consulterQcmById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		Qcm p = (Qcm) session.load(Qcm.class, id);
		return p;
	}

	@Override
	public List<Qcm> consulterQcm(Integer idEmp) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		String requete = "from Qcm where idEmp='" + idEmp + "'";
		return session.createQuery(requete).list();
	}

	@Override
	public Integer ajouterQuestionnaire(Questionnaire questionnaire) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(questionnaire);
		session.getTransaction().commit();
		return id;
	}

	@Override
	public Integer ajouterBonneReponse(BonneRep bonneRep) {		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(bonneRep);
		session.getTransaction().commit();
		return id;
	}

	@Override
	public void ajouterBonneReponseAQuestionnaire(Integer idBnr, Integer idQuestionnaire) {	
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		BonneRep bnr = (BonneRep) session.load(BonneRep.class, idBnr);
		Questionnaire qst = (Questionnaire) session.load(Questionnaire.class, idQuestionnaire);
		
		qst.getBonneReps().add(bnr);
		session.getTransaction().commit();
	}
	
	@Override
	public void ajouterQuestionnaireAQcm(Integer idQuestionnaire, Integer idQcm) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Qcm qcm = (Qcm) session.load(Qcm.class, idQcm);
		Questionnaire qst = (Questionnaire) session.load(Questionnaire.class, idQuestionnaire);
		
		qcm.getQuestionnaires().add(qst);
		session.getTransaction().commit();
	}

}
