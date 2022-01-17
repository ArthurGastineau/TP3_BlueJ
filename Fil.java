
/**
 * la classe Fil implémente une liaison dans un schéma logique
 * 
 * @author R. Gourdon, IUT Nantes
 * @version Septembre 2008, , révisé 2011
 */
public class Fil extends Generique
{
    // variables d'instance
    private int valeurdEntree;
        // valeur affectée à l'entrée de la liaison
    private int valeurdeSortie;
        // valeur produite par propagation en sortie de la liaison
    public static final int ZERO = 0;
    public static final int UN = 1;
    public static final int X = 2;
    public static final int IDEM = -1;
        // constantes pour se faciliter l'écriture

    /**
     * Constructeur (version 1) : version par défaut
     */
    public Fil()
    {
        // Chaque fil doit avoir un nom (ici : non défini)
        super();
        valeurdEntree = X;
        valeurdeSortie = X;
    }

    /**
     * Constructeur (version 2) : fixe le nom de la liaison
     */
    public Fil(String s)
    {
        // Chaque fil a un nom, fourni lors de l'instanciation
        super(s);
        valeurdEntree = X;
        valeurdeSortie = X;
    }

    /**
     * permet de récupérer l'état du fil sous forme d'une string
     * 
     * @return  (String) le texte décrivant la valeur logique présente sur la liaison
     */
    public String toString()
    {
        String s;
        switch (valeurdeSortie) {
            case ZERO : s = " - 0 ";break;
            case UN : s = " - 1 ";break;
            case X : s = " - X ";break;
            default : s = " - ? ";break;
        }
        return s;
    }

    /**
     * permet de récupérer l'état en sortie de la liaison
     * 
     * @return  (int) la valeur logique présente sur la liaison (sortie)
     */
    public int getValeurActuelle()
    {
        return valeurdeSortie;
    }

    /**
     * permet de récupérer l'état en entrée de la liaison
     * 
     * @return  (int) la valeur logique présente sur la liaison (entrée)
     */
    public int getValeurFuture()
    {
        return valeurdEntree;
    }
    
    /**
     * permet d'affecter à l'entrée de la liaison une valeur, qui pourra,
     * par la suite, être propagée vers la sortie de la liaison. Si la valeur
     * transmise est IDEM, la valeurdEntree n'est pas modifiée...
     * 
     * @param  (int) la valeur logique à mettre "sur" la liaison
     */
    public void setValeur(int val)
    {
        if (val != IDEM) valeurdEntree = val;
    }

    /**
     * permet de propager l'état de la liaison depuis son entrée jusqu'à
     * sa sortie
     */
    public void propager()
    {
        valeurdeSortie = valeurdEntree;
    }
   
    public static void main(String[] args)
    {
        Fil f0 = new Fil();
        Fil f1 = new Fil("net0001");
        f0.setValeur(UN);
        f1.setValeur(ZERO);
        System.out.println("Le fil "+f0.getNom()+" porte désormais la valeur "
            +f0.getValeurActuelle()+" (sans propagation)");
        System.out.println("Le fil "+f1.getNom()+" porte désormais la valeur "
            +f1.getValeurActuelle()+" (sans propagation)");
        f0.propager();
        f1.propager();
        System.out.println("Le fil "+f0.getNom()+" porte désormais la valeur "
            +f0.getValeurActuelle()+" (après propagation)");
        System.out.println("Le fil "+f1.getNom()+" porte désormais la valeur "
            +f1.getValeurActuelle()+" (après propagation)");        
    }
}
