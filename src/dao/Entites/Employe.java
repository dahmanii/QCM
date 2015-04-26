package dao.Entites;

public class Employe extends Utilisateur {
	
	public Employe(){
		super();
		this.setRole("Employé d'entreprise") ;
	}
	public Employe(String nom, String prenom, String identifiant, String password) {
		super(nom, prenom, identifiant, password, "Employé d'entreprise");
	}
	
	@Override
	public String toString(){
		return "Employé d'entreprise Nom: " + getNom() + " - " + "Prenom : " + getPrenom() + " - " + "Login: " + getIdentifiant() + " - " + "pass: " + getPassword() ; 
	}
	
	public void show(){
		System.out.print("id employé" + this.getId()+" ");
		System.out.println(toString());
	}
}
