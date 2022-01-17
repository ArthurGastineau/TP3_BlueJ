/**
 * La classe Bistable_SR implémente un schéma de type Bistable SR.
 * 
 * @author Arthur Gastineau & LAMOUR Guillaume, IUT de Nantes
 * @version Janvier 2022
 */
public class Bistable_SR extends SchemaGenerique
{
    // les variables d'instance constituant le schéma (fils, entrées, sorties et portes logiques)
    private Entree S;
    private Entree R;
    private Sortie Q1;
    private Sortie Q2;
    private Fil fS;
    private Fil fR;
    private Fil fQ1;
    private Fil fQ2;
    private PorteNAND porteNAND1;
    private PorteNAND porteNAND2;
    /**
     * Constructeur : il créée le schéma, c'est à dire les élements reliés entre eux
     */
    public Bistable_SR()
    {
        super();
        // création des fils, qui ne savent pas à qui ils sont reliées
        fS = new Fil("Fil_entrée_S");
        fR = new Fil("Fil_entrée_R");
        fQ1 = new Fil("Fil_sortie_Q1");
        fQ2 = new Fil("Fil_sortie_Q2");
        // Création des accès (reliés à un fil)
        S = new Entree("Entrée S",fS);
        R = new Entree("Entrée R",fR);
        Q1 = new Sortie("Sortie Q1",fQ1);
        Q2 = new Sortie("Sortie Q1",fQ2);
        //Création des circuits logiques(reliées à des entrée(s)/sortie(s))
        porteNAND1 = new PorteNAND(fS, fQ2, fQ1);
        porteNAND2 = new PorteNAND(fR, fQ1, fQ2);
        //Ajout dans les vecteurs
        Fils.add(fS);
        Fils.add(fR);
        Fils.add(fQ1);
        Fils.add(fQ2);
        Entrees.add(S);
        Entrees.add(R);
        Sorties.add(Q1);
        Sorties.add(Q2);
        Circuits.add(porteNAND1);
        Circuits.add(porteNAND2);
        //On initialise la valeur des deux fils en sorties
        Q1.setValeur(Fil.ZERO);
        Q2.setValeur(Fil.UN);
    }
}