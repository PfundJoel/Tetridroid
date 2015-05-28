package pfund.tpi.tetridroid.Bricks;

import pfund.tpi.tetridroid.R;

/**
 * Titre :       ShapeO
 * Description : Class that manage the O shape
 * Créateur :    Joel Pfund
 * Créé le :     30.04.2015
 * Modifié le :  24.05.2015
 */
public class ShapeO extends Brick{

    public ShapeO(){

        this.coordBrick[0][0] = getCoordX() + 0;        this.coordBrick[0][1] = getCoordY() + 0;
        this.coordBrick[1][0] = getCoordX() + 0;        this.coordBrick[1][1] = getCoordY()  -1;
        this.coordBrick[2][0] = getCoordX() + 1;        this.coordBrick[2][1] = getCoordY() + 0;
        this.coordBrick[3][0] = getCoordX() + 1;        this.coordBrick[3][1] = getCoordY()  -1;

        brickBackground = R.drawable.bugdroidyellow;
    }
}
