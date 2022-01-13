
/**
 * Cette classe permet de sp�cialiser la classe Acces
 * 
 * @author GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.1
 */
//h�rit� de Acces
public class Entree extends Acces
{
    /**
     * Constructeur de la classe Entree (version avec nom)
     * 
     * @param (String) le nom de la sortie
     */
    public Entree(String s)
    {
        // invocation du constructeur o� le nom est d�fini mais ne contient pas de fil de la classe parent Acces
        super(s);
    }

    /**
     * Constructeur de la classe Entree (version avec nom et fil)
     * 
     * @param (String) le nom de la sortie
     * @param (Fil) le nom du fil connect� � la sortie
     */
    public Entree(String s,Fil f)
    {
        // invocation du constructeur o� le nom et le fil connect� sont d�finis de la classe parent Acces
        super(s,f);
    }

    /**
     * M�thode setValeur permettant de charger une valeur sur l'acc�s. Nota : si aucun fil valide n'a
     * �t� reli� � l'acc�s, la valeur sera perdue...
     * 
     * @param  (int) la valeur � mettre sur l'acc�s qui est alors une entr�e
     * @return  (aucun)
     */
    public void setValeur(int val)
    {
        if (ficelle != null) ficelle.setValeur(val);
    }

    /**
     * M�thode getValeur permettant de lire la valeur pr�sente sur l'acc�s. Nota : si aucun fil valide n'a
     * �t� reli� � l'acc�s, le r�sultat sera "ind�termin�"
     * 
     * @param  (aucun)
     * @return  (int) la valeur de l'acc�s qui est une entr�e
     */
    public int getValeur()
    {
        int res = Fil.X;
        if (ficelle != null) res = ficelle.getValeurFuture();
        return res;
    }

    /**
     * M�thode getSens pour lire le sens
     * 
     * @param  (aucun)
     * @return  (int) le sens de l'acc�s
     */
    public int getSens()
    {
        return ENTREE;
    }
    
    /**
     * M�thode toString permet de r�cup�rer l'�tat sous forme d'une string
     * 
     * @return  (String) le texte d�crivant la valeur logique pr�sente sur l'�l�ment
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
        // Cr�ation des fils
        Fil f0 = new Fil();
        Fil f1 = new Fil("net0001");
        // Cr�ation des acc�s
        Entree a1 = new Entree("E1",f0);
        Entree a2 = new Entree("E2",f1);
 
        a1.setValeur(Fil.ZERO);
        a2.setValeur(Fil.UN);

        f0.propager();
        f1.propager();

        System.out.println("L'acc�s "+a1.getNom()+" porte d�sormais la valeur "
            +a1.getValeur());
        System.out.println("L'acc�s "+a2.getNom()+" porte d�sormais la valeur "
            +a2.getValeur());
        
    }

    
}
