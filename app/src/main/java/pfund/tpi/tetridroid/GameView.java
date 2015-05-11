package pfund.tpi.tetridroid;

import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridLayout;

import java.lang.reflect.Array;

/**
 * Titre :       GameView
 * Description : Classe qui gere l'affichage du jeu et des intéractions entre
 *               les différentes activités et fragments
 * Créateur :    Joël Pfund
 * Créé le :     08.05.2015
 * Modifié le :  08.05.2015
 */

public class GameView extends ActionBarActivity
     implements GameGridFragment.OnFragmentInteractionListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);

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
