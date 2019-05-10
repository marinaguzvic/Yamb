/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.db.operation;

import java.sql.ResultSet;
import rs.ac.bg.fon.silab.lib.domain.GeneralDObject;
import rs.ac.bg.fon.silab.server.db.DatabaseRepository;

/**
 *
 * @author MARINA
 */
public abstract class AbstractGenericDBOperation {

    protected DatabaseRepository db;

    public AbstractGenericDBOperation() {
        db = DatabaseRepository.getInstance();
    }

    public ResultSet templateExecute(GeneralDObject gdo) throws Exception {
        try {
            validate(gdo);
            try {
                
                ResultSet rs = execute(gdo);
                commitTransaction();
                return rs;
            } catch (Exception e) {
                rollbackTransaction();
                throw new Exception(e.getMessage());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    protected void validate(GeneralDObject gdo) throws Exception {
        //ako je select, redefinisemo validate, jer za select se validate ne radi
        gdo.checkConstraints();
    }

    protected abstract ResultSet execute(GeneralDObject gdo) throws Exception;

    private void commitTransaction() throws Exception {
        db.commitTransaction();
    }

    private void rollbackTransaction() throws Exception {
        db.rollbackTransaction();
    }

    protected void checkUnique(GeneralDObject gdo) throws Exception {
        if (gdo.getColumns().length != 0) {
            ResultSet rs = db.findAllRecords(gdo);
            while (rs.next()) {
                if (!sameRecord(rs,gdo)) {
                    for (String column : gdo.getColumns()) {
                        if (rs.getObject(column).equals(gdo.getValue(column))) {
                            throw new Exception("Column " + column + " is not unique in database");
                        }
                    }
                }
            }
        }
    }

    protected boolean sameRecord(ResultSet rs,GeneralDObject gdo) {
        return false;
    }
}
