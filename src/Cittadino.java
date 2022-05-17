import javax.swing.*;

public class Cittadino {
    public JPanel panel2;
    private JLabel label;

    public static void main(String[] args) {
            JFrame frame = new JFrame("Cittadino");;
            frame.setContentPane(new Cittadino().panel2);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(450,450);
            frame.setVisible(true);
    }
}