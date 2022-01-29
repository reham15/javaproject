/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelloScene;

import java.awt.MultipleGradientPaint;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author reham
 */
public class HelloScene extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
        Text txt = new Text("Hello World");
        txt.setId("text");
        Reflection reflection = new Reflection();
        txt.setEffect(reflection);
        
        txt.setFill(Color.RED);
        txt.setFont(Font.font(50.0));
        txt.setTranslateY(-30);
       
        
        Rectangle rect=new Rectangle(0,0,400,600);
        Stop[] stops=new Stop[]{new Stop(0,Color.BLACK),new Stop(0.5,Color.WHITE),new Stop(1,Color.BLACK)};
        LinearGradient l=new LinearGradient(0,0,0,1,true,CycleMethod.NO_CYCLE,stops);
        rect.setFill(l);
        StackPane root = new StackPane();
        root.getChildren().add(rect);
        root.getChildren().add(txt);
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
