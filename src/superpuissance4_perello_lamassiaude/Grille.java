/*
 * 
 * Classe Grille
 * 
 */
package superpuissance4_perello_lamassiaude;

/**
 *
 * @author eperello
 */
public class Grille {
    Cellule [][] Cellules = new Cellule[6][7];  
    
    
public Grille(){
    for (int i=0;i<6;i++){
        for(int j=0;j<7;j++){
            Cellules[i][j]=new Cellule();
        }
    }
}

public boolean ajouterJetonDansColonne(Joueur joueurActuel ,int colonne){
    //ajoute le jeton dans la  colonne ciblée, sur la cellule vide la plus basse. Renvoie faux si la colonne était pleine.
    boolean b=false;
    for (int i=0;i<6;i++){
        if(colonneRemplie(colonne)==false){
            if (Cellules[5-i][colonne].presenceDesintegrateur()==true){
                Cellules[5-i][colonne].recupererDesintegrateur();
                joueurActuel.nombreDesintegrateurs+=1;
                Cellules[5-i][colonne].affecterJeton(joueurActuel.ListeJetons[joueurActuel.nombreJetonsRestant-1]);
                return true;
            }
            else if (Cellules[5-i][colonne].presenceTrouNoir()==true){
                Cellules[5-i][colonne].activerTrouNoir();
                Cellules[5-i][colonne].supprimerJeton();
                System.out.println("Votre jeton a été absorbé par le Trou Noir...");
                return true;
            }
            else if (Cellules[5-i][colonne].jetonCourant==null){
                Cellules[5-i][colonne].affecterJeton(joueurActuel.ListeJetons[joueurActuel.nombreJetonsRestant-1]);
                return true;
            }
            b= true;
        }else{
            b= false;            
        }
    }
    return b;
}

public boolean  etreRemplie(){
    //renvoie vrai si la grille est pleine
    boolean b=true;
    for(int i=0;i<Cellules.length;i++){
        for(int j=0;j<Cellules[0].length;j++){
            if (Cellules[i][j]==null) {    
                b= true;
            }else{
                b= false;
    }
}
}
    return b;
}
    


public void  viderGrille(){
    //vide la grille
    for(int i=0;i<Cellules.length;i++){
        for(int j=0;j<Cellules[0].length;j++){
            Cellules[i][j].desintegrateur=false;
            Cellules[i][j].trouNoir=false;
            Cellules[i][j].jetonCourant=null;
    }
}
}

public void  afficherGrilleSurConsole(){
    //fonction d’affichage de la grille sur la console. Doit faire apparaitre les couleurs, et les trous noirs.
    for(int i=0;i<Cellules.length;i++){
        for(int j=0;j<Cellules[0].length;j++){
            if (Cellules[i][j].presenceTrouNoir()==true && Cellules[i][j].presenceDesintegrateur()==true) {    
               System.out.print("\u058D ");
            }
            else if (Cellules[i][j].presenceDesintegrateur()==true && Cellules[i][j].presenceTrouNoir()==false) {    
               System.out.print("\u235F ");
            }
            else if (Cellules[i][j].jetonCourant!=null){
                if ("R".equals(Cellules[i][j].jetonCourant.couleur)) {    
                        System.out.print("R ");
                }
                if ("J".equals(Cellules[i][j].jetonCourant.couleur)) {    
                    System.out.print("J ");
                }
            }
            else{
                System.out.print("\u2395 ");
            }  
        }
        System.out.println(" "+(i+1)); //afichage du numéro de ligne
    }
    for (int a=0;a<Cellules[0].length;a++){ //affichage du numéro de colonne
        System.out.print((a+1)+" ");
    }
    System.out.println();
}

public boolean celluleOccupee(int ligne, int colonne){
    //renvoie vrai si la cellule de coordonnées données est occupée par un jeton.
    if (Cellules[ligne][colonne].recupererJeton()==null){
        return false;
    }else{
        return true;
    }
}

public String lireCouleurDuJeton(int ligne, int colonne){
    //renvoie la couleur du jeton de la cellule ciblée
    if (Cellules[ligne][colonne].recupererJeton()==null){
        return "false";
    }else{
        return Cellules[ligne][colonne].recupererJeton().lireCouleur();
}
}

public boolean  etreGagnantePourJoueur(Joueur joueurteste){
    //renvoie vrai si la grille	est gagnante pour le joueur passé en paramètre,	c’est-à-dire que 4 pions de sa couleur sont alignés en ligne, en colonne ou en diagonale.
    boolean test=false;
    //test d'une colone gagante:
    for (int i=0;i<3;i++){
        for (int j=0;j<7;j++){
            if (lireCouleurDuJeton(i,j).equals(joueurteste.Couleur) && (lireCouleurDuJeton(i+1,j).equals(joueurteste.Couleur)) && (lireCouleurDuJeton(i+2,j).equals(joueurteste.Couleur)) && (lireCouleurDuJeton(i+3,j).equals(joueurteste.Couleur))){
                test=true;
            }}}
    //test d'une ligne gagante:
    for (int i=0;i<6;i++){
        for (int j=0;j<4;j++){        
            if (lireCouleurDuJeton(i,j).equals(joueurteste.Couleur) && (lireCouleurDuJeton(i,j+1).equals(joueurteste.Couleur)) && (lireCouleurDuJeton(i,j+2).equals(joueurteste.Couleur)) && (lireCouleurDuJeton(i,j+3).equals(joueurteste.Couleur))){
                test=true;
            }}}
    //test d'une diagonale montante gagante:
    for (int i=0;i<3;i++){
        for (int j=0;j<4;j++){
            if (lireCouleurDuJeton(i,j).equals(joueurteste.Couleur) && (lireCouleurDuJeton(i+1,j+1).equals(joueurteste.Couleur)) && (lireCouleurDuJeton(i+2,j+2).equals(joueurteste.Couleur)) && (lireCouleurDuJeton(i+3,j+3).equals(joueurteste.Couleur))){
                test=true;
            }}}
    //test d'une diagonale descendante gagnante:
    for (int i=3;i<6;i++){
        for (int j=0;j<4;j++){
            if (lireCouleurDuJeton(i,j).equals(joueurteste.Couleur) && (lireCouleurDuJeton(i-1,j+1).equals(joueurteste.Couleur)) && (lireCouleurDuJeton(i-2,j+2).equals(joueurteste.Couleur)) && (lireCouleurDuJeton(i-3,j+3).equals(joueurteste.Couleur))){
                test=true;
            }
        }
        }
    return test;
    }

public void tasserGrille(int colonejeton){
    //	lorsqu’un jeton	est capturé ou détruit,	tasse la grille	en décalant de une ligne les jetons situés au dessus de	la cellule libérée.
    for (int i=0;i<5;i++){
        if (Cellules[5-i][colonejeton].jetonCourant==null){
            Cellules[5-i][colonejeton].jetonCourant=Cellules[4-i][colonejeton].jetonCourant;
            Cellules[4-i][colonejeton].jetonCourant=null;
        }
    }
}

public boolean colonneRemplie(int colonne){
    //	renvoie	vrai si	la colonne est remplie (on ne peut y jouer un Jeton)
    boolean essai=false;
    if(celluleOccupee(0,colonne)==true){
        essai=true;
    }
    return essai;
}
    


public boolean placerTrouNoir(int ligne, int colone){
    //ajoute un	trou noir à l’endroit indiqué et retourne vrai si l’ajout s’est	bien passé, ou faux sinon (exemple : trou noir déjà présent)
    boolean test=false;
    if(Cellules[ligne][colone].trouNoir==false){
        Cellules[ligne][colone].trouNoir = true;
        test=true;
    }
return test;
}

public boolean  placerDesintegrateur(int ligne, int colone){
    //ajoute un	désintégrateur à l’endroit indiqué et retourne vrai si l’ajout s’est bien passé, ou faux sinon (exemple : désintégrateur déjà présent)
    boolean test=false;
    if(Cellules[ligne][colone].desintegrateur==false){
        Cellules[ligne][colone].desintegrateur = true;
        test=true;
    }
return test;
}

public boolean supprimerJeton(int ligne, int colone){
    //supprime le jeton	de la cellule visée. Renvoie vrai si la	suppression s’est bien déroulée, ou faux autrement (jeton absent)
    if (Cellules[ligne][colone].recupererJeton()!=null){
        Cellules[ligne][colone].supprimerJeton();
        return true;
    }
    return false;
}

public Jeton recupererJeton(int ligne, int colone){
    //enlève le	jeton de la cellule visée et renvoie une référence vers	ce jeton.
    Jeton jetonrecup =  Cellules[ligne][colone].jetonCourant;
    Cellules[ligne][colone].supprimerJeton();
    return jetonrecup;
}



}