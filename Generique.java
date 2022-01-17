
/**
 * Cette classe permet la généralisation des classes Accès et Fil
 * 
 * @author GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.1
 */

public abstract class Generique
{
    // déclaration de la variable d'instanciation commune qui est le nom
    private String nom;

    /**
     * Constructeur de la classe Generique - version anonyme
     */
    public Generique()
    {
        nom = "???";
    }

    /**
     * Constructeur de la classe Generique - version nommée
     * 
     * @param (String) nom souhaité
     */
    public Generique(String s)
    {
        nom = s;
    }

    /**
     * Méthode getNom permettant de récupérer l'attribut nom 
     * 
     * @param  (aucun)
     * @return  (String) le nom de l'accès
     */
    public String getNom()
    {
        return nom;
    }
    
    /**
     * Méthode setNom permettant de modifier l'attribut nom
     * 
     * @param  (String) le nom affecté
     * @return  (aucun) 
     */
    public void setNom(String s)
    {
        nom = s;
    }

    /**
     * Méthode abstraite toString permettant de récupérer l'état sous forme d'une string
     * 
     * @return  (String) le texte décrivant la valeur logique présente sur l'élément
     */
    public abstract String toString();
}
