/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.lib.matrix;

import java.util.List;

/**
 *
 * @author MARINA
 */
public class Matrix {
    private Field [][] fields;
    public static List<String> rows;

    public Matrix() {
    }

    public Matrix(Field[][] fields) {
        this.fields = fields;
    }

    public Field[][] getFields() {
        return fields;
    }

    public void setFields(Field[][] fields) {
        this.fields = fields;
    }
    
    public void setField(int row, int column, Field field){
        fields[row][column] = field;
    }
    
    public Field getField(int row, int column){
        return fields[row][column];
    }

    public void setField(Field field, int i, int j) {
        fields[i][j] = field;
    }

    public List<String> getRows() {
        return rows;
    }

    public void setRows(List<String> rows) {
        this.rows = rows;
    }
}
