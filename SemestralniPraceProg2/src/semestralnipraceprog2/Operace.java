
package semestralnipraceprog2;

/**
 *
 * @author Adam Kucera / kucerad4
 */
public class Operace {

    public Operace() {
    }   
    
    //methods for math operations, some yet with dummy procedures 
    
    //metoda pro součet
    public double [][] Soucet(double[][] maticeA, double[][] maticeB){
        
        double vysledek[][] = new double [maticeA.length][maticeA[0].length];
        
        if (maticeA.length != maticeB.length || maticeA[0].length != maticeB[0].length){
            System.out.println("Matice nemají kompatibilní rozměry pro sečtení! ");
            
        }
        
        else{
            for (int i = 0; i < vysledek.length; i++) {
                
                for (int j = 0; j < vysledek[0].length; j++) {
                    
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
            System.out.println("Matice nemají kompatibilní rozměry pro odečtení! ");
            
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
        
        if (maticeA[0].length != maticeB.length){
            
            System.out.println("Matice nejsou kompatibilní pro součin. ");
        }
        else{
            
            for (int i = 0; i < vysledek.length; i++) {
                
                for (int j = 0; j < vysledek[0].length; j++) {
                    
                    vysledek[i][j]=maticeA[i][j] * maticeB[j][i];
                    
                }                
            }
        }
        
        return vysledek;
    }
    //metoda pro vypocet determinantu
    public double Determinant(double[][] maticeA){
        
        double vysledek = 0;
        
        if (maticeA.length != maticeA[0].length){
            
            System.out.println("Matice není čtvercová! ");
        }
        else{
            //DOPLNIT!!!!!
            //DOPLNIT!!!!!
            //DOPLNIT!!!!!
            //DOPLNIT!!!!!
            //DOPLNIT!!!!!
            //DOPLNIT!!!!!            
               
            
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
            
            System.out.println("Matice není čtvercová! ");
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
