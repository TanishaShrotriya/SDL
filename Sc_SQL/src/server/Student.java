package server;
import java.io.Serializable;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class Student implements Serializable {

    int roll;
    String name;
    float gpa,percent;
	int year;
	
	public Student() {
		roll=0;
		gpa=percent=0;
		name="Default";
		year=0;
	}
	
	public void add(int r,String n) {
	        roll=r;
		    name= n;

		   
	}

	public String toString() {
		return roll+"       "+name+"       "+gpa+"     "+percent+"   "+year+"  \n";
	}
    public int getRoll() {
    	return roll;
    }
    public String getName() {
    	return name;
    }
    public float getPercent() {
    	return percent;
    }
    public void set() {
    	Scanner s = new Scanner(System.in);
    	System.out.println("\nEnter the member id :");
	    roll=s.nextInt();
	    System.out.println("\nEnter the member name :");
	    name=s.next();
	    System.out.println("\nEnter the gpa :");
	    gpa=s.nextFloat();
	    System.out.println("\nEnter the percent :");
	    percent=s.nextFloat();
	    System.out.println("\nEnter the year :");
	    year=s.nextInt();
	
    }
 
    
} 