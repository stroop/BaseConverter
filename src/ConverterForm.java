import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jacob Stroop on 9/7/2015.
 */
public class ConverterForm {


    private JPanel containerPanel;
    private JButton convertBtn;
    private JTextField input;
    private JRadioButton decimalRadioButton;
    private JRadioButton binaryRadioButton;
    private JRadioButton hexadecimalRadioButton;
    private JLabel mainLabel;
    private JLabel promptLabel;
    private JPanel topPanel;
    private JPanel lowerPanel;
    private JPanel middlePanel;
    private JLabel decLabel;
    private JLabel binLabel;
    private JLabel hexLabel;

    public ConverterForm() {
        convertBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (binaryRadioButton.isSelected()) {

                    BinaryConverter binCon = new BinaryConverter(input.getText());

                    if (!binCon.isValidTarget()) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid binary number");
                    }
                    else {
                        decLabel.setText(binCon.getDecimalEquivalent());
                        binLabel.setText(binCon.getTarget());
                        hexLabel.setText(binCon.getHexEquivalent());
                    }
                }
                else if (decimalRadioButton.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Binary Radio Button Works");
                }
                else if (hexadecimalRadioButton.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Hex Radio Button Works");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please select a conversion type");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Converter");
        frame.setContentPane(new ConverterForm().containerPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
