import java.io.Serializable;

/**
 * Models a bid by user for specific item for certain amount of pence
 */
public class Bid implements Serializable {
    private User user;
    private Item item;

    // Pence
    private int bid;

    public Bid(User user, Item item, int bid) {
        this.user = user;
        this.item = item;
        this.bid = bid;
    }

    public User getUser() {
        return user;
    }

    public Item getItem() {
        return item;
    }

    public int getBid() {
        return bid;
    }

    public String getBidAsString() {
        double decimal = bid/100;
        return "£" + decimal;
    }
}
