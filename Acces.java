/**
 * Cette classe réalise un accès du simulateur
 * 
 * @author GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.0
 */
//hérité de generique
public abstract class Acces extends Generique 
{
    // déclaration de variable d'instance représentant sa liaison
    protected Fil ficelle;
    // constantes pour se faciliter l'écriture
    public static final int ENTREE = 0;
    public static final int SORTIE = 1;

    /**
     * Constructeur avec le nom en paramètre d'appel
     * 
     * @param (String) le nom souhaité
     */
    public Acces(String s)
    {
        // on affecte à l'accès le nom souhaité à l'aide la méthode héritée et on initialisé l'attribut partagé pour signifier qu'il n'a pas de liaison
        setNom(s);
        ficelle = null;
    }

    /**
     * Constructeur avec  nom et fil associé
     * 
     * @param (String) le nom souhaité
     * @param (Fil) le fil associé
     */
    public Acces(String s,Fil f)
    {
        // on affecte à l'accès le nom souhaité à l'aide la méthode héritée et on initialise l' attribut partagé avec le fil en paramètre
        setNom(s);
        ficelle = f;
    }    

    /**
     * Méthode abstraite  qui permet de lire le sens et devra être implémenté dnas les classes filles
     * 
     * @param  (aucun)
     * @return  (int) le sens de l'accès
     */
    public abstract int getSens();
}
