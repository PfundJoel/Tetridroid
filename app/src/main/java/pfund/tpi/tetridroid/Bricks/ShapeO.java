package pfund.tpi.tetridroid.Bricks;

import android.graphics.Color;

/**
 * Titre :       ShapeO
 * Description : Classe qui gere la pièce carrée du jeu
 * Créateur :    Joël Pfund
 * Créé le :     30.04.2015
 * Modifié le :  01.05.2015
 */
public class ShapeO extends Brick{

    public ShapeO(){
        super(5, 1, Color.YELLOW);

        this.vectorBrick.add(new Positioning(0, 0));
        this.vectorBrick.add(new Positioning(0, -1));
        this.vectorBrick.add(new Positioning(1, 0));
        this.vectorBrick.add(new Positioning(1, -1));
    }

}
