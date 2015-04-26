package dao.Entites;

public class Internaute extends Utilisateur {
	private String dateNaissance;
	private Integer points;
	
	public Internaute(){
		super();
		this.setRole("Internaute") ;
		this.points = 0;
	}
	public Internaute(String nom, String prenom, String identifiant, String password) {
		super(nom, prenom, identifiant, password, "Internaute");
		this.points = 0;
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
	
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	
	public void modifierPoints(Integer note){
		this.points += note;
	}
	
	public void show(){
		System.out.println(toString());
	}
}
