/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.so;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.fon.silab.lib.domain.DCIgra;
import rs.ac.bg.fon.silab.lib.domain.DCKorisnik;
import rs.ac.bg.fon.silab.lib.domain.DCMatrica;
import rs.ac.bg.fon.silab.lib.domain.DCPolje;
import rs.ac.bg.fon.silab.lib.domain.GeneralDObject;
import rs.ac.bg.fon.silab.lib.transfer.request.RequestObject;
import rs.ac.bg.fon.silab.server.controller.Participation;
import rs.ac.bg.fon.silab.server.db.DatabaseRepository;
import rs.ac.bg.fon.silab.lib.matrix.Matrix;
import rs.ac.bg.fon.silab.lib.result.Result;
import rs.ac.bg.fon.silab.lib.transfer.response.ResponseObject;
import rs.ac.bg.fon.silab.lib.transfer.util.IStatus;
import rs.ac.bg.fon.silab.server.logic.polje.kolona.KolonaLogic;
import rs.ac.bg.fon.silab.server.matrix.factory.MatrixFactory;
import rs.ac.bg.fon.silab.server.session.Session;

/**
 *
 * @author MARINA
 */
public abstract class AbstractGenericSO {

    protected DatabaseRepository db;
    Matrix matrix;
    String message;
    protected Participation participation = null;

    public AbstractGenericSO() {
        db = DatabaseRepository.getInstance();
    }

    public ResponseObject templateExecute(RequestObject requestObject) {
        ResponseObject responseObject = new ResponseObject();

        try {
            findParticipation(requestObject);
            verifyLoginCredentials(requestObject);
            GeneralDObject gdo = getNewValue(requestObject);
            ResultSet rs = execute(gdo);
            readResultSet(rs, gdo, responseObject);
            switchState(requestObject);
            matrix = generateMatrix();
            responseObject.setCode(IStatus.OK);
            responseObject.setDices(participation.getState().getDices());
        } catch (Exception ex) {
            ex.printStackTrace();
            responseObject.setCode(IStatus.ERROR);
        }
        if (participation != null) {
            responseObject.setNumberOfThrows(participation.getState().getNumberOfThrows());
            fillResults(responseObject);
        }
        responseObject.setMatrix(matrix);
        responseObject.setMessage(getMessage(responseObject.getCode()));
        return responseObject;
    }

    protected abstract ResultSet execute(GeneralDObject gdo) throws Exception;



    public abstract void verifyLoginCredentials(RequestObject requestObject) throws Exception;

    protected void findParticipation(RequestObject requestObject) throws Exception {
        DCKorisnik korisnik = DCKorisnik.getInstance();
        korisnik.setKorisnickoIme(requestObject.getKorisnickoIme());
        participation = Session.getInstance().getParticipationByKorisnik(korisnik);
        if(participation == null)throw new Exception("Participation not found");
    }

    public abstract void switchState(RequestObject requestObject) throws Exception;

    public abstract GeneralDObject getNewValue(RequestObject requestObject) throws Exception;

    public Matrix generateMatrix() {
        return MatrixFactory.get(participation.getState(), participation.getMatrica());
    }

    public abstract String getMessage(int status);

    public abstract void readResultSet(ResultSet rs, GeneralDObject gdo, ResponseObject responseObject) throws Exception;

    private void fillResults(ResponseObject responseObject) {
        responseObject.setOpponentResults(new ArrayList<>());
        if(participation.getIgra() != null){
            DCIgra igra = participation.getIgra();
            for (DCMatrica dCMatrica : igra.getMatrice()) {
                Result r = new Result(dCMatrica.getKorisnik().getKorisnickoIme(), calculateTotal(dCMatrica), setIsFinished(dCMatrica));
                if(dCMatrica.equals(participation.getMatrica())){
                    responseObject.setMyResult(r);
                }else{
                    responseObject.getOpponentResults().add(r);
                }
            }
        }
    }
    
    public Long calculateTotal(DCMatrica matrica){
        Long total = 0L;
        for (DCPolje dCPolje : matrica.getPolja()) {
            if(KolonaLogic.inResultRows(dCPolje.getRed().getRedId())){
                total += dCPolje.getVrednost();
            }
        }
        return total;
    }
    
    

    private boolean setIsFinished(DCMatrica matrica) {
        if(matrica.getKrajnjiRezultat() == null || matrica.getKrajnjiRezultat() == 0L){
            return false;
        }else{
            return true;
        }
    }

}
