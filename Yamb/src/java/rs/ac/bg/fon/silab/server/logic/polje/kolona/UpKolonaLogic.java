/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.polje.kolona;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.fon.silab.lib.domain.DCPolje;
import rs.ac.bg.fon.silab.lib.domain.DCRed;
import rs.ac.bg.fon.silab.server.db.factory.GeneralDObjectFactory;
import rs.ac.bg.fon.silab.server.db.operation.DBOFindAllRecords;

/**
 *
 * @author MARINA
 */
public class UpKolonaLogic extends KolonaLogic {

    public static Long maxRed = 0L;

    @Override
    public Boolean available(int red, List<DCPolje> polja) {
        if (maxRed == 0) {
            DBOFindAllRecords dbo = new DBOFindAllRecords();
            try {
                DCRed r;
                ResultSet rs = dbo.templateExecute(DCRed.getInstance());
                while ((r = (DCRed) GeneralDObjectFactory.convertResultSetToObject(rs, DCRed.getInstance())) != null) {
                    if (r.getRedId() > maxRed) {
                        maxRed = r.getRedId();
                    }
                }
                maxRed++;
            } catch (Exception ex) {
            }
        }

        Long minRow = maxRed;
        for (DCPolje dCPolje : polja) {
            if ((!inResultRows(dCPolje.getRed().getRedId())) && dCPolje.getKolona().getKolonaId() == 3L && dCPolje.getRed().getRedId() < minRow) {
                minRow = dCPolje.getRed().getRedId();
            }
        }
        minRow--;
        if (inResultRows(minRow)) {
            minRow--;
        }
        return (red == minRow);
    }

}
