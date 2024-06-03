import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class Controller {

    @FXML
    private Circle circle;
    private double x;
    private double y;

    public void up(ActionEvent e){
        System.out.println("UP!!!");
        circle.setCenterY(y-=2);
    }
    public void right(ActionEvent e){
        System.out.println("Right!!!");
        circle.setCenterX(x+=2);

    }
    public void left(ActionEvent e){
        System.out.println("Left!!!");
        circle.setCenterX(x-=2);

    }
    public void down(ActionEvent e){
        System.out.println("Down!!!");
        circle.setCenterY(y+=2);

    }

}
