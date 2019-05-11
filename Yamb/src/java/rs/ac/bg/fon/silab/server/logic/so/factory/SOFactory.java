/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.server.logic.so.factory;

import rs.ac.bg.fon.silab.lib.transfer.request.RequestObject;
import rs.ac.bg.fon.silab.lib.transfer.util.IOperation;
import rs.ac.bg.fon.silab.server.logic.so.AbstractGenericSO;
import rs.ac.bg.fon.silab.server.logic.so.CalculateResultSO;
import rs.ac.bg.fon.silab.server.logic.so.CreateNewGameSO;
import rs.ac.bg.fon.silab.server.logic.so.EndGameAndCalculateResultSO;
import rs.ac.bg.fon.silab.server.logic.so.GetAllGamesSO;
import rs.ac.bg.fon.silab.server.logic.so.JoinGameSO;
import rs.ac.bg.fon.silab.server.logic.so.LoginSO;
import rs.ac.bg.fon.silab.server.logic.so.LogoutSO;
import rs.ac.bg.fon.silab.server.logic.so.NajaviSO;
import rs.ac.bg.fon.silab.server.logic.so.RefreshOpponentsResultsSO;
import rs.ac.bg.fon.silab.server.logic.so.StartGameSO;
import rs.ac.bg.fon.silab.server.logic.so.ThrowDicesSO;
import rs.ac.bg.fon.silab.server.logic.so.WriteResultSO;

/**
 *
 * @author MARINA
 */
public class SOFactory {
    public static AbstractGenericSO create(RequestObject requestObject){
        switch(requestObject.getOperation()){
            case IOperation.LOGIN:
                return new LoginSO();
            case IOperation.CREATE_NEW_GAME:
                return new CreateNewGameSO();
            case IOperation.GET_ALL_GAMES:
                return new GetAllGamesSO();
            case IOperation.JOIN_GAME:
                return new JoinGameSO();
            case IOperation.NAJAVI_POLJE:
                return new NajaviSO();
            case IOperation.CALCULTATE_RESULT:
                return new WriteResultSO();
            case IOperation.THROW_DICES:
                return new ThrowDicesSO();
            case IOperation.START_GAME:
                return new StartGameSO();
            case IOperation.END_GAME:
                return new EndGameAndCalculateResultSO();
            case IOperation.REFRESH_OPPONENTS:
                return new RefreshOpponentsResultsSO();
            case IOperation.LOGOUT:
                return new LogoutSO();
            default:
                return null;
        }
    }
}
