package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class Database {
	
		
	public void addSubscriber(String subname,String subtopic) throws ClassNotFoundException{
		 Connection conn;
		    Statement stmt;
			try {
				Class.forName("com.mysql.jdbc.Driver");  
				conn = DriverManager.getConnection(    //creating a connection object and connection to waypoints databse.
				        "jdbc:mysql://db:3306/pub_sub?connectTimeout=0&amp;socketTimeout=0&amp;autoReconnect=true", "sub", "password");
				 stmt = conn.createStatement();
				   String sqlInsert = "insert into subscriber(sub_name,sub_topic) "  //
			               + "values ( '" + subname + "' , '" + subtopic +"' )";
			         System.out.println("The SQL query is: " + sqlInsert);  // Echo for debugging
			         
			      int countInserted = stmt.executeUpdate(sqlInsert);   // executing the command on db

			         System.out.println(countInserted + " records inserted.\n");	 // Echo for debugging
			      
			      


				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
			
				

			}
	
	public String getRecentContent(String subtopic) throws ClassNotFoundException{

		 Connection conn;
	    Statement stmt;
	    String lastName=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			conn = DriverManager.getConnection(    //creating a connection object and connection to waypoints databse.
			        "jdbc:mysql://db:3306/pub_sub?connectTimeout=0&amp;socketTimeout=0&amp;autoReconnect=true", "sub", "password");
			 stmt = conn.createStatement();
			   String sqlretrieve = "select pub_content from publisher  order by id DESC LIMIT 1";  //
		              
		         System.out.println("The SQL query is: " + sqlretrieve);  // Echo for debugging
		         
		     // int countInserted = stmt.executeUpdate(sqlretrieve);   // executing the command on db

		      ResultSet rs = stmt.executeQuery(sqlretrieve);
		         while (rs.next()) {
		        	 lastName= rs.getString("pub_content");
		        	  //names.add(lastName);
		        	  System.out.println(lastName + "\n");
		        	  break;
		        	}	
		      
		      


			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
		
			

		return lastName;
	}
	

	}
	


