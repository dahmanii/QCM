package BeansVues;

import dao.Entites.Choice;

public class ChoiceVue {
	private String choix;
	private Integer label; // A ou B ou C..
	private String checked; // true si ce choix est une bonne réponse
	
	public ChoiceVue() {
		super();
		this.choix = "";
		this.checked = "";
	}
	public ChoiceVue(Choice c) {
		super();
		this.choix = c.getChoix();
		if(c.getBr()==1) this.setChecked("checked");
		else this.setChecked("");
	}

	public String getChoix() {
		return choix;
	}
	public void setChoix(String choix) {
		this.choix = choix;
	}
	public Integer getLabel() {
		return label;
	}
	public void setLabel(Integer label) {
		this.label = label;
	}

	
	public void show(){
		System.out.println("Label: "+label+" choix:" + choix + "checked: "+checked);
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	
}
