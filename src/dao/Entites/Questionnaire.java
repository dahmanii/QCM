package dao.Entites;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;


public class Questionnaire {
	private Integer id;
	private String question;
	private List<Choice> choices = new ArrayList<Choice>();
	
	public Questionnaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Questionnaire(String question) {
		super();
		this.question = question;	
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
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.question = questionnaire.getQuestion();
		this.choices = questionnaire.getChoices();

	}

	public void ajouterChoice(Choice choice){
		choices.add(choice);
	}
	public void viderChoice(){
		setChoices(new ArrayList<Choice>());;
	}
	public void addChoices( String[] choix, Integer[] bnrs) {		
		viderChoice();

		Vector<Integer> listeBnrs = new Vector<Integer>();
		for(Integer i:bnrs) System.out.println("bnrs dans questionnaire: "+i);
		for(Integer I:bnrs) listeBnrs.add(I);  

		int ascii = 65; // code de la lettre A
		for(int i =0; i< choix.length; i++) {
			if(!choix[i].isEmpty()) {
				if(listeBnrs.contains( new Integer(i) )) {
					choices.add(new Choice(choix[i], Character.toString ((char) ascii++) , new Integer(1)));
				}
				else choices.add(new Choice(choix[i], Character.toString ((char) ascii++) , new Integer(0)));
			}				
		}		
	}
	
	public void addChoices( Vector<String> choix, Vector<Integer> bnrs) {
		viderChoice();

		int ascii = 65; 
		for(int i=0; i< choix.size(); i++) {
			if(!choix.get(i).isEmpty()) {
				if(bnrs.contains( new Integer(i) )) {
					choices.add(new Choice(choix.get(i), Character.toString ((char) ascii++) , new Integer(1)));
				}
				else choices.add(new Choice(choix.get(i), Character.toString ((char) ascii++) , new Integer(0)));
			}				
		}
	}
	
	public void show(){
		System.out.println("		id_QUESTIONNAIRE: "+this.id);
		System.out.println("		question_QUESTIONNAIRE: "+this.question);
		int i=1;
		for(Choice choix: this.choices) {
			System.out.println("		CHOIX "+i++);
			choix.show();
		}
	}
}
