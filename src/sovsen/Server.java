package sovsen;

import java.io.DataOutputStream;
import java.io.*;
import java.net.*;

/**
 * @Author SovenGrp on 12-Sep-18.
 */
public class Server {

    static Socket[] clients = new Socket[2];
    static BufferedReader[] inputs = new BufferedReader[2];

    static ServerSocket server;
    static Socket client;
    static BufferedReader in;
    static BufferedReader in2;
    static PrintWriter out;
    static PrintWriter out2;
    static Socket client2;

    public static void main(String[] args) {

        try {

            server = new ServerSocket(3001);
            System.out.println("Server listening");


            while(true){
                try{

                    client = server.accept();
                    System.out.println("Connection established");

                    System.out.println("client1 is: " + client.toString());

                    new ServerThread(client).start();


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


    public static void updateBoards() throws IOException{
        System.out.println("UpdateBoards()");
        //dos.writeUTF(Board.viewBoard() + "\nWhere do you want to place your mark?");
    }





}