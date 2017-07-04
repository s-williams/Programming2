import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Models the communication from the client's persepective
 */
public class ClientComms extends Socket implements Comms {

    private ObjectOutputStream outToServer;
    private ObjectInputStream inFromServer;

    public ClientComms() throws IOException {
        super("localhost", 60010);

        outToServer = new ObjectOutputStream(getOutputStream());
        inFromServer = new ObjectInputStream(getInputStream());

        sendMessage(new Message("Test message please ignore"));
    }

    public void sendMessage(String string) {
        sendMessage(new Message(string));
    }

    @Override
    public void sendMessage(Message message) {
        try {
            outToServer.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Message receiveMessage() {
        try {
            return (Message)inFromServer.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ObjectMessage receiveObjectMessage() {
        try {
            return (ObjectMessage)inFromServer.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
