package sovsen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {

    BufferedReader in = null;
    PrintWriter out = null;
    Socket client;

    public ServerThread(Socket client){
        this.client = client;
    }

    public void run() {

        try {
            System.out.println("RUN started");
            in = new BufferedReader(
                    new InputStreamReader(client.getInputStream())
            );
            System.out.println("test2");
            out = new PrintWriter(
                    client.getOutputStream(), true
            );

            out.println("YOU ARE CONNECTED");

            System.out.println("test3");
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getCause());
        }


        String inputLine, outputLine;

        try {
            System.out.println("test4");
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client: " + inputLine);
                outputLine = Board.processInput(inputLine);

                System.out.println("test5");
                String[] strArr = outputLine.split("~");
                System.out.println("Server: ");

                for (String c : strArr) {
                    System.out.println(c + "\t");
                }

                out.println(outputLine);

            }
        } catch (IOException ex) {

            System.out.println("IOException in client " + this.getName() + ". " + ex.getCause());
        } catch (NullPointerException npe) {

            System.out.println("Client " + this.getName() + " is closed");


        }


        out.println("You are connected. Waiting for another player...");

    }


    public void closeConnection(){
        try {
            System.out.println("Connection closing");
            if (in != null){
                in.close();
            }

            if (out != null){
                out.close();
                System.out.println("Output socket stream closed");
            }

            if (client != null){
                client.close();
            }

        } catch (IOException ex){
            System.out.println("Socket close error: " + ex.getCause());
        }
    }

}
