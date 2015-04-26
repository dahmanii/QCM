package dao.Interfaces;
import dao.Entites.*;

import java.util.List;

public interface ResponsableDAO {
	
	public void init();
	
	public List<Qcm> consulterQcmEnCours();

	public void validerQcm(Integer idQcm, String nouveauEtatQcm, String responsableMessageValidationQcm);

	public List<Qcm> consulterQcm();

	public List<Qcm> qcmLus();
}
