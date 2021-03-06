/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yambclient.ui.game;

import java.io.FileInputStream;
import yambclient.ui.login.*;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import yambclient.start.YambClient;

/**
 *
 * @author MARINA
 */
public class GameFormFactory {
    public static void create() throws IOException{
        String resourcePath = "FXMLDocumentGame.fxml";
        URL location = GameFormFactory.class.getResource(resourcePath);

        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        
        Scene scene = new Scene(root);
//        scene.getStylesheets().add("CSS/stylesheet.css");
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(new FileInputStream("src/yambclient/images/dices/dice0.png")));
        stage.setTitle("Jamb");
        stage.show();
        
//        stage.setOnCloseRequest((WindowEvent we) -> {
//        }); 
    }
}
