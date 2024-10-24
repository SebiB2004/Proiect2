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
        private static JPanel panelLogin;
        public static Angajat angajat;
        private JButton ListAngajati;
        private DefaultListModel<String> Lista;
        private static JList <String> listaAng;

        public FermaUI() {

            initalizareUI();
        }

        public void initalizareUI() {

            panel = new JPanel();

            frame = new JFrame();

            frame.setSize(500, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panel.setBackground(Color.ORANGE);

            frame.add(panel);
            panel.setLayout(null);

            panelLogin = new JPanel();
            panelLogin.setBounds(50, 100, 400, 200);
            panelLogin.setLayout(null);
            panel.add(panelLogin);

            titlu = new JLabel("Bun venit in aplicatia de gestionare a firmei NORD SRL");
            titlu.setFont(new Font("Georgia", Font.BOLD, 15));
            titlu.setBounds(10, 10, 500, 25);
            panel.add(titlu);


            utilizator = new JLabel("Utilizator");
            utilizator.setFont(new Font("Arial", Font.BOLD, 15));
            utilizator.setBounds(90, 30, 100, 25);
            panelLogin.add(utilizator);

            parola = new JLabel("Parola");
            parola.setFont(new Font("Arial", Font.BOLD, 15));
            parola.setBounds(90, 80, 100, 25);
            panelLogin.add(parola);

            intUtil = new JTextField();
            intUtil.setBounds(200, 30, 100, 25);
            panelLogin.add(intUtil);

            intPass = new JPasswordField();
            intPass.setBounds(200, 80, 100, 25);
            panelLogin.add(intPass);

            login = new JButton("Login");
            login.setBounds(90, 120, 200, 50);
            panelLogin.add(login);
            login.addActionListener(this);

            frame.setVisible(true);


        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String util = intUtil.getText();
            String pass = intPass.getText();

            if (util.equalsIgnoreCase("Ingrijitor") && pass.equals("ingrijitor123")) {
                    panelLogin.setVisible(false);
                    angajat = new Ingrijitor("Ionel", "ingrijitor");
                    titlu.setText("Bun venit, " + angajat.getNume() + "!");
                    titlu.setBounds(170, 200, 500, 25);
                    TimerHide();
                }

                if (util.equalsIgnoreCase("Manager") && pass.equals("manager123")) {
                    panelLogin.setVisible(false);
                    angajat = new Manager("Marian", "Manager");
                    titlu.setBounds(170, 200, 500, 25);
                    titlu.setText("Bun venit, " + angajat.getNume() + "!");
                    TimerHide();
                } else {
                    JLabel eroare = new JLabel("Datele de logare sunt gresite");
                    eroare.setBounds(70, 170, 250, 30);
                    eroare.setFont(new Font("Arial", Font.BOLD, 15));
                    eroare.setForeground(Color.RED);
                    panelLogin.add(eroare);
                    panelLogin.revalidate();
                    panelLogin.repaint();

                }
            }



        public void TimerHide() {
            Timer timer = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    titlu.setText("");
                    SecondPanel();
                }
            });
            timer.setRepeats(false);
            timer.start();

        }

        public void SecondPanel() {

            titlu.setBounds(10, 10, 500, 25);
            titlu.setText("Functie: " + intUtil.getText());
            JLabel autoritate = new JLabel("Autoritatea ta: " + angajat.getAutoritate());
            autoritate.setFont(new Font("Georgia", Font.BOLD, 15));
            autoritate.setBounds(290, 10, 210, 25);
            panel.add(autoritate);
            panel.revalidate();
            panel.repaint();
            JPanel panelButon = new JPanel();

            panelButon.setLayout(new BoxLayout(panelButon, BoxLayout.Y_AXIS));
            panelButon.setAlignmentX(Component.CENTER_ALIGNMENT);
            panelButon.add(Box.createVerticalGlue());
            panelButon.setBackground(Color.darkGray);

                ListAngajati = new JButton("Lista angajatilor");
                ListAngajati.setAlignmentX(Component.CENTER_ALIGNMENT);
                ListAngajati.setForeground(Color.ORANGE);
                ListAngajati.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.ORANGE, 2),
                        BorderFactory.createEmptyBorder(10, 20, 10, 20)
                ));
                ListAngajati.setContentAreaFilled(false);
                panelButon.add(Box.createRigidArea(new Dimension(0, 10)));
                panelButon.add(ListAngajati);

            ListAngajati.addActionListener(new ActionListener() {
                private int numarAngajati = 4;
                private int inaltimeCelula = 30;
                @Override
                public void actionPerformed(ActionEvent e) {
                    Lista = new DefaultListModel<>();
                    Lista.addElement("George - Patron");
                    Lista.addElement("Marian - Contabil");
                    Lista.addElement("Mihai - Manager");
                    Lista.addElement("Ionel - Ingrijitor");

                    listaAng = new JList<>(Lista);
                    listaAng.setVisibleRowCount(numarAngajati);
                    listaAng.setFixedCellHeight(inaltimeCelula);
                    panel.add(listaAng);


                    if(angajat.getAutoritate().equalsIgnoreCase("medium") || angajat.getAutoritate().equalsIgnoreCase("High")) {
                        JButton adaugaAngajat = new JButton("Adauga un angajat nou");
                        adaugaAngajat.setBounds(290, 170, 200, 50);
                        adaugaAngajat.setBackground(Color.ORANGE);
                        listaAng.setBounds(80, 150, 200, 120);
                        panel.add(adaugaAngajat);

                        adaugaAngajat.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String raspuns = JOptionPane.showInputDialog(null, "Scrie numele si functia noului angajat","Intrebare", JOptionPane.QUESTION_MESSAGE);{
                                    Lista.addElement(raspuns);
                                    numarAngajati++;
                                    listaAng.setVisibleRowCount(numarAngajati);
                                    listaAng.setBounds(80,150, 200, numarAngajati * inaltimeCelula);
                                }
                            }
                        });
                    }
                    else {

                        listaAng.setBounds(135, 150, 200, 120);
                    }



                    panelButon.setVisible(false);
                    panel.add(listaAng);
                    panel.revalidate();
                    panel.repaint();
                }
            });

            String data[][]={{"Hrana uscata", "100kg", "50lei"},
                    {"Graunte," ,"700kg", "30lei"}
            };
            String coloana[] = {"Denumire", "Cantitate in stoc", "Pret/kg"};
            JTable tabelStoc = new JTable(data, coloana);
            tabelStoc.setBounds(100, 235, 300, 200);

            JButton StocHrana = new JButton("Stoc Hrana");
            StocHrana.setAlignmentX(Component.CENTER_ALIGNMENT);
            StocHrana.setForeground(Color.ORANGE);
            StocHrana.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.ORANGE, 2),
                    BorderFactory.createEmptyBorder(10, 20, 10, 20)
            ));

            StocHrana.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panelButon.setVisible(false);
                    panel.add(tabelStoc);
                }
            });
            StocHrana.setContentAreaFilled(false);
            panelButon.add(Box.createRigidArea(new Dimension(0, 10)));
            panelButon.add(StocHrana);

            JButton Grajduri = new JButton("Grajduri");
            Grajduri.setAlignmentX(Component.CENTER_ALIGNMENT);
            Grajduri.setForeground(Color.ORANGE);
            Grajduri.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.ORANGE, 2),
                    BorderFactory.createEmptyBorder(10, 20, 10, 20)
            ));


            Grajduri.setContentAreaFilled(false);
            panelButon.add(Box.createRigidArea(new Dimension(0, 10)));
            panelButon.add(Grajduri);

            JButton Salariu = new JButton("Salariile mele");
            Salariu.setAlignmentX(Component.CENTER_ALIGNMENT);
            Salariu.setForeground(Color.ORANGE);
            Salariu.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.ORANGE, 2),
                    BorderFactory.createEmptyBorder(10, 20, 10, 20)
            ));
            Salariu.setContentAreaFilled(false);
            panelButon.add(Box.createRigidArea(new Dimension(0, 10)));
            panelButon.add(Salariu);

            JButton Parteneri = new JButton("Parteneri");
            Parteneri.setAlignmentX(Component.CENTER_ALIGNMENT);
            Parteneri.setForeground(Color.ORANGE);
            Parteneri.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.ORANGE, 2),
                    BorderFactory.createEmptyBorder(10, 20, 10, 20)
            ));
            Parteneri.setContentAreaFilled(false);
            panelButon.add(Box.createRigidArea(new Dimension(0, 10)));
            panelButon.add(Parteneri);

            panelButon.add(Box.createVerticalGlue());
            panelButon.setBounds(125, 125, 250, 250);
            panel.add(panelButon);
            panel.revalidate();
            panel.repaint();


        }

    }

