/**
 * Cette classe réalise un accès du simulateur
 * 
 * @author GASINEAU Arthur & LAMOUR Guillaume
 * @version v0.0
 */
public abstract class Acces extends Generique 
{
    // variables d'instance
    protected Fil ficelle;
    
    public static final int ENTREE = 0;
    public static final int SORTIE = 1;

    /**
     * Constructeur avec le nom en paramètre d'appel
     */
    public Acces(String s)
    {
        setNom(s);
        ficelle = null;
    }

    /**
     * Constructeur avec  nom et fil associé
     */
    public Acces(String s,Fil f)
    {
        setNom(s);
        ficelle = f;
    }    

    /**
     * Accesseur pour lire le sens
     * 
     * @param  (aucun)
     * @return  (int) le sens de l'accès
     */
    public abstract int getSens();
    
  
}
