package dao.Entites;

public class Utilisateur {
	
	private Integer id;
	private String nom, prenom, identifiant, password;
	private String role; // role de type string pour commencer
	
	public Utilisateur() {
		super();
	}

	public Utilisateur(String nom, String prenom, String identifiant,
			String password, String role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.password = password;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean sIdentifier(String identifiant, String password){
		boolean correct = this.identifiant.equals(identifiant) & this.password.equals(password) ;
		return correct;		
	}
	@Override
	public String toString(){
		return "ROle: "+getRole()+"Nom:" + getNom() + " - " + "Prenom : " + getPrenom() + " - " + "Login: " + getIdentifiant() + " - " + "pass: " + getPassword() ; 
	}
	
	public void show(){
		System.out.println(toString());
	}
}
