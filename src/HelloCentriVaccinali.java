import javax.swing.*;
import java.awt.event.*;

public class HelloCentriVaccinali {
    private JPanel panel1;
    private JButton btnOperatore;
    private JButton btnCittadino;

    public HelloCentriVaccinali() {
        btnOperatore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "premuto Operatore");
            }
        });
        btnCittadino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "premuto Cittadino");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HelloCentriVaccinali");
        frame.setContentPane(new HelloCentriVaccinali().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
