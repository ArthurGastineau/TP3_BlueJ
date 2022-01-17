/**
 * La classe Bistable_SR impl�mente un sch�ma de type Bistable SR.
 * 
 * @author Arthur Gastineau & LAMOUR Guillaume, IUT de Nantes
 * @version Janvier 2022
 */
public class Bistable_SR extends SchemaGenerique
{
    // les variables d'instance constituant le sch�ma (fils, entr�es, sorties et portes logiques)
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
     * Constructeur : il cr��e le sch�ma, c'est � dire les �lements reli�s entre eux
     */
    public Bistable_SR()
    {
        super();
        // cr�ation des fils, qui ne savent pas � qui ils sont reli�es
        fS = new Fil("Fil_entr�e_S");
        fR = new Fil("Fil_entr�e_R");
        fQ1 = new Fil("Fil_sortie_Q1");
        fQ2 = new Fil("Fil_sortie_Q2");
        // Cr�ation des acc�s (reli�s � un fil)
        S = new Entree("Entr�e S",fS);
        R = new Entree("Entr�e R",fR);
        Q1 = new Sortie("Sortie Q1",fQ1);
        Q2 = new Sortie("Sortie Q1",fQ2);
        //Cr�ation des circuits logiques(reli�es � des entr�e(s)/sortie(s))
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