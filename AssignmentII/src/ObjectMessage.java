import java.io.Serializable;

/**
 * Models a more general message sent over Comms
 */
public class ObjectMessage implements Serializable {

    private Object object;

    public ObjectMessage(Object object) {
        this.object = object;
    }

    public Object getContents() {
        return object;
    }
}
