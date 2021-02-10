package fr.parshimipopeli.SwingJava.ImplementListener;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindowListener3 extends JFrame  {

    private JButton btnPushMe = new JButton("push me !");
    private JButton btnClickMe = new JButton("Click me !!!");
    private JButton btnChangeAllButon = new JButton("CHANGEZ LA COULEUR DES AUTRES BOUTONS");

    public MyWindowListener3() {
        super("My first Swing application !");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 20));
        //                                   pour placer    , mettre des marges  horizontale et verticales entre les élements

        btnPushMe.addActionListener((event) -> btnPushListener(event));
        contentPane.add(btnPushMe);

        btnClickMe.addActionListener((event) -> setBtnClickMeListener(event));
        contentPane.add(btnClickMe);

        btnChangeAllButon.addActionListener((event) -> changerCouleur(event));
        contentPane.add(btnChangeAllButon);

        JCheckBox chkCheckMe = new JCheckBox("check me :");
        contentPane.add(chkCheckMe);

        JTextField txtEditMe = new JTextField(("edit me !"));
        txtEditMe.setPreferredSize(new Dimension(120, 50));//redimentionnement d'un élement
        contentPane.add(txtEditMe);
    }

        private void changerCouleur(ActionEvent event) {
        btnClickMe.setBackground(Color.RED);
        btnPushMe.setBackground(Color.orange);
        }

        private void btnPushListener(ActionEvent event) {
            btnClickMe.setText("Bin et moi je suis pas cliqué!!!!");//changer le texte d un objet avec les classes anonyme ont a acces aux autres attributs
            btnPushMe.setForeground(Color.CYAN);
            btnPushMe.setBackground(Color.BLACK);
        }

        private void setBtnClickMeListener(ActionEvent event) {
            System.out.println("bouton clickMe cliqué");
            btnClickMe.setBackground(Color.GREEN);
            btnPushMe.setBackground(Color.MAGENTA);
            getContentPane().setBackground(Color.CYAN);//changer la fenettre de la fenetre principale

        }

    public static void main(String[] args) throws Exception {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        MyWindowListener3 myWindow = new MyWindowListener3();
        myWindow.setVisible(true);
    }


}