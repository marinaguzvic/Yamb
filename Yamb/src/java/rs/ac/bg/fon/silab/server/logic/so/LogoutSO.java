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
import rs.ac.bg.fon.silab.lib.domain.GeneralDObject;
import rs.ac.bg.fon.silab.lib.transfer.request.RequestObject;
import rs.ac.bg.fon.silab.lib.transfer.response.ResponseObject;
import rs.ac.bg.fon.silab.server.controller.Participation;
import rs.ac.bg.fon.silab.server.session.Session;

/**
 *
 * @author MARINA
 */
public class LogoutSO extends AbstractGenericSO {

    @Override
    protected ResultSet execute(GeneralDObject gdo) throws Exception {
        return null;
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
        participation.setState(participation.getState().logout());
    }

    @Override
    public GeneralDObject getNewValue(RequestObject requestObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMessage(int status) {
        if (status == 1) {
            return "Korisnik se uspesno odjavio";
        } else {
            return "Sistem nije uspeo da odjavi korisnika";
        }
    }

    @Override
    public void readResultSet(ResultSet rs, GeneralDObject gdo, ResponseObject responseObject) throws Exception {
    }

}
