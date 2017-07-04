import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Creates Server
 */
public class Server implements Runnable {

    private ServerComms serverComms;
    private DataPersistence dataPersistence;

    public Server() {
        try {
            serverComms = new ServerComms();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataPersistence = new DataPersistence(serverComms);

        Log log = new Log();
        ServerGUI serverGUI = new ServerGUI(log);

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        Message message;
        while (true) {
            message = serverComms.receiveMessage();
            String[] messageParts = message.getContents().trim().split("@");

            try {
                //Process the message
                switch (messageParts[0]) {
                    case "createUser":
                        dataPersistence.createUser(messageParts[1].trim(), messageParts[2].trim(), messageParts[3]);
                        break;
                    case "createItem":
                        dataPersistence.createItem(messageParts[1].trim(), messageParts[2].trim(), messageParts[3], messageParts[4], messageParts[5], messageParts[6], messageParts[7]);
                        break;
                    case "createBid":
                        dataPersistence.createBid(messageParts[1].trim(), messageParts[2].trim(), messageParts[3]);
                        break;
                    case "checkIfUserExists":
                        dataPersistence.checkIfUserExists(messageParts[1].trim(), messageParts[2].trim());
                        break;
                    case "verifyPassword":
                        dataPersistence.verifyPassword(messageParts[1].trim(), messageParts[2].trim(), messageParts[3]);
                        break;
                    case "getCurrentItems":
                        dataPersistence.getCurrentItems();
                        break;
                    default:
                        Log.write("Error parsing message from client: " + Arrays.toString(messageParts));
                        break;
                }
            } catch (ParseException p) {
                p.printStackTrace();
            }
        }
    }

    //Starts the server side of things
    public static void main(String[] args) {
        Server server = new Server();
    }
}
