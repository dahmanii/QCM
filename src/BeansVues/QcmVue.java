package BeansVues;

import java.util.ArrayList;
import java.util.List;

import dao.Entites.Qcm;
import dao.Entites.Questionnaire;

public class QcmVue {
	private Integer id;
	private List<QuestionnaireVue> questionnaires = new ArrayList<QuestionnaireVue>();	
	private String libelle;
	private String dateCreation;

	private String etat; // en cours; refuse; en ligne
	private Integer idEmp;
	private String messageResponsable;
	private Integer internautes;   // nombre d'internautes qui ont répondu à ce qcm
	private String categorieScience;
	private String categorieInformatique;
	private String categorieMusique;
	private String categorieCulture;
	
	
	public QcmVue() {
		super();
	}
	
	public QcmVue(Qcm qcm ) {
		super();
		this.id = qcm.getId();
		this.libelle =  qcm.getLibelle();
		this.dateCreation =  qcm.getDateCreation();
		this.etat = "en cours";
		this.idEmp = qcm.getIdEmp();
		this.messageResponsable=qcm.getMessageResponsable();
		this.internautes=qcm.getInternautes();
		for(Questionnaire quest: qcm.getQuestionnaires())
		this.questionnaires.add(new QuestionnaireVue(quest));
		this.categorieScience = "";
		this.categorieInformatique = "";
		this.categorieMusique = "";
		this.categorieCulture = "";
		switch (qcm.getCategorie()) {
		case "Science":
			//this.categorie = "Science";
			this.categorieScience = "selected";
			break;
		case "Informatique":
			//this.categorie = "Informatique";
			this.categorieInformatique = "selected";
			break;
		case "Musique":
			//this.categorie = "Musique";
			this.categorieMusique= "selected";
			break;
		case "Culture générale":
			//this.categorie = "Culture générale";
			this.categorieCulture = "selected";
			break;
		default:
			break;
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getCategorieScience() {
		return this.categorieScience;
	}

	public void setCategorieScience(String categorieScience) {
		this.categorieScience = categorieScience;
	}

	public String getCategorieInformatique() {
		return this.categorieInformatique;
	}

	public void setCategorieInformatique(String categorieInformatique) {
		this.categorieInformatique = categorieInformatique;
	}

	public String getCategorieMusique() {
		return this.categorieMusique;
	}

	public void setCategorieMusique(String categorieMusique) {
		this.categorieMusique = categorieMusique;
	}

	public String getCategorieCulture() {
		return this.categorieCulture;
	}

	public void setCategorieCulture(String categorieCulture) {
		this.categorieCulture = categorieCulture;
	}

	public List<QuestionnaireVue> getQuestionnaires() {
		return this.questionnaires;
	}

	public void setQuestionnaires(List<QuestionnaireVue> questionnaires) {
		this.questionnaires = questionnaires;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Integer getIdEmp() {
		return this.idEmp;
	}

	public void setIdEmp(Integer idEmp) {
		this.idEmp = idEmp;
	}

	public void ajouterQuestionnaireVue(QuestionnaireVue q){
		this.questionnaires.add(q);
	}


	public String getMessageResponsable() {
		return this.messageResponsable;
	}

	public void setMessageResponsable(String messageResponsable) {
		this.messageResponsable = messageResponsable;
	}
	
	public Integer getInternautes() {
		return internautes;
	}

	public void setInternautes(Integer internautes) {
		this.internautes = internautes;
	}

	public void show(){
		System.out.println("----------Qcm------------\n");
		System.out.println("id : "+this.id);
		System.out.println("libelle : "+this.libelle);
		System.out.println("CategorieScience : "+this.categorieScience);
		System.out.println("CategorieInformatique : "+this.categorieInformatique);
		System.out.println("CategorieMusique : "+this.categorieMusique);
		System.out.println("CategorieCulture : "+this.categorieCulture);
		System.out.println("Internautes : "+this.internautes);
		for(QuestionnaireVue q: this.questionnaires) q.show();

	}
	
}
