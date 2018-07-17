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
import javafx.stage.Modality;
import javafx.stage.Stage;
import jf.dailytodo.address.model.ToDoDatabase;
import jf.dailytodo.address.util.EventEntry;
import jf.dailytodo.address.view.AddNewEventViewController;
import jf.dailytodo.address.view.RootStageController;




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
	
	@Override
	public void stop() {
		
	}
	
	
	public void initRootStage() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootStage.fxml"));
			
			AnchorPane rootStage = (AnchorPane) loader.load();
			
			//sets the scene to the rootStage
			Scene scene = new Scene(rootStage);
			primaryStage.setScene(scene);
			
			
			//gets the RootStageController and then sets the controller with the mainApp
			//purpose is to allow refrence back to the mainController
			//remeber this will give you an exception if you dont see the fxml to the controller class 
			//in scenebuilder!
			RootStageController controller = loader.getController();
            controller.setMainApp(this);
			
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
	
	
	public EventEntry showAddNewEventView() {
		
		try {
			//loads the view 
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AddNewEventView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            //sets the view into a new window stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add New Event");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            
            //sets the view anchorPane to the scene and then sets the dialogStage to that scene
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            AddNewEventViewController controller = loader.getController();
            //set the controller class's dialog stage to the mainApp dialog stage, allows reference back
            controller.setDialogStage(dialogStage);
            
            dialogStage.showAndWait();
            
            return controller.getNewEvent();
            
            
			
		}
		catch(IOException e) {
			e.printStackTrace();
			return new EventEntry();
		}
		
	}
	
	

	public static void main(String[] args) {
		launch(args);
	}
}
