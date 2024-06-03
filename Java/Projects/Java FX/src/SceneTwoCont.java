import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SceneTwoCont {
    @FXML
    Label nameLabel;

    public void displayName(String userName){
        this.nameLabel.setText("Name: " + userName);
    }
}
