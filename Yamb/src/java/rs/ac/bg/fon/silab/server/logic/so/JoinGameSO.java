/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.so;

import java.sql.ResultSet;
import rs.ac.bg.fon.silab.lib.domain.DCIgra;
import rs.ac.bg.fon.silab.lib.domain.DCKorisnik;
import rs.ac.bg.fon.silab.lib.domain.DCMatrica;
import rs.ac.bg.fon.silab.lib.domain.EnumAktivna;
import rs.ac.bg.fon.silab.lib.domain.GeneralDObject;
import rs.ac.bg.fon.silab.lib.matrix.Matrix;
import rs.ac.bg.fon.silab.lib.transfer.request.RequestObject;
import rs.ac.bg.fon.silab.lib.transfer.response.ResponseObject;
import rs.ac.bg.fon.silab.server.controller.Participation;
import rs.ac.bg.fon.silab.server.db.factory.GeneralDObjectFactory;
import rs.ac.bg.fon.silab.server.db.operation.AbstractGenericDBOperation;
import rs.ac.bg.fon.silab.server.db.operation.DBOFindById;
import rs.ac.bg.fon.silab.server.db.operation.DBOSaveRecord;
import rs.ac.bg.fon.silab.server.session.Session;

/**
 *
 * @author MARINA
 */
public class JoinGameSO extends AbstractGenericSO {

    @Override
    protected ResultSet execute(GeneralDObject gdo) throws Exception {
        AbstractGenericDBOperation dbo = new DBOSaveRecord();
        return dbo.templateExecute(gdo);
    }

    @Override
    public void verifyLoginCredentials(RequestObject requestObject) throws Exception {
        DCKorisnik korisnik = participation.getMatrica().getKorisnik();
        if (!(korisnik.getKorisnickoIme().equals(requestObject.getKorisnickoIme()) && korisnik.getSifra().equals(requestObject.getSifra()))) {
            throw new Exception("Wrong credentials!");
        }
        
    }

    @Override
    public void switchState(RequestObject requestObject) {
        participation.setState(participation.getState().joinGame());
    }

    @Override
    public GeneralDObject getNewValue(RequestObject requestObject) throws Exception {
        DBOFindById dbo = new DBOFindById();
        DCIgra igra = DCIgra.getInstance(requestObject.getSelectedGame().getGameId());
        ResultSet rs = dbo.templateExecute(igra);
        igra = (DCIgra) GeneralDObjectFactory.convertResultSetToObject(rs, igra);
        for (DCMatrica dCMatrica : participation.getIgra().getMatrice()) {
            if (Session.getInstance().getParticipationByKorisnik(dCMatrica.getKorisnik()) == null
                    || Session.getInstance().getParticipationByKorisnik(dCMatrica.getKorisnik()).getIgra() != participation.getIgra()) {
                throw new Exception("Not all of the users are logged in or on the same game");
            }
        }
        participation.getMatrica().setIgra(igra);
        participation.getMatrica().setMatricaId(igra.getMatrice().size() + 1L);
        igra.getMatrice().add(participation.getMatrica());
        return participation.getMatrica();
    }

    @Override
    public String getMessage(int status) {
        if (status == 1) {
            return "Sistem je uspeo da prijavi korisnika u igru";
        } else {
            return "Sistem ne moze da prijavi korisnika u igru";
        }
    }

    @Override
    public void readResultSet(ResultSet rs, GeneralDObject gdo, ResponseObject responseObject) {
    }

}
