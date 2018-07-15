/**
 * 
 * dailytodo project mainApp
 * Starting point for the Javafx application and sets and manages the Stages 
 * 
 * @author johnfu
 * 
 */
package jf.dailytodo.address;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import jf.dailytodo.address.model.ToDoDatabase;


public class MainApp extends Application {
	
	//Private member variables used for scene management
    private Stage primaryStage;
    //private BorderPane rootStage;
	
 

	@Override
	public void start(Stage primaryStage) {
		ToDoDatabase.createDailyTable();
		
		
		
		
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Daily To Do List");
        
        this.primaryStage.getIcons().add(new Image("file:resources/images/if_icon-86-document-list_314769.png"));
        
		initRootStage();
		
	}
	
	
	public void initRootStage() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootStage.fxml"));
			
			AnchorPane rootStage = (AnchorPane) loader.load();
			
			//sets the scene to the rootStage
			Scene scene = new Scene(rootStage);
			primaryStage.setScene(scene);
			
			primaryStage.show();
			
			
			//looks up the split pane divider and then set it to transparent 
			//gets rid of that ugly divider in split panes 
		    Node paneDivider = rootStage.lookup(".split-pane-divider");
		    if(paneDivider!=null){
		        paneDivider.setStyle("-fx-background-color: transparent;");
		    }
			
			
			
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

	public static void main(String[] args) {
		launch(args);
	}
}
