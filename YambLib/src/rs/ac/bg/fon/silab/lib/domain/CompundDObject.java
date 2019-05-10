/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.lib.domain;


import java.io.Serializable;
import java.util.List;

/**
 *
 * @author MARINA
 */
public interface CompundDObject extends Serializable{
    public List<String> classNames();
    public List<GeneralDObject> getItemsFor(String className);
    public GeneralDObject createChild(String className);
    public String getWhere(String className);

    public void addChild(GeneralDObject gdo);
}
