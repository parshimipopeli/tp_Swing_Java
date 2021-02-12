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

        JMenu ListMenu = new JMenu("Menus");
        ListMenu.setMnemonic('M');//pour ajouter un racourcis avec premiere lettre du menu souligné à ouvrir avec touche alt + premiere lettre du menu

        JMenu WinterMenu = new JMenu("Winter Menu");
        WinterMenu.setMnemonic('W');
//        WinterMenu.addActionListener(this::menuNewLister);
        WinterMenu.setIcon(new ImageIcon("icons/img.png"));//ajouter une icone au JMenuItem
        ListMenu.add(WinterMenu);
        ListMenu.addSeparator();

        JMenuItem menuWA = new JMenuItem("Menu-1");
        menuWA.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));//mettre un  accélerateur, racourci clavier pour ouvrir le JMenuItem
        WinterMenu.add(menuWA);
        JMenuItem menuWB = new JMenuItem("Menu-2");
        menuWB.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_DOWN_MASK));
        WinterMenu.add(menuWB);
        JMenuItem menuC = new JMenuItem("Menu-3");
        menuC.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        WinterMenu.add(menuC);
        JMenuItem menuWD = new JMenuItem("Menu-4");
        menuWD.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
        WinterMenu.add(menuWD);

        JMenu SpringMenu = new JMenu("SpringMenu");
        SpringMenu.setMnemonic('S');
        ListMenu.add(SpringMenu);
        JMenuItem menuSA = new JMenuItem("menu-A");
        menuSA.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
        SpringMenu.add(menuSA);
        JMenuItem menuSB = new JMenuItem("menu-B");
        menuSB.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_DOWN_MASK));
        SpringMenu.add(menuSB);
        JMenuItem mesuSC = new JMenuItem("Menu-C");
        menuC.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK ));
        SpringMenu.add(menuC);



        JMenu Coktails = new JMenu(("Coktails"));
        Coktails.setMnemonic('C');
        JMenu Rhum = new JMenu("Rhum");
        Rhum.setMnemonic('R');
        Coktails.add(Rhum);

        JMenuItem Mojito = new JMenuItem("Mojito");
        Mojito.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.CTRL_DOWN_MASK));
        Rhum.add(Mojito);


        menuBar.add(ListMenu);
        menuBar.add(Coktails);
        return menuBar;
    }

    //methode permettant de faire ouvrir une boite de dialogue
//    private void menuNewLister(ActionEvent event) {
//        JOptionPane.showMessageDialog(this, "new document required");
//    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        MenuBarSample window = new MenuBarSample();
        window.setVisible(true);
    }
}
