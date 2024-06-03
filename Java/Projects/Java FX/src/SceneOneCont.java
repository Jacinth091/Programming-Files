import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneOneCont {

    @FXML
    TextField userTextField;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String css = this.getClass().getResource("AppCss.css").toExternalForm();


    public void login(ActionEvent e) throws IOException {

        String userName = userTextField.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene2.fxml"));
        root = loader.load();

        SceneTwoCont scene2Cont = loader.getController();
        scene2Cont.displayName(userName);
//        root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getCss());
        stage.setScene(scene);
        stage.show();
    }
    public String getCss(){
        return this.css;
    }
}
