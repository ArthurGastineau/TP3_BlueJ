
/**
 * Cette classe abstraite permet de d�finir qu'un circuit est constitu� d'au moins deux fils :
 * un en entr�e du circuit, l'autre ne sortie
 *
 * @author  GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.1
 */
//h�rit� de Generique
public abstract class Circuit extends Generique 
{
    // d�claration des variables d'instance communes � tous les circuits
    protected Fil fentree;
    protected Fil fsortie;

    /**
     * Constructeur de la classe Circuit
     *
     * @param (Fil) 1e fil en entr�e du circuit
     * @param (Fil) 1e fil en sortie du circuit
     */
    public Circuit(Fil fentree, Fil fsortie)
    {
        // initialisation des variables d'instance
        this.fentree = fentree;
        this.fsortie = fsortie;
    }

    /**
     * M�thode abstraite calculer qui sera d�finit par les classes filles permettant de d�terminer
     * l��tat de sortie d�une porte logique en fonction des stimulis appliqu�s en entr�es de la porte
     */
    abstract public void calculer();
}
