import javax.swing.*;
import java.awt.*;

public class ExerciseSheet4 {
    public static void main(String[] args) {
        //Finds smallest integer
        MinInt.run();

        System.out.println(Math.pow(3, 4));

        //Fractal Circle
        QuestionTwo questionTwo = new QuestionTwo();

        //Gray Code
        QuestionThree questionThree = new QuestionThree();
    }
}

class QuestionTwo extends JFrame {

    int width;
    JPanel jPanel;

    public QuestionTwo() {
        super();

        width = 800;

        //Main panel
        jPanel = new JPanel();
        jPanel.setLayout(null);

        //Window
        JFrame jFrame = new JFrame("Fractal!");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(jPanel);
        Circle circle = new Circle();
        jFrame.add(circle);
        jFrame.setLocation(0, 0);
        jFrame.setSize(width, 600);
        jFrame.setVisible(true);
    }

    class Circle extends JPanel {


        int circleWidth;

        public Circle() {
            circleWidth = width/3;
        }

        public void paint(Graphics g) {
            for (int i = 0; i < 3; i++) {
                draw3Circles(i,g);
            }
        }

        public void draw3Circles(int depth, Graphics g) {
            int instanceWidth = width/((int)(Math.pow(3, depth)));
            Color color = new Color(20,200-40*depth,20);

            int x = instanceWidth/2;
            int diameter = instanceWidth/3;
            drawCircle(g,color,x,300,diameter);

            x = instanceWidth/2 + instanceWidth/2;
            drawCircle(g,color,x,300,diameter);

            x = instanceWidth/2 + instanceWidth/2 + instanceWidth/2;
            drawCircle(g,color,x,300,diameter);
        }

        public void drawCircle(Graphics g, Color color, int x, int y, int diameter) {
            g.setColor(color);
            g.fillOval(x,y-diameter,diameter,diameter);
        }
    }
}

class QuestionThree {

}