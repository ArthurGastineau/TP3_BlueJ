/**
 * La classe Schema impl�mente un sch�ma � simuler.
 * De l'ext�rieur, le sch�ma est inconnu : on sait seulement qu'il a des entr�es
 * et des sorties. Ce qui int�resse l'utilisateur de ce sch�ma, c'est de :
 *      - pouvoir appliquer des stimuli sur les entr�es
 *      - faire un pas de propagation
 *      - observer le r�sultat en sortie
 * 
 * A l'int�rieur, le sch�ma g�re les diff�rents constituants d'un sch�ma. En les 
 * instanciant, il �tablit les relations entre eux. Cette version op�re avec
 * des acc�s dff�renci�s (utilisation des classes Entr�e et Sortie). Cette
 * version permet la r�alisation d'un sch�ma � plusieurs entr�es et plusieurs sorties.
 * 
 * @author Arthur GASTINEAU
 * @version v0.4
 */
//h�rit� de SchemaGenerique
public class SchemaTP extends SchemaGenerique
{
    // d�claration des variables d'instance constituent le sch�ma
    private Entree entree1;
    private Entree entree2;
    private Sortie sortie1;
    private Sortie sortie2;
    private Fil f0;
    private Fil f1;
    private Fil f2;
    private Fil f3;
    private PorteNAND porteNAND1;
    private PorteNAND porteNAND2;

    /**
     * Constructeur : il cr��e le sch�ma, c'est � dire les �lements reli�s entre eux
     */
    public SchemaTP()
    {
        super();
        
        // Cr�ation des fils, qui ne savent pas � qui ils sont reli�es qu'on ajoute dans le tableau dynamique ocntenant tous les fils du sch�ma
        f0 = new Fil("net0000"); Fils.add(f0);
        f1 = new Fil("net0001"); Fils.add(f1);
        f2 = new Fil("net0002"); Fils.add(f2);
        f3 = new Fil("net0003"); Fils.add(f3);
        // Il faut s'assurer que le bistable demarre bien pour cela on affecte 0 � ses deux sorties
        f2.setValeur(Fil.ZERO);
        f3.setValeur(Fil.ZERO);
        // On propage l'information pour quelle soit bien entr�e des circuits et utilisable au niveau des circuits
        f2.propager();
        f3.propager();
        // Cr�ation des acc�s (reli�s � un fil)
        entree1 = new Entree("Entr�e S",f0); Entrees.add(entree1);
        entree2 = new Entree("Entr�e R",f1); Entrees.add(entree2);
        sortie1 = new Sortie("Sortie Q1",f2); Sorties.add(sortie1);
        sortie2 = new Sortie("Sortie Q2",f3); Sorties.add(sortie2);
        // Cr�ation des portes NAND
        porteNAND1 = new PorteNAND(f0,f3,f2); Circuits.add(porteNAND1);
        porteNAND2 = new PorteNAND(f1,f2,f3); Circuits.add(porteNAND2);
        
    }
}

