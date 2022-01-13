
/**
 * Cette classe permet de spécialiser la classe Acces
 * 
 * @author GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.1
 */
//hérité de Acces
public class Entree extends Acces
{
    /**
     * Constructeur de la classe Entree (version avec nom)
     * 
     * @param (String) le nom de la sortie
     */
    public Entree(String s)
    {
        // invocation du constructeur où le nom est défini mais ne contient pas de fil de la classe parent Acces
        super(s);
    }

    /**
     * Constructeur de la classe Entree (version avec nom et fil)
     * 
     * @param (String) le nom de la sortie
     * @param (Fil) le nom du fil connecté à la sortie
     */
    public Entree(String s,Fil f)
    {
        // invocation du constructeur où le nom et le fil connecté sont définis de la classe parent Acces
        super(s,f);
    }

    /**
     * Méthode setValeur permettant de charger une valeur sur l'accès. Nota : si aucun fil valide n'a
     * été relié à l'accès, la valeur sera perdue...
     * 
     * @param  (int) la valeur à mettre sur l'accès qui est alors une entrée
     * @return  (aucun)
     */
    public void setValeur(int val)
    {
        if (ficelle != null) ficelle.setValeur(val);
    }

    /**
     * Méthode getValeur permettant de lire la valeur présente sur l'accès. Nota : si aucun fil valide n'a
     * été relié à l'accès, le résultat sera "indéterminé"
     * 
     * @param  (aucun)
     * @return  (int) la valeur de l'accès qui est une entrée
     */
    public int getValeur()
    {
        int res = Fil.X;
        if (ficelle != null) res = ficelle.getValeurFuture();
        return res;
    }

    /**
     * Méthode getSens pour lire le sens
     * 
     * @param  (aucun)
     * @return  (int) le sens de l'accès
     */
    public int getSens()
    {
        return ENTREE;
    }
    
    /**
     * Méthode toString permet de récupérer l'état sous forme d'une string
     * 
     * @return  (String) le texte décrivant la valeur logique présente sur l'élément
     */
    public  String toString() { 
        return ficelle.toString();
    }
    
    /**
     * Methode main permettant de tester la classe Entree
     * 
     * @param  (aucun)
     * @return   (aucun)
     */
    public static void main(String[] args)
    {
        // Création des fils
        Fil f0 = new Fil();
        Fil f1 = new Fil("net0001");
        // Création des accès
        Entree a1 = new Entree("E1",f0);
        Entree a2 = new Entree("E2",f1);
 
        a1.setValeur(Fil.ZERO);
        a2.setValeur(Fil.UN);

        f0.propager();
        f1.propager();

        System.out.println("L'accès "+a1.getNom()+" porte désormais la valeur "
            +a1.getValeur());
        System.out.println("L'accès "+a2.getNom()+" porte désormais la valeur "
            +a2.getValeur());
        
    }

    
}
