package pfund.tpi.tetridroid;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import pfund.tpi.tetridroid.Bricks.Brick;
import pfund.tpi.tetridroid.Fragments.GameGridFragment;


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

    // Score points
    int SingleLine = 100;
    int DoubleLine = 300;
    int TripleLine = 500;
    int Tetris = 800;
    int SimpleDescent = 1;
    int ForcedDescent = 2;

    Level myLevel = new Level();
    GameGridFragment gameGridFragment = new GameGridFragment();

    // State of the game
    private boolean GameIsStarted = false;
    private boolean GameIsRunning = false;

    // Constructeur
    public GameFunction(){

    }

    public void StartNewGame(){

        GameIsStarted = true;
        DelayBeforeStart();

        //MediaPlayer music = checkOptions();
        //Toast.makeText(this,
        //        "Game is started !", Toast.LENGTH_LONG).show();
    }


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

    public void PauseGame() {
        setCurrentGameState(!getCurrentGameState());

        if (getCurrentGameState()){
            DelayBeforeStart();
        }
        else{
            // Stopper le mouvement des pièces...
        }
    }


    /*  Summary :   Met fin au jeu si le joueur confirme l'action
    *   Param. :    Nothing
    *   Returns:    Nothing
    *   Exception : -
    */
    public void StopGame(){


        setGameState(false);
    }


    /*  Summary :   Compte à rrebours de 3 secondes avant de démarrer/reprendre la partie
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

        // gameGridFragment.launchNewBrick(nextBrick);

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
    }
}
