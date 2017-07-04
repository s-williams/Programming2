package Server;

import java.util.HashSet;
import java.util.Random;

/**
 * Models the user of the system
 */
public class User {
    private final String givenName;
    private final String familyName;
    private String password; //Note this is bad
    private Integer userID;

    //Constructor
    public User(String givenName, String familyName, String password, Integer userID) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.password = password; //Note this is bad
        this.userID = userID;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getPassword() {
        return password;
    }
}
