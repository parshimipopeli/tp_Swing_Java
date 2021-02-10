package fr.parshimipopeli.SwingJava.ImplementListener;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;




    public class DemoSwing extends JFrame {

        private JComboBox<String> comboBox = new JComboBox<>( new String[] { "First", "Second", "Third" } );
        private JScrollPane tree = new JScrollPane( new JTree() );
        private JScrollPane textArea = new JScrollPane( new JTextArea("Content to edit") );
        private JButton button = new JButton( "Click Me" );
        private JPanel contentPane;

        private Component currentInjectedComponent = null;

        public DemoSwing() {
            super( "Demo changement contenu" );
            this.setSize( 400, 300 );
            this.setLocationRelativeTo( null );
            this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );

            contentPane = (JPanel) getContentPane();
            contentPane.add( comboBox, BorderLayout.NORTH );

            // Utilisation de référence sur méthode pour la gestion des événements (requière un Java SE 8)
            comboBox.addItemListener( this::comboBoxItemStateChange );

            this.setVisible( true );
        }

        public void comboBoxItemStateChange( ItemEvent event ) {
            if ( event.getStateChange() == ItemEvent.SELECTED ) {
                if ( currentInjectedComponent != null ) {
                    contentPane.remove( currentInjectedComponent );
                }
                switch( (String) event.getItem() ) {
                    case "First":
                        currentInjectedComponent = tree;
                        contentPane.add( tree, BorderLayout.CENTER );
                        break;
                    case "Second":
                        currentInjectedComponent = textArea;
                        contentPane.add( textArea, BorderLayout.CENTER );
                        break;
                    default:
                        currentInjectedComponent = button;
                        contentPane.add( button, BorderLayout.CENTER );
                }
                contentPane.revalidate();
                currentInjectedComponent.repaint();
            }
        }


        public static void main( String[] args )  throws Exception {
            UIManager.setLookAndFeel( new NimbusLookAndFeel() );
            new DemoSwing();
        }

    }

