import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

/**
 * Allows the user to select a file from the local file system. Display the contents of the selected file in a JTextArea
 */
public class QuestionThreeGUI extends JFrame {
    public QuestionThreeGUI() {
        super("File chooser");

        setLayout(new GridLayout(3, 1));

        JLabel inputLabel = new JLabel("File path:");
        JTextField input = new JTextField();
        input.setColumns(10);
        JTextArea contents = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(contents);
        JLabel status = new JLabel("Status");

        input.addActionListener(new fileChooserListener(input, contents, status));

        JPanel inputs = new JPanel();
        inputs.add(inputLabel);
        inputs.add(input);

        add(inputs);
        add(scrollPane);
        add(status);

        setSize(200,200);
        setLocation(300,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class fileChooserListener implements ActionListener {

    private JTextField input;
    private JTextArea contents;
    private JLabel status;

    fileChooserListener(JTextField input, JTextArea contents, JLabel status) {
        this.input = input;
        this.contents = contents;
        this.status = status;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        File file = new File(input.getText());

        if (file.exists() && !file.isDirectory()) {
            String str = "";
            try {
                Scanner sc = new Scanner(new File(input.getText()));

                //Read every line and concatenate the line to the str
                while (sc.hasNextLine()) {
                    str = str + sc.nextLine();

                    //Adds a new line so every new line is on a new line
                    str = str + "\n";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            //Update the contents of the text area
            contents.setText(str);
            status.setText("Successfully read file");
        }
        else {
            status.setText("Error! File does not exist!");
        }
    }
}