/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yambclient.ui.login;

import java.io.FileNotFoundException;
import java.io.IOException;
import rs.ac.bg.fon.silab.lib.korisnik.Korisnik;
import yambclient.controller.GeneralFXMLDocumentController;
import yambclient.controller.GeneralGUIController;
import yambclient.session.Session;
import yambclient.ui.login.listener.LoginListener;

/**
 *
 * @author MARINA
 */
public class LoginGUIController extends GeneralGUIController{

    public LoginGUIController(GeneralFXMLDocumentController fxcon) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException, FileNotFoundException, ClassNotFoundException {
        super(fxcon);
        FXMLDocumentControllerLogin con = (FXMLDocumentControllerLogin)fxcon;
        con.getLogin().setOnAction(new LoginListener(this));
    }

    @Override
    public boolean fillTheFormFromObject() {
        
        return true;
    }

    @Override
    public boolean fillTheObjectFromAForm() {
        FXMLDocumentControllerLogin con = (FXMLDocumentControllerLogin)fxcon;
        Session.getInstance().setKorisnik(new Korisnik( con.getUsername().getText(), con.getPassword().getText()));
        return true;
    }

    @Override
    public void fillTheEmptyForm() {
        FXMLDocumentControllerLogin con = (FXMLDocumentControllerLogin)fxcon;
        con.getUsername().setText("");
        con.getPassword().setText("");
    }
    
}
