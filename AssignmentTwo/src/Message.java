/**
 * Models a message sent using comms
 */
public class Message {

    private String stringContents;

    public Message(String stringContents) {
        this.stringContents = stringContents;
    }

    public String getStringContents() {
        return stringContents;
    }
}
