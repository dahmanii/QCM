package dao.Entites;

public class Internaute extends Utilisateur {
	private String dateNaissance;
	
	public Internaute(){
		super();
		this.setRole("Internaute") ;
	}
	public Internaute(String nom, String prenom, String identifiant, String password) {
		super(nom, prenom, identifiant, password, "Internaute");
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
	
	public void show(){
		System.out.println(toString());
	}
}
