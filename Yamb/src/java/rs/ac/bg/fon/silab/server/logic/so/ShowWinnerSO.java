/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.so;

import java.sql.ResultSet;
import rs.ac.bg.fon.silab.lib.domain.DCKorisnik;
import rs.ac.bg.fon.silab.lib.domain.DCMatrica;
import rs.ac.bg.fon.silab.lib.domain.EnumAktivna;
import rs.ac.bg.fon.silab.lib.domain.GeneralDObject;
import rs.ac.bg.fon.silab.lib.transfer.request.RequestObject;
import rs.ac.bg.fon.silab.lib.transfer.response.ResponseObject;
import rs.ac.bg.fon.silab.server.controller.Participation;
import rs.ac.bg.fon.silab.server.db.operation.DBOUpdateRecord;
import rs.ac.bg.fon.silab.server.session.Session;

/**
 *
 * @author MARINA
 */
public class ShowWinnerSO extends AbstractGenericSO{

    @Override
    protected ResultSet execute(GeneralDObject gdo) throws Exception {
        DBOUpdateRecord dbo = new DBOUpdateRecord();
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
    public void switchState(RequestObject requestObject) throws Exception {
        participation.setState(participation.getState().endGame());
    }

    @Override
    public GeneralDObject getNewValue(RequestObject requestObject) throws Exception {
        Long maxResult = 0L;
        DCMatrica maxP = null;
        for (DCMatrica matrica : participation.getIgra().getMatrice()) {
            if(matrica.getKrajnjiRezultat() == null)throw new Exception("Igra jos nije gotova");
                if(matrica.getKrajnjiRezultat() > maxResult){
                    if(maxP != null){
                        maxP.setPobeda(false);
                    }
                    maxP = matrica;
                    matrica.setPobeda(true);
                    maxResult = matrica.getKrajnjiRezultat();
                }
        }
        if(maxResult == 0L || maxP == null)throw new Exception("Nema pobednika");
        participation.getIgra().setAktivna(EnumAktivna.ZAVRSENA.name());
        return participation.getIgra();
    }

    @Override
    public String getMessage(int status) {
        if (status == 1) {
            return "Sistem je uspesno prikazao pobednika";
        } else {
            return "Sistem ne moze da prikaze pobednika";
        }
    }

    @Override
    public void readResultSet(ResultSet rs, GeneralDObject gdo, ResponseObject responseObject) throws Exception {
        responseObject.setWinner("Pobednik je " + getPobednik() + " sa rezultatom " + getRezultat());
        DCMatrica matrica = DCMatrica.getInstance();
        matrica.setKorisnik(participation.getKorisnik());
        participation.setMatrica(matrica);
    }
    
    private String getPobednik() throws Exception{
        for (DCMatrica dCMatrica : participation.getIgra().getMatrice()) {
            if(dCMatrica.isPobeda())return dCMatrica.getKorisnik().getKorisnickoIme();
        }
        throw new Exception("Nema pobednika");
    }

    private String getRezultat() throws Exception {
        for (DCMatrica dCMatrica : participation.getIgra().getMatrice()) {
            if(dCMatrica.isPobeda())return dCMatrica.getKrajnjiRezultat() + "";
        }
        throw new Exception("Nema pobednika");
    }
}
