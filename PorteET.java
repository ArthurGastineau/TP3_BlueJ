
/**
 * Cette classe permet la modélisation de la porte logique ET
 *
 * @author GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.1
 */
//hérité de Circuit
public class PorteET extends Circuit
{
    // déclaration de la variable d'instane modélisant le 2e fil en entrée
    private Fil fentree2;

   /**
     * Constructeur d'objets de classe PorteET
     * 
     * @param (Fil) le fil relié à la 1e entrée
     * @param (Fil) le fil relié à la 2e entrée
     * @param (Fil) le fil relié à la sortie
     */
    public PorteET(Fil fentree1,Fil fentree2,Fil fsortie1)
    {
        // invocation du constructeur de la classe parent Circuit
        super(fentree1,fsortie1);
        // initialisation de la variable d'instance
        this.fentree2 = fentree2;
    }

    /**
     * Méthode calculer permettant d'effectuer l'opération logique ET aux fils en entrée et d'affecter le résultat en sortie
     *
     * @param (aucun)
     * @return (aucun)
     */
    public void calculer()
    {
        // Si les deux fils sont bien défini alors on affecte au fil en sortie le résultat de l'opération logique ET
        if (fentree.getValeurActuelle() != fentree.X && fentree2.getValeurActuelle() != fentree2.X)
        {
            fsortie.setValeur(fentree.getValeurActuelle() & fentree2.getValeurActuelle());
        }
        // Autrement si l'un des deux fils est à 0 alors on affecte à la sortie la valeur 0
        else if (fentree.getValeurActuelle() == fentree.ZERO || fentree2.getValeurActuelle() == fentree2.ZERO) fsortie.setValeur(fsortie.ZERO);
        // Autrement on affecte l'état du fil en sortie comme indéfini
        else fsortie.setValeur(fsortie.X);
    }
    
    /**
     * Méthode toString permettant de retourner un texte représentant l'opération logique effectuée
     *
     * @param  (aucun)
     * @return  (String) le texte décrivant l'opération logique ET
     */
    public String toString()
    {
        return fentree.getValeurActuelle() + " <ET> " + fentree2.getValeurActuelle() + " => " + fsortie.getValeurFuture();
    }
}
