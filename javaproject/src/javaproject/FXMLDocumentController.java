/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author elkrnk 1
 */
public   class FXMLDocumentController implements Initializable {
   public   FXML2Controller t;
   public  FXMLLoader loader;
    @FXML
    private Label label;
    @FXML
    private Button bt1;
    @FXML
    private Button bt2;
        
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButton2Action(ActionEvent event) throws IOException {
          label.setText("");
           /*loader = new FXMLLoader(getClass().getResource("FXML2.fxml"));
           Parent window = loader.load();
 t =loader.<FXML2Controller>getController();
  Client c1=new Client();
  for(int i=0;i<(c1.p.length);i++)
  { if(c1.p[i]== null)
       System.out.println(c1.p[i]);
          t.set( "kkk");
  }
          //Client c1=new Client();
       Scene scene = new Scene(window);
       //Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
       Stage stage=Javaproject.stage;
      stage.setScene(scene);
       stage.show();*/
  
      Client c1=new Client();  
          
    }
    
}
