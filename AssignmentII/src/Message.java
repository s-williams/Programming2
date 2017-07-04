import java.io.Serializable;

/**
 * Models a message sent using comms
 */
public class Message implements Serializable {

    private String stringContents;

    public Message(String stringContents) {
        this.stringContents = stringContents;
    }

    public String getContents() {
        return stringContents;
    }
}
