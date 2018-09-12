package sovsen;
import java.io.IOException;
import java.net.*;
/**
 * @Author SovenGrp on 12-Sep-18.
 */
public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket server = null;

            server = new ServerSocket(3001);

            System.out.println("Connected");

                Socket s=server.accept();
            }
        }