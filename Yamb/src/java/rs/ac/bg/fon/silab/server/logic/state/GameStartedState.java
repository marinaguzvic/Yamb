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
public class GameStartedState extends PlayState {

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
        generateDices(null);
        DicesFirstThrowState state = new DicesFirstThrowState();
        state.setDices(getDices());
        return state;
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
        return new GameBrokenState();
    }

    @Override
    public int getNumberOfThrows() {
        return 0;
    }

}
