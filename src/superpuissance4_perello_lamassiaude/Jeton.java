/*
 * 
 * Classe Jeton
 * 
 */
package superpuissance4_perello_lamassiaude;

/**
 *
 * @author eperello
 */
public class Jeton {
     //Attributs:
    String couleur;
    
    
    public Jeton (String laCouleur){
        couleur = laCouleur;
    }
    
    public String lireCouleur(){
        return couleur;
    }
    
    @Override
    public String toString() {
        return couleur;
    }
}
