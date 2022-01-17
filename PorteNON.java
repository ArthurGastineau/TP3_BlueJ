
/**
 * Cette classe permet la modélisation de la porte logique NON
 *
 * @author GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.1
 */

// hérité de Circuit
public class PorteNON extends Circuit
{
    /**
     * Constructeur d'objets de classe PorteNON avec nom non-défin
     * 
     * @param (Fil) le fil en entrée
     * @param (Fil) le fil en sortie
     */
    public PorteNON(Fil fentree1,Fil fsortie1)
    {
        // invocation du constructeur de la classe parent Circuit
        super(fentree1,fsortie1);
    }
    
    /**
     * Constructeur d'objets de classe PorteNON modifiant le nom
     * 
     * @param (String) le nom du cricuit
     * @param (Fil) le fil en entrée
     * @param (Fil) le fil en sortie
     */
    public PorteNON(String s,Fil fentree1,Fil fsortie1)
    {
        // invocation du constructeur de la classe parent Circuit
        super(s,fentree1,fsortie1);
    }

    /**
     * Méthode calculer permettant d'effectuer l'opération logique NON au fil en entrée et d'affecter le résultat en sortie
     *
     * @param (aucun)
     * @return (aucun)
     */
    public void calculer()
    {
        // On s'assure que le fil en entrée a une valeur actuelle définie
        if (fentree.getValeurActuelle() != fentree.X)
        {
            // On affecte au fil en sortie comme ValeurFuture le résultat de l'opération NON sur le fil en entrée
            if (fentree.getValeurActuelle() == fentree.UN) fsortie.setValeur(fsortie.ZERO);
            if (fentree.getValeurActuelle() == fentree.ZERO) fsortie.setValeur(fsortie.UN);
        }
        // Autrement on définit la valeur du fil en sortie comme indéfini
        else fsortie.setValeur(fsortie.X);
    }
    /**
     * Méthode toString permettant de retourner un texte représentant l'opération logique effectuée
     *
     * @param  (aucun)
     * @return  (String) le texte décrivant l'opération logique NON
     */
    public String toString()
    {
        return " <NON> " + fentree.getValeurActuelle() + " => " + fsortie.getValeurFuture();
    }
}
