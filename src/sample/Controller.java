package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import javax.sound.sampled.Line;
import java.io.File;
import java.util.Arrays;

public class Controller {
    @FXML
    private TextArea areaText;

    private TextFile currentTextFile;

    private EditorModel model;

    public Controller(EditorModel model) {

        this.model = model;
    }

    @FXML
    private void onSave() {
        TextFile textFile = new TextFile(currentTextFile.getFile(), Arrays.asList(areaText.getText().split("/n")));
        model.save(textFile);
    }
    @FXML
    private void onLoad() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("./"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            IOResult<TextFile> io = model.load(file.toPath());

            if(io.isOk() && io.hasData()){
                currentTextFile = io.getData();

                areaText.clear();
                currentTextFile.getContent().forEach(Line -> areaText.appendText(Line + "\n"));
            }else{
                System.out.print("failed");
            }
        }
    }
    @FXML
    private void onClose() {
        model.close();
    }
    @FXML
    private void onAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("About");
        alert.setHeaderText("This is a simple text editor, which was done by student of IAU");
        alert.show();
    }
}
