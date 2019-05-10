/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yambclient.ui.choosegame.listener;

import javafx.event.Event;
import javafx.event.EventHandler;
import yambclient.controller.GeneralGUIController;

/**
 *
 * @author MARINA
 */
public class CreateGameListener implements EventHandler {

    GeneralGUIController con;

    public CreateGameListener(GeneralGUIController con) {
        this.con = con;
    }

    @Override
    public void handle(Event event) {
        try {
            con.createGame();
        } catch (Exception e) {
            e.printStackTrace();
            con.message("Error: " + e.getMessage());
        }

    }

}
