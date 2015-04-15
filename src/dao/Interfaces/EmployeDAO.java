package dao.Interfaces;
import dao.Entites.*;

import java.util.List;

public interface EmployeDAO {
	
	public void init();
	
	//public void initialiserQcm(Qcm qcm);
	public Integer ajouterBonneReponse(BonneRep bonneRep);	
	public Integer ajouterQuestionnaire(Questionnaire questionnaire);
	public Integer ajouterQcm(Qcm q);
	
	public void ajouterBonneReponseAQuestionnaire(Integer idBnr, Integer idQuestionnaire);	
	public void ajouterQuestionnaireAQcm(Integer idQuestionnaire, Integer idQcm);
	
	public void supprimerQcm(Integer id);
	public void modifierQcm( Qcm q);
	public void mettreQcmEnLigne( Integer id);
	public Qcm consulterQcmById(Integer id);
	public List<Qcm> consulterQcm(Integer idEmp);


	
}
