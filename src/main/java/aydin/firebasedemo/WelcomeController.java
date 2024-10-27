package aydin.firebasedemo;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class WelcomeController {

    @FXML
    private Button registerButton;

    @FXML
    private Button secondaryButton;

    @FXML
    private TextField signInTextField;

    @FXML
    private void switchToPrimary() throws IOException {
        DemoApp.setRoot("primary");
    }
}
