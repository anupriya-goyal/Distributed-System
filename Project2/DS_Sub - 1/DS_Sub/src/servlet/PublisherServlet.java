package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import core.PublisherSubscriber;

/**
 * Servlet implementation class HelloForm
 */
public class PublisherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PublisherServlet() {
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
		response.setContentType("text/html");
		 String pubtopic= request.getParameter("pubtopic");
		 String pubcontent= request.getParameter("pubcontent");
		 PublisherSubscriber publish=new PublisherSubscriber();
		 
		 Map pubres= publish.addPublisher(pubtopic,pubcontent);
		 List subfortopiclist =publish.getsubscribersfortopic(pubtopic);
		
		 PrintWriter out = response.getWriter();
	     
	       out.println(pubres); 
	       out.println(subfortopiclist);
	       /*if(subfortopiclist != null){
	       out.println(subfortopiclist);
	       }
	     */
		doGet(request, response);
	}

}
