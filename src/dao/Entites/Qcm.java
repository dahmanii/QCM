package dao.Entites;

import java.util.HashSet;
import java.util.Set;

public class Qcm {
	private Integer id;
	String categorie;
	private Set<Questionnaire> questionnaires = new HashSet<Questionnaire>();
	private String libelle;
	private String dateCreation;
	//private String debutValidite, finValidite;
	private String etat; // en cours; refuse; en ligne
	private Integer idEmp;
	private String messageResponsable;

	
	
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
	}
	
	/*
	public Qcm(String categorie, String libelle, String dateCreation, Integer idEmp, String etat ) {
		super();
		this.categorie = categorie;
		this.libelle = libelle;
		this.dateCreation = dateCreation;
		this.etat = "en cours";
		this.idEmp = idEmp;
		this.etat=etat;
	}*/
	
	public Integer getId() {
		return id;
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

	public Set<Questionnaire> getQuestionnaires() {
		return questionnaires;
	}

	public void setQuestionnaires(Set<Questionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}
	
	public void setQcm(Qcm qcm) {
		questionnaires = qcm.getQuestionnaires();
		dateCreation = qcm.getDateCreation();
		etat = qcm.getEtat();
		idEmp = qcm.getIdEmp();
	}
	
	public void ajouterQuestionnaire(Questionnaire q){
		questionnaires.add(q);
	}
	@Override
	public String toString(){
		String qcmss;
		qcmss = "id : "+getId()+ "date : "+getDateCreation()+ "etat : "+getEtat()+ "idEmp : "+getIdEmp();
		for(Questionnaire q: questionnaires)
			qcmss+=q.toString()+"\n";
		return qcmss; 
	}
	
	public void show(){
		System.out.println(toString());
	}

	public String getMessageResponsable() {
		return messageResponsable;
	}

	public void setMessageResponsable(String messageResponsable) {
		this.messageResponsable = messageResponsable;
	}

	

	
}
