package pfund.tpi.tetridroid.Class;

/**
 * Created by pfundjo on 04.05.2015.
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
    private double delayBeforeGetDown = 1000;
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
        delayBeforeGetDown = 1000/Speed;
    }

    public int getLevel() {
        return Level;
    }

    public int getNbLine() {
        return NbLine;
    }

    public double getSpeed(){
        return delayBeforeGetDown;
    }

    /*  Summary :   Change le nombre de lignes à atteindre (s'il n'est pas déjà à la limite fixée)
    *               avant d'atteindre le prochain niveau
    *   Param. :    Nouveau niveau du joueur
    *   Returns:    Nombre de lignes à atteindre pour le prochain niveau
    *   Exception : -
    */
    public int ChangeLineToReach(int level){

        if (NbLineToReach < LimitNbLine) {

            NbLineToReach = level * MultipleLine;
        }

        return NbLineToReach;
    }

    /*  Summary :   Augmente la vitesse de descente des pièces
    *   Param. :    Vitesse en cours à augmenter
    *   Returns:    Nouvelle vitesse
    *   Exception : -
    */
    public double SpeedUp(double SpeedToChange) {

        SpeedToChange += SpeedToAdd;
        delayBeforeGetDown = 1/SpeedToChange;

        return SpeedToChange;
    }

    /*  Summary :   Ajoute les points au score actuel
    *   Param. :    Points à ajouter
    *   Returns:    Nothing
    *   Exception : -
    */
    public void AddPoint(int PointToAdd){
        Score += PointToAdd;
    }
}
