import java.util.*;
/**
 * Cette classe regroupe les parties g�n�ralisables entre tous les sch�mas possibles
 *
 * @author  GASTINEAU Arthur
 * @version v0.2
 */
public class SchemaGenerique
{
    // les variables d'instance sont des tableaux dynamiques contenant les �l�ments du sch�ma
    protected Vector<Entree> Entrees;
    protected Vector<Sortie> Sorties;
    protected Vector<Fil> Fils;
    protected Vector<Circuit> Circuits;

    /**
     * Constructeur SchemaGenerique permettant la d�claration des tableaux qui vont contenir les �lements du sch�ma
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
     * M�thode getNbENtrees permettant de r�cup�rer le nombre d'entr�es du sch�ma
     * 
     * @param (aucun)
     * @return (int) le nombre d'entr�es du sch�ma
     */
    public int getNbEntrees()
    {
        //retourne la taille du tableau Entrees soit le nombre d'entr�es du sch�ma
        return Entrees.size();
    }
    
    /**
     * M�thode setStimuli affecte une valeur sur chacune des entr�es du sch�ma - Version � 2 entr�es
     * 
     * @param (int []) les valeurs des stimulus appliqu�s � chaque entr�e
     * @return (aucun)
     */
    public void setStimuli(int [] valeurs) {
        //on modifie la valeur actuelle de chaque fil en entr�e du circuit en fonction du tableau en entr�e de la m�thode
        for (int id_entree=0; id_entree < Entrees.size(); id_entree++)
        {
            Entrees.get(id_entree).setValeur(valeurs[id_entree]);
        }
    }

    /**
     * M�thode getEntreeString permettant de r�cup�rer (sous forme texte) les valeurs pr�sentes en entr�e 
     * 
     * @param (aucun)
     * @return (String) les valeurs pr�sentes en entr�e 
     */
    public String getEntreeString() {
        String s = "";
        //� l'aide de la fonction concat on ajoute � une chaine de caract�re vide l'�tat de chaque entr�e du sch�ma
        for (int id_entree=0; id_entree < Entrees.size(); id_entree++)
        {
            s = s.concat(Entrees.get(id_entree).toString());
        }
        return s;
    }
    
    /**
     * M�thode getSortie permettant de r�cup�rer les valeurs pr�sente en sortie du sch�ma - Version � plusieurs entr�es
     * 
     * @param (aucun)
     * @return (int []) les valeurs pr�sentent en sortie
     */
    public int[] getSortie() {
        // on d�clare un tableau de tailel correspondant aux nombre de sortie
        int [] vals = new int [Sorties.size()];
        // pour chaque sortie on r�cup�re sa valeur actuelle et on l'affecte � la case du tableau correspondante
        for (int id_sortie = 0; id_sortie < Sorties.size(); id_sortie++)
        {
            vals[id_sortie] = Sorties.get(id_sortie).getValeur();
        }
        return vals;
    }

    /**
     * M�thode getSortieString permettant de r�cup�rer (sous forme texte) les valeurs pr�sente en sortie 
     * 
     * @param (aucun)
     * @return (String) les valeur pr�sentent en sortie
     */
    public String getSortieString() {
        // on d�clare une cha�ne de caract�re vide
        String s = "";
        // on ajoute � la cha�ne de caract�re les valeurs en sortie si elle n'ets pas d�fini on ajoute "inconnu"
        for (int id_sortie=0; id_sortie < Sorties.size(); id_sortie++)
        {
            if (Sorties.get(id_sortie).getValeur() == Fil.X) s = s.concat(" - inconnu ");
            else s = s.concat(Sorties.get(id_sortie).toString());
        }
        return s;
    }

    /**
     * M�thode calculeUnPas permettant de r�aliser un pas de simulation dans le sch�ma
     * 
     * @param (aucun)
     * @return (aucun)
     */
    public void calculeUnPas() {
        // on propage linformation sur tous les fils du sch�ma
        for (int id_fil=0; id_fil < Fils.size(); id_fil++)
        {
            Fils.get(id_fil).propager();
        }
        // on effectue toutes les op�rations logiques possibles des circuits du sch�ma
        for (int id_circuit=0; id_circuit < Circuits.size(); id_circuit++)
        {
            Circuits.get(id_circuit).calculer();
        }
        // on affiche l'�tat actuelle de tous les fils
        AffichageEtatsFils();
    }
    
    /**
     * M�thode AffichageEtatsFils permettant l'affichage des Etats Actuelle de tous les fils
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
