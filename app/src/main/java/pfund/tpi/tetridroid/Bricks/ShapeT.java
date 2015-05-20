package pfund.tpi.tetridroid.Bricks;

import android.graphics.Color;

/**
 * Titre :       ShapeT
 * Description : Classe qui gere la pièce en forme de T du jeu
 * Créateur :    Joël Pfund
 * Créé le :     30.04.2015
 * Modifié le :  13.05.2015
 */
public class ShapeT extends Brick{

    public ShapeT(){
        super(5, 1, "Violet");

        this.coordBrick[0][0] = -1;        this.coordBrick[0][1] = 0;
        this.coordBrick[1][0] = 0;        this.coordBrick[1][1] = -1;
        this.coordBrick[2][0] = 0;        this.coordBrick[2][1] = 0;
        this.coordBrick[3][0] = 1;        this.coordBrick[3][1] = 0;

    }
}
