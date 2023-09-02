import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancellationModule extends JFrame {
    private JTextField pnrField;
    private JButton cancelButton;

    public CancellationModule() {
        setTitle("Cancellation Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        pnrField = new JTextField(15);
        cancelButton = new JButton("Cancel Reservation");

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pnrNumber = pnrField.getText();

                // Retrieve reservation details using the provided PNR number
                // Display reservation information and confirm cancellation
                if (isValidPNR(pnrNumber)) {
                    String reservationInfo = retrieveReservationInfo(pnrNumber);
                    int option = JOptionPane.showConfirmDialog(
                            CancellationModule.this,
                            "Do you want to cancel this reservation?\n" + reservationInfo,
                            "Confirm Cancellation",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (option == JOptionPane.YES_OPTION) {
                        performCancellation(pnrNumber);
                    }
                } else {
                    JOptionPane.showMessageDialog(
                            CancellationModule.this,
                            "Invalid PNR number. Please provide a valid PNR."
                    );
                }
            }
        });

        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("PNR Number:"));
        panel.add(pnrField);
        panel.add(cancelButton);

        add(panel);
        setVisible(true);
    }

    private boolean isValidPNR(String pnrNumber) {
        // Validate against existing reservations
        // For this example, assume any non-empty PNR is valid
        return !pnrNumber.isEmpty();
    }

    private String retrieveReservationInfo(String pnrNumber) {
        // Retrieve reservation details from the central database
        // For this example, return a placeholder message
        return "Sample Reservation Information";
    }

    private void performCancellation(String pnrNumber) {
        // Perform cancellation and update the central database
        // Display cancellation confirmation
        JOptionPane.showMessageDialog(this, "Reservation with PNR " + pnrNumber + " has been canceled.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CancellationModule::new);
    }
}
