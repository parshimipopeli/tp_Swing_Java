package fr.parshimipopeli.SwingJava;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MenuBarSample extends JFrame {

    //constructeur de l'interface graphique
    public MenuBarSample() {
        super("JMenuBar sample");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //construction et injection de la barre de menu
        this.setJMenuBar(createMenuBar());
    }

    //methode de construction de la barre de menu
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("file");
        menuFile.setMnemonic('F');//pour ajouter un racourcis avec premiere lettre du menu souligné à ouvrir avec touche alt + premiere lettre du menu

        JMenuItem menuNew = new JMenuItem("newFile");
        menuNew.addActionListener(this::menuNewLister);
        menuFile.add(menuNew);
        menuFile.addSeparator();

        JMenu menuMenu = new JMenu("menu");
        menuFile.add(menuMenu);
        JMenuItem menu1 = new JMenuItem("menu-A");
        menu1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));//mettre un  accélerateur, racourci clavier pour ouvrir le JMenuItem

        menuMenu.add(menu1);
        JMenuItem menu2 = new JMenuItem("menu-B");
        menu2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_DOWN_MASK));//mettre un  accélerateur, racourci clavier pour ouvrir le JMenuItem

        menuMenu.add(menu2);

        JMenu menuTest = new JMenu(("test"));
        menuTest.setMnemonic('T');


        menuBar.add(menuFile);
        menuBar.add(menuTest);
        return menuBar;
    }

    //methode permettant de faire ouvrir une boite de dialogue
    private void menuNewLister(ActionEvent event) {
        JOptionPane.showMessageDialog(this, "new document required");
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        MenuBarSample window = new MenuBarSample();
        window.setVisible(true);
    }
}
