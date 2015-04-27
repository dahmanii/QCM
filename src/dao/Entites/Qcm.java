package dao.Entites;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import BeansVues.QuestionnaireVue;

public class Qcm {
	private Integer id;
	private String categorie;
	private List<Questionnaire> questionnaires = new ArrayList<Questionnaire>();	
	private String libelle;
	private String dateCreation;

	private String etat; // en cours; refuse; en ligne
	private Integer idEmp;
	private String messageResponsable;
	
	private Integer internautes;   // nombre d'internautes qui ont r�pondu � ce qcm
	private Integer compteurBonnesReponses;
	private Integer compteurmauvaisesReponses;
	
	private String color;
	
	public Qcm() {
		super();
	}
	
	public Qcm(String categorie, String libelle, String dateCreation, Integer idEmp ) {
		super();
		
		this.categorie = categorie;
		this.libelle = libelle;
		this.dateCreation = dateCreation;
		this.etat = "en cours";
		this.idEmp = idEmp;
		this.messageResponsable="";
		this.internautes=0;
	}
	
	
	public Integer getId() {
		return id;
	}
	public Integer getInternautes() {
		return internautes;
	}

	public void setInternautes(Integer internautes) {
		this.internautes = internautes;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Integer getIdEmp() {
		return idEmp;
	}
	public void setIdEmp(Integer idEmp) {
		this.idEmp = idEmp;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}

	public List<Questionnaire> getQuestionnaires() {
		return questionnaires;
	}

	public void setQuestionnaires(List<Questionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}
	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setQcm(Qcm qcm) {     // cette methode est appel�e dans EmployeImpl.java lors de la modification d'un qcm.
		categorie = qcm.getCategorie();
		libelle = qcm.getLibelle();
		dateCreation = qcm.getDateCreation();
		etat = qcm.getEtat();
		idEmp = qcm.getIdEmp();
		messageResponsable = qcm.getMessageResponsable();
		internautes = qcm.getInternautes();

	}
	
	public void ajouterQuestionnaire(Questionnaire q){
		questionnaires.add(q);
	}
	public void viderQuestionnaire(){
		this.setQuestionnaires(new ArrayList<Questionnaire>());
	}

	public String getMessageResponsable() {
		return messageResponsable;
	}

	public void setMessageResponsable(String messageResponsable) {
		this.messageResponsable = messageResponsable;
	}
	public Questionnaire getQuestionnaireById(Integer idQuestionnaire){
		for(Questionnaire q: this.questionnaires){
			if(q.getId().equals(idQuestionnaire)) return q;
		}
		return null;
	}
	
	public void show(){
		System.out.println("----------Qcm------------\n");
		System.out.println("id : "+this.id);
		System.out.println("libelle : "+this.libelle);
		System.out.println("Categorie : "+this.categorie);
		
		System.out.println("dateCreation : "+this.dateCreation);
		System.out.println("etat : "+this.etat);
		System.out.println("idEmp : "+this.idEmp);
		System.out.println("messageResponsable : "+this.messageResponsable);
		System.out.println("internautes : "+this.internautes);
		
		for(Questionnaire q: this.questionnaires) q.show();

	}

	public void set2Questionnaires(Integer[] idQuestionnaires, String[] question, String[] choix, String[] bnrs) {
		viderQuestionnaire();
		Questionnaire quest ;
		Vector<String> choix_ ;
		Vector<Integer> bnrs_ ;
		Vector<Vector<Integer>> BNRS = new Vector<Vector<Integer>>();
		
		int i,j;
		Integer Id, Bnrs;
		String[] s;
		Integer idQuest = -1;
		
		for(i = 0; i< bnrs.length; i++){
			s = bnrs[i].split("-");
			Id = Integer.parseInt(s[0].toString());
			Bnrs = Integer.parseInt(s[1].toString());
			if(Id.equals(idQuest)) {
				BNRS.lastElement().add(Bnrs);
			}else{
				idQuest = Id;
				BNRS.add(new Vector<Integer>());
				BNRS.lastElement().add(Bnrs);
			}
		}
		
		for(i = 0; i< idQuestionnaires.length; i++){
			quest = new Questionnaire();
			choix_ = new Vector<String>();
			bnrs_ = new Vector<Integer>();
			quest.setId(idQuestionnaires[i]);
			quest.setQuestion(question[i]);
			
			// construire le vecteur choix_
			for(j=0;j<4;j++) choix_.add(choix[4*i+j]);
			
			// construire le vecteur bnrs_
			bnrs_ = BNRS.get(i);
			
			quest.addChoices(choix_, bnrs_);
			ajouterQuestionnaire(quest);
		}
	}

	public Integer getCompteurBonnesReponses() {
		return compteurBonnesReponses;
	}

	public void setCompteurBonnesReponses(Integer compteurBonnesReponses) {
		this.compteurBonnesReponses = compteurBonnesReponses;
	}

	public Integer getCompteurmauvaisesReponses() {
		return compteurmauvaisesReponses;
	}

	public void setCompteurmauvaisesReponses(Integer compteurmauvaisesReponses) {
		this.compteurmauvaisesReponses = compteurmauvaisesReponses;
	}
	
}
