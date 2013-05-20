package semestralnipraceprog2;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class Navod extends JDialog{

    //založení oblasti, kam budeme zapisovat, návod a tlačítka pro zavření
    protected JTextArea vypisSouboru = new JTextArea();
    protected JButton zavritOkno = new JButton("Zavřít");
    
    public Navod() {
        //nastavení parametrů okna, title, velikost atd.
        setTitle("Navod");
        setSize(400, 550);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //okno bude v popředí před hlavním oknem
        setModal(true);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        
        //nastavení zobrazení na střed
        setLocation((d.width - getSize().width) / 2, (d.height - getSize().height) / 2);

        
        setLayout(new FlowLayout());
        
        add(zavritOkno);
        add(vypisSouboru);

        //přečteme soubor s návodem
        try {
            BufferedReader vstup = new BufferedReader(new InputStreamReader(new FileInputStream("navod.txt"), "windows-1250"));
            String s, t;
            while (vstup.ready()) {
                s = vstup.readLine();               
                
                t = vypisSouboru.getText() + "\n"; //pridano zalamovani radku
                vypisSouboru.setText(t + s);
            }
            vstup.close();

        } catch (IOException e) {
            
            //chybová hláška při poruše čtení
            JOptionPane.showMessageDialog(null, "Nepredpokladana chyba pri cteni ze souboru!!!");
        }

        //zavření okna
        zavritOkno.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            dispose();
            }
        
        });
    }
}
