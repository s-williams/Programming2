import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ExerciseSheet2 {
    public static void main(String[] args) {
        //This is question one
        QuestionOne questionOne = new QuestionOne();

        //This is question two
        QuestionTwo questionTwo = new QuestionTwo();

        //This is question three
        QuestionThree questionThree = new QuestionThree();

        //This is question four
        QuestionFour questionFour = new QuestionFour();
    }
}

//Question One
class QuestionOne extends JFrame {

    int number = 0;

    public QuestionOne() {
        JFrame jFrame = new JFrame("Question One");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setSize(500,150);
        jFrame.setLocation(0,0);

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
}

class IncrementListener implements ActionListener {

    JTextField textField;

    public IncrementListener(JTextField textField) {
        this.textField = textField;
    }
    public void actionPerformed(ActionEvent event) {
        textField.setText( String.valueOf((Integer.parseInt(textField.getText()) + 1)));
    }
}

class ResetListener implements ActionListener {

    JTextField textField;

    public ResetListener(JTextField textField) {
        this.textField = textField;

    }
    public void actionPerformed(ActionEvent event) {
        textField.setText( String.valueOf(0));
    }
}

//Question Two
class QuestionTwo extends JFrame {
    public QuestionTwo() {

        //Checkboxes
        JCheckBox bold = new JCheckBox("Bold");
        JCheckBox italic = new JCheckBox("Italic");
        JPanel checkboxes = new JPanel();
        checkboxes.setLayout(new GridLayout(2, 1));
        checkboxes.add(bold);
        checkboxes.add(italic);


        //Drop down
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        JComboBox<String> fonts = new JComboBox<String>();
        for (Font f : graphicsEnvironment.getAllFonts()) {
            fonts.addItem(f.getFontName());
        }

        //Text
        JTextField text = new JTextField(10);
        JPanel textbox = new JPanel();
        textbox.add(text);

        //Button
        JButton button = new JButton("Submit");
        JPanel buttony = new JPanel();
        buttony.add(button);

        //Size label & textfield
        JLabel size = new JLabel("Size:");
        JTextField sizeTextField = new JTextField("12", 5);
        JPanel sizePanel = new JPanel();
        sizePanel.add(size);
        sizePanel.add(sizeTextField);
        sizePanel.setLayout(new GridLayout(2,1));

        //Listeners
        SubmitButtonListener submitButtonListener = new SubmitButtonListener(text, fonts, sizeTextField, bold, italic);
        button.addActionListener(submitButtonListener);


        //Together
        JFrame window = new JFrame("Font Chooser");
        JPanel wholePanel = new JPanel();
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        window.setLocation(350,0);
        wholePanel.add(checkboxes);
        wholePanel.add(fonts);
        wholePanel.add(sizePanel);
        wholePanel.add(textbox);
        wholePanel.add(buttony);
        window.add(wholePanel);
        window.pack();
        window.setVisible(true);
    }
}

class SubmitButtonListener implements ActionListener {

    JTextField textField;
    JComboBox<String> jComboBox;
    JTextField sizeField;
    JCheckBox bold;
    JCheckBox italic;

    //Fonts
    Font font;


    public SubmitButtonListener(JTextField textField, JComboBox<String> jComboBox, JTextField sizeField, JCheckBox bold, JCheckBox italic) {
        this.textField = textField;
        this.sizeField = sizeField;
        this.jComboBox = jComboBox;
        this.bold = bold;
        this.italic = italic;
    }

    public void actionPerformed(ActionEvent e) {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        font = textField.getFont();

        //Finds selected font
        for (Font fonty : graphicsEnvironment.getAllFonts()) {
            if(jComboBox.getSelectedItem().equals(fonty.getFontName())){
                font = fonty;
            }
        }

        //Sets size
        font = font.deriveFont(Float.parseFloat(sizeField.getText()));

        //Bold check
        if(bold.isSelected()){
            font = font.deriveFont(Font.BOLD);
        }

        //Italics check
        if(italic.isSelected()){
            font = font.deriveFont(Font.ITALIC);
        }

        //Sets new font
        textField.setFont(font);
    }
}

//Question Three
class QuestionThree extends JFrame {
    public QuestionThree() {

        JFrame jFrame = new JFrame("Randomly sized");


        //Null
        JPanel central = new JPanel();
        JPanel south = new JPanel();
        JPanel together = new JPanel();
        together.setLayout(new BorderLayout());
        together.add(central, BorderLayout.CENTER);
        together.add(south, BorderLayout.SOUTH);

        //South bit, labels
        south.setLayout(new FlowLayout());

        //Centre bit, panels
        central.setLayout(null);


        Random random = new Random();
        //Randomly makes a random number of randomly placed and randomly sized JPanels and generates a label for each one
        for (int i = 0; i < 5; i++) {
            JPanel jPanel = new JPanel();
            jPanel.setBounds(random.nextInt(300),random.nextInt(300),20 + random.nextInt(80),20 + random.nextInt(80));

            //Randomly selects colour
            int rollADice = random.nextInt(6);
            if (rollADice == 1) jPanel.setBackground(Color.red);
            if (rollADice == 2) jPanel.setBackground(Color.blue);
            if (rollADice == 3) jPanel.setBackground(Color.yellow);
            if (rollADice == 4) jPanel.setBackground(Color.green);
            if (rollADice == 5) jPanel.setBackground(Color.pink);
            if (rollADice == 6) jPanel.setBackground(Color.magenta);

            central.add(jPanel);

            //Generates jLabel for each panel
            JLabel jLabel = new JLabel();
            south.add(jLabel);
            jLabel.setText("text");

            //Adds mouse listener to each panel to display relative coords in panel
            jFrame.addMouseListener(new MyMouseListener(jLabel, jPanel));
        }

        //Window
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(together);
        jFrame.setLocation(0,300);
        jFrame.setSize(400,400);
        jFrame.setVisible(true);

    }
}

class MyMouseListener implements MouseMotionListener, MouseListener {

    JLabel jLabel;
    JPanel jPanel;

    public MyMouseListener(JLabel jLabel, JPanel jPanel) {
        this.jLabel = jLabel;
        this.jPanel = jPanel;
    }

    public void mouseClicked(MouseEvent e) {
        jLabel.setText("(" + (e.getX() - jPanel.getX()) + ", " + (e.getY() - jPanel.getY()) + ")");
        System.out.println("click detected");
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        jLabel.setText("(" + (e.getX() - jPanel.getX()) + ", " + (e.getY() - jPanel.getY()) + ")");
        System.out.println("movement detected");
    }
}

//Question Four
class QuestionFour extends JFrame {
    public QuestionFour() {

        //Window
        JPanel together = new JPanel();
        JFrame jFrame = new JFrame("Sliding Puzzle");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(together);
        jFrame.setLocation(500, 300);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}