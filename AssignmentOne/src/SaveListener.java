import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Models the listener on the save button
 */
public class SaveListener implements ActionListener {

    private JLabel jLabel;
    private MandelbrotViewer mandelbrotViewer;
    private ClickListener clickListener;

    //Constructor
    public SaveListener(JLabel jLabel, MandelbrotViewer mandelbrotViewer, ClickListener clickListener) {
        this.jLabel = jLabel;
        this.mandelbrotViewer = mandelbrotViewer;
        this.clickListener = clickListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        mandelbrotViewer.setStoredX(clickListener.getMostRecentX());
        mandelbrotViewer.setStoredY(clickListener.getMostRecentY());

        jLabel.setText("Saved!");
    }
}
