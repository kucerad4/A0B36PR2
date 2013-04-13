/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralnipraceprog2;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Adam Kucera / kucerad4
 */
public class Okno extends JFrame{
    
    
    //pole a tlačítka, která budu vyuzivat na titulce    
    protected JTextArea poleMaticeA, poleMaticeB, poleVysledek;
        
    protected JButton vlozA, vlozB, ulozA, ulozB, ulozC, help;

    protected JComboBox vyberOperaci;
    
    protected String operace[] = {"A+B", "A-B", "A*B", "B*A", "Transponovat A", "Transponovat B", "Inverzní A", "Inverzní B", "Determinant A", "Determinant B"};

    public Okno() {
        
        //zalozeni hlavniho okna, velikosti...
        setTitle("Maticová kalkulačka ");
        setSize(750,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,1));
        
        
        //podokno ve kterem jsou pole pro matice
        JPanel okna = new JPanel();
        okna.setLayout(new GridLayout(1,3,5,5));
        okna.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        poleMaticeA = new JTextArea();
        poleMaticeB = new JTextArea();
        poleVysledek = new JTextArea();
        
        okna.add(OknoSMatici("Matice A", poleMaticeA));
        okna.add(OknoSMatici("Matice B", poleMaticeB));
        okna.add(OknoSMatici("Výsledná matice", poleVysledek));
        
        add(okna);
        
        
        //podokno pro nabídku operací
        JPanel nabidka = new JPanel();        
        nabidka.setLayout(new GridLayout(3,3,10,10));
        nabidka.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        vlozA = new JButton("Vlož A ze souboru");
        //vlozA.setSize(70, 20);
        vlozB = new JButton("Vlož B ze souboru");
        //vlozB.setSize(70, 20);
        ulozA = new JButton("Ulož A");
        //ulozA.setSize(70, 20);
        ulozB = new JButton("Ulož B");
        //ulozB.setSize(70, 20);
        ulozC = new JButton("Ulož výsledek");
        
        vyberOperaci = new JComboBox(operace);
        
        
        
        nabidka.add(vlozA);
        nabidka.add(vlozB);
        nabidka.add(vyberOperaci);
        nabidka.add(ulozA);
        nabidka.add(ulozB);
        nabidka.add(ulozC);
        
        add(nabidka);
        
        
        help = new JButton("Nápověda");
        nabidka.add(help);
       
        
        
        
    }
    
    private JPanel OknoSMatici(String nazev, JTextArea pole){
        
        JScrollPane poleProMatici = new JScrollPane(pole);
        poleProMatici.setSize(220, 220);
        
        JLabel nadpis = new JLabel(nazev);
        nadpis.setLabelFor(poleProMatici);
        
        JPanel okno = new JPanel();
        okno.setLayout(new BoxLayout(okno, BoxLayout.Y_AXIS));
        okno.add(nadpis);
        okno.add(poleProMatici);
        
        
        return okno;
        
        
    }
    
    
    
        
        
    
    
    
}
