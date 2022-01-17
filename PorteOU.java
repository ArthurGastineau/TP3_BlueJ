
/**
 * Cette classe permet la mod�lisation de la porte logique OU
 *
 * @author GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.1
 */
//h�rit� de Circuit
public class PorteOU extends Circuit
{
    // d�claration de la variable d'instane mod�lisant le 2e fil en entr�e
    private Fil fentree2;

    /**
     * Constructeur d'objets de classe PorteOU avec nom non-d�fini
     * 
     * @param (Fil) le fil reli� � la 1e entr�e
     * @param (Fil) le fil reli� � la 2e entr�e
     * @param (Fil) le fil reli� � la sortie
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
     * @param (Fil) le fil reli� � la 1e entr�e
     * @param (Fil) le fil reli� � la 2e entr�e
     * @param (Fil) le fil reli� � la sortie
     */
    public PorteOU(String s,Fil fentree1,Fil fentree2,Fil fsortie1)
    {
        // invocation du constructeur de la classe parent Circuit
        super(s,fentree1,fsortie1);
        // initialisation de la variable d'instance
        this.fentree2 = fentree2;
    }

    /**
     * M�thode calculer permettant d'effectuer l'op�ration logique OU aux fils en entr�e et d'affecter le r�sultat en sortie
     *
     * @param (aucun)
     * @return (aucun)
     */
    public void calculer()
    {
        // Si un des fils en entr�e est � 1 alors on affecte au fil en sortie la valeur future 1
        if (fentree.getValeurActuelle() == fentree.UN || fentree2.getValeurActuelle() == fentree2.UN)
        {
            fsortie.setValeur(fsortie.UN);
        }
        // Autrement si les deux sont � z�ro alors on affecte au fil en sortie la valeur future 0
        else if (fentree.getValeurActuelle() == fentree.ZERO && fentree2.getValeurActuelle() == fentree2.ZERO) 
        {
            fsortie.setValeur(fsortie.ZERO);
        }
        // Autrement l'tat en sortie est ind�fini
        else fsortie.setValeur(fsortie.X);
    }
    
    /**
     * M�thode toString permettant de retourner un texte repr�sentant l'op�ration logique effectu�e
     *
     * @param  (aucun)
     * @return  (String) le texte d�crivant l'op�ration logique OU
     */
    public String toString()
    {
        return fentree.getValeurActuelle() + " <OU> " + fentree2.getValeurActuelle() + " => " + fsortie.getValeurFuture();
    }
}
