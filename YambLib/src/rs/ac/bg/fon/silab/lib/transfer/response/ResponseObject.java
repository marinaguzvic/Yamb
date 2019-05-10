/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.lib.transfer.response;

import java.io.Serializable;
import java.util.List;
import rs.ac.bg.fon.silab.lib.game.Game;
import rs.ac.bg.fon.silab.lib.matrix.Matrix;

/**
 *
 * @author MARINA
 */
public class ResponseObject implements Serializable{
    private int code;
    private Matrix matrix;
    private Integer [] dices;
    private int numberOfThrows;

    public int getNumberOfThrows() {
        return numberOfThrows;
    }

    public void setNumberOfThrows(int numberOfThrows) {
        this.numberOfThrows = numberOfThrows;
    }
    private List<Game> games;

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Integer[] getDices() {
        return dices;
    }

    public void setDices(Integer[] dices) {
        this.dices = dices;
    }
    private String message;

    public ResponseObject() {
    }


    public ResponseObject(int code, Matrix matrix, Integer[] dices, String message) {
        this.code = code;
        this.matrix = matrix;
        this.dices = dices;
        this.message = message;
    }
    
    

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }
    
    
}
