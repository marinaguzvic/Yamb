/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.polje;

import rs.ac.bg.fon.silab.server.logic.polje.kolona.KolonaLogic;
import rs.ac.bg.fon.silab.server.logic.polje.red.RedLogic;

/**
 *
 * @author MARINA
 */
public class Polje {
    int red;
    int kolona;
    KolonaLogic kolonaLogic;
    RedLogic redLogic;

    public Polje(int red, int kolona) {
        this.red = red;
        this.kolona = kolona;
    }

    public Polje(int kolona) {
        this.kolona = kolona;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getKolona() {
        return kolona;
    }

    public void setKolona(int kolona) {
        this.kolona = kolona;
    }

    public KolonaLogic getKolonaLogic() {
        return kolonaLogic;
    }

    public void setKolonaLogic(KolonaLogic kolonaLogic) {
        this.kolonaLogic = kolonaLogic;
    }

    public RedLogic getRedLogic() {
        return redLogic;
    }

    public void setRedLogic(RedLogic redLogic) {
        this.redLogic = redLogic;
    }
    
    
}
