package fr.parshimipopeli.SwingJava;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class MyWindowFlowLayout extends JFrame {

    public MyWindowFlowLayout() {
        super("My first Swing application !");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
        //                                   pour placer    , mettre des marges  horizontale et verticales entre les élements


//        contentPane.add(new JButton("pushMe!"));
//        contentPane.add(new JButton("clickMe!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"));
//        contentPane.add(new JCheckBox("CheckMe!"));
//        contentPane.add(new JTextField("EditMe!"));

        //idem

       JButton btnPushMe = new JButton("push me !");
       contentPane.add(btnPushMe);

       JButton btnClickMe = new JButton("click me !!!");
       contentPane.add(btnClickMe);

       JCheckBox chkCheckMe = new JCheckBox("check me :");
       contentPane.add(chkCheckMe);

       JTextField txtEditMe = new JTextField(("edit me !"));
       txtEditMe.setPreferredSize(new Dimension(120, 50));//redimentionnement d'un élement
       contentPane.add(txtEditMe);

       JMenuBar menuBar = new JMenuBar();

    }

    public static void main(String[] args) throws Exception {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        MyWindowFlowLayout myWindow = new MyWindowFlowLayout();
        myWindow.setVisible(true);
    }
}