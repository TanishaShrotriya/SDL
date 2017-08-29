package server;

import java.sql.*;
import java.util.*;

public  class Operations {

 public String insert(Connection conn,Student s1) {
		 try {
			  PreparedStatement st = conn.prepareStatement("insert into Student values (?,?,?,?,?)");
	    	  st.setInt(1,s1.roll);
	    	  st.setString(2,s1.name);
	    	  st.setFloat(3,s1.gpa);
	    	  st.setFloat(4,s1.percent);
	    	  st.setInt(5,s1.year);
         	  st.execute();
	    	  return "Received";
	      }
	  
	      catch(SQLException k) {
	    	  k.printStackTrace();
	    	  return "Error";
	      }
	    
	}
	
 public ArrayList display (Connection conn) {
		
	 ArrayList<Student> a= new ArrayList<Student>();
	
	  try {
	 	    
		       Statement stmt = conn.createStatement();
	 	       String query="select * from Student;";
		       ResultSet ss=stmt.executeQuery(query);
		       
		       while(ss.next())
	
		        {       Student s = new Student();
		                s.roll=ss.getInt("roll");
		                s.name=ss.getString("name");
		                s.gpa=ss.getFloat("gpa");
		                s.percent=ss.getFloat("percent");
		                s.year=ss.getInt("year");
		                a.add(s);
		        }
		       return a;
	    }
		 catch(SQLException s) {
		 	  s.printStackTrace();
		 	  a.clear();
		 	  return a;
		 }

 
 }
 
 public String update(Connection conn,int r,Float gp,Float percent) {
	 
	  try {
	 	    
		  PreparedStatement st1 = conn.prepareStatement("update Student set gpa= ? where roll= ?;");
		  PreparedStatement st2 = conn.prepareStatement("update Student set percent= ? where roll= ?;");
	   
    	  st1.setFloat(1,gp);
    	  st1.setInt(2, r);
    	  st2.setFloat(1,percent);
    	  st2.setInt(2,r);
     	  st1.execute();
     	  st2.execute();
    	  return "Received";
     }
	 catch(SQLException s) {
	 	  s.printStackTrace();
	      return "Data not updated";
	 }

 }

public String search(Connection conn,int r) {

	  try {
	 	    
		    
	       Statement stmt = conn.createStatement();
	       String query="select * from Student where roll= "+r+";";
	       ResultSet ss=stmt.executeQuery(query);
           
	       Student s = new Student();
	       
	       while(ss.next())
	    		
	        {       
	                s.roll=ss.getInt("roll");
	                s.name=ss.getString("name");
	                s.gpa=ss.getFloat("gpa");
	                s.percent=ss.getFloat("percent");
	                s.year=ss.getInt("year");
	         
	        }
	       return s.toString(); 
     }
	 catch(SQLException s) {
	 	  s.printStackTrace();
	      return "Data not found";
	 }
	  //add test case for not found 
}

public String top(Connection conn) {

	  try {
	 	    
		    
	       Statement stmt = conn.createStatement();
	       String query="select * from Student where percent = (Select max(percent) from Student);";
	       ResultSet ss=stmt.executeQuery(query);
         
	       Student s = new Student();
	       
	       while(ss.next())
	    		
	        {       
	                s.roll=ss.getInt("roll");
	                s.name=ss.getString("name");
	                s.gpa=ss.getFloat("gpa");
	                s.percent=ss.getFloat("percent");
	                s.year=ss.getInt("year");
	         
	        }
	       return s.toString(); 
   }
	 catch(SQLException s) {
	 	  s.printStackTrace();
	      return "Error in query";
	 }
	
}

public String remove(Connection conn,int r) {

	  try {
	 	    
		    
	       Statement stmt = conn.createStatement();
	       String query="delete from Student where roll="+r+"";
	       stmt.executeUpdate(query);
	       return "Delete Success";
 }
	 catch(SQLException s) {
	 	  s.printStackTrace();
	      return "Error in query";
	 }
	
}

public String pOrF(Connection conn) {
	int p=0,f=0;
	try {
	 	    
	       Statement stmt = conn.createStatement();
	       String query="select percent from Student;";
	       ResultSet ss=stmt.executeQuery(query);
	       
	       while(ss.next())

	        {       int roll=ss.getInt("percent");
	                if(roll>70)
	                	p++;
	                else 
	                	f++;
	        } 
   }
	 catch(SQLException s) {
	 	  s.printStackTrace();
	 	
	 }

	return "Number of pass students are = " + p + " number of fail are =  " + f;
}
}