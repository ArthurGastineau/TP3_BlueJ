
/**
 * Cette classe permet la modélisation de la porte logique OU
 *
 * @author GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.1
 */
//hérité de Circuit
public class PorteOU extends Circuit
{
    // déclaration de la variable d'instane modélisant le 2e fil en entrée
    private Fil fentree2;

    /**
     * Constructeur d'objets de classe PorteOU avec nom non-défini
     * 
     * @param (Fil) le fil relié à la 1e entrée
     * @param (Fil) le fil relié à la 2e entrée
     * @param (Fil) le fil relié à la sortie
     */
    public PorteOU(Fil fentree1,Fil fentree2,Fil fsortie1)
    {
        // invocation du constructeur de la classe parent Circuit
        super(fentree1,fsortie1);
        // initialisation de la variable d'instance
        this.fentree2 = fentree2;
    }
    
    /**
     * Constructeur d'objets de classe PorteOU modifiant le nom
     * 
     * @param (String) le nom du circuit
     * @param (Fil) le fil relié à la 1e entrée
     * @param (Fil) le fil relié à la 2e entrée
     * @param (Fil) le fil relié à la sortie
     */
    public PorteOU(String s,Fil fentree1,Fil fentree2,Fil fsortie1)
    {
        // invocation du constructeur de la classe parent Circuit
        super(s,fentree1,fsortie1);
        // initialisation de la variable d'instance
        this.fentree2 = fentree2;
    }

    /**
     * Méthode calculer permettant d'effectuer l'opération logique OU aux fils en entrée et d'affecter le résultat en sortie
     *
     * @param (aucun)
     * @return (aucun)
     */
    public void calculer()
    {
        // Si un des fils en entrée est à 1 alors on affecte au fil en sortie la valeur future 1
        if (fentree.getValeurActuelle() == fentree.UN || fentree2.getValeurActuelle() == fentree2.UN)
        {
            fsortie.setValeur(fsortie.UN);
        }
        // Autrement si les deux sont à zéro alors on affecte au fil en sortie la valeur future 0
        else if (fentree.getValeurActuelle() == fentree.ZERO && fentree2.getValeurActuelle() == fentree2.ZERO) 
        {
            fsortie.setValeur(fsortie.ZERO);
        }
        // Autrement l'tat en sortie est indéfini
        else fsortie.setValeur(fsortie.X);
    }
    
    /**
     * Méthode toString permettant de retourner un texte représentant l'opération logique effectuée
     *
     * @param  (aucun)
     * @return  (String) le texte décrivant l'opération logique OU
     */
    public String toString()
    {
        return fentree.getValeurActuelle() + " <OU> " + fentree2.getValeurActuelle() + " => " + fsortie.getValeurFuture();
    }
}
