package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import core.PublisherSubscriber;

/**
 * Servlet implementation class SubscriberServlet
 */
public class SubscriberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubscriberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PublisherSubscriber publish=new PublisherSubscriber();
		String subtopic= request.getParameter("subtopic");
		 String subname=request.getParameter("subname");
if(request.getParameter("flag").equals("refresh")){
	
	 
			String getRecentContent = publish.getRecentContent(subtopic);
			 PrintWriter out = response.getWriter();
			 out.println(getRecentContent);
			}
			
		
		
		 
if(request.getParameter("flag").equals("addSub")){
		 
		 Map subres=publish.addSubscriber(subname,subtopic);
		 
		 PrintWriter out = response.getWriter();
		 out.println(subname+","+subtopic);
	    
	
		}
		doGet(request, response);
	}
	

}
