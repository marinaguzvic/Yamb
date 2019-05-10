/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.db.factory;

import java.sql.ResultSet;
import rs.ac.bg.fon.silab.lib.domain.CompundDObject;
import rs.ac.bg.fon.silab.lib.domain.DCIgra;
import rs.ac.bg.fon.silab.lib.domain.DCKolona;
import rs.ac.bg.fon.silab.lib.domain.DCKorisnik;
import rs.ac.bg.fon.silab.lib.domain.DCMatrica;
import rs.ac.bg.fon.silab.lib.domain.DCPolje;
import rs.ac.bg.fon.silab.lib.domain.DCRed;
import rs.ac.bg.fon.silab.lib.domain.GeneralDObject;
import rs.ac.bg.fon.silab.lib.domain.constants.Constants;
import rs.ac.bg.fon.silab.server.db.operation.AbstractGenericDBOperation;
import rs.ac.bg.fon.silab.server.db.operation.DBOFindById;
import rs.ac.bg.fon.silab.server.db.operation.DBOFindChildren;

/**
 *
 * @author MARINA
 */
public class GeneralDObjectFactory {


    public static GeneralDObject convertResultSetToObject(ResultSet rs, GeneralDObject gdo) throws Exception {
        if (rs.next()) {
            gdo = gdo.getInstance(rs);
            for (String column : gdo.getColumns()) {
                if(gdo.getValue(column) instanceof GeneralDObject)continue;
                    gdo.setValue(column, rs, null);
                if (gdo.getValue(column) instanceof GeneralDObject) {
                    gdo.setValue(column, rs, null);
                    AbstractGenericDBOperation dbo = new DBOFindById();
                    ResultSet rs2 = dbo.templateExecute((GeneralDObject) gdo.getValue(column));
                    gdo.setValue(column, rs, convertResultSetToObject(rs2, (GeneralDObject) gdo.getValue(column)));
                }
            }
            if (gdo instanceof CompundDObject) {
                findChildren((CompundDObject) gdo);
            }
            return gdo;
        } else {
            return null;
        }
    }



    public static void findChildren(CompundDObject cdo) throws Exception {
        for (String className : cdo.classNames()) {
            GeneralDObject gdo = cdo.createChild(className);
            AbstractGenericDBOperation dbo = new DBOFindChildren();
            ResultSet rs = dbo.templateExecute(gdo);
            while ((gdo = convertResultSetToObject(rs, gdo)) != null) {
                cdo.addChild(gdo);
            }

        }

    }


}
