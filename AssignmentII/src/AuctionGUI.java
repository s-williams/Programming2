import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

/**
 * Creates the GUI for the user
 * Allows the user to be able to submit a new item for sale, make a bid on any open item, see their own bids,
 * see the status of their own items for sale, and receive and display notifications upon winning items.
 */
public class AuctionGUI extends JFrame {

    private ClientComms clientComms;

    public AuctionGUI(ClientComms clientComms) {
        super();

        this.clientComms = clientComms;

        setTitle("Auction System: Home");
        setSize(800,600);

        //Shows items for sale with searchbar
        HomePanel home = new HomePanel();

        //Auction Panel
        AuctionPanel auctionPanel = new AuctionPanel();

        //Creates a new auction
        CreateAuctionPanel createAuction = new CreateAuctionPanel();

        //Shows user stats/bids/items
        UserStatusPanel userStatus = new UserStatusPanel(new User("Placeholder", "Placeholder", "Placeholder"));

        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.addTab("Home screen", home);
        jTabbedPane.addTab("Auction Panel", auctionPanel);
        jTabbedPane.addTab("Create Auction", createAuction);
        jTabbedPane.add("User Status", userStatus);

        add(jTabbedPane);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class HomePanel extends JPanel {

        public HomePanel() {
            setLayout(new BorderLayout());

            JLabel title = new JLabel("Current Auctions");
            add(title, BorderLayout.NORTH);

            JPanel auctionsPanel = new JPanel();
            auctionsPanel.setLayout(new FlowLayout());
            JScrollPane jScrollPane = new JScrollPane(auctionsPanel);
            add(jScrollPane, BorderLayout.CENTER);
            for (Item item : getItems()) {
                JPanel jPanel = new JPanel();
                jPanel.setLayout(new FlowLayout());
                jPanel.add(new JLabel(item.getTitle()));
                jPanel.add(new JLabel(item.getDescription()));
                jPanel.add(new JLabel(item.getCategory().toString()));
                jPanel.add(new JLabel(item.getEndTime().toString()));
                jPanel.add(new JLabel(item.getHighestBid().getBidAsString()));
                auctionsPanel.add(jPanel);
            }
        }

        private HashSet<Item> getItems() {
            clientComms.sendMessage("getCurrentItems");
            return (HashSet<Item>)clientComms.receiveObjectMessage().getContents();
        }
    }

    private class AuctionPanel extends JPanel{
        private AuctionPanel() {
            setLayout(new BorderLayout());
            add(new JLabel("View Auction"), BorderLayout.NORTH);
        }
    }

    private class CreateAuctionPanel extends JPanel {
        private CreateAuctionPanel() {
            setLayout(new BorderLayout());
            add(new JLabel("Create Auction"), BorderLayout.NORTH);

            JPanel centrePanel = new JPanel();
            centrePanel.setLayout(new GridLayout(7,1));

            //New auction title
            JPanel titles = new JPanel();
            titles.setLayout(new GridLayout(1,2));
            titles.add(new JLabel("Auction Title"));
            JTextField titlesJTextField = new JTextField(20);
            titles.add(titlesJTextField);
            centrePanel.add(titles);

            //New auction description
            JPanel descriptions = new JPanel();
            descriptions.setLayout(new GridLayout(1,2));
            descriptions.add(new JLabel("Auction Description"));
            JTextArea descriptionTextArea = new JTextArea(2,20);
            descriptions.add(descriptionTextArea);
            centrePanel.add(descriptions);

            //New auction category
            JPanel categories = new JPanel();
            categories.setLayout(new GridLayout(1,2));
            categories.add(new JLabel("Categories"));
            //Fills a JComboBox with the values from the enum Category
            JComboBox<Category> categoryJComboBox = new JComboBox<Category>(Category.values());
            categories.add(categoryJComboBox);
            centrePanel.add(categories);

            //New auction start time
            JPanel startTimes = new JPanel();
            startTimes.setLayout(new GridLayout(1,2));
            startTimes.add(new JLabel("Start Time"));
            JTextField startTimesJTextField = new JTextField(20);
            startTimes.add(startTimesJTextField);
            centrePanel.add(startTimes);

            //New auction end time
            JPanel endTimes = new JPanel();
            endTimes.setLayout(new GridLayout(1,2));
            endTimes.add(new JLabel("End Time"));
            JTextField endTimesJTextField = new JTextField(20);
            endTimes.add(endTimesJTextField);
            centrePanel.add(endTimes);

            //New auction start price
            JPanel startPrices = new JPanel();
            startPrices.setLayout(new GridLayout(1,2));
            startPrices.add(new JLabel("Start Price"));
            JTextField startPricesTextField = new JTextField(20);
            startPrices.add(startPricesTextField);
            centrePanel.add(startPrices);

            //New auction reserve price
            JPanel reserve = new JPanel();
            reserve.setLayout(new GridLayout(1,2));
            reserve.add(new JLabel("Reserve"));
            JTextField reserveJTextField = new JTextField(20);
            reserve.add(reserveJTextField);
            centrePanel.add(reserve);

            add(centrePanel, BorderLayout.CENTER);

            //Submit button
            JButton submitButton = new JButton("Submit item for Auction");
            submitButton.addActionListener(new SubmitAuctionButtonListener(titlesJTextField, descriptionTextArea, categoryJComboBox, startTimesJTextField, endTimesJTextField, startPricesTextField, reserveJTextField));
            add(submitButton, BorderLayout.SOUTH);

        }

        //The submit button on the create auction page
        private class SubmitAuctionButtonListener implements ActionListener {

            private JTextField title;
            private JTextArea description;
            private JComboBox<Category> categoryJComboBox;
            private JTextField startTime;
            private JTextField endTime;
            private JTextField startPrice;
            private JTextField reserve;

            //Constructor
            public SubmitAuctionButtonListener(JTextField title, JTextArea description, JComboBox<Category> categoryJComboBox, JTextField startTime, JTextField endTime, JTextField startPrice, JTextField reserve) {
                this.title = title;
                this.description = description;
                this.categoryJComboBox = categoryJComboBox;
                this.startTime = startTime;
                this.endTime = endTime;
                this.startPrice = startPrice;
                this.reserve = reserve;
            }

            /*
             * Validates the information given in the fields
             * Sends a message through client comms to create a new item with the given details
             */
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }
    }

    private class UserStatusPanel extends JPanel {
        private UserStatusPanel(User user) {
            setLayout(new BorderLayout());
            add(new JLabel("User Status"), BorderLayout.NORTH);

            JPanel centrePanel = new JPanel();
            centrePanel.setLayout(new GridLayout(4,1));

            JLabel firstName = new JLabel("Fist Name: " );
            centrePanel.add(firstName);
            JLabel lastName = new JLabel("Last Name: ");
            centrePanel.add(lastName);
            JLabel userID = new JLabel("UserID: ");
            centrePanel.add(userID);
            JPanel bids = new JPanel();
            bids.setLayout(new BorderLayout(1,2));
            JLabel bidsPlaced = new JLabel("Bids placed: ");
            bids.add(bidsPlaced);
            JComboBox<Bid> jComboBox = new JComboBox<Bid>();
            bids.add(jComboBox);
            centrePanel.add(bids);

            add(centrePanel, BorderLayout.CENTER);
        }
    }

}