package demo.test;
import java.util.ArrayList;
import java.util.Scanner;
public class Assignment3 {
    ArrayList<String> collection = new ArrayList();
    void collectData(){
        collection.add("stupid");
        collection.add("idiot");
        collection.add("non sense");
        collection.add("dumb");
    }
    public void check() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the string: ");
        String s1 = sc.nextLine();
        for (String e : collection) {
            s1=s1.replace(e, "#####");
        }
        System.out.println(s1);
    }
      
    public static void main(String[] args) {
    	Assignment3 obj = new Assignment3();
        obj.collectData();
        obj.check();
    }
}