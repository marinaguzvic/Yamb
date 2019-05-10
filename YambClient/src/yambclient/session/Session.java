/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yambclient.session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rs.ac.bg.fon.silab.lib.domain.DCIgra;
import rs.ac.bg.fon.silab.lib.korisnik.Korisnik;
import rs.ac.bg.fon.silab.server.web.Matrix;
import rs.ac.bg.fon.silab.server.web.ResponseObject;
import yambclient.util.Constants;

/**
 *
 * @author MARINA
 */
public class Session {

    private static Session instance;
    private final Map<String, Object> map;

    private Session() {
        map = new HashMap<>();
        map.put(Constants.KORISNIK, null);
        map.put(Constants.IGRA,null);
        map.put(Constants.RESPONSE, null);
    }
    
    public void setResponse(ResponseObject responseObject){
        map.put(Constants.RESPONSE, responseObject);
    }
    
    public ResponseObject getResponse(){
        return (ResponseObject)map.get(Constants.RESPONSE);
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setKorisnik(Korisnik korisnik) {
        map.put(Constants.KORISNIK, korisnik);
    }

    public Korisnik getKorisnik() {
        return (Korisnik) map.get(Constants.KORISNIK);
    }
    
    
    public void setIgra(Long igraID){
        map.put(Constants.IGRA, igraID);
    }
    
    public Long getIgra(){
        return (Long) map.get(Constants.IGRA);
    }
}
