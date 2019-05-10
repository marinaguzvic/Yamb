/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yambclient.ui.game.table;

import rs.ac.bg.fon.silab.server.web.Field;
import rs.ac.bg.fon.silab.server.web.FieldArray;

/**
 *
 * @author MARINA
 */
public class Row {
    String rowName;
    FieldArray values;

    public String getRowName() {
        return rowName;
    }

    public void setRowName(String rowName) {
        this.rowName = rowName;
    }

    public Row(String rowName, FieldArray values) {
        this.rowName = rowName;
        this.values = values;
    }
    

    
    public Field getDownwards(){
        for (Field field : values.getItem()) {
            if(field.getColumn() == 1)return field;
        }
        return null;
    }

    public Field getUpwards(){
        for (Field field : values.getItem()) {
            if(field.getColumn() == 3)return field;
        }
        return null;
    }
    
    public Field getMixed(){
        for (Field field : values.getItem()) {
            if(field.getColumn() == 2)return field;
        }
        return null;
    }
    
    public Field getNajava(){
        for (Field field : values.getItem()) {
            if(field.getColumn() == 4)return field;
        }
        return null;
    }
}
