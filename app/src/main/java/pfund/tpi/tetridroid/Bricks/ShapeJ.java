package pfund.tpi.tetridroid.Bricks;

import android.graphics.Color;

/**
 * Titre :       ShapeJ
 * Description : Classe qui gere la pièce en forme de J du jeu
 * Créateur :    Joël Pfund
 * Créé le :     30.04.2015
 * Modifié le :  01.05.2015
 */
public class ShapeJ extends Brick {

    public ShapeJ(){
        super(5, 1, Color.BLUE);

        this.vectorBrick.add(new Positioning(0, -1));
        this.vectorBrick.add(new Positioning(0, 0));
        this.vectorBrick.add(new Positioning(1, 0));
        this.vectorBrick.add(new Positioning(2, 0));

    }
}
