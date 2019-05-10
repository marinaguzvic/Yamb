/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.controller;

import java.util.Objects;
import rs.ac.bg.fon.silab.lib.domain.DCIgra;
import rs.ac.bg.fon.silab.lib.domain.DCKorisnik;
import rs.ac.bg.fon.silab.lib.domain.DCMatrica;
import rs.ac.bg.fon.silab.server.logic.state.PlayState;

/**
 *
 * @author MARINA
 */
public class Participation {

    private DCMatrica matrica;
    private PlayState state;
    
    public Participation() {
    }
    
    public Participation(DCMatrica matrica, PlayState state) {
        this.matrica = matrica;
        this.state = state;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.matrica);
        hash = 71 * hash + Objects.hashCode(this.state);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Participation other = (Participation) obj;
        if (!Objects.equals(this.matrica, other.matrica)) {
            return false;
        }
        return true;
    }
    
    public PlayState getState() {
        return state;
    }
    
    public void setState(PlayState state) {
        this.state = state;
    }
    
    public DCIgra getIgra() {
        return matrica.getIgra();
    }
    
    public void setIgra(DCIgra igra) {
        matrica.setIgra(igra);
    }
    
    public DCKorisnik getKorisnik() {
        return matrica.getKorisnik();
    }
    
    public void setKorisnik(DCKorisnik korisnik) {
        matrica.setKorisnik(korisnik);
    }
    
    public DCMatrica getMatrica() {
        return matrica;
    }
    
    public void setMatrica(DCMatrica matrica) {
        this.matrica = matrica;
    }
    
}
