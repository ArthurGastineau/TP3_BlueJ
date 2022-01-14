import java.util.*;
/**
 * Cette classe regroupe les parties généralisables entre tous les schémas possibles
 *
 * @author  GASTINEAU Arthur
 * @version v0.2
 */
public class SchemaGenerique
{
    // les variables d'instance sont des tableaux dynamiques contenant les éléments du schéma
    protected Vector<Entree> Entrees;
    protected Vector<Sortie> Sorties;
    protected Vector<Fil> Fils;
    protected Vector<Circuit> Circuits;

    /**
     * Constructeur SchemaGenerique permettant la déclaration des tableaux qui vont contenir les élements du schéma
     */
    public SchemaGenerique()
    {
        // initialisation des variables d'instance
        Entrees = new Vector <Entree>();
        Sorties = new Vector <Sortie>();
        Fils = new Vector <Fil>();
        Circuits = new Vector <Circuit>();       
    }
    /**
     * Méthode getNbENtrees permettant de récupérer le nombre d'entrées du schéma
     * 
     * @param (aucun)
     * @return (int) le nombre d'entrées du schéma
     */
    public int getNbEntrees()
    {
        //retourne la taille du tableau Entrees soit le nombre d'entrées du schéma
        return Entrees.size();
    }
    
    /**
     * Méthode setStimuli affecte une valeur sur chacune des entrées du schéma - Version à 2 entrées
     * 
     * @param (int []) les valeurs des stimulus appliqués à chaque entrée
     * @return (aucun)
     */
    public void setStimuli(int [] valeurs) {
        //on modifie la valeur actuelle de chaque fil en entrée du circuit en fonction du tableau en entrée de la méthode
        for (int id_entree=0; id_entree < Entrees.size(); id_entree++)
        {
            Entrees.get(id_entree).setValeur(valeurs[id_entree]);
        }
    }

    /**
     * Méthode getEntreeString permettant de récupérer (sous forme texte) les valeurs présentes en entrée 
     * 
     * @param (aucun)
     * @return (String) les valeurs présentes en entrée 
     */
    public String getEntreeString() {
        String s = "";
        //à l'aide de la fonction concat on ajoute à une chaine de caractère vide l'état de chaque entrée du schéma
        for (int id_entree=0; id_entree < Entrees.size(); id_entree++)
        {
            s = s.concat(Entrees.get(id_entree).toString());
        }
        return s;
    }
    
    /**
     * Méthode getSortie permettant de récupérer les valeurs présente en sortie du schéma - Version à plusieurs entrées
     * 
     * @param (aucun)
     * @return (int []) les valeurs présentent en sortie
     */
    public int[] getSortie() {
        // on déclare un tableau de tailel correspondant aux nombre de sortie
        int [] vals = new int [Sorties.size()];
        // pour chaque sortie on récupère sa valeur actuelle et on l'affecte à la case du tableau correspondante
        for (int id_sortie = 0; id_sortie < Sorties.size(); id_sortie++)
        {
            vals[id_sortie] = Sorties.get(id_sortie).getValeur();
        }
        return vals;
    }

    /**
     * Méthode getSortieString permettant de récupérer (sous forme texte) les valeurs présente en sortie 
     * 
     * @param (aucun)
     * @return (String) les valeur présentent en sortie
     */
    public String getSortieString() {
        // on déclare une chaîne de caractère vide
        String s = "";
        // on ajoute à la chaîne de caractère les valeurs en sortie si elle n'ets pas défini on ajoute "inconnu"
        for (int id_sortie=0; id_sortie < Sorties.size(); id_sortie++)
        {
            if (Sorties.get(id_sortie).getValeur() == Fil.X) s = s.concat(" - inconnu ");
            else s = s.concat(Sorties.get(id_sortie).toString());
        }
        return s;
    }

    /**
     * Méthode calculeUnPas permettant de réaliser un pas de simulation dans le schéma
     * 
     * @param (aucun)
     * @return (aucun)
     */
    public void calculeUnPas() {
        // on propage linformation sur tous les fils du schéma
        for (int id_fil=0; id_fil < Fils.size(); id_fil++)
        {
            Fils.get(id_fil).propager();
        }
        // on effectue toutes les opérations logiques possibles des circuits du schéma
        for (int id_circuit=0; id_circuit < Circuits.size(); id_circuit++)
        {
            Circuits.get(id_circuit).calculer();
        }
        // on affiche l'état actuelle de tous les fils
        AffichageEtatsFils();
    }
    
    /**
     * Méthode AffichageEtatsFils permettant l'affichage des Etats Actuelle de tous les fils
     * 
     * @param (aucun)
     * @return (aucun)
     */
    public void AffichageEtatsFils(){
        System.out.println("Etat actuel des fils :");
        // on affiche le nom et la valeur actuelle de chaque fil
        for (int id_fil=0; id_fil < Fils.size(); id_fil++)
        {
            System.out.print(Fils.get(id_fil).getNom() + " : " + Fils.get(id_fil).toString() + " ; ");
        }
        System.out.println();
    }

}
