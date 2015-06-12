package pfund.tpi.tetridroid.Activity;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import pfund.tpi.tetridroid.Fragments.GameGridFragment;
import pfund.tpi.tetridroid.Fragments.LevelFragment;
import pfund.tpi.tetridroid.Fragments.OpponentFragment;
import pfund.tpi.tetridroid.Fragments.ScoreFragment;
import pfund.tpi.tetridroid.R;

/*
    Title :       VersusActivity
    Summary :     Class that contains the activity in Versus mode
    Creator :     Joel Pfund
    Created :     24.04.2015
    Modified :    27.05.2015
 */
public class VersusActivity extends ActionBarActivity
         implements OpponentFragment.OnFragmentInteractionListener,
                    GameGridFragment.OnFragmentInteractionListener,
                    LevelFragment.OnFragmentInteractionListener,
                    ScoreFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_versus);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_versus, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent Activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onFragmentInteraction(Uri uri) {
        // The user selected the headline of an article from the HeadlinesFragment
        // Do something here to display that article

    } // onFragmentInteraction

}
