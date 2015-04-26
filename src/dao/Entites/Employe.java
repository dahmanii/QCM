package dao.Entites;

public class Employe extends Utilisateur {
	
	public Employe(){
		super();
		this.setRole("Employ� d'entreprise") ;
	}
	public Employe(String nom, String prenom, String identifiant, String password) {
		super(nom, prenom, identifiant, password, "Employ� d'entreprise");
	}
	
	@Override
	public String toString(){
		return "Employ� d'entreprise Nom: " + getNom() + " - " + "Prenom : " + getPrenom() + " - " + "Login: " + getIdentifiant() + " - " + "pass: " + getPassword() ; 
	}
	
	public void show(){
		System.out.print("id employ�" + this.getId()+" ");
		System.out.println(toString());
	}
}
