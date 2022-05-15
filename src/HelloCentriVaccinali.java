import javax.swing.*;

public class HelloCentriVaccinali extends JFrame{
    private JPanel mainPanel;
    private JButton btnCittadino;
    private JButton btnOperatore;

    public HelloCentriVaccinali(){
        setContentPane(mainPanel);
        setTitle("Centri Vaccinali");
        setSize(420,420);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        HelloCentriVaccinali frame = new HelloCentriVaccinali();
    }

}
