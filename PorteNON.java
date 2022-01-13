
/**
 * Cette classe permet la mod�lisation de la porte logique NON
 *
 * @author GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.1
 */

// h�rit� de Circuit
public class PorteNON extends Circuit
{
    /**
     * Constructeur d'objets de classe PorteNON
     * 
     * @param (Fil) le fil en entr�e
     * @param (Fil) le fil en sortie
     */
    public PorteNON(Fil fentree1,Fil fsortie1)
    {
        // invocation du constructeur de la classe parent Circuit
        super(fentree1,fsortie1);
    }

    /**
     * M�thode calculer permettant d'effectuer l'op�ration logique NON au fil en entr�e et d'affecter le r�sultat en sortie
     *
     * @param (aucun)
     * @return (aucun)
     */
    public void calculer()
    {
        // On s'assure que le fil en entr�e a une valeur actuelle d�finie
        if (fentree.getValeurActuelle() != fentree.X)
        {
            // On affecte au fil en sortie comme ValeurFuture le r�sultat de l'op�ration NON sur le fil en entr�e
            if (fentree.getValeurActuelle() == fentree.UN) fsortie.setValeur(fentree.ZERO);
            if (fentree.getValeurActuelle() == fentree.ZERO) fsortie.setValeur(fentree.UN);
        }
    }
    /**
     * M�thode toString permettant de retourner un texte repr�sentant l'op�ration logique effectu�e
     *
     * @param  (aucun)
     * @return  (String) le texte d�crivant l'op�ration logique NON
     */
    public String toString()
    {
        return " <NON> " + fentree.getValeurActuelle() + " => " + fsortie.getValeurFuture();
    }
}