/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.result;

import rs.ac.bg.fon.silab.lib.domain.DCKolona;
import rs.ac.bg.fon.silab.lib.domain.DCMatrica;
import rs.ac.bg.fon.silab.lib.domain.DCPolje;
import rs.ac.bg.fon.silab.lib.domain.DCRed;

/**
 *
 * @author MARINA
 */
public class ResultCalculatorSuma2 extends ResultCalculator{

    public ResultCalculatorSuma2(DCMatrica matrica, DCRed red) {
        super(matrica, red);
    }



    @Override
    public DCPolje calculateResult(DCKolona column) {
        Long result = 0L;
        Long ones = -1L;
        Long min = 0L;
        Long max = 0L;
        for (DCPolje dCPolje : matrica.getPolja()) {
            if (dCPolje.getKolona().equals(column)) {
                if(dCPolje.getRed().getRedId() == 1L){
                    ones = dCPolje.getVrednost();
                }   
                if(dCPolje.getRed().getRedId() == 8L){
                    min = dCPolje.getVrednost();
                }
                if(dCPolje.getRed().getRedId() == 9L){
                    max = dCPolje.getVrednost();
                } 
            }
        }
        result = ones * (max - min);
        if(min == 0L || max == 0L || ones == -1L)result = 0L;
        DCPolje polje = DCPolje.getInstance(matrica);
        polje.setRed(red);
        polje.setKolona(column);
        polje.setVrednost(result);
        return polje;
    }
    
}
