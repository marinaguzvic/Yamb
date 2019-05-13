/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yambclient.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import rs.ac.bg.fon.silab.lib.korisnik.Korisnik;
import rs.ac.bg.fon.silab.lib.transfer.util.IOperation;
import rs.ac.bg.fon.silab.lib.transfer.util.IStatus;
import rs.ac.bg.fon.silab.server.web.RequestObject;
import rs.ac.bg.fon.silab.server.web.ResponseObject;
import rs.ac.bg.fon.silab.server.web.YambService;
import rs.ac.bg.fon.silab.server.web.YambService_Service;
import yambclient.session.Session;
import yambclient.ui.choosegame.ChooseGameFormFactory;
import yambclient.ui.choosegame.ChooseGameGUIController;
import yambclient.ui.game.GameFormFactory;
import yambclient.ui.login.LoginFormFactory;

/**
 *
 * @author Sinisa
 */
public abstract class GeneralGUIController {

    protected GeneralFXMLDocumentController fxcon;
    YambService service;
    protected RequestObject request;

    public GeneralGUIController(GeneralFXMLDocumentController fxcon) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException, FileNotFoundException, ClassNotFoundException {
        this.fxcon = fxcon;
        this.service = new YambService_Service().getYambServicePort();
        request = new RequestObject();

    }

    public void message(String message) {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Poruka:");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(message);
        infoAlert.showAndWait();
    }

    public ResponseObject callSO(String nameSO) {
        request.setOperation(nameSO);
        request.setKorisnickoIme(Session.getInstance().getKorisnik().getUsername());
        request.setSifra(Session.getInstance().getKorisnik().getPassword());
        return service.processRequest(request);
    }

    String responseMessage() {
        return Session.getInstance().getResponse().getMessage();
    }

// fxcon.datumRodjenja.setValue(kor.getDatumRodjenja().toGregorianCalendar().toZonedDateTime().toLocalDate());
    public abstract boolean fillTheFormFromObject();

    //kor.setDatumRodjenja(konvertujLocalDateUXMLGregorianCalendar(fxcon.datumRodjenja.getValue()));
    public abstract boolean fillTheObjectFromAForm();

    public abstract void fillTheEmptyForm();

    public void login() {
        fillTheObjectFromAForm();
        try {
            Session.getInstance().setResponse(callSO(IOperation.LOGIN));
            if (Session.getInstance().getResponse().getCode() == IStatus.OK) {
                message(responseMessage());
                try {
                    if (Session.getInstance().getResponse().getMatrix() == null) {
                        ChooseGameFormFactory.create();
                    } else {
                        GameFormFactory.create();
                    }
                    closeForm();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            } else {
                message(responseMessage());
                fillTheEmptyForm();
            }
        } catch (Exception e) {
            e.printStackTrace();
            fillTheEmptyForm();
        }

    }

    public void getAllGames() throws IOException {
        try {
            Session.getInstance().setResponse(callSO(IOperation.GET_ALL_GAMES));
            fillTheFormFromObject();
        } catch (Exception e) {
            e.printStackTrace();
            closeForm();
            LoginFormFactory.create();
        }
        message(responseMessage());
    }

    public void closeForm() {
        fxcon.closeForm();
    }

    public void createGame() throws IOException {
        request = new RequestObject();
        try {
            Session.getInstance().setResponse(callSO(IOperation.CREATE_NEW_GAME));
            if (Session.getInstance().getResponse().getCode() == IStatus.OK) {
                try {
                    GameFormFactory.create();
                    closeForm();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {

                fillTheEmptyForm();
            }
        } catch (Exception e) {
            e.printStackTrace();
            closeForm();
            LoginFormFactory.create();
        }
        message(responseMessage());
    }

    public void joinGame() throws IOException {
        request = new RequestObject();
        try {
            fillTheObjectFromAForm();
            Session.getInstance().setResponse(callSO(IOperation.JOIN_GAME));
            message(responseMessage());
            if (Session.getInstance().getResponse().getCode() == IStatus.OK) {
                try {
                    GameFormFactory.create();
                    closeForm();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {

                fillTheEmptyForm();
            }
        } catch (Exception e) {
            e.printStackTrace();
            closeForm();
            LoginFormFactory.create();
        }
        message(responseMessage());
    }

    public void najavi() {
        request = new RequestObject();
        fillTheObjectFromAForm();
        Session.getInstance().setResponse(callSO(IOperation.NAJAVI_POLJE));
        if (Session.getInstance().getResponse().getCode() == IStatus.OK) {
            fillTheFormFromObject();
        } else {

        }
        message(responseMessage());
    }

    public void baciKockice() {
        request = new RequestObject();
        fillTheObjectFromAForm();
        Session.getInstance().setResponse(callSO(IOperation.THROW_DICES));
        if (Session.getInstance().getResponse().getCode() == IStatus.OK) {
            fillTheFormFromObject();
        } else {

        }
        message(responseMessage());
    }

    public void upisiRezultat() {
        request = new RequestObject();
        fillTheObjectFromAForm();
        Session.getInstance().setResponse(callSO(IOperation.CALCULTATE_RESULT));
        if (Session.getInstance().getResponse().getCode() == IStatus.OK) {
            fillTheFormFromObject();
        } else {

        }
        message(responseMessage());
    }

    public void zapocniIgru() {
        request = new RequestObject();
        Session.getInstance().setResponse(callSO(IOperation.START_GAME));
        if (Session.getInstance().getResponse().getCode() == IStatus.OK) {
            fillTheFormFromObject();
        } else {

        }
        message(responseMessage());
    }

    public void zavrsiIgruIIzracunajRezultat() {
        request = new RequestObject();
        Session.getInstance().setResponse(callSO(IOperation.END_GAME));
        if (Session.getInstance().getResponse().getCode() == IStatus.OK) {
            fillTheFormFromObject();
        } else {

        }
        message(responseMessage());
    }

    public void logout() {
        request = new RequestObject();
        Session.getInstance().setResponse(callSO(IOperation.LOGOUT));
        if (Session.getInstance().getResponse().getCode() == IStatus.OK) {
            try {
                Session.getInstance().setIgra(null);
                Session.getInstance().setKorisnik(null);
                LoginFormFactory.create();
                closeForm();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {

        }
        message(responseMessage());
    }

    public void refreshOpponents() {
        request = new RequestObject();
        Session.getInstance().setResponse(callSO(IOperation.REFRESH_OPPONENTS));
        if (Session.getInstance().getResponse().getCode() == IStatus.OK) {
            fillTheFormFromObject();
        } else {

        }
        message(responseMessage());
    }
    
    public void showWinner(){
        request = new RequestObject();
        Session.getInstance().setResponse(callSO(IOperation.SHOW_WINNER));
        if (Session.getInstance().getResponse().getCode() == IStatus.OK) {
            try {
                message(Session.getInstance().getResponse().getWinner());
                ChooseGameFormFactory.create();
                closeForm();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {

        }
        message(responseMessage());
    }
}
