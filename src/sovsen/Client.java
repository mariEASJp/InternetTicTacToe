package sovsen;
import java.io.IOException;
import java.net.*;
/**
 * @Author SovsenGrp 12-Sep-18.
 */
public class Client {
    public static void main(String[] args) throws IOException {


            Socket s = new Socket("127.0.0.1", 3001);
            System.out.println("Connected!");
        }
    }
