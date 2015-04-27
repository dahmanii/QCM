package dao.Interfaces;
import dao.Entites.*;

import java.util.List;

public interface InternauteDAO {
	
	public void init();
	
	public List<Qcm> consulterQcmByCategorie(String categorie);
	
	public void repondreQcm(Qcm qcm, Integer idInternaute, Integer noteQcm);

	public List<Internaute> consulterInternautes();
	
}
