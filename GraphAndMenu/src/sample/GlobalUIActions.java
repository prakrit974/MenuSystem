package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckMenuItem;

import java.io.IOException;

public class GlobalUIActions {

    private FileStruct fileStruct;

    public GlobalUIActions(FileStruct fileStruct) {
        this.fileStruct = fileStruct;
    }


    EventHandler<ActionEvent> SaveEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            try {
                FileMaker fileMaker = new FileMaker(fileStruct);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    EventHandler<ActionEvent> OpenEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {

        }
    };

    public FileStruct getFileStruct() { return fileStruct; }
    public void setFileStruct(FileStruct fileStruct) { this.fileStruct = fileStruct; }
    
}
