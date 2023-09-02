import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginModule extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginModule() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Validate credentials and open the main system
                if (isValidUser(username, password)) {
                    openMainSystem();
                } else {
                    JOptionPane.showMessageDialog(LoginModule.this, "Invalid username or password. Please try again.");
                }
            }
        });

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }

    private boolean isValidUser(String username, String password) {
        // Validate against a user database or predefined credentials
        return username.equals("krishna") && password.equals("Krishna@123");
    }

    private void openMainSystem() {
        // Create and open the main system frame
        MainSystemModule mainSystem = new MainSystemModule();
        mainSystem.setVisible(true);
        dispose(); // Close the login frame
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginModule::new);
    }
}
