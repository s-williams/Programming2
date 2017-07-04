import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Models the listener on the load button
 */
public class LoadListener implements ActionListener {

    private JLabel jLabel;
    private MandelbrotViewer mandelbrotViewer;

    //Constructor
    public LoadListener(JLabel jLabel, MandelbrotViewer mandelbrotViewer) {
        this.jLabel = jLabel;
        this.mandelbrotViewer = mandelbrotViewer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Check if there is a real value in the store
        if (mandelbrotViewer.getStoredX().equals(null) || mandelbrotViewer.getStoredY().equals(null)) {
            jLabel.setText("Failed to load!");
        } else {
            //Draw the saved Julia set
            mandelbrotViewer.juliaPanel.draw(mandelbrotViewer.getStoredX(), mandelbrotViewer.getStoredY());

            jLabel.setText("Loaded!");
        }
    }
}
