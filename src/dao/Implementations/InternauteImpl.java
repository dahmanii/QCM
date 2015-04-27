package dao.Implementations;
import dao.Interfaces.InternauteDAO;
import dao.Entites.*;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;

public class InternauteImpl implements InternauteDAO {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("init InternauteImpl");
	}


	@Override
	public List<Qcm> consulterQcmByCategorie(String categorie) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		String requete = "from Qcm where etat='en ligne' and categorie='"+categorie+"'";
		return session.createQuery(requete).list();
	}


	@Override
	public void repondreQcm(Qcm q, Integer idInternaute, Integer noteQcm) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		//qcm.show();
		
		Qcm qcm = (Qcm) session.load(Qcm.class, q.getId());	
		qcm.setQcm(q);

		session.save(qcm);		
		Internaute inter = (Internaute) session.load(Internaute.class, idInternaute);	
		inter.modifierPoint(noteQcm, qcm.getCategorie());
		session.save(inter);
		session.getTransaction().commit();
	}


	@Override
	public List<Internaute> consulterInternautes() {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		String requete = "from Internaute where role = 'Internaute' order by points";
		return session.createQuery(requete).list();

	}

}
