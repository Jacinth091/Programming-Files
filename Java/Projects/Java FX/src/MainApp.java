

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

import java.util.Objects;


public class MainApp extends Application{


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        String css = this.getClass().getResource("AppCss.css").toExternalForm();
//        Group root = new Group();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(css);


        stage.setScene(scene);
        stage.show();
    }


}
