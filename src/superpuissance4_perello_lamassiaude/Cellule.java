/*
 * 
 * Classe Cellule
 * 
 */
package superpuissance4_perello_lamassiaude;

/**
 *
 * @author eperello
 */
public class Cellule {
    Jeton jetonCourant;
    boolean trouNoir;
    boolean desintegrateur;

    
public Cellule(){
    //construteur initialisant les attributs avec des valeurs par défaut
    jetonCourant=null;
}

public boolean affecterJeton(Jeton leJeton){
    //ajoute le jeton en paramètre à la cellule, et retourne vrai si l’ajout s’est bien passé, ou faux sinon (ex :jeton déjà présent)
    if (jetonCourant==null){
        jetonCourant=leJeton;
        return true;
    }
    else{
        return false;
    } 
}

public Jeton recupererJeton(){
    //renvoie une référence vers le jeton de la cellule
        return jetonCourant;
}

public boolean  supprimerJeton(){
    //supprime le jeton et renvoie vrai si la suppression s’est bien passée, ou faux autrement (ex : pas de jeton présent)*
    if (jetonCourant==null){
        return false;
    }else{
        jetonCourant=null;
        return true;
    }   
}


public boolean presenceTrouNoir(){
    //renvoie vrai si un trou noir est présent sur la cellule
    if (trouNoir==true){
        return true;
    }else{
        return false;
    }
}
    

public boolean  presenceDesintegrateur(){
    //renvoie vrai si un desintégrateur est présent sur la cellule
   if (desintegrateur==true){
        return true;
    }else{
        return false;
    }
}

public boolean placerTrouNoir(){
    //ajoute un trou noir à l’endroit indiqué et retourne vrai si lajout s’est bien passé, ou faux sinon (exemple : trou noir déjà présent)   
    if (presenceTrouNoir() == true){
        return false;
    }else{
        trouNoir=true;
        return true;
}
}

public boolean placerDesintegrateur(){
    //ajoute un désintégrateur à l’endroit indiqué et retourne vrai si lajout s’est bien passé, ou faux sinon (exemple : désintégrateur déjà présent)   
    if (desintegrateur == true){
        return false;
    }else{
        desintegrateur=true;
        return true;
}
}

public String  lireCouleurDuJeton(){
    //renvoie la couleur du jeton occupant la cellule
    String couleur;
    if (jetonCourant==null){
        couleur= "pas de jeton";
    }
    else{
        couleur=jetonCourant.lireCouleur();
    }
    return couleur;
}

public boolean  recupererDesintegrateur(){
    //supprime le désintégrateur présent de la cellule, et renvoie vrai, ou faux sinon (exemple : pas de désintégrateur présent)
    if (presenceDesintegrateur()==true){
        desintegrateur=false;
        return true;
    }else{
        return false;
    }
}

public boolean activerTrouNoir(){
    //active le trou noir : le trou noir engloutit le jeton et disparait. Retourne vrai si tout s’est correctement déroulé, ou faux sinon (pas de trou noir)
    if(presenceTrouNoir()==true){
        supprimerJeton();
        trouNoir=false;
        return true;
    }else{
        return false;
              
    }
}

}
