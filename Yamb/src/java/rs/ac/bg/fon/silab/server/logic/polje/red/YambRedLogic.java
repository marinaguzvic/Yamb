/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.polje.red;

/**
 *
 * @author MARINA
 */
public class YambRedLogic extends RedLogic{

    @Override
    public Long calculate(Integer[] dices) {
        Integer dice = dices[0];
        Boolean yamb = true;
        for (int i = 1; i < dices.length; i++) {
            if(dice != dices[i]) {
                yamb = false;
                break;
            }
        }
        if(yamb) return 5 * dice + 50L;
        else return 0L;
    }
    
}
