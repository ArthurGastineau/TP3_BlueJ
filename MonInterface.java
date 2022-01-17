//Importation de classes de la bibliothèque javaFX
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.application.Platform;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import java.util.Vector;

/**
 * Cette classe permet d'implémenter une interface Graphique à l'application 
 * simulateur de circuits logiques. Cette classe contient les méthodes nécessaires
 * à la construction des différents objets graphiques ainsi qu'au traitement des
 * évènements (clic sur un bouton par l'utilisateur par exemple. Dans cette
 * première version, elle affiche uniquement une fenêtre avec un titre.
 *
 * @author Arthur Gastineau & Guillaume Lamour
 * @version 15/01/2022
 */
//héritée de la classe Application et implémente EventHandler<ActionEvent>
public class MonInterface extends Application implements EventHandler<ActionEvent>
{
    //Variables d'instance (boutons Pas et RAZ + vecteurs contenants les labels et RadioButtons de l'affichage graphique + tableau contenant les stimulis
    private Vector<Label> lab_entrees;
    private Vector<Label> lab_entrees_val;
    private Vector<Label> lab_sorties;
    private Vector<Label> lab_sorties_val;
    private Vector<RadioButton> radioButtons;
    private Button but_Pas, but_RAZ; 
    private Bistable_SR sch;
    private int [] vals; 
    
	 
    /**
     * Démarrage de l'application. Cette méthode permet d'instancier tous les objets graphiques et de
     * les disposer de façon à obtenir une interface graphique organisée facilement utilisable.
     * 
     * @param (Stage) la fenêtre principale de l'interface graphique
     * @return (aucun)
     */
    public void start(Stage primaryStage)
    {
        sch = new Bistable_SR(); //Instanciation du schéma
        int nombre_entrees = sch.Entrees.size(); //nombre d'entrées que comporte le schéma
        int nombre_sorties = sch.Sorties.size(); //nombre de sorties que comporte le schéma
        //Instanciation du tableau contenant les stimulis
        vals = new int [nombre_entrees];
        //Instanciation des vecteurs contenant les buttons, les labels, et les conteneurs pour l'affichage graphique
        lab_entrees = new Vector<Label>();
        lab_sorties = new Vector<Label>();
        lab_entrees_val = new Vector<Label>();
        lab_sorties_val = new Vector<Label>();
        radioButtons = new Vector<RadioButton>();
        
        //Instanciation des conteneurs
        Vector<ToggleGroup> groupsRadioButtons = new Vector<ToggleGroup>();
        Vector<HBox> hboxsE= new Vector<HBox>();
        Vector<HBox> hboxsS = new Vector<HBox>();
        GridPane grid = new GridPane();
        
        //Instanciation de tous les éléments contenues dans les HBox pour les lignes d'affichages correspondant aux entrées,
        //lie les RadioButton entre eux (avec ToggleGroup) et placent l'ensemble dans les HBox, puis les Hbox dans une grille.
        for(int id_entree = 0; id_entree < nombre_entrees ; id_entree++)
        {
                lab_entrees.add(new Label("Entrée " + (id_entree-(-1)) + ":"));
                lab_entrees_val.add(new Label(""));
                hboxsE.add(new HBox(12));
                groupsRadioButtons.add(new ToggleGroup());
                radioButtons.add(new RadioButton("0")); 
                radioButtons.add(new RadioButton("1")); 
                radioButtons.add(new RadioButton("X")); 
                for(int i = 0 ; i < 3 ; i++)
                {
                    radioButtons.get(id_entree*3+i).setOnAction(this);
                    radioButtons.get(id_entree*3+i).setToggleGroup(groupsRadioButtons.get(id_entree));
                }
                hboxsE.get(id_entree).getChildren().addAll(lab_entrees.get(id_entree), radioButtons.get(id_entree*3), radioButtons.get(id_entree*3+1), radioButtons.get(id_entree*3+2), lab_entrees_val.get(id_entree));
                grid.add(hboxsE.get(id_entree), 0, id_entree);
        }
        
        //Implémentation des boutons Pas et RAZ
        HBox boxPasRAZ = new HBox(5);
        but_Pas = new Button("Pas");
        but_RAZ = new Button("RAZ");
        but_Pas.setMinSize(50, 20);
        but_RAZ.setMinSize(50, 20);
        but_Pas.setOnAction(this);
        but_RAZ.setOnAction(this);
        but_Pas.setStyle("-fx-background-color: MediumSeaGreen");
        but_RAZ.setStyle("-fx-background-color: Crimson");
        boxPasRAZ.getChildren().addAll(but_Pas, but_RAZ);
        grid.add(boxPasRAZ, 0, nombre_entrees);
        
        //Instanciation de tous les éléments contenues dans les HBox pour les lignes 
        //d'affichages correspondant aux sorties, et placent l'ensemble
        //de ces élements dans les HBox, puis les Hbox dans une grille.
        for(int id_sortie = 0; id_sortie < nombre_sorties ; id_sortie++)
        {
            lab_sorties.add(new Label("Résultat sortie " + (id_sortie -(-1))+ ":"));
            lab_sorties_val.add(new Label(""));
            hboxsS.add(new HBox(5));
            hboxsS.get(id_sortie).getChildren().addAll(lab_sorties.get(id_sortie), lab_sorties_val.get(id_sortie));
            grid.add(hboxsS.get(id_sortie), 0, id_sortie+nombre_entrees+1);
        }
        
        //Définition de la taille de la marge (padding) et des interlignes de la grille
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(20);
        
        //Création d'une nouvelle fenêtre comportant la grille, de taille variable en fonction du nombre d'entrées/sorties puis on 	l'affiche 
        primaryStage.setScene(new Scene(grid, 500, 40*(nombre_entrees+nombre_sorties+1)));
        primaryStage.setTitle("Simulateur de Circuits Logiques");
        primaryStage.show();
    }
    
