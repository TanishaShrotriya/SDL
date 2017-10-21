
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Controller  extends Tictactoe implements ActionListener,Serializable {

	int count,flagCount,pturn=0;
	ArrayList<Integer> flags= null;
	static int choice=0;
	int alpha;
	int gameType=1;
	boolean gameOver;
	boolean myMove=true;
	int winner=0;
	
	int port ;
	Socket s = null;
	//Objects created for data transfer
	ObjectOutputStream cObOut =null; 
	ObjectInputStream cObIn = null;
	DataOutputStream cOut = null;
	DataInputStream cIn =null;
	
	
	Controller(int c) {
		super();
		try {
			port =12345;
	 		//Client socket created.
	 		
	        s = new Socket("192.168.43.53",port);
	 		//giving IP address of server and the port for communication
	 			
	 		//Objects created for data transfer
	 		cObOut = new ObjectOutputStream(s.getOutputStream());
	 		//this doesn't make sense.
	 		cObIn = new ObjectInputStream(s.getInputStream());
		    //for sending object data 
	 		cOut = new DataOutputStream(s.getOutputStream());
	 		//for sending data
	  	    cIn = new DataInputStream(s.getInputStream());
	 		//for reading data
		}
		catch(Exception e) {
			
		}
		gameOver=false;
		count=0;
        flagCount=0;
        gameType=c;
        
    	flags= new ArrayList<Integer>();
    	
		for(int i=0;i<9;i++) {
			    flags.add(0);
		}
		//flags.add(10,-1);
		for(int i=0;i<3;i++) {
				
				for(int m=0;m<3;m++) {
				    buttonArray[i][m].addActionListener(this);
				    if(i==1 && m==1) {
				    	//buttonArray[i][m].setText("X");
				       //flags.add(4,2);	
				        
				        
				    }
				    
				}
		
		}
		
		
	}
	
	@Override
     public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.flagCount=0;
		gameOver();
		for(int i=0;i<3;i++) {
			
			for(int m=0;m<3;m++) {
				
				if(e.getSource()==buttonArray[i][m]) {
					
					this.myMove=true;
                     
					//USER vs USER
					
					if(gameType==2) {
						
					
						if(gameOver()==false) {
							if(alpha==1) {
								buttonArray[i][m].setText("0");
								this.flags.remove(flagCount);
								this.flags.add(flagCount, 1);
							}
							else {
								buttonArray[i][m].setText("X");
								this.flags.remove(flagCount);
								this.flags.add(flagCount, 2);
								
							}
							try {
								//JOptionPane.showMessageDialog(this,"Winner is: "+winner);
								cObOut.writeObject(this.flags);
								cOut.writeInt(winner);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						}
						else {
							try {
							//	JOptionPane.showMessageDialog(this,"Winner is: "+winner);
								cObOut.writeObject(this.flags);
								cOut.writeInt(winner);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(this, "SCORE :");
							if(winner==-1) {
								JOptionPane.showMessageDialog(this,"DRAW!!!");
							}
							if((winner==1 && alpha==1)||(winner==2 && alpha==2)) {
								JOptionPane.showMessageDialog(this,"YOU WIN!!!");
							}
							else if((winner==2 && alpha==1)||(winner==1 && alpha==2)) {
								JOptionPane.showMessageDialog(this,"OPPONENT WINS!!!");
							}
							
						}
					}
					 //Comp vs User
					else {
					  
						buttonArray[i][m].setText("0");
						this.flags.remove(flagCount);
						this.flags.add(flagCount, 1);
						
						if(!gameOver())
						{
						compMove();
						}
					}
					
				}
				this.flagCount++;
				
			}
	
	    }
			
		
	}
	public void readChoice() {
		
		//USER VS USER
		
		try {
			alpha=cIn.readInt();
			//JOptionPane.showMessageDialog(this,alpha);
		} catch (HeadlessException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readGame() {
		// USER VS USER
		try {
			JOptionPane.showMessageDialog(this,alpha);
		} catch (HeadlessException e) {
			e.printStackTrace();
		}
	}
    public void read() {
   
		         try {
		        	winner=cIn.readInt();
					if(gameOver()==false) {
						
						
			        	ArrayList<Integer> c =new ArrayList<Integer>();
								c=(ArrayList<Integer>)cObIn.readObject();
						int flags=0;
						
					//	JOptionPane.showMessageDialog(this, "in read winner : "+winner);
						for(int i=0;i<3;i++) {
							int done=0;
							for(int m=0;m<3;m++) {
							//	 JOptionPane.showMessageDialog(this, "inside for");
								 if((c.get(flags)==1 && this.flags.get(flags)==0)) {
									     
								//	    JOptionPane.showMessageDialog(this, "inside if");
									 if(alpha==2) {
										buttonArray[i][m].setText("0");	
									
									 }
									
									 if(alpha==1) {
											buttonArray[i][m].setText("X");	
											
								     }
										this.flags=c;
						//				JOptionPane.showMessageDialog(this, ""+this.flags.toString());
										
										done=1;
										javax.swing.SwingUtilities.isEventDispatchThread();
										break;
								}
								 else if((c.get(flags)==2 && this.flags.get(flags)==0)) {
	//								    JOptionPane.showMessageDialog(this, "inside if");
									 if(alpha==2) {
										buttonArray[i][m].setText("0");	
									
									 }
									
									 if(alpha==1) {
											buttonArray[i][m].setText("X");	
											
								     }
										this.flags=c;
							//			JOptionPane.showMessageDialog(this, ""+this.flags.toString());
										
										done=1;
										javax.swing.SwingUtilities.isEventDispatchThread();
										break;
										}
										  
								flags++;
							}
					      if(done==1) {
					    	  break;
					      }
					    }
					}
					else {
						
						JOptionPane.showMessageDialog(this, "SCORE ");
						if(winner==-1) {
							JOptionPane.showMessageDialog(this,"DRAW!!!");
						}
						if((winner==1 && alpha==1)||(winner==2 && alpha==2)) {
							JOptionPane.showMessageDialog(this,"YOU WIN!!!");
						}
						else if((winner==2 && alpha==1)||(winner==1 && alpha==2)) {
							JOptionPane.showMessageDialog(this,"OPPONENT WINS!!!");
						}
						
					}
					
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       
	
	}
    public void compMove() {
    	pturn=0;
   
    	if(pturn==0) {
    		doublefun(0);
    	}
    	
    	if(pturn==0) {
    		doublefun(3);
    	}
    	
    	if(pturn==0) {
    		doublefun(6);
    	}
    	
    	if(pturn==0) {
    		doublefun(1);
    	}
    	
    	if(pturn==0) {
    		doublefun(2);
    	}
    	
    	if(pturn==0) {
    		corner();
    	}
    	
    	if(pturn==0) {
    		anyempty();
    	}
    	gameOver();
    }
    
    public boolean isempty()
    {
    	

    	for(int i=0;i<9;i++)
    	{
    		
    			if(flags.get(i)==0)
    			{
    				continue;
    			}
    			else if(flags.get(i)==1)
    			{
    				return false;
    				
    			}
    			
    		
    	}
    	return true;
    	
    }
	
    public void doublefun(int n)
    {
    	if(n%3==0)
    	{   
    		if((flags.get(n)==1 && flags.get(n+1)==1 && flags.get(n+2)==0) || (flags.get(n+1)==1 && flags.get(n+2)==1 && flags.get(n)==0) || (flags.get(n)==1 && flags.get(n+2)==1  && flags.get(n+1)==0))
    		{
    			
    			if(flags.get(n)==0)
    			{
    				buttonArray[n/3][0].setText("X");
    				flags.remove(n);
    				flags.add(n,2);
    				pturn=1;
    			}
    			if(flags.get(n+1)==0)
    			{
    				buttonArray[n/3][1].setText("X");
    				flags.remove(n+1);
    				flags.add(n+1,2);
    		
    			}
    			if(flags.get(n+2)==0)
    			{
    				buttonArray[n/3][2].setText("X");
    				flags.remove(n+2);
    				flags.add(n+2,2);
    	
    			}
    			pturn=1;
    		}
    		
    		
    	}
    	
    	if(n%3!=0 || n==0)
    	{   
    		if((flags.get(n)==1 && flags.get(n+3)==1  && flags.get(n+6)==0 ) || (flags.get(n+3)==1 && flags.get(n+6)==1  && flags.get(n)==0) || (flags.get(n)==1 && flags.get(n+6)==1  && flags.get(n+3)==0))
    		{
    		
    			if(flags.get(n)==0)
    			{
    				buttonArray[0][n].setText("X");
    				flags.remove(n);
    				flags.add(n,2);
    		
    			}
    			if(flags.get(n+3)==0)
    			{
    				buttonArray[1][n].setText("X");
    				flags.remove(n+3);
    				flags.add(n+3,2);
    		
    			}
    			if(flags.get(n+6)==0)
    			{
    				buttonArray[2][n].setText("X");
    				flags.remove(n+6);
    				flags.add(n+6,2);
    		
    			}
    			
    			pturn=1;
    		}
    		
    		
    	}
    	else 
    	{   
    		for(int i=0;i<9;i++)
    		{
    			if(i%2==0)
    			{
    				if(i%4==0)
    				{
    					if(i==0) {
	    					if((flags.get(i)==1 && flags.get(i+4)==1 && flags.get(i+8)==0) || (flags.get(i+4)==1 && flags.get(i+8)==1  && flags.get(i)==0) || (flags.get(i)==1 && flags.get(i+8)==1  && flags.get(i+4)==0))
	    		    		{
	    		    		
	    		    			if(flags.get(i)==0)
	    		    			{
	    		    				buttonArray[i/4][i/4].setText("X");
	    		    				flags.remove(i);
	    		    				flags.add(i,2);
	    		    			}
	    		    			if(flags.get(4)==0)
	    		    			{
	    		    				buttonArray[1][1].setText("X");
	    		    				flags.remove(i+4);
	    		    				flags.add(i+4,2);
	    		    	
	    		    			}
	    		    			if(flags.get(8)==0)
	    		    			{
	    		    				buttonArray[2][2].setText("X");
	    		    				flags.remove(i+8);
	    		    				flags.add(i+8,2);
	    		    			}
	    		    			
	    		    			pturn=1;
	    		    		}
    					}
    				}
    				
    			}
    		}	
    		
    	}
    
    }
    
    public void corner()
    {
    	for(int i=0;i<9;i++)
    	{
    		if(i%2==0 )
    		{
    			
    			if(flags.get(0)==0 && i==0)
    			{
    				buttonArray[0][0].setText("X");
    				//turn=client;
                    flags.remove(0);
                    flags.add(0,2);
                    pturn=1;
                    break;
    				
    			}
    			else if(flags.get(2)==0 && i==2)
    			{
    				buttonArray[0][2].setText("X");
                    flags.remove(2);
                    flags.add(2,2);
                    pturn=1;
                    break;
    	
    			}
    			else if(flags.get(6)==0 && i==6)
    			{
    				buttonArray[2][0].setText("X");
                    flags.remove(6);
                    flags.add(6,2);
                    pturn=1;
                    break;
   
    			}
    			else if(flags.get(8)==0 && i==8)
    			{
    				buttonArray[2][2].setText("X");
                    flags.remove(8);
                    flags.add(8,2);
                    pturn=1;
                    break;
 
    			}
    			
    		}
   
    	}
 	
    }
    
    
    public void anyempty() 
    {
		
    		int m=0;
    		
    		for(int j=0;j<3;j++)
    		{
    			int done=0;
    			
    			for(int k=0;k<3;k++)
    			{
    				
    				if(flags.get(m)==0)
    				{
    					
    					buttonArray[j][k].setText("X");
    					flags.remove(m);
    					flags.add(m, 2);
    					done=1;
    					break;
    				}
    				m++;
    			}
    			
    			
    			if(done==1)
    				break;
    		}
    		
    	}


    	public boolean gameOver() {
    		
    		
    			if((flags.get(0)==2 &&  flags.get(1)==2 && flags.get(2)==2 ) || 
    					(flags.get(3)==2 &&  flags.get(4)==2 && flags.get(5)==2 ) ||
    					(flags.get(6)==2 &&  flags.get(7)==2 && flags.get(8)==2 ) ||
    					(flags.get(0)==2 &&  flags.get(3)==2 && flags.get(6)==2 ) ||
    					(flags.get(1)==2 &&  flags.get(4)==2 && flags.get(7)==2 ) ||
    					(flags.get(2)==2 &&  flags.get(5)==2 && flags.get(8)==2 ) ||
    					(flags.get(0)==2 &&  flags.get(4)==2 && flags.get(8)==2 ) ||
    					(flags.get(2)==2 &&  flags.get(4)==2 && flags.get(6)==2 ) 
    					
    					)
    			{
    				if(gameType==1) {
    					
    					JOptionPane.showMessageDialog(this, "COMPUTER WINS");
    				}
    				else {
    					winner=2;
    				}
    				return true;
    				
    			}
    			
    			if((flags.get(0)==1 &&  flags.get(1)==1 && flags.get(2)==1 ) || 
    					(flags.get(3)==1 &&  flags.get(4)==1 && flags.get(5)==1 ) ||
    					(flags.get(6)==1 &&  flags.get(7)==1 && flags.get(8)==1 ) ||
    					(flags.get(0)==1 &&  flags.get(3)==1 && flags.get(6)==1 ) ||
    					(flags.get(1)==1 &&  flags.get(4)==1 && flags.get(7)==1 ) ||
    					(flags.get(2)==1 &&  flags.get(5)==1 && flags.get(8)==1 ) ||
    					(flags.get(0)==1 &&  flags.get(4)==1 && flags.get(8)==1 ) ||
    					(flags.get(2)==1 &&  flags.get(4)==1 && flags.get(6)==1 ) 
    					
    					)
    			{
    				if(gameType==1) {
    					JOptionPane.showMessageDialog(this, "YOU ARE THE WINNER");
    				}
    				else {
    					winner=1;
    				}
    				return true;
    				
    			}
    			
    			else if(flags.get(0)==0 ||  flags.get(1)==0 || flags.get(2)==0  || 
    					flags.get(3)==0 ||  flags.get(4)==0 || flags.get(5)==0  ||
    					flags.get(6)==0 ||  flags.get(7)==0 || flags.get(8)==0  ) 
    			{
    				return false;
    				
    			}
    			
    			
    			
    			else {
    				if(gameType==1) {
    					JOptionPane.showMessageDialog(this, "DRAW");
    				}
    				else {
    					winner=-1;
    				}
    				return true;
    			}
    		
		}
	

}

