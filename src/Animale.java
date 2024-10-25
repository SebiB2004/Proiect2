import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animale extends StocHrana{

    JButton porcJPG;
    JButton calJPG;
    JButton vacaJPG;

    public Animale() {

        ImageIcon porc = new ImageIcon("/home/sebi_programatorul/Desktop/Proiect2/Proiect2/Baby_Pig.png");
        porcJPG = new JButton(porc);
        porcJPG.setBounds(285, 70, 230, 230);
        porcJPG.setContentAreaFilled(false);
        porcJPG.setOpaque(false);
        porcJPG.setBorderPainted(false);
        porcJPG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String produs = JOptionPane.showInputDialog(null, "Cu ce produs doresti sa hranesti porcul?", "Intrebare", JOptionPane.QUESTION_MESSAGE);
                String cantitate = JOptionPane.showInputDialog(null, "Ce cantitate doresti sa oferi porcului?", "Intrebare", JOptionPane.QUESTION_MESSAGE);
                if(scadeCantitate(produs, Integer.parseInt(cantitate))){
                    scadeCantitate(produs, Integer.parseInt(cantitate));

                }
            }
        });

        ImageIcon cal = new ImageIcon("/home/sebi_programatorul/Desktop/Proiect2/Proiect2/638607217752048766.png");
        calJPG = new JButton(cal);
        calJPG.setBounds(285, 300, 230, 230);
        calJPG.setContentAreaFilled(false);
        calJPG.setOpaque(false);
        calJPG.setBorderPainted(false);

        ImageIcon vaca = new ImageIcon("/home/sebi_programatorul/Desktop/Proiect2/Proiect2/637577398224101135.png");
        vacaJPG = new JButton(vaca);
        vacaJPG.setBounds(285, 500, 230, 230);
        vacaJPG.setContentAreaFilled(false);
        vacaJPG.setOpaque(false);
        vacaJPG.setBorderPainted(false);
    }

    public JButton getPorc(){
        return this.porcJPG;
    }
    public JButton getCalJPG(){
        return this.calJPG;
    }
    public JButton getVacaJPG(){
        return this.vacaJPG;
    }
}
