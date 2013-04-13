/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralnipraceprog2;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Adam Kucera / kucerad4
 */
public class Okno extends JFrame{
    
    
    //pole a tlačítka, která budu vyuzivat na titulce    
    protected JTextArea poleMaticeA, poleMaticeB, poleVysledek;
        
    protected JButton vlozA, vlozB, ulozA, ulozB, ulozC, help, spocti;

    protected JComboBox vyberOperaci;
    
    protected String operace[] = {"A+B", "A-B", "A*B", "B*A", "Transponovat A", "Transponovat B", "Inverzní A", "Inverzní B", "Determinant A", "Determinant B"};

    
    Operace op = new Operace();
    
    
    public Okno() {
        
        //zalozeni hlavniho okna, velikosti...
        setTitle("Maticová kalkulačka ");
        setSize(750,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        
        
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
        
        //podokno vyber operace a tlačítko =
        JPanel pocitej = new JPanel();
        pocitej.setLayout(new GridLayout(1,2,10,10));
        pocitej.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        spocti = new JButton("Spočti!");
        vyberOperaci = new JComboBox(operace);
        pocitej.add(vyberOperaci);
        pocitej.add(spocti);
        add(pocitej);
        
        
        //podokno pro nabídku operací
        JPanel nabidka = new JPanel();        
        nabidka.setLayout(new GridLayout(2,3,10,10));
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
        //ulozC.setSize(70, 20);
        help = new JButton("Nápověda");
        
        nabidka.add(ulozA);
        nabidka.add(ulozB);
        nabidka.add(ulozC);
        nabidka.add(vlozA);
        nabidka.add(vlozB);
        nabidka.add(help);
        
        add(nabidka);
       
        spocti.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                int volba = vyberOperaci.getSelectedIndex();
                
                
                //MUSÍ SE DOPLNIT VÝSLEDEK Z NAČTENÍ MATIC!!!!
                //MUSÍ SE DOPLNIT VÝSLEDEK Z NAČTENÍ MATIC!!!!
                //MUSÍ SE DOPLNIT VÝSLEDEK Z NAČTENÍ MATIC!!!!
                //MUSÍ SE DOPLNIT VÝSLEDEK Z NAČTENÍ MATIC!!!!
                //MUSÍ SE DOPLNIT VÝSLEDEK Z NAČTENÍ MATIC!!!!
                //MUSÍ SE DOPLNIT VÝSLEDEK Z NAČTENÍ MATIC!!!!
                //MUSÍ SE DOPLNIT VÝSLEDEK Z NAČTENÍ MATIC!!!!
                switch (volba){
                    
                    case 0:
                        //op.Soucet(maticeA, maticeB);
                        break;
                    case 1:
                        //op.Rozdil(maticeA, maticeB);
                        break;
                    case 2:
                        //op.Soucin(maticeA, maticeB);
                        break;
                    case 3:
                        //op.Soucin(maticeB, maticeA);
                        break;
                    case 4:
                        //op.Soucin(maticeA, maticeB);
                        break;
                    case 5:
                        //op.Transpozice(maticeA);
                        break;
                    case 6:
                        //op.Transpozice(maticeB);
                        break;
                    case 7:
                        //op.Inverzni(maticeA);
                        break;
                    case 8:
                        //op.Inverzni(maticeB);
                        break;
                    case 9:
                        //op.Determinant(maticeA);
                        break;
                    case 10:
                        //op.Determinant(maticeB);
                        break;
                        
                  }
            }
        });
        
        ulozA.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
            
            
        });
        
        ulozB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
        ulozC.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
        vlozA.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
        vlozB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
        help.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
        
        
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
