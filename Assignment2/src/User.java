import java.io.Serializable;
import java.util.HashSet;
import java.util.Random;

/**
 * Models the user of the system
 */
public class User implements Serializable {

    private static HashSet<Integer> takenUserIDs = new HashSet<>();


    private final String firstName;
    private final String lastName;
    private String password; //Note this is bad
    private Integer userID;

    //Constructor
    public User(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password; //Note this is bad

        //Assigns new unique userID by checking in against list of all current userIDs to ensure they dont match
        //Because counting incrementally is a terrible idea: https://youtu.be/gocwRvLhDf8?t=1m59s
        Random random = new Random();
        boolean foundUserID = false;
        while (!foundUserID) {
            int newUserID = random.nextInt(Integer.MAX_VALUE);
            if (!takenUserIDs.contains(newUserID)) {
                foundUserID = true;
                takenUserIDs.add(newUserID);
                this.userID = newUserID;
            }
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public Integer getUserID() {
        return userID;
    }
}
