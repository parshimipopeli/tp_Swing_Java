package fr.parshimipopeli.SwingJava;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class MyWindowGridLayout extends JFrame {

    public MyWindowGridLayout() {
        super("My first Swing application !");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new GridLayout(2, 2, 20, 20));


        //idem

       JButton btnPushMe = new JButton("push me !");
       contentPane.add(btnPushMe);

       JButton btnClickMe = new JButton("click me !!!");
       contentPane.add(btnClickMe);

       JCheckBox chkCheckMe = new JCheckBox("check me :");
       contentPane.add(chkCheckMe);

       JTextField txtEditMe = new JTextField(("edit me !"));
       txtEditMe.setPreferredSize(new Dimension(120, 50));//redimentionnement d'un élement ne marche pas sur GridLayout
       contentPane.add(txtEditMe);

       JMenuBar menuBar = new JMenuBar();

    }

    public static void main(String[] args) throws Exception {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        MyWindowGridLayout myWindow = new MyWindowGridLayout();
        myWindow.setVisible(true);
    }
}