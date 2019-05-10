/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.lib.transfer.request;

import java.io.Serializable;
import rs.ac.bg.fon.silab.lib.game.Game;
import rs.ac.bg.fon.silab.lib.matrix.Field;

/**
 *
 * @author MARINA
 */
public class RequestObject implements Serializable{
    private String operation;
    private String korisnickoIme;
    private String sifra;
    private Integer [] dices;
    private Long igraId;
    private Field selectedField;
    private Game selectedGame;

    public Game getSelectedGame() {
        return selectedGame;
    }

    public void setSelectedGame(Game selectedGame) {
        this.selectedGame = selectedGame;
    }
    

    public RequestObject() {
    }


    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }



    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public Integer[] getDices() {
        return dices;
    }

    public void setDices(Integer[] dices) {
        this.dices = dices;
    }

    public Long getIgraId() {
        return igraId;
    }

    public void setIgraId(Long igraId) {
        this.igraId = igraId;
    }

    public Field getSelectedField() {
        return selectedField;
    }

    public void setSelectedField(Field selectedField) {
        this.selectedField = selectedField;
    }
    
    
}
