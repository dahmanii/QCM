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

}
