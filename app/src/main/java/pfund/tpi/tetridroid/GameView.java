package pfund.tpi.tetridroid;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import pfund.tpi.tetridroid.Bricks.Brick;
import pfund.tpi.tetridroid.Fragments.GameGridFragment;
import pfund.tpi.tetridroid.Fragments.LevelFragment;
import pfund.tpi.tetridroid.Fragments.ScoreFragment;

/**
 * Titre :       GameView
 * Description : Classe qui gere l'affichage du jeu et des interactions entre
 *               les differentes activites et fragments
 * Créateur :    Joel Pfund
 * Créé le :     08.05.2015
 * Modifié le :  08.05.2015
 */

public class GameView extends ActionBarActivity
     implements GameGridFragment.OnFragmentInteractionListener,
                ScoreFragment.OnFragmentInteractionListener,
                LevelFragment.OnFragmentInteractionListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);

        GameFunction currentGame = new GameFunction();

        currentGame.StartNewGame();

    }

    /*  Summary :   Lance la piece sur la grille de jeu en recuperant les coordonnees de la piece
    *               afin de faire changer la couleur des cases
    *   Param. :    la brique a afficher sur la grille
    *   Returns:    nothing
    *   Exception : -
    */
    public void launchNewrick(Brick brick){
        int[][] position = brick.coordBrick;
        for (int x = 0; x < position.length; x++){

        }
    }
    public void onFragmentInteraction(Uri uri) {
        // The user selected the headline of an article from the HeadlinesFragment
        // Do something here to display that article
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_view, menu);
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

}
