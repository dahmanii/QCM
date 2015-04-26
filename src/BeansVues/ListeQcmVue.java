package BeansVues;

import java.util.ArrayList;
import java.util.List;
import dao.Entites.*;

public class ListeQcmVue {
	List<QcmVue> liste = new ArrayList<QcmVue>();

	public ListeQcmVue() {
		super();
	}

	public ListeQcmVue(List<Qcm> liste) {
		super();
		for(Qcm q:liste)
		this.liste.add(new QcmVue(q));
	}
	
	public List<QcmVue> getListe() {
		return liste;
	}

	public void setListe(List<QcmVue> liste) {
		this.liste = liste;
	}

	public void show(){
		for(QcmVue q: this.liste) q.show();
	}
	
}
