
/**
 * Cette classe permet la modélisation de la porte logique NAND
 *
 * @author GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.1
 */
// hérité de Circuit
public class PorteNAND extends Circuit
{
    // déclaration des variables d'instanciation
    private Fil fentree2;
    private Fil fconducteur1;
    private Fil fconducteur2;
    private PorteNON PorteNON1;
    private PorteNON PorteNON2;
    private PorteOU PorteOU1;

    /**
     * Constructeur d'objets de classe PorteNAND
     * 
     * @param (Fil) le fil relié à la 1e entrée
     * @param (Fil) le fil relié à la 2e entrée
     * @param (Fil) le fil relié à la sortie
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
     * Méthode calculer permettant d'effectuer l'opération logique NAND au fils en entrée et d'affecter le résultat en sortie
     *
     * @param  (aucun)
     * @return  (aucun)
     */
    public void calculer()
    {
        // On effectue l'opération NON sur le 1e fil en entrée et on affecte le résultat au 1e fil conducteur
        PorteNON1.calculer();
        // On propage l'information du 1e fil ocnducteur
        fconducteur1.propager();
        // On effectue l'opération NON sur le 2e fil en entrée et on affecte le résultat au 2e fil conducteur
        PorteNON2.calculer();
        // On propage l'information du 2e fil ocnducteur
        fconducteur2.propager();
        // on effectue l'opération OU sur les 2 fils conducteur et on affecte le résultat au fil en sortie
        PorteOU1.calculer();
    }
    
    /**
     * Méthode toString permettant de retourner un texte représentant l'opération logique effectuée
     *
     * @param  (aucun)
     * @return  (String) le texte décrivant l'opération logique NAND
     */
    public String toString()
    {
        return fentree.getValeurActuelle() + " <NAND> " + fentree2.getValeurActuelle() + " => " + fsortie.getValeurFuture();
    }
}
