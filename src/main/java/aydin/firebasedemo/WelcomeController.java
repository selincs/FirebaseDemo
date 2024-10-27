package aydin.firebasedemo;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.FirebaseApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class WelcomeController {

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button registerButton;

    @FXML
    private Button secondaryButton;

    @FXML
    private Button signInButton;

    @FXML
    private TextField userSignInTextField;

    @FXML
    void signInUser(ActionEvent event) throws IOException {
        String email = userSignInTextField.getText();
        String password = passwordTextField.getText();
        try {
            UserRecord user = DemoApp.fauth.getUserByEmail(email);
            if (user != null) {
//                if (/*password check*/) {
                System.out.println("User is registered. User ID: " + user.getUid());
                //switch view to other GUI
                switchToPrimary();
//                }
            } else {
                System.out.println("Incorrect password. Please try again.");
            }
        } catch (FirebaseAuthException ex) {
            System.out.println("User is not registered.");
             ex.printStackTrace();
        }
    }

    @FXML
    void registerButtonClicked(ActionEvent event) {
        registerUser();
    }

    public boolean registerUser() {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail("selin@firebase.com")
                .setEmailVerified(false)
                .setPassword("secret")
                .setPhoneNumber("+11234567890")
                .setDisplayName("John Doe")
                .setDisabled(false);

        UserRecord userRecord;
        try {
            userRecord = DemoApp.fauth.createUser(request);
            System.out.println("Successfully created new user with Firebase Uid: " + userRecord.getUid()
                    + " check Firebase > Authentication > Users tab");
            return true;

        } catch (FirebaseAuthException ex) {
            // Logger.getLogger(FirestoreContext.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error creating a new user in the firebase");
            return false;
        }
    }

    @FXML
    private void switchToPrimary() throws IOException {
        DemoApp.setRoot("primary");
    }
}
