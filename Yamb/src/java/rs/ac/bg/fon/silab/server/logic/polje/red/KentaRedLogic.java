/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.polje.red;

import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author MARINA
 */
public class KentaRedLogic extends RedLogic {

    Integer[] combination1 = new Integer[]{1, 2, 3, 4, 5};
    Integer[] combination2 = new Integer[]{2, 3, 4, 5, 6};

    @Override
    public Long calculate(Integer[] dices) {
        HashSet<Integer> setCombination1 = new HashSet<Integer>(Arrays.asList(combination1));
        HashSet<Integer> setCombination2 = new HashSet<Integer>(Arrays.asList(combination2));
        HashSet<Integer> setDices = new HashSet<Integer>(Arrays.asList(dices));
        boolean c1 = setDices.equals(setCombination1);
        if(!c1){
            c1 = setDices.equals(setCombination2);
        }
        if(c1) return 76L - numberOfThrows*10;
        else return 0L;
    }

}
