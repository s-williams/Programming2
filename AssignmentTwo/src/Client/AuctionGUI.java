package Client;

import javax.swing.*;
import java.awt.*;

/**
 * Creates the GUI for the user
 * Allows the user to be able to submit a new item for sale, make a bid on any open item, see their own bids,
 * see the status of their own items for sale, and receive and display notifications upon winning items.
 */
public class AuctionGUI extends JFrame {
    public AuctionGUI() {
        setTitle("Auction System");
        setSize(800,600);

        setLayout(new BorderLayout());

        JToolBar jToolBar = new JToolBar("Toolbar");
        jToolBar.setFloatable(false);

        JButton homeButton = new JButton("Home");
        homeButton.setToolTipText("Returns to the home screen");
        jToolBar.add(homeButton);
        JButton createAuctionButton = new JButton("Create Auction");
        createAuctionButton.setToolTipText("Goes to create auction screen");
        jToolBar.add(createAuctionButton);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class newItemButtonListener {

}
