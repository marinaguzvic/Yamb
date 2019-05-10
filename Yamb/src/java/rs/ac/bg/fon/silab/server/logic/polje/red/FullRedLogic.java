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
public class FullRedLogic extends RedLogic{
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
        int twoValue = 0;
        Boolean twoValueExists = false;
        int threeValue = 0;
        Boolean threeValueExists = false;
        for (int i = 0; i < diceOccurencies.length; i++) {
            if(diceOccurencies[i] == 5){
                twoValue = 2 * possibleDices[i];
                threeValue = 3 * possibleDices[i];
                twoValueExists = true;
                threeValueExists = true;
            }else if (diceOccurencies[i] == 3){
                threeValue = 3 * possibleDices[i];
                threeValueExists = true;
            }else{
                twoValue = 2 * possibleDices[i];
                twoValueExists = true;
            }
        }
        if(twoValueExists && threeValueExists)return twoValue + threeValue + 20L;
        else return 0L;
    }
    
}
