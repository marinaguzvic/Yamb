/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.result;

import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import rs.ac.bg.fon.silab.lib.domain.DCKolona;
import rs.ac.bg.fon.silab.lib.domain.DCMatrica;
import rs.ac.bg.fon.silab.lib.domain.DCPolje;
import rs.ac.bg.fon.silab.lib.domain.DCRed;

/**
 *
 * @author MARINA
 */
public class ResultCalculatorSuma1 extends ResultCalculator {

    public ResultCalculatorSuma1(DCMatrica matrica, DCRed red) {
        super(matrica, red);
    }


    @Override
    public DCPolje calculateResult(DCKolona column) {
        Long result = 0L;
        for (DCPolje dCPolje : matrica.getPolja()) {
            if (dCPolje.getKolona().equals(column) && in(dCPolje.getRed().getRedId(),1L,6L)) {
                result += dCPolje.getVrednost();
            }
        }
        if(result >= 60)result += 30;
        DCPolje polje = DCPolje.getInstance(matrica);
        polje.setRed(red);
        polje.setKolona(column);
        polje.setVrednost(result);
        return polje;
    }

}
