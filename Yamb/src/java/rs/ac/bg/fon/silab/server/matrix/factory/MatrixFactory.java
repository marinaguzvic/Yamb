/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.matrix.factory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.fon.silab.lib.domain.DCMatrica;
import rs.ac.bg.fon.silab.lib.domain.DCRed;
import rs.ac.bg.fon.silab.lib.domain.GeneralDObject;
import rs.ac.bg.fon.silab.lib.matrix.Field;
import rs.ac.bg.fon.silab.lib.matrix.Matrix;
import rs.ac.bg.fon.silab.server.db.factory.GeneralDObjectFactory;
import rs.ac.bg.fon.silab.server.db.operation.DBOFindAllRecords;
import rs.ac.bg.fon.silab.server.logic.polje.kolona.KolonaLogic;
import rs.ac.bg.fon.silab.server.logic.polje.kolona.factory.KolonaLogicFactory;
import rs.ac.bg.fon.silab.server.logic.state.PlayState;

/**
 *
 * @author MARINA
 */
public class MatrixFactory {

    public static Matrix get(PlayState state, DCMatrica matrica) {
        if (Matrix.rows == null) {
            Matrix.rows = new ArrayList<>();
            try {
                DBOFindAllRecords dbo = new DBOFindAllRecords();
                DCRed red = DCRed.getInstance();
                ResultSet rs = dbo.templateExecute(red);
                GeneralDObject gdo;
                do {
                    gdo = GeneralDObjectFactory.convertResultSetToObject(rs, red);
                    if (gdo != null) {
                        Matrix.rows.add(((DCRed) gdo).getNaziv());
                    }
                } while (gdo != null);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        Matrix matrix = new Matrix(new Field[15][4]);
        for (int i = 1; i <= 4; i++) {
            KolonaLogic kolonaLogic = KolonaLogicFactory.get(i, state);
            for (int j = 1; j <= 15; j++) {
                Field field = new Field();
                field.setAvailable(kolonaLogic.available(j, matrica.getPolja()));
                field.setColumn(i);
                field.setRow(j);
                if (matrica.getPolje(i, j) != null) {
                    field.setValue(matrica.getPolje(i, j).getVrednost());
                }
                matrix.setField(field, j - 1, i - 1);
            }
        }

        return matrix;
    }

}
