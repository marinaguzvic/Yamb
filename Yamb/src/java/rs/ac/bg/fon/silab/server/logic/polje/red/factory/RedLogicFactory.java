/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.polje.red.factory;

import rs.ac.bg.fon.silab.server.logic.polje.red.FiveRedLogic;
import rs.ac.bg.fon.silab.server.logic.polje.red.FourRedLogic;
import rs.ac.bg.fon.silab.server.logic.polje.red.FullRedLogic;
import rs.ac.bg.fon.silab.server.logic.polje.red.KentaRedLogic;
import rs.ac.bg.fon.silab.server.logic.polje.red.MaxRedLogic;
import rs.ac.bg.fon.silab.server.logic.polje.red.MinRedLogic;
import rs.ac.bg.fon.silab.server.logic.polje.red.OneRedLogic;
import rs.ac.bg.fon.silab.server.logic.polje.red.PokerRedLogic;
import rs.ac.bg.fon.silab.server.logic.polje.red.RedLogic;
import rs.ac.bg.fon.silab.server.logic.polje.red.SixRedLogic;
import rs.ac.bg.fon.silab.server.logic.polje.red.ThreeRedLogic;
import rs.ac.bg.fon.silab.server.logic.polje.red.TwoRedLogic;
import rs.ac.bg.fon.silab.server.logic.polje.red.YambRedLogic;

/**
 *
 * @author MARINA
 */
public class RedLogicFactory {

    public static RedLogic get(int red) {
        switch (red) {
            case 1:
                return new OneRedLogic();
            case 2:
                return new TwoRedLogic();
            case 3:
                return new ThreeRedLogic();
            case 4:
                return new FourRedLogic();
            case 5:
                return new FiveRedLogic();
            case 6:
                return new SixRedLogic();
            case 7:
            case 10:
            case 15:
                return null;
            case 8:
                return new MaxRedLogic();
            case 9:
                return new MinRedLogic();
            case 11:
                return new KentaRedLogic();
            case 12:
                return new FullRedLogic();
            case 13:
                return new PokerRedLogic();
            case 14:
                return new YambRedLogic();
            default:
                return null;

        }
    }
}
