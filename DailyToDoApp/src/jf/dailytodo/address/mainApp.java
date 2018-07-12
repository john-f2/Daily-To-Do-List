/**
 * 
 * dailytodo project mainApp
 * Starting point for the Javafx application and sets and manages the Stages 
 * 
 * @author johnfu
 * 
 */
package jf.dailytodo.address;

import javafx.application.Application;
import javafx.stage.Stage;
import jf.dailytodo.address.model.ToDoDatabase;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) {
		ToDoDatabase.createDailyTable();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
