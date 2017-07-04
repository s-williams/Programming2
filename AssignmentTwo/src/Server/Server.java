package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Handles communication between server and client
 */
public class Server extends ServerSocket implements Runnable {

    private Socket socket;
    private final Data data;

    public Server() throws IOException {
        super(60010);
        System.out.println("TCPServer Waiting for client on port 60010");
        while (socket == null) {
            socket = accept();
        }
        System.out.println("Accepted " + socket);
        data = new Data();
        run();
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String line = null;

            System.out.println(line);

            //Receives and processes outputs
            while ((line = in.readLine()) != null) {
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                if (line.trim().toLowerCase().equals("hello")) {
                    System.out.println("Received hello");
                    out.write("Sup");
                    out.newLine();
                    out.flush();
                    System.out.println("Sent Sup");
                }
                // u standing for create new user
                else if(line.trim().toLowerCase().charAt(0) == 'u') {
                    System.out.println("Creating user");
                    String[] parts = line.substring(1).split("~");
                    data.createNewUser(parts[0],parts[1],parts[2]);
                    System.out.println("User created");
                }
                // i standing for create new item
                else if (line.trim().toLowerCase().charAt(0) == 'i') {
                    String[] parts = line.substring(1).split("~");
                    data.createNewItem(parts[0], parts[1], parts[2], parts[3], parts[4]);
                }
                // b standing for create new bid
                else if (line.trim().toLowerCase().charAt(0) == 'b') {
                    String[] parts = line.substring(1).split("~");
                    data.createNewBid(parts[0], parts[1], parts[2]);
                }
                // @ checks if user exists
                else if (line.trim().toLowerCase().charAt(0) =='@') {
                    String[] parts = line.substring(1).split("~");
                    data.checkIfUserExists(parts[0], parts[1]);
                }
                // # checks if user password is correct
                else if (line.trim().toLowerCase().charAt(0) =='#') {
                    String[] parts = line.substring(1).split("~");
                    data.checkUserPasswordIsCorrect(parts[0], parts[1], parts[2]);
                }
                else {
                    throw new IOException("Unknown input");
                }
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
