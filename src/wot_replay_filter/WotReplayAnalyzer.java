/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wot_replay_filter;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 *
 * @author Timbo
 */
public class WotReplayAnalyzer extends Application {
    
    private TableView table = new TableView();
    private ListView listView = new ListView();
    final public Label directoryLabel =  new Label();
    
    
    @Override
    public void start(final Stage primaryStage) {

        Button btn = new Button();
        ObservableList <Replay> replays = FXCollections.observableArrayList();
        
        directoryLabel.setText("H:\\World of Tanks\\World_of_Tanks_closed_Beta\\replays");
        btn.setText("Select Directory");
        
        ObservableList<String> mockFiles = FXCollections.observableArrayList();
        
        mockFiles.add("20020101_0142_usa-M24_Chaffee_14_siegfried_line.wotreplay");
        mockFiles.add("20020101_0144_germany-Pro_Ag_A_60_asia_miao.wotreplay");
        mockFiles.add("20020101_0152_uk-GB12_Conqueror_14_siegfried_line.wotreplay");
        mockFiles.add("20140305_2223_china-Ch04_T34_1_28_desert.wotreplay");
        mockFiles.add("20140305_2231_germany-Sturer_Emil_14_siegfried_line.wotreplay");
        mockFiles.add("20140306_2048_japan-Chi_To_33_fjord.wotreplay");
        
        for(String s : mockFiles){
            replays.add(splitFileName(s));
        }
        
        TableColumn dateColumn = new TableColumn("Datum");
        TableColumn timeColumn = new TableColumn("Zeit");
        TableColumn nationColumn = new TableColumn("Nation");
        TableColumn tankColumn = new TableColumn("Panzer");
        TableColumn mapColumn = new TableColumn("Karte");

        dateColumn.setCellValueFactory(
            new PropertyValueFactory<Replay,String>("date")
        );
        timeColumn.setCellValueFactory(
            new PropertyValueFactory<Replay,String>("time")
        );
        nationColumn.setCellValueFactory(
            new PropertyValueFactory<Replay,String>("nation")
        );
        tankColumn.setCellValueFactory(
            new PropertyValueFactory<Replay,String>("tank")
        );
        mapColumn.setCellValueFactory(
            new PropertyValueFactory<Replay,String>("map")
        );
        
        table.getColumns().addAll(dateColumn, timeColumn,
                nationColumn, tankColumn, mapColumn);
        
        table.setItems(replays);
        
        btn.setOnAction(new DirectoryEventHandler<ActionEvent>());
        GridPane grid = new GridPane();
        grid.setHgap(4);
        grid.setVgap(1);
        
        grid.add(directoryLabel, 1, 1);
        grid.add(btn, 1, 2);
        grid.add(table, 1, 3);
        
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
    
    /**
     * Splits a filename and returns a Replay object generated from filename
     * @param fileName
     * @return 
     */
    public static Replay splitFileName(String fileName){
        
        int counter = 0;
        Replay r = new Replay();
        
        //split date from String
        String[] dateExtracted = fileName.split("_", 3);
        String date = dateExtracted[0];
        r.setDate(dateExtracted[0]);
        r.setTime(dateExtracted[1]);
        r.setYear(date.substring(0,4));
        r.setMonth(date.substring(4,6));
        r.setDay(date.substring(6));
        r.generateDate();
        r.generateTime();
        
        //split nation
        String[] countryExtracted = dateExtracted[2].split("-");
        r.setNation(countryExtracted[0]);
        
        //split at double integer followed by underscore "_00" to get tank type
        String[] tankExtracted = countryExtracted[1].split("[\\_][\\d][\\d][\\_]");
        r.setTank(tankExtracted[0]);
        
        //split at dot to have map only
        String[] mapExtracted = tankExtracted[1].split("\\.");
        r.setMap(mapExtracted[0]);
        
        return r;
    }
    
    /**
     * searches how many underscores occure in a string
     * currently not needed
     * @param toSearch
     * @return 
     */
    public static int searchUnderscoreOccurances(String toSearch){
        int occurances = 0;
        
        for(int i = 0; i < toSearch.length(); i++){
            if(toSearch.charAt(i) == '_'){
                occurances++;
            }
        }
        return occurances;
    }
}
