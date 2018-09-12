package sovsen;
import java.io.IOException;
import java.net.*;
/**
 * @Author SovsenGrp 12-Sep-18.
 */
public class Client {
    public static void main(String[] args) {

        try {
            Socket s = new Socket("127.0.0.1", 3000);
            System.out.println("Connected!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
