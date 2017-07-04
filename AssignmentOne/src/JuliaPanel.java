import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Models the panel which displays the Julia Set
 */
public class JuliaPanel extends JPanel {

    private int height;
    private int width;
    private int limit;

    private double xWidth = 2.0;
    private double yWidth = 2.0;

    BufferedImage bufferedImage;

    //Constructor
    public JuliaPanel(int height, int width) {
        super();

        this.height = height;
        this.width = width;
        this.limit = 100;
    }

    public void draw(double xInput, double yInput) {
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //Loop through each pixel in display area
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

                //Scale x and y of pixel
                double x = (i / (width / (2 * xWidth))) - xWidth;
                double y = (j / (height / (2 * yWidth))) - yWidth;

                int iterations = 0;

                //This pixel represents point c of the complex plane
                ComplexNumber complexNumber = new ComplexNumber(x, y);

                //Calculate the sequence of z(i) values up to a fixed limit
                while (complexNumber.modulusSquared() < 5 && iterations < limit) {

                    //Build the Mandelbrot x and y
                    complexNumber = complexNumber.square();
                    complexNumber.setReal(complexNumber.getReal() + xInput);
                    complexNumber.setImaginary(complexNumber.getImaginary() + yInput);

                    iterations++;
                }
                if (iterations < limit) {
                    //HSB(Hue, Saturation, Brightness)
                    Color color = Color.getHSBColor(10, 5, iterations * 5);
                    bufferedImage.setRGB(i, j, color.getRGB());
                } else {
                    bufferedImage.setRGB(i, j, Color.BLACK.getRGB());
                }
            }
        }

    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        //Draws the Julia set image onto the panel
        g.drawImage(bufferedImage, 0, 0, width, height, null);
    }
}
