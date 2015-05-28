package pfund.tpi.tetridroid.Class;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;

import pfund.tpi.tetridroid.Activity.GameView;
import pfund.tpi.tetridroid.Activity.OptionView;
import pfund.tpi.tetridroid.Bricks.Brick;
import pfund.tpi.tetridroid.Fragments.GameGridFragment;
import pfund.tpi.tetridroid.R;


/**
 * Title :       GameFunction
 * Description : Classe qui gère le fonctionnement global du jeu, pause, reprendre,
 *               nouvelle partie, mise à jour des points, ...
 * Author :      Joël Pfund
 * Created :     31.04.2015
 * Modified :    22.05.2015
 */
public class GameFunction extends OptionView {

    public static final String PREFS_OPTIONS = "Tetridroid";

    int[][] position;

    Level myLevel = new Level();
    GameView gameView;

    Brick currentBrick;
    Brick nextBrick;

    GameGridFragment gameGridFragment;
    // State of the game
    private boolean GameIsStarted = false;
    private boolean GameIsRunning = false;

    // Constructeur
    public GameFunction(GameView gameView){
        this.gameView = gameView;
    }

    public void StartNewGame(){

        GameIsStarted = true;
        GameIsRunning = true;

        DelayBeforeStart();

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

    // Met le jeu en pause s'il est en cours ou le reprend s'il est en pause


    /*  Summary :   Put the game in pause if it's running or resume after a delay if it's paused
    *   Param. :    Nothing
    *   Returns:    Nothing
    *   Exception : -
    */
    public void PauseGame() {
        setCurrentGameState(!getCurrentGameState());

        if (getCurrentGameState()){
            DelayBeforeStart();
        }
        else{
            setCurrentGameState(false);
        }
    } // PauseGame


    /*  Summary :   Met fin au jeu si le joueur confirme l'action
    *   Param. :    Nothing
    *   Returns:    Nothing
    *   Exception : -
    */
    public void StopGame(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

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

    }


    /*  Summary :   Compte a rebours de 3 secondes avant de démarrer/reprendre la partie
    *   Param. :    Nothing
    *   Returns:    Nothing
    *   Exception : -
    */
    public void DelayBeforeStart(){

        // TODO: Ajouter une animation sympa
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // StartGame

            }
        }, 3000);

    }


    /*  Summary :   Boucle qui contient les "tours" du jeu.
    *   Param. :    Nothing
    *   Returns:    Nothing
    *   Exception : -
    */
    public void gameLoop() {

        CreateBrick();

        // La piece "next" devient la piece en cours
        currentBrick = nextBrick;

        // On cree une nouvelle piece
        CreateBrick();

        // On lance la brique sur la grille
        gameView.launchNewBrick(currentBrick);

        do {
            currentBrick.Positionning(0);
            gameView.updateBricks(currentBrick);

        } while (canBrickGoDown() && GameIsRunning);

    } // gameLoop


    /*  Summary :   Controle si la piece est arrivee contre un obstacle.
    *   Param. :    -
    *   Returns:    Booleen : true si la piece peut descendre / False si elle est bloquee
    *   Exception : -
    */
    public boolean canBrickGoDown(){
        int x = currentBrick.getCoordX();
        int y = currentBrick.getCoordY();

        for(int i = 0; i < currentBrick.coordBrick.length; i++) {
            if (gameGridFragment.ArrayButton[x + currentBrick.coordBrick[i][0]+1][y + currentBrick.coordBrick[i][1]].getBackground() == getResources().getDrawable(R.drawable.square)){
                return false;
            }
        }
        return true;
    }


    /*  Summary :   Creer une nouvelle piece
    *               afin de faire changer la couleur des cases
    *   Param. :    la brique a afficher sur la grille
    *   Returns:    nothing
    *   Exception : -
    */
    public void CreateBrick(){

        nextBrick = new Brick() { };
        nextBrick.newBrick();

    }


    /*  Summary :   Contrôle de la grille pour voir s'il faut éliminer des lignes
    *   Param. :    Nothing
    *   Returns:    Nothing
    *   Exception : -
    */
    public void CheckGrid(){
        gameGridFragment.CheckLine();
    }


    /*  Summary :   Ajoute les points au score total
    *   Param. :    Points that we have to add to the score
    *   Returns:    Nothing
    *   Exception : -
    */
    public void UpdateScore(int PointToAdd){

        myLevel.AddPoint(PointToAdd);
    }


    /*  Summary :   Contrôle les options gérer les lecteurs de son et de musique
    *   Param. :    -
    *   Returns:    Nothing
    *   Exception : -
    */
    private MediaPlayer checkOptions(){

/*      String isMusicOn = PlayerProfile.getString(SP_Music, "");
        String isSoundOn = PlayerProfile.getString(SP_Sound, "");

        MediaPlayer TetrisMusic = MediaPlayer.create(this, R.raw.tetrissong);
*/
        // TODO: Changer les sons du jeu
        MediaPlayer GameSounds = MediaPlayer.create(this, R.raw.tetrissong);

/*
        if (isMusicOn == "On"){
            TetrisMusic.start();
            TetrisMusic.setLooping(true);
        }

        if (isSoundOn == "Off"){

            GameSounds.reset();
        }
*/
        return GameSounds;
    } // checkOptions

}
