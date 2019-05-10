/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.lib.game;

import java.util.List;

/**
 *
 * @author MARINA
 */
public class Game {
    private Long gameId;
    private List<String> players;

    public Game(Long gameId, List<String> players) {
        this.gameId = gameId;
        this.players = players;
    }

    public Game() {
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }
    
    
}
