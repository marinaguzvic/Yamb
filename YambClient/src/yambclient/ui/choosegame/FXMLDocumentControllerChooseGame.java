/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yambclient.ui.choosegame;

import java.io.IOException;
import yambclient.ui.login.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;
import rs.ac.bg.fon.silab.server.web.Game;
import yambclient.controller.GeneralFXMLDocumentController;
import yambclient.ui.choosegame.list.Igra;

/**
 *
 * @author MARINA
 */
public class FXMLDocumentControllerChooseGame extends GeneralFXMLDocumentController implements Initializable {
    
    @FXML
    private Label username;
    @FXML
    private Button createNewGameBtn;
    @FXML
    private Button refreshGamesBtn;
    @FXML
    private Button joinGameBtn;
    @FXML
    private ListView<Igra> games; 
    
    private ChooseGameGUIController chooseGameController;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            chooseGameController = new ChooseGameGUIController(this);
        }  catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }    

    public Label getUsername() {
        return username;
    }

    public void setUsername(Label username) {
        this.username = username;
    }

    public Button getCreateNewGameBtn() {
        return createNewGameBtn;
    }

    public void setCreateNewGameBtn(Button createNewGameBtn) {
        this.createNewGameBtn = createNewGameBtn;
    }

    public Button getRefreshGamesBtn() {
        return refreshGamesBtn;
    }

    public void setRefreshGamesBtn(Button refreshGamesBtn) {
        this.refreshGamesBtn = refreshGamesBtn;
    }

    public Button getJoinGameBtn() {
        return joinGameBtn;
    }

    public void setJoinGameBtn(Button joinGameBtn) {
        this.joinGameBtn = joinGameBtn;
    }

    public ListView<Igra> getGames() {
        return games;
    }

    public void setGames(ListView<Igra> games) {
        this.games = games;
    }

    public ChooseGameGUIController getChooseGameController() {
        return chooseGameController;
    }

    public void setChooseGameController(ChooseGameGUIController chooseGameController) {
        this.chooseGameController = chooseGameController;
    }


    @Override
    public void closeForm() {
        Stage stage = (Stage) username.getScene().getWindow();
        stage.close();
    }

    void showForm() {
        Stage stage = (Stage) username.getScene().getWindow();
        stage.show();
    }
    
}
