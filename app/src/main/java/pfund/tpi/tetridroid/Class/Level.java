package pfund.tpi.tetridroid.Class;

/**
 * Title :       Level
 * Description : Class that manage the points, lines and level of the game
 * Author :      Joel Pfund
 * Created :     04.05.2015
 * Modified :    27.05.2015
 */
public class Level {

    // Default Value
    int MultipleLine = 5;
    int LimitNbLine = 50;
    double SpeedToAdd = 0.2;

    private int Level = 1;
    private int NbLineToReach = 5;
    private int NbLine = 0;
    private double Speed = 1.0;
    private int delayBeforeGetDown = 1000;
    private int Score = 0;

    // Score points
    int SingleLine = 100;
    int DoubleLine = 300;
    int TripleLine = 500;
    int Tetris = 800;
    int SimpleDescent = 1;
    int ForcedDescent = 2;

    public void setLevel(int level) {
        Level = level;
    }

    public void setNbLine(int nbLine) {
        NbLine = nbLine;
    }

    public void SetSpeed(double speed){
        Speed = speed;
        delayBeforeGetDown = (int) (1000/Speed);
    }

    public int getLevel() {
        return Level;
    }

    public int getNbLine() {
        return NbLine;
    }

    public int getSpeed(){
        return delayBeforeGetDown;
    }


    /*  Summary :   Change the number of linento reach if it's not already to the fixed limit
    *               for change level
    *   Param. :    New gamer's level
    *   Returns:    New number of line to reach for next level
    *   Exception : -
    */
    public int ChangeLineToReach(int level){

        if (NbLineToReach < LimitNbLine) {

            NbLineToReach = level * MultipleLine;
        }

        return NbLineToReach;
    } // ChangeLineToReach


    /*  Summary :   Increase the brick's speed
    *   Param. :    Current speed
    *   Returns:    New speed
    *   Exception : -
    */
    public int SpeedUp(int SpeedToChange) {

        SpeedToChange += SpeedToAdd;
        delayBeforeGetDown = (int) 1/SpeedToChange;

        return SpeedToChange;
    } // SpeedUp


    /*  Summary :   Add points to current score
    *   Param. :    Points to add
    *   Returns:    Nothing
    *   Exception : -
    */
    public void AddPoint(int PointToAdd){
        Score += PointToAdd;
    }
}
