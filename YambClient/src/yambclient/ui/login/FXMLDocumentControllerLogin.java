/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yambclient.ui.login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import yambclient.controller.GeneralFXMLDocumentController;

/**
 *
 * @author MARINA
 */
public class FXMLDocumentControllerLogin extends GeneralFXMLDocumentController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    
    

    public LoginGUIController loginController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loginController = new LoginGUIController(this);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public TextField getUsername() {
        return username;
    }

    public void setUsername(TextField username) {
        this.username = username;
    }

    public PasswordField getPassword() {
        return password;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }

    public Button getLogin() {
        return login;
    }

    public void setLogin(Button login) {
        this.login = login;
    }

@Override
    public void closeForm() {
        Stage stage = (Stage) username.getScene().getWindow();
        stage.close();
    }



}
