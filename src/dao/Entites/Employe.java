package dao.Entites;

public class Employe extends Utilisateur {
	
	public Employe(){
		super();
		this.setRole("Employe") ;
	}
	public Employe(String nom, String prenom, String identifiant, String password) {
		super(nom, prenom, identifiant, password, "Employe");
	}
	
	@Override
	public String toString(){
		return "Employe d'entreprise Nom: " + getNom() + " - " + "Prenom : " + getPrenom() + " - " + "Login: " + getIdentifiant() + " - " + "pass: " + getPassword() ; 
	}
	
	public void show(){
		System.out.print("id employe" + this.getId()+" ");
		System.out.println(toString());
	}
}
