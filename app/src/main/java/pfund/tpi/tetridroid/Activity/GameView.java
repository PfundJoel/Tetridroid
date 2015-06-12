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

/*
 * Title :       GameView
 * Summary :     Class that manage the game view and that makes the interaction between this class and the game functionnality
 * Creator :     Joel Pfund
 * Created :     08.05.2015
 * Modified :    30.05.2015
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
    } // onCreate


    /*  Summary :   Delete the old place of the brick when the brick go down
    *   Param. :    The brick that move
    *   Returns:    nothing
    *   Exception : -
    */
    public void deleteOldBricks(Brick brick){

        gameGridFragment = (GameGridFragment) getFragmentManager().findFragmentById(R.id.FragmentGameGrid);

        System.out.println("_________DeleteBrick__________");

        boolean isntFirstLine = true;
        int positionX, positionY;

        for (int i = 0; i < brick.coordBrick.length; i++){

            positionX = (brick.coordBrick[i][1]);
            positionY = brick.coordBrick[i][0];

            if(positionX <= 0){
                isntFirstLine = false;
            }
        }

        if (isntFirstLine){
            for (int i = 0; i < brick.coordBrick.length; i++){

                final int positionX2 = (brick.coordBrick[i][1])-1;
                final int positionY2 = brick.coordBrick[i][0];

                System.out.println(positionX2 + " " + positionY2);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gameGridFragment.ArrayButton[positionX2][positionY2].setBackgroundResource(R.drawable.square);
                    }
                });

            }
        }

    } // updateBricks


    /*  Summary :   Update the grid when the brick go down
    *   Param. :    la brique a afficher sur la grille
    *   Returns:    nothing
    *   Exception : -
    */
    public void updateBricks(final Brick brick){
        gameGridFragment = (GameGridFragment) getFragmentManager().findFragmentById(R.id.FragmentGameGrid);

        System.out.println("_________UpdateBrick__________");

        //int positionX, positionY;

        for (int i = 0; i < brick.coordBrick.length; i++){
            final int positionX = brick.coordBrick[i][1];
            final int positionY = brick.coordBrick[i][0];

            System.out.println(positionX + " " + positionY);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    gameGridFragment.ArrayButton[positionX][positionY].setBackgroundResource(brick.brickBackground);
                }
            });

        }
    } // updateBricks


    /*  Summary :   Launch a new brick on the game grid and takes it coordonates for change the button's colour
    *   Param. :    Brick to show on  the game grid
    *   Returns:    nothing
    *   Exception : -
    */
    public void launchNewBrick(Brick brick){
        gameGridFragment = (GameGridFragment) getFragmentManager().findFragmentById(R.id.FragmentGameGrid);

        System.out.println(" -_ LaunchNewBrick _- ");

        int[][] position = brick.coordBrick;
        for (int i = 0; i < position.length; i++){
            gameGridFragment.ArrayButton[position[i][1]][position[i][0]]
                    .setBackgroundResource(brick.brickBackground);
        }
    } // launchNewBrick


    /*  Summary :   Check if the brick has something who can stop his movement down
    *   Param. :    -
    *   Returns:    Boolean : true if the brick can go down, false if it can't
    *   Exception : -
    */
    public boolean canBrickGoDown(Brick brick) {

        System.out.println(" -_ canBrickGoDown _- ");

        for(int i = 0; i < brick.coordBrick.length; i++) {
            System.out.println(brick.coordBrick[i][0] +" "+brick.coordBrick[i][1]);
            if (brick.coordBrick[i][0] == gameGridFragment.ArrayButton.length){
                return false;
            } else if (gameGridFragment.ArrayButton[brick.coordBrick[i][0]+1][brick.coordBrick[i][1]]
                    .getBackground() == getResources().getDrawable(R.drawable.square)){
                return false;
            }
        }
        return true;
    } // canBrickGoDown


    public void onFragmentInteraction(Uri uri) { } // onFragmentInteraction


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_game_view, menu);
        return true;
    } // onCreateOptionsMenu


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            currentGame.StopGame();
            return true;
        }
        return super.onOptionsItemSelected(item);

    } // onOptionsItemSelected


    @Override
    protected void onPause() {
        super.onPause();

    }

    protected void plop(){
        // prout
    }
}
