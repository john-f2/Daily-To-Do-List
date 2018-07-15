/**
 * 
 * DateHashMap class
 * used to represent the hash map that will 
 * tie int to a string date 
 * 
 * 
 */
package jf.dailytodo.address.util;

import java.util.HashMap;

public class DateHashMap {
	
	//key:Integer  Value: String
	HashMap<Integer, String> dateMap = new HashMap<>();
	
	//default constructor
	public DateHashMap(){
		dateMap.put(1, "Sunday");
		dateMap.put(2, "Monday");
		dateMap.put(3, "Tuesday");
		dateMap.put(4, "Wednesday");
		dateMap.put(5, "Thursday");
		dateMap.put(6, "Friday");
		dateMap.put(7, "Saturday");
		
		
	}
	
	public String getDate(int dateIntValue) {
		return dateMap.get(dateIntValue);
	}
	
	
	

}
