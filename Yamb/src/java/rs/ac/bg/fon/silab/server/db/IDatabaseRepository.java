/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.db;

import java.sql.ResultSet;
import rs.ac.bg.fon.silab.lib.domain.GeneralDObject;

/**
 *
 * @author MARINA
 */
public interface IDatabaseRepository {

    void commitTransaction() throws Exception;

    ResultSet findAllRecords(GeneralDObject gdo) throws Exception;

    ResultSet findRecordByPrimaryKey(GeneralDObject gdo) throws Exception;

    ResultSet findRecordsByWhereCondition(GeneralDObject gdo, String where) throws Exception;

    void rollbackTransaction() throws Exception;

    GeneralDObject updateRecord(GeneralDObject gdo) throws Exception;

    GeneralDObject updateRecordCompound(GeneralDObject gdo) throws Exception;
    
}
