/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

/**
 *
 * @author elkrnk 1
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.*;
import java.io.*;
import java.lang.Thread;
import java.lang.Runnable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Client extends JFrame implements Runnable {
public String str;
Socket mySocket;
DataInputStream dis ;
PrintStream ps;
Thread th;
String []p=new String[100];
  FXML2Controller t;
Parent window;
public Client ( ) throws IOException {
 
 FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML2.fxml"));
            window = loader.load();
 t =loader.<FXML2Controller>getController();
 
  Scene scene = new Scene(window);
       //Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
       //Stage stage=Javaproject.stage;
      Javaproject.stage.setScene(scene);
       Javaproject.stage.show();

try
{
mySocket = new Socket(InetAddress.getLocalHost(), 5005);
dis = new DataInputStream(mySocket.getInputStream ());
ps = new PrintStream(mySocket.getOutputStream ());

}
catch(IOException ex)
{
ex.printStackTrace();
}

th =new Thread(this);
th.start();


}
public void run(){ 
  int i=0;
		while (true){
			 
			try{
                            
                          String str = dis.readLine();
                      
       
       
        //Scene scene = new Scene(root);
                       
                        
                        
                        t.set( str+"\n");
  
                            // c1.t.set("5555");
          
        
        
                          
                          
                        // System.out.println(str);
                         /*if(str!=null&&i<10)
                         {p[i]=str;
                        
                         //str=null;
                         
                     // System.out.println(p[i]);
                          i++;}*/
                          //FXML2Controller.text .appendText("\n");
            }
             
                        

                    

            catch(Exception e)
             {e.printStackTrace(); }
			
			
			
		}
}




   
}