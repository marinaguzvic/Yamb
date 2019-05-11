/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yambclient.ui.game;

import java.io.IOException;
import yambclient.ui.login.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rs.ac.bg.fon.silab.server.web.Field;
import rs.ac.bg.fon.silab.server.web.FieldArray;
import yambclient.controller.GeneralFXMLDocumentController;
import yambclient.ui.game.table.Row;

/**
 *
 * @author MARINA
 */
public class FXMLDocumentControllerGame extends GeneralFXMLDocumentController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private TableView table;
    @FXML
    private TableColumn<Row, String> header;
    @FXML
    private TableColumn<Row, Field> downwards;
    @FXML
    private TableColumn<Row, Field> mixed;
    @FXML
    private TableColumn<Row, Field> upwards;
    @FXML
    private TableColumn<Row, Field> najava;
    @FXML
    private ImageView dice1;
    @FXML
    private ImageView dice2;
    @FXML
    private ImageView dice3;
    @FXML
    private ImageView dice4;
    @FXML
    private ImageView dice5;
    @FXML
    private CheckBox dice1check;
    @FXML
    private CheckBox dice2check;
    @FXML
    private CheckBox dice3check;
    @FXML
    private CheckBox dice4check;
    @FXML
    private CheckBox dice5check;
    @FXML
    private Button throwDicesBtn;
    @FXML
    private Label throwsNo;
    @FXML
    private Button startGameBtn;
    @FXML
    private Button najaviBtn;
    @FXML
    private Button upisiRezultatBtn;
    @FXML
    private TextField poljeText;
    @FXML
    private Button zavrsiIgruBtn;
    @FXML
    private MenuItem logoutMenuItem;
    @FXML
    private VBox opponentsVbox;
    @FXML
    private Label usernameLbl;
    @FXML
    private Label resultLbl;
    @FXML
    private Button refreshOpponentListBtn;

    public Button getRefreshOpponentListBtn() {
        return refreshOpponentListBtn;
    }

    public void setRefreshOpponentListBtn(Button refreshOpponentListBtn) {
        this.refreshOpponentListBtn = refreshOpponentListBtn;
    }

    public VBox getOpponentsVbox() {
        return opponentsVbox;
    }

    public void setOpponentsVbox(VBox opponentsVbox) {
        this.opponentsVbox = opponentsVbox;
    }

    public Label getUsernameLbl() {
        return usernameLbl;
    }

    public void setUsernameLbl(Label usernameLbl) {
        this.usernameLbl = usernameLbl;
    }

    public Label getResultLbl() {
        return resultLbl;
    }

    public void setResultLbl(Label resultLbl) {
        this.resultLbl = resultLbl;
    }
    

    public MenuItem getLogoutMenuItem() {
        return logoutMenuItem;
    }

    public void setLogoutMenuItem(MenuItem logoutMenuItem) {
        this.logoutMenuItem = logoutMenuItem;
    }

    public Button getZavrsiIgruBtn() {
        return zavrsiIgruBtn;
    }

    public void setZavrsiIgruBtn(Button zavrsiIgruBtn) {
        this.zavrsiIgruBtn = zavrsiIgruBtn;
    }

    private GameGUIController gameGUIController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            gameGUIController = new GameGUIController(this);
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

    public TableView getTable() {
        return table;
    }

    public void setTable(TableView table) {
        this.table = table;
    }

    public ImageView getDice1() {
        return dice1;
    }

    public void setDice1(ImageView dice1) {
        this.dice1 = dice1;
    }

    public ImageView getDice2() {
        return dice2;
    }

    public void setDice2(ImageView dice2) {
        this.dice2 = dice2;
    }

    public ImageView getDice3() {
        return dice3;
    }

    public void setDice3(ImageView dice3) {
        this.dice3 = dice3;
    }

    public ImageView getDice4() {
        return dice4;
    }

    public void setDice4(ImageView dice4) {
        this.dice4 = dice4;
    }

    public ImageView getDice5() {
        return dice5;
    }

    public void setDice5(ImageView dice5) {
        this.dice5 = dice5;
    }

    public CheckBox getDice1check() {
        return dice1check;
    }

    public void setDice1check(CheckBox dice1check) {
        this.dice1check = dice1check;
    }

    public CheckBox getDice2check() {
        return dice2check;
    }

    public void setDice2check(CheckBox dice2check) {
        this.dice2check = dice2check;
    }

    public CheckBox getDice3check() {
        return dice3check;
    }

    public void setDice3check(CheckBox dice3check) {
        this.dice3check = dice3check;
    }

    public CheckBox getDice4check() {
        return dice4check;
    }

    public void setDice4check(CheckBox dice4check) {
        this.dice4check = dice4check;
    }

    public CheckBox getDice5check() {
        return dice5check;
    }

    public void setDice5check(CheckBox dice5check) {
        this.dice5check = dice5check;
    }

    public Button getThrowDicesBtn() {
        return throwDicesBtn;
    }

    public void setThrowDicesBtn(Button throwDicesBtn) {
        this.throwDicesBtn = throwDicesBtn;
    }

    public Label getThrowsNo() {
        return throwsNo;
    }

    public void setThrowsNo(Label throwsNo) {
        this.throwsNo = throwsNo;
    }

    public Button getStartGameBtn() {
        return startGameBtn;
    }

    public void setStartGameBtn(Button startGameBtn) {
        this.startGameBtn = startGameBtn;
    }

    public GameGUIController getGameGUIController() {
        return gameGUIController;
    }

    public void setGameGUIController(GameGUIController gameGUIController) {
        this.gameGUIController = gameGUIController;
    }

    public TableColumn<Row, Field> getDownwards() {
        return downwards;
    }

    public void setDownwards(TableColumn<Row, Field> downwards) {
        this.downwards = downwards;
    }

    public TableColumn<Row, Field> getMixed() {
        return mixed;
    }

    public void setMixed(TableColumn<Row, Field> mixed) {
        this.mixed = mixed;
    }

    public TableColumn<Row, Field> getUpwards() {
        return upwards;
    }

    public void setUpwards(TableColumn<Row, Field> upwards) {
        this.upwards = upwards;
    }

    public TableColumn<Row, Field> getNajava() {
        return najava;
    }

    public void setNajava(TableColumn<Row, Field> najava) {
        this.najava = najava;
    }

    public TableColumn<Row, String> getHeader() {
        return header;
    }

    public void setHeader(TableColumn<Row, String> header) {
        this.header = header;
    }

    @Override
    public void closeForm() {
        Stage stage = (Stage) username.getScene().getWindow();
        stage.close();
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }

    public Button getNajaviBtn() {
        return najaviBtn;
    }

    public void setNajaviBtn(Button najaviBtn) {
        this.najaviBtn = najaviBtn;
    }

    public Button getUpisiRezultatBtn() {
        return upisiRezultatBtn;
    }

    public void setUpisiRezultatBtn(Button upisiRezultatBtn) {
        this.upisiRezultatBtn = upisiRezultatBtn;
    }

    public TextField getPoljeText() {
        return poljeText;
    }

    public void setPoljeText(TextField poljeText) {
        this.poljeText = poljeText;
    }

}
