package screenForms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameAndPay {

    private static String name = "";
    private static double pay = 0.00;
    private JButton mcNextButton;
    private JTextField nameField;
    private JTextField payField;
    private JPanel mainPanel;
    private JButton nameSubmit;
    private JButton paySubmit;
    private JLabel nameLabel;
    private JLabel payLabel;

    public NameAndPay() {
        nameSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String newName = nameField.getText();
                nameField.setText("");

                if (!newName.isEmpty() && newName.length() <= 20) {
                    setName(newName);
                } else {
                    errorMessage("Invalid Name", "Name must not be empty, and must be 20 characters or less.");
                }

                updateLabels();
            }
        });
        paySubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String stringPay = payField.getText();
                payField.setText("");

                try {
                    double newPay = Double.parseDouble(stringPay);

                    if (newPay > 0) {
                        setPay(newPay);
                    } else {
                        errorMessage("Invalid Pay", "Pay must be a number greater than 0.00.");
                    }
                } catch (Exception e) {
                    errorMessage("Invalid Pay", "Pay must be a number greater than 0.00.");
                }

                updateLabels();
            }
        });
    }

    private void errorMessage(String subject, String explanation) {
        JOptionPane.showMessageDialog(mainPanel, explanation, subject, JOptionPane.ERROR_MESSAGE);
    }
    private void updateLabels() {

        if (!name.isEmpty()) {
            nameLabel.setText("Name: " + name);
        } else {
            nameLabel.setText("Name: NONE");
        }

        if (pay > 0) {
            payLabel.setText(String.format("Pay: %.2f", pay));
        } else {
            payLabel.setText("Pay: NONE");
        }
    }

    public JPanel getMainPanel(String name, double pay) {

        setName(name);
        setPay(pay);

       updateLabels();

        return mainPanel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

}
