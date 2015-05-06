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
    double delayBeforeGetDown = 1;
    private int Score = 0;


    public void setLevel(int level) {
        Level = level;
    }

    public void setNbLine(int nbLine) {
        NbLine = nbLine;
    }

    public void SetSpeed(double speed){
        Speed = speed;
        delayBeforeGetDown = 1/Speed;
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
    public double SpeedUp(double SpeedToChange) {

        SpeedToChange += SpeedToAdd;
        delayBeforeGetDown = 1/SpeedToChange;

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
