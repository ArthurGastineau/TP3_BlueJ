/**
 * la classe Fil impl�mente une liaison dans un sch�ma logique
 * 
 * @author GASTINEAU Arthur
 * @version v0.1
 */
//h�rit� de Generique
public class Fil extends Generique
{
    // d�claration des variables d'instance
    // valeur affect�e � l'entr�e de la liaison
    private int valeurdEntree;
    // valeur produite par propagation en sortie de la liaison
    private int valeurdeSortie;
    // constantes pour se faciliter l'�criture
    public static final int ZERO = 0;
    public static final int UN = 1;
    public static final int X = 2;
    public static final int IDEM = -1;
    /**
     * Constructeur (version 1) : version par d�faut
     * 
     * @param (aucun)
     */
    public Fil()
    {
        // invocation du constructeur o� le nom n'est pas d�fini de la classe parent Circuit
        super();
        // initialisation des valeurs aux bouts de la liaison comme non-d�fini
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
        // invocation du constructeur o� le nom ets le param�tre en entr�e de la classe parent Circuit
        super(s);
        // initialisation des valeurs aux bouts de la liaison comme non-d�fini
        valeurdEntree = X;
        valeurdeSortie = X;
    }

    /**
     * M�thode toString permettant de r�cup�rer l'�tat du fil sous forme d'une cha�ne de caract�res
     * 
     * @return  (String) le texte d�crivant la valeur logique pr�sente sur la liaison
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
     * M�thode GetValeurActuelle permettant de r�cup�rer l'�tat en sortie de la liaison
     * 
     * @param (aucun)
     * @return  (int) la valeur logique pr�sente sur la liaison (sortie)
     */
    public int getValeurActuelle()
    {
        return valeurdeSortie;
    }

    /**
     * M�thode getValeurFuture permettant de r�cup�rer l'�tat en entr�e de la liaison
     * 
     * @param (aucun)
     * @return  (int) la valeur logique pr�sente sur la liaison (entr�e)
     */
    public int getValeurFuture()
    {
        return valeurdEntree;
    }
    
    /**
     * M�thode setValeur permettant d'affecter � l'entr�e de la liaison une valeur, qui pourra,
     * par la suite, �tre propag�e vers la sortie de la liaison. Si la valeur
     * transmise est IDEM, la valeurdEntree n'est pas modifi�e...
     * 
     * @param  (int) la valeur logique � mettre "sur" la liaison
     * @return (aucun)
     */
    public void setValeur(int val)
    {
        if (val != IDEM) valeurdEntree = val;
    }

    /**
     * M�thode permettant de propager l'�tat de la liaison depuis son entr�e jusqu'�
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
        System.out.println("Le fil "+f0.getNom()+" porte d�sormais la valeur "
            +f0.getValeurActuelle()+" (sans propagation)");
        System.out.println("Le fil "+f1.getNom()+" porte d�sormais la valeur "
            +f1.getValeurActuelle()+" (sans propagation)");
        f0.propager();
        f1.propager();
        System.out.println("Le fil "+f0.getNom()+" porte d�sormais la valeur "
            +f0.getValeurActuelle()+" (apr�s propagation)");
        System.out.println("Le fil "+f1.getNom()+" porte d�sormais la valeur "
            +f1.getValeurActuelle()+" (apr�s propagation)");        
    }

}