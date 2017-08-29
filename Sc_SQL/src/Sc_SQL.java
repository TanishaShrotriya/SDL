import server.Student;
import java.util.*;
import java.io.*;
import java.net.*;

public class Sc_SQL {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		int port =12345;
 		//Client socket created.
 		
 		Socket s = new Socket("localhost",port);
 		//giving IP address of server and the port for communication
 			
 		//Objects created for data transfer
 		ObjectOutputStream cObOut = new ObjectOutputStream(s.getOutputStream());
 		//this doesnt make sense.
 		ObjectInputStream cObIn = new ObjectInputStream(s.getInputStream());
	    //for sending object data 
 		DataOutputStream cOut = new DataOutputStream(s.getOutputStream());
 		//for sending data
  		DataInputStream cIn = new DataInputStream(s.getInputStream());
 		//for reading data
 	    
 		Scanner sc = new Scanner(System.in);
 		int choice ;
 		String ch="y";
 		
 		do {
 			
 			System.out.println("Operations Possible : ");
 			System.out.println("1.Add \n2.Display \n3.Update \n4.Search "
 					+ "\n5.Topper \n6.Delete \n7.Pass or Fail\n8.Exit");
 			
 			choice= sc.nextInt();
 			cOut.write(choice);
 		    cOut.flush();
 		    
 		    switch(choice) {
 		    
 		            case 0 : System.out.println(cIn.readInt());break; 
		 		    case 1 ://Add or insert
		 		            //client to student class to get data
		 		            System.out.println(cIn.readUTF());
		 		            Student s1 = new Student();
		 		            s1.set();
		 		            //write to server 
		 		            cObOut.writeObject(s1);
		 		            System.out.println(cIn.readUTF());
		 		            break;
		 		    case 2 : //Display 
		 		    	    System.out.println("roll   name  gpa  percent  year");
		 		    	    System.out.println(cIn.readUTF());
		 		    	    break;
		 		    case 3 : 
		 		    	     //Communicate with server to and user to obtain updates
		 		    	     System.out.println(cIn.readUTF());
				    	     int r = sc.nextInt();
				    	     cOut.write(r);
				    	     
				    	     // adding check for float values
				    	     
				    	     System.out.println(cIn.readUTF());
				    	     float gp=sc.nextFloat();
				    	     cOut.writeFloat(gp);
				    	     
				    	     System.out.println(cIn.readUTF());
				    	     float percent=sc.nextFloat();
				    	     cOut.writeFloat(percent);
				    	     
				    	     System.out.println(cIn.readUTF());
				    	     break;
				    	     
		 		    case 4 ://Search 
		 		    	    System.out.println(cIn.readUTF());
		 		    	    r=sc.nextInt();
		 		    	    cOut.writeInt(r);
		 		    	    System.out.println(cIn.readUTF());
		 		    	    break;
		 		    case 5: //top
		 		    	    System.out.println(cIn.readUTF());
		 		    	    break;
		 		    case 6: //delete
		 		    	    System.out.println(cIn.readUTF());
		 		    	    r=sc.nextInt();
		 		    	    cOut.writeInt(r);
		 		    	    System.out.println(cIn.readUTF());
		 		    	    break;
		 		    case 7: //Pass or Fail
		 		        	System.out.println(cIn.readUTF());
	 		        	    break;
	 		        case 8: System.out.println(cIn.readUTF());
				    	    s.close(); 
				            System.exit(0); 
				            break;
 		    }
 		 
 		}while(choice!=8);
 		
	}
}

