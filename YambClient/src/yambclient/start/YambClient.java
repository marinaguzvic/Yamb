/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yambclient.start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import yambclient.ui.login.LoginFormFactory;

/**
 *
 * @author MARINA
 */
public class YambClient extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        LoginFormFactory.create();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
