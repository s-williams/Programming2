package Server;

/**
 * Models a bid by user for specific item for certain amount of pence
 */
public class Bid {
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
}
