import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ferma implements ActionListener {

    private static JPanel panel;
    private static JFrame frame;
    private static JLabel utilizator;
    private static JLabel parola;
    private static JTextField intUtil;
    private static JPasswordField intPass;
    private static JButton login;
    private static JLabel titlu;
    private static JLabel succes;

    public static void main(String[] args) {

        panel = new JPanel();

        frame = new JFrame();

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.ORANGE);

        frame.add(panel);
        panel.setLayout(null);

        titlu = new JLabel("Bun venit in aplicatia de gestionare a firmei NORD SRL");
        titlu.setFont(new Font("Georgia", Font.BOLD, 15) );
        titlu.setBounds(10, 10, 500, 25);
        panel.add(titlu);

        utilizator = new JLabel("Utilizator");
        utilizator.setBounds(10, 40, 80, 25);
        utilizator.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(utilizator);

        parola = new JLabel("Parola");
        parola.setBounds(10, 80, 80, 25);
        parola.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(parola);

        intUtil = new JTextField();
        intUtil.setBounds(100, 40, 80, 25);
        panel.add(intUtil);

        intPass = new JPasswordField();
        intPass.setBounds(100, 80, 80, 25);
        panel.add(intPass);

        login = new JButton("Login");
        login.setBounds(10, 120, 80,50);
        panel.add(login);
        login.addActionListener(new Ferma());

        succes = new JLabel("");
        succes.setBounds(170,200, 500,80);
        panel.add(succes);


        frame.setVisible(true);


        Angajat ingrijitor = new Ingrijitor("Ion", "ingrijitor");
    System.out.println("Autoritatea este " + ingrijitor.getAutoritate());


    }

    @Override
    public void actionPerformed(ActionEvent e) {
   String util = intUtil.getText();
   String pass = intPass.getText();
        if(util.equalsIgnoreCase("Ingrijitor") && pass.equals("ingrijitor123")){
            utilizator.setVisible(false);
            parola.setVisible(false);
            intUtil.setVisible(false);
            intPass.setVisible(false);
            login.setVisible(false);
            titlu.setText("Bun venit, " + util + "!");
        } else {
            succes.setText("Datele de autentificare sunt gresite.");
        }

    }
}