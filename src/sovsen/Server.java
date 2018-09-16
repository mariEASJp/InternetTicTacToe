package sovsen;

import java.io.DataOutputStream;
import java.io.*;
import java.net.*;

/**
 * @Author SovenGrp on 12-Sep-18.
 */
public class Server {


    static ServerSocket server;
    static Socket client;
    static BufferedReader in;
    static PrintWriter out;

    public static void main(String[] args) {

        try {

            server = new ServerSocket(3001);
            System.out.println("Server listening");


            while(Board.getObservers() < 2){
                try{

                    client = server.accept();
                    System.out.println("Connection established");

                    System.out.println("client is: " + client.toString());
                    ServerThread s =  new ServerThread(client);
                    Board.attach(s);
                    s.start();


                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Connection error");
                }
            }


        } catch (Exception e) {

        }

    }


    public static void closeServer() throws IOException{
        System.out.println("Close connection");
        out.close();
        in.close();
        client.close();
        server.close();
    }






}