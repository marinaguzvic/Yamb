/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yambclient.ui.choosegame.list;

import rs.ac.bg.fon.silab.server.web.Game;

/**
 *
 * @author MARINA
 */
public class Igra {
    Game game;

    public Igra(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        String string = game.getGameId() + ": ";
        for (int i = 0; i < game.getPlayers().size(); i++) {
            string = string.concat(game.getPlayers().get(i));
            if(i != game.getPlayers().size() - 1)string = string.concat(", ");
        }
        return string;
    }
    
    
}
