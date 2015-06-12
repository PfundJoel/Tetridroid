package pfund.tpi.tetridroid.Class;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;

import pfund.tpi.tetridroid.Activity.GameView;
import pfund.tpi.tetridroid.Activity.OptionView;
import pfund.tpi.tetridroid.Bricks.Brick;
import pfund.tpi.tetridroid.Fragments.GameGridFragment;
import pfund.tpi.tetridroid.R;


/**
 * Title :       GameFunction
 * Description : Class that manage the global functions of the game... Play, Pause, Resume, Start new game, scores
 * Author :      Joel Pfund
 * Created :     31.04.2015
 * Modified :    30.05.2015
 */
public class GameFunction extends OptionView {
    public static final String PREFS_OPTIONS = "Tetridroid";
    public SharedPreferences PlayerProfile;

    int[][] position;

    Level myLevel = new Level();
    GameView gameView;

    public Brick currentBrick;
    public Brick nextBrick;

    GameGridFragment gameGridFragment;

    // State of the game
    private boolean GameIsStarted = false;
    private boolean GameIsRunning = false;

    public GameFunction(GameView gameView){
        this.gameView = gameView;
    }

    /**
     * Task to run on the UIThread because they change the User Interface
     **/

    // - Launch new Brick on the grid
    Thread launchBrickThread = new Thread(new Runnable() {
        @Override
        public void run() {
            GameFunction.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    gameView.launchNewBrick(currentBrick);
                } // run
            });
        } // run
    });

    // - Move the Brick down and wait
    Thread updateThread = new Thread(new Runnable() {
        @Override
        public void run() {
            GameFunction.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    gameView.updateBricks(currentBrick);

                } // run
            });
        } // run
    });


    /** Summary :   Start a new game
     *   Param. :    Nothing
     *   Returns:    Nothing
     *   Exception : -
     */
    public void StartNewGame() {
        GameIsStarted = true;
        GameIsRunning = true;

        DelayBeforeStart();
        nextBrick = CreateBrick();


        Thread game = new Thread(new Runnable() {

            @Override
            public void run() {
                while (getCurrentGameState()) {
                    gameLoop();
                }

            }
        });
        game.start();


    } // startNewGame

    public boolean getGameState(){
        return GameIsStarted;
    }
    public boolean getCurrentGameState(){
        return GameIsRunning;
    }

    public void setGameState(boolean gameIsStarted){
        GameIsStarted = gameIsStarted;
    }
    public void setCurrentGameState(boolean gameIsRunning){
        GameIsRunning = gameIsRunning;
    }


    /** Summary :   Put the game in pause if it's running or resume after a delay if it's paused
     *   Param. :    Nothing
     *   Returns:    Nothing
     *   Exception : -
     */
    public void PauseGame() {
        setCurrentGameState(!getCurrentGameState());

        if (getCurrentGameState()){
            DelayBeforeStart();
        }
        else {
            setCurrentGameState(false);
        }
    } // PauseGame


    /** Summary :   Stop the game if the gamer confirm the action
     *   Param. :    Nothing
     *   Returns:    Nothing
     *   Exception : -
     */
    public void StopGame(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(gameView);
        alertDialogBuilder.setTitle("Attention");
        alertDialogBuilder
                .setMessage("Voulez-vous vraiment quitter ?")
                .setCancelable(false)
                .setPositiveButton("Oui",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close current Activity
                        setGameState(false);
                        GameFunction.this.finish();
                    }
                })
                .setNegativeButton("Non",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close the dialog box and do nothing
                        dialog.cancel();
                    }
                });
        // create alert dialog and show it
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    } // StopGame


    /** Summary :   Timer of 3 seconds before start or resume the game.
     *   Param. :    Nothing
     *   Returns:    Nothing
     *   Exception : -
     */
    public void DelayBeforeStart(){
        Thread pauseThread = new Thread(new Runnable() {

            @Override
            public void run() {
                GameFunction.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("_____Delay before start_____");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } // run
                });
            } // run
        });
        pauseThread.start();
    } // DelayBeforeStart


    /** Summary :   Loop that contains the "round" of the game
     *   Param. :    Nothing
     *   Returns:    Nothing
     *   Exception : -
     */
    public void gameLoop() {

        currentBrick = nextBrick;// nextBrick;
        //CreateBrick();
        //launchBrickThread.start();
        gameView.deleteOldBricks(currentBrick);

        //TODO if newBrick =>
        //gameView.launchNewBrick(currentBrick);

        gameView.updateBricks(currentBrick);

        try {
            Thread.sleep(myLevel.getSpeed());
            //updateThread.sleep(myLevel.getSpeed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        currentBrick.Positionning(0);
        //updateThread.start();

    } // gameLoop


    /** Summary :   Create a new brick
     *   Param. :    nothing
     *   Returns:    nothing
     *   Exception : -
     */
    public Brick CreateBrick(){

        Brick brick = new Brick() { };
        brick = brick.newBrick();

        return brick;
    } // CreateBrick


    /** Summary :   Check the grid for see if it's necessary to delete line
     *   Param. :    Nothing
     *   Returns:    Nothing
     *   Exception : -
     */
    public void CheckGrid(){
        gameGridFragment.CheckLine();
    }


    /** Summary :   Ajoute les points au score total
     *   Param. :    Points that we have to add to the score
     *   Returns:    Nothing
     *   Exception : -
     */
    public void UpdateScore(int PointToAdd){
        myLevel.AddPoint(PointToAdd);
    } // UpdateScore


    /** Summary :   Check the option for see if music or sounds have to be played
     *   Param. :    -
     *   Returns:    Nothing
     *   Exception : -
     */
    private MediaPlayer checkOptions(){

        String isMusicOn = PlayerProfile.getString(SP_Music, "");
        String isSoundOn = PlayerProfile.getString(SP_Sound, "");

        MediaPlayer TetrisMusic = MediaPlayer.create(this, R.raw.tetrissong);

        // TODO: Changer les sons du jeu
        MediaPlayer GameSounds = MediaPlayer.create(this, R.raw.tetrissong);


        if (isMusicOn == "On"){
            TetrisMusic.start();
            TetrisMusic.setLooping(true);
        }

        if (isSoundOn == "Off"){

            GameSounds.reset();
        }

        return GameSounds;
    } // checkOptions
}
