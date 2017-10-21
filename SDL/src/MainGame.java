import java.util.Scanner;

import javax.swing.JOptionPane;

public class MainGame {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int choice;
        String ch=null;
     do {
        System.out.println("Choose: 1.Comp vs Player \n 2:Plyer vs Player");
        Scanner sc=new Scanner(System.in);
        choice=sc.nextInt();
        
		Controller c=new Controller(choice);
       // System.out.println("This "+javax.swing.SwingUtilities.isEventDispatchThread());
		 if(choice == 2) {
				new Thread() {
					public void run() { 
						javax.swing.SwingUtilities.isEventDispatchThread();
						c.readChoice();
						while(true)	{	
				 
						  javax.swing.SwingUtilities.isEventDispatchThread();
						  if(c.myMove==true) {
							c.myMove=false;
							c.read();
							System.out.println("Returning");
						
						  }
						}
					}
				}.start();
		 }
	    System.out.println("Thread end");
		System.out.println("Do you want to continue");
		ch=sc.next();
		
	}while(ch.equals("y")) ;
	}
}
