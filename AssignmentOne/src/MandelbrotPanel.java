import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Models the panel with the mandelbrot set on it
 */
public class MandelbrotPanel extends JPanel {

    private int height;
    private int width;
    private int limit;

    private double xWidth = 1.6;
    private double yWidth = 2.0;

    BufferedImage bufferedImage;

    //Constructor
    public MandelbrotPanel(int height, int width) {
        super();

        this.height = height;
        this.width = width;
        this.limit = 200;

        draw();
    }

    //Draws the fractal on the bufferedImage
    private void draw() {
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //Loop through each pixel in display area
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

                //Scale x and y of pixel
                double x = (i / (width / (2 * xWidth))) - xWidth;
                double y = (j / (height / (2 * yWidth))) - yWidth;

                int iterations = 0;

                //This pixel represents point c of the complex plane
                ComplexNumber complexNumber = new ComplexNumber();

                //Calculate the sequence of z(i) values up to a fixed limit
                while (complexNumber.modulusSquared() < 5 && iterations < limit) {

                    //Build the Mandelbrot x and y
                    complexNumber = complexNumber.square();
                    complexNumber.setReal(complexNumber.getReal() + x);
                    complexNumber.setImaginary(complexNumber.getImaginary() + y);

                    iterations++;
                }
                if (iterations < limit) {
                    //HSB(Hue, Saturation, Brightness)
                    Color color = Color.getHSBColor(255, (float)0.9, iterations * 20);
                    bufferedImage.setRGB(i, j, color.getRGB());
                } else {
                    bufferedImage.setRGB(i, j, Color.BLACK.getRGB());
                }
            }
        }
    }

    //Paint
    public void paint(Graphics g) {
        super.paintComponent(g);
        //Draws the Mandelbrot set image onto the panel
        g.drawImage(bufferedImage, 0, 0, width, height, null);
    }
}
