package semestralnipraceprog2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Adam Kucera / kucerad4
 */


// tato třída je zoodpovědná a obsahuje metody pro načtení matice, jak z řádku, tak ze souboru, zobrazení matice a uložení matice
public class Matice {
    
    
    //Nactení matice z okna
    public static double[][] NactiMatici(JTextArea pole){
        
        //založení proměnných
	String text = pole.getText();
	String val = "";
	int i = 0;
	int j = 0;
        int m = 0;
        int n = 0;
        
	//rozsekání textu na řádky a posléze na sloupce, pro zjištění jejich počtu               
	StringTokenizer prvniST = new StringTokenizer(text, "\n");
	while (prvniST.hasMoreTokens()) {
            StringTokenizer prvniST2 = new StringTokenizer(prvniST.nextToken());
		while (prvniST2.hasMoreTokens()) {
                    prvniST2.nextToken();
                    j++;
		}			
		i++;
                m = i;
                n = j;
		j = 0;
	}
        
        //založení výstupní matice
	double matice[][] = new double[m][n];
	i = j = 0;
		
        //znovu projetí na řádky a slouce, tentokrát ukládáme jednotlivé prvky do matice
	StringTokenizer prvni2 = new StringTokenizer(text, "\n");
        while (prvni2.hasMoreTokens()) {
            StringTokenizer druhy = new StringTokenizer(prvni2.nextToken());
                while (druhy.hasMoreTokens()) {
                    val = druhy.nextToken();

                    try {
                        matice[i][j] = Double.valueOf(val).doubleValue();
                    } catch (Exception exception) {

                        JOptionPane.showMessageDialog(null, "Byla špatně zadána některá z matic! ");
                    }
                    j++;
                }
                i++;
                j = 0;
        }
        return matice;
    }
    //zobrazení matice v jednom z textových polí, vstupem je polem s maticí a textové pole, do kterého budeme ukládat
    public static void ZobrazMatici(double[][] matice, JTextArea pole) {
            
        //založení proměnných
        String komplet = "";
        String prvek = "";
        
        //projetí jednotlivých prvků matice a jejich přilepení k sobě
        for (int i = 0; i < matice.length; i++) {
                for (int j = 0; j < matice[i].length; j++) {
                        prvek = ""+matice[i][j];
                        komplet = komplet.concat(prvek + "  ");
                }

                komplet = komplet.concat("\n");
        }

        pole.setText(komplet);
    }
    
    
    //uložení matice do souboru
    public static void Uloz(double[][] matice, String jmeno){
        
        //pomocí FileWriteru jdeme po prvcích matice, které postupně zapisujeme
        //do vytvořeného souboru
        FileWriter fstream = null;
        try {
            fstream = new FileWriter(jmeno);
            BufferedWriter out = new BufferedWriter(fstream);
            for (int i = 0; i < matice.length; i++) {
                for (int j = 0; j < matice[i].length; j++) {
                    out.write(matice[i][j]+" ");
                }
                out.newLine();
            }

            out.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Chyba při zápisu matice do souboru! ");
            
        } finally {
            try {
                fstream.close();
            } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Nelze zavřít FileWriter! ");
            }
        } 
    }
    
    
    //načtení uožené matice ze souboru
    public static double[][] Nacti(String nazev) throws FileNotFoundException, IOException{
         
        //kvůli return value musíme založit matici již teď s nefinálními rozměry
        double matice[][] = new double[2][2];
        
        //pomocné proměnné pro cykly
        int i;
        int m = 0;
        int n = 0;        
         
        String text;

        //vytvoření souboru, s předaným názvem z parametru
        File soubor = new File(nazev); 
        if (soubor.exists()) {

            BufferedReader br = null;
            
            FileReader fr = new FileReader(soubor); 
            br = new BufferedReader(fr);
            //ArrayList do kterého budeme dočasně ukládat všechny prvky
            List<Double> ar = new ArrayList<Double>();
                


            while (br.ready()) {
                String vstup = br.readLine();
                StringTokenizer st = new StringTokenizer(vstup);
                n = st.countTokens();
                i = 0;
                while (st.hasMoreTokens()) {
                    //dokud máme další prvky, ukládáme je do arraylistu
                    text = st.nextToken();
                    ar.add(Double.parseDouble(text));                        

                    i++;
                    if (i == n) {                        
                        m++;//pokud projdeme cyklus tolikrat, koilk mame sloupcu, tak jdeme na dalsi radek
                        break; 
                    }

                }
            }                
            //přetypování matice na skutečné výstupní rozměry  
            matice = new double[m][n];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    matice[j][k] = ar.get(j * m + k);                            
                }

            }
        }
        else{
        JOptionPane.showMessageDialog(null, "Soubor s maticí neexistuje! ");
        }
        return matice;
    }
    
    
    
    
    
    
}
