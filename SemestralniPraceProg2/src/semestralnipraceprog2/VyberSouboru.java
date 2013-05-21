/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralnipraceprog2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Adam
 */

public class VyberSouboru extends JDialog {
    
    public static String nazev = "";

     protected JButton vyber = new JButton("Potvrdit! ");
     protected JRadioButton soubor1 = new JRadioButton("soubor1");
     protected JRadioButton soubor2 = new JRadioButton("soubor2");
     protected JRadioButton soubor3 = new JRadioButton("soubor3");
     protected JRadioButton soubor4 = new JRadioButton("soubor4");
     protected JRadioButton soubor5 = new JRadioButton("soubor5");
    
     
     public VyberSouboru(){
     
        setTitle("Vyberte slot! ");
        setSize(250, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        setModal(true);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        
        //nastavení zobrazení na střed
        setLocation((d.width - getSize().width) / 2, (d.height - getSize().height) / 2);

        
        setLayout(new GridLayout(6,1));
        
        
        
        
        
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(soubor1);
        bg1.add(soubor2);
        bg1.add(soubor3);
        bg1.add(soubor4);
        bg1.add(soubor5);
        
        
        add(soubor1);
        add(soubor2);
        add(soubor3);
        add(soubor4);
        add(soubor5);
        
        add(vyber);
        
        
        soubor1.setSelected(rootPaneCheckingEnabled);
        
        
        
        vyber.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if (soubor1.isSelected()){
                nazev = soubor1.getText();
                nazev = nazev.concat(".txt");
                }
                if (soubor2.isSelected()){
                    nazev = soubor2.getText();
                    nazev = nazev.concat(".txt");
                }
                if (soubor3.isSelected()){
                    nazev = soubor3.getText();
                    nazev = nazev.concat(".txt");
                }
                if (soubor4.isSelected()){
                    nazev = soubor4.getText();
                    nazev = nazev.concat(".txt");
                }
                if (soubor5.isSelected()){
                    nazev = soubor5.getText();
                    nazev = nazev.concat(".txt");
                }
                
            dispose();
            }
        
        });
     }
}