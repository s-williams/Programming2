import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

/**
 * Creates the GUI for the user
 * Allows the user to be able to submit a new item for sale, make a bid on any open item, see their own bids,
 * see the status of their own items for sale, and receive and display notifications upon winning items.
 */
public class AuctionGUI extends JFrame {

    private ClientComms clientComms;
    private User loggedInUser;

    public AuctionGUI(ClientComms clientComms, User loggedInUser) {
        super();

        System.out.println(loggedInUser);

        this.clientComms = clientComms;
        this.loggedInUser = loggedInUser;

        setSize(800,600);

        //Shows items for sale with searchbar
        HomePanel home = new HomePanel();

        //Auction Panel
        AuctionPanel auctionPanel = new AuctionPanel();

        //Creates a new auction
        CreateAuctionPanel createAuction = new CreateAuctionPanel();

        //Shows user stats/bids/items
        UserStatusPanel userStatus = new UserStatusPanel();

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
        public AuctionPanel() {

        }
    }

    private class CreateAuctionPanel extends JPanel {

    }

    private class UserStatusPanel extends JPanel {}

}

class newItemButtonListener {

}
