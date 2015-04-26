package dao.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import services.QcmMetierImplementation;
import BeansVues.ListeQcmVue;
import BeansVues.QcmVue;
import BeansVues.QuestionnaireVue;
import dao.Entites.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] idQuestionnaires = {1,2};
		String[] question = {"question1","question2"};
		String[] choix = {"choix1","","choix1","","","choix1","choix1","choix1"};
		String[] bnrs = {"1-0","1-3","2-2"};
		
		Vector<String> choix_ ;
		Vector<Integer> bnrs_ ;
		Vector<Vector<Integer>> BNRS = new Vector<Vector<Integer>>();
		
		int i,j;
		Integer Id, Bnrs;
		String[] s;
		Integer idQuest = -1;
		for(i = 0; i< bnrs.length; i++){
			s = bnrs[i].split("-");
			Id = Integer.parseInt(s[0].toString());
			Bnrs = Integer.parseInt(s[1].toString());
			if(Id.equals(idQuest)) {
				BNRS.lastElement().add(Bnrs);
			}else{
				idQuest = Id;
				BNRS.add(new Vector<Integer>());
				BNRS.lastElement().add(Bnrs);
			}
		}
		
		for(i = 0; i< idQuestionnaires.length; i++){
			System.out.println("id Quest: "+idQuestionnaires[i]);
			System.out.println("question Quest: "+question[i]);
			
			choix_ = new Vector<String>();
			bnrs_ = new Vector<Integer>();
			
			// construire le vecteur choix_
			for(j=0;j<4;j++) choix_.add(choix[4*i+j]);
			System.out.println("choix_: "); for(String sc: choix_) System.out.println("   " + sc);
			// construire le vecteur bnrs_
			bnrs_ = BNRS.get(i);
			System.out.println("bnrs_: "); for(Integer bn: bnrs_) System.out.println("   " + bn);
			
			System.out.println("------------------");
		}
	}

}
