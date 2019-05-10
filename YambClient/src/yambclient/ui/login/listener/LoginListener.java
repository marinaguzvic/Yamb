/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yambclient.ui.login.listener;

import javafx.event.Event;
import javafx.event.EventHandler;
import yambclient.controller.GeneralGUIController;
import yambclient.ui.login.LoginGUIController;


/**
 *
 * @author MARINA
 */
public class LoginListener implements EventHandler{
    GeneralGUIController controller;

    public LoginListener(GeneralGUIController controller) {
        this.controller = controller;
    }
    
    

    @Override
    public void handle(Event event) {
        controller.login();
    }
    
}
