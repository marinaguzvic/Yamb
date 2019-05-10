/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yambclient.ui.choosegame;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import rs.ac.bg.fon.silab.server.web.Game;
import yambclient.controller.GeneralFXMLDocumentController;
import yambclient.controller.GeneralGUIController;
import yambclient.session.Session;
import yambclient.ui.choosegame.list.Igra;
import yambclient.ui.choosegame.listener.CreateGameListener;
import yambclient.ui.choosegame.listener.JoinGameListener;
import yambclient.ui.choosegame.listener.RefreshGamesListener;

/**
 *
 * @author MARINA
 */
public class ChooseGameGUIController extends GeneralGUIController{

    public ChooseGameGUIController(GeneralFXMLDocumentController fxcon) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException, FileNotFoundException, ClassNotFoundException {
        super(fxcon);
        FXMLDocumentControllerChooseGame con = (FXMLDocumentControllerChooseGame)fxcon;
        //Add listeners
        con.getCreateNewGameBtn().setOnAction(new CreateGameListener(this));
        con.getJoinGameBtn().setOnAction(new JoinGameListener(this));
        con.getRefreshGamesBtn().setOnAction(new RefreshGamesListener(this));
        getAllGames();
        
    }

    @Override
    public boolean fillTheFormFromObject() {
        FXMLDocumentControllerChooseGame con = (FXMLDocumentControllerChooseGame)fxcon;
        con.getUsername().setText(Session.getInstance().getKorisnik().getUsername());
        ObservableList<Igra> igre = makeObservableList();
        con.getGames().setItems(igre);
        return true;
    }

    @Override
    public boolean fillTheObjectFromAForm() {
        FXMLDocumentControllerChooseGame con = (FXMLDocumentControllerChooseGame)fxcon;
        Igra igra = con.getGames().getSelectionModel().getSelectedItem();
        request.setSelectedGame(igra.getGame());
        return true;
    }

    @Override
    public void fillTheEmptyForm() {
    }

    private ObservableList<Igra> makeObservableList() {
        ObservableList<Igra> igre = FXCollections.observableArrayList();
        for (Game game : Session.getInstance().getResponse().getGames()) {
            igre.add(new Igra(game));
        }
        return igre;
    }



    
}
