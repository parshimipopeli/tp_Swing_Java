package fr.parshimipopeli.SwingJava;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class MyWindowBorderLayout extends JFrame {

    public MyWindowBorderLayout() {
        super("My first Swing application !");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new BorderLayout());



       JButton btnPushMe = new JButton("push me !");
       contentPane.add(btnPushMe, BorderLayout.NORTH);

       JButton btnClickMe = new JButton("click me !!!");
       btnClickMe.setPreferredSize(new Dimension(350, 0));
       contentPane.add(btnClickMe, BorderLayout.WEST);

       JCheckBox chkCheckMe = new JCheckBox("check me :");
       contentPane.add(chkCheckMe, BorderLayout.SOUTH);

       JTextField txtEditMe = new JTextField(("edit me !"));
       contentPane.add(txtEditMe, BorderLayout.CENTER);

       JMenuBar menuBar = new JMenuBar();

    }


    public static void main(String[] args) throws Exception {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        MyWindowBorderLayout myWindow = new MyWindowBorderLayout();
        myWindow.setVisible(true);
    }
}