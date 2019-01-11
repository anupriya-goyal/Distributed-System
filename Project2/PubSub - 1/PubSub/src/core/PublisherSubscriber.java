package core;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class PublisherSubscriber {
	String fname,lname;
	public static final Map<String,List<String>> topicsubscribers= new HashMap<String, List<String>>();
	
	
	

	public Map addPublisher(String fname,String lname) {
		// TODO Auto-generated method stub
		
		Map<String,String> publishers= new HashMap<String, String>();
		publishers.put(fname, lname);
		
		return publishers;
		
	}



	public Map addSubscriber(String subname, String subtopic) {
		// TODO Auto-generated method stub
		
		List<String> subscribers= new LinkedList<String>();
		
		
		if(topicsubscribers.containsKey(subtopic)){
			subscribers=topicsubscribers.get(subtopic);
			subscribers.add(subname);
			topicsubscribers.put(subtopic, subscribers);
		}
		else{
			subscribers.add(subname);
			topicsubscribers.put(subtopic, subscribers);
		}
		
		System.out.println("topicss"+topicsubscribers);
		
		return topicsubscribers;
	}



	public List getsubscribersfortopic(String pubtopic) {
		// TODO Auto-generated method stub
		
		
		return topicsubscribers.get(pubtopic);
	}
	
}
