package sovsen;

import java.io.DataOutputStream;
import java.io.*;
import java.net.*;

/**
 * @Author SovenGrp on 12-Sep-18.
 */
public class Server {
    static ServerSocket server;
    static Socket s;
    static BufferedReader in;
    static PrintWriter out;

    public static void main(String[] args) {

        try {

            server = new ServerSocket(3001);

            s = server.accept();
            System.out.println("Connected");


            in = new BufferedReader(
                    new InputStreamReader(s.getInputStream())
            );
            out = new PrintWriter(
                    s.getOutputStream(), true);

            out.println("Hello, you are connected");

            String inputLine = "", outputLine = "";

                while((inputLine = in.readLine()) != null){

                    System.out.println("Client: " + inputLine);
                    outputLine = Board.processInput(inputLine);
                    outputLine = "You said: " + inputLine;
                    System.out.println("Server: " + outputLine);
                    out.println(outputLine);


                    if (outputLine.equals("End")){
                        System.out.println("Terminating");
                        closeServer();
                        break;
                    }

                }


        } catch (Exception e) {

        }
    }



    public static void closeServer() throws IOException{
        out.close();
        in.close();
        s.close();
        server.close();
    }


    public static void updateBoards() throws IOException{
        System.out.println("UpdateBoards()");
        //dos.writeUTF(Board.viewBoard() + "\nWhere do you want to place your mark?");
    }





}