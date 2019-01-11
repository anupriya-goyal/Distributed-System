package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Database {
	Connection conn;
    Statement stmt;
	
	public void addPublisher(String pubstopic, String pubcontent) throws ClassNotFoundException{
		
    
	try {
		Class.forName("com.mysql.jdbc.Driver");  
		conn = DriverManager.getConnection(    //creating a connection object and connection to waypoints databse.
		        "jdbc:mysql://db:3306/pub_sub?connectTimeout=0&amp;socketTimeout=0&amp;autoReconnect=true", "root", "password");
		 stmt = conn.createStatement();
		   String sqlInsert = "insert into publisher(pub_topic,pub_content) "  //
	               + "values ('" + pubstopic + "' , '" + pubcontent +"' )";
	         System.out.println("The SQL query is: " + sqlInsert);  // Echo for debugging
	         
	      int countInserted = stmt.executeUpdate(sqlInsert);   // executing the command on db

	         System.out.println(countInserted + " records inserted.\n");	 // Echo for debugging
	      
	      


		 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
public List<String> getSubscribers(String getsubtopic)throws ClassNotFoundException{
		
		List<String> names= new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			conn = DriverManager.getConnection(    //creating a connection object and connection to waypoints databse.
			        "jdbc:mysql://db:3306/pub_sub?connectTimeout=0&amp;socketTimeout=0&amp;autoReconnect=true", "root", "password");
			 stmt = conn.createStatement();
			   String sqlretrieve = "select * from subscriber where sub_topic = '"+getsubtopic+"'";  //
		              
		         System.out.println("The SQL query is: " + sqlretrieve);  // Echo for debugging
		         ResultSet rs = stmt.executeQuery(sqlretrieve);
		         while (rs.next()) {
		        	  String lastName = rs.getString("sub_name");
		        	  names.add(lastName);
		        	  System.out.println(lastName + "\n");
		        	}	 // Echo for debugging
		      
		      


			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return names;
		
	}


     
	
		

	
}

