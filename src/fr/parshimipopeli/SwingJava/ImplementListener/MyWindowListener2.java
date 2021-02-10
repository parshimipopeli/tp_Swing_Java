package fr.parshimipopeli.SwingJava.ImplementListener;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindowListener2 extends JFrame  {

    private JButton btnPushMe = new JButton("push me !");
    private JButton btnClickMe = new JButton("Click me !!!");


    public MyWindowListener2() {
        super("My first Swing application !");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
        //                                   pour placer    , mettre des marges  horizontale et verticales entre les élements

        btnPushMe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPushListener(e);
            }
        });
        contentPane.add(btnPushMe);

        btnClickMe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBtnClickMeListener(e);
            }
        });
        contentPane.add(btnClickMe);

        JCheckBox chkCheckMe = new JCheckBox("check me :");
        contentPane.add(chkCheckMe);

        JTextField txtEditMe = new JTextField(("edit me !"));
        txtEditMe.setPreferredSize(new Dimension(120, 50));//redimentionnement d'un élement
        contentPane.add(txtEditMe);

        JMenuBar menuBar = new JMenuBar();

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

        }

    public static void main(String[] args) throws Exception {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        MyWindowListener2 myWindow = new MyWindowListener2();
        myWindow.setVisible(true);
    }


}