package BeansVues;

import java.util.ArrayList;
import java.util.List;

import dao.Entites.Qcm;
import dao.Entites.Questionnaire;

public class QcmInternaute {
	private Integer id;
	private String libelle;

	private List<QuestionnaireInternaute> questionnaires = new ArrayList<QuestionnaireInternaute>();	
	
	
	public QcmInternaute() {
		super();
	}
	
	public QcmInternaute(Qcm qcm ) {
		super();
		this.id = qcm.getId();
		this.libelle = qcm.getLibelle();
		for(Questionnaire quest: qcm.getQuestionnaires())
		this.questionnaires.add(new QuestionnaireInternaute(quest));
		int i=0;
		for(QuestionnaireInternaute quest: this.questionnaires) quest.setLabel(i++);
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public List<QuestionnaireInternaute> getQuestionnaires() {
		return this.questionnaires;
	}

	public void setQuestionnaires(List<QuestionnaireInternaute> questionnaires) {
		this.questionnaires = questionnaires;
	}	

	public void ajouterQuestionnaireInternaute(QuestionnaireInternaute q){
		this.questionnaires.add(q);
	}

	public void show(){
		System.out.println("----------Qcm------------\n");
		System.out.println("id : "+this.id);		
		System.out.println("libelle : "+this.libelle);	
		for(QuestionnaireInternaute q: this.questionnaires) q.show();

	}
	
}
