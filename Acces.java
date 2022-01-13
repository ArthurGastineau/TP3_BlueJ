/**
 * Cette classe r�alise un acc�s du simulateur
 * 
 * @author GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.0
 */
//h�rit� de generique
public abstract class Acces extends Generique 
{
    // d�claration de variable d'instance repr�sentant sa liaison
    protected Fil ficelle;
    // constantes pour se faciliter l'�criture
    public static final int ENTREE = 0;
    public static final int SORTIE = 1;

    /**
     * Constructeur avec le nom en param�tre d'appel
     * 
     * @param (String) le nom souhait�
     */
    public Acces(String s)
    {
        // on affecte � l'acc�s le nom souhait� � l'aide la m�thode h�rit�e et on initialis� l'attribut partag� pour signifier qu'il n'a pas de liaison
        setNom(s);
        ficelle = null;
    }

    /**
     * Constructeur avec  nom et fil associ�
     * 
     * @param (String) le nom souhait�
     * @param (Fil) le fil associ�
     */
    public Acces(String s,Fil f)
    {
        // on affecte � l'acc�s le nom souhait� � l'aide la m�thode h�rit�e et on initialise l' attribut partag� avec le fil en param�tre
        setNom(s);
        ficelle = f;
    }    

    /**
     * M�thode abstraite  qui permet de lire le sens et devra �tre impl�ment� dnas les classes filles
     * 
     * @param  (aucun)
     * @return  (int) le sens de l'acc�s
     */
    public abstract int getSens();
}
