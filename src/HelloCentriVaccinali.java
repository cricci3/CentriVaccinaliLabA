import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloCentriVaccinali {
    private JPanel Panel1;
    private JButton btn_cittadino;
    private JButton btn_operatore;
    private JLabel label;

    public HelloCentriVaccinali() {

        btn_cittadino.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello World!");
            }
        });
        btn_operatore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello World 2!");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HelloCentriVaccinali");
        frame.setContentPane(new HelloCentriVaccinali().Panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
