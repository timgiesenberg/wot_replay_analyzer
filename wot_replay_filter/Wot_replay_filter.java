/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wot_replay_filter;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author Timbo
 */
public class Wot_replay_filter extends Application {
    
    private TableView table = new TableView();
    private ListView listView = new ListView();
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        Label directoryLabel =  new Label();
        directoryLabel.setText("H:\\World of Tanks\\World_of_Tanks_closed_Beta\\replays");
        btn.setText("Select Directory");
        
        
        
        TableColumn columnFile = new TableColumn("File");
        
        table.getColumns().addAll(columnFile);
        
        
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                DirectoryChooser chooser = new DirectoryChooser();
                chooser.setTitle("JavaFX Projects");
                chooser.setInitialDirectory(new File("H:\\World of Tanks\\World_of_Tanks_closed_Beta\\replays"));
                File selectedDirectory = chooser.showDialog(primaryStage);
                System.out.println(selectedDirectory.getName());
                
                try{
                    directoryLabel.setText(selectedDirectory.getCanonicalPath());
                    File directory = new File(selectedDirectory.getCanonicalPath());
                    ObservableList<String> files = FXCollections.observableArrayList(directory.list());
                    
                    for(int i = 0; i < files.size(); i++){
                        System.out.println("Split the list: " + splitFileName(files.get(i)));
                    }
                    listView.setItems(files);
                    
                
                } catch (IOException io) {
                    io.printStackTrace();
                }
            }
        });
        GridPane grid = new GridPane();
        grid.setHgap(4);
        grid.setVgap(3);
        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        root.getChildren().add(btn);
        
        grid.add(btn, 1, 1);
        grid.add(directoryLabel, 2, 1);
        grid.add(listView, 1, 2);
        
        Scene scene = new Scene(grid, 600, 600);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static Replay splitFileName(String fileName){
        
        Replay r = new Replay();
        String[] s = fileName.split("_", 3);
        String date = s[0];
        r.setDate(d);
        System.out.println("Date " + r.getDate());
        
        return r;
    }
}
