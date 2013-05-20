package semestralnipraceprog2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
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

    //pro přístup k metodám operací a použití matic
    Operace op = new Operace();
    Matice mat = new Matice();
    
    
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
        
        okna.add(OknoSMatici("Matice A:", poleMaticeA));
        okna.add(OknoSMatici("Matice B:", poleMaticeB));
        okna.add(OknoSMatici("Výsledek:", poleVysledek));
        
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
        vlozB = new JButton("Vlož B ze souboru");        
        ulozA = new JButton("Ulož A");        
        ulozB = new JButton("Ulož B");        
        ulozC = new JButton("Ulož výsledek");        
        help = new JButton("Nápověda");
        
        nabidka.add(ulozA);
        nabidka.add(ulozB);
        nabidka.add(ulozC);
        nabidka.add(vlozA);
        nabidka.add(vlozB);
        nabidka.add(help);
        
        add(nabidka);
       
        
        //ActionListenery
        
        //volba akce pro tlačítko 'Spočti!' v závislosti na vybrané operaci
        spocti.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                
                int volba = vyberOperaci.getSelectedIndex();             
                
                
                switch (volba){
                    
                    case 0:
                        mat.ZobrazMatici(op.Soucet(mat.NactiMatici(poleMaticeA),mat.NactiMatici(poleMaticeB)),poleVysledek);
                        break;
                    case 1:
                        mat.ZobrazMatici(op.Rozdil(mat.NactiMatici(poleMaticeA),mat.NactiMatici(poleMaticeB)),poleVysledek);
                        break;
                    case 2:
                        mat.ZobrazMatici(op.Soucin(mat.NactiMatici(poleMaticeA),mat.NactiMatici(poleMaticeB)),poleVysledek);
                        break;
                    case 3:
                        mat.ZobrazMatici(op.Soucin(mat.NactiMatici(poleMaticeB),mat.NactiMatici(poleMaticeA)),poleVysledek);
                        break;                    
                    case 4:
                        mat.ZobrazMatici(op.Transpozice(mat.NactiMatici(poleMaticeA)),poleVysledek);
                        break;
                    case 5:
                        mat.ZobrazMatici(op.Transpozice(mat.NactiMatici(poleMaticeB)),poleVysledek);
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Tato metoda bohužel ještě není implementována. ");
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null, "Tato metoda bohužel ještě není implementována. ");
                        break;
                    case 8:
                        poleVysledek.setText("" +op.Determinant(mat.NactiMatici(poleMaticeA)));
                        break;
                    case 9:
                        poleVysledek.setText("" +op.Determinant(mat.NactiMatici(poleMaticeB)));
                        break;
                        
                  }
                } catch (Exception er) {
                    System.err.println("Chyba chlačítka 'spočti': " + er);
                }
            }
        });
        
        //tlačítko ulož, ukládáme matici do souboru
        ulozA.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String jmeno = "maticeA.txt";
                    mat.Uloz(mat.NactiMatici(poleMaticeA),jmeno);
                } catch (Exception er) {
                    System.err.println("Chyba při ulkádání matice A! " + er);
                }

            }
        });
        
        //tlačítko ulož, ukládáme matici do souboru
        ulozB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                String jmeno = "maticeB.txt";
                    mat.Uloz(mat.NactiMatici(poleMaticeB),jmeno);
                } catch (Exception er) {
                    System.err.println("Chyba při ulkádání matice B! " + er);
                }
            }
        });
        
        //tlačítko ulož, ukládáme matici do souboru
        ulozC.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String jmeno = "Vysledek.txt";
                    mat.Uloz(mat.NactiMatici(poleVysledek),jmeno);
                } catch (Exception er) {
                    System.err.println("Chyba při ulkádání matice C! " + er);
                }               
            }
        });
        
        //tlačítko pro vložení ze souboru
        vlozA.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String jmeno = "maticeA.txt";
                    
                    mat.ZobrazMatici(mat.Nacti(jmeno),poleMaticeA);
                } catch (FileNotFoundException ex) {
                    System.out.println("Soubor s maticí nebyl nalezen! ");
                } catch (IOException ex) {
                    System.out.println("Chyba při čtení ze souboru! ");
                }                
            }
        });
        
        //tlačítko pro vložení ze souboru
        vlozB.addActionListener(new ActionListener() {                    

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String jmeno = "maticeB.txt";                    
                    mat.ZobrazMatici(mat.Nacti(jmeno),poleMaticeB);
                } catch (FileNotFoundException ex) {
                    System.out.println("Soubor s maticí nebyl nalezen! ");
                } catch (IOException ex) {
                    System.out.println("Chyba při čtení ze souboru! ");
                }
            }
        });
        
        //vyskakující okno s nápovědou
        help.addActionListener(new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent e) {
                Navod navod = new Navod();
                navod.setVisible(true);
            }
        });
    }
    
    //založení textových polí pro matice, v rámci objektového pojetí, je samostatně
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