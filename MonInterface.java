/**
 * Cette classe permet la cr�ation d'une interface graphique permettant � l'utilisateur
 * de modifier les stimuli des entr�es du sch�ma, d'effecteur des pas de simulation, d' observer le r�sultat en sortie du circuit
 * 
 * @author Arthur GASTINEAU & Guillaume LAMOUR
 * @version v0.7
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import java.util.*;

// h�rit� de Application et v�rifie l'interface EventHandler <ActionEvent> pour la gestion des boutons
public class MonInterface extends Application implements EventHandler<ActionEvent>
{
    // d�claration des variables d'instanciation
    public static final  int X = 2; //constante definissant un �tat logique comme non-d�fini
    protected int [] valEntrees = new int[]{X,X};   //tableau contenant les stimuli en entr�e initialis� comme non-d�fini
    /**
     * D�marrage de l'application
     *
     */
    public void start(Stage primaryStage)
    {
        //cr�ation du sch�ma 
        SchemaTP schema1 = new SchemaTP();
        //choix d'un titre
        primaryStage.setTitle("Simulateur de Circuits Logiques");
        //cr�ation d'un layout pour la disposition des �lements en utilisant une grille
        GridPane root = new GridPane();
        //on place les �l�ments en ayant comme origine le centre de la grille
        root.setAlignment(Pos.CENTER);
        //on d�clare une marge de 16 pixels horizontalement et 8 pixels verticalement entre chaque �lement de la grille
        root.setHgap(16);
        root.setVgap(8);
        //cr�ation de conteneurs avec comme param�tre le nombre de pixels entre chaque �lements contenus
        HBox Entree1Box = new HBox(20);
        HBox Entree2Box = new HBox(20);
        HBox SortieBox = new HBox(10);
        //cr�ation des labels
        Label labelEntree1_type = new Label("Entr�e 1: ");
        Label labelEntree1_valeur = new Label("");
        Label labelEntree2_type = new Label("Entr�e 2:");
        Label labelEntree2_valeur = new Label("");
        Label labelSortie_type = new Label("R�sultat en sortie:");
        Label labelSortie_valeur = new Label("");
        
        //cr�ation des 6 boutons radio controllant les stimulis 
        //d�claration d'un groupe qui va contenir les 3 boutons radios du stimuli de l'entr�e1
        ToggleGroup GroupEntree1 = new ToggleGroup();
        //d�claration d'un bouton radio repr�sentant l'�tat logique 0 pour l'entr�e1
        RadioButton buttonEntree1_0 = new RadioButton("0");
        //lorsqu'il est actif on affecte � la variable concernant l'entr�e 1 la valeur 0 et on ajoute au label des stimulis de l'entr�e 1 la nouvelle valeur
        buttonEntree1_0.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                valEntrees[0] = 0;
                labelEntree1_valeur.setText(labelEntree1_valeur.getText() + "0 - ");
            }
        });
        //d�claration d'un bouton radio repr�sentant l'�tat logique 1 pour l'entr�e1
        RadioButton buttonEntree1_1 = new RadioButton("1");
        //lorsqu'il est actif on affecte � la variable concernant l'entr�e 1 la valeur 1 et on ajoute au label des stimulis de l'entr�e 1 la nouvelle valeur
        buttonEntree1_1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                valEntrees[0] = 1;
                labelEntree1_valeur.setText(labelEntree1_valeur.getText() + "1 - ");
            }
        });
        //d�claration d'un bouton radio repr�sentant l'�tat logique non-d�fini "X" pour l'entr�e1
        RadioButton buttonEntree1_X = new RadioButton("X");
        //lorsqu'il est actif on affecte � la variable concernant l'entr�e 1 la valeur X correspondant � 2 et on ajoute au label des stimulis de l'entr�e 1 la nouvelle valeur
        buttonEntree1_X.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                valEntrees[0] = X;
                labelEntree1_valeur.setText(labelEntree1_valeur.getText() + "X - ");
            }
        });
        //on rattache les 3 boutons radio au groupe
        buttonEntree1_0.setToggleGroup(GroupEntree1);
        buttonEntree1_1.setToggleGroup(GroupEntree1);
        buttonEntree1_X.setToggleGroup(GroupEntree1);
        
        //d�claration d'un groupe qui va contenir les 3 boutons radios du stimuli de l'entr�e2
        ToggleGroup GroupEntree2 = new ToggleGroup();
        //d�claration d'un bouton radio repr�sentant l'�tat logique 0 pour l'entr�e2
        RadioButton buttonEntree2_0 = new RadioButton("0");
        //lorsqu'il est actif on affecte � la variable concernant l'entr�e 2 la valeur 0 et on ajoute au label des stimulis de l'entr�e 2 la nouvelle valeur
        buttonEntree2_0.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                valEntrees[1] = 0;
                labelEntree2_valeur.setText(labelEntree2_valeur.getText() + "0 - ");
            }
        });
        //d�claration d'un bouton radio repr�sentant l'�tat logique 1 pour l'entr�e2
        RadioButton buttonEntree2_1 = new RadioButton("1");
        //lorsqu'il est actif on affecte � la variable concernant l'entr�e 2 la valeur 1 et on ajoute au label des stimulis de l'entr�e 2 la nouvelle valeur
        buttonEntree2_1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                valEntrees[1] = 1;
                labelEntree2_valeur.setText(labelEntree2_valeur.getText() + "1 - ");
            }
        });
        //d�claration d'un bouton radio repr�sentant l'�tat logique non-d�fini "X" pour l'entr�e2
        RadioButton buttonEntree2_X = new RadioButton("X");
        //lorsqu'il est actif on affecte � la variable concernant l'entr�e 2 la valeur X correspondant � 2 et on ajoute au label des stimulis de l'entr�e 2 la nouvelle valeur
        buttonEntree2_X.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                valEntrees[1] = X;
                labelEntree2_valeur.setText(labelEntree2_valeur.getText() + "X - ");
            }
        });
        //on rattache les 3 boutons radio au groupe
        buttonEntree2_0.setToggleGroup(GroupEntree2);
        buttonEntree2_1.setToggleGroup(GroupEntree2);
        buttonEntree2_X.setToggleGroup(GroupEntree2);
        
        //cr�ation des 2 boutons simples
        Button Button_RAZ = new Button("RAZ");
        //lors de l'appui du bouton RAZ on efface le contenu des 3 labels contenant la valeur des stimuli et du r�sultat de la simulation
        Button_RAZ.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
            labelEntree1_valeur.setText("");
            labelEntree2_valeur.setText("");
            labelSortie_valeur.setText("");
            //on d�sactive �galement les 6 boutons radios et on met les stimulis des entr�e � l'�tat non-d�fini
            buttonEntree1_0.setSelected(false);
            buttonEntree1_1.setSelected(false);
            buttonEntree1_X.setSelected(false);
            buttonEntree2_0.setSelected(false);
            buttonEntree2_1.setSelected(false);
            buttonEntree2_X.setSelected(false);
            for(int id_entree=0; id_entree<valEntrees.length; id_entree++) valEntrees[id_entree]=0;
            }
        });
        Button Button_Pas = new Button("Pas");
        //lors de l'appui du bouton Pas on affecte les stimuli en entr�e du sch�ma, on calcule un pas et on affiche le r�sultat de la simulation
        Button_Pas.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
            schema1.setStimuli(valEntrees);
            schema1.calculeUnPas();
            labelSortie_valeur.setText(labelSortie_valeur.getText() + " | " + schema1.getSortieString());
            }
        });
        
        //on ajoute le label constant, les 3 boutons radios et le label variable dans les HBox correspondant pour les entr�es
        Entree1Box.getChildren().addAll(labelEntree1_type, buttonEntree1_0, buttonEntree1_1, buttonEntree1_X, labelEntree1_valeur);
        Entree2Box.getChildren().addAll(labelEntree2_type, buttonEntree2_0, buttonEntree2_1, buttonEntree2_X, labelEntree2_valeur);
        //on ajoute les 2 boutons simples, le label constant et le label variable dans le HBox correspondant pour la sortie
        SortieBox.getChildren().addAll(Button_RAZ, Button_Pas, labelSortie_type, labelSortie_valeur);
        //on place chaque HBox dans une case de la grille en les pla�ant les uns sous les autres
        root.add(Entree1Box,0,0);
        root.add(Entree2Box,0,1);
        root.add(SortieBox,0,2);
        //cr�ation du fond de la fen�tre de dimension 380x300
        primaryStage.setScene(new Scene(root,380,300));
        //affichage de la fen�tre
        primaryStage.show();
    }
    
    /**
     * La m�thode handle permet le traitement des actions (h�rit� de l'interface EventHandler<ActionEvent>)
     *
     */
    public void handle(ActionEvent e)
    {
    }
    
    /**
     * La m�thode stop permet l'arr�t de l'application
     */
    public void stop()
    {
        System.exit(0);
    }
    
    /**
     * La m�thode main permet la cr�ation d'un point d'entr�e au programme, il permet le lancement de l'interface graphique
     */
    public static void main (String[] args)
    {
        MonInterface.launch(args);
    }
}
