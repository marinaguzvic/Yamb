/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.polje.kolona.factory;

import rs.ac.bg.fon.silab.server.logic.polje.kolona.DownKolonaLogic;
import rs.ac.bg.fon.silab.server.logic.polje.kolona.FalseKolonaLogic;
import rs.ac.bg.fon.silab.server.logic.polje.kolona.KolonaLogic;
import rs.ac.bg.fon.silab.server.logic.polje.kolona.MixedKolonaLogic;
import rs.ac.bg.fon.silab.server.logic.polje.kolona.NajavaKolonaLogic;
import rs.ac.bg.fon.silab.server.logic.polje.kolona.TrueKolonaLogic;
import rs.ac.bg.fon.silab.server.logic.polje.kolona.UpKolonaLogic;
import rs.ac.bg.fon.silab.server.logic.state.DicesFirstThrowState;
import rs.ac.bg.fon.silab.server.logic.state.DicesIdleState;
import rs.ac.bg.fon.silab.server.logic.state.GameStartedState;
import rs.ac.bg.fon.silab.server.logic.state.JoinedGameState;
import rs.ac.bg.fon.silab.server.logic.state.Najava;
import rs.ac.bg.fon.silab.server.logic.state.PlayState;

/**
 *
 * @author MARINA
 */
public class KolonaLogicFactory {

    public static KolonaLogic get(int kolona, PlayState state) {
        if (state instanceof Najava) {
            switch (kolona) {
                case 1:
                case 2:
                case 3:
                    return new FalseKolonaLogic();
                case 4:
                    NajavaKolonaLogic kolonaLogic = new NajavaKolonaLogic();
                    kolonaLogic.setNajavaRed(((Najava)state).getNajavaRow());
                    return kolonaLogic;
                default:
                    return null;
            }
        }else if((state instanceof DicesIdleState) || (state instanceof JoinedGameState) || (state instanceof GameStartedState)){
            return new FalseKolonaLogic();
        }
        else{
            switch(kolona){
                case 1:
                    return new DownKolonaLogic();
                case 2:
                    return new MixedKolonaLogic();
                case 3:
                    return new UpKolonaLogic();
                case 4:
                    if(state instanceof DicesFirstThrowState) return new TrueKolonaLogic();
                    else return new FalseKolonaLogic();
                       default:
                  return null;
            }
                
        }
    }
}
