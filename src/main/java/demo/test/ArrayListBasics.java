package demo.test;

import java.util.ArrayList;

public class ArrayListBasics {

	public static void main(String[] args) {
		ArrayList ar = new ArrayList();
		System.out.println("Initial size of al: " + ar.size());
		ar.add("S");
		ar.add("A");
		ar.add("U");
		ar.add("R");
		ar.add("A");
		ar.add("V");
		
		System.out.println(ar.size());
		System.out.println(ar);
		ar.remove("U");
		System.out.println(ar);
		ar.add(2,"W");
		System.out.println(ar);


	}
}