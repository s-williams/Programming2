package Server;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;

/**
 * Contains the data of the system
 * The server interacts with the Users, Items, and Bids with this class
 */
public class Data {

    private ArrayList<User> userArrayList;
    private  HashSet<Integer> takenUserIDs = new HashSet<>();


    public Data() {
        userArrayList = new ArrayList<User>();
        //Dummy user added to avoid problems
        userArrayList.add(new User("dummy", "dummy", "dummy", generateUserID()));
    }

    //Creates a new user
    public void createNewUser(String givenName, String familyName, String password) {
        userArrayList.add(new User(givenName, familyName, password, generateUserID()));
    }

    private Integer generateUserID() {
        Random random;
        Integer returnInteger = 0;

        //Assigns new unique userID by checking in against list of all current userIDs to ensure they dont match
        //Because counting incrementally is a terrible idea: https://youtu.be/gocwRvLhDf8?t=1m59s
        random = new Random();
        boolean foundUserID = false;
        while (!foundUserID) {
            //Essentially impossible to run out of userIDs
            int newUserID = random.nextInt(Integer.MAX_VALUE);
            if (!takenUserIDs.contains(newUserID)) {
                foundUserID = true;
                takenUserIDs.add(newUserID);
                returnInteger = newUserID;
            }
        }
        return returnInteger;
    }

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public String getUserPassword(String firstName, String lastName) throws Exception {
        for (User user : userArrayList) {
            if (user.getGivenName().trim().toLowerCase().equals(firstName.trim().toLowerCase()) && user.getFamilyName().trim().toLowerCase().equals(lastName.trim().toLowerCase()))
                return user.getPassword();
        }
        throw new Exception("getUserPassword failed");
    }

    void createNewItem(String part, String part1, String part2, String part3, String part4) {
        //TODO
    }

    void createNewBid(String part, String part1, String part2) {
        //TODO
    }

    boolean checkIfUserExists(String firstName, String lastName) {
        for (User user : userArrayList) {
            if (user.getGivenName().trim().toLowerCase().equals(firstName.trim().toLowerCase()) && user.getFamilyName().trim().toLowerCase().equals(lastName.trim().toLowerCase()))
                return true;
        }
        return false;
    }

    boolean checkUserPasswordIsCorrect(String firstName, String lastName, String password) {
        for (User user : userArrayList) {
            if (user.getGivenName().trim().toLowerCase().equals(firstName.trim().toLowerCase()) && user.getFamilyName().trim().toLowerCase().equals(lastName.trim().toLowerCase()) && Objects.equals(password, user.getPassword()))
                return true;
        }
        return false;
    }

    //Serialisation
}
