package sovsen;

import java.io.*;
import java.net.*;

/**
 * @Author SovsenGrp 12-Sep-18.
 */
public class Client {
    public static void main(String[] args) {

        try {
            Socket s = new Socket("127.0.0.1",3001);

           // DataInputStream dis = new DataInputStream(s.getInputStream());
           // String msg = dis.readUTF();

           // System.out.println(msg);


            String fromServer;
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader((System.in)));


            while ((fromServer = in.readLine()) != null){
                System.out.println("Server: " + fromServer);

                if (fromServer.equals("End")){
                    System.out.println("Server is silent");
                    break;
                }


                String fromUser = stdIn.readLine();
                if (fromUser != null){
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }

            }



            //Close the connection and exit
            // dis.close();
            //s1In.close();
            //s1.close();


        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
