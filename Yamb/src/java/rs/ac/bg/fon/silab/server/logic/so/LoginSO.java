/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.so;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.fon.silab.lib.domain.DCIgra;
import rs.ac.bg.fon.silab.lib.domain.DCKorisnik;
import rs.ac.bg.fon.silab.lib.domain.DCMatrica;
import rs.ac.bg.fon.silab.lib.domain.GeneralDObject;
import rs.ac.bg.fon.silab.lib.transfer.request.RequestObject;
import rs.ac.bg.fon.silab.server.controller.Participation;
import rs.ac.bg.fon.silab.server.db.constants.Constants;
import rs.ac.bg.fon.silab.server.db.factory.GeneralDObjectFactory;
import rs.ac.bg.fon.silab.server.db.operation.AbstractGenericDBOperation;
import rs.ac.bg.fon.silab.server.db.operation.DBOFindByWhereCondition;
import rs.ac.bg.fon.silab.lib.matrix.Matrix;
import rs.ac.bg.fon.silab.lib.transfer.response.ResponseObject;
import rs.ac.bg.fon.silab.lib.transfer.util.IStatus;
import rs.ac.bg.fon.silab.server.logic.state.LoggedInState;
import rs.ac.bg.fon.silab.server.session.Session;

/**
 *
 * @author MARINA
 */
public class LoginSO extends AbstractGenericSO {

    @Override
    protected ResultSet execute(GeneralDObject gdo) throws Exception {
        return null;
    }

    @Override
    public void verifyLoginCredentials(RequestObject requestObject) throws Exception {
        if(participation != null)return;
        try {
            AbstractGenericDBOperation dbo = new DBOFindByWhereCondition();
            GeneralDObject gdo = DCKorisnik.getInstance();
            gdo.setCustomWhereCondition(rs.ac.bg.fon.silab.lib.domain.constants.Constants.Korisnik.KORISNICKO_IME + "='" + requestObject.getKorisnickoIme() + "'");
            ResultSet rs = dbo.templateExecute(gdo);
            gdo = GeneralDObjectFactory.convertResultSetToObject(rs, gdo);
            if (((DCKorisnik) gdo).getSifra().equals(requestObject.getSifra())) {
                participation = new Participation();
                DCMatrica matrica = DCMatrica.getInstance();
                matrica.setKorisnik((DCKorisnik) gdo);
                participation.setMatrica(matrica);
                Session.getInstance().getParticipations().add(participation);
            } else {
                throw new Exception("Password is not correct");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Korisnik was not found");
        }

    }

    @Override
    public void switchState(RequestObject requestObject) {
        if (participation.getState() == null) {
            participation.setState(new LoggedInState());
        }else{
            participation.setState(participation.getState().login());
        }
    }

    @Override
    public GeneralDObject getNewValue(RequestObject requestObject) {
        return null;
    }

    @Override
    public Matrix generateMatrix() {
        if(participation.getState() instanceof LoggedInState){
            return null;
        }else{
            return super.generateMatrix();
        }
    }

    @Override
    public String getMessage(int status) {
        if (status == IStatus.OK) {
            return "Korisnik se uspesno ulogovao";
        } else {
            return "Sistem ne moze da uloguje korisnika";
        }
    }

    @Override
    public void readResultSet(ResultSet rs, GeneralDObject gdo, ResponseObject responseObject) {
    }

    @Override
    protected void findParticipation(RequestObject requestObject) throws Exception {
        try {
            super.findParticipation(requestObject);
        } catch (Exception e) {
        }
    }

}
