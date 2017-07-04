import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Models the communication from the Server's persepective
 */
public class ServerComms extends ServerSocket implements Comms {

    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;


    public ServerComms() throws IOException {
        super(60010);

        Socket socket = accept();

        outToClient = new ObjectOutputStream(socket.getOutputStream());
        inFromClient = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public synchronized void sendMessage(Message message) {
        try {
            System.out.println("wasdawc");
            outToClient.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized Message receiveMessage() {
        try {
            System.out.println("wadasda");
            Message returnValue = (Message)inFromClient.readObject();
            return returnValue;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void sendMessage(ObjectMessage objectMessage) {
        try {
            System.out.println("asdajsd");
            outToClient.writeObject(objectMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
