package pfund.tpi.tetridroid;

/**
 * Created by pfundjo on 01.05.2015.
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

    public GameFunction(){

    }

    // State of the game
    boolean GameStarted = false;
    boolean GamePaused = false;
    boolean GameStopped = false;
    boolean GameRunning = false;

    public void getGameState(){

    }

    public void setGameState(){

    }

    public void StartNewGame(){


    }

    public void UpdateScore(int PointToAdd){

        myLevel.AddPoint(PointToAdd);
    }
}
