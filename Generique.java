
/**
 * Cette classe permet la g�n�ralisation des classes Acc�s et Fil
 * 
 * @author GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.1
 */

public abstract class Generique
{
    // d�claration de la variable d'instanciation commune qui est le nom
    private String nom;

    /**
     * Constructeur de la classe Generique - version anonyme
     */
    public Generique()
    {
        nom = "???";
    }

    /**
     * Constructeur de la classe Generique - version nomm�e
     * 
     * @param (String) nom souhait�
     */
    public Generique(String s)
    {
        nom = s;
    }

    /**
     * M�thode getNom permettant de r�cup�rer l'attribut nom 
     * 
     * @param  (aucun)
     * @return  (String) le nom de l'acc�s
     */
    public String getNom()
    {
        return nom;
    }
    
    /**
     * M�thode setNom permettant de modifier l'attribut nom
     * 
     * @param  (String) le nom affect�
     * @return  (aucun) 
     */
    public void setNom(String s)
    {
        nom = s;
    }

    /**
     * M�thode abstraite toString permettant de r�cup�rer l'�tat sous forme d'une string
     * 
     * @return  (String) le texte d�crivant la valeur logique pr�sente sur l'�l�ment
     */
    public abstract String toString();
}
