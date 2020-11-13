/*
 * 
 * Classe Joueur
 * 
 */
package superpuissance4_perello_lamassiaude;

/**
 *
 * @author eperello
 */
public class Joueur {
    // Attributs:
    String Nom;
    String Couleur;
    Jeton [] ListeJetons;
    int nombreDesintegrateurs;
    int nombreJetonsRestant;
    
public Joueur(String leNom){
    Nom = leNom;
    Couleur = "";
    ListeJetons = new Jeton[21];
    nombreDesintegrateurs = 0;
    nombreJetonsRestant = 0;
}     


public void affecterCouleur(String laCouleur){
    //affecte la couleur en paramètre au joueur
    Couleur = laCouleur;
}

public void ajouterJeton(Jeton leJeton){
    //ajoute le jeton passé en paramètre à la liste des jetons
    ListeJetons[nombreJetonsRestant]=leJeton;
    nombreJetonsRestant+=1;
    }


public void obtenirDesintegrateur(){
    //incrémente le nombre de désintégrateurs du joueur
    nombreDesintegrateurs+= 1;
}

public boolean utiliserDesintegrateur(){
    //décrémente le nombre de désintégrateurs et confirme l’utilisation de ce dernier, ou renvoie faux s’il ne restait	plus de désintégrateurs.
    if (nombreDesintegrateurs>=1){
        nombreDesintegrateurs=nombreDesintegrateurs-1;
        return true;
    }
    else{
        return false;
}
}

@Override
    public String toString() {
        return Nom+" "+Couleur+" possède "+nombreDesintegrateurs+" désintégrateurs et il lui reste "+nombreJetonsRestant+ " jetons ";
    }

}
