import javax.swing.*;
import java.awt.*;

/**
 * Is the viewer of the entire gui
 */
public class MandelbrotViewer extends JFrame {

    private double xWidth = 1.6;
    private double yWidth = 2.0;
    private int height = 800;
    private int width = 800;

    //X and Y that is saved by the SaveListener
    private Double StoredX;
    private Double StoredY;

    public JuliaPanel juliaPanel;

    //Main thread
    public static void main(String[] args) {
        //Creates the GUI
        MandelbrotViewer mandelbrotViewer = new MandelbrotViewer("Mandelbrot & Julia Set Viewer");
        mandelbrotViewer.setSize(1600,800);
        mandelbrotViewer.makeGUI();
    }

    //Constructor
    private MandelbrotViewer(String title) {
        super(title);
    }

    //Makes the GUI for the viewer
    private void makeGUI() {
        //Sets the layout
        this.setLayout(new BorderLayout());

        //Adds the side menu
        JPanel westPanel = new JPanel();
        this.add(westPanel, BorderLayout.WEST);
        westPanel.setLayout(new GridLayout(3,1));
        JLabel coordinateLabel = new JLabel();
        coordinateLabel.setText("Initialised");
        JPanel xandyBox = new JPanel();
        xandyBox.setLayout(new GridLayout(2,1));
        xandyBox.add(new JLabel("Point clicked at:"));
        xandyBox.add(coordinateLabel);
        westPanel.add(xandyBox);

        //Save and Load
        JPanel saveAndLoadPanel = new JPanel();
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");
        saveAndLoadPanel.setLayout(new GridLayout(2,1));
        saveAndLoadPanel.add(saveButton);
        saveAndLoadPanel.add(loadButton);
        westPanel.add(saveAndLoadPanel);

        //Lower third
        JPanel placeholder = new JPanel();
        JLabel jLabel = new JLabel();
        placeholder.add(jLabel);
        westPanel.add(placeholder);

        //Adds the Mandelbrot panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1,2));
        this.add(centerPanel, BorderLayout.CENTER);
        MandelbrotPanel mandelbrotPanel = new MandelbrotPanel(800,800);
        centerPanel.add(mandelbrotPanel);

        //Julia Set bit
        juliaPanel = new JuliaPanel(800,800);
        centerPanel.add(juliaPanel);

        //Adds the Mandelbrot panel click listener
        ClickListener clickListener = new ClickListener(this ,coordinateLabel);
        mandelbrotPanel.addMouseListener(clickListener);

        //Save and Load Listeners
        saveButton.addActionListener(new SaveListener(jLabel, this, clickListener));
        loadButton.addActionListener(new LoadListener(jLabel, this));

        //Ends program on window close
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Set visible
        this.setVisible(true);
    }

    public double getxWidth() {
        return xWidth;
    }

    public double getyWidth() {
        return yWidth;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Double getStoredY() {
        return StoredY;
    }

    public void setStoredY(double StoredY) {
        this.StoredY = StoredY;
    }

    public Double getStoredX() {
        return StoredX;
    }

    public void setStoredX(double StoredX) {
        this.StoredX = StoredX;
    }
}