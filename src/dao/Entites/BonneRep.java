package dao.Entites;

public class BonneRep {
	private Integer id;
	private String bnr;
	
	public BonneRep() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BonneRep(String bnr) {
		super();
		this.bnr = bnr;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBnr() {
		return bnr;
	}
	public void setBnr(String bnr) {
		this.bnr = bnr;
	}
	
	public void show(){
		System.out.println(bnr);
	}
}
