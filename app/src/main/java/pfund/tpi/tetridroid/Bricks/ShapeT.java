package pfund.tpi.tetridroid.Bricks;

import pfund.tpi.tetridroid.R;

/**
 * Title :       ShapeT
 * Description : Classe qui gere la pièce en forme de T du jeu
 * Creator :     Joël Pfund
 * Created :     30.04.2015
 * Modified :    24.05.2015
 */
public abstract class ShapeT extends Brick{

    public ShapeT(){

        System.out.println("création de la pièce : " + getCoordX() +" "+ getCoordY());
        this.coordBrick[0][0] = getCoordX()  -1;        this.coordBrick[0][1] = getCoordY() + 0;
        this.coordBrick[1][0] = getCoordX() + 0;        this.coordBrick[1][1] = getCoordY()  -1;
        this.coordBrick[2][0] = getCoordX() + 0;        this.coordBrick[2][1] = getCoordY() + 0;
        this.coordBrick[3][0] = getCoordX() + 1;        this.coordBrick[3][1] = getCoordY() + 0;

        brickBackground = R.drawable.bugdroidviolet;
    }
}
