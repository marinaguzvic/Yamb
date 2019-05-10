/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.db.operation;

import java.sql.ResultSet;
import rs.ac.bg.fon.silab.lib.domain.GeneralDObject;
import rs.ac.bg.fon.silab.server.db.operation.AbstractGenericDBOperation;

/**
 *
 * @author MARINA
 */
public class DBOFindAllRecords extends AbstractGenericDBOperation{

    @Override
    protected ResultSet execute(GeneralDObject gdo) throws Exception {
        return db.findAllRecords(gdo);

    }

    @Override
    protected void validate(GeneralDObject gdo) throws Exception {
    }


    
    
}
