package fr.parshimipopeli.SwingJava.calculatrice;

import fr.parshimipopeli.SwingJava.ImplementListener.MyWindowListener4;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatriceWindow extends JFrame {

    private JPanel container = new JPanel();

    //Tableau stockant les éléments à afficher dans la calculatrice
    String[] tab_string = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "=", "C", "+", "-", "*", "/"};
    //Un bouton par élément à afficher
    JButton[] tab_button = new JButton[tab_string.length];

    private JLabel ecran = new JLabel();
    private Dimension dim = new Dimension(50, 40);
    private Dimension dim2 = new Dimension(50, 31);
    private double chiffre1;
    private boolean clicOperateur = false, update = false;
    private String operateur = "";
//    private JButton touch1 = new JButton("1");
//    private JButton touch2 = new JButton("2");
//    private JButton touch3 = new JButton("3");
//    private JButton touch4 = new JButton("4");
//    private JButton touch5 = new JButton("5");
//    private JButton touch6 = new JButton("6");
//    private JButton touch7 = new JButton("7");
//    private JButton touch8 = new JButton("8");
//    private JButton touch9 = new JButton("9");
//    private JButton touch0 = new JButton("0");
//    private JButton touchAdditionner = new JButton("+");
//    private JButton touchSoustraire = new JButton("-");
//    private JButton touchMultiplier = new JButton("*");
//    private JButton touchDiviser = new JButton("/");
//    private JButton touchEgal = new JButton("=");
//    private JButton touchVirgule = new JButton(",");
//    private JTextField resultat = new JTextField("");

    public CalculatriceWindow(){
        this.setSize(240, 260);
        this.setTitle("Calculette");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //On initialise le conteneur avec tous les composants
        initComposant();
        //On ajoute le conteneur
        this.setContentPane(container);
        this.setVisible(true);
    }

    private void initComposant(){
        //On définit la police d'écriture à utiliser
        Font police = new Font("Arial", Font.BOLD, 20);
        ecran = new JLabel("0");
        ecran.setFont(police);
        //On aligne les informations à droite dans le JLabel
        ecran.setHorizontalAlignment(JLabel.RIGHT);
        ecran.setPreferredSize(new Dimension(220, 20));
        JPanel operateur = new JPanel();
        operateur.setPreferredSize(new Dimension(55, 225));
        JPanel chiffre = new JPanel();
        chiffre.setPreferredSize(new Dimension(165, 225));
        JPanel panEcran = new JPanel();
        panEcran.setPreferredSize(new Dimension(220, 30));

        //On parcourt le tableau initialisé
        //afin de créer nos boutons
        for(int i = 0; i < tab_string.length; i++){
            tab_button[i] = new JButton(tab_string[i]);
            tab_button[i].setPreferredSize(dim);
            switch(i){
                //Pour chaque élément situé à la fin du tableau
                //et qui n'est pas un chiffre
                //on définit le comportement à avoir grâce à un listener
                case 11 :
                    tab_button[i].addActionListener(new EgalListener());
                    chiffre.add(tab_button[i]);
                    break;
                case 12 :
                    tab_button[i].setForeground(Color.red);
                    tab_button[i].addActionListener(new ResetListener());
                    operateur.add(tab_button[i]);
                    break;
                case 13 :
                    tab_button[i].addActionListener(new PlusListener());
                    tab_button[i].setPreferredSize(dim2);
                    operateur.add(tab_button[i]);
                    break;
                case 14 :
                    tab_button[i].addActionListener(new MoinsListener());
                    tab_button[i].setPreferredSize(dim2);
                    operateur.add(tab_button[i]);
                    break;
                case 15 :
                    tab_button[i].addActionListener(new MultiListener());
                    tab_button[i].setPreferredSize(dim2);
                    operateur.add(tab_button[i]);
                    break;
                case 16 :
                    tab_button[i].addActionListener(new DivListener());
                    tab_button[i].setPreferredSize(dim2);
                    operateur.add(tab_button[i]);
                    break;
                default :
                    //Par défaut, ce sont les premiers éléments du tableau
                    //donc des chiffres, on affecte alors le bon listener
                    chiffre.add(tab_button[i]);
                    tab_button[i].addActionListener(new ChiffreListener());
                    break;
            }
        }
        panEcran.add(ecran);
        panEcran.setBorder(BorderFactory.createLineBorder(Color.black));
        container.add(panEcran, BorderLayout.NORTH);
        container.add(chiffre, BorderLayout.CENTER);
        container.add(operateur, BorderLayout.EAST);
    }

    //Méthode permettant d'effectuer un calcul selon l'opérateur sélectionné
    private void calcul(){
        if(operateur.equals("+")){
            chiffre1 = chiffre1 +
                    Double.valueOf(ecran.getText()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }
        if(operateur.equals("-")){
            chiffre1 = chiffre1 -
                    Double.valueOf(ecran.getText()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }
        if(operateur.equals("*")){
            chiffre1 = chiffre1 *
                    Double.valueOf(ecran.getText()).doubleValue();
            ecran.setText(String.valueOf(chiffre1));
        }
        if(operateur.equals("/")){
            try{
                chiffre1 = chiffre1 /
                        Double.valueOf(ecran.getText()).doubleValue();
                ecran.setText(String.valueOf(chiffre1));
            } catch(ArithmeticException e) {
                ecran.setText("0");
            }
        }
    }

    //Listener utilisé pour les chiffres
    //Permet de stocker les chiffres et de les afficher
    class ChiffreListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            //On affiche le chiffre additionnel dans le label
            String str = ((JButton)e.getSource()).getText();
            if(update){
                update = false;
            }
            else{
                if(!ecran.getText().equals("0"))
                    str = ecran.getText() + str;
            }
            ecran.setText(str);
        }
    }

    //Listener affecté au bouton =
    class EgalListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            calcul();
            update = true;
            clicOperateur = false;
        }
    }

    //Listener affecté au bouton +
    class PlusListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            if(clicOperateur){
                calcul();
                ecran.setText(String.valueOf(chiffre1));
            }
            else{
                chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
                clicOperateur = true;
            }
            operateur = "+";
            update = true;
        }
    }

    //Listener affecté au bouton -
    class MoinsListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            if(clicOperateur){
                calcul();
                ecran.setText(String.valueOf(chiffre1));
            }
            else{
                chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
                clicOperateur = true;
            }
            operateur = "-";
            update = true;
        }
    }

    //Listener affecté au bouton *
    class MultiListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            if(clicOperateur){
                calcul();
                ecran.setText(String.valueOf(chiffre1));
            }
            else{
                chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
                clicOperateur = true;
            }
            operateur = "*";
            update = true;
        }
    }

    //Listener affecté au bouton /
    class DivListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            if(clicOperateur){
                calcul();
                ecran.setText(String.valueOf(chiffre1));
            }
            else{
                chiffre1 = Double.valueOf(ecran.getText()).doubleValue();
                clicOperateur = true;
            }
            operateur = "/";
            update = true;
        }
    }

    //Listener affecté au bouton de remise à zéro
    class ResetListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0){
            clicOperateur = false;
            update = true;
            chiffre1 = 0;
            operateur = "";
            ecran.setText("");
        }
    }
        public static void main(String[] args) throws Exception{

                  UIManager.setLookAndFeel(new NimbusLookAndFeel());

            CalculatriceWindow calculette = new CalculatriceWindow();
        }
    }

