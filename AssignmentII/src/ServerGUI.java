import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

/**
 * Creates a GUI with a button that prints out the log file
 */
public class ServerGUI extends JFrame {

    private Log log;

    public ServerGUI(Log log) {
        super();

        this.log = log;

        setTitle("Server GUI");
        setSize(200,200);
        setLocation(800,400);

        setLayout(new BorderLayout());

        //Text area
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        //Status textfield
        JLabel status = new JLabel("Status: ");
        add(status, BorderLayout.SOUTH);

        //Button
        JButton showLog = new JButton("Show Log");
        showLog.setToolTipText("Shows the log");
        add(showLog, BorderLayout.NORTH);
        showLog.addActionListener(new LogButtonListener(textArea, status));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Log.write("Created Server GUI");
    }

    private class LogButtonListener implements ActionListener {

        private String logFile;
        private JTextArea textArea;
        private JLabel status;

        public LogButtonListener(JTextArea textArea, JLabel status) {
            this.textArea = textArea;
            this.status = status;

            status.setText("Ready to show log");

            try {
                logFile = log.getLogName();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            File file = new File(logFile);

            if (file.exists() && !file.isDirectory()) {

                Log.write("Read log file to Server GUI");

                String str = "";
                try {
                    Scanner sc = new Scanner(file);

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
                textArea.setText(str);
                status.setText("Successfully read file");
            }
            else {
                status.setText("Error! File does not exist!");
                Log.write("Failed to read log file to Server GUI");
            }
        }
    }
}
