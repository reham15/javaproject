/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellocss;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author reham
 */
public class HelloCss extends Application {
    
    @Override
  public void start(Stage primaryStage) {
       
        Text txt = new Text("Hello World");
        txt.setId("text");
        Text txt2 = new Text("Hello World");
        txt2.setId("text2");
        Rectangle rect=new Rectangle(0,0,400,600);
        rect.setId("rect");
        StackPane root = new StackPane();
       
         root.getChildren().add(rect);
          root.getChildren().add(txt);
           root.getChildren().add(txt2);
        Scene scene = new Scene(root);
        
        scene.getStylesheets().add(getClass().getResource("Style.css").toString());
        
        
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
