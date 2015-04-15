package dao.Implementations;
import dao.Interfaces.QcmDAO;
import dao.Entites.*;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;

public class QcmImpl implements QcmDAO {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("init QcmImpl");
	}

	@Override
	public void ajouterUtilisateur(Utilisateur user) {
		// TODO Auto-generated method stub
		System.out.println( "     debut ajouterUtilisateur qcmImpl ");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		System.out.println( "     objet session crée ");
		session.beginTransaction();
		System.out.println( "     beginTransaction terminé ");
		Integer id = (Integer) session.save(user);
		System.out.println( "     user ajouté");
		System.out.println("nouveau id utilisateur: "+id);
		session.getTransaction().commit();
	}

	@Override
	public Employe getEmploye(Integer id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		
		Employe user = (Employe) session.load(Employe.class, id);
		return user;
	}
	
	@Override
	public Internaute getInternaute(Integer id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		
		Internaute user = (Internaute) session.load(Internaute.class, id);
		return user;
	}

	@Override
	public Responsable getResponsable(Integer id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		
		Responsable user = (Responsable) session.load(Responsable.class, id);
		return user;
	}

	@Override
	public List<Employe> empDejaEnregistre(String identifiant, String password) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		String requete = "from Employe where identifiant = '" + identifiant + "' and password = '" + password  +"'  and role = 'Employé d''entreprise'";
		List<Employe> liste = session.createQuery(requete).list();
		return liste;
	}

	@Override
	public List<Responsable> respDejaEnregistre(String identifiant,
			String password) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		String requete = "from Responsable where identifiant = '" + identifiant + "' and password = '" + password  +"'  and role = 'Responsable technique'";
		List<Responsable> liste = session.createQuery(requete).list();
		System.out.println("Affichage des users");
		for(Responsable u:liste) u.show();
		return liste;
	}

	@Override
	public List<Internaute> internauteDejaEnregistre(String identifiant,
			String password) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		String requete = "from Internaute where identifiant = '" + identifiant + "' and password = '" + password  +"'  and role = 'Internaute'";
		List<Internaute> liste = session.createQuery(requete).list();
		System.out.println("Affichage des users");
		for(Internaute u:liste) u.show();
		return liste;
	}

	@Override
	public Qcm getQcm(Integer id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		
		Qcm qcm = (Qcm) session.load(Qcm.class, id);
		return qcm;
	}
}
