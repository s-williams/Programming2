import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Models an item for sale in the auction
 */
class Item implements Serializable {

    private static HashSet<Integer> takenItemIDs = new HashSet<>();

    private String title;
    private String description;
    private Category category;
    private Integer itemID;
    private Calendar startTime;
    private Calendar endTime;
    private Integer startPrice;
    private ArrayList<Bid> bids;

    public Item(String title, String description, Category category, Calendar startTime, Calendar endTime, Integer startPrice, Integer reserve) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startPrice = startPrice;

        //Assigns new unique userID by checking in against list of all current userIDs to ensure they dont match
        //Because counting incrementally is a terrible idea: https://youtu.be/gocwRvLhDf8?t=1m59s
        Random random = new Random();
        boolean foundItemID = false;
        while (!foundItemID) {
            int newUserID = random.nextInt(Integer.MAX_VALUE);
            if (!takenItemIDs.contains(newUserID)) {
                foundItemID = true;
                takenItemIDs.add(newUserID);
                this.itemID = newUserID;
            }
        }

        bids = new ArrayList<Bid>();
    }

    public void addBid(Bid bid) {
        bids.add(bid);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getItemID() {
        return itemID;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public Integer getStartPrice() {
        return startPrice;
    }

    public ArrayList<Bid> getBids() {
        return bids;
    }

    //Returns the highest bid
    public Bid getHighestBid() {
        Bid highest = null;

        for(Bid bid : bids) {
            if (highest.equals(null)) highest = bid;
            if (bid.getBid() > highest.getBid()) highest = bid;
        }

        return highest;
    }
}
