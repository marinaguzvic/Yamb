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
public abstract class ResultCalculator {

    protected DCMatrica matrica;
    protected DCRed red;

    public ResultCalculator(DCMatrica matrica, DCRed red) {
        this.matrica = matrica;
        this.red = red;
    }

    boolean in(Long broj, Long startBroj, Long endBroj) {
        for (Long i = startBroj; i <= endBroj; i++) {
            if (broj == i) {
                return true;
            }
        }
        return false;
    }

    public abstract DCPolje calculateResult(DCKolona column);
}
