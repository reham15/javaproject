


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.simple.JSONObject;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*import java.io.*;
import java.net.*;
import java.util.*;
import java.io.FileNotFoundException;
import java.sql.SQLException;

class ChatHandler extends Thread {
    DataInputStream dis;
    PrintStream ps;
    static Vector < ChatHandler > clientsVector = new Vector < ChatHandler > ();
    String []p;
	
	public ChatHandler(Socket cs) {
        try
		{dis = new DataInputStream(cs.getInputStream());
        ps = new PrintStream(cs.getOutputStream());
        clientsVector.add(this);
        start();
		}
		catch (Exception ex)
	    {
            ex.printStackTrace();
        }
    }
	
    public void run() {
       // while (true) {
		try
           { //String str = dis.readLine();
            sendMessageToAll();
		   }
	    catch (Exception ex)
	       {
            ex.printStackTrace();
           }
        //}
    }
	
    void sendMessageToAll() throws SQLException {
        for (ChatHandler ch: clientsVector) {
           DataBase d=new DataBase();
         p= d.selectusers( );
         for(int i=0;i<p.length;i++) 
         { 
          if(p[i]!=null)
              ch.ps.println(p[i]+"\n");
         }
        }}
    }*/

class ClientHandler extends Thread {
    Socket socket;
    BufferedReader dis;
    PrintStream ps;
    boolean running = true;
    static Vector<ClientHandler> clients = new Vector<ClientHandler>();
    ObservableList<User> userList=FXCollections.observableArrayList();
     ObjectMapper mapper=new ObjectMapper();
 //mapper.enable(SerializationFeature.INDENT_OUTPUT);
    DataBase d=new DataBase();
    
 
    int myID;
 
    public ClientHandler(Socket socket) {
        ///
        //mapper.enable(SerializationFeature.INDENT_OUTPUT);
        this.socket = socket;
        try {
            dis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            ps = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
 
       // myID = clients.size();
        //ps.println(myID);
 
        clients.add(this);
        start();
    }
 
    public void run() {
        String str;
        while (running) {
            try {
                String signal = dis.readLine();
                if (signal.equals("RUN")) {
                    try {
                        //int tempID = Integer.parseInt(dis.readLine());
                        //str = dis.readLine();
                        // System.out.println("Recieved text: " + str);
                        /*/if (str != null) {
                        //broadcastMessage(str);
                        //sendMessage(tempID, str);
                        }*/
                        sendUsers();
                    } catch (SQLException ex) {
                        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (JsonProcessingException ex) {
                        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
 
                } else {
                    /// HANDLE CLOSE
                    handleClientDisconnected();
                }
 
            } catch (IOException e) {
                /// HANDLE CLOSE UNEXPECTED
                handleClientDisconnected();
            }
 
        }
 
        closeConnection();
 
    }
 
    void broadcastMessage(String s) {
 
        for (ClientHandler c : clients) {
            c.ps.println("RUN");
            c.ps.println(s);
        }
 
    }
 
   /* void sendMessage(int id, String s) {
 
        clients.get(id).ps.println("RUN");
        clients.get(id).ps.println(s);
    }
 */
    void handleClientDisconnected() {
        running = false;
        ps.println("CLOSE");
        clients.remove(this);
        System.out.println("Client disconnected: " + clients.size());
    }
 
    void closeConnection() {
 
        try {
            ps.close();
            dis.close();
            socket.close();
            System.out.println("Connection Terminated!");
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
    
    void sendUsers() throws SQLException, JsonProcessingException
    {userList=d.selectusers();
    
    String listJson= mapper.writeValueAsString(userList);
    for (ClientHandler c : clients) {
         c.ps.println("RUN");
         c.ps.println(listJson);
    }
     
    
    
    
    }
 
}
