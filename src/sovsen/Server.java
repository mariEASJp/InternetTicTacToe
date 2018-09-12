package sovsen;

import java.io.DataOutputStream;
import java.io.*;
import java.net.*;

/**
 * @Author SovenGrp on 12-Sep-18.
 */
public class Server {
    public static void main(String[] args) {

        try {

            ServerSocket server = new ServerSocket(3001);

            Socket s = server.accept();
            System.out.println("Connected");

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF("Welcome to Socket");
        } catch (Exception e) {
        }
    }
}