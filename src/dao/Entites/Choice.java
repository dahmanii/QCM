package dao.Entites;

public class Choice {
	private Integer id;
	private String choix;
	private String label; // A ou B ou C..
	private Integer br; // true si ce choix est une bonne réponse
	
	public Choice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Choice(String choix, String label, Integer br) {
		super();
		this.choix = choix;
		this.label = label;
		this.br = br;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getChoix() {
		return choix;
	}
	public void setChoix(String choix) {
		this.choix = choix;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Integer getBr() {
		return br;
	}
	public void setBr(Integer br) {
		this.br = br;
	}
	
	public void show(){
		System.out.println("Label: "+label+" id: "+id+" choix:" + choix + "br: "+br);
	}
	
}
