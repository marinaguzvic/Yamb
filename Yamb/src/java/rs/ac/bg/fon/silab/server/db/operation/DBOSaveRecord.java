/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.db.operation;

import java.sql.ResultSet;
import rs.ac.bg.fon.silab.lib.domain.GeneralDObject;

/**
 *
 * @author MARINA
 */
public class DBOSaveRecord extends AbstractGenericDBOperation {

    @Override
    public ResultSet execute(GeneralDObject gdo) throws Exception {
        db.insertRecordCompound(gdo);
        return null;
    }
}
