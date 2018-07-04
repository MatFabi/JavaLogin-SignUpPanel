package sample.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Database.DatabaseHandler;

public class SignUpController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signUpFirstName;

    @FXML
    private TextField signUpLastName;

    @FXML
    private CheckBox signUpCheckBoxMale;

    @FXML
    private TextField signUpLocation;

    @FXML
    private PasswordField signUpPassword;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField signUpUsername;

    @FXML
    private CheckBox signUpCheckBoxFeMale;

    @FXML
    void initialize() {
        signUpButton.setOnAction(ev->{
            DatabaseHandler databaseHandler = new DatabaseHandler();

            signUpButton.setOnAction(e->{
                databaseHandler.signUpUser(signUpFirstName.getText(),signUpLastName.getText(),signUpUsername.getText()
                        ,signUpPassword.getText(),signUpLocation.getText(), "Male");
            });
        });
    }

}
