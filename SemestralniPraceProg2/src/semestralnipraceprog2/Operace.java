
package semestralnipraceprog2;

import javax.swing.JOptionPane;

/**
 *
 * @author Adam Kucera / kucerad4
 */
public class Operace {

    public Operace() {
    }   
    
    //metoda pro součet
    public double [][] Soucet(double[][] maticeA, double[][] maticeB){        
        
        double vysledek[][] = new double [maticeA.length][maticeA[0].length];
        
        if (maticeA.length != maticeB.length || maticeA[0].length != maticeB[0].length){
            JOptionPane.showMessageDialog(null, "Matice nemají kompatibilní rozměry pro sečtení! ");
            
        }
        
        else{
            for (int i = 0; i < maticeA.length; i++) {
                
                for (int j = 0; j < maticeA[0].length; j++) {
                    
                    vysledek[i][j]=maticeA[i][j] + maticeB[i][j];
                    
                }                
            }            
        }        
        return vysledek;        
        
    }
    
    //metoda rozdílu
    public double [][] Rozdil(double[][] maticeA, double[][] maticeB){
        
        double vysledek[][] = new double [maticeA.length][maticeA[0].length];
        
        if (maticeA.length != maticeB.length || maticeA[0].length != maticeB[0].length){
            JOptionPane.showMessageDialog(null, "Matice nemají kompatibilní rozměry pro odečtení! ");
            
        }
        
        else{
            for (int i = 0; i < vysledek.length; i++) {
                
                for (int j = 0; j < vysledek[0].length; j++) {
                    
                    vysledek[i][j]=maticeA[i][j] - maticeB[i][j];
                    
                }                
            }            
        }        
        return vysledek;        
        
    }
    //metoda pro soucin
    public double [][] Soucin(double[][] maticeA, double[][] maticeB){
        
        double vysledek[][] = new double [maticeA.length][maticeB[0].length];
        double sum = 0;
        
        if (maticeA[0].length != maticeB.length){
            
            JOptionPane.showMessageDialog(null, "Matice nejsou kompatibilní pro součin. ");
        }
        else{            
            
            for ( int i = 0 ; i < maticeA.length ; i++ ) {
                for ( int j = 0 ; j < maticeB[0].length ; j++ ) {   
                    for ( int k = 0 ; k < maticeB.length ; k++ ) {
                        sum += maticeA[i][k]*maticeB[k][j];
                    }
                    vysledek[i][j] = sum;
                    sum = 0;
                }
            }
        }
        
        return vysledek;
    }
    //metoda pro vypocet determinantu
    public double Determinant(double[][] maticeA){
        
        double vysledek = 0;
        
        if (maticeA.length != maticeA[0].length){
            
            JOptionPane.showMessageDialog(null, "Matice není čtvercová! ");
        } else {
        
            int sum=0; 
            int s;
            if(maticeA.length==1){
                return(maticeA[0][0]);
            }
            for(int i=0;i<maticeA.length;i++){
                double[][]mini= new double[maticeA.length-1][maticeA.length-1];
                for(int a=1;a<maticeA.length;a++){
                    for(int b=0;b<maticeA.length;b++){
                        if(b<i){
                            mini[a-1][b]=maticeA[a][b];
                        }
                        else if(b>i){
                            mini[a-1][b-1]=maticeA[a][b];
                        }
                    }
                }
                if(i%2==0){ //změna znaménka - máme přičítat nebo odčítat
                    s=1;
                }
                else{
                    s=-1;
                }            
                vysledek+=s*maticeA[0][i]*(Determinant(mini));
            }
        }
        return vysledek;
    }
    
    //vypocet transponovane matice
    public double [][] Transpozice(double[][] maticeA){
        
        double vysledek [][] = new double [maticeA[0].length][maticeA.length];
        
        for (int i = 0; i < vysledek.length; i++) {
                
            for (int j = 0; j < vysledek[0].length; j++) {

                vysledek[i][j]=maticeA[j][i];                    
            }                
        }        
        return vysledek;
    }
    
    //vypovet inverzni matice
    double [][] Inverzni(double[][] maticeA){
        
        double vysledek [][] = new double [maticeA.length][maticeA[0].length];
        
        if (maticeA.length != maticeA[0].length){
            
            JOptionPane.showMessageDialog(null, "Matice není čtvercová! ");
        }
        else{
            //DOPLNIT!!!!!
            //DOPLNIT!!!!!
            //DOPLNIT!!!!!
            //DOPLNIT!!!!!
            //DOPLNIT!!!!!
            //DOPLNIT!!!!!            
            //DOPLNIT!!!!!                    
        }        
        
        return vysledek;
    }
}