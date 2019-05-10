/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.polje.kolona;

import java.util.List;
import rs.ac.bg.fon.silab.lib.domain.DCPolje;

/**
 *
 * @author MARINA
 */
public class FalseKolonaLogic extends KolonaLogic{

    @Override
    public Boolean available(int red, List<DCPolje> polja) {
        return false;
    }
    
}
