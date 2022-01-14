import java.io.*;   
    
/**
 * Cette classe permet de tester le schéma
 * 
 * @author GASTINEAU Arthur & LAMOUR Guillaume
 * @version v0.2
 */
public class Testeur
{

    /**
     * Methode main - seule et unique méthode de la classe
     * C'est elle que l'on exécute pour tester le simulateur
     * 
     * @param  (aucun)
     * @return   (aucun)
     */

    public static void main(String[] args) throws IOException {  
        /********** Création du schéma ***********/
        // Création du Schéma
        SchemaTP schema1 = new SchemaTP();
        /************* Simulation proprement dite **********/
        boolean fini = false;
        while (!fini) {
            System.out.print("Début d'un pas de simulation ");
            System.out.println(" (Etat actuel des entrées : " + schema1.getEntreeString() + " )");            
            // acquisition des stimuli qui sont appliquées sur les entrées...
            int nbEntrees = schema1.getNbEntrees();
            int [] valEntrees = new int[nbEntrees];
            for (int id_entree = 0; id_entree < nbEntrees; id_entree++)
            {
                valEntrees[id_entree] = lireValeurFil();
            }
            // après saisie au clavier, mettre à jour les entrées du schéma
            schema1.setStimuli(valEntrees);
            // effectuer un pas de simulation
            schema1.calculeUnPas();
            // récupérer l'état de la sortie du schéma et afficher le résultat
            System.out.print("Les sorties du schéma valent ");
            System.out.println(schema1.getSortieString());
            // Terminaison de la boucle
            fini = finBoucle();
        }

        System.out.print(" -- Termine -- ");
        System.exit(0);
    }
    
    /**
     * Cette méthode permet d'acquérir au clavier une valeur à mettre sur un fil
     * La valeur Fil.IDEM signifie "même valeur que précédemment"
     * Nota : cette méthode est statique car elle est appelée par main qui est
     * elle-même statique
     * 
     * @param  (aucun)
     * @return (int) valeur du fil
     */

    private static int lireValeurFil() throws IOException
    {   
        // pour accès clavier : TOUJOURS TERMINéS PAR ENTREE
        BufferedReader inr = new BufferedReader(new InputStreamReader(System.in));
        
        // saisie d'une nouvelle valeur
        System.out.print(" - Nouvelle valeur (suivie de return) : ");
        String s = inr.readLine();
        int resultat = Fil.IDEM;
        if (s.length() >= 1) {
            switch (s.charAt(0)) {
                case (byte)'0':resultat =  Fil.ZERO;break;
                case (byte)'1':resultat =  Fil.UN;break;
                case (byte)'x':resultat =  Fil.X;break;
                case (byte)'X':resultat =  Fil.X;break;
                case '\r':resultat =  Fil.IDEM;break;
                default: resultat =  Fil.X;
                }
            }
        return resultat;
    }
    
    /**
     * Cette méthode permet de demander à l'utilisateur s'il souhaite terminer
     * la simulation
     * Nota : cette méthode est statique car elle est appelée par main qui est
     * elle-même statique
     * 
     * @param  (aucun)
     * @return (boolean) VRAI si fin souhaitée
     */
    private static boolean finBoucle() throws IOException
    {
        BufferedReader inr = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nOn continue ? (n/N pour arrêter - Autre pour continuer)");
        String s = inr.readLine();
        if (s.length() < 1) return false;
        if ((s.charAt(0))==(int)'n' || (s.charAt(0))==(int)'N') return true;
        else return false;
    }    
}