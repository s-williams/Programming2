package Server;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Models an item for sale in the auction
 */
class Item {

    private static HashSet<Integer> takenItemIDs = new HashSet<>();

    private Random random;

    private String title;
    private String description;
    private Integer userID;
    private Category category;
    private Integer itemID;
    private Calendar startTime;
    private Double startPrice;
    private HashMap<Double, User> bids;

    public Item(String title, String description, Integer userID, Category category, Calendar startTime, Double startPrice) {
        this.title = title;
        this.description = description;
        this.userID = userID;
        this.category = category;
        this.startTime = startTime;
        this.startPrice = startPrice;

        //Assigns new unique userID by checking in against list of all current userIDs to ensure they dont match
        //Because counting incrementally is a terrible idea: https://youtu.be/gocwRvLhDf8?t=1m59s
        random = new Random();
        boolean foundItemID = false;
        while (!foundItemID) {
            int newUserID = random.nextInt(2147483647); //2^31 - 1
            if (!takenItemIDs.contains(newUserID)) {
                foundItemID = true;
                takenItemIDs.add(newUserID);
                this.itemID = newUserID;
            }
        }

        bids = new HashMap<Double, User>();
    }


}
