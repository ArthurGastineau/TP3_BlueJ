 /**
 * Cette classe permet de définir et simuler une porte NAND.
 *
 * @author (LAMOUR Guillaume & GASTINEAU Arthur)
 * @version (15/01/2022)
 */
public class PorteNAND extends Circuit
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Fil fentree2;

    /**
     * Constructeur d'objets de classe Porte NAND avec nom non défini
     * 
     * @param (Fil) le fil relié à la 1e entrée
     * @param (Fil) le fil relié à la 2e entrée
     * @param (Fil) le fil relié à la sortie
     */
    public PorteNAND(Fil fentree, Fil fentree2, Fil fsortie)
    {
        // initialisation des variables d'instance
        super(fentree, fsortie);
        this.fentree2 = fentree2;
    }
    
    /*
     * Constructeur d'objets de classe Porte NAND avec nom modifié
     * 
     * @param (String) le nom du Circuit
     * @param (Fil) le fil relié à la 1e entrée
     * @param (Fil) le fil relié à la 2e entrée
     * @param (Fil) le fil relié à la sortie
     */
    public PorteNAND(String s, Fil fentree, Fil fentree2, Fil fsortie)
    {
        // initialisation des variables d'instance
        super(s, fentree, fsortie);
        this.fentree2 = fentree2;
    }

    /**
     * Méthode calculer : permet de calculer l'état de sortie fsortie
     * d'une porte NAND à partie des états d'entrées fentree et fentree2
     *
     */
    public void calculer()
    {
        if(fentree.getValeurActuelle() == Fil.ZERO || fentree2.getValeurActuelle() == Fil.ZERO) fsortie.setValeur(Fil.UN);
        else if (fentree.getValeurActuelle() == Fil.UN&&fentree2.getValeurActuelle() == Fil.UN) fsortie.setValeur(Fil.ZERO);
        else fsortie.setValeur(Fil.X);  
    }
    
    /**
     * permet de récupérer les valeurs d'entrées et de sortie sous forme d'une string
     * 
     * @return  (String) le texte décrivant la valeur logique présente sur la liaison
     */
    public String toString()
    {
        return fentree.getValeurActuelle() + " <NAND> " + fentree2.getValeurActuelle() + " => " + fsortie.getValeurFuture();
    }
}