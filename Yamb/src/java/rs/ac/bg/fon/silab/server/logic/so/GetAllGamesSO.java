/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.so;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.silab.lib.domain.DCIgra;
import rs.ac.bg.fon.silab.lib.domain.DCKorisnik;
import rs.ac.bg.fon.silab.lib.domain.DCMatrica;
import rs.ac.bg.fon.silab.lib.domain.EnumAktivna;
import rs.ac.bg.fon.silab.lib.domain.GeneralDObject;
import rs.ac.bg.fon.silab.lib.game.Game;
import rs.ac.bg.fon.silab.lib.matrix.Matrix;
import rs.ac.bg.fon.silab.lib.transfer.request.RequestObject;
import rs.ac.bg.fon.silab.lib.transfer.response.ResponseObject;
import rs.ac.bg.fon.silab.lib.transfer.util.IStatus;
import rs.ac.bg.fon.silab.server.controller.Participation;
import rs.ac.bg.fon.silab.server.db.factory.GeneralDObjectFactory;
import rs.ac.bg.fon.silab.server.db.operation.DBOFindByWhereCondition;
import rs.ac.bg.fon.silab.server.session.Session;

/**
 *
 * @author MARINA
 */
public class GetAllGamesSO extends AbstractGenericSO {

    @Override
    protected ResultSet execute(GeneralDObject gdo) throws Exception {
        DBOFindByWhereCondition dbo = new DBOFindByWhereCondition();
        gdo.setCustomWhereCondition("aktivna='" + EnumAktivna.NOVA.toString() + "'" );
        return dbo.templateExecute(gdo);
    }

    @Override
    public void verifyLoginCredentials(RequestObject requestObject) throws Exception {
        DCKorisnik korisnik = participation.getMatrica().getKorisnik();
        if(!(korisnik.getKorisnickoIme().equals(requestObject.getKorisnickoIme()) && korisnik.getSifra().equals(requestObject.getSifra())))throw new Exception("Wrng credentials!");
    }

    @Override
    public void switchState(RequestObject requestObject) {
    }

    @Override
    public GeneralDObject getNewValue(RequestObject requestObject) {
        return DCIgra.getInstance();
    }

    @Override
    public Matrix generateMatrix() {
        return null;
    }

    @Override
    public String getMessage(int status) {
        if (status == IStatus.OK) {
            return "Igre su uspesno pronadjene";
        } else {
            return "Sistem nije uspeo da pronadje igre";
        }
    }

    @Override
    public void readResultSet(ResultSet rs, GeneralDObject gdo, ResponseObject responseObject) throws Exception{
        List<Game> games = new ArrayList<>();
        do {
            try {
                gdo = GeneralDObjectFactory.convertResultSetToObject(rs, gdo);
                if (gdo != null) {
                    DCIgra igra = (DCIgra) gdo;
                    List<String> korisnici = new ArrayList<>();
                    boolean game = true;
                    for (DCMatrica dCMatrica : igra.getMatrice()) {
                        if(dCMatrica.getKorisnik().equals(participation.getKorisnik()) ||
                                Session.getInstance().getParticipationByKorisnik(dCMatrica.getKorisnik()) == null ||
                                 Session.getInstance().getParticipationByKorisnik(dCMatrica.getKorisnik()).getIgra() != igra){
                            game = false;
                            break;
                        }
                        korisnici.add(dCMatrica.getKorisnik().getKorisnickoIme());
                    }
                    if(game)games.add(new Game(igra.getIgraId(), korisnici));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new Exception(ex.getMessage());
            }
        } while (gdo != null);
        responseObject.setGames(games);
    }

}
