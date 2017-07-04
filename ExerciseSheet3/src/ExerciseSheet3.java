import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class ExerciseSheet3 {
    public static void main(String[] args) {
        //Increment Listener
        QuestionOne questionOne = new QuestionOne();

        //Clickable shapes
        QuestionTwo questionTwo = new QuestionTwo();

        //Dice
        QuestionThree questionThree = new QuestionThree();

        //This is question four
        QuestionFour questionFour = new QuestionFour();

        //This is question five
        QuestionFive questionFive = new QuestionFive();

        //This is question six
        QuestionSix questionSix = new QuestionSix();
    }
}

class QuestionOne extends JFrame {

    int number = 0;

    public QuestionOne() {
        JFrame jFrame = new JFrame("Increment with internal classes");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setSize(500, 150);

        JTextField output = new JTextField(String.valueOf(number), 10);
        JButton increment = new JButton("increment");
        increment.addActionListener(new IncrementListener(output));
        JButton reset = new JButton("Reset");
        reset.addActionListener(new ResetListener(output));

        jFrame.setLayout(new FlowLayout());
        jFrame.add(increment);
        jFrame.add(reset);
        jFrame.add(output);

        jFrame.pack();
    }

    class IncrementListener implements ActionListener {

        JTextField textField;

        public IncrementListener(JTextField textField) {
            this.textField = textField;
        }

        public void actionPerformed(ActionEvent event) {
            textField.setText(String.valueOf((Integer.parseInt(textField.getText()) + 1)));
        }
    }

    class ResetListener implements ActionListener {

        JTextField textField;

        public ResetListener(JTextField textField) {
            this.textField = textField;

        }

        public void actionPerformed(ActionEvent event) {
            textField.setText(String.valueOf(0));
        }
    }
}

class QuestionTwo extends JFrame {
    public QuestionTwo() {

        //Main panel
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        //Drawing
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            //Makes random new colour
            float r = random.nextFloat();
            float g = random.nextFloat();
            float b = random.nextFloat();
            Color color = new Color(r,g,b);

            //Circle stuff
            Circle circle = new Circle(color);
            jPanel.add(circle);
            circle.setBounds(random.nextInt(500),random.nextInt(500),60,60);
            circle.addMouseListener(new circleListener(circle, jPanel));

            //Square stuff
            Square square = new Square(color);
            jPanel.add(square);
            square.setBounds(random.nextInt(500),random.nextInt(500),60,60);
            square.addMouseListener(new squareListener(square, jPanel));
        }

        //Window
        JFrame jFrame = new JFrame("Clickable shapes!");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(jPanel);
        jFrame.setLocation(0, 0);
        jFrame.setSize(600, 600);
        jFrame.setVisible(true);
    }





    class Circle extends JPanel {

        Color color;

        public Circle(Color color) {
            this.color = color;
        }
        public void paint(Graphics g){
            g.setColor(color);
            g.fillOval(0, 0, 60, 60);
        }
    }

    class Square extends JPanel {

        Color color;

        public Square(Color color) {
            this.color = color;
        }
        public void paint(Graphics g){
            g.setColor(color);
            g.fillRect(0, 0, 60, 60);
        }
    }

    class circleListener implements MouseListener {

        Circle circle;
        JPanel wholePanel;
        Random random;

        public circleListener(Circle circle, JPanel jPanel) {
            this.circle = circle;
            this.wholePanel = jPanel;
            random = new Random();
        }

        public void mouseClicked(MouseEvent e) {
            //Generates a random colour
            float r = random.nextFloat();
            float g = random.nextFloat();
            float b = random.nextFloat();
            Color color = new Color(r, g, b);

            //Gets coordinates of circle and removes the circle
            int X = circle.getX();
            int Y = circle.getY();
            wholePanel.remove(circle);

            //Makes new circle of random colour in old coordinates
            Circle newCircle = new Circle(new Color(r, g, b));
            newCircle.addMouseListener(new circleListener(circle, wholePanel));
            wholePanel.add(newCircle);
            newCircle.setBounds(X,Y,60,60);
        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }
    }

    class squareListener implements MouseListener {

        Square square;
        JPanel wholePanel;
        Random random;

        public squareListener(Square square, JPanel jPanel) {
            this.square = square;
            this.wholePanel = jPanel;
            random = new Random();
        }

        public void mouseClicked(MouseEvent e) {
            //Generates new random colour
            float r = random.nextFloat();
            float g = random.nextFloat();
            float b = random.nextFloat();
            Color color = new Color(r,g,b);

            //Gets coordinates of square then removes it
            int X = square.getX();
            int Y = square.getY();
            wholePanel.remove(square);

            //Makes a new square with a random colour at the old coordinates
            Square newSquare = new Square(color);
            newSquare.addMouseListener(new squareListener(square, wholePanel));
            wholePanel.add(newSquare);
            newSquare.setBounds(X,Y,60,60);
        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }
    }

    /*
    In the shape superclass there might exist a variable for the colour as well as mouse listeners
    In the square and circle classes there would be listed the actual drawing mechanism for the shape
     */
}

class QuestionThree {
    public QuestionThree() {

        //Main window
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1,1));

        //Add die
        Die die = new Die();
        die.setBounds(0,0,400,400);
        jPanel.add(die);

        //Window
        JFrame jFrame = new JFrame("Dice!");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(jPanel);
        jFrame.setSize(120,120);
        jFrame.setLocation(600, 0);
        jFrame.setVisible(true);
    }
}

class QuestionFour {

}

class QuestionFive {

}

class QuestionSix {

}