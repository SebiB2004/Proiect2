import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FermaUI implements ActionListener {

    private static JPanel panel;
    private static JFrame frame;
    private static JLabel utilizator;
    private static JLabel parola;
    private static JTextField intUtil;
    private static JPasswordField intPass;
    private static JButton login;
    private static JLabel titlu;
    private static JLabel succes;
    private static JPanel panelLogin;

    public FermaUI(){
        initalizareUI();
    }



    public void initalizareUI (){

        panel = new JPanel();

        frame = new JFrame();

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.ORANGE);

        frame.add(panel);
        panel.setLayout(null);

        panelLogin = new JPanel();
        panelLogin.setBounds(10, 40, 400, 200);
        panelLogin.setLayout(new GridLayout(3, 2, 10, 10));
        panel.add(panelLogin);

        titlu = new JLabel("Bun venit in aplicatia de gestionare a firmei NORD SRL");
        titlu.setFont(new Font("Georgia", Font.BOLD, 15) );
        titlu.setBounds(10, 10, 500, 25);
        panel.add(titlu);


        utilizator = new JLabel("Utilizator");
        utilizator.setFont(new Font("Arial", Font.BOLD, 15));
        panelLogin.add(utilizator);

        parola = new JLabel("Parola");
        parola.setFont(new Font("Arial", Font.BOLD, 15));
        panelLogin.add(parola);

        intUtil = new JTextField();
        panelLogin.add(intUtil);

        intPass = new JPasswordField();
        panelLogin.add(intPass);

        login = new JButton("Login");
        panelLogin.add(login);
        login.addActionListener(this);

        succes = new JLabel("");
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
   String util = intUtil.getText();
   String pass = intPass.getText();
        if(util.equalsIgnoreCase("Ingrijitor") && pass.equals("ingrijitor123")){
            panelLogin.setVisible(false);
            titlu.setText("Bun venit, " + util + "!");
        } else {
            succes.setText("Datele de autentificare sunt gresite.");
        }

    }
    public static void instantiereAngajat(){

    }
}