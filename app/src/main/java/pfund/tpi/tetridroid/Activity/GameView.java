package pfund.tpi.tetridroid.Activity;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import pfund.tpi.tetridroid.Bricks.Brick;
import pfund.tpi.tetridroid.Fragments.GameGridFragment;
import pfund.tpi.tetridroid.Fragments.LevelFragment;
import pfund.tpi.tetridroid.Fragments.ScoreFragment;
import pfund.tpi.tetridroid.Class.GameFunction;
import pfund.tpi.tetridroid.R;

/**
 * Titre :       GameView
 * Description : Classe qui gere l'affichage du jeu et des interactions entre
 *               les differentes activites et Fragments
 * Createur :    Joel Pfund
 * Cr éé le :     08.05.2015
 * Modifié le :  08.05.2015
 */

public class GameView extends ActionBarActivity
     implements GameGridFragment.OnFragmentInteractionListener,
                ScoreFragment.OnFragmentInteractionListener,
                LevelFragment.OnFragmentInteractionListener{

    GameGridFragment gameGridFragment;

    GameFunction currentGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);

        currentGame = new GameFunction(this);

        currentGame.StartNewGame();

        // Thread du fonctionnement global du jeu
        Thread gameThread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    GameView.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            currentGame.gameLoop();
                        }
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } // run the gameLoop
        });
        gameThread.start();
    }

    public void updateBricks(Brick brick){
        gameGridFragment = (GameGridFragment) getFragmentManager().findFragmentById(R.id.FragmentGameGrid);

        Button button = new Button(getApplicationContext());
        button.setBackgroundResource(R.drawable.bugdroidyellow);
        gameGridFragment.setViewParams(button);

        System.out.println("TEST !!! ");

        try {
            gameGridFragment.gridLayout.removeViewAt(10);
            gameGridFragment.gridLayout.addView(button);
        }
        catch(Exception e){
            System.err.println("Error "+e);
        }
    }


    /*  Summary :   Lance la piece sur la grille de jeu en recuperant les coordonnees de la piece
    *               afin de faire changer la couleur des cases ou elle se trouve
    *   Param. :    la brique a afficher sur la grille
    *   Returns:    nothing
    *   Exception : -
    */
    public void launchNewBrick(Brick brick){

        gameGridFragment = (GameGridFragment) getFragmentManager().findFragmentById(R.id.FragmentGameGrid);

        int[][] position = brick.coordBrick;

        for (int i = 0; i < position.length; i++){

            System.out.println(brick.coordBrick[i][0]);
            System.out.println(brick.coordBrick[i][1]);

            gameGridFragment.ArrayButton[position[i][0]][position[i][1]].setBackgroundResource(brick.brickBackground);
        }
    } // launchNewBrick


    public void onFragmentInteraction(Uri uri) { } // onFragmentInteraction


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
        // as you specify a parent Activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    } // onOptionsItemSelected



}
