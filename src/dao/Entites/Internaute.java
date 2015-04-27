package dao.Entites;

public class Internaute extends Utilisateur {
	private String dateNaissance;
	private Integer pointS; // points catégorie science
	private Integer pointI; // points catégorie informatique
	private Integer pointM; // points catégorie musique
	private Integer pointC; // points catégorie culture générale
	
	public Internaute(){
		super();
		this.setRole("Internaute") ;
		this.pointS = 0;
		this.pointI = 0;
		this.pointM = 0;
		this.pointC = 0;
	}
	public Internaute(String nom, String prenom, String identifiant, String password) {
		super(nom, prenom, identifiant, password, "Internaute");
		this.pointS = 0;
		this.pointI = 0;
		this.pointM = 0;
		this.pointC = 0;
	}
	
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	@Override
	public String toString(){
		return "Internaute Nom: " + getNom() + " - " + "Prenom : " + getPrenom() + " - " + "Login: " + getIdentifiant() + " - " + "pass: " + getPassword() ; 
	}
	
	
	public void modifierPointS(Integer note){
		this.pointS += note;
	}
	
	public void modifierPointM(Integer note){
		this.pointM += note;
	}
	
	public void modifierPointI(Integer note){
		this.pointI += note;
	}
	
	public void modifierPointC(Integer note){
		this.pointC += note;
	}
	
	public void modifierPoint(Integer note, String categorie){
		switch (categorie) {
		case "Science":
			modifierPointS(note);
			break;
		case "Informatique":
			modifierPointI(note);
			break;
		case "Musique":
			modifierPointM(note);
			break;
		case "Culture générale":
			modifierPointC(note);
			break;
		default:
			break;
		}
	}
	
	public void show(){
		System.out.println(toString());
	}
	public Integer getPointS() {
		return pointS;
	}
	public void setPointS(Integer pointS) {
		this.pointS = pointS;
	}
	public Integer getPointI() {
		return pointI;
	}
	public void setPointI(Integer pointI) {
		this.pointI = pointI;
	}
	public Integer getPointM() {
		return pointM;
	}
	public void setPointM(Integer pointM) {
		this.pointM = pointM;
	}
	public Integer getPointC() {
		return pointC;
	}
	public void setPointC(Integer pointC) {
		this.pointC = pointC;
	}

}
