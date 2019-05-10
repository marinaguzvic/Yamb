/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.db.operation;

import java.sql.ResultSet;
import java.sql.SQLException;
import rs.ac.bg.fon.silab.lib.domain.GeneralDObject;

/**
 *
 * @author MARINA
 */
public class DBOUpdateRecord extends AbstractGenericDBOperation {

    @Override
    public ResultSet execute(GeneralDObject gdo) throws Exception {
        db.updateRecordCompound(gdo);
        return null;
    }

    @Override
    protected boolean sameRecord(ResultSet rs, GeneralDObject gdo) {
        boolean same = true;
        for (String primaryKeyColumn : gdo.getPrimaryKeyColumns()) {
            try {
                same = same && gdo.getValue(primaryKeyColumn).equals(rs.getObject(primaryKeyColumn));
            } catch (SQLException ex) {
                System.out.println("Exception in sameRecord");
                ex.printStackTrace();
            }
        }
        return same;
    }

}
