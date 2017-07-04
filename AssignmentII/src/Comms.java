import java.net.ServerSocket;
import java.net.Socket;

/**
 * Handles communication between the client and server
 */
public interface Comms {

    public void sendMessage(Message message);

    public Message receiveMessage();
}