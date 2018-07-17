/**
 * 
 * Event Class
 * 
 * Used to represent an event in the application 
 * 
 * @author johnfu
 * 
 */
package jf.dailytodo.address.util;

public class EventEntry {
	
	//member variables
	
	//this id is for the database 
	private int id;
	private String title;
	private String location;
	private String startTime;
	private String endTime;
	private String description;
	
	
	//constructor
	
	//default
	public EventEntry() {
		title = "";
		
	}

	public EventEntry(int id, String title, String location, String startTime, String endTime, String description) {
		this.id = id;
		this.title = title;
		this.location = location;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
	}
	
	
	//public member methods
	
	//sets the private variables 
	public void setId(int newId) {
		this.id = newId;
		
	}
	
	public void setTitle(String newTitle) {
		this.title = newTitle;
		
	}
	
	public void setLocation(String newLocation) {
		this.location = newLocation;
		
	}
	
	public void setStartTime(String newStartTime) {
		this.startTime = newStartTime;
		
	}
	
	public void setEndTime(String newEndTime) {
		this.endTime = newEndTime;
		
	}
	
	public void setDescription(String newDescription) {
		this.description = newDescription;
		
	}
	
	//returns the private member variables 
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public String getDescription() {
		return description;
	}
	
	

}
