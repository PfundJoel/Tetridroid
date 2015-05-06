package pfund.tpi.tetridroid;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.Random;

/**
 * Titre :       GameGrid
 * Description : Classe qui gere la grille où se déroule le jeu
 * Créateur :    Joël Pfund
 * Créé le :     04.05.2015
 * Modifié le :  06.05.2015
 */

public class GameGrid extends ActionBarActivity {

    private int GridWidth = 10;
    private int GridHeight = 23;
    private Button[][] ArrayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_game);

        ArrayButton = new Button[GridHeight][GridWidth];

        for(int i = 0; i < GridHeight; i++) {
            for(int j = 0; j < GridWidth; j++) {
                ArrayButton[i][j] = new Button(this);
                ArrayButton[i][j].setBackgroundColor(Color.TRANSPARENT);
            }
        }
    } // OnCreate

    /*  Summary :   Contrôle de la grille de jeu pour chercher si des lignes sont complètes
    *   Param. :    Nothing
    *   Returns:    Nothing
    *   Exception : -
    */
    // TODO : Pour la suite, chercher uniquement dans les lignes où des pièces tombent quand ça sera fait
    public void CheckLine(){

        int Counter = 0;
        ColorDrawable buttonColor;

        for (int LineNumber = 0; LineNumber < GridHeight; LineNumber++) {
            for (int y = 0; y < GridWidth; y++) {

                if (((ColorDrawable) ArrayButton[LineNumber][y].getBackground()).getColor() != Color.TRANSPARENT) {
                    Counter++;
                }

                if (Counter == GridWidth) {
                    DeleteLine(LineNumber);
                }
            }
        }
    } //CheckLine

    /*  Summary :   Effacer la ligne et faire descendre les pièces du dessus
    *   Param. :    Numéro de la ligne à supprimer
    *   Returns:    Nothing
    *   Exception : -
    */
    // TODO: A contrôler pour les lignes multiples à supprimer
    public void DeleteLine(int LineNumber){

        ColorDrawable buttonColor;
        int Counter = 0;

        // Bouclie qui décale toutes les lignes vers le bas jusqu'à ce qu'ils n'y aient plus de boutons colorés au dessus-d'elles
        do {
            Counter = 0;

            for (int x = 0; x < GridWidth; x++){
                if (((ColorDrawable)ArrayButton[LineNumber-1][x].getBackground()).getColor() == Color.TRANSPARENT){
                    Counter++;
                }
                ArrayButton[LineNumber][x].setBackgroundColor(((ColorDrawable) ArrayButton[LineNumber-1][x].getBackground()).getColor());
            }

            LineNumber --;

        } while (Counter < GridWidth);

    } //DeleteLine


    /*  Summary :   Ajout de ligne(s) au bas de la grille
    *   Param. :    Nombre de lignes à ajouter
    *   Returns:    Nothing
    *   Exception : -
    */
    public void AddLine(int NbLine){

        for (int LineNumber = 0; LineNumber < GridHeight; LineNumber++) {

            if(LineNumber == GridHeight-1) {

                CreateRandomLine(NbLine);
            }
            else{

                for (int y = 0; y < GridWidth; y++) {
                    ArrayButton[LineNumber][LineNumber].setBackgroundColor(((ColorDrawable) ArrayButton[LineNumber + 1][LineNumber].getBackground()).getColor());
                }
            }
        }
    } // AddLine

    /*  Summary :   Créer un nombre de lignes d'après le chiffre passé en paramètre de couleurs aléatoires
    *   Param. :    Nombre de lignes à ajouter
    *   Returns:    Nothing
    *   Exception : -
    */
    public void CreateRandomLine(int NbLineToAdd){

        Random random = new Random();
        int LineToDo;

        for (int x = 0; x <= NbLineToAdd; x++){
            for (int y = 0; y < GridWidth; y++) {

                LineToDo = GridHeight-x;

                int randomHole = random.nextInt(9);
                int randomNumber = random.nextInt(6);

                if (y == randomHole) {
                    ArrayButton[GridHeight][x].setBackgroundColor(Color.TRANSPARENT);
                }
                else{
                    switch (randomNumber) {
                        case 0:
                            ArrayButton[LineToDo][y].setBackgroundColor(Color.BLUE);
                            break;
                        case 1:
                            ArrayButton[LineToDo][y].setBackgroundColor(Color.CYAN);
                            break;
                        case 2:
                            ArrayButton[LineToDo][y].setBackgroundColor(Color.YELLOW);
                            break;
                        case 3:
                            ArrayButton[LineToDo][y].setBackgroundColor(Color.RED);
                            break;
                        case 4:
                            ArrayButton[LineToDo][y].setBackgroundColor(Color.GREEN);
                            break;
                        case 5:
                            ArrayButton[LineToDo][y].setBackgroundColor(Color.MAGENTA);
                            break;
                        case 6:
                            ArrayButton[LineToDo][y].setBackgroundColor(Color.GRAY);
                            break;
                    }
                }
            }
        }
    } // CreateRandomLine

    /*
    INUTILE POUR L'INSTANT...
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_grid_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/
}
