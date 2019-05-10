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
public class PokerRedLogic extends RedLogic{

    Integer [] possibleDices = new Integer [] {1,2,3,4,5,6};
    Integer [] diceOccurencies = new Integer[] {0,0,0,0,0,0};

    @Override
    public Long calculate(Integer[] dices) {
        for (Integer possibleDice : possibleDices) {
            int occurencies = 0;
            for (Integer dice : dices) {
                if (dice == possibleDice) occurencies++;
            }
            diceOccurencies[possibleDice - 1] = occurencies;
        }
        int value = 0;
        Boolean fourValueExists = false;
        for (int i = 0; i < diceOccurencies.length; i++) {
            if(diceOccurencies[i] == 4){
                value = 4 * (i + 1);
                fourValueExists = true;
            }
        }
        if(fourValueExists)return value + 40L;
        else return 0L;
    }
    
}
