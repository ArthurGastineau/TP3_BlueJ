
/**
 * Cette classe permet la mod�lisation de la porte logique ET
 *
 * @author GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.1
 */
//h�rit� de Circuit
public class PorteET extends Circuit
{
    // d�claration de la variable d'instane mod�lisant le 2e fil en entr�e
    private Fil fentree2;

   /**
     * Constructeur d'objets de classe PorteET
     * 
     * @param (Fil) le fil reli� � la 1e entr�e
     * @param (Fil) le fil reli� � la 2e entr�e
     * @param (Fil) le fil reli� � la sortie
     */
    public PorteET(Fil fentree1,Fil fentree2,Fil fsortie1)
    {
        // invocation du constructeur de la classe parent Circuit
        super(fentree1,fsortie1);
        // initialisation de la variable d'instance
        this.fentree2 = fentree2;
    }

    /**
     * M�thode calculer permettant d'effectuer l'op�ration logique ET aux fils en entr�e et d'affecter le r�sultat en sortie
     *
     * @param (aucun)
     * @return (aucun)
     */
    public void calculer()
    {
        // Si les deux fils sont bien d�fini alors on affecte au fil en sortie le r�sultat de l'op�ration logique ET
        if (fentree.getValeurActuelle() != fentree.X && fentree2.getValeurActuelle() != fentree2.X)
        {
            fsortie.setValeur(fentree.getValeurActuelle() & fentree2.getValeurActuelle());
        }
        // Autrement si l'un des deux fils est � 0 alors on affecte � la sortie la valeur 0
        else if (fentree.getValeurActuelle() == fentree.ZERO || fentree2.getValeurActuelle() == fentree2.ZERO) fsortie.setValeur(fsortie.ZERO);
        // Autrement on affecte l'�tat du fil en sortie comme ind�fini
        else fsortie.setValeur(fsortie.X);
    }
    
    /**
     * M�thode toString permettant de retourner un texte repr�sentant l'op�ration logique effectu�e
     *
     * @param  (aucun)
     * @return  (String) le texte d�crivant l'op�ration logique ET
     */
    public String toString()
    {
        return fentree.getValeurActuelle() + " <ET> " + fentree2.getValeurActuelle() + " => " + fsortie.getValeurFuture();
    }
}
