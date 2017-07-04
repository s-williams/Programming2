import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;

/**
 * Saves and manages the data
 * Mainly used by the ServerComm & Server classes to answer data requests and create new instances
 */
public class DataPersistence {
    private HashSet<User> users;
    private HashSet<Item> items;
    private ServerComms serverComms;

    public DataPersistence(ServerComms serverComms) {
        this.serverComms = serverComms;
        users = new HashSet<User>();
        items = new HashSet<Item>();

        //Test data
        try {
            createUser("Test","Buddy","test");
            createItem("Test", "Very Testing", "Art", "2016-05-12_20-20-20", "2016-06-12_20-20-20", "50", "500");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void createUser(String firstName, String lastName, String password) {
        users.add(new User(firstName, lastName, password));
        Log.write("Created new user: " + firstName + " " + lastName + " " + password);

    }

    public void createItem(String title, String description, String category, String startTime, String endTime, String startPrice, String reserve) throws ParseException {
        //Creates calendar from the string input startTime
        Calendar calendarStartTime = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date dateObj = simpleDateFormat.parse(startTime);
        calendarStartTime.setTime(dateObj);

        //Creates calendar from the string input endTime
        Calendar calendarEndTime = Calendar.getInstance();
        dateObj = simpleDateFormat.parse(startTime);
        calendarEndTime.setTime(dateObj);

        items.add(new Item(title, description, Category.valueOf(category), calendarStartTime, calendarEndTime, Integer.parseInt(startPrice), Integer.parseInt(reserve)));
    }

    //Creates a new Bid on a specific item
    public void createBid(String itemID, String userID, String amount) {
        for (Item item : items) {
            if (item.getItemID().equals(Integer.parseInt(itemID))) {
                for (User user : users) {
                    if (user.getUserID().equals(Integer.parseInt(userID))) {
                        item.addBid(new Bid(user, item, Integer.parseInt(amount)));
                    }
                    break;
                }
            }
            break;
        }
    }

    public void checkIfUserExists(String firstName, String lastName) {
        boolean userExists = false;
        for(User user : users) {
            if(user.getFirstName().equals(firstName.trim()) && user.getLastName().equals(lastName)) {
                //User does exist
                userExists = true;
                break;
            }
        }
        if (userExists) serverComms.sendMessage(new Message("true"));
        else serverComms.sendMessage(new Message("false"));

    }

    public void verifyPassword(String firstName, String lastName, String password) {
        boolean passwordCorrect = false;
        for(User user : users) {
            if(user.getFirstName().equals(firstName.trim()) && user.getLastName().equals(lastName)) {
                //User does exist
                if (user.getPassword().equals(password)) passwordCorrect = true;
                break;
            }
        }
        if (passwordCorrect) serverComms.sendMessage(new Message("true"));
        else serverComms.sendMessage(new Message("false"));
    }

    public void getCurrentItems() {
        HashSet<Item> currentItems = new HashSet<Item>();
        for (Item item : items) {
            if(item.getEndTime().compareTo(Calendar.getInstance()) > 0) {
                currentItems.add(item);
            }
        }
        serverComms.sendMessage(new ObjectMessage(currentItems));
    }
}
