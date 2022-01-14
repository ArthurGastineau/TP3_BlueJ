/**
 * La classe Schema implémente un schéma à simuler.
 * De l'extérieur, le schéma est inconnu : on sait seulement qu'il a des entrées
 * et des sorties. Ce qui intéresse l'utilisateur de ce schéma, c'est de :
 *      - pouvoir appliquer des stimuli sur les entrées
 *      - faire un pas de propagation
 *      - observer le résultat en sortie
 * 
 * A l'intérieur, le schéma gère les différents constituants d'un schéma. En les 
 * instanciant, il établit les relations entre eux. Cette version opère avec
 * des accès dfférenciés (utilisation des classes Entrée et Sortie). Cette
 * version permet la réalisation d'un schéma à plusieurs entrées et plusieurs sorties.
 * 
 * @author Arthur GASTINEAU
 * @version v0.4
 */
//hérité de SchemaGenerique
public class SchemaTP extends SchemaGenerique
{
    // déclaration des variables d'instance constituent le schéma
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
     * Constructeur : il créée le schéma, c'est à dire les élements reliés entre eux
     */
    public SchemaTP()
    {
        super();
        
        // Création des fils, qui ne savent pas à qui ils sont reliées qu'on ajoute dans le tableau dynamique ocntenant tous les fils du schéma
        f0 = new Fil("net0000"); Fils.add(f0);
        f1 = new Fil("net0001"); Fils.add(f1);
        f2 = new Fil("net0002"); Fils.add(f2);
        f3 = new Fil("net0003"); Fils.add(f3);
        // Il faut s'assurer que le bistable demarre bien pour cela on affecte 0 à ses deux sorties
        f2.setValeur(Fil.ZERO);
        f3.setValeur(Fil.ZERO);
        // On propage l'information pour quelle soit bien entrée des circuits et utilisable au niveau des circuits
        f2.propager();
        f3.propager();
        // Création des accès (reliés à un fil)
        entree1 = new Entree("Entrée S",f0); Entrees.add(entree1);
        entree2 = new Entree("Entrée R",f1); Entrees.add(entree2);
        sortie1 = new Sortie("Sortie Q1",f2); Sorties.add(sortie1);
        sortie2 = new Sortie("Sortie Q2",f3); Sorties.add(sortie2);
        // Création des portes NAND
        porteNAND1 = new PorteNAND(f0,f3,f2); Circuits.add(porteNAND1);
        porteNAND2 = new PorteNAND(f1,f2,f3); Circuits.add(porteNAND2);
        
    }
}

