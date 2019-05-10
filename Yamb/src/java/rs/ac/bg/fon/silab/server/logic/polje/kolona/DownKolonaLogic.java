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
public class DownKolonaLogic extends KolonaLogic {

    @Override
    public Boolean available(int red, List<DCPolje> polja) {
        Long highestRow = 0L;
        for (DCPolje dCPolje : polja) {
            if ((!inResultRows(dCPolje.getRed().getRedId())) && dCPolje.getKolona().getKolonaId() == 1L && dCPolje.getRed().getRedId() > highestRow) {
                highestRow = dCPolje.getRed().getRedId();
            }
        }
        if (inResultRows(highestRow + 1)) {
            highestRow++;
        }
        return (red == (++highestRow));
    }

}
