package aydin.firebasedemo;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SecondaryController {

    @FXML
    private Button registerBtn;

    @FXML
    private Button secondaryButton;

    @FXML
    private void switchToPrimary() throws IOException {
        DemoApp.setRoot("primary");
    }
}
