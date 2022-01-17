
/**
 * Cette classe permet la modélisation de la porte logique OU Exclusif
 *
 * @author GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.1
 */
//hérité de Circuit
public class PorteXOR extends Circuit
{
    // déclaration des variables d'instance modélisant le 2e fil en entrée
    private Fil fentree2;

    /**
     * Constructeur d'objets de classe PorteXOR avec nom non-défini
     * 
     * @param (Fil) le fil relié à la 1e entrée
     * @param (Fil) le fil relié à la 2e entrée
     * @param (Fil) le fil relié à la 1e sortie
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
     * @param (Fil) le fil relié à la 1e entrée
     * @param (Fil) le fil relié à la 2e entrée
     * @param (Fil) le fil relié à la 1e sortie
     */
    public PorteXOR(String s,Fil fentree1, Fil fentree2, Fil fsortie1)
    {
        // invocation du constructeur de la classe parent Circuit
        super(s,fentree1,fsortie1);
        // initialisation de la variable d'instance
        this.fentree2 = fentree2;
    }

    /**
     * Méthode calculer permettant d'effectuer l'opération logique XOR aux fils en entrée et d'affecter le résultat en sortie
     *
     * @param (aucun)
     * @return (aucun)
     */
    public void calculer()
    {
        // Si les l'état des 2 fils en entrée sont définis, on affecte en sortie le résultat de l'opération logique
        if (fentree.getValeurActuelle() != fentree.X && fentree2.getValeurActuelle() != fentree2.X)
        {
            fsortie.setValeur(fentree.getValeurActuelle() ^ fentree2.getValeurActuelle());  
        }
        // Autrement on définit l'état du fil e nsortie comme indéfini
        else fsortie.setValeur(fsortie.X);
    }
    
    /**
     * Méthode toString permettant de retourner un texte représentant l'opération logique effectuée
     *
     * @param  (aucun)
     * @return  (String) le texte décrivant l'opération logique OU exclusif
     */
    public String toString()
    {
        return fentree.getValeurActuelle() + " <XOR> " + fentree2.getValeurActuelle() + " => " + fsortie.getValeurFuture();
    }
}
