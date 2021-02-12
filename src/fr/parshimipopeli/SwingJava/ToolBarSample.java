package fr.parshimipopeli.SwingJava;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ToolBarSample extends JFrame {

    public ToolBarSample() {
        super("JtoolBar Sample");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Construction et injection de la barre d'outils
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.add(createToolBar(), BorderLayout.NORTH);
    }

    //Methode de construction de la barre d'outils
    private  JToolBar createToolBar() {

        JToolBar toolBar = new JToolBar();

        JButton btnNew = new JButton(new ImageIcon("icons/new.png"));
        btnNew.addActionListener(this::btnListener);
        btnNew.setToolTipText("New File (CTRL+N");
        toolBar.add(btnNew);

        JButton btnSave = new JButton(new ImageIcon("icons/save.png"));
        btnSave.addActionListener(this::btnListener);
        btnSave.setToolTipText("Save file (CTRL+S");
        toolBar.add(btnSave);

        JButton btnCopy = new JButton(new ImageIcon("icons/copy.png"));
        btnCopy.setToolTipText("Copy file (CTRL+C");
        toolBar.add(btnCopy);

        JButton btnCut = new JButton(new ImageIcon("icons/cut.png"));
        btnCut.setToolTipText("Cut file (CTRL+W");
        toolBar.add(btnCut);

        JButton btnExit = new JButton(new ImageIcon("icons/exit.png"));
        btnExit.setToolTipText("Exit (CTRL+E)");
        toolBar.add(btnExit);

        return toolBar;
    }

    private void btnListener(ActionEvent event) {
        JOptionPane.showMessageDialog(this, "new document is required");
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        ToolBarSample window = new ToolBarSample();
        window.setVisible(true);
    }
}
