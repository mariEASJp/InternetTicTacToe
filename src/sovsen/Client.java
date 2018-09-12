package sovsen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

/**
 * @Author SovsenGrp 12-Sep-18.
 */
public class Client {
    public static void main(String[] args) {

        try {
            Socket s = new Socket("127.0.0.1",3001);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            String msg = dis.readUTF();

            System.out.println(msg);
        } catch (Exception e) {
        }
    }
}
