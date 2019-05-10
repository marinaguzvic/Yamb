/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rs.ac.bg.fon.silab.lib.domain.DCIgra;
import rs.ac.bg.fon.silab.lib.domain.DCKorisnik;
import rs.ac.bg.fon.silab.server.controller.Participation;
import rs.ac.bg.fon.silab.server.db.constants.Constants;

/**
 *
 * @author MARINA
 */
public class Session {
    private static Session instance;
    private final Map<String, Object> map;

    private Session() {
        map = new HashMap<>();
        List<Participation> participations = new ArrayList<>();
        map.put(Constants.PARTICIPATIONS, participations);
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

    public List<Participation> getParticipations(){
        return (List<Participation>) map.get(Constants.PARTICIPATIONS);
    }
    
    public Participation getParticipationByKorisnik(DCKorisnik korisnik){
        List<Participation> participations = (List<Participation>) map.get(Constants.PARTICIPATIONS);
        for (Participation participation : participations) {
            if(participation.getMatrica().getKorisnik().equals(korisnik)){
                return participation;
            }
        }
        return null;
    }
    
}
