package fr.parshimipopeli.SwingJava.ImplementListener;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyWindowListener4 extends JFrame  {

    private JButton btnPushMe = new JButton("push me !");
    private JButton btnClickMe = new JButton("Click me !!!");
    private JButton btnChangeAllButon = new JButton("CHANGEZ LA COULEUR DES AUTRES BOUTONS");

    public MyWindowListener4() {
        super("My first Swing application !");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 20));
        //                                   pour placer    , mettre des marges  horizontale et verticales entre les élements

        btnPushMe.addActionListener(this::btnPushListener);
        contentPane.add(btnPushMe);

        btnClickMe.addActionListener(this::setBtnClickMeListener);
        contentPane.add(btnClickMe);
        btnClickMe.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnClickMe.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnClickMe.setForeground(Color.BLACK);
            }
        });

        btnChangeAllButon.addActionListener(this::changerCouleur);
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
        MyWindowListener4 myWindow = new MyWindowListener4();
        myWindow.setVisible(true);
    }


}