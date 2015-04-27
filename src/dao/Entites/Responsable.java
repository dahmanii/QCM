package dao.Entites;

public class Responsable extends Utilisateur {
	
	public Responsable(){
		super();
		this.setRole("Responsable") ;
	}
	public Responsable(String nom, String prenom, String identifiant, String password) {
		super(nom, prenom, identifiant, password, "Responsable");
	}
	@Override
	public String toString(){
		return "Responsable technique Nom: " + getNom() + " - " + "Prenom : " + getPrenom() + " - " + "Login: " + getIdentifiant() + " - " + "pass: " + getPassword() ; 
	}
	
	public void show(){
		System.out.println(toString());
	}
}
