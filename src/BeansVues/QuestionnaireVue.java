package BeansVues;

import java.util.ArrayList;

import java.util.List;
import dao.Entites.*;


public class QuestionnaireVue {
	private Integer id;
	private String question;
	private List<ChoiceVue> choices = new ArrayList<ChoiceVue>();
	
	public QuestionnaireVue() {
		super();
	}
	
	public QuestionnaireVue(Questionnaire quest) {
		super();
		this.id = quest.getId();
		this.question = quest.getQuestion();	
		for(Choice c: quest.getChoices())
			ajouterChoice(new ChoiceVue(c));
		int I = 4-this.choices.size();
		for(int i=0; i < I; i++)
			ajouterChoice(new ChoiceVue());
		for(int i=0; i < 4; i++) {
			this.choices.get(i).setLabel(i);
		}
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<ChoiceVue> getChoices() {
		return choices;
	}
	public void setChoices(List<ChoiceVue> choices) {
		this.choices = choices;
	}
	public void ajouterChoice(ChoiceVue choice){
		choices.add(choice);
	}
	
	public void show(){
		System.out.println("		id_QUESTIONNAIRE: "+this.id);
		System.out.println("		question_QUESTIONNAIRE: "+this.question);
		int i=1;
		System.out.println("Nombre de choix: "+this.choices.size());
		for(ChoiceVue choix: this.choices) {
			System.out.println("		CHOIX "+i++);
			choix.show();
		}
	}
}
