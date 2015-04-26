package dao.Implementations;
import dao.Interfaces.EmployeDAO;
import dao.Entites.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;

public class EmployeImpl implements EmployeDAO {

	@Override
	public void init() {
		System.out.println("init EmployeImpl");
	}

	@Override
	public Integer ajouterQcm(Qcm q) {
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
		Questionnaire quest = new Questionnaire();
		Choice c = new Choice();
		for(Questionnaire questionnaire: q.getQuestionnaires()){
			for(Choice choix: questionnaire.getChoices()){
				c = (Choice) session.load(Choice.class, choix.getId());
				session.delete(c);
			}
			quest = (Questionnaire) session.load(Questionnaire.class, questionnaire.getId());
			session.delete(quest);
		}
		session.delete(q);
		session.getTransaction().commit();

	}
	
	@Override
	public void supprimerQuestionnaire(Integer idQcm, Integer idQuestionnaire) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		Qcm qcm = (Qcm) session.load(Qcm.class, idQcm);
		Questionnaire questionnaire = qcm.getQuestionnaireById(idQuestionnaire);
		qcm.getQuestionnaires().remove(questionnaire);
		//System.out.println("id questionnaire dans supprimerQuestionnaire: " + questionnaire.getId() + " // idQuestionnaire = "+idQuestionnaire);
		for(Choice choix: questionnaire.getChoices()){
			session.delete(choix);
		}		
		session.delete(questionnaire);
		session.update(qcm);
		//session.flush();
		session.getTransaction().commit();
		//ssession.close();
	}

	@Override
	public void modifierQcm(Qcm q) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		q.show();
		
		Qcm qcm = (Qcm) session.load(Qcm.class, q.getId());	
		qcm.setQcm(q);

		session.save(qcm);
		session.getTransaction().commit();
	}
	
	@Override
	public void mettreQcmEnLigne(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		
		
		Qcm qcm = (Qcm) session.load(Qcm.class, id);
		qcm.setEtat("en ligne");

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
	public void ajouterQuestionnaireAQcm(Questionnaire questionnaire, Integer idQcm) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Qcm qcm = (Qcm) session.load(Qcm.class, idQcm);
		
		qcm.getQuestionnaires().add(questionnaire);
		session.update(qcm);
		session.save(questionnaire);

		for(Choice c: questionnaire.getChoices()) session.save(c);
		session.getTransaction().commit();
	}

	@Override
	public Integer ajouterChoice(Choice choice) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(choice);
		session.getTransaction().commit();
		return id;
	}

	@Override
	public void ajouterChoiceAQuestionnaire(Integer idChoice, Integer idQuestionnaire) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Choice choice = (Choice) session.load(Choice.class, idChoice);
		Questionnaire qst = (Questionnaire) session.load(Questionnaire.class, idQuestionnaire);
		
		qst.getChoices().add(choice);
		session.getTransaction().commit();		
	}

	@Override
	public void supprimerChoicesByIdQcm(Integer idQcm) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		String requete = "from Choice where idQcm='" + idQcm + "'";
		List<Choice> liste = session.createQuery(requete).list();
		for(Choice q: liste) session.delete(q);
		session.getTransaction().commit();	
	}

	@Override
	public void supprimerQuestionnairesByIdQcm(Integer idQcm) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		String requete = "from Questionnaire where idQcm='" + idQcm + "'";
		List<Questionnaire> liste = session.createQuery(requete).list();
		for(Questionnaire q: liste) session.delete(q);
		session.getTransaction().commit();	
	}

	@Override
	public void modifierQuestionnaire(Questionnaire questionnaire) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Questionnaire QUEST = (Questionnaire) session.load(Questionnaire.class, questionnaire.getId());
		//on vide les anciens choix du questionnaire:
		
		for(Choice c: QUEST.getChoices()) {
			session.delete(c);
		}
		//QUEST.setChoices(new ArrayList<Choice>());
		
		QUEST.setChoices(questionnaire.getChoices());
		QUEST.setQuestion(questionnaire.getQuestion());
				
		for(Choice c: QUEST.getChoices()) session.save(c);
		
		session.update(QUEST);
		session.getTransaction().commit();
	}

	@Override
	public List<Qcm> mesQcmLus(Integer idEmp) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String requete = "from Qcm as qcm where qcm.internautes > 0 and qcm.idEmp = '"+idEmp+"'";
		return session.createQuery(requete).list();
	}
	
}
