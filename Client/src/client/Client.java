package client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
 
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
//import java.awt.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.util.*;
import java.util.Arrays;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import static javafx.collections.FXCollections.observableArrayList;
import static javafx.collections.FXCollections.observableArrayList;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
 
public class Client  implements Runnable {
 
    
   boolean usrerListFlag=true;
    Socket socket;
    BufferedReader dis;
    PrintStream printStream;
    Thread th;
    boolean running = true;
    //int myID;
    User[]u=new User[10];
   ObservableList<User> userList=FXCollections.observableArrayList();
    List<User> users=new LinkedList<User>();
  
     ObjectMapper mapper=new ObjectMapper();
    public Client() {
        
        
   
        try {
            socket = new Socket(InetAddress.getLocalHost(), 5005);
            dis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printStream = new PrintStream(socket.getOutputStream());
          //  mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
          
            printStream.println("RUN");
            //myID = Integer.parseInt(dis.readLine());
 
            //System.out.println("My id : " + myID);
        } catch (UnknownHostException e) {
            System.out.println("Server Inaccessible #1");
        } catch (IOException e) {
            System.out.println("Server Inaccessible #2");
        }
 
       /* this.setLayout(new FlowLayout());
        add(scroll);
        add(tfuser);
        add(tf);
        add(okButton);
 
        okButton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent ae) {
                // ta.append(tf.getText() + "\n");
                // tf.setText("");
                sendMessage();
            }
 
        });
 
        /// ps.println()MOVE
        /// 9
        /// X
 
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                handleServerDisconnect();
            }
        });*/
 
        th = new Thread(this);
        th.start();
    }
 
   /* void sendMessage() {
 
        String message = tf.getText();
        if (message != null) {
            printStream.println("RUN");
            printStream.println(tfuser.getText());
            printStream.println(message);
            tf.setText("");
        }
 
    }*/
 
   
 
   
 
    public void run() {
        while (running) {
            try {
                String signal = "";
               // if (dis != null)
                    signal = dis.readLine();
 
                if (signal.equals("RUN")) 
                    {String message = dis.readLine();
                    //ta.append(message + "\n");
                    System.out.println(message);
                    //List<User> l = new ArrayList<>();
                    if(usrerListFlag)
                         printStream.println("RUN");
                  

                  
                 //userList=mapper.readValue(message,  new TypeReference<ObservableList<User>>(){});
             // u=   mapper.readValue(message, User[].class );
              users = mapper.readValue(message, new TypeReference<List<User>>(){});
                 userList= FXCollections.observableArrayList( users);
              for(int i=0;i<5;i++)
                       
                 
                   {
                   //System.out.println(u[i].getUserName());
                    System.out.println(userList.get(i).getUserName());
                   }
                           
                    }
                 else {
                    /// HANDLE CLOSE
                    handleServerDisconnect();
                }
 
            } catch (IOException e) {
 
                /// HANDLE CLOSE UNEXPECTED
                handleServerDisconnect();
            }
        }
 
        closeConnection();
        System.exit(0);
 
    }
 
    void handleServerDisconnect() {
 
        if (printStream != null) {
            running = false;
            printStream.println("CLOSE");
        } else {
            System.exit(0);
        }
 
    }
 
    void closeConnection() {
 
        try {
            printStream.close();
            dis.close();
            socket.close();
            System.out.println("Connection Terminated!");
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
    
      public static void main(String[] args) {
        Client ui = new Client();
         
        
 
    }
 
}
