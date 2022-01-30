package server;

/*import java.io.*;
import java.net.*;
import java.util.*;



public class Server {
    ServerSocket serverSocket;
    public Server() {
	    try
		{
        serverSocket = new ServerSocket(7001);
		}
		catch (IOException ex)
	    {
            ex.printStackTrace();
        }
        while (true) {
        try
		{    
			Socket s = serverSocket.accept();
			new ChatHandler(s);
		}
		catch (IOException ex)
	    {
            ex.printStackTrace();
        }	
           
        }
    }
    public static void main(String[] args) {
        new Server();
    }
}*/

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
 
import java.io.PrintStream;
import java.lang.Thread;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Server {
    ServerSocket serverSocket;
 
    public Server() {
        try {
            serverSocket = new ServerSocket(5005);
            System.out.println("Server is running on port 5005");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
 
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
 
                /// OPEN NEW THREAD FOR THE NEW CLIENT
                ClientHandler ch = new ClientHandler(socket);
 
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
 
    }
 
    public static void main(String[] args) {
        Server server = new Server();
    }
}
 
