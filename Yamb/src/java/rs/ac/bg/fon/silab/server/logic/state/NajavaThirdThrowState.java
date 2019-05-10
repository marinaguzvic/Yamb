/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.state;

import rs.ac.bg.fon.silab.lib.matrix.Field;
import rs.ac.bg.fon.silab.lib.matrix.Matrix;

/**
 *
 * @author MARINA
 */
public class NajavaThirdThrowState extends PlayState implements Najava {

    private Long najavaRow;

    public NajavaThirdThrowState(Long najavaRow) {
        this.najavaRow = najavaRow;
    }

    @Override
    public PlayState joinGame() {
        return this;
    }

    @Override
    public PlayState startGame() {
        return this;
    }

    @Override
    public PlayState throwDices(java.lang.Integer[] dicesKept) throws Exception {
        throw new Exception("Dices were already thrown three times");
    }

    @Override
    public PlayState najavi(Long najavaRow) throws Exception {
        throw new Exception("Trying to perform najavi after already having performed it");
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
    public Long getNajavaRow() {
        return najavaRow;
    }

    @Override
    public void setNajavaRow(Long najavaRow) {
        this.najavaRow = najavaRow;
    }

    @Override
    public int getNumberOfThrows() {
        return 3;
    }
}