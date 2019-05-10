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
public class FourRedLogic extends RedLogic{
    @Override
    public Long calculate(Integer[] dices) {
        Long result = 0L;
        for (int dice : dices) {
            if(dice == 4) result += 4;
        }
        return result;
    }
}
