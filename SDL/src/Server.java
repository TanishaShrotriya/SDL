import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.net.ServerSocket;

/*
 * A chat server that delivers public and private messages.
 */
public class Server {

  // The server socket.
  private static ServerSocket serverSocket = null;
  // The client socket.
  private static Socket clientSocket = null;

  // This chat server can accept up to maxClientsCount clients' connections.
  private static final int maxClientsCount = 10;
  private static final clientThread[] threads = new clientThread[maxClientsCount];

  public static void main(String args[]) {

    // The default port number.
    int portNumber = 12345;
      System.out
          .println("Usage: java MultiThreadChatServer <portNumber>\n"
              + "Now using port number=" + portNumber);
  
    try {
      serverSocket = new ServerSocket(portNumber);
    } catch (IOException e) {
      System.out.println(e);
    }

    /*
     * Create a client socket for each connection and pass it to a new client
     * thread.
     */
    while (true) {
      try {
        clientSocket = serverSocket.accept();
        int i = 0;
        for (i = 0; i < maxClientsCount; i++) {
          if (threads[i] == null) {
            (threads[i] = new clientThread(clientSocket, threads)).start();
            System.out.println("Connected to :"+i);
            break;
          }
        }
        if (i == maxClientsCount) {
          PrintStream os = new PrintStream(clientSocket.getOutputStream());
          os.println("Server too busy. Try later.");
          os.close();
          clientSocket.close();
        }
      } catch (IOException e) {
        System.out.println(e);
      }
    }
  }
}

class clientThread extends Thread {

  private DataInputStream is = null;
  private DataOutputStream os = null;
  private ObjectOutputStream out=null;
  private ObjectInputStream in=null;
  private Socket clientSocket = null;
  private final clientThread[] threads;
  private int maxClientsCount;

  public clientThread(Socket clientSocket, clientThread[] threads) {
    this.clientSocket = clientSocket;
    this.threads = threads;
    maxClientsCount = threads.length;
  }

  public void run() {
    int maxClientsCount = this.maxClientsCount;
    clientThread[] threads = this.threads;

    try {
      /*
       * Create input and output streams for this client.
       */
      is = new DataInputStream(clientSocket.getInputStream());
     // os = new PrintStream(clientSocket.getOutputStream());
      os = new DataOutputStream(clientSocket.getOutputStream());
      out=new ObjectOutputStream(clientSocket.getOutputStream());
      in=new ObjectInputStream(clientSocket.getInputStream()); 

      
      for (int i = 0; i < maxClientsCount; i++) {
			if(threads[i]==this){
					
				 try{
								      
					   if(i%2==0) {
						   System.out.println("WRTITING PLAYER 1");
						   threads[i].os.writeInt(1) ;
		                }
		                
						if (i%2==1) {
							 System.out.println("WRTITING PLAYER 2");
						     threads[i].os.writeInt(2) ;
						} 
					}
					catch(Exception e) {} 
		              //   }
		      }   
      }
      
      while (true) {
    	  
    	    /*for (int i = 0; i < maxClientsCount; i++) {
    			if(threads[i]==this){
    					
    				 try{
    								      
    					   if(i%2==0) {
    						   System.out.println("WRTITING PLAYER 1");
    						   threads[i].os.writeInt(1) ;
    		                }
    		                
    						if (i%2==1) {
    							 System.out.println("WRTITING PLAYER 2");
    						     threads[i].os.writeInt(2) ;
    						} 
    					}
    					catch(Exception e) {} 
    		              //   }
    		      }   
          }*/
      
        ArrayList<Integer> c =new ArrayList<Integer>();
		c=(ArrayList<Integer>)in.readObject();
		System.out.println("Here READ");
	       int winner=is.readInt();
	       for (int i = 0; i < maxClientsCount; i++) {
	        
	    		if(threads[i]==this){
	    	            //    synchronized(this) {
	    				try{
	    				        if(i%2==0) {
	    		                           if(threads[i+1]!=null) {  
	    	          				        threads[i+1].os.writeInt(winner);
	    					   }
	    	                                }
	    	                
	    					if (i%2==1 && threads[i-1]!=null) {
	    	          				threads[i-1].os.writeInt(winner);
	    					} 
	    				}
	    				catch(Exception e) {} 
	    	              //   }
	    		} 

	          }
       /* if(c.get(9)==-1) {
        	
        	   for (int i = 0; i < maxClientsCount; i++) {
      			if(threads[i]==this){
      					
      				  try{
      					   if(i%2==0) {
  						       c.remove(9);
  						       c.add(9,1);
  						       System.out.println("Here Even");
  			                   threads[i].out.writeObject(c);
      		                }
      		                
      						if (i%2==1) {
      							 System.out.println("Here Odd");
      							 c.remove(9);
    						     c.add(9,2);
      							 threads[i].out.writeObject(c);
      						} 
      					}
      					catch(Exception e) {} 
      		              //   }
      		      }   

              }
        }
        else {*/
        for (int i = 0; i < maxClientsCount; i++) {

        	 System.out.println("Here Write");
			if(threads[i]==this){
					
				  try{
					   if(i%2==0) {
						   
			                 if(threads[i+1]!=null) {  
					           System.out.println("Here2");
			                   threads[i+1].out.writeObject(c);
			                 }
		                }
		                
						if (i%2==1 && threads[i-1]!=null) {
							 System.out.println("Here3");
							 threads[i-1].out.writeObject(c);
						} 
					}
					catch(Exception e) {} 
		              //   }
		      }   

        //}
      }

//      os.println("*** Bye " + name + " ***");

      /*
       * Clean up. Set the current thread variable to null so that a new client
       * could be accepted by the server.
       */
    //  for (int i = 0; i < maxClientsCount; i++) {
      //  if (threads[i] == this) {
       //   threads[i] = null;
        //}
     // }

      /*
       * Close the output stream, close the input stream, close the socket.
       */
   //   is.close();
    //  os.close();
      //clientSocket.close();
    }
      } catch (IOException e) {
    } catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
  }
}