package fr.parshimipopeli.SwingJava.ImplementListener;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindowListener1 extends JFrame implements ActionListener {

    private JButton btnPushMe = new JButton("push me !");
    private JButton btnClickMe = new JButton("Click me !!!");


    public MyWindowListener1() {
        super("My first Swing application !");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
        //                                   pour placer    , mettre des marges  horizontale et verticales entre les élements

        btnPushMe.addActionListener(this);
        contentPane.add(btnPushMe);

        btnClickMe.addActionListener(this);
        contentPane.add(btnClickMe);

        JCheckBox chkCheckMe = new JCheckBox("check me :");
        contentPane.add(chkCheckMe);

        JTextField txtEditMe = new JTextField(("edit me !"));
        txtEditMe.setPreferredSize(new Dimension(120, 50));//redimentionnement d'un élement
        contentPane.add(txtEditMe);

        JMenuBar menuBar = new JMenuBar();

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (((JButton) event.getSource() == btnClickMe)) {
//            System.out.println("bouton btnClick me cliqué !");
            btnClickMe.setBackground(Color.red);//change la couleur du bouton
        } else {
//            System.out.println("autre bouton cliqué !!");
            btnPushMe.setForeground(Color.BLUE);//change la couleur du texte
            btnPushMe.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));//change la bordure du boutton

        }
    }

    public static void main(String[] args) throws Exception {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        MyWindowListener1 myWindow = new MyWindowListener1();
        myWindow.setVisible(true);
    }


}