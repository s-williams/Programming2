import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Models a six sided die
 */
public class Die extends JPanel {

    int number;
    Random random;

    //Constructor
    public Die() {
        super();
        random = new Random();
        number = random.nextInt(6) + 1;
    }

    //Paints it
    public void paint(Graphics g){
        super.paint(g);
        super.setBackground(Color.WHITE);
        super.setBounds(0, 0, 40, 40);
        this.drawDice(g);
    }

    public void drawDice(Graphics g){
        if(number == 1) {
            middle(g);
        } else if (number == 2){
            topLeft(g);
            bottomRight(g);
        } else if(number == 3){
            topLeft(g);
            middle(g);
            bottomRight(g);
        } else if(number == 4) {
            topLeft(g);
            topRight(g);
            bottomLeft(g);
            bottomRight(g);
        } else if(number == 5) {
            topLeft(g);
            topRight(g);
            middle(g);
            bottomLeft(g);
            bottomRight(g);
        } else if(number == 6){
            topLeft(g);
            topRight(g);
            middleLeft(g);
            middleRight(g);
            bottomLeft(g);
            bottomRight(g);
        }
    }

    //Draw a circle on the top left
    public void topLeft(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(10, 10, 2, 2);
    }

    //Draw a circle on the top right
    public void topRight(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(30, 10, 2, 2);
    }

    //Draw a circle on the middle left
    public void middleLeft(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(10, 20, 2, 2);
    }

    //Draw a circle on the middle
    public void middle(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(20, 20, 2, 2);
    }

    //Draw a circle on the middle right
    public void middleRight(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(30, 20, 2, 2);
    }

    //Draw a circle on the bottom left
    public void bottomLeft(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(10, 30, 2, 2);
    }

    //Draw a circle on the bottom right
    public void bottomRight(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(30, 30, 2, 2);
    }

    //Shows new value on the die
    public void updateVal(int i) {
        number = i;
    }
}
