package pfund.tpi.tetridroid;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.Random;

/**
 * Titre :       GameGrid
 * Description : Classe qui gère la grille où se déroule le jeu
 * Créateur :    Joël Pfund
 * Créé le :     04.05.2015
 * Modifié le :  07.05.2015
 */

public class GameGrid extends ActionBarActivity {

    private int ScreenWidth, ScreenHeight;
    private int GridWidth = 10;
    private int GridHeight = 23;
    private Button[][] ArrayButton;
    public GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_game);

        ArrayButton = new Button[GridHeight][GridWidth];
        gridLayout = (GridLayout) findViewById(R.id.myGridLayout);

        getScreenSize();

        for(int x = 0; x < GridHeight; x++) {
            for(int y = 0; y < GridWidth; y++) {

                ArrayButton[x][y] = new Button(this);
                ArrayButton[x][y].setBackgroundColor(Color.TRANSPARENT);
                gridLayout.addView(ArrayButton[x][y]);

                setViewParams(ArrayButton[x][y]);
            }
        }
    } // OnCreate

    /*  Summary :   Contrôle de la grille de jeu pour chercher si des lignes sont complètes
    *   Param. :    Nothing
    *   Returns:    Nothing
    *   Exception : -
    */
    // TODO : Pour la suite, chercher uniquement dans les lignes où des pièces tombent quand ça sera fait => Economie de ressources/temps
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

    /*  Summary :   Set les paramêtres de taille des boutons dans la grille de jeu
    *   Param. :    Bouton auquel appliquer les réglages
    *   Returns:    Nothing
    *   Exception : -
    */
    public void setViewParams(Button button){

        int Margin = 1;

        GridLayout.LayoutParams ButtonParams = (GridLayout.LayoutParams) button.getLayoutParams();

        ButtonParams.height = (ScreenHeight*3/4 ) / GridHeight;
        ButtonParams.width = ButtonParams.height;

        ButtonParams.setMargins(Margin, Margin, Margin, Margin);

        System.out.println("ButtonParams.height = "+ ButtonParams.height);

        button.setLayoutParams(ButtonParams);
    } // SetViewParams


    /*  Summary :   Set la taille de la grille de jeu
    *   Param. :    Nothing
    *   Returns:    Nothing
    *   Exception : -
    */
    public void getScreenSize(){

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        ScreenWidth = size.x;
        ScreenHeight = size.y;

        System.out.println(ScreenWidth);
        System.out.println(ScreenHeight);


    }
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
