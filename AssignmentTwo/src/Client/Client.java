package Client;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

/**
 * Communication from the client
 */
public class Client extends Socket {

    private BufferedReader inFromServer;
    private BufferedWriter outToServer;

    private Client() throws Exception{
        super("localhost", 60010);

        //Initialises the writers and readers
        inFromServer = new BufferedReader(new InputStreamReader(this.getInputStream()));
        outToServer = new BufferedWriter(new OutputStreamWriter(this.getOutputStream()));

        //Verifies that the connection to the server has been made
        //Sends Hello and expects a "Sup" as a reply
        boolean connected = false;
        while(!connected) {
            if (sendReceiveMessage("Hello").equals("Sup")) {
                connected = true;
                //Starts the auction
                LogInGUImaker logInGUImaker = new LogInGUImaker(this);
            }
        }
    }
    //
    //Sends a message and returns its reply
    private String sendReceiveMessage(String sendMessage) throws IOException {
        inFromServer = new BufferedReader(new InputStreamReader(this.getInputStream()));
        outToServer = new BufferedWriter(new OutputStreamWriter(this.getOutputStream()));
        outToServer.write(sendMessage);
        outToServer.newLine();
        outToServer.flush();

        return inFromServer.readLine();
    }

    boolean checkIfUserExists(String firstName, String lastName) throws IOException {
        inFromServer = new BufferedReader(new InputStreamReader(this.getInputStream()));
        outToServer = new BufferedWriter(new OutputStreamWriter(this.getOutputStream()));
        System.out.println("Sending message to check if user exists");
        outToServer.write("@" + firstName + "~" + lastName);
        outToServer.newLine();
        outToServer.flush();
        System.out.println("Sent message");

        String receivedMessage = inFromServer.readLine().trim().toLowerCase();
        System.out.println(receivedMessage);
        if (receivedMessage.equals("true")) return true;
        else return false;
    }

    //Returns true if the server says the password of a specific user is correct
    boolean checkUserPasswordIsCorrect(String firstName, String lastName, String password) throws IOException {
        outToServer.write("#" + firstName + "~" + lastName + "~" + password);
        outToServer.newLine();
        outToServer.flush();

        if (inFromServer.readLine().trim().toLowerCase().equals("true")) return true;
        else return false;
    }

    void createNewUser(String firstName, String lastName, String password) throws  IOException {
        outToServer.write("u" + firstName + "~" + lastName + "~" + password);
        outToServer.newLine();
        outToServer.flush();
    }

    public static void main(String[] args) {
        try {
            Client client = new Client();
        } catch (ConnectException e) {
            e.printStackTrace();
            main(new String[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
