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

    /*  Summary :   Change le nombre de lignes � atteindre (s'il n'est pas d�j� � la limite fix�e)
    *               avant d'atteindre le prochain niveau
    *   Param. :    Nouveau niveau du joueur
    *   Returns:    Nombre de lignes � atteindre pour le prochain niveau
    *   Exception : -
    */
    public int ChangeLineToReach(int level){

        if (NbLineToReach < LimitNbLine) {

            NbLineToReach = level * MultipleLine;
        }

        return NbLineToReach;
    }

    /*  Summary :   Augmente la vitesse de descente des pi�ces
    *   Param. :    Vitesse en cours � augmenter
    *   Returns:    Nouvelle vitesse
    *   Exception : -
    */
    public int SpeedUp(int SpeedToChange) {

        SpeedToChange += SpeedToAdd;
        delayBeforeGetDown = (int) 1/SpeedToChange;

        return SpeedToChange;
    }

    /*  Summary :   Ajoute les points au score actuel
    *   Param. :    Points � ajouter
    *   Returns:    Nothing
    *   Exception : -
    */
    public void AddPoint(int PointToAdd){
        Score += PointToAdd;
    }
}
