
/**
 * Cette classe permet la mod�lisation de la porte logique NAND
 *
 * @author GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.1
 */
// h�rit� de Circuit
public class PorteNAND extends Circuit
{
    // d�claration des variables d'instanciation
    private Fil fentree2;
    private Fil fconducteur1;
    private Fil fconducteur2;
    private PorteNON PorteNON1;
    private PorteNON PorteNON2;
    private PorteOU PorteOU1;

    /**
     * Constructeur d'objets de classe PorteNAND
     * 
     * @param (Fil) le fil reli� � la 1e entr�e
     * @param (Fil) le fil reli� � la 2e entr�e
     * @param (Fil) le fil reli� � la sortie
     */
    public PorteNAND(Fil fentree1,Fil fentree2,Fil fsortie1)
    {
        // invocation du constructeur de la classe parent Circuit
        super(fentree1,fsortie1);
        // initialisation des variables d'instance
        this.fentree2 = fentree2;
        fconducteur1 = new Fil("fil conducteur1");
        fconducteur2 = new Fil("fil conducteur2");
        PorteNON1 = new PorteNON(fentree1,fconducteur1);
        PorteNON2 = new PorteNON(fentree2,fconducteur2);
        PorteOU1 = new PorteOU(fconducteur1,fconducteur2,fsortie1);
    }

    /**
     * M�thode calculer permettant d'effectuer l'op�ration logique NAND au fils en entr�e et d'affecter le r�sultat en sortie
     *
     * @param  (aucun)
     * @return  (aucun)
     */
    public void calculer()
    {
        // On effectue l'op�ration NON sur le 1e fil en entr�e et on affecte le r�sultat au 1e fil conducteur
        PorteNON1.calculer();
        // On propage l'information du 1e fil ocnducteur
        fconducteur1.propager();
        // On effectue l'op�ration NON sur le 2e fil en entr�e et on affecte le r�sultat au 2e fil conducteur
        PorteNON2.calculer();
        // On propage l'information du 2e fil ocnducteur
        fconducteur2.propager();
        // on effectue l'op�ration OU sur les 2 fils conducteur et on affecte le r�sultat au fil en sortie
        PorteOU1.calculer();
    }
    
    /**
     * M�thode toString permettant de retourner un texte repr�sentant l'op�ration logique effectu�e
     *
     * @param  (aucun)
     * @return  (String) le texte d�crivant l'op�ration logique NAND
     */
    public String toString()
    {
        return fentree.getValeurActuelle() + " <NAND> " + fentree2.getValeurActuelle() + " => " + fsortie.getValeurFuture();
    }
}
