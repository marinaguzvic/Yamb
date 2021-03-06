/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.state;

import rs.ac.bg.fon.silab.lib.matrix.Matrix;

/**
 *
 * @author MARINA
 */
public class DicesFirstThrowState extends PlayState{

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
        generateDices(dicesKept);
        DicesSecondThrowState state = new DicesSecondThrowState();
        state.setDices(getDices());
        return state;
    }

    @Override
    public PlayState najavi(Long najavaRow) {
        NajavaFirstThrowState state = new NajavaFirstThrowState(najavaRow);
        state.setDices(getDices());
        return state;
    }


    @Override
    public PlayState writeResult() {
        return new DicesIdleState();
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
        return 1;
    }

    @Override
    public PlayState login() {
        return this;
    }

    @Override
    public PlayState logout() {
        return new LoggedOutState(this);
    }


    
}
