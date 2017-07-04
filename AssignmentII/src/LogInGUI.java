import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LogInGUI {

    private ClientComms clientComms;

    public LogInGUI (ClientComms clientComms) {

        this.clientComms = clientComms;

        JFrame jframe = new JFrame("Auction System: Log In");

        jframe.setSize(200, 200);
        jframe.setLocation(400, 400);
        jframe.setLayout(new GridLayout(2,1));

        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JLabel firstNameLabel = new JLabel("First Name");
        JLabel lastNameLabel = new JLabel("Last name");
        JLabel passwordLabel = new JLabel("Password");

        JButton logInButton = new JButton("Log In");
        JButton registerButton = new JButton("Register");

        JPanel labelsFields = new JPanel();
        labelsFields.setLayout(new GridLayout(3, 2));

        //Adds the GUI together
        labelsFields.add(firstNameLabel);
        labelsFields.add(firstNameField);
        labelsFields.add(lastNameLabel);
        labelsFields.add(lastNameField);
        labelsFields.add(passwordLabel);
        labelsFields.add(passwordField);
        JPanel buttons = new JPanel();
        buttons.add(logInButton);
        buttons.add(registerButton);
        jframe.add(labelsFields);
        jframe.add(buttons);

        //Adds the listeners
        LogInListener logInListener = new LogInListener(jframe, clientComms, firstNameField, lastNameField, passwordField);
        logInButton.addActionListener(logInListener);
        RegisterListener registerListener = new RegisterListener(jframe, clientComms, firstNameField, lastNameField, passwordField);
        registerButton.addActionListener(registerListener);

        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }
}

abstract class RegisterLoginListener implements ActionListener {

    protected JFrame jframe;
    protected ClientComms clientComms;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JPasswordField passwordField;

    RegisterLoginListener(JFrame jframe, ClientComms clientComms, JTextField firstNameField, JTextField lastNameField, JPasswordField passwordField) {
        this.jframe = jframe;
        this.clientComms = clientComms;
        this.firstNameField = firstNameField;
        this.lastNameField = lastNameField;
        this.passwordField = passwordField;
    }

    //Validates the users inputs
    boolean validate() {



        String problems = "";

        if (firstNameField.getText().trim().toLowerCase().length() < 1)
            problems = problems + "You must have a first name length of at least 2 characters! ";
        if (lastNameField.getText().trim().toLowerCase().length() < 1)
            problems = problems + "You must have a last name length of at least 2 characters! ";
        if (passwordField.getText().length() < 4)
            problems = problems + "You must have a password length of at least 4 characters! ";

        if(problems.equals(""))
            return true;
        else {
            JOptionPane.showMessageDialog(null, problems);
            return false;
        }
    }

    //Returns true if log in for user exists
    boolean logInUserExists() throws IOException {
        clientComms.sendMessage("checkIfUserExists@" + firstNameField.getText() + "@" + lastNameField.getText());
        if (clientComms.receiveMessage().getContents().toLowerCase().equals("true")) return true;
        else return false;
    }

    //Returns true if passwords of users match
    boolean passwordIsCorrect() throws IOException {
        System.out.println("Checking if password is correct");
        clientComms.sendMessage("verifyPassword@" + firstNameField.getText() + "@" + lastNameField.getText() + "@" + passwordField.getText());
        if (clientComms.receiveMessage().getContents().toLowerCase().equals("true")) return true;
        else return false;
    }

    //Creates a new user
    void createNewUser() {
        clientComms.sendMessage("createUser@" + firstNameField.getText() + "@" + lastNameField.getText() + "@" + passwordField.getText());
    }
}

class LogInListener extends RegisterLoginListener implements ActionListener {

    LogInListener(JFrame jframe, ClientComms clientComms, JTextField firstNameField, JTextField lastNameField, JPasswordField passwordField) {
        super(jframe, clientComms, firstNameField, lastNameField, passwordField);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (validate()) {
            try {
                if (logInUserExists() && passwordIsCorrect()) {
                    AuctionGUI auctionGUI = new AuctionGUI(clientComms);
                    jframe.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Log in details incorrect!");
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class RegisterListener extends RegisterLoginListener implements ActionListener {

    RegisterListener(JFrame jframe, ClientComms clientComms, JTextField firstNameField, JTextField lastNameField, JPasswordField passwordField) {
        super(jframe, clientComms, firstNameField, lastNameField, passwordField);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (validate()) {
            try {
                if (!logInUserExists()) {
                    createNewUser();

                    //Inputs have been validated and user name doesn't already exist
                    AuctionGUI auctionGUI = new AuctionGUI(clientComms);
                    jframe.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "These user details already exist!");
                }
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }
}