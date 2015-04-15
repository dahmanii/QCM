package dao.Implementations;
import dao.Interfaces.ResponsableDAO;
import dao.Entites.*;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;

public class ResponsableImpl implements ResponsableDAO {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("init InternauteImpl");
	}


	@Override
	public List<Qcm> consulterQcmEnCours() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		String requete = "from Qcm where etat='en cours'";
		return session.createQuery(requete).list();
	}


	@Override
	public void validerQcm(Integer idQcm, String nouveauEtatQcm, String responsableMessageValidationQcm) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		
		//System.out.println("Dans mettreQcmEnLigne / EmployeImpl");
		//System.out.println("id QCM: "+id);
		
		Qcm qcm = (Qcm) session.load(Qcm.class, idQcm);	
		//System.out.println("QCM: ");qcm.show();
		qcm.setEtat(nouveauEtatQcm);
		qcm.setMessageResponsable(responsableMessageValidationQcm);
		//System.out.println("QCM en ligne: ");qcm.show();
		//qcm.show();
		session.save(qcm);
		session.getTransaction().commit();
	}

}
