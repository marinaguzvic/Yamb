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
import rs.ac.bg.fon.silab.lib.result.Result;

/**
 *
 * @author MARINA
 */
public class ResponseObject implements Serializable{
    private int code;
    private Matrix matrix;
    private Integer [] dices;
    private int numberOfThrows;
    private List<Result> opponentResults;
    private Result myResult;
    

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

    public List<Result> getOpponentResults() {
        return opponentResults;
    }

    public void setOpponentResults(List<Result> opponentResults) {
        this.opponentResults = opponentResults;
    }

    public Result getMyResult() {
        return myResult;
    }

    public void setMyResult(Result myResult) {
        this.myResult = myResult;
    }
    
    
}
