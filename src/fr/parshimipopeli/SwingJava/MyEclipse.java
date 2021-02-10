package fr.parshimipopeli.SwingJava;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyEclipse extends JFrame {

    public MyEclipse() {
        super("My first Swing application !");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new BorderLayout());

       contentPane.add(createToolbar(), BorderLayout.NORTH);

       JScrollPane westComponent = new JScrollPane(new JTree());//JTree pour créer une arborescence
        westComponent.setPreferredSize(new Dimension(200, 30));
        contentPane.add(westComponent, BorderLayout.WEST);

       contentPane.add(createStatusBar(), BorderLayout.SOUTH);

       contentPane.add(createRightPanel(), BorderLayout.EAST);

       JTextField txtContent = new JTextField(("The content of this editor"));
       JScrollPane scrContent = new JScrollPane(txtContent);
       contentPane.add(scrContent);


    }


    private JToolBar createToolbar() {
        JToolBar toolBar = new JToolBar();

        JButton btnPushMe = new JButton("Push me !");
        toolBar.add(btnPushMe);
        JButton btnClickMe = new JButton("click me !!!");
        toolBar.add(btnClickMe);

        JCheckBox chkCheckMe = new JCheckBox("check me :");
        toolBar.add(chkCheckMe);

        JTextField txtEditMe = new JTextField(("edit me !"));
        txtEditMe.setPreferredSize(new Dimension(300, 30));
        toolBar.add(txtEditMe);
        return toolBar;
    }

    private JPanel createStatusBar() {
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel lblStaus1 = new JLabel("message 1");
        lblStaus1.setPreferredSize(new Dimension(100, 30));
        statusBar.add(lblStaus1);

        JLabel lblStatus2 = new JLabel("message 2");
        lblStatus2.setPreferredSize(new Dimension(100, 30));
        statusBar.add(lblStatus2);

        JLabel lblStatus3 = new JLabel("message 3");
        lblStatus3.setPreferredSize(new Dimension(100, 30));
        statusBar.add(lblStatus3);

        return statusBar;

    }


    private JPanel createRightPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(new JButton("Button 1"));
        panel.add(new JButton("Boutton 2"));
        panel.add(new JButton("Boutton 3"));
        panel.add(new JButton("button 4"));

        return panel;

    }



    public static void main(String[] args) throws Exception {
        // Apply a look'n feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        // Start my window
        MyEclipse myWindow = new MyEclipse();
        myWindow.setVisible(true);
    }
}