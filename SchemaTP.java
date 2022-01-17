/**
* La classe SchemaTP impl�mente un sch�ma � simuler.
* De l'ext�rieur, le sch�ma est inconnu : on sait seulement qu'il a des entr�es
* et des sorties. Ce qui int�resse
* l'utilisateur de ce sch�ma, c'est de :
* - pouvoir appliquer des stimuli sur les entr�es
50
* - faire un pas de propagation
* - observer le r�sultat en sortie
*
* A l'int�rieur, le sch�ma g�re les diff�rents constituants d'un sch�ma. En les
* instanciant, il �tablit les relations entre eux. Cette version op�re avec
* des acc�s diff�renci�s (utilisation des classes Entr�e et Sortie). Cette
* version permet la r�alisation d'un sch�ma � 4 entr�es et 1 sortie.
*
* @author Arthur GASTINEAU & Guillaume LAMOUR
* @version v0.4
*/
public class SchemaTP extends SchemaGenerique
{
    // les variables d'instance constituent le sch�ma
    private Entree entree1;
    private Entree entree2;
    private Entree entree3;
    private Entree entree4;
    private Sortie sortie1;
    private Fil f0;
    private Fil f1;
    private Fil f2;
    private Fil f3;
    private Fil f4;
    private Fil f5;
    private Fil f6;
    private PorteXOR porteXOR1;
    private PorteET porteET1;
    private PorteOU porteOU1;
    /**
    * Constructeur : il cr��e le sch�ma, c'est � dire les �lements reli�s entre
    eux
    */
    public SchemaTP()
    {
        super();
        // cr�ation des fils, qui ne savent pas � qui ils sont reli�es
        f0 = new Fil("net0000"); Fils.add(f0);
        f1 = new Fil("net0001"); Fils.add(f1);
        f2 = new Fil("net0002"); Fils.add(f2);
        f3 = new Fil("net0003"); Fils.add(f3);
        f4 = new Fil("net0004"); Fils.add(f4);
        f5 = new Fil("net0005"); Fils.add(f5);
        f6 = new Fil("net0006"); Fils.add(f6);
        // Cr�ation des acc�s (reli�s � un fil)
        entree1 = new Entree("Entr�e 1",f0); Entrees.add(entree1);
        entree2 = new Entree("Entr�e 2",f1); Entrees.add(entree2);
        entree1 = new Entree("Entr�e 1",f2); Entrees.add(entree1);
        entree2 = new Entree("Entr�e 2",f3); Entrees.add(entree2);
        sortie1 = new Sortie("Sortie 1",f6); Sorties.add(sortie1);
        // Cr�ation des portes ET, XOR et OU
        porteET1 = new PorteET (f0,f1,f4); Circuits.add(porteET1);
        porteXOR1 = new PorteXOR (f2,f3,f5); Circuits.add(porteXOR1);
        porteOU1 = new PorteOU (f4,f5,f6); Circuits.add(porteOU1);
    }
}