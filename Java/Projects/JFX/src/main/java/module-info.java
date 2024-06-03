module org.jacinth.jfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens org.jacinth.jfx to javafx.fxml;
    exports org.jacinth.jfx;
}