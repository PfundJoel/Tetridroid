package pfund.tpi.tetridroid.Activity;

import android.app.Fragment;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import pfund.tpi.tetridroid.Bricks.Brick;
import pfund.tpi.tetridroid.Fragments.GameGridFragment;
import pfund.tpi.tetridroid.Fragments.LevelFragment;
import pfund.tpi.tetridroid.Fragments.ScoreFragment;
import pfund.tpi.tetridroid.Class.GameFunction;
import pfund.tpi.tetridroid.R;

/**
 * Titre :       GameView
 * Description : Classe qui gere l'affichage du jeu et des interactions entre
 *               les differentes activites et fragments
 * Createur :    Joel Pfund
 * Créé le :     08.05.2015
 * Modifié le :  08.05.2015
 */

public class GameView extends ActionBarActivity
     implements GameGridFragment.OnFragmentInteractionListener,
                ScoreFragment.OnFragmentInteractionListener,
                LevelFragment.OnFragmentInteractionListener{

    GameFunction currentGame;
    Brick brick;
    Fragment gridFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);

        currentGame = new GameFunction();

        //currentGame.StartNewGame();

        currentGame.launchNewBrick(brick.newBrick());

    } // onCreate


    public void onFragmentInteraction(Uri uri) {
        // The user selected the headline of an article from the HeadlinesFragment
        // Do something here to display that article

    } // onFragmentInteraction


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_view, menu);
        return true;

    } // onCreateOptionsMenu


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

    } // onOptionsItemSelected



}
