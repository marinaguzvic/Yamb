/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yambclient.ui.choosegame;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import yambclient.ui.login.LoginFormFactory;

/**
 *
 * @author MARINA
 */
public class ChooseGameFormFactory {
    public static void create() throws IOException{
        String resourcePath = "FXMLDocumentChooseGame.fxml";
        URL location = ChooseGameFormFactory.class.getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        
        Scene scene = new Scene(root);
//        scene.getStylesheets().add("CSS/stylesheet.css");
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(new FileInputStream("src/yambclient/images/dices/dice0.png")));
        stage.setTitle("Jamb");
        stage.show();
    }
}
