package dao.Entites;

import java.util.HashSet;
import java.util.Set;


public class Questionnaire {
	private Integer id;
	private String question;
	private String choix1;
	private String choix2;
	private String choix3;
	private String choix4;
	private Set<BonneRep> bonneReps = new HashSet<BonneRep>();
	
	public Questionnaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Questionnaire(String question, String choix1, String choix2, String choix3, String choix4) {
		super();
		this.question = question;
		this.choix1 = choix1;
		this.choix2 = choix2;
		this.choix3 = choix3;
		this.choix4 = choix4;
		
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
	
	public String getChoix1() {
		return choix1;
	}
	public void setChoix1(String choix1) {
		this.choix1 = choix1;
	}
	public String getChoix2() {
		return choix2;
	}
	public void setChoix2(String choix2) {
		this.choix2 = choix2;
	}
	public String getChoix3() {
		return choix3;
	}
	public void setChoix3(String choix3) {
		this.choix3 = choix3;
	}
	public String getChoix4() {
		return choix4;
	}
	public void setChoix4(String choix4) {
		this.choix4 = choix4;
	}
	public Set<BonneRep> getBonneReps() {
		return bonneReps;
	}
	public void setBonneReps(Set<BonneRep> bonneReps) {
		this.bonneReps = bonneReps;
	}
	
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.question = questionnaire.getQuestion();
		this.choix1 = questionnaire.getChoix1();
		this.choix2 = questionnaire.getChoix2();
		this.choix3 = questionnaire.getChoix3();
		this.choix4 = questionnaire.getChoix4();
		this.bonneReps = questionnaire.getBonneReps();
	}
	
	public void ajouterBonneRep(BonneRep bnr){
		bonneReps.add(bnr);
	}
	
	@Override
	public String toString(){
		String bnrs="";
		for(BonneRep bnr:this.bonneReps) bnrs+=bnr.getBnr()+", ";
		return "id : "+getId()+" - question : " + getQuestion() + " - choix1: " + getChoix1() + " - bonnes réponses: " + bnrs; 
	}
	
	public void show(){
		System.out.println(toString());
	}

}
