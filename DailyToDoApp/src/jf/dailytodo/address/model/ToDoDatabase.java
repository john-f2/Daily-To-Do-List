package jf.dailytodo.address.model;
/**
 * 
 * Database class for ToDoApp project 
 * Uses Sqlite as the database 
 * 
 * 
 * @author johnfu
 * 
 * 
 */

import java.sql.*;
import java.time.LocalDate;
import java.util.Date;

import javafx.scene.image.Image;
import jf.dailytodo.address.util.DateHashMap;
import jf.dailytodo.address.util.EventEntry;

import java.util.Calendar;

public class ToDoDatabase {
	
	//private member variables 
	//I use this private variables like connection pooling, I won't want to continually open and 
	//close these connections, I will close them when the application ends 
	private static Connection db = null;
	private static Statement stmt = null;
	private static DateHashMap dateMap = new DateHashMap();
	
	 
	
	
	
	/**
	 * establishes connection to database
	 * called in Start() in MainApp
	 * @return true if successful else false
	 */
	public static boolean establishConnection() {
		
		try {
	         Class.forName("org.sqlite.JDBC");
	         //the database is called flashcards.db
	         db = DriverManager.getConnection("jdbc:sqlite:dailytodo.db");
	         stmt = db.createStatement();
			
			return true;
			
		}
		catch(Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.out.println("Could not close connections");
			return false;
			
		}
		
	}
	
	
	
	/**
	 * closes connection and statement to database
	 * called when application ends at stop() in MainApp
	 * 
	 * @return true if successful else false 
	 */
	public static boolean closeConnection() {
		
		try {
			//closes the connection and the statement
			//called at the stop() in MainApp
			stmt.close();
			db.close();
			return true;
			
		}
		catch (Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.out.println("Could not close connections");
			return false;
			
		}	
		
	}
	
	
	/**
	 * 
	 * Gets today's date as a string 
	 * 
	 * @return String 
	 */
	public static String getTodayDate() {
		
		//localDateTime is set to today's date 
		LocalDate localDateTime = LocalDate.now();
		
		//in order convert to a calendar object, we need to convert the LocalDate
		//object to a Date object
		Date date = java.sql.Date.valueOf(localDateTime);
		
		//converts the date to a int which will represent what day of the week today is
		Calendar dayConvert = Calendar.getInstance();
		dayConvert.setTime(date);
		
		//days start from 1 (Sunday) 
		//ex: Wednesday is 4 on the calendar 
		int todayDayAsInt = dayConvert.get(Calendar.DAY_OF_WEEK);
		
		return dateMap.getDate(todayDayAsInt);
		
		
	}
	
	
	
	
	
	/**
	 * 
	 * my initial table for the daily to-do list app
	 * it will create a new table based on today's day
	 * called in start() in the MainApp 
	 * 
	 * @return true if the table was successfully created, false if it wasn't or an error had occurred 
	 */
	public static boolean createDailyTable() {
		
		try {
			String query = "CREATE TABLE IF NOT EXISTS todolist " +
							"(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
							+ "title TEXT NOT NULL,"
							+ "location TEXT NOT NULL,"
							+ "start_time TEXT NOT NULL,"
							+ "end_time TEXT NOT NULL,"
							+ "description TEXT NOT NULL,"
							+ "day TEXT NOT NULL)";
			
			stmt.executeUpdate(query);
			
			
				
			
			
			return true;
		}
		catch(Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return false;
		}
		
		
	}
	
	/**
	 * Adds a new event to todolist database
	 * @param event
	 * @return true if successful, else false
	 */
	public boolean addEvent(EventEntry event) {
		try {
			
			String query = "INSERT INTO todolist(title,location,start_time,"
					+ "end_time,description,day) VALUES(?,?,?,?,?,?)";
			
			PreparedStatement psmt = db.prepareStatement(query);
			psmt.setString(1, event.getTitle());
			psmt.setString(2, event.getLocation());
			psmt.setString(3,event.getStartTime());
			psmt.setString(4, event.getEndTime());
			psmt.setString(5, event.getDescription());
			psmt.setString(6, getTodayDate());;
			
			psmt.executeUpdate();
			psmt.close();
			
			return true;
		}
		catch(Exception e) 
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return false;
		}
		
		
	}
	
	public static void deleteDailyTable() {
		try {
			String dropQuery = "DROP TABLE IF EXISTS todolist";
			stmt.executeUpdate(dropQuery);
			
		}
		catch(Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
		
		
	}
	

}

