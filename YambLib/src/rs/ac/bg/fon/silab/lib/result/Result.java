/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.lib.result;

/**
 *
 * @author MARINA
 */
public class Result {
    private String username;
    private Long result;
    private boolean done;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Result(String username, Long result, boolean done) {
        this.username = username;
        this.result = result;
        this.done = done;
    }

    public Result(String username, Long result) {
        this.username = username;
        this.result = result;
    }

    public Result() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }
    
    
}
