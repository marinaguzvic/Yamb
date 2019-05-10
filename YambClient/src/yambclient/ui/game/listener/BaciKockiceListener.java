/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yambclient.ui.game.listener;

import javafx.event.Event;
import javafx.event.EventHandler;
import yambclient.controller.GeneralGUIController;

/**
 *
 * @author MARINA
 */
public class BaciKockiceListener implements EventHandler{
    GeneralGUIController con;

    public BaciKockiceListener(GeneralGUIController con) {
        this.con = con;
    }
    
    

    @Override
    public void handle(Event event) {
        con.baciKockice();
    }
    
}
