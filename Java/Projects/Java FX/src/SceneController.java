import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class SceneController {

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String css = this.getClass().getResource("AppCss.css").toExternalForm();


    public void switchScene1(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();

    }

    public void switchScene2(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();

    }
}