    /**
     * Traitement des actions
     * 
     * @param (ActionEvent) l'évènement qui a eu lieu
     * @return (aucun)
     */
    public void handle(ActionEvent e)
    {
        //Lors de l'appui sur le bouton Pas
        if(e.getSource() == but_Pas)
        {
            //Mise à jour des valeurs d'entrées et de l'affichage
            for(int i = 0 ; i < sch.Entrees.size() ; i++)
            {
                    if(radioButtons.get(i*3).isSelected())
                    {
                        lab_entrees_val.get(i).setText(lab_entrees_val.get(i).getText() + "- 0 - ");
                        vals[i] = Fil.ZERO;
                    }
                    else if(radioButtons.get(i*3+1).isSelected())
                    {
                        lab_entrees_val.get(i).setText(lab_entrees_val.get(i).getText() + "- 1 - ");
                        vals[i] = Fil.UN;
                    }
                    else
                    {
                        lab_entrees_val.get(i).setText(lab_entrees_val.get(i).getText() + "- X - ");
                        vals[i] = Fil.X;
                    }
            }
            sch.setStimuli(vals);
            sch.calculeUnPas();
            for(int i = 0 ; i < sch.Sorties.size() ; i++)
            {
                lab_sorties_val.get(i).setText(lab_sorties_val.get(i).getText() + sch.getSortieStringInterface(i));
            }
        }
        //Lors de l'appui sur le bouton RAZ
        if(e.getSource() == but_RAZ)
        {
            //RAZ de l'affichage des états en entrées et en sortie et désélection des boutons radios
            for(int i = 0 ; i < sch.Entrees.size() ; i++)
            {
                lab_entrees_val.get(i).setText("");
                vals[i] = Fil.X;
                for(int n = 0 ; n < 3 ; n++)
                {
                    radioButtons.get(i*3+n).setSelected(false);
                }
            }
            for(int i = 0 ; i < sch.Sorties.size() ; i++)
            {
                lab_sorties_val.get(i).setText("");
            }
            sch.setStimuli(vals); //RAZ des valeurs en entrées
        }
    }
    
    /**
     * Arrêt de l'application
     * 
     * @param (aucun)
     * @return (aucun)
     */
    public void stop()
    {
        System.exit(0);
    }
    
    /**
     * main : méthode principale permettant de lancer l'application
     * 
     * @param (String[]) les arguments donnés à la méthode main
     * @return (aucun)
     */
    public static void main(String[] args)
    {
        MonInterface.launch(args);
    }
}