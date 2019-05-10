/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yambclient.ui.choosegame.listener;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import yambclient.controller.GeneralGUIController;

/**
 *
 * @author MARINA
 */
public class JoinGameListener implements EventHandler{
    
    GeneralGUIController con;

    public JoinGameListener(GeneralGUIController con) {
        this.con = con;
    }


    
    @Override
    public void handle(Event event) {
        try {
            con.joinGame();
        } catch (IOException ex) {
            ex.printStackTrace();
            con.message("Error: " + ex.getMessage());
        }
    }
    
}
