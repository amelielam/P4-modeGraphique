/*
 * 
 * Classe Partie
 * 
 */
package superpuissance4_perello_lamassiaude;
import java.util.Scanner;
/**
 *
 * @author Acer
 */
public class Partie {
    //Attributs:
    Joueur [] ListeJoueurs = new Joueur[2];
    Joueur joueurCourant;
    Grille grilleJeu = new Grille();
    
public Partie (){
}

public void attribuerCouleursAuxJoueurs(){
    double nbalea=Math.random();
    if (nbalea>0.5) {
        ListeJoueurs[0].affecterCouleur("R");
        ListeJoueurs[1].affecterCouleur("J");
        System.out.println(ListeJoueurs[0].Nom+" a la couleur ROUGE");
        System.out.println(ListeJoueurs[1].Nom+" a la couleur JAUNE");
    }else{
        ListeJoueurs[0].affecterCouleur("J");
        ListeJoueurs[1].affecterCouleur("R");
        System.out.println(ListeJoueurs[1].Nom+" a la couleur ROUGE");
        System.out.println(ListeJoueurs[0].Nom+" a la couleur JAUNE");
    }
}

public void initialiserPartie(){
    //inscription des 2 joueurs:
    Scanner sca = new Scanner(System.in);
    System.out.println("Entrez le nom du premier joueur");
    String Joueur1=sca.next();
    System.out.println("Entrez le nom du second joueur");
    String Joueur2=sca.next();
    Joueur J1 = new Joueur(Joueur1);
    Joueur J2 = new Joueur(Joueur2);
    ListeJoueurs[0]=J1;
    ListeJoueurs[1]=J2;
    
    //détermination du 1er joueur:
    double nbalea=Math.random();
    if (nbalea>0.5) {
        joueurCourant= ListeJoueurs[0];
    }
    else{
        joueurCourant= ListeJoueurs[1];
    }
    System.out.println("Le premier joueur est : "+joueurCourant.Nom);
    
    //Distribution des couleurs:
    attribuerCouleursAuxJoueurs();

    //Création de la grille
    grilleJeu.viderGrille();
    int nbTN=0;
    while (nbTN<=5){
        int ligne=(int)(Math.random() * 6);
        int colone=(int)(Math.random() * 7);
        
        if (grilleJeu.Cellules[ligne][colone].desintegrateur==false && grilleJeu.Cellules[ligne][colone].trouNoir==false){
            if (nbTN==4 || nbTN==5){
                grilleJeu.placerTrouNoir(ligne,colone);
                grilleJeu.placerDesintegrateur(ligne,colone);
            }else{
                grilleJeu.placerTrouNoir(ligne,colone);
            }
            nbTN+=1;
            
        
    }
    }
    
       
    int nbDesint=0;
    while (nbDesint<=3){
        int ligne=(int)(Math.random() * 6);
        int colone=(int)(Math.random() * 7);
        if (grilleJeu.Cellules[ligne][colone].desintegrateur==false && grilleJeu.Cellules[ligne][colone].trouNoir==false){
            grilleJeu.placerDesintegrateur(ligne,colone);
            nbDesint+=1;
        }else{
                nbDesint=nbDesint;
                }
    }    
    for (int i=0;i<21;i++){
        if (ListeJoueurs[0].Couleur.equals("R")){
            Jeton jetonjoueurR = new Jeton("R");
            ListeJoueurs[0].ajouterJeton(jetonjoueurR);
            Jeton jetonjoueurJ = new Jeton("J");
            ListeJoueurs[1].ajouterJeton(jetonjoueurJ);
        }else{
            Jeton jetonjoueurR = new Jeton("R");
            ListeJoueurs[1].ajouterJeton(jetonjoueurR);
            Jeton jetonjoueurJ = new Jeton("J");
            ListeJoueurs[0].ajouterJeton(jetonjoueurJ);
        }
    }
}
    
public void debuterPartie(){
    initialiserPartie();
    while((grilleJeu.etreGagnantePourJoueur(ListeJoueurs[0])!=true) && (grilleJeu.etreGagnantePourJoueur(ListeJoueurs[1])!=true) && (grilleJeu.etreRemplie()!=true)){
        //afficher la grille
        grilleJeu.afficherGrilleSurConsole();
        
        //demander au joueur ce qu'il veut faire
        Scanner sc = new Scanner(System.in);
        System.out.println(joueurCourant.Nom+" C'est à vous de jouer! Que voulez-vous faire: ");
        System.out.println("(Vous disposez de "+joueurCourant.nombreJetonsRestant+" jetons et de "+joueurCourant.nombreDesintegrateurs+" désintérateur(s) )");
        System.out.println("1) Placer un jeton");
        System.out.println("2) Récupérer un jeton");
        System.out.println("3) Utiliser un désintégrateur");
        int saisie = sc.nextInt();
        while (saisie>3 || saisie<=0){
                System.out.println("ERREUR: Veuillez ressaisir un choix compris entre 1 et 3:");
                saisie = sc.nextInt();
        }
        if (saisie==1){
           //placer un jeton dans une colonne
            Scanner s = new Scanner(System.in);
            System.out.println("Sélectionnez un numéro de colone:");
            int colonne = s.nextInt()-1;
            while (colonne>6 || colonne<0){
                System.out.println("ERREUR: Veuillez ressaisir un numéro de colone correct:");
                colonne = s.nextInt()-1;
            }
            while(grilleJeu.colonneRemplie(colonne)==true){
                System.out.println("ERREUR: La colonne est remplie, veuillez en choisir une autre:");
                colonne = s.nextInt()-1;   
            }
            grilleJeu.ajouterJetonDansColonne(joueurCourant, colonne); 
            joueurCourant.nombreJetonsRestant=joueurCourant.nombreJetonsRestant-1;
            System.out.println("(Vous disposez de "+joueurCourant.nombreJetonsRestant+" jetons et de "+joueurCourant.nombreDesintegrateurs+" désintérateur(s) )");
        }
        
        
        if (saisie==2){
            //récupérer un jeton de la grille de jeu
            Scanner recupL = new Scanner(System.in);
            System.out.println("Sélectionnez les coordonnées du jeton:");
            System.out.println("Sélectionnez un numéro de ligne:");
            int ligne = recupL.nextInt()-1;
            while (ligne>5 || ligne<0){
                System.out.println("ERREUR: Veuillez ressaisir un numéro de ligne correct:");
                ligne = recupL.nextInt()-1;
            }
            Scanner recupC = new Scanner(System.in);
            System.out.println("Sélectionnez un numéro de colonne:");
            int colonne = recupC.nextInt()-1;
            while (colonne>6 || colonne<0){
                System.out.println("ERREUR: Veuillez ressaisir un numéro de colonne correct:");
                colonne = recupC.nextInt()-1;
            }
            
            if (grilleJeu.recupererJeton(ligne,colonne)==null || !(grilleJeu.recupererJeton(ligne,colonne).couleur.equals(joueurCourant.Couleur))){
                System.out.println("Vous n'avez aucun jeton à récupérer ici, vous avez perdu un tour...");
            }else{
                joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestant]=grilleJeu.recupererJeton(ligne,colonne);
                joueurCourant.nombreJetonsRestant+=1;
                grilleJeu.tasserGrille();
            }  
        }
        
        if (saisie==3 && (joueurCourant.nombreDesintegrateurs!=0)){
            //utiliser un desintégrateur
            Scanner desinL = new Scanner(System.in);
            System.out.println("Sélectionnez les coordonnées du jeton:");
            System.out.println("Sélectionnez un numéro de ligne:");
            int ligne = desinL.nextInt()-1;
            while (ligne>5 || ligne<=0){
                System.out.println("ERREUR: Veuillez ressaisir un numéro de ligne correct:");
                ligne = desinL.nextInt()-1;
            }
            Scanner desinC = new Scanner(System.in);
            System.out.println("Sélectionnez un numéro de colonne:");
            int colonne = desinC.nextInt()-1;
            while (colonne>6 || colonne<=0){
                System.out.println("ERREUR: Veuillez ressaisir un numéro de colonne correct:");
                colonne = desinC.nextInt()-1;
            joueurCourant.utiliserDesintegrateur();
            grilleJeu.supprimerJeton(ligne,colonne);
            grilleJeu.tasserGrille();
            }
        }
        if (saisie==3 && (joueurCourant.nombreDesintegrateurs==0)){
            System.out.println("ERREUR: Vous n'avez pas de désintégrateur à utiliser");
            System.out.println("Rechoississez ce que vous voulez faire: 1)Placer un jeton ou 2)Récupérer un jeton");
            saisie = sc.nextInt();
            while (saisie>2 || saisie<=0){
                System.out.println("ERREUR: Veuillez ressaisir un choix compris entre 1 et 2:");
                saisie = sc.nextInt();
            }
        }
        if (joueurCourant==ListeJoueurs[0]){
            joueurCourant=ListeJoueurs[1];
        }
        else{
            joueurCourant=ListeJoueurs[0];
        }

    }
    if(grilleJeu.etreGagnantePourJoueur(ListeJoueurs[0])==true){
        System.out.println(ListeJoueurs[0].Nom+" est le gagnant!BRAVO");
    }
    if(grilleJeu.etreGagnantePourJoueur(ListeJoueurs[1])==true){
        System.out.println(ListeJoueurs[1].Nom+" est le gagnant!BRAVO");
    }
    if(grilleJeu.etreRemplie()==true){
        System.out.println("La partie est terminée car la grille est pleine, il n'y a pas de gagnant");
    }
}
}
