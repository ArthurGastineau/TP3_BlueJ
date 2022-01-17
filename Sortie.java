
/**
 * Cette classe permet de sp�cialiser la classe Acces
 * 
 * @author GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.1
 */
//h�rit� de Acces
public class Sortie extends Acces
{
    /**
     * Constructeur de la classe Sortie (version avec nom)
     * 
     * @param (String) le nom de la sortie
     */
    public Sortie(String s)
    {
        // invocation du constructeur o� le nom est d�fini mais ne contient pas de fil de la classe parent Acces
        super(s);
    }

    /**
     * Constructeur de la classe Sortie (version avec nom et fil)
     * 
     * @param (String) le nom de la sortie
     * @param (Fil) le nom du fil connect� � la sortie
     */
    public Sortie(String s,Fil f)
    {
        // invocation du constructeur o� le nom et le fil connect� sont d�finis de la classe parent Acces
        super(s,f);
    }
    
    /**
     * M�thode getValeur permettant de lire la valeur pr�sente sur l'acc�s. Nota : si aucun fil valide n'a
     * �t� reli� � l'acc�s, le r�sultat sera "ind�termin�"
     * 
     * @param  (aucun)
     * @return  (int) la valeur de l'acc�s qui est alors une sortie
     */
    public int getValeur()
    {
        int res = Fil.X;
        if (ficelle != null) res = ficelle.getValeurActuelle();
        return res;
    }

    /**
     * M�thode setValeur permettan de charger une valeur sur l'acc�s. 
     * Comme on est sur une sortie, cette op�ration n'a aucun effet !
     * 
     * @param  (int) la valeur � mettre sur l'acc�s qui est une sortie !
     * @return  (aucun)
     */
    public void setValeur(int val)
    {        
    }

    /**
     * M�thode getSens pour lire le sens
     * 
     * @param  (aucun)
     * @return  (int) le sens de l'acc�s
     */
    public int getSens()
    {
        return SORTIE;
    }
    
    /**
     * M�thode toString permet de r�cup�rer l'�tat sous forme d'une string
     * 
     * @param (aucun)
     * @return  (String) le texte d�crivant la valeur logique pr�sente sur l'�l�ment
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
        // Cr�ation des fils
        Fil f0 = new Fil();
        Fil f1 = new Fil("net0001");
        // Cr�ation des acc�s
        Sortie a3 = new Sortie("S1",f0);
        Sortie a4 = new Sortie("S2",f1);

        f0.setValeur(Fil.ZERO);
        f1.setValeur(Fil.UN);

        f0.propager();
        f1.propager();

        System.out.println("L'acc�s "+a3.getNom()+" porte d�sormais la valeur "
            +a3.getValeur());
        System.out.println("L'acc�s "+a4.getNom()+" porte d�sormais la valeur "
            +a4.getValeur());
        
    }
}
