/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.result.factory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.fon.silab.lib.domain.DCMatrica;
import rs.ac.bg.fon.silab.lib.domain.DCRed;
import rs.ac.bg.fon.silab.server.db.factory.GeneralDObjectFactory;
import rs.ac.bg.fon.silab.server.db.operation.DBOFindById;
import rs.ac.bg.fon.silab.server.db.operation.DBOFindByWhereCondition;
import rs.ac.bg.fon.silab.server.logic.result.ResultCalculator;
import rs.ac.bg.fon.silab.server.logic.result.ResultCalculatorSuma1;
import rs.ac.bg.fon.silab.server.logic.result.ResultCalculatorSuma2;
import rs.ac.bg.fon.silab.server.logic.result.ResultCalculatorSuma3;

/**
 *
 * @author MARINA
 */
public class ResultCalculatorFactory {

    public static DCRed red1;
    public static DCRed red2;
    public static DCRed red3;

    public static void getRedovi() {
        try {
            DBOFindById dbo = new DBOFindById();
            DCRed red = DCRed.getInstance(7L);
            ResultSet rs = dbo.templateExecute(red);
            red1 = (DCRed) GeneralDObjectFactory.convertResultSetToObject(rs, red);
            red = DCRed.getInstance(10L);
            rs = dbo.templateExecute(red);
            red2 = (DCRed) GeneralDObjectFactory.convertResultSetToObject(rs, red);
            red = DCRed.getInstance(15L);
            rs = dbo.templateExecute(red);
            red3 = (DCRed) GeneralDObjectFactory.convertResultSetToObject(rs, red);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ResultCalculator get(DCMatrica matrica, DCRed red) {
        if (red1 == null) {
            getRedovi();
        }
        switch (red.getRedId().intValue()) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new ResultCalculatorSuma1(matrica, red1);
            case 8:
            case 9:
                return new ResultCalculatorSuma2(matrica, red2);
            case 11:
            case 12:
            case 13:
            case 14:
                return new ResultCalculatorSuma3(matrica, red3);
            default:
                return null;

        }
    }
}
