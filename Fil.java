/**
 * la classe Fil implémente une liaison dans un schéma logique
 * 
 * @author GASTINEAU Arthur
 * @version v0.1
 */
//hérité de Generique
public class Fil extends Generique
{
    // déclaration des variables d'instance
    // valeur affectée à l'entrée de la liaison
    private int valeurdEntree;
    // valeur produite par propagation en sortie de la liaison
    private int valeurdeSortie;
    // constantes pour se faciliter l'écriture
    public static final int ZERO = 0;
    public static final int UN = 1;
    public static final int X = 2;
    public static final int IDEM = -1;
    /**
     * Constructeur (version 1) : version par défaut
     * 
     * @param (aucun)
     */
    public Fil()
    {
        // invocation du constructeur où le nom n'est pas défini de la classe parent Circuit
        super();
        // initialisation des valeurs aux bouts de la liaison comme non-défini
        valeurdEntree = X;
        valeurdeSortie = X;
    }

    /**
     * Constructeur (version 2) : fixe le nom de la liaison
     * 
     * @param (String) le nom du fil
     */
    public Fil(String s)
    {
        // invocation du constructeur où le nom ets le paramètre en entrée de la classe parent Circuit
        super(s);
        // initialisation des valeurs aux bouts de la liaison comme non-défini
        valeurdEntree = X;
        valeurdeSortie = X;
    }

    /**
     * Méthode toString permettant de récupérer l'état du fil sous forme d'une chaîne de caractères
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
     * Méthode GetValeurActuelle permettant de récupérer l'état en sortie de la liaison
     * 
     * @param (aucun)
     * @return  (int) la valeur logique présente sur la liaison (sortie)
     */
    public int getValeurActuelle()
    {
        return valeurdeSortie;
    }

    /**
     * Méthode getValeurFuture permettant de récupérer l'état en entrée de la liaison
     * 
     * @param (aucun)
     * @return  (int) la valeur logique présente sur la liaison (entrée)
     */
    public int getValeurFuture()
    {
        return valeurdEntree;
    }
    
    /**
     * Méthode setValeur permettant d'affecter à l'entrée de la liaison une valeur, qui pourra,
     * par la suite, être propagée vers la sortie de la liaison. Si la valeur
     * transmise est IDEM, la valeurdEntree n'est pas modifiée...
     * 
     * @param  (int) la valeur logique à mettre "sur" la liaison
     * @return (aucun)
     */
    public void setValeur(int val)
    {
        if (val != IDEM) valeurdEntree = val;
    }

    /**
     * Méthode permettant de propager l'état de la liaison depuis son entrée jusqu'à
     * sa sortie
     * 
     * @param (aucun)
     * @return (aucun)
     */
    public void propager()
    {
        valeurdeSortie = valeurdEntree;
    }
    
    /**
     * Methode main permettant de tester la classe Fil
     * 
     * @param  (aucun)
     * @return   (aucun)
     */
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