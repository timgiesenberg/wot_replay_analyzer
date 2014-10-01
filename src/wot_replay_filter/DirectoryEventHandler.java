/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wot_replay_filter;

import java.io.File;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.DirectoryChooser;
import static wot_replay_filter.Wot_replay_filter.splitFileName;

/**
 *
 * @author tim.giesenberg@me.com
 * @param <ActionEvent>
 */
public class DirectoryEventHandler<ActionEvent> implements EventHandler {

    @Override
    public void handle(Event t) {
        /**
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
        }/**/
    }
    
    
}
