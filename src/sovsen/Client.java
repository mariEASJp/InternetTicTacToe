package sovsen;

import java.io.*;
import java.net.*;

/**
 * @Author SovsenGrp 12-Sep-18.
 */
public class Client {

    static Socket s1;
    static BufferedReader stdIn;

    public static void main(String[] args) {


        try {

            s1 = new Socket("localhost", 3001);


            String fromServer = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(s1.getInputStream()));

            stdIn = new BufferedReader(new InputStreamReader((System.in)));


            while ((fromServer = in.readLine()) != null){

                System.out.println("Conn");
                String[] strArr = fromServer.split("~");




                System.out.println("Server: ");

                for (String c : strArr) {
                    System.out.println("Client-c " + c + "\t");
                }

                if (fromServer.equals("End")){
                    System.out.println("Server is silent");
                    break;
                }



                String fromUser = stdIn.readLine();

                if (fromUser != null){

                    write("from user: " + fromUser);
                    System.out.println("Client: " + fromUser);
                    // out.println(fromUser);
                }




            }


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }



        //Close the connection and exit
        // dis.close();
        //s1In.close();
        //s1.close();
    }


    public static void write(String fromUser){
        try {

            PrintWriter out;
            out = new PrintWriter(s1.getOutputStream(), true);
            out.println(fromUser);

        } catch (IOException e) {
            e.printStackTrace();



        }
    }
}
