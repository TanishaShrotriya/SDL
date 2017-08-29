package server;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


public class Server {
	
	ExecutorService pool = null;
	
	Server(ExecutorService s) {
		
		pool = s;
		
	}
	
	public void StartServer(int p) {
		int port=12345;
		try {
	
			ServerSocket ss= new ServerSocket(port);
			
			while(true) {
				
				Socket s = ss.accept();
				Server_body serv = new Server_body(port,s);
				pool.execute(serv);
			
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main (String args[]) {
		
		new Server(Executors.newFixedThreadPool(5)).StartServer(11123);
		
	} 
	
}

//thread class
class Server_body implements Runnable {

    //Socket or i/o related data variables
    int port;
	Socket S ;
			
	Server_body(int p,Socket sock) {
		
		this.port=p;
		this.S=sock;
	
	}
	
    public void run() {

    	try {
	        //MySQL connection related instances.	
			Connection conn = null;
		    final String user="b76";
		    final String pass="b76";
		    final String JDBC_Driver="com.mysql.jdbc.Driver";    
		    final String DB_URL="jdbc:mysql://172.16.1.68:3306/b76";
		      
		    Scanner sc = new Scanner(System.in);
		    int choice ;
		
		    String check;

			//Server for socket created.
			System.out.println("Waiting");
			

			//Objects created for data transfer 
		    ObjectOutputStream sObOut = new ObjectOutputStream(S.getOutputStream());
		    //for sending object data 
		    ObjectInputStream sObIn = new ObjectInputStream(S.getInputStream());
			//for reading object
			DataInputStream sIn = new DataInputStream(S.getInputStream());
			//for reading data
		    DataOutputStream sOut = new DataOutputStream(S.getOutputStream());
			//for reading data
		
		    Operations ob=new Operations();
	
		    do {
			
		    	choice=sIn.read();
				System.out.println("Choice received awaiting response");
		
				    switch(choice) {
				    
				           case 0 :sOut.writeInt(10);
				                   break;
						   case 1 ://insert
								    // get information from client side
								    Student s1 = new Student();
							    	sOut.writeUTF("Enter the choice :");
								    s1=(Student)sObIn.readObject();
								   
									try {
										  //connection established
									      Class.forName(JDBC_Driver);
										  conn=DriverManager.getConnection(DB_URL,user,pass);
								    	  sOut.writeUTF(ob.insert(conn,s1));
								    	  //operations class method insert called and status sent to the client
								     }
								  
								    catch(SQLException k) {
								    	  k.printStackTrace();
								    }
								    catch (ClassNotFoundException e) {
										  e.printStackTrace();
									 }
								    break;
								    
						    case 2 :// Display data through arrayList and toString defined in Student 
						    	    try {
					                	    Class.forName(JDBC_Driver);
									        conn=DriverManager.getConnection(DB_URL,user,pass);
									        sOut.writeUTF(ob.display(conn).toString());
									  
							           }
							          catch(SQLException s2) {
								     	  s2.printStackTrace();
								        }
								      catch (ClassNotFoundException e) {
										
										 e.printStackTrace();
									    }
							         break;
						    case 3 ://update data 
						    	     // Communicate with client for data
						    	      sOut.writeUTF("Enter roll number whose data is to be updated");
						    	      int r=sIn.read();
						    	      
						    	      sOut.writeUTF("Enter new gpa");
						    	      float gp=sIn.readFloat();
						    	      
						    	      sOut.writeUTF("Enter new percent");
						    	      float percent=sIn.readFloat();
						    	      
						    	      //Send data to MySQL 
						              try {
				                	    Class.forName(JDBC_Driver);
								        conn=DriverManager.getConnection(DB_URL,user,pass);
								        //using method of operations class
								        sOut.writeUTF(ob.update(conn,r,gp,percent));
								  
							           }
							          catch(SQLException s2) {
								     	  s2.printStackTrace();
								        }
								      catch (ClassNotFoundException e) {
										
										 e.printStackTrace();
									    }
							          break;
						     case 4 ://search for record 
						    	     sOut.writeUTF("Enter the roll number to search for");
						    	     int x = sIn.readInt();
						    	     //Send data to MySQL 
						              try {
				                	    Class.forName(JDBC_Driver);
								        conn=DriverManager.getConnection(DB_URL,user,pass);
								        //using method of operations class
								        sOut.writeUTF(ob.search(conn,x));
								  
							           }
							          catch(SQLException s2) {
								     	  s2.printStackTrace();
								        }
								      catch (ClassNotFoundException e) {
										
										 e.printStackTrace();
									    }
						             break;
						     case 5: //top
						    	     try {
				                	    Class.forName(JDBC_Driver);
								        conn=DriverManager.getConnection(DB_URL,user,pass);
								        //using method of operations class
								        sOut.writeUTF(ob.top(conn));
								  
							           }
							         catch(SQLException s2) {
								     	  s2.printStackTrace();
								        }
								     catch (ClassNotFoundException e) {
										
										 e.printStackTrace();
									    }
						    	     break;
						     case 6: //delete
						    	    sOut.writeUTF("Enter roll number to delete");
						    	    r = sIn.readInt();
						    	    try {
				                	    Class.forName(JDBC_Driver);
								        conn=DriverManager.getConnection(DB_URL,user,pass);
								        //using method of operations class
								        sOut.writeUTF(ob.remove(conn,r));
								  
							           }
							         catch(SQLException s2) {
								     	  s2.printStackTrace();
								        }
								     catch (ClassNotFoundException e) {
										
										 e.printStackTrace();
									    }
						    	     break;
						     case 7 ://pass or fail 
						    	    try {
				                	    Class.forName(JDBC_Driver);
								        conn=DriverManager.getConnection(DB_URL,user,pass);
								        //using method of operations class
								        sOut.writeUTF(ob.pOrF(conn));
								  
							           }
							         catch(SQLException s2) {
								     	  s2.printStackTrace();
								        }
								     catch (ClassNotFoundException e) {
										
										 e.printStackTrace();
									    }
						    	     break;
						    	   
							 case 8 ://exit and end connection
						    	     sOut.writeUTF("Ending connection");
						    	     S.close();
						    	     System.exit(0); 
						    	     break;
				    }
				    
				 
			
			}while(choice!=8);
			
    	}
    	 catch(Exception e ) {
    		 e.printStackTrace();
    	 }
     }
  

}