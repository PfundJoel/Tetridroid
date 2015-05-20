package pfund.tpi.tetridroid.Bricks;

import android.graphics.Color;

/**
 * Titre :       ShapeO
 * Description : Classe qui gere la pièce carrée du jeu
 * Créateur :    Joël Pfund
 * Créé le :     30.04.2015
 * Modifié le :  13.05.2015
 */
public class ShapeO extends Brick{

    public ShapeO(){
        super(5, 1, "Yellow");

        this.coordBrick[0][0] = 0;        this.coordBrick[0][1] = 0;
        this.coordBrick[1][0] = 0;        this.coordBrick[1][1] = -1;
        this.coordBrick[2][0] = 1;        this.coordBrick[2][1] = 0;
        this.coordBrick[3][0] = 1;        this.coordBrick[3][1] = -1;

    }

}
