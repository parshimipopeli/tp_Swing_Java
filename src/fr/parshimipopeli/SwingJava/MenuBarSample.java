package fr.parshimipopeli.SwingJava;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

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

        JMenuItem menuNew = new JMenuItem("newFile");
        menuFile.add(menuNew);
        JMenuItem menu2 = new JMenuItem("menu2");
        menuFile.add(menu2);



        JMenu menuTest = new JMenu(("test"));

        menuBar.add(menuFile);
        menuBar.add(menuTest);
        return menuBar;
    }


    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        MenuBarSample window = new MenuBarSample();
        window.setVisible(true);
    }
}
