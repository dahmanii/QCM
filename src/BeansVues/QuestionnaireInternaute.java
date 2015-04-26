package BeansVues;

import java.util.ArrayList;
import java.util.List;

import dao.Entites.*;


public class QuestionnaireInternaute {
	private Integer id;
	private String question;
	private Integer label;
	private List<Choice> choices = new ArrayList<Choice>();
	
	public QuestionnaireInternaute() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuestionnaireInternaute(Questionnaire quest) {
		super();
		this.id = quest.getId();
		this.question = quest.getQuestion();	
		
		for(Choice c: quest.getChoices())
			ajouterChoice(c);
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
	public List<Choice> getChoices() {
		return choices;
	}
	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}
	public void ajouterChoice(Choice choice){
		choices.add(choice);
	}
	
	public Integer getLabel() {
		return label;
	}
	public void setLabel(Integer label) {
		this.label = label;
	}
	public void show(){
		System.out.println("		id_QUESTIONNAIRE: "+this.id);
		System.out.println("		question_QUESTIONNAIRE: "+this.question);
		int i=1;
		System.out.println("Nombre de choix: "+this.choices.size());
		for(Choice choix: this.choices) {
			System.out.println("		CHOIX "+i++);
			choix.show();
		}
	}
}
