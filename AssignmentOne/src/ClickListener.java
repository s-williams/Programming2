import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Listens for clicks on the Mandelbrot Panel
 */
public class ClickListener implements MouseListener {

    private MandelbrotViewer mandelbrotViewer;
    private JLabel coordinateLabel;

    //Used in the SaveListener
    private double mostRecentX;
    private double mostRecentY;

    //Constructor
    public ClickListener(MandelbrotViewer mandelbrotViewer, JLabel coordinateLabel) {
        this.coordinateLabel = coordinateLabel;
        this.mandelbrotViewer = mandelbrotViewer;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //Scale pixels back to complex number
        double x = (e.getX() / (mandelbrotViewer.getWidth() / (mandelbrotViewer.getxWidth() + mandelbrotViewer.getxWidth()))) - mandelbrotViewer.getxWidth();
        double y = -(e.getY() / (mandelbrotViewer.getHeight() / (mandelbrotViewer.getyWidth() + mandelbrotViewer.getyWidth()))) + mandelbrotViewer.getyWidth();

        //Formatting to 3 decimal places
        String xPrint = String.format("%.5g%n", x);
        String yPrint = String.format("%.5g%n", y);

        //Set the new text
        coordinateLabel.setText("" + xPrint + " + " + yPrint + "i");

        //Store the values in the ClickListener
        mostRecentX = x;
        mostRecentY = y;

        //Show the new JuliaSet
        mandelbrotViewer.juliaPanel.draw(x, y);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public double getMostRecentX() {
        return mostRecentX;
    }

    public double getMostRecentY() {
        return mostRecentY;
    }
}
