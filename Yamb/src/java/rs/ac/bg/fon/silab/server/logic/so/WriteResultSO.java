/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.so;

import java.sql.ResultSet;
import oracle.jrockit.jfr.tools.ConCatRepository;
import rs.ac.bg.fon.silab.lib.domain.DCIgra;
import rs.ac.bg.fon.silab.lib.domain.DCKolona;
import rs.ac.bg.fon.silab.lib.domain.DCKorisnik;
import rs.ac.bg.fon.silab.lib.domain.DCMatrica;
import rs.ac.bg.fon.silab.lib.domain.DCPolje;
import rs.ac.bg.fon.silab.lib.domain.DCRed;
import rs.ac.bg.fon.silab.lib.domain.GeneralDObject;
import rs.ac.bg.fon.silab.lib.domain.constants.Constants;
import rs.ac.bg.fon.silab.lib.matrix.Field;
import rs.ac.bg.fon.silab.lib.transfer.request.RequestObject;
import rs.ac.bg.fon.silab.lib.transfer.response.ResponseObject;
import rs.ac.bg.fon.silab.server.controller.Participation;
import rs.ac.bg.fon.silab.server.db.factory.GeneralDObjectFactory;
import rs.ac.bg.fon.silab.server.db.operation.DBOFindById;
import rs.ac.bg.fon.silab.server.db.operation.DBOFindByWhereCondition;
import rs.ac.bg.fon.silab.server.db.operation.DBOSaveRecord;
import rs.ac.bg.fon.silab.server.db.operation.DBOUpdateRecord;
import rs.ac.bg.fon.silab.server.logic.polje.kolona.KolonaLogic;
import rs.ac.bg.fon.silab.server.logic.polje.kolona.factory.KolonaLogicFactory;
import rs.ac.bg.fon.silab.server.logic.polje.red.RedLogic;
import rs.ac.bg.fon.silab.server.logic.polje.red.factory.RedLogicFactory;
import rs.ac.bg.fon.silab.server.logic.result.factory.ResultCalculatorFactory;
import rs.ac.bg.fon.silab.server.session.Session;

/**
 *
 * @author MARINA
 */
public class WriteResultSO extends AbstractGenericSO {

    @Override
    protected ResultSet execute(GeneralDObject gdo) throws Exception {
        DBOSaveRecord dbo = new DBOSaveRecord();
        return dbo.templateExecute(gdo);
    }

    @Override
    public void verifyLoginCredentials(RequestObject requestObject) throws Exception {
        DCKorisnik korisnik = participation.getMatrica().getKorisnik();
        if (!(korisnik.getKorisnickoIme().equals(requestObject.getKorisnickoIme()) && korisnik.getSifra().equals(requestObject.getSifra()))) {
            throw new Exception("Wrong credentials!");
        }
        for (DCMatrica dCMatrica : participation.getIgra().getMatrice()) {
            if (Session.getInstance().getParticipationByKorisnik(dCMatrica.getKorisnik()) == null
                    || Session.getInstance().getParticipationByKorisnik(dCMatrica.getKorisnik()).getIgra() != participation.getIgra()) {
                throw new Exception("Not all of the users are logged in or on the same game");
            }
        }
    }

    @Override
    public void switchState(RequestObject requestObject) {
        participation.setState(participation.getState().writeResult());
    }

    @Override
    public GeneralDObject getNewValue(RequestObject requestObject) throws Exception {
        Field chosenField = requestObject.getSelectedField();
        if(!KolonaLogicFactory.get(chosenField.getColumn(), participation.getState()).available(chosenField.getRow(), participation.getMatrica().getPolja())) throw new Exception("Trying to write on an unavailable field");
        Long vrednost = RedLogicFactory.get(chosenField.getRow()).calculate(participation.getState().getDices());
        DCPolje dCPolje = DCPolje.getInstance(participation.getMatrica());
        dCPolje.setKolona(DCKolona.getInstance((long)chosenField.getColumn()));
        dCPolje.setRed(DCRed.getInstance((long)chosenField.getRow()));
        dCPolje.setVrednost(vrednost);
        return dCPolje;
    }

    @Override
    public String getMessage(int status) {
        if(status == 1){
            return "Rezultat je uspesno upisan";
        }else{
            return "Sistem nije uspeo da upise rezultat";
        }
    }

    @Override
    public void readResultSet(ResultSet rs, GeneralDObject gdo, ResponseObject responseObject) throws Exception {
        DCPolje polje = (DCPolje) gdo;
        participation.getMatrica().addChild(polje);
        DCPolje result = ResultCalculatorFactory.get(participation.getMatrica(), polje.getRed()).calculateResult(polje.getKolona());
        DBOFindByWhereCondition dboResult = new DBOFindByWhereCondition();
        result.setCustomWhereCondition(Constants.Polje.IGRA_ID_FK + "=" + result.getMatrica().getIgra().getIgraId()
                + " AND " + Constants.Polje.MATRICA_ID_FK + "=" + result.getMatrica().getMatricaId() +
                " AND " + Constants.Polje.RED_ID_FK + "=" + result.getRed().getRedId() + 
                " AND " + Constants.Polje.KOLONA_ID_FK + "=" + result.getKolona().getKolonaId());
        ResultSet rs3 = dboResult.templateExecute(result);
        DCPolje foundResult = null;
        if((foundResult = (DCPolje) GeneralDObjectFactory.convertResultSetToObject(rs3, result)) == null){
            DBOSaveRecord dboSave = new DBOSaveRecord();
            dboSave.templateExecute(result);
        }else{
            DBOUpdateRecord dboUpdate = new DBOUpdateRecord();
            foundResult.setVrednost(result.getVrednost());
            dboUpdate.templateExecute(foundResult);
        }
        participation.getMatrica().addChild(result);
    }

}
