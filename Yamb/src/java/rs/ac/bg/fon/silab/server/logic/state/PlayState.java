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
public abstract class PlayState {
    private Integer [] dices;
    
    public abstract PlayState joinGame();
    public abstract PlayState startGame();
    
    public abstract PlayState throwDices(Integer[] dicesKept) throws Exception;
    public abstract PlayState najavi(Long najavaRow) throws Exception;
    public abstract PlayState writeResult();
    public abstract PlayState calculateScore();
    public abstract PlayState endGame();
    public abstract PlayState login();
    public abstract PlayState logout ();
    
    
    public void generateDices(Integer[] dicesKept){
        Integer [] newDices = new Integer[5];
        int i = 0;
        if(dicesKept != null)
            for (; i < dicesKept.length; i++) 
                newDices[i] = dices[dicesKept[i]];
        for (;i < 5;i++) {
            newDices[i] = (int)Math.round(Math.random() * 5 + 1);
        }
        dices = newDices;
    }
    

    public Integer[] getDices() {
        return dices;
    }

    public void setDices(Integer[] dices) {
        this.dices = dices;
    }

    public abstract int getNumberOfThrows() ;
    
}
