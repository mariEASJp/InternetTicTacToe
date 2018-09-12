package sovsen;
import java.io.IOException;
import java.net.*;
/**
 * @Author SovenGrp on 12-Sep-18.
 */
public class Server {
    public static void main(String[] args) {

        ServerSocket server = null;
        try {
            server = new ServerSocket(3000);
        } catch (IOException e) {
            e.printStackTrace();

            try {
                Socket s=server.accept();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            System.out.println("Connected");
        }
    }
}
