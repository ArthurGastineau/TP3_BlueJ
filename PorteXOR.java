
/**
 * Cette classe permet la mod�lisation de la porte logique OU Exclusif
 *
 * @author GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.1
 */
//h�rit� de Circuit
public class PorteXOR extends Circuit
{
    // d�claration des variables d'instance mod�lisant le 2e fil en entr�e
    private Fil fentree2;

    /**
     * Constructeur d'objets de classe PorteXOR avec nom non-d�fini
     * 
     * @param (Fil) le fil reli� � la 1e entr�e
     * @param (Fil) le fil reli� � la 2e entr�e
     * @param (Fil) le fil reli� � la 1e sortie
     */
    public PorteXOR(Fil fentree1, Fil fentree2, Fil fsortie1)
    {
        // invocation du constructeur de la classe parent Circuit
        super(fentree1,fsortie1);
        // initialisation de la variable d'instance
        this.fentree2 = fentree2;
    }
    
    /**
     * Constructeur d'objets de classe PorteXOR modifiant le nom
     * 
     * @param (String) le nom du circuit
     * @param (Fil) le fil reli� � la 1e entr�e
     * @param (Fil) le fil reli� � la 2e entr�e
     * @param (Fil) le fil reli� � la 1e sortie
     */
    public PorteXOR(String s,Fil fentree1, Fil fentree2, Fil fsortie1)
    {
        // invocation du constructeur de la classe parent Circuit
        super(s,fentree1,fsortie1);
        // initialisation de la variable d'instance
        this.fentree2 = fentree2;
    }

    /**
     * M�thode calculer permettant d'effectuer l'op�ration logique XOR aux fils en entr�e et d'affecter le r�sultat en sortie
     *
     * @param (aucun)
     * @return (aucun)
     */
    public void calculer()
    {
        // Si les l'�tat des 2 fils en entr�e sont d�finis, on affecte en sortie le r�sultat de l'op�ration logique
        if (fentree.getValeurActuelle() != fentree.X && fentree2.getValeurActuelle() != fentree2.X)
        {
            fsortie.setValeur(fentree.getValeurActuelle() ^ fentree2.getValeurActuelle());  
        }
        // Autrement on d�finit l'�tat du fil e nsortie comme ind�fini
        else fsortie.setValeur(fsortie.X);
    }
    
    /**
     * M�thode toString permettant de retourner un texte repr�sentant l'op�ration logique effectu�e
     *
     * @param  (aucun)
     * @return  (String) le texte d�crivant l'op�ration logique OU exclusif
     */
    public String toString()
    {
        return fentree.getValeurActuelle() + " <XOR> " + fentree2.getValeurActuelle() + " => " + fsortie.getValeurFuture();
    }
}
