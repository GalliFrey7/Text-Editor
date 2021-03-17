package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.tree.DefaultTreeCellEditor;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader =new FXMLLoader(getClass().getResource("sample.fxml"));
        loader.setControllerFactory(t -> new Controller(new EditorModel()));
        stage.setTitle("Text Editor");
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
