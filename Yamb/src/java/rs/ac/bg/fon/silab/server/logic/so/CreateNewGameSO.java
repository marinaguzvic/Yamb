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
import rs.ac.bg.fon.silab.server.matrix.factory.MatrixFactory;
import rs.ac.bg.fon.silab.server.session.Session;

/**
 *
 * @author MARINA
 */
public class CreateNewGameSO extends AbstractGenericSO{

    @Override
    protected ResultSet execute(GeneralDObject gdo) throws Exception {
        AbstractGenericDBOperation dbo = new DBOSaveRecord();
        return dbo.templateExecute(gdo);
    }

    @Override
    public void verifyLoginCredentials(RequestObject requestObject) throws Exception {
        DCKorisnik korisnik = participation.getMatrica().getKorisnik();
        if(!(korisnik.getKorisnickoIme().equals(requestObject.getKorisnickoIme()) && korisnik.getSifra().equals(requestObject.getSifra())))throw new Exception("Wrng credentials!");
    }

    @Override
    public void switchState(RequestObject requestObject) {
        participation.setState(participation.getState().joinGame());
    }

    @Override
    public GeneralDObject getNewValue(RequestObject requestObject) {
        DCIgra igra = DCIgra.getInstance();
        igra.setAktivna(EnumAktivna.NOVA.toString());
        DCMatrica matrica = participation.getMatrica();
        matrica.setIgra(igra);
        matrica.setMatricaId(1L);
        matrica.setKorisnik(participation.getKorisnik());
        igra.getMatrice().add(matrica);
        return igra;
    }



    @Override
    public String getMessage(int status) {
        if(status == 1){
            return "Nova igra je uspesno kreirana";
        }else{
            return "Sistem nije uspeo da kreira novu igru";
        }
        
    }

    @Override
    public void readResultSet(ResultSet rs, GeneralDObject gdo, ResponseObject responseObject) throws Exception{
        try {
            DBOFindById dbo = new DBOFindById();
            ResultSet rs2 = dbo.templateExecute(gdo);
            GeneralDObject gdo2 = GeneralDObjectFactory.convertResultSetToObject(rs2, gdo);
            participation.setIgra((DCIgra) gdo2);
            participation.setMatrica(((DCIgra) gdo2).getMatrice().get(0));
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        
    }

    
}
