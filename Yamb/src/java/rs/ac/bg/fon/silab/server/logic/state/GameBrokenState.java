/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.state;

/**
 *
 * @author MARINA
 */
public class GameBrokenState extends PlayState {

    @Override
    public PlayState joinGame() {
        return this;
    }

    @Override
    public PlayState startGame() {
        return this;
    }

    @Override
    public PlayState throwDices(java.lang.Integer[] dicesKept) {
        return this;
    }

    @Override
    public PlayState najavi(Long najavaRow) {
        return this;
    }

    @Override
    public PlayState writeResult() {
        return this;
    }

    @Override
    public PlayState calculateScore() {
        return this;
    }

    @Override
    public PlayState endGame() {
        return this;
    }

    @Override
    public int getNumberOfThrows() {
            return -1;
    }

}
