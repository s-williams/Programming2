import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Creats a simple form with a text box, submit, and cancel
 */

public class SubmitCancelForm {

    public static void main(String[] args){

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

class QuestionOne extends JFrame {
    public QuestionOne() {
        JFrame window = new JFrame("Simple Submit Cancel Form");
        window.setSize(100,200);
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE) ;
        JPanel panel = new JPanel();

        // The following just adds a bit of padding
        Border eb = new EmptyBorder(10,10,10,10);
        panel.setBorder(eb);

        window.setContentPane(panel);
        panel.setLayout(new GridLayout(2, 1));

        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");
        JTextField textField = new JTextField(10);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout());
        textPanel.setBorder(new EmptyBorder(1,1,1,1));
        textPanel.add(textField);

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        buttons.setBorder(new EmptyBorder(1,1,1,1));

        panel.add(textPanel);
        buttons.add(submitButton);
        buttons.add(cancelButton);
        panel.add(buttons);

        window.pack();

        window.setVisible(true);
    }
}

class QuestionTwo extends JFrame {
    public QuestionTwo() {


        //Checkboxes
        JCheckBox bold = new JCheckBox("Bold");
        JCheckBox italic = new JCheckBox("Italic");
        JPanel checkboxes = new JPanel();
        checkboxes.setLayout(new GridLayout(2, 1));
        checkboxes.add(bold);
        checkboxes.add(italic);

        //Radios
        JRadioButton times = new JRadioButton("Times");
        JRadioButton helvetica = new JRadioButton("Helvetica");
        JRadioButton courier = new JRadioButton("Courier");
        ButtonGroup fonts = new ButtonGroup();
        fonts.add(times);
        fonts.add(helvetica);
        fonts.add(courier);
        JPanel radio = new JPanel();
        radio.setLayout(new GridLayout(3, 1));
        radio.add(times);
        radio.add(helvetica);
        radio.add(courier);

        //Text
        JTextField text = new JTextField(10);
        JPanel textbox = new JPanel();
        textbox.add(text);

        //Button
        JButton button = new JButton("Submit");
        JPanel buttony = new JPanel();
        buttony.add(button);

        //Together
        JFrame window = new JFrame("Font Chooser");
        JPanel wholePanel = new JPanel();
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        wholePanel.add(checkboxes);
        wholePanel.add(radio);
        wholePanel.add(textbox);
        wholePanel.add(buttony);
        window.add(wholePanel);
        window.pack();
        window.setVisible(true);
    }
}

class QuestionThree extends JFrame {
    public QuestionThree() {


        //Checkboxes
        JCheckBox bold = new JCheckBox("Bold");
        JCheckBox italic = new JCheckBox("Italic");
        JPanel checkboxes = new JPanel();
        checkboxes.setLayout(new GridLayout(2, 1));
        checkboxes.add(bold);
        checkboxes.add(italic);

        //Radios fixed to be JComboBox
        String[] fontStrings = {"Times", "Helvetica","Courier"};
        JComboBox<String> fontscombo = new JComboBox(fontStrings);

        JPanel radio = new JPanel();
        radio.setLayout(new FlowLayout());
        radio.add(fontscombo);

        //Text
        JTextField text = new JTextField(10);
        JPanel textbox = new JPanel();
        textbox.add(text);

        //Button
        JButton button = new JButton("Submit");
        JPanel buttony = new JPanel();
        buttony.add(button);

        //Together
        JFrame window = new JFrame("Font Chooser");
        JPanel wholePanel = new JPanel();
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        wholePanel.add(checkboxes);
        wholePanel.add(radio);
        wholePanel.add(textbox);
        wholePanel.add(buttony);
        window.add(wholePanel);
        window.pack();
        window.setVisible(true);
    }
}

class QuestionFour {
    public QuestionFour() {

        //Song name label
        JLabel songName = new JLabel("[Song Name]");

        //Previous button
        JButton previous = new JButton("Previous");

        //Play button
        JButton play = new JButton("Play");

        //Next button
        JButton next = new JButton("Next");

        //South
        JPanel south = new JPanel();
        south.setLayout(new FlowLayout());
        south.add(previous);
        south.add(play);
        south.add(next);

        //Window
        JFrame window = new JFrame("MP4 Player");
        JPanel together = new JPanel();
        together.setLayout(new BorderLayout());
        together.add(songName, BorderLayout.CENTER);
        together.add(south, BorderLayout.SOUTH);
        window.add(together);
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);

    }
}