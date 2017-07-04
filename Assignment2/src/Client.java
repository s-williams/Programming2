import java.io.IOException;
import java.util.ArrayList;

/**
 * Creates client
 */
public class Client {

    public Client() {
        try {
            ClientComms clientComms = new ClientComms();
             LogInGUI logInGUI = new LogInGUI(clientComms);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Starts the client side of things
    public static void main(String[] args) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Client client = new Client();
    }
}
