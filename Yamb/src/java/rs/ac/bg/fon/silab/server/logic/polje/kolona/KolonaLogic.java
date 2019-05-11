/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.polje.kolona;

import java.util.List;
import rs.ac.bg.fon.silab.lib.domain.DCPolje;

/**
 *
 * @author MARINA
 */
public abstract class KolonaLogic {

    static Long[] resultRows = new Long[]{7L, 10L, 15L};

    public abstract Boolean available(int red, List<DCPolje> polja);

    public static boolean inResultRows(Long row) {
        for (Long resultRow : resultRows) {
            if (row == resultRow) {
                return true;
            }
        }
        return false;
    }
}
