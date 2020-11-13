/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superpuissance4_perello_lamassiaude;



import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Acer
 */
public class CelluleGraphique extends JButton {
    Cellule celluleAssociee;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));
    ImageIcon img_desint = new javax.swing.ImageIcon(getClass().getResource("/images/desintegrateur.png"));
    ImageIcon img_jetonJaune = new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png"));
    ImageIcon img_jetonRouge = new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png"));
    ImageIcon img_trouNoir = new javax.swing.ImageIcon(getClass().getResource("/images/trouNoir.png"));
    
    public CelluleGraphique (Cellule uneCellule){
        celluleAssociee = uneCellule;
    }
    
    @Override
    public void paintComponent (Graphics G){
        super.paintComponent(G);
        if (celluleAssociee.presenceTrouNoir() == true){
            setIcon(img_trouNoir);
        }
        else if (celluleAssociee.presenceDesintegrateur()== true){
            setIcon(img_desint);
        }
        else {
            String couleur_jeton = celluleAssociee.lireCouleurDuJeton();
            switch (couleur_jeton){
                case "Rouge":
                    setIcon(img_jetonRouge);
                    break;
                case "Jaune":
                    setIcon(img_jetonJaune);
                    break;
                case "vide":
                    setIcon(img_vide); // On attribue l'image celluleVide.png
                    break;
            }
        }     
    }
    
  
}
