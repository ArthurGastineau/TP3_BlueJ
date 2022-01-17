
/**
 * Cette classe abstraite permet de définir qu'un circuit est constitué d'au moins deux fils :
 * un en entrée du cicruit, l'autre ne sortie
 *
 * @author  GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.1
 */
//hérité de Generique
public abstract class Circuit extends Generique 
{
    // déclaration des variables d'instance communes à tous les circuits
    protected Fil fentree;
    protected Fil fsortie;

    /**
     * Constructeur de la classe Circuit en modifiant son nom
     *
     * @param (Fil) 1e fil en entrée du circuit
     * @param (Fil) 1e fil en sortie du circuit
     */
    public Circuit(String s,Fil fentree, Fil fsortie)
    {
        // invocation du constructeur de la classe parent Generique
        super(s);
        // initialisation des variables d'instance
        this.fentree = fentree;
        this.fsortie = fsortie;
    }
    
    /**
     * Constructeur de la classe Circuit avec nom non-défini
     *
     * @param (Fil) 1e fil en entrée du circuit
     * @param (Fil) 1e fil en sortie du circuit
     */
    public Circuit(Fil fentree, Fil fsortie)
    {
        // invocation du constructeur de la classe parent Generique
        super();
        // initialisation des variables d'instance
        this.fentree = fentree;
        this.fsortie = fsortie;
    }

    /**
     * Méthode abstraite calculer qui sera définit par les classes filles permettant de déterminer
     * l’état de sortie d’une porte logique en fonction des stimulis appliqués en entrées de la porte
     */
    abstract public void calculer();
}