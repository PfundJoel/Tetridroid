package pfund.tpi.tetridroid;



import android.os.Handler;

import pfund.tpi.tetridroid.Fragments.GameGridFragment;


/**
 * Title :       GameFunction
 * Description : Classe qui g�re le fonctionnement global du jeu, pause, reprendre,
 *               nouvelle partie, mise � jour des points, ...
 * Author :      Jo�l Pfund
 * Created :     31.04.2015
 * Modified :    11.05.2015
 */
public class GameFunction {


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


    public GameFunction(){

    }

    public void StartNewGame(){

        GameIsStarted = true;
        DelayBeforeStart();

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
            // Stopper le mouvement des pi�ces...
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

    /*  Summary :   Compte � rrebours de 3 secondes avant de d�marrer/reprendre la partie
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
    /*  Summary :   Contr�le de la grille pour voir s'il faut �liminer des lignes
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
}
