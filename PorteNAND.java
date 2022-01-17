 /**
 * Cette classe permet de d�finir et simuler une porte NAND.
 *
 * @author (LAMOUR Guillaume & GASTINEAU Arthur)
 * @version (15/01/2022)
 */
public class PorteNAND extends Circuit
{
    // variables d'instance - remplacez l'exemple qui suit par le v�tre
    private Fil fentree2;

    /**
     * Constructeur d'objets de classe Porte NAND avec nom non d�fini
     * 
     * @param (Fil) le fil reli� � la 1e entr�e
     * @param (Fil) le fil reli� � la 2e entr�e
     * @param (Fil) le fil reli� � la sortie
     */
    public PorteNAND(Fil fentree, Fil fentree2, Fil fsortie)
    {
        // initialisation des variables d'instance
        super(fentree, fsortie);
        this.fentree2 = fentree2;
    }
    
    /*
     * Constructeur d'objets de classe Porte NAND avec nom modifi�
     * 
     * @param (String) le nom du Circuit
     * @param (Fil) le fil reli� � la 1e entr�e
     * @param (Fil) le fil reli� � la 2e entr�e
     * @param (Fil) le fil reli� � la sortie
     */
    public PorteNAND(String s, Fil fentree, Fil fentree2, Fil fsortie)
    {
        // initialisation des variables d'instance
        super(s, fentree, fsortie);
        this.fentree2 = fentree2;
    }

    /**
     * M�thode calculer : permet de calculer l'�tat de sortie fsortie
     * d'une porte NAND � partie des �tats d'entr�es fentree et fentree2
     *
     */
    public void calculer()
    {
        if(fentree.getValeurActuelle() == Fil.ZERO || fentree2.getValeurActuelle() == Fil.ZERO) fsortie.setValeur(Fil.UN);
        else if (fentree.getValeurActuelle() == Fil.UN&&fentree2.getValeurActuelle() == Fil.UN) fsortie.setValeur(Fil.ZERO);
        else fsortie.setValeur(Fil.X);  
    }
    
    /**
     * permet de r�cup�rer les valeurs d'entr�es et de sortie sous forme d'une string
     * 
     * @return  (String) le texte d�crivant la valeur logique pr�sente sur la liaison
     */
    public String toString()
    {
        return fentree.getValeurActuelle() + " <NAND> " + fentree2.getValeurActuelle() + " => " + fsortie.getValeurFuture();
    }
}