//    public CalculatriceWindow() {
//        super("My calculatrice");
//        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        this.setSize(300, 320);
//        this.setLocationRelativeTo(null);

//        JPanel contentPane = (JPanel) this.getContentPane();
//        contentPane.setLayout(new BorderLayout());
//
//        resultat.setPreferredSize(new Dimension(300, 80));
//        contentPane.add(resultat, BorderLayout.NORTH);
//
//        contentPane.add(createPaneauNum());
//
//        contentPane.add("East", touchCalcul());
//    }

//    private JPanel createPaneauNum() {
//        JPanel touchNumerique = new JPanel(new GridLayout(4,3));
//
//        touchNumerique.add(touch7);
//        touchNumerique.add(touch8);
//        touchNumerique.add(touch9);
//        touchNumerique.add(touch4);
//        touchNumerique.add(touch5);
//        touchNumerique.add(touch6);
//
//        touch1.addActionListener(this::changeColor1);
//        touchNumerique.add(touch1);
//        touchNumerique.add(touch2);
//        touchNumerique.add(touch3);
//
//        touch0.addActionListener(this::changeColor0);
//        touchNumerique.add(touch0);
//
//        return touchNumerique;
//    }
//    private JPanel touchCalcul() {
//        JPanel touchCalcul = new JPanel();
//
//        touchCalcul.add(touchMultiplier);
//        touchCalcul.add(touchDiviser);
//        touchCalcul.add(touchAdditionner);
//        touchCalcul.add(touchSoustraire);
//        touchCalcul.add(touchEgal);
//        touchCalcul.add(touchVirgule);
//        return touchCalcul;
//    }
//
//
//    private void changeColor0(ActionEvent event) {
//        touch0.setBackground(Color.orange);
//        touch1.setBackground(Color.YELLOW);
//        touch2.setBackground(Color.blue);
//        touch3.setBackground(Color.CYAN);
//        touch4.setBackground(Color.DARK_GRAY);
//        touch5.setBackground(Color.gray);
//        touch6.setBackground(Color.RED);
//        touch7.setBackground(Color.GREEN);
//        touch8.setBackground(Color.PINK);
//        touch9.setBackground(Color.MAGENTA);
//        touchAdditionner.setBackground(Color.black);
//        touchDiviser.setBackground(Color.blue);
//        touchEgal.setBackground(Color.cyan);
//        touchMultiplier.setBackground(Color.LIGHT_GRAY);
//        touchSoustraire.setBackground(Color.PINK);
//
//    }
//
//    private void changeColor1(ActionEvent event) {
//        touch1.setBackground(Color.orange);
//        touch2.setBackground(Color.YELLOW);
//        touch3.setBackground(Color.blue);
//        touch4.setBackground(Color.CYAN);
//        touch5.setBackground(Color.DARK_GRAY);
//        touch6.setBackground(Color.gray);
//        touch7.setBackground(Color.RED);
//        touch8.setBackground(Color.GREEN);
//        touch9.setBackground(Color.PINK);
//        touch0.setBackground(Color.MAGENTA);
//        touchAdditionner.setBackground(Color.blue);
//        touchDiviser.setBackground(Color.black);
//        touchEgal.setBackground(Color.GREEN);
//        touchMultiplier.setBackground(Color.pink);
//        touchSoustraire.setBackground(Color.magenta
//        );
//
//    }
//
//
//    public static void main(String[] args) throws Exception {
////        // Apply a look'n feel
//        UIManager.setLookAndFeel(new NimbusLookAndFeel());
//
//        // Start my window
//        CalculatriceWindow Mycalculate = new CalculatriceWindow();
//        Mycalculate.setVisible(true);
//    }

