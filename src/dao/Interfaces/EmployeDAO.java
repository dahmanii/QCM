package dao.Interfaces;
import dao.Entites.*;

import java.util.List;

public interface EmployeDAO {
	
	public void init();
	
	public Integer ajouterChoice(Choice choice);	
	public void ajouterChoiceAQuestionnaire(Integer idChoice, Integer idQuestionnaire);	

	//public Integer ajouterQuestionnaire(Questionnaire questionnaire);
	public void ajouterQuestionnaireAQcm(Questionnaire questionnaire, Integer idQcm);

	public Integer ajouterQcm(Qcm q);
	public void supprimerChoicesByIdQcm(Integer idQcm);

	public void supprimerQuestionnairesByIdQcm(Integer idQcm);
	public void supprimerQcm(Integer id);
	public void supprimerQuestionnaire(Integer idQcm, Integer idQuestionnaire);
	
	public void modifierQcm(Qcm qcm);
	public void mettreQcmEnLigne( Integer id);
	public Qcm consulterQcmById(Integer id);
	public List<Qcm> consulterQcm(Integer idEmp);

	public void modifierQuestionnaire(Questionnaire questionnaire);

	public List<Qcm> mesQcmLus(Integer idEmp);



	
}
