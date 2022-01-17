
/**
 * Cette classe permet de spécialiser la classe Acces
 * 
 * @author GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.1
 */
//hérité de Acces
public class Sortie extends Acces
{
    /**
     * Constructeur de la classe Sortie (version avec nom)
     * 
     * @param (String) le nom de la sortie
     */
    public Sortie(String s)
    {
        // invocation du constructeur où le nom est défini mais ne contient pas de fil de la classe parent Acces
        super(s);
    }

    /**
     * Constructeur de la classe Sortie (version avec nom et fil)
     * 
     * @param (String) le nom de la sortie
     * @param (Fil) le nom du fil connecté à la sortie
     */
    public Sortie(String s,Fil f)
    {
        // invocation du constructeur où le nom et le fil connecté sont définis de la classe parent Acces
        super(s,f);
    }
    
    /**
     * Méthode getValeur permettant de lire la valeur présente sur l'accès. Nota : si aucun fil valide n'a
     * été relié à l'accès, le résultat sera "indéterminé"
     * 
     * @param  (aucun)
     * @return  (int) la valeur de l'accès qui est alors une sortie
     */
    public int getValeur()
    {
        int res = Fil.X;
        if (ficelle != null) res = ficelle.getValeurActuelle();
        return res;
    }

    /**
     * Méthode setValeur permettan de charger une valeur sur l'accès. 
     * Comme on est sur une sortie, cette opération n'a aucun effet !
     * 
     * @param  (int) la valeur à mettre sur l'accès qui est une sortie !
     * @return  (aucun)
     */
    public void setValeur(int val)
    {        
    }

    /**
     * Méthode getSens pour lire le sens
     * 
     * @param  (aucun)
     * @return  (int) le sens de l'accès
     */
    public int getSens()
    {
        return SORTIE;
    }
    
    /**
     * Méthode toString permet de récupérer l'état sous forme d'une string
     * 
     * @param (aucun)
     * @return  (String) le texte décrivant la valeur logique présente sur l'élément
     */
    public  String toString() { 
        return ficelle.toString();
    }
    
    /**
     * Methode main permettant de tester la classe Sortie
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
        Sortie a3 = new Sortie("S1",f0);
        Sortie a4 = new Sortie("S2",f1);

        f0.setValeur(Fil.ZERO);
        f1.setValeur(Fil.UN);

        f0.propager();
        f1.propager();

        System.out.println("L'accès "+a3.getNom()+" porte désormais la valeur "
            +a3.getValeur());
        System.out.println("L'accès "+a4.getNom()+" porte désormais la valeur "
            +a4.getValeur());
        
    }
}
