/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yambclient.ui.game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextAlignment;
import rs.ac.bg.fon.silab.server.web.Field;
import rs.ac.bg.fon.silab.server.web.FieldArray;
import rs.ac.bg.fon.silab.server.web.Result;
import yambclient.controller.GeneralFXMLDocumentController;
import yambclient.controller.GeneralGUIController;
import yambclient.session.Session;
import yambclient.ui.game.listener.BaciKockiceListener;
import yambclient.ui.game.listener.LogoutListener;
import yambclient.ui.game.listener.NajaviListener;
import yambclient.ui.game.listener.RefreshOpponentsListener;
import yambclient.ui.game.listener.ShowWinnerListener;
import yambclient.ui.game.listener.UpisiRezultatListener;
import yambclient.ui.game.listener.ZapocniIgruListener;
import yambclient.ui.game.listener.ZavrsiIgruIIzracunajRezultatListener;
import yambclient.ui.game.table.Row;

/**
 *
 * @author MARINA
 */
public class GameGUIController extends GeneralGUIController {

    Image[] images = new Image[7];

    public GameGUIController(GeneralFXMLDocumentController fxcon) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException, FileNotFoundException, ClassNotFoundException {
        super(fxcon);
        FXMLDocumentControllerGame con = (FXMLDocumentControllerGame) fxcon;
        con.getNajaviBtn().setOnAction(new NajaviListener(this));
        con.getUpisiRezultatBtn().setOnAction(new UpisiRezultatListener(this));
        con.getThrowDicesBtn().setOnAction(new BaciKockiceListener(this));
        con.getStartGameBtn().setOnAction(new ZapocniIgruListener(this));
        con.getLogoutMenuItem().setOnAction(new LogoutListener(this));
        con.getRefreshOpponentListBtn().setOnAction(new RefreshOpponentsListener(this));
        con.getZavrsiIgruBtn().setOnAction(new ZavrsiIgruIIzracunajRezultatListener(this));
        con.getShowWinnerBtn().setOnAction(new ShowWinnerListener(this));
        loadImages();
        fillTheFormFromObject();
    }

    @Override
    public boolean fillTheFormFromObject() {
        FXMLDocumentControllerGame con = (FXMLDocumentControllerGame) fxcon;
        ObservableList<Row> rows = makeListOfRowsFromMatrix();
        makeTable(con, rows);
        fillDices(con);
        fillNoOfThrows(con);
        toggleBaciKockiceEnabled(con);
        toggleNajaviEnabled(con);
        upisiRezultatDisabled(con);
        toggleStartGameEnabled(con);
        uncheckAllBoxes(con);
        fillResultLabels(con);
        return true;
    }

    @Override
    public boolean fillTheObjectFromAForm() {
        FXMLDocumentControllerGame con = (FXMLDocumentControllerGame) fxcon;
        setChosenDices(con);
        setChosenField(con);
        return true;
    }

