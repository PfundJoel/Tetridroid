package pfund.tpi.tetridroid;

/**
 * Created by pfundjo on 04.05.2015.
 */
public class Level {

    int MultipleLine = 5;
    int LimitNbLine = 50;
    double SpeedToAdd = 0.2;


    // Default Value
    private int Level = 1;
    private int NbLineToReach = 5;
    private int NbLine = 0;
    private double Speed = 1.0;
    private int Score = 0;


    public void setLevel(int level) {
        Level = level;
    }

    public void setNbLine(int nbLine) {
        NbLine = nbLine;
    }

    public void SetSpeed(double speed){
        Speed = speed;
    }

    public int getLevel() {
        return Level;
    }

    public int getNbLine() {
        return NbLine;
    }

    public double getSpeed(){
        return Speed;
    }

    public int ChangeLineToReach(int level){

        if (NbLineToReach < LimitNbLine) {

            NbLineToReach = level * MultipleLine;
        }

        return NbLineToReach;
    }

    public double SpeedUp(double SpeedToChange) {

        SpeedToChange += SpeedToAdd;

        return SpeedToChange;
    }

    public void AddPoint(int PointToAdd){
        Score += PointToAdd;
    }
}
