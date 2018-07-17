/**
 * 
 * AddNewEventViewController
 * 
 * controller class to the AddNewEventView 
 * 
 * @author johnfu
 * 
 */
package jf.dailytodo.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jf.dailytodo.address.util.EventEntry;

public class AddNewEventViewController {
	
	
	@FXML
	private TextField title;
	
	@FXML
	private TextField locationField;
	
	@FXML
	private TextField startTime;
	
	@FXML
	private TextField endTime;
	
	@FXML
	private TextArea description;
	
	
	@FXML
	private Label errorMsg;
	
	private Stage dialogStage;
	
	//this boolean is to tell the main app that ok is pressed and we can go get the new Event object
	private boolean okPressed =false;
	
	private EventEntry newEvent = new EventEntry();
	
	
	/**
	 * 
	 * initialization function
	 * sets the errorMsg label to blank at first 
	 * 
	 */
	@FXML
	private void initialize() {
		
		errorMsg.setText("");
		
	}
	
	
	
	 /**
	  * used to set up a new window for this scene
	  * sets the mainApp dialogStage to this class dialog stage, allows reference back
	  * @param dialogStage
	  */
	 public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	   
	}
	
//	/**
//	 * 
//	 * this function will be called in mainApp and 
//	 * will see if the okPressed boolean is true,
//	 * if true then mainApp will call the method getNewEvent()
//	 * if false, then the main app will do nothing 
//	 *  
//	 * @return
//	 */
//	public boolean getOkBoolean() {
//		return okPressed;
//	}
	
	public EventEntry getNewEvent() {
		return newEvent;
	}
	 
	 
	
	/**
	 * 
	 * 
	 * gives the ok button functionality 
	 * checks the textFields and textArea to see if it has 
	 * valid inputs using the private method checkValidInputs()
	 * if valid then it will set the newEvent Event Object with the
	 * inputed fields 
	 * 
	 * 
	 * 
	 */
	@FXML
	private void handleOk(){
		//checks input fields first
		if( checkValidInputs()) {
			newEvent.setTitle(title.getText());
			newEvent.setLocation(locationField.getText());
			newEvent.setStartTime(startTime.getText());
			newEvent.setEndTime(endTime.getText());
			newEvent.setDescription(description.getText());
			
			
			//closes dialog stage
			dialogStage.close();
			
		}
		
	}
	
	
	/**
	 * closes dialog stage, does nothing 
	 */
	@FXML
	private void handleCancel() {
		
		dialogStage.close();
		
	}
	
	
	/**
	 * 
	 * checks if the user's inputed values in the view are valid
	 * used in the handleOk method 
	 * 
	 * 
	 * @return true if all inputs are valid 
	 */
	private boolean checkValidInputs() {
		
		if(title.getText() == null || title.getText().length() == 0) {
			errorMsg.setText("ERROR: No Title was entered, Entries must have a title");
			return false;
			
		}
		//currently I will have it where every field is necessary, but i am thinking of changing it later
		//to only title is necessary 
		else if(locationField.getText() == null || locationField.getText().length() == 0) {
			
			return false;
		}
		else if(startTime.getText() == null || startTime.getText().length() ==0)
		{
			return false;
		}
		else if(endTime.getText() == null || endTime.getText().length() ==0)
		{
			return false;
		}
		else if(description.getText() == null || description.getText().length() ==0)
		{
			return false;
		}
		
		
		
		return true;
	}
	
	

	
	

}
