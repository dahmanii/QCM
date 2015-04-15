package dao.Interfaces;
import dao.Entites.*;

import java.util.Iterator;
import java.util.List;

public interface QcmDAO {
	
	public void init();
	
	public List<Employe> empDejaEnregistre(String identifiant, String password);
	public List<Responsable> respDejaEnregistre(String identifiant, String password);
	public List<Internaute> internauteDejaEnregistre(String identifiant, String password);
	
	public void ajouterUtilisateur(Utilisateur user);
	public Employe getEmploye(Integer id);
	public Internaute getInternaute(Integer id);
	public Responsable getResponsable(Integer id);

	public Qcm getQcm(Integer idQcm);

	

}
