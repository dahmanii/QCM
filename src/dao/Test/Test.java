package dao.Test;
import dao.Entites.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employe emp1 = new Employe("aaa", "bbb", "saw", "123");
		Employe emp2 = new Employe("aaa", "bbb", "saw", "123");
		Employe emp3 = new Employe("aaa", "bbb", "saw", "123");
		Employe emp4 = new Employe("aaa", "bbb", "saw", "123");
		
		emp1.show();
		emp2.show();
		emp3.show();
		emp4.show();
		
		emp4.setNom("qqqqq");
		emp4.show();
	}

}