    @Override
    public void fillTheEmptyForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void makeTable(FXMLDocumentControllerGame con, ObservableList<Row> rows) {
        con.getTable().getSelectionModel().setCellSelectionEnabled(true);
        con.getHeader().setText("");
        con.getHeader().setMinWidth(100);
        con.getHeader().setSortable(false);
        con.getHeader().setCellValueFactory(new PropertyValueFactory<Row, String>("rowName"));
        con.getDownwards().setText("");
        makeColumn(con.getDownwards(), "downwards");
        con.getMixed().setText("");
        makeColumn(con.getMixed(), "mixed");
        con.getUpwards().setText("");
        makeColumn(con.getUpwards(), "upwards");
        con.getNajava().setText("");
        makeColumn(con.getNajava(), "najava");
        con.getTable().setItems(rows);
//        con.getTable().getColumns().addAll(con.getHeader(), con.getDownwards(), con.getMixed(), con.getUpwards(), con.getNajava());
        con.getTable().setMinWidth(302);
//        con.getTable().getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
//            if (newSelection != null) {
//                Field field = (Field) newSelection;
//                con.getPoljeText().setText("Kolona: " + field.getRow() + ", Red: " + field.getColumn());
//            }
//        });
        con.getTable().getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                //Check whether item is selected and set value of selected item to Label
                if (con.getTable().getSelectionModel().getSelectedItem() != null) {
                    TableViewSelectionModel selectionModel = con.getTable().getSelectionModel();
                    ObservableList selectedCells = selectionModel.getSelectedCells();
                    TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                    Field field = (Field) tablePosition.getTableColumn().getCellData(newValue);
                    con.getPoljeText().setText("Red: " + field.getRow() + ", Kolona: " + field.getColumn());
                    toggleUpisiRezultatEnabled(con);
                }
            }

        });
    }

    private void makeColumn(TableColumn<Row, Field> col, String cellValueProperty) {
        col.setSortable(false);
        col.getStyleClass().add(cellValueProperty);
        col.setMinWidth(50);
        col.setCellValueFactory(new PropertyValueFactory<Row, Field>(cellValueProperty));
        col.setCellFactory(column -> {
            return new TableCell<Row, Field>() {
                @Override
                protected void updateItem(Field item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null && (item.getRow() == 7 || item.getRow() == 10 || item.getRow() == 15)) {
                        getStyleClass().add("highlightedRow");
                    }
                    if (item == null || empty) {
                        setText(null);
                        setStyle("");
                    } else if (item.getValue() == null) {
                        setText(null);
                        setStyle("");
                        if (!item.isAvailable()) {
                            setDisable(true);
                        }
                    } else {
                        setText(item.getValue() + "");
                        setDisable(true);
                    }
                }

            };
        });
    }

    private ObservableList<Row> makeListOfRowsFromMatrix() {
        ObservableList<Row> rows = FXCollections.observableArrayList();
        int i = 0;

        for (FieldArray field : Session.getInstance().getResponse().getMatrix().getFields()) {
            rows.add(new Row(Session.getInstance().getResponse().getMatrix().getRows().get(i++), field));
        }
        return rows;
    }

    private void fillDices(FXMLDocumentControllerGame con) {
        if (Session.getInstance().getResponse() == null || Session.getInstance().getResponse().getDices().size() == 0) {
            for (int i = 1; i < 6; i++) {
                getImage(con, i).setImage(images[0]);
            }
        } else {
            for (int i = 1; i < 6; i++) {
                getImage(con, i).setImage(images[Session.getInstance().getResponse().getDices().get(i - 1)]);
            }
        }

    }

    ImageView getImage(FXMLDocumentControllerGame con, int no) {
        switch (no) {
            case 1:
                return con.getDice1();
            case 2:
                return con.getDice2();
            case 3:
                return con.getDice3();
            case 4:
                return con.getDice4();
            case 5:
                return con.getDice5();
            default:
                return null;
        }
    }

    CheckBox getCheckBox(FXMLDocumentControllerGame con, int no) {
        switch (no) {
            case 1:
                return con.getDice1check();
            case 2:
                return con.getDice2check();
            case 3:
                return con.getDice3check();
            case 4:
                return con.getDice4check();
            case 5:
                return con.getDice5check();
            default:
                return null;
        }
    }

    private void loadImages() {
        for (int i = 0; i < images.length; i++) {
            try {
                images[i] = new Image(new FileInputStream("src/yambclient/images/dices/dice" + i + ".png"));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void setChosenDices(FXMLDocumentControllerGame con) {
        for (int i = 1; i <= 5; i++) {
            CheckBox cb = getCheckBox(con, i);
            boolean selected = cb.isSelected();
            if (selected) {
                request.getDices().add(i - 1);
            }
        }

    }

    private void setChosenField(FXMLDocumentControllerGame con) {
        try {
            ObservableList selectedCells = con.getTable().getSelectionModel().getSelectedCells();
            TablePosition tablePosition = (TablePosition) selectedCells.get(0);
            Field selectedField = (Field) tablePosition.getTableColumn().getCellData(con.getTable().getSelectionModel().getSelectedItem());
            request.setSelectedField(selectedField);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void fillNoOfThrows(FXMLDocumentControllerGame con) {
        int throwsNo = Session.getInstance().getResponse().getNumberOfThrows();
        if (throwsNo < 0) {
            throwsNo = 0;
        }
        con.getThrowsNo().setText(throwsNo + "");
    }

    private void toggleBaciKockiceEnabled(FXMLDocumentControllerGame con) {
        if (Session.getInstance().getResponse().getNumberOfThrows() < 0 || Session.getInstance().getResponse().getNumberOfThrows() == 3) {
            con.getThrowDicesBtn().setDisable(true);
        } else {
            con.getThrowDicesBtn().setDisable(false);
        }
    }

    private void toggleNajaviEnabled(FXMLDocumentControllerGame con) {
        if (Session.getInstance().getResponse().getNumberOfThrows() == 1) {
            con.getNajaviBtn().setDisable(false);
        } else {
            con.getNajaviBtn().setDisable(true);
        }
    }

    private void toggleUpisiRezultatEnabled(FXMLDocumentControllerGame con) {
        if (Session.getInstance().getResponse().getNumberOfThrows() >= 1 && Session.getInstance().getResponse().getNumberOfThrows() <= 3) {
            con.getUpisiRezultatBtn().setDisable(false);
        } else {
            con.getUpisiRezultatBtn().setDisable(true);
        }
    }

    private void upisiRezultatDisabled(FXMLDocumentControllerGame con) {
        con.getUpisiRezultatBtn().setDisable(true);
    }

    private void toggleStartGameEnabled(FXMLDocumentControllerGame con) {
        if (Session.getInstance().getResponse().getNumberOfThrows() == -2) {
            con.getStartGameBtn().setDisable(false);
        } else {
            con.getStartGameBtn().setDisable(true);
        }
    }

    private void uncheckAllBoxes(FXMLDocumentControllerGame con) {
        for (int i = 1; i <= 5; i++) {
            getCheckBox(con, i).setSelected(false);
        }
    }

    private void fillResultLabels(FXMLDocumentControllerGame con) {
        con.getOpponentsVbox().getChildren().clear();
        for (Result opponentResult : Session.getInstance().getResponse().getOpponentResults()) {
            Label label = new Label();
            label.setText(opponentResult.getUsername() + ": " + opponentResult.getResult() + addIfDone(opponentResult.isDone()));
            con.getOpponentsVbox().getChildren().add(label);
        }
        Result result = Session.getInstance().getResponse().getMyResult();
        con.getUsernameLbl().setText(result.getUsername() + ": " + result.getResult() + addIfDone(result.isDone()));
    }

    private String addIfDone(boolean done) {
        if (done) {
            return " DONE";
        } else {
            return "";
        }
    }

}
